package com.example.project_oop.fragments.add

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.project_oop.R

class AddFragmentDirections private constructor() {
  companion object {
    fun actionAddFragmentToListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addFragment_to_listFragment)
  }
}
