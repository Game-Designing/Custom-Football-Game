package com.flurry.sdk;

import java.util.Map;

/* renamed from: com.flurry.sdk.Sa */
class C7451Sa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f14653a;

    /* renamed from: b */
    final /* synthetic */ Map f14654b;

    /* renamed from: c */
    final /* synthetic */ C7461Ua f14655c;

    C7451Sa(C7461Ua ua, String str, Map map) {
        this.f14655c = ua;
        this.f14653a = str;
        this.f14654b = map;
    }

    public final void run() {
        C7449Rd.m16479a().f14637b.mo23821a(this.f14653a, this.f14654b);
    }
}
