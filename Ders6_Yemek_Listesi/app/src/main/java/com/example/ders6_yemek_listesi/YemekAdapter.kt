package com.example.ders6_yemek_listesi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ders6_yemek_listesi.databinding.RecyclerRowBinding

class YemekAdapter(val yemekListesi: ArrayList<Yemek>) : RecyclerView.Adapter<YemekAdapter.YemekHolder>() {

    class YemekHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return YemekHolder(binding)
    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }

    override fun onBindViewHolder(holder: YemekHolder, position: Int) {
        holder.binding.yemekAdiText.text = yemekListesi.get(position).yemekAdi
        holder.binding.kategoriText.text = yemekListesi.get(position).yemekKategori
        holder.binding.puanText.text = yemekListesi.get(position).yemekPuani
        holder.binding.yemekImage.setImageResource(yemekListesi.get(position).yemekResmi)

        holder.binding.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("YemekListesi",yemekListesi.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

}
