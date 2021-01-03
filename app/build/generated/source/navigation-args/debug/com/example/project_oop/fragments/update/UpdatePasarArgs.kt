package com.example.project_oop.fragments.update

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.project_oop.model.DataPasar
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class UpdatePasarArgs(
  val currentPasar: DataPasar
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): UpdatePasarArgs {
      bundle.setClassLoader(UpdatePasarArgs::class.java.classLoader)
      val __currentPasar : DataPasar?
      if (bundle.containsKey("currentPasar")) {
        if (Parcelable::class.java.isAssignableFrom(DataPasar::class.java) ||
            Serializable::class.java.isAssignableFrom(DataPasar::class.java)) {
          __currentPasar = bundle.get("currentPasar") as DataPasar?
        } else {
          throw UnsupportedOperationException(DataPasar::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentPasar == null) {
          throw IllegalArgumentException("Argument \"currentPasar\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentPasar\" is missing and does not have an android:defaultValue")
      }
      return UpdatePasarArgs(__currentPasar)
    }
  }
}
