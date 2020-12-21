package com.example.project_oop.fragments.update

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.project_oop.R

class UpdateFragmentDirections private constructor() {
  companion object {
    fun actionUpdateFragmentToListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_updateFragment_to_listFragment)
  }
}
