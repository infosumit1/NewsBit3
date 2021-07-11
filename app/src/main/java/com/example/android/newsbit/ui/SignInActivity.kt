package com.example.android.newsbit.ui

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.setPadding
import com.example.android.newsbit.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*
import java.util.concurrent.TimeUnit

class SignInActivity : AppCompatActivity() {

    companion object {
        private const val RC_SIGN_IN = 120
    }

    lateinit var sharedPreferences: SharedPreferences
    private var codeSent: String = ""
    private lateinit var credential: PhoneAuthCredential

    //    private lateinit var tokenID: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private var phoneNo: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val controller = window.insetsController

            if (controller != null) {
                controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        setTheme(R.style.Theme_NewsBit)
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (restorePrefData()) {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        setContentView(R.layout.activity_sign_in)

        //FIREBASE USER CHECK AUTHORIZATION
        mAuth = Firebase.auth
        val user = mAuth.currentUser

        mAuth.addAuthStateListener { firebaseAuth ->
            if (!(firebaseAuth.currentUser == null || !firebaseAuth.currentUser!!.isEmailVerified)) {
                val dashboardIntent = Intent(this, MainActivity::class.java)
                startActivity(dashboardIntent)
                finish()
            }
        }

//        ccp.registerPhoneNumberTextView(otp_input)
//        ccp.showFullName(true)
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)


        //GOOGLE AUTHENTICATION BUTTON CLICK LISTENER
        google_login_btn.setOnClickListener {
            signIn()
        }

        //OTP SEND BUTTON CLICK LISTENER
        verifyBtn.setOnClickListener { signwithPhoneNumber() }

        //OTP VERIFICATION BUTTON CLICK LISTENER
        verifyOTPBtn.setOnClickListener {

            var code = otp_txtNum.text.toString().trim()
            try {
                if (code.isEmpty() || code.isNullOrBlank()) {
                    otp_txtNum.setError("Enter 6 Digit OTP")
                } else if (!(code.length == 6)) {
                    otp_txtNum.setError("Invalid OTP")
                } else {
                    credential = PhoneAuthProvider.getCredential(codeSent!!, code)
                    signInWithPhoneAuthCredential(credential)
                }
            } catch (e: Exception) {
                Log.e("VerifyException", e.toString())
            }

        }

        //RESEND BUTTON CLICK LISTENER
        otp_resend.setOnClickListener {
            startOTPTimer()
            signwithPhoneNumber()
        }

        // Callback function for Phone Auth

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // verification completed
                //OTP VERIFICATION
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked if an invalid request for verification is made,
                // for instance if the the phone number format is invalid.
                Toast.makeText(applicationContext, "Login Failed!!", Toast.LENGTH_SHORT).show()

                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    Toast.makeText(applicationContext, "INVALID PHONE NUMBER", Toast.LENGTH_SHORT)
                        .show()
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    Toast.makeText(applicationContext, "NO OF REQUEST EXCEEDED", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            override fun onCodeSent(
                verificationId: String,
                p1: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
//                showSnackbar("onCodeSent:" + verificationId)
                // Save verification ID and resending token so we can use them later
                codeSent = verificationId
                Toast.makeText(applicationContext, "OTP SENT!!", Toast.LENGTH_SHORT).show()
                otpSentEnableView()
                phone_num.clearFocus()
                otp_textView.requestFocus()
//                tokenID = token!!
                // Disable text Box... and the submit button
            }

            override fun onCodeAutoRetrievalTimeOut(verificationId: String) {
                // called when the timeout duration has passed without triggering onVerificationCompleted
                super.onCodeAutoRetrievalTimeOut(verificationId)
            }
        }

    }

    private fun otpSentEnableView() {
        otp_msg.setText("OTP has been sent to " + phoneNo)
        otp_msg.setTypeface(Typeface.DEFAULT_BOLD)
        phoneNum.isEnabled = false
        verifyBtn.visibility = View.GONE
        otp_msg.visibility = View.VISIBLE
        verifyOTPBtn.visibility = View.VISIBLE
        otp_resend.visibility = View.VISIBLE
        otp_textView.visibility = View.VISIBLE
        startOTPTimer()
    }

    private fun checkValidPhnNumber(phnNumber: String): Boolean {
        var phoneNumber = phnNumber
        if (!(phoneNumber.isEmpty() || phoneNumber == "" || phoneNumber.length != 10 || phoneNumber.isNullOrBlank())) {
            phone_num.error = ""
            return true
        }
        Toast.makeText(this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show()
        phone_num.setError("Enter Valid Phone Number")
        phone_num.requestFocus()
        return false
    }

    private fun signwithPhoneNumber() {
        phoneNo = phoneNum.text.toString().trim()
        if (checkValidPhnNumber(phoneNo)) {
            var number = "+91" + phoneNo.trim()
            intent.putExtra("phoneNo", number)
            sendVerificationcode(number)
        }
    }

    private fun sendVerificationcode(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(mAuth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(2, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = mAuth.currentUser
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }

    private fun startOTPTimer() {
        otp_resend.isClickable = false
        otp_resend.linksClickable = false
        val timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
//                val minutes = millisUntilFinished / 1000 / 60
//                val seconds = millisUntilFinished / 1000 % 60

                val hms = String.format(
                    "%02d:%02d",
                    (TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                            TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(
                                    millisUntilFinished
                                )
                            )),
                    (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    ))
                )
                otp_resend.text = "Didn't get OTP, Try Again in " + hms
            }

            override fun onFinish() {
                otp_resend.isClickable = true
                otp_resend.linksClickable = true
                otp_resend.text = "Resend OTP"
                otp_resend.setTypeface(otp_resend.getTypeface(), Typeface.BOLD);
                otp_resend.setTextColor(R.attr.colorPrimaryVariant)
                otp_resend.setPadding(20)
                otp_resend.isEnabled = true
                phone_num.isEnabled = true
                cancel()
            }
        }
        timer.start()
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(
                        applicationContext,
                        "Sign In Successful!!",
                        Toast.LENGTH_LONG
                    ).show()
                    var intent = Intent(applicationContext, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    intent.putExtra("phone_num", phoneNo)
                    savePrefData()
                    startActivity(intent)
                    finish()
                    val user = task.result?.user
                    if (user != null) {
                        mAuth.updateCurrentUser(user)
                    }
                } else {
                    // Sign in failed, display a message and update the UI
//                        Toast.makeText(applicationContext,"Incorrect OTP, Try Again...",Toast.LENGTH_LONG).show()
                    otp_textView.setError("Incorrect OTP!!")
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }

    private fun restorePrefData(): Boolean {
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("verified", false)
    }

    private fun savePrefData() {

        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putString("phonenumber", phoneNo)
        editor.putBoolean("verified", true)
        editor.apply()
    }

}

