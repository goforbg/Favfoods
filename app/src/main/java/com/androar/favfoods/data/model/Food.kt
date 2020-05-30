package com.androar.favfoods.data.model

import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("name")
    val name: String,
    @SerializedName("thumbnail")
    val thumbnail: String)
