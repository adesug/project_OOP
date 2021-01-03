package com.example.project_oop.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.project_oop.R
import com.example.project_oop.model.DataPasar
import kotlinx.android.synthetic.main.custom_row_pasar.view.*

class ListAdapterPasar:  RecyclerView.Adapter<ListAdapterPasar.PasarViewHolder>() {

    private var pasarList = emptyList<DataPasar>()

    class PasarViewHolder(itemView1: View):RecyclerView.ViewHolder(itemView1) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasarViewHolder {
        return PasarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row_pasar, parent, false))
    }

    override fun getItemCount(): Int {
        return pasarList.size
    }

    override fun onBindViewHolder(holder: PasarViewHolder, position: Int) {
        val currentItem = pasarList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.nama_txt.text = currentItem.namaPasar
        holder.itemView.alamat_txt.text = currentItem.alamatPasar
        holder.itemView.tipe_txt.text = currentItem.tipePasar

        holder.itemView.rowLayoutPasar.setOnClickListener {
            val action = ListFragmentPasarDirections.actionListFragmentPasarToUpdatePasar(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun  setData(pasar: List<DataPasar>){
        this.pasarList = pasar
        notifyDataSetChanged()
    }

}