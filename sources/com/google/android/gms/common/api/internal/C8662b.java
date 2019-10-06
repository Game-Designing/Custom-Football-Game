package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.common.api.internal.b */
final class C8662b implements StatusListener {

    /* renamed from: a */
    private final /* synthetic */ BasePendingResult f19745a;

    /* renamed from: b */
    private final /* synthetic */ zaab f19746b;

    C8662b(zaab zaab, BasePendingResult basePendingResult) {
        this.f19746b = zaab;
        this.f19745a = basePendingResult;
    }

    /* renamed from: a */
    public final void mo27403a(Status status) {
        this.f19746b.f19784a.remove(this.f19745a);
    }
}
