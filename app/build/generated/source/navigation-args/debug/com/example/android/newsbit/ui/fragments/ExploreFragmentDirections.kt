package com.example.android.newsbit.ui.fragments

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.android.newsbit.R
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public class ExploreFragmentDirections private constructor() {
  private data class ActionExploreFragmentToCategoryNewsFragment(
    public val categoryName: String,
    public val isCustomCategory: Boolean
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_exploreFragment_to_categoryNewsFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("categoryName", this.categoryName)
      result.putBoolean("isCustomCategory", this.isCustomCategory)
      return result
    }
  }

  private data class ActionExploreFragmentToSourceNewsFragment(
    public val newsSourceId: String
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_exploreFragment_to_sourceNewsFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("newsSourceId", this.newsSourceId)
      return result
    }
  }

  private data class ActionExploreFragmentToSearchFragment(
    public val keyword: String
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_exploreFragment_to_searchFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("keyword", this.keyword)
      return result
    }
  }

  public companion object {
    public fun actionExploreFragmentToCategoryNewsFragment(categoryName: String,
        isCustomCategory: Boolean): NavDirections =
        ActionExploreFragmentToCategoryNewsFragment(categoryName, isCustomCategory)

    public fun actionExploreFragmentToSourceNewsFragment(newsSourceId: String): NavDirections =
        ActionExploreFragmentToSourceNewsFragment(newsSourceId)

    public fun actionExploreFragmentToSearchFragment(keyword: String): NavDirections =
        ActionExploreFragmentToSearchFragment(keyword)
  }
}
