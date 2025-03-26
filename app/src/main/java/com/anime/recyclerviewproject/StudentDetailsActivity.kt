package com.anime.recyclerviewproject

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class StudentDetailsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val name = findViewById<TextView>(R.id.student_name)
        val photo = findViewById<ImageView>(R.id.student_photo)

        intent?.let {
            val fName = it.getStringExtra("fName") ?: ""
            val mName = it.getStringExtra("mName") ?: ""
            val lName = it.getStringExtra("lName") ?: ""
            val fullName = "$fName $mName $lName"
            name.text = fullName

            val photoRes = it.getIntExtra("photo", R.drawable.luffy)
            photo.setImageResource(photoRes)
        }
    }
}