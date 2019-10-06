package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;

public final class zae<A extends ApiMethodImpl<? extends Result, AnyClient>> extends zab {

    /* renamed from: b */
    private final A f19885b;

    public zae(int i, A a) {
        super(i);
        this.f19885b = a;
    }

    /* renamed from: a */
    public final void mo27533a(zaa<?> zaa) throws DeadObjectException {
        try {
            this.f19885b.mo27446b(zaa.mo27496f());
        } catch (RuntimeException e) {
            mo27534a(e);
        }
    }

    /* renamed from: a */
    public final void mo27532a(Status status) {
        this.f19885b.mo27448c(status);
    }

    /* renamed from: a */
    public final void mo27534a(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.f19885b.mo27448c(new Status(10, sb.toString()));
    }

    /* renamed from: a */
    public final void mo27604a(zaab zaab, boolean z) {
        zaab.mo27581a((BasePendingResult<? extends Result>) this.f19885b, z);
    }
}
