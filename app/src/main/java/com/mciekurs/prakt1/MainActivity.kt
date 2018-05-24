package com.mciekurs.prakt1

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.mciekurs.prakt1.fragments.FragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Izsauc adatper un to piesaista viewPager */
        val adapter = FragmentAdapter(supportFragmentManager)
        pager.adapter = adapter

        /** Piesaista tabLayout nosaukumus */
        tabs_main.setupWithViewPager(pager)

        /** Firebase Analytics */
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "launched application")
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

        /** Izveido permsion sarakstu */
        val permissions = arrayOf(Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        /** Padod izveidotus permisions, ja tie nav atļauti */
        if (!hasPermissions(this, *permissions)) {
            ActivityCompat.requestPermissions(this, permissions, 1)
        }


    }


    /** Funkcija, kas pārbauda, vai ir permisions */
    private fun hasPermissions(context: Context?, vararg permissions: String): Boolean {
        if (context != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

}

/** Glabājas foto un audio mainīgie */
class PhotoInfo(var title: String, var bitmap: Bitmap)

class AudioInfo(var title: String)
