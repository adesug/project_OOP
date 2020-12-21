package com.example.project_oop.fragments.update

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.project_oop.model.Pedagang
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class UpdateFragmentArgs(
  val currentPedagang: Pedagang
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): UpdateFragmentArgs {
      bundle.setClassLoader(UpdateFragmentArgs::class.java.classLoader)
      val __currentPedagang : Pedagang?
      if (bundle.containsKey("currentPedagang")) {
        if (Parcelable::class.java.isAssignableFrom(Pedagang::class.java) ||
            Serializable::class.java.isAssignableFrom(Pedagang::class.java)) {
          __currentPedagang = bundle.get("currentPedagang") as Pedagang?
        } else {
          throw UnsupportedOperationException(Pedagang::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentPedagang == null) {
          throw IllegalArgumentException("Argument \"currentPedagang\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentPedagang\" is missing and does not have an android:defaultValue")
      }
      return UpdateFragmentArgs(__currentPedagang)
    }
  }
}
