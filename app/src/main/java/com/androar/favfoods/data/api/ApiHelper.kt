package com.androar.favfoods.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPizzas() = apiService.getPizzas()

    suspend fun getBurgers() = apiService.getBurgers()

    suspend fun getRolls() = apiService.getRolls()

}
