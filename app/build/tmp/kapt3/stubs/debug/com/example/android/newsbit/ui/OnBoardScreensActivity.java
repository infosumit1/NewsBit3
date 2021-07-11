package com.example.android.newsbit.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020+H\u0002J\u0016\u00101\u001a\u00020+2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u00065"}, d2 = {"Lcom/example/android/newsbit/ui/OnBoardScreensActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "nextText", "Landroid/widget/TextView;", "getNextText", "()Landroid/widget/TextView;", "setNextText", "(Landroid/widget/TextView;)V", "onBoardingViewPager", "Landroidx/viewpager/widget/ViewPager;", "getOnBoardingViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setOnBoardingViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "previousText", "getPreviousText", "setPreviousText", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "viewPagerAdapter", "Lcom/example/android/newsbit/adapters/ViewPagerAdapter;", "getViewPagerAdapter", "()Lcom/example/android/newsbit/adapters/ViewPagerAdapter;", "setViewPagerAdapter", "(Lcom/example/android/newsbit/adapters/ViewPagerAdapter;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "restorePrefData", "", "savePrefData", "setOnBoardingViewPagerAdapter", "onBoardingScreens", "", "Lcom/example/android/newsbit/models/OnBoardingScreens;", "app_debug"})
public final class OnBoardScreensActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private com.example.android.newsbit.adapters.ViewPagerAdapter viewPagerAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.material.tabs.TabLayout tabLayout;
    @org.jetbrains.annotations.Nullable()
    private androidx.viewpager.widget.ViewPager onBoardingViewPager;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView nextText;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView previousText;
    private int position = 0;
    public android.content.SharedPreferences sharedPreferences;
    private java.util.HashMap _$_findViewCache;
    
    public OnBoardScreensActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.android.newsbit.adapters.ViewPagerAdapter getViewPagerAdapter() {
        return null;
    }
    
    public final void setViewPagerAdapter(@org.jetbrains.annotations.Nullable()
    com.example.android.newsbit.adapters.ViewPagerAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.material.tabs.TabLayout getTabLayout() {
        return null;
    }
    
    public final void setTabLayout(@org.jetbrains.annotations.Nullable()
    com.google.android.material.tabs.TabLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.viewpager.widget.ViewPager getOnBoardingViewPager() {
        return null;
    }
    
    public final void setOnBoardingViewPager(@org.jetbrains.annotations.Nullable()
    androidx.viewpager.widget.ViewPager p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getNextText() {
        return null;
    }
    
    public final void setNextText(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getPreviousText() {
        return null;
    }
    
    public final void setPreviousText(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    public final int getPosition() {
        return 0;
    }
    
    public final void setPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setOnBoardingViewPagerAdapter(java.util.List<com.example.android.newsbit.models.OnBoardingScreens> onBoardingScreens) {
    }
    
    private final void savePrefData() {
    }
    
    private final boolean restorePrefData() {
        return false;
    }
}