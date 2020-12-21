package com.example.project_oop.fragments.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.project_oop.R
import com.example.project_oop.model.Pedagang
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToUpdateFragment(
    val currentPedagang: Pedagang
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_listFragment_to_updateFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Pedagang::class.java)) {
        result.putParcelable("currentPedagang", this.currentPedagang as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Pedagang::class.java)) {
        result.putSerializable("currentPedagang", this.currentPedagang as Serializable)
      } else {
        throw UnsupportedOperationException(Pedagang::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionListFragmentToAddFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragment_to_addFragment)

    fun actionListFragmentToUpdateFragment(currentPedagang: Pedagang): NavDirections =
        ActionListFragmentToUpdateFragment(currentPedagang)
  }
}
