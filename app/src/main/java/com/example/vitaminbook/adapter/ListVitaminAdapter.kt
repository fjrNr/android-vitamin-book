package com.example.vitaminbook.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.vitaminbook.R
import com.example.vitaminbook.dataClass.Vitamin
import com.example.vitaminbook.activity.DetailActivity

class ListVitaminAdapter(private val listVitamin: ArrayList<Vitamin>) : RecyclerView.Adapter<ListVitaminAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_vitamin, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listVitamin.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, thumbnailUrl, synonym, overall) = listVitamin[position]
        Glide.with(holder.itemView.context)
            .load(thumbnailUrl)
            .transform(CircleCrop())
            .placeholder(R.drawable.ic_launcher_vitamin_book_foreground)
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = String.format("Sinonim: %s\n%s", synonym, overall)
        holder.itemView.setOnClickListener({
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_VITAMIN, listVitamin[holder.adapterPosition])
            intentDetail.putExtra(DetailActivity.EXTRA_INDEX, holder.adapterPosition)
            holder.itemView.context.startActivity(intentDetail)
        })
    }
}