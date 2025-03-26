package com.anime.recyclerviewproject

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anime.recyclerviewproject.data.Student
import com.anime.recyclerviewproject.helpers.StudentAdapter

class MainActivity : Activity() {
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var students: MutableList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        students = mutableListOf(
            Student(1, "Luffy", "D", "Mag-iba", R.drawable.luffy),
            Student(2, "Koe", "-", "Langot", R.drawable.eren),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        studentAdapter = StudentAdapter(
            students,
            onClick = { student ->
                startActivity(
                    Intent(this, StudentDetailsActivity::class.java).apply {
                        putExtra("fName", student.firstName)
                        putExtra("mName", student.middleName)
                        putExtra("lName", student.lastName)
                        putExtra("photoId", student.id)
                        putExtra("photo", student.photoRes)
                    }
                )
            },
            onLongClick = { student ->
                val position = students.indexOf(student)
                if (position != -1) {
                    showDeleteDialog(position)
                }
            }
        )
        recyclerView.adapter = studentAdapter
    }
    private fun showDeleteDialog(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete item")
        builder.setMessage("Are you sure you want to delete this student?")
        builder.setPositiveButton("Remove") { _, _ ->
            students.removeAt(position)
            studentAdapter.notifyItemRemoved(position)
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }
}