package com.example.android.newsbit.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.android.newsbit.R
import com.example.android.newsbit.ui.SignInActivity
import com.example.android.newsbit.ui.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var currentUser: FirebaseUser
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var mainActivity: MainActivity
    private var theme : Int = 0

    lateinit var switchButton: SwitchCompat

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = activity as MainActivity
        mAuth = FirebaseAuth.getInstance()

        switchButton=view.findViewById(R.id.switch1)

        switchButton.setOnCheckedChangeListener({ _ , isChecked ->
            if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        })

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        if (mAuth.currentUser != null) {
            currentUser = mAuth.currentUser!!

            if (currentUser.photoUrl != null) {
                Glide.with(requireContext())
                    .load(currentUser.photoUrl)
                    .into(user_dp)
            } else {
                Glide.with(requireContext())
                    .load(R.drawable.newsbit)
                    .into(user_dp)
            }
            if (!currentUser.displayName.isNullOrBlank() && !currentUser.displayName.isNullOrEmpty()) {
                user_name.text = currentUser.displayName
            } else if (!currentUser.phoneNumber.isNullOrBlank() && !currentUser.phoneNumber.isNullOrEmpty()) {
                user_name.text =
                    currentUser.phoneNumber!!.subSequence(3, currentUser.phoneNumber!!.length)
            }
            if (!currentUser.email.isNullOrBlank() && !currentUser.email.isNullOrEmpty()) {
                user_email.text = currentUser.email
            } else {
                user_email.visibility = View.GONE
            }
        }

        logout_btn.setOnClickListener { signOut() }

//        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//
//            when (checkedId) {
//                R.id.defaultBtn -> {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//                }
//                R.id.dayBtn -> {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                }
//                R.id.nightBtn -> {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                }
//            }
//        }

//        day_btn.setOnClickListener {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
//        night_btn.setOnClickListener {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        }
    }

    private fun signOut() {
        // Firebase sign out
        mAuth.signOut()
        // Google sign out
        if (googleSignInClient != null) {
            googleSignInClient.signOut()
        }
        mainActivity.logOut()
    }


//    private fun getPreference(): String
//    {
//        val sharedPreferences = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
//        return sharedPreferences.getString("theme", "default")!!
//    }
}