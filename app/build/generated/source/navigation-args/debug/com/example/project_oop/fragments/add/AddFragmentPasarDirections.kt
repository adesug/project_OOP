package com.example.project_oop.fragments.add

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.project_oop.R

class AddFragmentPasarDirections private constructor() {
  companion object {
    fun actionAddFragmentPasarToListFragmentPasar(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addFragmentPasar_to_listFragmentPasar)
  }
}
