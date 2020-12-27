package com.example.project_oop.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import cn.pedant.SweetAlert.SweetAlertDialog

import com.example.project_oop.R
import com.example.project_oop.model.Pedagang
import com.example.project_oop.viewmodel.PedagangViewModel
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_update.*
//import kotlinx.android.synthetic.main.fragment_add.view.Update_nama
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: PedagangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        mUserViewModel = ViewModelProvider(this).get(PedagangViewModel::class.java)
        view.Update_nama.setText(args.currentPedagang.nama)
        view.Update_alamat.setText(args.currentPedagang.alamat_pedagang)
        view.Update_no_lapak.setText(args.currentPedagang.no_lapak.toString())
        view.Update_btn.setOnClickListener {
            updateItem()
        }

        setHasOptionsMenu(true)
        return view
    }
    private fun updateItem(){
        val nama = Update_nama.text.toString()
        val alamat = Update_alamat.text.toString()
        val no_lapak = Integer.parseInt(Update_no_lapak.text.toString())
        if(inputCheck(nama,alamat,Update_no_lapak.text)){
            val updatedPedagang = Pedagang(args.currentPedagang.id, nama,alamat,no_lapak)
            SweetAlertDialog(activity,SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Data Berhasil Di Tambahkan")
                .show()
            mUserViewModel.updatePedagang(updatedPedagang)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Data Gagal Ditambahkan!", Toast.LENGTH_SHORT).show()
        }
    }
    private  fun  inputCheck(nama: String, alamat: String, no_lapak: Editable): Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(alamat) && no_lapak.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deletePedagang()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deletePedagang(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("yes"){_,_ ->
            mUserViewModel.deletePedagang(args.currentPedagang)
            SweetAlertDialog(activity,SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Data Berhasil Di Hapus")
                .show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Hapus ${args.currentPedagang.nama}?")
        builder.setMessage("Apakah Anda Yakin Menghapus ${args.currentPedagang.nama}?")
        builder.create().show()
    }
}