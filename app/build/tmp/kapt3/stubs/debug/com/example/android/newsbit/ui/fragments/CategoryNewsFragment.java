package com.example.android.newsbit.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010e\u001a\u00020NH\u0002J\b\u0010f\u001a\u00020NH\u0002J\u0012\u0010g\u001a\u00020N2\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\u001a\u0010j\u001a\u00020N2\u0006\u0010k\u001a\u00020l2\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\b\u0010m\u001a\u00020NH\u0002J\u0010\u0010n\u001a\u00020N2\u0006\u0010o\u001a\u00020\u0004H\u0002J\b\u0010p\u001a\u00020NH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0011\u0010)\u001a\u00020*\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R\u0019\u00100\u001a\n 2*\u0004\u0018\u00010101\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020$\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u001a\u00107\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\u0010R\u001a\u0010:\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R\u001a\u0010A\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\u001a\u0010C\u001a\u00020;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R\u0011\u0010E\u001a\u00020$\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010&R\u001a\u0010G\u001a\u00020HX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u00020NX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010T\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010&\"\u0004\bV\u0010(R\u001a\u0010W\u001a\u00020XX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020^X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0011\u0010c\u001a\u00020$\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010&\u00a8\u0006q"}, d2 = {"Lcom/example/android/newsbit/ui/fragments/CategoryNewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnRetry", "Landroid/widget/Button;", "getBtnRetry", "()Landroid/widget/Button;", "setBtnRetry", "(Landroid/widget/Button;)V", "category", "getCategory", "setCategory", "(Ljava/lang/String;)V", "categoryArgs", "Lcom/example/android/newsbit/ui/fragments/CategoryNewsFragmentArgs;", "getCategoryArgs", "()Lcom/example/android/newsbit/ui/fragments/CategoryNewsFragmentArgs;", "categoryArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "categoryNewsAdapter", "Lcom/example/android/newsbit/adapters/NewsAdapter;", "getCategoryNewsAdapter", "()Lcom/example/android/newsbit/adapters/NewsAdapter;", "setCategoryNewsAdapter", "(Lcom/example/android/newsbit/adapters/NewsAdapter;)V", "categoryNewsItemView", "Landroidx/recyclerview/widget/RecyclerView;", "getCategoryNewsItemView", "()Landroidx/recyclerview/widget/RecyclerView;", "setCategoryNewsItemView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "categoryNewsPageTemp", "", "getCategoryNewsPageTemp", "()I", "setCategoryNewsPageTemp", "(I)V", "categoryNewsScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getCategoryNewsScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "customCategoryNewsPageTemp", "getCustomCategoryNewsPageTemp", "setCustomCategoryNewsPageTemp", "date", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getDate", "()Ljava/util/Calendar;", "day", "getDay", "from", "getFrom", "setFrom", "isCustomCategory", "", "()Z", "setCustomCategory", "(Z)V", "isError", "setError", "isLoading", "setLoading", "isScrolling", "setScrolling", "month", "getMonth", "paginationProgressBarView", "Landroid/widget/ProgressBar;", "getPaginationProgressBarView", "()Landroid/widget/ProgressBar;", "setPaginationProgressBarView", "(Landroid/widget/ProgressBar;)V", "previous", "", "getPrevious", "()Lkotlin/Unit;", "setPrevious", "(Lkotlin/Unit;)V", "Lkotlin/Unit;", "totalResults", "getTotalResults", "setTotalResults", "tvErrorMessage", "Landroid/widget/TextView;", "getTvErrorMessage", "()Landroid/widget/TextView;", "setTvErrorMessage", "(Landroid/widget/TextView;)V", "viewModel", "Lcom/example/android/newsbit/ui/NewsViewModel;", "getViewModel", "()Lcom/example/android/newsbit/ui/NewsViewModel;", "setViewModel", "(Lcom/example/android/newsbit/ui/NewsViewModel;)V", "year", "getYear", "hideErrorMessage", "hideProgressBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "setupRecyclerView", "showErrorMessage", "message", "showProgressBar", "app_debug"})
public final class CategoryNewsFragment extends androidx.fragment.app.Fragment {
    public com.example.android.newsbit.ui.NewsViewModel viewModel;
    public com.example.android.newsbit.adapters.NewsAdapter categoryNewsAdapter;
    public androidx.recyclerview.widget.RecyclerView categoryNewsItemView;
    public android.widget.ProgressBar paginationProgressBarView;
    public android.widget.Button btnRetry;
    public android.widget.TextView tvErrorMessage;
    private boolean isError = false;
    private int totalResults = 0;
    private boolean isLoading = false;
    private boolean isScrolling = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy categoryArgs$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String category = "";
    private boolean isCustomCategory = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "CategoryNewsFragment";
    private int categoryNewsPageTemp = 1;
    private int customCategoryNewsPageTemp = 1;
    private final java.util.Calendar date = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.Unit previous;
    private final int year = 0;
    private final int month = 0;
    private final int day = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String from;
    @org.jetbrains.annotations.NotNull()
    private final androidx.recyclerview.widget.RecyclerView.OnScrollListener categoryNewsScrollListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public CategoryNewsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.android.newsbit.ui.NewsViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.example.android.newsbit.ui.NewsViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.android.newsbit.adapters.NewsAdapter getCategoryNewsAdapter() {
        return null;
    }
    
    public final void setCategoryNewsAdapter(@org.jetbrains.annotations.NotNull()
    com.example.android.newsbit.adapters.NewsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getCategoryNewsItemView() {
        return null;
    }
    
    public final void setCategoryNewsItemView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ProgressBar getPaginationProgressBarView() {
        return null;
    }
    
    public final void setPaginationProgressBarView(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtnRetry() {
        return null;
    }
    
    public final void setBtnRetry(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvErrorMessage() {
        return null;
    }
    
    public final void setTvErrorMessage(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    public final boolean isError() {
        return false;
    }
    
    public final void setError(boolean p0) {
    }
    
    public final int getTotalResults() {
        return 0;
    }
    
    public final void setTotalResults(int p0) {
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final void setLoading(boolean p0) {
    }
    
    public final boolean isScrolling() {
        return false;
    }
    
    public final void setScrolling(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.android.newsbit.ui.fragments.CategoryNewsFragmentArgs getCategoryArgs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isCustomCategory() {
        return false;
    }
    
    public final void setCustomCategory(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final int getCategoryNewsPageTemp() {
        return 0;
    }
    
    public final void setCategoryNewsPageTemp(int p0) {
    }
    
    public final int getCustomCategoryNewsPageTemp() {
        return 0;
    }
    
    public final void setCustomCategoryNewsPageTemp(int p0) {
    }
    
    public final java.util.Calendar getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Unit getPrevious() {
        return null;
    }
    
    public final void setPrevious(@org.jetbrains.annotations.NotNull()
    kotlin.Unit p0) {
    }
    
    public final int getYear() {
        return 0;
    }
    
    public final int getMonth() {
        return 0;
    }
    
    public final int getDay() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFrom() {
        return null;
    }
    
    public final void setFrom(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void hideProgressBar() {
    }
    
    private final void showProgressBar() {
    }
    
    private final void hideErrorMessage() {
    }
    
    private final void showErrorMessage(java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.OnScrollListener getCategoryNewsScrollListener() {
        return null;
    }
    
    private final void setupRecyclerView() {
    }
}