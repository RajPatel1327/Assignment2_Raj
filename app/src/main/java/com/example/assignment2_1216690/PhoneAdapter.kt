package com.example.assignment2_1216690

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhoneAdapter(private val phoneList: List<Phone>) : RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    class PhoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewModel: TextView = itemView.findViewById(R.id.text_view_model)
        val textViewName: TextView = itemView.findViewById(R.id.text_view_name)
        val textViewOperatingSystem: TextView = itemView.findViewById(R.id.text_view_operating_system)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_phone, parent, false)
        return PhoneViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val currentItem = phoneList[position]
        holder.textViewModel.text = currentItem.model
        holder.textViewName.text = currentItem.name
        holder.textViewOperatingSystem.text = currentItem.operatingSystem
    }

    override fun getItemCount() = phoneList.size
}