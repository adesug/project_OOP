package com.example.project_oop.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.project_oop.R
import kotlinx.android.synthetic.main.fragment_list_pasar.view.*

class ListFragmentPasar : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view2  = inflater.inflate(R.layout.fragment_list_pasar, container, false)

        view2.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragmentPasar2_to_addFragmentPasar)
        }

        return view2
    }
}