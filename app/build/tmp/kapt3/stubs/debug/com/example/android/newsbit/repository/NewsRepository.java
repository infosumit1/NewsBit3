package com.example.android.newsbit.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00180\u0017J7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J7\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J/\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/example/android/newsbit/repository/NewsRepository;", "", "db", "Lcom/example/android/newsbit/db/ArticleDatabase;", "(Lcom/example/android/newsbit/db/ArticleDatabase;)V", "getDb", "()Lcom/example/android/newsbit/db/ArticleDatabase;", "deleteArticle", "", "article", "Lcom/example/android/newsbit/models/Article;", "(Lcom/example/android/newsbit/models/Article;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomCategoryNews", "Lretrofit2/Response;", "Lcom/example/android/newsbit/models/NewsResponse;", "q", "", "language", "from", "pageNumber", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSavedNews", "Landroidx/lifecycle/LiveData;", "", "getSearchedNews", "getSourceNews", "sources", "getTopNews", "countryCode", "category", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsert", "", "app_debug"})
public final class NewsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.android.newsbit.db.ArticleDatabase db = null;
    
    public NewsRepository(@org.jetbrains.annotations.NotNull()
    com.example.android.newsbit.db.ArticleDatabase db) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.android.newsbit.db.ArticleDatabase getDb() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopNews(@org.jetbrains.annotations.NotNull()
    java.lang.String countryCode, @org.jetbrains.annotations.NotNull()
    java.lang.String category, int pageNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.android.newsbit.models.NewsResponse>> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCustomCategoryNews(@org.jetbrains.annotations.NotNull()
    java.lang.String q, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.String from, int pageNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.android.newsbit.models.NewsResponse>> p4) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSourceNews(@org.jetbrains.annotations.NotNull()
    java.lang.String sources, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.String from, int pageNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.android.newsbit.models.NewsResponse>> p4) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSearchedNews(@org.jetbrains.annotations.NotNull()
    java.lang.String q, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.String from, int pageNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.android.newsbit.models.NewsResponse>> p4) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object upsert(@org.jetbrains.annotations.NotNull()
    com.example.android.newsbit.models.Article article, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.android.newsbit.models.Article>> getSavedNews() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteArticle(@org.jetbrains.annotations.NotNull()
    com.example.android.newsbit.models.Article article, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
}