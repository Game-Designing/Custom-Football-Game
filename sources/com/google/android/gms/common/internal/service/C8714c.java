package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

/* renamed from: com.google.android.gms.common.internal.service.c */
final class C8714c extends zaa {

    /* renamed from: b */
    private final ResultHolder<Status> f20172b;

    public C8714c(ResultHolder<Status> resultHolder) {
        this.f20172b = resultHolder;
    }

    /* renamed from: k */
    public final void mo27846k(int i) throws RemoteException {
        this.f20172b.mo27445a(new Status(i));
    }
}
