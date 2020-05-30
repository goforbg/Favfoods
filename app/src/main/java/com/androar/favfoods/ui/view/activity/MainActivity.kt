package com.androar.favfoods.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.androar.favfoods.R
import com.androar.favfoods.ui.view.fragment.HomeFragment
import com.androar.favfoods.ui.view.fragment.OnboardingFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        val prefs = this.getSharedPreferences(getString(R.string.PREFS_FILENAME), 0)
        val userOnboarded = prefs!!.getBoolean(getString(R.string.USER_ONBOARDED), false)
        if (!userOnboarded) {
            showFragment(OnboardingFragment())
            prefs.edit().putBoolean(getString(R.string.USER_ONBOARDED), true).apply()
        }
        else {
            showFragment(HomeFragment())
        }
    }

    private fun showFragment(newFragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container_main, newFragment)
                .commit()
    }

}
