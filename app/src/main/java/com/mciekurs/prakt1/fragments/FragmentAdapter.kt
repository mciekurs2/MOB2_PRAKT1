package com.mciekurs.prakt1.fragments

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/** Nodrošina viewPager ar fragmentiem */
class FragmentAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){
    /** Piesaista fragmentus */
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> CameraFragment()
            else -> AudioFragment()
        }
    }

    /** Atgriež fragmentu skaitu (pagaidām statisks) */
    override fun getCount(): Int {
        return 2
    }

    /** Atgriež tabLayout nosaukumus */
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Kamera"
            else -> "Audio"
        }
    }

}