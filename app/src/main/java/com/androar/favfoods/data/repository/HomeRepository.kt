package com.androar.favfoods.data.repository

import com.androar.favfoods.data.api.ApiHelper

class HomeRepository(private val apiHelper: ApiHelper) {

    suspend fun getPizzas() = apiHelper.getPizzas()

    suspend fun getBurgers() = apiHelper.getBurgers()

    suspend fun getRolls() = apiHelper.getRolls()
}
