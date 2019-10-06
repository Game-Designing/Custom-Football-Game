package com.google.android.gms.internal.ads;

import android.support.p001v7.widget.LinearLayoutManager;

public class zzmy {

    /* renamed from: a */
    private int f28927a;

    /* renamed from: a */
    public void mo32012a() {
        this.f28927a = 0;
    }

    /* renamed from: b */
    public final boolean mo32015b() {
        return mo32017c(LinearLayoutManager.INVALID_OFFSET);
    }

    /* renamed from: c */
    public final boolean mo32016c() {
        return mo32017c(4);
    }

    /* renamed from: d */
    public final boolean mo32018d() {
        return mo32017c(1);
    }

    /* renamed from: a */
    public final void mo32013a(int i) {
        this.f28927a = i;
    }

    /* renamed from: b */
    public final void mo32014b(int i) {
        this.f28927a |= LinearLayoutManager.INVALID_OFFSET;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final boolean mo32017c(int i) {
        return (this.f28927a & i) == i;
    }
}
