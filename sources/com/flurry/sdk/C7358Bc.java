package com.flurry.sdk;

/* renamed from: com.flurry.sdk.Bc */
class C7358Bc implements C7452Sb<C7553lb> {

    /* renamed from: a */
    final /* synthetic */ C7390Hc f14378a;

    C7358Bc(C7390Hc hc) {
        this.f14378a = hc;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23509a(C7447Rb rb) {
        C7553lb lbVar = (C7553lb) rb;
        String str = this.f14378a.f14482a;
        StringBuilder sb = new StringBuilder("onNetworkStateChanged : isNetworkEnable = ");
        sb.append(lbVar.f14932b);
        C7513ec.m16639a(4, str, sb.toString());
        if (lbVar.f14932b) {
            this.f14378a.mo23832c();
        }
    }
}
