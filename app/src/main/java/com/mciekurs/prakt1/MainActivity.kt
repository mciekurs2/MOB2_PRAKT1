package com.mciekurs.prakt1

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.mciekurs.prakt1.fragments.FragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = FragmentAdapter(supportFragmentManager)
        pager.adapter = adapter

        tabs_main.setupWithViewPager(pager)

        /*Firebase Analytics*/
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "launched application")
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

    }

}

class PhotoInfo(var title: String, var bitmap: Bitmap)

class AudioInfo(var title: String)
