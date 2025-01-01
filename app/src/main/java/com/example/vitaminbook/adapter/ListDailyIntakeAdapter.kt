package com.example.vitaminbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vitaminbook.dataClass.DailyIntake
import com.example.vitaminbook.R

class ListDailyIntakeAdapter(private val dailyIntakeList: ArrayList<DailyIntake>, private val unit: String) : RecyclerView.Adapter<ListDailyIntakeAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPeople: TextView = itemView.findViewById(R.id.tv_item_people)
        val tvIntakeValue: TextView = itemView.findViewById(R.id.tv_item_intake_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_daily_intake, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (people, value) = dailyIntakeList[position]
        holder.tvPeople.text = people
        holder.tvIntakeValue.text = if ("hamil" in people.orEmpty() || "menyusui" in people.orEmpty()) {
                "+ $value $unit"
            } else {
                "$value $unit"
            }
    }

    override fun getItemCount(): Int = dailyIntakeList.size
}