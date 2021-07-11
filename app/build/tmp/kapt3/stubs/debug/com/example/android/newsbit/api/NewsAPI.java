package com.example.android.newsbit.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001JS\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJS\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u00062\b\b\u0003\u0010\u0011\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/android/newsbit/api/NewsAPI;", "", "getCustomCategoryNews", "Lretrofit2/Response;", "Lcom/example/android/newsbit/models/NewsResponse;", "query", "", "sources", "language", "from", "pageNumber", "", "apiKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchedNews", "getTopNews", "countryCode", "category", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface NewsAPI {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v2/top-headlines")
    public abstract java.lang.Object getTopNews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "country")
    java.lang.String countryCode, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "category")
    java.lang.String category, @retrofit2.http.Query(value = "page")
    int pageNumber, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.android.newsbit.models.NewsResponse>> p4);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v2/everything")
    public abstract java.lang.Object getCustomCategoryNews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sources")
    java.lang.String sources, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "from")
    java.lang.String from, @retrofit2.http.Query(value = "page")
    int pageNumber, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.android.newsbit.models.NewsResponse>> p6);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v2/everything")
    public abstract java.lang.Object getSearchedNews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sources")
    java.lang.String sources, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "from")
    java.lang.String from, @retrofit2.http.Query(value = "page")
    int pageNumber, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.android.newsbit.models.NewsResponse>> p6);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}