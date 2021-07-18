package com.example.android.newsbit.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u001b\u001a\u00020\u001c2\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J*\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\n\b\u0001\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J\u001a\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\'\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/example/android/newsbit/ui/fragments/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "isNight", "", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mainActivity", "Lcom/example/android/newsbit/ui/MainActivity;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "switchButton", "Landroidx/appcompat/widget/SwitchCompat;", "getSwitchButton", "()Landroidx/appcompat/widget/SwitchCompat;", "setSwitchButton", "(Landroidx/appcompat/widget/SwitchCompat;)V", "theme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "restorePrefData", "savePrefData", "b", "signOut", "app_debug"})
public final class SettingsFragment extends androidx.fragment.app.Fragment {
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private com.google.firebase.auth.FirebaseUser currentUser;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient;
    private com.example.android.newsbit.ui.MainActivity mainActivity;
    private int theme = 0;
    private boolean isNight = false;
    public androidx.appcompat.widget.SwitchCompat switchButton;
    public android.content.SharedPreferences sharedPreferences;
    private java.util.HashMap _$_findViewCache;
    
    public SettingsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.widget.SwitchCompat getSwitchButton() {
        return null;
    }
    
    public final void setSwitchButton(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.SwitchCompat p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void signOut() {
    }
    
    private final void savePrefData(boolean b) {
    }
    
    private final boolean restorePrefData() {
        return false;
    }
}