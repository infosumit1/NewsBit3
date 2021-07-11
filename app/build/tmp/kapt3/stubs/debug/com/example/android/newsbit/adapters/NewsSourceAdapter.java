package com.example.android.newsbit.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000b2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001a\u0010\u0015\u001a\u00020\u000b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/android/newsbit/adapters/NewsSourceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/android/newsbit/adapters/NewsSourceAdapter$NewsSourceViewHolder;", "newsSources", "", "Lcom/example/android/newsbit/models/NewsSource;", "(Ljava/util/List;)V", "getNewsSources", "()Ljava/util/List;", "onItemClickListener", "Lkotlin/Function1;", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "listener", "NewsSourceViewHolder", "app_debug"})
public final class NewsSourceAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.android.newsbit.adapters.NewsSourceAdapter.NewsSourceViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.android.newsbit.models.NewsSource> newsSources = null;
    private kotlin.jvm.functions.Function1<? super com.example.android.newsbit.models.NewsSource, kotlin.Unit> onItemClickListener;
    
    public NewsSourceAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.android.newsbit.models.NewsSource> newsSources) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.android.newsbit.models.NewsSource> getNewsSources() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.android.newsbit.adapters.NewsSourceAdapter.NewsSourceViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.android.newsbit.adapters.NewsSourceAdapter.NewsSourceViewHolder holder, int position) {
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.android.newsbit.models.NewsSource, kotlin.Unit> listener) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/android/newsbit/adapters/NewsSourceAdapter$NewsSourceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/android/newsbit/adapters/NewsSourceAdapter;Landroid/view/View;)V", "newsSourceImageView", "Landroid/widget/ImageView;", "getNewsSourceImageView", "()Landroid/widget/ImageView;", "newsSourceNameView", "Landroid/widget/TextView;", "getNewsSourceNameView", "()Landroid/widget/TextView;", "app_debug"})
    public final class NewsSourceViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView newsSourceImageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView newsSourceNameView = null;
        
        public NewsSourceViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getNewsSourceImageView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getNewsSourceNameView() {
            return null;
        }
    }
}