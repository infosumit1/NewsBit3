package com.example.android.newsbit.ui.fragments

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.String
import kotlin.jvm.JvmStatic

public data class CategoryNewsFragmentArgs(
  public val categoryName: String,
  public val isCustomCategory: Boolean
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("categoryName", this.categoryName)
    result.putBoolean("isCustomCategory", this.isCustomCategory)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CategoryNewsFragmentArgs {
      bundle.setClassLoader(CategoryNewsFragmentArgs::class.java.classLoader)
      val __categoryName : String?
      if (bundle.containsKey("categoryName")) {
        __categoryName = bundle.getString("categoryName")
        if (__categoryName == null) {
          throw IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"categoryName\" is missing and does not have an android:defaultValue")
      }
      val __isCustomCategory : Boolean
      if (bundle.containsKey("isCustomCategory")) {
        __isCustomCategory = bundle.getBoolean("isCustomCategory")
      } else {
        throw IllegalArgumentException("Required argument \"isCustomCategory\" is missing and does not have an android:defaultValue")
      }
      return CategoryNewsFragmentArgs(__categoryName, __isCustomCategory)
    }
  }
}
