package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class TaskApiCall<A extends AnyClient, ResultT> {

    /* renamed from: a */
    private final Feature[] f19731a = null;

    /* renamed from: b */
    private final boolean f19732b = false;

    @KeepForSdk
    public static class Builder<A extends AnyClient, ResultT> {

        /* renamed from: a */
        private boolean f19733a = true;

        private Builder() {
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public abstract void mo27558a(A a, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    /* renamed from: b */
    public final Feature[] mo27560b() {
        return this.f19731a;
    }

    @KeepForSdk
    /* renamed from: a */
    public boolean mo27559a() {
        return this.f19732b;
    }
}
