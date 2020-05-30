package com.androar.favfoods.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androar.favfoods.data.model.Food

class CommunicatorViewModel : ViewModel() {

    val food = MutableLiveData<Food>()

    fun setFood(food:Food){
        this.food.value = food
    }

}