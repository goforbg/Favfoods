package com.androar.favfoods.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androar.favfoods.R
import com.androar.favfoods.data.model.Food
import com.bumptech.glide.Glide


class FoodViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.food_item, parent, false)) {

    private var mFoodName: TextView? = null
    private var mFoodImage: ImageView? = null


    init {
        mFoodName = itemView.findViewById(R.id.food_name)
        mFoodImage = itemView.findViewById(R.id.food_image)
    }

    fun bind(food: Food) {
        mFoodName?.text = food.name
        Glide
            .with(itemView.context)
            .load(food.thumbnail)
            .placeholder(R.drawable.progress_animation)
            .into(mFoodImage!!)
    }

    

}