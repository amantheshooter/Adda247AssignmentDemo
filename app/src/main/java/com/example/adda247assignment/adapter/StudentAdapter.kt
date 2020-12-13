package com.example.adda247assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adda247assignment.R
import com.example.adda247assignment.model.StudentData
import kotlinx.android.synthetic.main.item_row.view.*
import java.util.*

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    private var mStudentList: ArrayList<StudentData>? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        )

        return ViewHolder(holder.itemView)
    }

    override fun getItemCount(): Int {
        return if (mStudentList != null) {
            mStudentList!!.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStudent = mStudentList!![position]
        holder.itemView.txt_name.text = currentStudent.name
        holder.itemView.txt_email.text = currentStudent.email
        holder.itemView.active_status.text = currentStudent.status

        if (currentStudent.status.toString().contains("In")) {
            holder.itemView.active_status.setBackgroundResource(R.drawable.rect_inactive)
        } else {
            holder.itemView.active_status.setBackgroundResource(R.drawable.rect_active)
        }
    }

    fun setDeveloperList(mStudentList: ArrayList<StudentData>) {
        this.mStudentList = mStudentList
        notifyDataSetChanged()
    }

}
