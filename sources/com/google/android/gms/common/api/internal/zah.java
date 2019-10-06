package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zah extends C8648M<Boolean> {

    /* renamed from: c */
    private final ListenerKey<?> f19891c;

    public zah(ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f19891c = listenerKey;
    }

    /* renamed from: d */
    public final void mo27535d(zaa<?> zaa) throws RemoteException {
        zabw zabw = (zabw) zaa.mo27499i().remove(this.f19891c);
        if (zabw != null) {
            zabw.f19863b.mo27564a(zaa.mo27496f(), this.f19703b);
            zabw.f19862a.mo27541a();
            return;
        }
        this.f19703b.mo33184b(Boolean.valueOf(false));
    }

    /* renamed from: b */
    public final Feature[] mo27614b(zaa<?> zaa) {
        zabw zabw = (zabw) zaa.mo27499i().get(this.f19891c);
        if (zabw == null) {
            return null;
        }
        return zabw.f19862a.mo27544c();
    }

    /* renamed from: c */
    public final boolean mo27615c(zaa<?> zaa) {
        zabw zabw = (zabw) zaa.mo27499i().get(this.f19891c);
        return zabw != null && zabw.f19862a.mo27545d();
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
