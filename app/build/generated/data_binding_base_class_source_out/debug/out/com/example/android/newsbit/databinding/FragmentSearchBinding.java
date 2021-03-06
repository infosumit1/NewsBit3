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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.android.newsbit.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSearchBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ItemErrorMessageBinding itemErrorMessage;

  @NonNull
  public final LinearLayout noresultBg;

  @NonNull
  public final ProgressBar progressBarSearch2;

  @NonNull
  public final RecyclerView searchItemView2;

  @NonNull
  public final SearchView searchView2;

  private FragmentSearchBinding(@NonNull ConstraintLayout rootView,
      @NonNull ItemErrorMessageBinding itemErrorMessage, @NonNull LinearLayout noresultBg,
      @NonNull ProgressBar progressBarSearch2, @NonNull RecyclerView searchItemView2,
      @NonNull SearchView searchView2) {
    this.rootView = rootView;
    this.itemErrorMessage = itemErrorMessage;
    this.noresultBg = noresultBg;
    this.progressBarSearch2 = progressBarSearch2;
    this.searchItemView2 = searchItemView2;
    this.searchView2 = searchView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.itemErrorMessage;
      View itemErrorMessage = rootView.findViewById(id);
      if (itemErrorMessage == null) {
        break missingId;
      }
      ItemErrorMessageBinding binding_itemErrorMessage = ItemErrorMessageBinding.bind(itemErrorMessage);

      id = R.id.noresultBg;
      LinearLayout noresultBg = rootView.findViewById(id);
      if (noresultBg == null) {
        break missingId;
      }

      id = R.id.progress_bar_search2;
      ProgressBar progressBarSearch2 = rootView.findViewById(id);
      if (progressBarSearch2 == null) {
        break missingId;
      }

      id = R.id.searchItemView2;
      RecyclerView searchItemView2 = rootView.findViewById(id);
      if (searchItemView2 == null) {
        break missingId;
      }

      id = R.id.search_view2;
      SearchView searchView2 = rootView.findViewById(id);
      if (searchView2 == null) {
        break missingId;
      }

      return new FragmentSearchBinding((ConstraintLayout) rootView, binding_itemErrorMessage,
          noresultBg, progressBarSearch2, searchItemView2, searchView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
