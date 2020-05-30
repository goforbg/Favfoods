package com.androar.favfoods.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.androar.favfoods.R
import com.androar.favfoods.data.model.Food
import com.androar.favfoods.ui.viewmodel.CommunicatorViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * FoodBottomSheet that displays Food Stuff.
 */
class FoodBottomSheet : BottomSheetDialogFragment() {

    lateinit var mRootView: View
    private lateinit var communicatorViewModel: CommunicatorViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(R.layout.fragment_food, container, false)
        initViewModel()
        initUI()
        return mRootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme);
    }

    private fun initViewModel() {
        communicatorViewModel = ViewModelProviders.of(activity!!)
            .get(CommunicatorViewModel::class.java)
    }

    private fun initUI() {
        communicatorViewModel.food.observe(this,
            Observer<Food> { food ->
                mRootView.findViewById<TextView>(R.id.food_title).text = food!!.name
                setRecipe(food)
                setPairsWith(food)
            })
    }

    /**
     * Ideally should do a POST function for this,
     * But due to the lack of time, doing it manually.
     * **/
    private fun setPairsWith(food: Food) {
        when (food.id) {
            1 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_burger1)
            2 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_burger2)
            3 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_burger3)
        }
    }

    private fun setRecipe(food: Food) {
        when (food.id) {
            1 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_burger1)
            2 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_burger2)
            3 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_burger3)
        }
    }

}
