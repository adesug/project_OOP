package com.example.project_oop.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.project_oop.R

class fragment_pilihanDirections private constructor() {
  companion object {
    fun actionFragmentPilihan2ToListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_pilihan2_to_listFragment)

    fun actionFragmentPilihanToListFragmentPasar(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragment_pilihan_to_listFragmentPasar)
  }
}
