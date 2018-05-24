package com.mciekurs.prakt1

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.mciekurs.prakt1.fragments.AudioFragment.Companion.adapter
import com.mciekurs.prakt1.fragments.AudioFragment.Companion.audioList
import kotlinx.android.synthetic.main.activity_recording.*


class RecordingActivity : AppCompatActivity() {

    /** Izveido globāt path */
    private var outputFile: String = Environment.getExternalStorageDirectory().absolutePath
    lateinit var audioRecorder: MediaRecorder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recording)

        /** dabū no AudioFragment fileName un piesaista no path galā*/
        val fileName = intent.getStringExtra("fileName")
        outputFile += "/$fileName.3gp"

        /** Uzstāda faila formātus un sāk audio ierakstīšanu */
        button_record.setOnClickListener {
            audioRecorder = MediaRecorder()

            audioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
            audioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            audioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
            audioRecorder.setOutputFile(outputFile)

            audioRecorder.prepare()
            audioRecorder.start()
            button_record.isEnabled = false
            button_stop.isEnabled = true
            Toast.makeText(applicationContext, "Recording started", Toast.LENGTH_SHORT).show()
        }

        /** Pārtrauc faila ierakstīšanu */
        button_stop.setOnClickListener {
            audioRecorder.stop()
            audioRecorder.release()
            //audioRecorder = null
            button_record.isEnabled = true
            button_stop.isEnabled = false
            button_play.isEnabled = true
            button_save.isEnabled = true
            Toast.makeText(applicationContext, "Recording stopped", Toast.LENGTH_SHORT).show()
        }

        /** Atskaņo ierakstīto failu */
        button_play.setOnClickListener {
            val mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(outputFile)
            mediaPlayer.prepare()
            mediaPlayer.start()
            Toast.makeText(applicationContext, "Playing recorded audio", Toast.LENGTH_SHORT).show()
        }

        /** Saglabā ierakstu sarkastā */
        button_save.setOnClickListener {
            audioList.add(AudioInfo(fileName))
            adapter.notifyDataSetChanged()
            //pagaidam tikai aizver Activity
            finish()
        }

    }


}
