package com.example.project_oop.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.project_oop.R
import com.example.project_oop.model.Pedagang
import com.example.project_oop.viewmodel.PedagangViewModel
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_update.*
//import kotlinx.android.synthetic.main.fragment_add.view.Update_nama
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val  args by navArgs<UpdateFragmentArgs>()

    private lateinit var mPedagangViewModel: PedagangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mPedagangViewModel = ViewModelProvider(this).get(PedagangViewModel::class.java)

        view.Update_nama.setText(args.currentPedagang.nama)
        view.Update_alamat.setText(args.currentPedagang.alamat_pedagang)
        view.Update_no_lapak.setText(args.currentPedagang.no_lapak.toString())

         view.Update_btn.setOnClickListener {
            updateItem()
         }
        //add menu
        setHasOptionsMenu(true)
        return view
    }
    private fun updateItem() {
        val nama = Update_nama.text.toString()
        val alamat = Update_alamat.text.toString()
        val no_lapak = Integer.parseInt(Update_no_lapak.toString())

        if (inputCheck(nama, alamat, Update_no_lapak.text)){
            //create pedagang object
            val updatePedagang = Pedagang(args.currentPedagang.id, nama, alamat, no_lapak)
            //update current pedagang
            mPedagangViewModel.updatePedagang(updatePedagang)
            Toast.makeText(requireContext(), "Update Successfully", Toast.LENGTH_SHORT).show()
            //Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }
    }

    private  fun  inputCheck(nama: String, alamat: String, no_lapak: Editable): Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(alamat) && no_lapak.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deletePedagang()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun deletePedagang(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton( "Yes") { _, _ ->
            mPedagangViewModel.deletePedagang(args.currentPedagang)
           Toast.makeText(
               requireContext(),
               "SuccessFully removed: ${args.currentPedagang.nama}",
               Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setPositiveButton("No") {_, _ -> }
        builder.setMessage("Are you sure want to delete ${args.currentPedagang.nama}?")
        builder.create().show()
    }




}