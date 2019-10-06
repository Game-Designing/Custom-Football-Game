package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends AnyClient, L> {

    /* renamed from: a */
    private final ListenerHolder<L> f19711a;

    /* renamed from: b */
    private final Feature[] f19712b;

    /* renamed from: c */
    private final boolean f19713c;

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public abstract void mo27542a(A a, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    /* renamed from: b */
    public ListenerKey<L> mo27543b() {
        return this.f19711a.mo27528b();
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27541a() {
        this.f19711a.mo27526a();
    }

    @KeepForSdk
    /* renamed from: c */
    public Feature[] mo27544c() {
        return this.f19712b;
    }

    /* renamed from: d */
    public final boolean mo27545d() {
        return this.f19713c;
    }
}
