package com.mciekurs.prakt1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.single_audio_layout.view.*

/** Nodrošina audioFragment recyclerView funkcionalitāti */
class AudioAdapter(var audio: ArrayList<AudioInfo>): RecyclerView.Adapter<CostumeAudioHolder>(){
    /** Papildina recyclerView ar single_audio_layout katram jaunam elementam */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CostumeAudioHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_audio_layout, parent, false)
        return CostumeAudioHolder(itemView)
    }

    /** Atrgirež  AudioInfo arrayList izmēru*/
    override fun getItemCount(): Int {
        return audio.size
    }

    /** Papildina view ar audioTittle */
    override fun onBindViewHolder(holder: CostumeAudioHolder, position: Int) {
        val audio = audio[position]

        holder.view.textView_audioTittle.text = audio.title
    }

}

/** Nodrošina costumeView, vēlāk var piesaistīt individuālus elementus */
class CostumeAudioHolder(val view: View): RecyclerView.ViewHolder(view)