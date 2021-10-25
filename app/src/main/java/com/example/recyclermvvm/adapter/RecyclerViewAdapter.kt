package com.example.recyclermvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclermvvm.R
import com.example.recyclermvvm.models.RecyclerData
import com.example.recyclermvvm.models.RecyclerList
import com.squareup.picasso.Picasso
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class RecyclerViewAdapter(
    var repos : ArrayList<RecyclerData>
): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

//    fun setUpdatedData(items: ArrayList<RecyclerData>) {
//        this.items = items;
//        notifyDataSetChanged()
//    }


//    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val recyclerImage: ImageView = view.
//    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

         val recyclerImage: ImageView = view.findViewById(R.id.recycler_image)
         val tvTitle: TextView = view.findViewById(R.id.tv_name)
         val tvDesc: TextView = view.findViewById(R.id.description)

//        fun bind(data : RecyclerData) {
//            tvTitle.text = data.name
//            tvDesc.text = data.description
//
//            val url = data.owner.avatar_url
//            Picasso.get().load(url).into(recyclerImage)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_items, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      //  holder.bind(items[position])
        val currentRepo = repos[position]

        holder.tvTitle.text = currentRepo.name
        holder.tvDesc.text = currentRepo.description
        val url = currentRepo.owner.avatar_url
        Picasso.get().load(url).into(holder.recyclerImage)

    }

    override fun getItemCount(): Int {
        return repos.size
    }
}