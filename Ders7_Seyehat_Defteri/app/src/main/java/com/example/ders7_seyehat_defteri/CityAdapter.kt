package com.example.ders7_seyehat_defteri

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ders7_seyehat_defteri.databinding.RecyclerRowBinding

class CityAdapter(val cityList: ArrayList<City>) : RecyclerView.Adapter<CityAdapter.CityHolder>() {

    class CityHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CityHolder(binding)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.binding.cityNameText.text = cityList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("info","old")
            intent.putExtra("id",cityList.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }

}