package com.androar.favfoods.ui.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.androar.favfoods.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


/**
 * An about class of the owner of coder :)
 */
class AboutFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var mRootView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView =  inflater.inflate(R.layout.fragment_about, container, false)
        setOnClickListeners()
        return mRootView
    }

    private fun setOnClickListeners() {
        mRootView.findViewById<ImageView>(R.id.linkedin).setOnClickListener(this)
        mRootView.findViewById<ImageView>(R.id.website).setOnClickListener(this)
        mRootView.findViewById<ImageView>(R.id.github).setOnClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme);
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.website -> {
                val url = "http://www.goforbg.com"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
            R.id.linkedin -> {
                val url = "http://www.linkedin.com/in/goforbg"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
            R.id.github -> {
                val url = "http://www.github.com/goforbg"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
        }
    }

}
