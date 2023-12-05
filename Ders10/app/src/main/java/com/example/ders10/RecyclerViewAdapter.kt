package com.example.ders10

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.ders10.databinding.RecyclerRowBinding
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(
    private val valorantList: ArrayList<ValorantModel>,
    private val listener: MainActivity
) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    class RowHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return valorantList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.binding.agentName.text = valorantList.get(position).displayName
        Picasso.get().load(valorantList.get(position).fullPortrait).into(holder.binding.agentImage)

        val originalColor = valorantList.get(position).backgroundColor
        val color = Color.parseColor(originalColor)
        val opacity = 128
        val newColor = ColorUtils.setAlphaComponent(color, opacity)
        holder.binding.card.setCardBackgroundColor(newColor)

        holder.itemView.setOnClickListener {
            listener.onItemClick(valorantList.get(position))
        }
    }
}