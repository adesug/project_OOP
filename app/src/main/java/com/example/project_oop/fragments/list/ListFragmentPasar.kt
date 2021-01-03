package com.example.project_oop.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_oop.R
import com.example.project_oop.viewmodel.DataPasarViewModel
import kotlinx.android.synthetic.main.fragment_list_pasar.view.floatingActionButton
import kotlinx.android.synthetic.main.fragment_list_pasar.view.recyclerview

class ListFragmentPasar : Fragment() {

    private lateinit var mPasarViewModel: DataPasarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view2  = inflater.inflate(R.layout.fragment_list_pasar, container, false)

        val adapter = ListAdapterPasar()
        val recyclerView = view2.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mPasarViewModel = ViewModelProvider(this).get(DataPasarViewModel::class.java)
        mPasarViewModel.readAllData.observe(viewLifecycleOwner, Observer { pasar ->
            adapter.setData(pasar)
        })
        view2.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragmentPasar_to_addFragmentPasar)
        }

        setHasOptionsMenu(true)
        return view2
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteAllPasars()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllPasars(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _, _ ->
            mPasarViewModel.deleteAllPasars()
            Toast.makeText(
                requireContext(),
                "Successfully removed All",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No"){_, _ ->}
        builder.setTitle("Delete All?")
        builder.setMessage("Are You sure you want to delete All")
        builder.create().show()
    }
}