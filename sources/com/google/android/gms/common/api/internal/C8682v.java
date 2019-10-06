package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.internal.v */
final class C8682v extends zabr {

    /* renamed from: a */
    private WeakReference<zaaw> f19779a;

    C8682v(zaaw zaaw) {
        this.f19779a = new WeakReference<>(zaaw);
    }

    /* renamed from: a */
    public final void mo27539a() {
        zaaw zaaw = (zaaw) this.f19779a.get();
        if (zaaw != null) {
            zaaw.m21491o();
        }
    }
}
