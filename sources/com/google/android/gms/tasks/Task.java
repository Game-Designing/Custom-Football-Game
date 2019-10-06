package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

public abstract class Task<TResult> {
    /* renamed from: a */
    public abstract Task<TResult> mo33174a(OnSuccessListener<? super TResult> onSuccessListener);

    /* renamed from: a */
    public abstract Exception mo33176a();

    /* renamed from: b */
    public abstract TResult mo33177b();

    /* renamed from: c */
    public abstract boolean mo33178c();

    /* renamed from: d */
    public abstract boolean mo33179d();

    /* renamed from: a */
    public Task<TResult> mo33173a(OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    /* renamed from: a */
    public Task<TResult> mo33175a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }
}
