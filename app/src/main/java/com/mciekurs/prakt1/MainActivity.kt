package com.mciekurs.prakt1

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mciekurs.prakt1.fragments.FragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = FragmentAdapter(supportFragmentManager)
        pager.adapter = adapter

        tabs_main.setupWithViewPager(pager)

    }

}

class PhotoInfo(var title: String, var bitmap: Bitmap)

class AudioInfo(var title: String)
