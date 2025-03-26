package com.anime.recyclerviewproject.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anime.recyclerviewproject.R
import com.anime.recyclerviewproject.data.Student

class StudentAdapter(
    private val students: List<Student>,
    private val onClick : (Student) -> Unit,
    private val onLongClick : (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.student_photo)
        val name: TextView = itemView.findViewById(R.id.student_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.photo.setImageResource(student.photoRes)
        holder.name.text = "${student.firstName} ${student.middleName} ${student.lastName}"

        holder.itemView.setOnClickListener {
            onClick(student)
        }

        holder.itemView.setOnLongClickListener {
            onLongClick(student)
            true
        }
    }

    override fun getItemCount(): Int = students.size
}