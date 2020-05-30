package com.androar.favfoods.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.androar.favfoods.R

/**
 * Home Fragment for Food Details
 */
class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var rootView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        initUI()
        return rootView
    }

    fun initUI() {
        val animFadeIn = AnimationUtils.loadAnimation(context!!, R.anim.fade_in);
        rootView.findViewById<ConstraintLayout>(R.id.container_home).startAnimation(animFadeIn)
        rootView.findViewById<ImageView>(R.id.home_menu_burger).setOnClickListener(this)
        rootView.findViewById<ImageView>(R.id.home_menu_pizza).setOnClickListener(this)
        rootView.findViewById<ImageView>(R.id.home_menu_rolls).setOnClickListener(this)
    }

    private fun unselectOtherViews() {
        rootView.findViewById<ImageView>(R.id.home_menu_pizza).isSelected = false
        rootView.findViewById<ImageView>(R.id.home_menu_rolls).isSelected = false
        rootView.findViewById<ImageView>(R.id.home_menu_burger).isSelected = false
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.home_menu_burger -> {
                unselectOtherViews()
                p0.isSelected = true
            }
            R.id.home_menu_pizza -> {
                unselectOtherViews()
                p0.isSelected = true
            }
            R.id.home_menu_rolls -> {
                unselectOtherViews()
                p0.isSelected = true
            }
        }
    }

}
