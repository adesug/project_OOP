package com.example.project_oop.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.project_oop.R
import com.example.project_oop.data.DataPasar
import com.example.project_oop.data.DataPasarViewModel
import kotlinx.android.synthetic.main.fragment_add_pasar.*
import kotlinx.android.synthetic.main.fragment_add_pasar.view.*

class AddFragmentPasar : Fragment() {

    private lateinit var mDataPasarViewModel: DataPasarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_pasar,container,false)

        mDataPasarViewModel = ViewModelProvider(this).get(DataPasarViewModel::class.java)

        view.buttonAdd.setOnClickListener{
            insertDatatoDatabase()
        }

        return view
    }

    private fun insertDatatoDatabase(){
        val namaPasar = edt_namaPasar.text.toString()
        val alamatPasar = edt_alamatPasar.text.toString()
        val tipePasar = edt_tipePasar.text.toString()

        if(inputCheck(namaPasar,alamatPasar,tipePasar)){
            val dataPasar = DataPasar(0, namaPasar, alamatPasar, tipePasar)

            mDataPasarViewModel.addData(dataPasar)
            Toast.makeText(requireContext(), "Sukses Terinput", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(namaPasar: String,alamatPasar: String, tipePasar: String): Boolean{
        return !(TextUtils.isEmpty(namaPasar) && TextUtils.isEmpty(alamatPasar) && TextUtils.isEmpty(tipePasar))
    }

}