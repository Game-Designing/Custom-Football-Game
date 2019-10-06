package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* renamed from: com.google.android.gms.common.api.internal.N */
final class C8649N {

    /* renamed from: a */
    private final int f19704a;

    /* renamed from: b */
    private final ConnectionResult f19705b;

    C8649N(ConnectionResult connectionResult, int i) {
        Preconditions.m21857a(connectionResult);
        this.f19705b = connectionResult;
        this.f19704a = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final int mo27537b() {
        return this.f19704a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final ConnectionResult mo27536a() {
        return this.f19705b;
    }
}
