// Generated by view binder compiler. Do not edit!
package com.example.android.newsbit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.android.newsbit.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentExploreBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final RecyclerView categoryItemView;

  @NonNull
  public final LinearLayout exploreBottomSection;

  @NonNull
  public final RecyclerView newsSourceItemView;

  @NonNull
  public final ProgressBar progressBarSearch;

  @NonNull
  public final RecyclerView searchItemView;

  @NonNull
  public final SearchView searchView;

  private FragmentExploreBinding(@NonNull NestedScrollView rootView,
      @NonNull RecyclerView categoryItemView, @NonNull LinearLayout exploreBottomSection,
      @NonNull RecyclerView newsSourceItemView, @NonNull ProgressBar progressBarSearch,
      @NonNull RecyclerView searchItemView, @NonNull SearchView searchView) {
    this.rootView = rootView;
    this.categoryItemView = categoryItemView;
    this.exploreBottomSection = exploreBottomSection;
    this.newsSourceItemView = newsSourceItemView;
    this.progressBarSearch = progressBarSearch;
    this.searchItemView = searchItemView;
    this.searchView = searchView;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentExploreBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentExploreBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_explore, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentExploreBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.categoryItemView;
      RecyclerView categoryItemView = rootView.findViewById(id);
      if (categoryItemView == null) {
        break missingId;
      }

      id = R.id.explore_bottom_section;
      LinearLayout exploreBottomSection = rootView.findViewById(id);
      if (exploreBottomSection == null) {
        break missingId;
      }

      id = R.id.newsSourceItemView;
      RecyclerView newsSourceItemView = rootView.findViewById(id);
      if (newsSourceItemView == null) {
        break missingId;
      }

      id = R.id.progress_bar_search;
      ProgressBar progressBarSearch = rootView.findViewById(id);
      if (progressBarSearch == null) {
        break missingId;
      }

      id = R.id.searchItemView;
      RecyclerView searchItemView = rootView.findViewById(id);
      if (searchItemView == null) {
        break missingId;
      }

      id = R.id.search_view;
      SearchView searchView = rootView.findViewById(id);
      if (searchView == null) {
        break missingId;
      }

      return new FragmentExploreBinding((NestedScrollView) rootView, categoryItemView,
          exploreBottomSection, newsSourceItemView, progressBarSearch, searchItemView, searchView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}