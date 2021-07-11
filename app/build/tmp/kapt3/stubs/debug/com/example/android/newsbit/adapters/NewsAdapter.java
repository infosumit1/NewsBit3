package com.example.android.newsbit.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u000e2\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rJ\u001a\u0010\u001b\u001a\u00020\u000e2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rR\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/android/newsbit/adapters/NewsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/android/newsbit/adapters/NewsAdapter$NewsViewHolder;", "()V", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/example/android/newsbit/models/Article;", "kotlin.jvm.PlatformType", "getDiffer", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "differCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "onBookmarkClickListener", "Lkotlin/Function1;", "", "onItemClickListener", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnBookmarkClickListener", "listener", "setOnItemClickListener", "NewsViewHolder", "app_debug"})
public final class NewsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.android.newsbit.adapters.NewsAdapter.NewsViewHolder> {
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.android.newsbit.models.Article> differCallback = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.recyclerview.widget.AsyncListDiffer<com.example.android.newsbit.models.Article> differ = null;
    private kotlin.jvm.functions.Function1<? super com.example.android.newsbit.models.Article, kotlin.Unit> onItemClickListener;
    private kotlin.jvm.functions.Function1<? super com.example.android.newsbit.models.Article, kotlin.Unit> onBookmarkClickListener;
    
    public NewsAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.AsyncListDiffer<com.example.android.newsbit.models.Article> getDiffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.android.newsbit.adapters.NewsAdapter.NewsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.android.newsbit.adapters.NewsAdapter.NewsViewHolder holder, int position) {
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.android.newsbit.models.Article, kotlin.Unit> listener) {
    }
    
    public final void setOnBookmarkClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.android.newsbit.models.Article, kotlin.Unit> listener) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/example/android/newsbit/adapters/NewsAdapter$NewsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/android/newsbit/adapters/NewsAdapter;Landroid/view/View;)V", "bookmarkBtn", "Landroid/widget/Button;", "getBookmarkBtn", "()Landroid/widget/Button;", "descriptionView", "Landroid/widget/TextView;", "getDescriptionView", "()Landroid/widget/TextView;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "sourceView", "getSourceView", "titleView", "getTitleView", "app_debug"})
    public final class NewsViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView titleView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView descriptionView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView sourceView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.Button bookmarkBtn = null;
        
        public NewsViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTitleView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getDescriptionView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getSourceView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImageView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Button getBookmarkBtn() {
            return null;
        }
    }
}