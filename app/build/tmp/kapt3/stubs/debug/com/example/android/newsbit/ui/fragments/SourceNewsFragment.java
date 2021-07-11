package com.example.android.newsbit.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010`\u001a\u00020,H\u0002J\b\u0010a\u001a\u00020,H\u0002J\u001a\u0010b\u001a\u00020,2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010g\u001a\u00020,H\u0002J\u0010\u0010h\u001a\u00020,2\u0006\u0010i\u001a\u00020\u0004H\u0002J\b\u0010j\u001a\u00020,H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010!\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0011\u0010#\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00102\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\u0019R\u001a\u00105\u001a\u000206X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020<8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u001a\u0010A\u001a\u00020BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0015\"\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020L\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0015\"\u0004\bQ\u0010JR\u001a\u0010R\u001a\u00020SX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020YX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0011\u0010^\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0015\u00a8\u0006k"}, d2 = {"Lcom/example/android/newsbit/ui/fragments/SourceNewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "btnRetry", "Landroid/widget/Button;", "getBtnRetry", "()Landroid/widget/Button;", "setBtnRetry", "(Landroid/widget/Button;)V", "date", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getDate", "()Ljava/util/Calendar;", "day", "", "getDay", "()I", "from", "getFrom", "setFrom", "(Ljava/lang/String;)V", "isError", "", "()Z", "setError", "(Z)V", "isLoading", "setLoading", "isScrolling", "setScrolling", "month", "getMonth", "paginationProgressBarView", "Landroid/widget/ProgressBar;", "getPaginationProgressBarView", "()Landroid/widget/ProgressBar;", "setPaginationProgressBarView", "(Landroid/widget/ProgressBar;)V", "previous", "", "getPrevious", "()Lkotlin/Unit;", "setPrevious", "(Lkotlin/Unit;)V", "Lkotlin/Unit;", "sourceId", "getSourceId", "setSourceId", "sourceNewsAdapter", "Lcom/example/android/newsbit/adapters/NewsAdapter;", "getSourceNewsAdapter", "()Lcom/example/android/newsbit/adapters/NewsAdapter;", "setSourceNewsAdapter", "(Lcom/example/android/newsbit/adapters/NewsAdapter;)V", "sourceNewsArgs", "Lcom/example/android/newsbit/ui/fragments/SourceNewsFragmentArgs;", "getSourceNewsArgs", "()Lcom/example/android/newsbit/ui/fragments/SourceNewsFragmentArgs;", "sourceNewsArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "sourceNewsItemView", "Landroidx/recyclerview/widget/RecyclerView;", "getSourceNewsItemView", "()Landroidx/recyclerview/widget/RecyclerView;", "setSourceNewsItemView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "sourceNewsPageTemp", "getSourceNewsPageTemp", "setSourceNewsPageTemp", "(I)V", "sourceNewsScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getSourceNewsScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "totalResults", "getTotalResults", "setTotalResults", "tvErrorMessage", "Landroid/widget/TextView;", "getTvErrorMessage", "()Landroid/widget/TextView;", "setTvErrorMessage", "(Landroid/widget/TextView;)V", "viewModel", "Lcom/example/android/newsbit/ui/NewsViewModel;", "getViewModel", "()Lcom/example/android/newsbit/ui/NewsViewModel;", "setViewModel", "(Lcom/example/android/newsbit/ui/NewsViewModel;)V", "year", "getYear", "hideErrorMessage", "hideProgressBar", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "showErrorMessage", "message", "showProgressBar", "app_debug"})
public final class SourceNewsFragment extends androidx.fragment.app.Fragment {
    public com.example.android.newsbit.ui.NewsViewModel viewModel;
    public com.example.android.newsbit.adapters.NewsAdapter sourceNewsAdapter;
    public androidx.recyclerview.widget.RecyclerView sourceNewsItemView;
    public android.widget.ProgressBar paginationProgressBarView;
    public android.widget.Button btnRetry;
    public android.widget.TextView tvErrorMessage;
    private int totalResults = 0;
    private boolean isError = false;
    private boolean isLoading = false;
    private boolean isScrolling = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy sourceNewsArgs$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sourceId = "the-hindu";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "SourceNewsFragment";
    private int sourceNewsPageTemp = 1;
    private final java.util.Calendar date = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.Unit previous;
    private final int year = 0;
    private final int month = 0;
    private final int day = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String from;
    @org.jetbrains.annotations.NotNull()
    private final androidx.recyclerview.widget.RecyclerView.OnScrollListener sourceNewsScrollListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public SourceNewsFragment() {
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
    public final com.example.android.newsbit.adapters.NewsAdapter getSourceNewsAdapter() {
        return null;
    }
    
    public final void setSourceNewsAdapter(@org.jetbrains.annotations.NotNull()
    com.example.android.newsbit.adapters.NewsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getSourceNewsItemView() {
        return null;
    }
    
    public final void setSourceNewsItemView(@org.jetbrains.annotations.NotNull()
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
    
    public final int getTotalResults() {
        return 0;
    }
    
    public final void setTotalResults(int p0) {
    }
    
    public final boolean isError() {
        return false;
    }
    
    public final void setError(boolean p0) {
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
    public final com.example.android.newsbit.ui.fragments.SourceNewsFragmentArgs getSourceNewsArgs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSourceId() {
        return null;
    }
    
    public final void setSourceId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final int getSourceNewsPageTemp() {
        return 0;
    }
    
    public final void setSourceNewsPageTemp(int p0) {
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
    public final androidx.recyclerview.widget.RecyclerView.OnScrollListener getSourceNewsScrollListener() {
        return null;
    }
    
    private final void setupRecyclerView() {
    }
}