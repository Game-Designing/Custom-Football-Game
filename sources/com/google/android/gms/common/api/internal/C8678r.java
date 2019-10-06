package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.common.api.internal.r */
final class C8678r implements ConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f19770a;

    /* renamed from: b */
    private final /* synthetic */ StatusPendingResult f19771b;

    /* renamed from: c */
    private final /* synthetic */ zaaw f19772c;

    C8678r(zaaw zaaw, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.f19772c = zaaw;
        this.f19770a = atomicReference;
        this.f19771b = statusPendingResult;
    }

    public final void onConnected(Bundle bundle) {
        this.f19772c.m21484a((GoogleApiClient) this.f19770a.get(), this.f19771b, true);
    }

    public final void onConnectionSuspended(int i) {
    }
}
