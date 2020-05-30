package com.androar.favfoods.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
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
import org.w3c.dom.Text

/**
 * FoodBottomSheet that displays Food Stuff.
 */
class FoodBottomSheet : BottomSheetDialogFragment() {

    lateinit var mRootView : View
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
        setStyle(STYLE_NORMAL, R.style. AppBottomSheetDialogTheme);
    }

    private fun initViewModel() {
        communicatorViewModel= ViewModelProviders.of(activity!!)
            .get(CommunicatorViewModel::class.java)
    }

    private fun initUI() {
        communicatorViewModel.food.observe(this,
            Observer<Food> { food ->
                mRootView.findViewById<TextView>(R.id.food_title).text =
                    food!!.name
            })

    }

}
