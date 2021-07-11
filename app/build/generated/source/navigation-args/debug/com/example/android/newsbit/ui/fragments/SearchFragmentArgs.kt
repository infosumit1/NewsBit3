package com.example.android.newsbit.ui.fragments

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class SearchFragmentArgs(
  public val keyword: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("keyword", this.keyword)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SearchFragmentArgs {
      bundle.setClassLoader(SearchFragmentArgs::class.java.classLoader)
      val __keyword : String?
      if (bundle.containsKey("keyword")) {
        __keyword = bundle.getString("keyword")
        if (__keyword == null) {
          throw IllegalArgumentException("Argument \"keyword\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"keyword\" is missing and does not have an android:defaultValue")
      }
      return SearchFragmentArgs(__keyword)
    }
  }
}
