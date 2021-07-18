package com.example.android.newsbit.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.android.newsbit.R
import com.example.android.newsbit.models.Article
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class SourceNewsFragmentDirections private constructor() {
  private data class ActionSourceNewsFragmentToArticleFragment(
    public val article: Article
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_sourceNewsFragment_to_articleFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Article::class.java)) {
        result.putParcelable("article", this.article as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Article::class.java)) {
        result.putSerializable("article", this.article as Serializable)
      } else {
        throw UnsupportedOperationException(Article::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  public companion object {
    public fun actionSourceNewsFragmentToArticleFragment(article: Article): NavDirections =
        ActionSourceNewsFragmentToArticleFragment(article)

    public fun actionSourceNewsFragmentToNoResponseFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_sourceNewsFragment_to_noResponseFragment)
  }
}
