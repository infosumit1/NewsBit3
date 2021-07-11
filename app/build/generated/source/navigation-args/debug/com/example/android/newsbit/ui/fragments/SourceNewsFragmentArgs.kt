package com.example.android.newsbit.ui.fragments

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class SourceNewsFragmentArgs(
  public val newsSourceId: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("newsSourceId", this.newsSourceId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SourceNewsFragmentArgs {
      bundle.setClassLoader(SourceNewsFragmentArgs::class.java.classLoader)
      val __newsSourceId : String?
      if (bundle.containsKey("newsSourceId")) {
        __newsSourceId = bundle.getString("newsSourceId")
        if (__newsSourceId == null) {
          throw IllegalArgumentException("Argument \"newsSourceId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"newsSourceId\" is missing and does not have an android:defaultValue")
      }
      return SourceNewsFragmentArgs(__newsSourceId)
    }
  }
}
