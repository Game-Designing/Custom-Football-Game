package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;

public final class zaf extends C8648M<Void> {

    /* renamed from: c */
    private final RegisterListenerMethod<AnyClient, ?> f19886c;

    /* renamed from: d */
    private final UnregisterListenerMethod<AnyClient, ?> f19887d;

    /* renamed from: d */
    public final void mo27535d(zaa<?> zaa) throws RemoteException {
        this.f19886c.mo27542a(zaa.mo27496f(), this.f19703b);
        if (this.f19886c.mo27543b() != null) {
            zaa.mo27499i().put(this.f19886c.mo27543b(), new zabw(this.f19886c, this.f19887d));
        }
    }

    /* renamed from: b */
    public final Feature[] mo27614b(zaa<?> zaa) {
        return this.f19886c.mo27544c();
    }

    /* renamed from: c */
    public final boolean mo27615c(zaa<?> zaa) {
        return this.f19886c.mo27545d();
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo27604a(zaab zaab, boolean z) {
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo27534a(RuntimeException runtimeException) {
        super.mo27534a(runtimeException);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo27532a(Status status) {
        super.mo27532a(status);
    }
}
