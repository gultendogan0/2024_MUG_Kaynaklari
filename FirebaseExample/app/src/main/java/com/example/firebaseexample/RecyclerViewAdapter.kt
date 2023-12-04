package com.example.firebaseexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseexample.databinding.RecyclerRowBinding
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(var shareList: ArrayList<Share>) : RecyclerView.Adapter<RecyclerViewAdapter.ShareHolder>() {

    class ShareHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShareHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShareHolder(binding)
    }

    override fun getItemCount(): Int {
        return shareList.size
    }

    override fun onBindViewHolder(holder: ShareHolder, position: Int) {
        holder.binding.recyclerRowUser.text = shareList.get(position).user
        holder.binding.recyclerRowShareComment.text = shareList.get(position).userComment
        if(shareList.get(position).imageUrl != null){
            holder.binding.recyclerRowImage.visibility = View.VISIBLE
            Picasso.get().load(shareList.get(position).imageUrl).into(holder.binding.recyclerRowImage)
        }
    }
}