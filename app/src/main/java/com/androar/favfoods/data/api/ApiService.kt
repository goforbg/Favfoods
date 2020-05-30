package com.androar.favfoods.data.api
import com.androar.favfoods.data.model.Food
import retrofit2.http.GET

interface ApiService {

    @GET("burgers.json")
    suspend fun getBurgers(): ArrayList<Food>

    @GET("pizzas.json")
    suspend fun getPizzas(): ArrayList<Food>

    @GET("rolls.json")
    suspend fun getRolls(): ArrayList<Food>

}
