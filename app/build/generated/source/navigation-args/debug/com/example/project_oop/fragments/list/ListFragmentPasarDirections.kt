package com.example.project_oop.fragments.list

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.project_oop.R

class ListFragmentPasarDirections private constructor() {
  companion object {
    fun actionListFragmentPasar2ToAddFragmentPasar(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragmentPasar2_to_addFragmentPasar)
  }
}
