package com.androar.favfoods.ui.view.fragment

import android.os.Bundle
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
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

/**
 * FoodBottomSheet that displays Food Stuff.
 */
class FoodBottomSheet : BottomSheetDialogFragment() {

    lateinit var mRootView: View
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
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme);
    }

    private fun initViewModel() {
        communicatorViewModel = ViewModelProviders.of(activity!!)
            .get(CommunicatorViewModel::class.java)
    }

    private fun initUI() {
        communicatorViewModel.food.observe(this,
            Observer<Food> { food ->
                mRootView.findViewById<TextView>(R.id.food_title).text = food!!.name
                setRecipe(food)
                setPairsWith(food)
                playVideo(food.yid)
            })
    }

    /**
     * Ideally should do a POST function for this,
     * But due to the lack of time, doing it manually.
     * **/
    private fun setPairsWith(food: Food) {
        when (food.id) {
            1 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_burger1)
            2 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_burger2)
            3 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_burger3)
            4 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_pizza1)
            5 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_pizza2)
            6 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_pizza3)
            7 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_rolls1)
            8 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_rolls2)
            9 -> mRootView.findViewById<TextView>(R.id.food_pairs_with).text =
                getString(R.string.pair_rolls3)
        }
    }

    private fun setRecipe(food: Food) {
        when (food.id) {
            1 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_burger1)
            2 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_burger2)
            3 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_burger3)
            4 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_pizza1)
            5 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_pizza2)
            6 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_pizza3)
            7 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_rolls1)
            8 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_rolls2)
            9 -> mRootView.findViewById<TextView>(R.id.food_recipe).text =
                getString(R.string.recipe_pizza3)
        }
    }

    private fun playVideo(id: String) {
        val youTubePlayerView = mRootView.findViewById(R.id.youtube_player_view) as YouTubePlayerView
        lifecycle.addObserver(youTubePlayerView)
        youTubePlayerView.addYouTubePlayerListener(object: AbstractYouTubePlayerListener()  {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.loadVideo(id, 0F)
            }
        })
    }

}
