package com.example.project_oop.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.project_oop.R
import com.example.project_oop.model.Pedagang
//import com.example.roomapp.R
//import com.example.rooma.data.Pedagang
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var pedagangList = emptyList<Pedagang>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent,false ))
    }

    override fun getItemCount(): Int {
       return  pedagangList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = pedagangList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.name_txt.text = currentItem.nama
        holder.itemView.alamat_txt.text = currentItem.alamat_pedagang
        holder.itemView.noLapak_txt.text = currentItem.no_lapak.toString()

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(pedagang: List<Pedagang>){
        this.pedagangList = pedagang
        notifyDataSetChanged()
    }


}