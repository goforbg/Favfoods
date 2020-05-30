package com.androar.favfoods.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.androar.favfoods.R
import com.androar.favfoods.data.api.ApiHelper
import com.androar.favfoods.data.api.RetrofitBuilder
import com.androar.favfoods.data.model.Food
import com.androar.favfoods.ui.adapter.FoodAdapter
import com.androar.favfoods.ui.view.activity.MainActivity
import com.androar.favfoods.ui.viewmodel.CommunicatorViewModel
import com.androar.favfoods.ui.viewmodel.HomeViewModel
import com.androar.favfoods.ui.viewmodel.ViewModelFactory
import com.androar.favfoods.utils.Status

/**
 * Home Fragment for Food Details
 */
class HomeFragment : Fragment(), View.OnClickListener, FoodAdapter.RecyclerViewCallback {

    private lateinit var rootView : View
    private lateinit var viewModel: HomeViewModel
    private lateinit var communicatorViewModel: CommunicatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        initUI()
        initViewModel()
        return rootView
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))).
            get(HomeViewModel::class.java)

        communicatorViewModel= ViewModelProviders.of(activity!!)
            .get(CommunicatorViewModel::class.java)
    }

    private fun OGpopulateBurgerList() {
        viewModel.getBurgers().observe(this, Observer {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                                foods -> setAdapter(foods)
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(context!!, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }
        })
    }

        private fun initUI() {
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
        val adapter = FoodAdapter(foods)
        rootView.findViewById<RecyclerView>(R.id.rv_food).adapter = adapter
        adapter.setOnCallbackListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.home_menu_burger -> {
                unselectOtherViews()
                p0.isSelected = true
                OGpopulateBurgerList()
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

    override fun onRecycleViewItemClick(food: Food, position: Int) {
        communicatorViewModel.setFood(food)
        val foodBottomSheet = FoodBottomSheet()
        foodBottomSheet.show(activity!!.supportFragmentManager, "FoodBottomSheet")
    }

}
