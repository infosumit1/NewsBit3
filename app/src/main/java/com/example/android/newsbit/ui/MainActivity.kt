package com.example.android.newsbit.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android.newsbit.R
import com.example.android.newsbit.db.ArticleDatabase
import com.example.android.newsbit.repository.NewsRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    private lateinit var mAuth: FirebaseAuth
    private lateinit var currentUser: FirebaseUser
    private lateinit var googleSignInClient: GoogleSignInClient
    private val TAG = "Main Activity"
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var phonenumber: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        mAuth = FirebaseAuth.getInstance()
        if (mAuth.currentUser != null) {
            currentUser = mAuth.currentUser!!
        }

        //CHECK IF THE USER SIGNED WITH PHONE NUMBER OR NOT

        if (mAuth.currentUser == null) {
//            Log.e("PhoneNumber", "Signed as" + sharedPreferences.getString("phonenumber", null))
            val i = Intent(applicationContext, SignInActivity::class.java)
            startActivity(i)
            finish()
        } else {
            Log.e(
                "CurrentUser",
                "Signed as" + currentUser.phoneNumber + "  " + currentUser.displayName
            )
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

//        Log.e("THEME NO RESTORE", themeName)


        /*
        The next 3 lines(where we are instantiating viewModel) work only
        if we write them before setContentView(R.layout.activity_main).
        It has something to relate with lifecycle. I don't understand it fully yet
        because in phillip lackner course it works fine if we write these lines after
        setContentView(R.layout.activity_main) line
         */


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        setTheme(R.style.Theme_NewsBit)
        setContentView(R.layout.activity_main)

        if (this::viewModel.isInitialized) {
//            Log.e(TAG, " Ho to raha hai yaar ")
        } else {
//            Log.e(TAG, "Abhi nahi yaar ")
        }

        val navController = findNavController(R.id.newsNavHostFragment)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.articleFragment -> bottomNavigationView.visibility = View.GONE
                else -> bottomNavigationView.visibility = View.VISIBLE
            }
        }

        profileBtn.setOnClickListener {
            navController.navigate(R.id.settingsFragment)
        }
    }
    fun logOut(){
        Toast.makeText(this, "Logged Out Successfully!!", Toast.LENGTH_LONG).show()
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}