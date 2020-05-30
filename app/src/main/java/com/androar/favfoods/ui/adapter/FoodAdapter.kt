package com.androar.favfoods.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androar.favfoods.data.model.Food

class FoodAdapter(private val list: List<Food>)
    : RecyclerView.Adapter<FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FoodViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val movie: Food = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size

}
