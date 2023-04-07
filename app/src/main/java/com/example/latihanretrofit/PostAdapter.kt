package com.example.latihanretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val list: ArrayList<PostResponse>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postResponse: PostResponse) {
            with(itemView) {
                var tvText: TextView = findViewById(R.id.tvText)
                val text = "id: ${postResponse.id}\n" +
                        "title: ${postResponse.title}\n" +
                        "body: ${postResponse.text}"
                tvText.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
}