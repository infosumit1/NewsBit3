package com.example.android.newsbit.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager.widget.ViewPager
import com.example.android.newsbit.R
import com.google.android.material.tabs.TabLayout
import com.example.android.newsbit.models.OnBoardingScreens
import com.example.android.newsbit.adapters.ViewPagerAdapter

class OnBoardScreensActivity : AppCompatActivity() {

    var viewPagerAdapter: ViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager: ViewPager? = null
    var nextText: TextView? = null
    var previousText: TextView? = null
    var position = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        if (restorePrefData()) {
            val i = Intent(applicationContext, SignInActivity::class.java)
            startActivity(i)
            finish()
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setTheme(R.style.Theme_NewsBit)
        setContentView(R.layout.activity_on_board_screens)

        tabLayout = findViewById(R.id.tab_layout)
        nextText = findViewById(R.id.next)
        previousText = findViewById(R.id.previous)

        val onBoardingScreens: MutableList<OnBoardingScreens> = ArrayList()
        onBoardingScreens.add(
            OnBoardingScreens(
                "Trending",
                "Get latest update and news in Realtime",
                R.drawable.trend
            )
        )
        onBoardingScreens.add(
            OnBoardingScreens(
                "International",
                "International News at just one click to your dashboard",
                R.drawable.news
            )
        )
        onBoardingScreens.add(
            OnBoardingScreens(
                "Covid-19",
                "Daily COVID-19 news and stats in your country",
                R.drawable.corona
            )
        )
        onBoardingScreens.add(
            OnBoardingScreens(
                "Search",
                "Get latest update and news in Realtime",
                R.drawable.search
            )
        )
        onBoardingScreens.add(
            OnBoardingScreens(
                "Bookmark",
                "Get latest update and news in Realtime",
                R.drawable.bookmark
            )
        )
        setOnBoardingViewPagerAdapter(onBoardingScreens)
        position = onBoardingViewPager!!.currentItem

        nextText?.setOnClickListener {
            if (position < onBoardingScreens.size) {
                position++
                onBoardingViewPager!!.currentItem = position
            }
            if (position == onBoardingScreens.size) {
                savePrefData()
                val i = Intent(applicationContext, SignInActivity::class.java)
                startActivity(i)
            }
        }
        previousText?.setOnClickListener {
            if (position == onBoardingScreens.size || position>0) {
                position--
                onBoardingViewPager!!.currentItem = position
            }
        }

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if (tab.position == onBoardingScreens.size - 1) {
                    nextText!!.text = "Finish"
                } else {
                    nextText!!.text = "Next"
                }
                if(tabLayout!!.getTabAt(position) == tabLayout!!.getTabAt(0)) {previousText!!.text = ""}
                else{ previousText!!.text = "Previous"}
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingScreens: List<OnBoardingScreens>) {

        onBoardingViewPager = findViewById(R.id.slideViewPager);
        viewPagerAdapter = ViewPagerAdapter(this, onBoardingScreens)
        onBoardingViewPager!!.adapter = viewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)

    }

    private fun savePrefData() {

        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
//        editor.putString("theme","default")
        editor.apply()
    }

    private fun restorePrefData(): Boolean {
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)

    }
}
