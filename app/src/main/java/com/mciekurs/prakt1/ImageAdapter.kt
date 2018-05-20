package com.mciekurs.prakt1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.single_camera_layout.view.*

class ImageAdapter(private val images: ArrayList<PhotoInfo>): RecyclerView.Adapter<CostumeViewHolder>(){
    override fun onBindViewHolder(holder: CostumeViewHolder, position: Int) {
        val images = images[position]

        holder.view.textView_camera.text = images.title
        holder.view.imageView_camera.setImageBitmap(images.bitmap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CostumeViewHolder{
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_camera_layout, parent, false)
        return CostumeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return images.size
    }


}

class CostumeViewHolder(val view: View): RecyclerView.ViewHolder(view)
/*Here you can add listener to item presses*/