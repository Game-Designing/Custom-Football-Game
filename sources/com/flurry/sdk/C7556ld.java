package com.flurry.sdk;

import android.content.Context;

/* renamed from: com.flurry.sdk.ld */
class C7556ld implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f14939a;

    /* renamed from: b */
    final /* synthetic */ C7585qd f14940b;

    C7556ld(C7585qd qdVar, Context context) {
        this.f14940b = qdVar;
        this.f14939a = context;
    }

    public final void run() {
        this.f14940b.m16793e(this.f14939a);
    }
}
