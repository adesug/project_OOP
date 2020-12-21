package com.example.project_oop.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.project_oop.R
import com.example.project_oop.model.Pedagang
import com.example.project_oop.viewmodel.PedagangViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private  lateinit var mPedagangViewModel: PedagangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mPedagangViewModel = ViewModelProvider( this).get(PedagangViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun  insertDataToDatabase(){
        val  nama = add_nama.text.toString()
        val  alamat = add_alamat.text.toString()
        val no_lapak = add_no_lapak.text

        if (inputCheck(nama, alamat, no_lapak)){
            // check user object
            val pedagang = Pedagang(
                0,
                nama,
                alamat,
                Integer.parseInt(no_lapak.toString())
            )
            // add data to Database
            mPedagangViewModel.addPedagang(pedagang)
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()
            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)


        }else{
            Toast.makeText(requireContext(),"Please fill out all field.", Toast.LENGTH_LONG).show()
        }

    }

    private  fun  inputCheck(nama: String, alamat: String, no_lapak: Editable): Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(alamat) && no_lapak.isEmpty())
    }
}

