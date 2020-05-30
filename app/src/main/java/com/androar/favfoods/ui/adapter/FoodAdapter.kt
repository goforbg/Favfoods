package com.androar.favfoods.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androar.favfoods.data.model.Food

class FoodAdapter(private val list: List<Food>) : RecyclerView.Adapter<FoodViewHolder>() {

    private var recyclerViewCallback: RecyclerViewCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FoodViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val movie: Food = list[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            this@FoodAdapter.recyclerViewCallback?.onRecycleViewItemClick(list[position], position)
        }
    }

    override fun getItemCount(): Int = list.size

    interface RecyclerViewCallback {
        fun onRecycleViewItemClick(food: Food, position: Int)
    }

    public fun setOnCallbackListener(recyclerViewCallback: RecyclerViewCallback) {
        this.recyclerViewCallback = recyclerViewCallback
    }
}
