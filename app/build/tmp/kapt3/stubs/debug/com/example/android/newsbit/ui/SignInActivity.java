package com.example.android.newsbit.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\'\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/example/android/newsbit/ui/SignInActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "callbacks", "Lcom/google/firebase/auth/PhoneAuthProvider$OnVerificationStateChangedCallbacks;", "codeSent", "", "credential", "Lcom/google/firebase/auth/PhoneAuthCredential;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "phoneNo", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "checkValidPhnNumber", "", "phnNumber", "firebaseAuthWithGoogle", "", "idToken", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "otpSentEnableView", "restorePrefData", "savePrefData", "sendVerificationcode", "phoneNumber", "signIn", "signInWithPhoneAuthCredential", "signwithPhoneNumber", "startOTPTimer", "Companion", "app_debug"})
public final class SignInActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.android.newsbit.ui.SignInActivity.Companion Companion = null;
    private static final int RC_SIGN_IN = 120;
    public android.content.SharedPreferences sharedPreferences;
    private java.lang.String codeSent = "";
    private com.google.firebase.auth.PhoneAuthCredential credential;
    private com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient;
    private java.lang.String phoneNo = "";
    private java.util.HashMap _$_findViewCache;
    
    public SignInActivity() {
        super();
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
    
    private final void otpSentEnableView() {
    }
    
    private final boolean checkValidPhnNumber(java.lang.String phnNumber) {
        return false;
    }
    
    private final void signwithPhoneNumber() {
    }
    
    private final void sendVerificationcode(java.lang.String phoneNumber) {
    }
    
    private final void signIn() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void firebaseAuthWithGoogle(java.lang.String idToken) {
    }
    
    private final void startOTPTimer() {
    }
    
    private final void signInWithPhoneAuthCredential(com.google.firebase.auth.PhoneAuthCredential credential) {
    }
    
    private final boolean restorePrefData() {
        return false;
    }
    
    private final void savePrefData() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/android/newsbit/ui/SignInActivity$Companion;", "", "()V", "RC_SIGN_IN", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}