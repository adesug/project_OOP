package com.example.project_oop.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.project_oop.R
import kotlinx.android.synthetic.main.fragment_pilihan.view.*

class fragment_pilihan : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pilihan, container, false)
        view.btn_pedagang.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_pilihan2_to_listFragment)
        }
        view.btn_pasar.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_pilihan_to_listFragmentPasar)
        }
        return view
    }

}