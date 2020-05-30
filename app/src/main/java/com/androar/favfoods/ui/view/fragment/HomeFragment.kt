package com.androar.favfoods.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.androar.favfoods.R
import com.androar.favfoods.data.model.Food
import com.androar.favfoods.ui.adapter.FoodAdapter

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

    private fun populateBurgerList() {
        val foodList: ArrayList<Food> = arrayListOf()
        foodList.add(Food("Beef Burger",""))
        foodList.add(Food("Sappa Mame",""))
        foodList.add(Food("Beef Burger",""))
        setAdapter(foodList)
    }

    private fun populatePizzaList() {
        val foodList: ArrayList<Food> = arrayListOf()
        foodList.add(Food("Chukka Pizza",""))
        foodList.add(Food("Pizza Mama",""))
        foodList.add(Food("Bulp Pizza",""))
        setAdapter(foodList)
    }

    private fun populateRollsList() {
        val foodList: ArrayList<Food> = arrayListOf()
        foodList.add(Food("Rolls 1",""))
        foodList.add(Food("Rolls 2",""))
        foodList.add(Food("3 Rolls",""))
        setAdapter(foodList)
    }


    private fun setAdapter(foods: ArrayList<Food>) {
        rootView.findViewById<RecyclerView>(R.id.rv_food).adapter = FoodAdapter(foods)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.home_menu_burger -> {
                unselectOtherViews()
                p0.isSelected = true
                populateBurgerList()
            }
            R.id.home_menu_pizza -> {
                unselectOtherViews()
                p0.isSelected = true
                populatePizzaList()
            }
            R.id.home_menu_rolls -> {
                unselectOtherViews()
                p0.isSelected = true
                populateRollsList()
            }
        }
    }

}
