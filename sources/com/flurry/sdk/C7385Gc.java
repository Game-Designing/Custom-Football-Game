package com.flurry.sdk;

/* renamed from: com.flurry.sdk.Gc */
public class C7385Gc extends C7364Cd {

    /* renamed from: d */
    final /* synthetic */ String f14465d;

    /* renamed from: e */
    final /* synthetic */ C7390Hc f14466e;

    public C7385Gc(C7390Hc hc, String str) {
        this.f14466e = hc;
        this.f14465d = str;
    }

    /* renamed from: a */
    public final void mo23803a() {
        if (!this.f14466e.f14484c.remove(this.f14465d)) {
            String str = this.f14466e.f14482a;
            StringBuilder sb = new StringBuilder("Internal error. Block with id = ");
            sb.append(this.f14465d);
            sb.append(" was not in progress state");
            C7513ec.m16639a(6, str, sb.toString());
        }
    }
}
