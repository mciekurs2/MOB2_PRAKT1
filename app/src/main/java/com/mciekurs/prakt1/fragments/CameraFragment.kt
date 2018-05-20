package com.mciekurs.prakt1.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mciekurs.prakt1.PhotoInfo
import com.mciekurs.prakt1.R
import com.mciekurs.prakt1.ImageAdapter
import kotlinx.android.synthetic.main.fragment_camera.*
import android.text.Editable
import android.text.TextWatcher



class CameraFragment : Fragment() {
    //creates empty list of objects referring to PhotoInfo
    private var list = arrayListOf<PhotoInfo>()
    //global value, because need to refresh it after image has been taken
    private val adapter = ImageAdapter(list)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText_name.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                button_camera.isEnabled = !s.toString().trim().isEmpty()
            }


        })

        val manager = LinearLayoutManager(view.context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        rw_camera.layoutManager = manager
        rw_camera.adapter = adapter


        button_camera.setOnClickListener {
            startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), 0)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val extras = data?.extras
        if (extras?.get("data") != null){
            val bitmap = extras.get("data") as Bitmap
            imageView_cameraPreview.setImageBitmap(bitmap)

            list.add(PhotoInfo(editText_name.text.toString(), bitmap))
            adapter.notifyDataSetChanged()
        }

    }


}
