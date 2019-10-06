package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public class DataHolderResult implements Releasable, Result {
    @KeepForSdk

    /* renamed from: a */
    protected final Status f19638a;
    @KeepForSdk

    /* renamed from: b */
    protected final DataHolder f19639b;

    @KeepForSdk
    public Status getStatus() {
        return this.f19638a;
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27353a() {
        DataHolder dataHolder = this.f19639b;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
