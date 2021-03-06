package com.mciekurs.prakt1.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mciekurs.prakt1.AudioAdapter
import com.mciekurs.prakt1.AudioInfo
import com.mciekurs.prakt1.R
import com.mciekurs.prakt1.RecordingActivity
import kotlinx.android.synthetic.main.fragment_audio.*


class AudioFragment : Fragment() {

    /** Tas pats kas public static */
    companion object {
        val audioList = arrayListOf<AudioInfo>()
        val adapter = AudioAdapter(audioList)
    }

    /** papildina viewPager ar fragment_audio */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_audio, container, false)
    }

    /** Nepieciešams, lai izveidotu setOnClickListener, savādak izmetīs null paziņojumu*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** Pāriet uz recordAudio activity un pārnes fileName */
        button_audio.setOnClickListener{
            val intent = Intent(view.context, RecordingActivity::class.java)
            intent.putExtra("fileName", editText_audioName.text.toString())
            startActivity(intent)
        }

        /** piesaista recyclerView adapteri */
        val manager = LinearLayoutManager(view.context)
        manager.orientation = LinearLayoutManager.VERTICAL
        rw_audio.layoutManager = manager
        rw_audio.adapter = adapter



    }




}
