package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.IStatusCallback.Stub;

@KeepForSdk
public class StatusCallback extends Stub {
    @KeepForSdk

    /* renamed from: b */
    private final ResultHolder<Status> f19729b;

    @KeepForSdk
    /* renamed from: i */
    public void mo27505i(Status status) {
        this.f19729b.mo27445a(status);
    }
}
