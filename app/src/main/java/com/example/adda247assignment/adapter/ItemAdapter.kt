package com.example.adda247assignment.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.adda247assignment.R
import com.example.adda247assignment.adapter.ItemAdapter.ItemViewHolder
import com.example.adda247assignment.model.StudentData

class ItemAdapter internal constructor(private val mCtx: Context) :
    PagedListAdapter<StudentData, ItemViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(mCtx).inflate(R.layout.item_row, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.textName.text = item.name
            holder.textEmail.text = item.email
            holder.activeStatus.text = item.status
        } else {
            Toast.makeText(mCtx, "StudentData is null", Toast.LENGTH_LONG).show()
        }
    }

    class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.txt_name)
        var textEmail: TextView = itemView.findViewById(R.id.txt_email)
        var activeStatus: TextView = itemView.findViewById(R.id.active_status)

    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<StudentData> =
            object : DiffUtil.ItemCallback<StudentData>() {
                override fun areItemsTheSame(
                    oldItem: StudentData,
                    newItem: StudentData
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: StudentData,
                    newItem: StudentData
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}