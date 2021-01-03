package com.example.project_oop.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.project_oop.R
import com.example.project_oop.model.DataPasar
import com.example.project_oop.viewmodel.DataPasarViewModel
import kotlinx.android.synthetic.main.fragment_update_pasar.*
import kotlinx.android.synthetic.main.fragment_update_pasar.view.*

class UpdatePasar : Fragment() {

    private val args by navArgs<UpdatePasarArgs>()
    private lateinit var mPasarViewModel: DataPasarViewModel

  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view = inflater.inflate(R.layout.fragment_update_pasar, container, false)

      mPasarViewModel = ViewModelProvider(this).get(DataPasarViewModel::class.java)

      view.update_namaPasar.setText(args.currentPasar.namaPasar)
      view.update_alamatPasar.setText(args.currentPasar.alamatPasar)
      view.update_tipePasar.setText(args.currentPasar.tipePasar)

      view.btn_updatePasar.setOnClickListener {
          updatePasar()
      }

      setHasOptionsMenu(true)
      return view
    }

    private fun updatePasar(){
        val namaPasar = update_namaPasar.text.toString()
        val alamatPasar = update_alamatPasar.text.toString()
        val tipePasar = update_tipePasar.text.toString()

        if (inputCheck(namaPasar, alamatPasar, tipePasar)){

            val updatedPasar = DataPasar(args.currentPasar.id, namaPasar, alamatPasar, tipePasar)

            mPasarViewModel.updatePasar(updatedPasar)
            Toast.makeText(requireContext(),"Updated!",Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updatePasar_to_listFragmentPasar)
        }else{
            Toast.makeText(requireContext(),"Isi semua Data !",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(namaPasar: String,alamatPasar: String, tipePasar: String): Boolean{
        return !(TextUtils.isEmpty(namaPasar) && TextUtils.isEmpty(alamatPasar) && TextUtils.isEmpty(tipePasar))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deletePasar()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deletePasar() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _, _ ->
            mPasarViewModel.deletePasar(args.currentPasar)
            Toast.makeText(
                requireContext(),
                "Successfully removed",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updatePasar_to_listFragmentPasar)
        }
        builder.setNegativeButton("No"){_, _ ->}
        builder.setTitle("Delete ${args.currentPasar.namaPasar}?")
        builder.setMessage("Are You sure you want to delete ${args.currentPasar.namaPasar}")
        builder.create().show()
    }
}