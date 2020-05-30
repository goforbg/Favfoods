package com.androar.favfoods.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

import com.androar.favfoods.R

/**
 * Onboarding Fragment is used when the user arrives to the app for the first time.
 */
class OnboardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_onboarding, container, false)
        startAnimations(rootView)
        return rootView
    }

    private fun startAnimations (rootView: View) {
        val animFadeIn = AnimationUtils.loadAnimation(context!!, R.anim.fade_in);
        val animFadeInSlow = AnimationUtils.loadAnimation(context!!, R.anim.fade_in_slow);
        rootView.findViewById<TextView>(R.id.onboarding_hi).startAnimation(animFadeInSlow)
        rootView.findViewById<TextView>(R.id.onboarding_start).startAnimation(animFadeInSlow)
        rootView.findViewById<ImageView>(R.id.onboarding_image).startAnimation(animFadeIn)
    }

}
