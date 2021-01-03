package com.example.project_oop.fragments.update

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.project_oop.R

class UpdatePasarDirections private constructor() {
  companion object {
    fun actionUpdatePasarToListFragmentPasar(): NavDirections =
        ActionOnlyNavDirections(R.id.action_updatePasar_to_listFragmentPasar)
  }
}
