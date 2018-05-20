package com.mciekurs.prakt1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.single_audio_layout.view.*

class AudioAdapter(var audio: ArrayList<AudioInfo>): RecyclerView.Adapter<CostumeAudioHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CostumeAudioHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_audio_layout, parent, false)
        return CostumeAudioHolder(itemView)
    }

    override fun getItemCount(): Int {
        return audio.size
    }

    override fun onBindViewHolder(holder: CostumeAudioHolder, position: Int) {
        val audio = audio[position]

        holder.view.textView_audioTittle.text = audio.title
    }

}

class CostumeAudioHolder(val view: View): RecyclerView.ViewHolder(view)