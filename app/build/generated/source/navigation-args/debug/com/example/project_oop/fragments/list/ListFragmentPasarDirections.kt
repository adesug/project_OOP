package com.example.project_oop.fragments.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.project_oop.R
import com.example.project_oop.model.DataPasar
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class ListFragmentPasarDirections private constructor() {
  private data class ActionListFragmentPasarToUpdatePasar(
    val currentPasar: DataPasar
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_listFragmentPasar_to_updatePasar

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(DataPasar::class.java)) {
        result.putParcelable("currentPasar", this.currentPasar as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(DataPasar::class.java)) {
        result.putSerializable("currentPasar", this.currentPasar as Serializable)
      } else {
        throw UnsupportedOperationException(DataPasar::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionListFragmentPasarToFragmentPilihan2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragmentPasar_to_fragment_pilihan2)

    fun actionListFragmentPasarToFragmentPilihan3(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragmentPasar_to_fragment_pilihan3)

    fun actionListFragmentPasarToAddFragmentPasar(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragmentPasar_to_addFragmentPasar)

    fun actionListFragmentPasarToUpdatePasar(currentPasar: DataPasar): NavDirections =
        ActionListFragmentPasarToUpdatePasar(currentPasar)
  }
}
