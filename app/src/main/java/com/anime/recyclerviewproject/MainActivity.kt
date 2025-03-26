package com.anime.recyclerviewproject

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anime.recyclerviewproject.data.Student
import com.anime.recyclerviewproject.helpers.StudentAdapter

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val students = listOf(
            Student(1, "Luffy", "D", "Mag-iba", R.drawable.luffy),
            Student(2, "Koe", "-", "Langot", R.drawable.eren),
        )

        recyclerView.adapter = StudentAdapter(students)
    }
}