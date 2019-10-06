package com.flurry.sdk;

/* renamed from: com.flurry.sdk.U */
class C7460U implements C7452Sb<C7553lb> {

    /* renamed from: a */
    final /* synthetic */ C7490aa f14669a;

    C7460U(C7490aa aaVar) {
        this.f14669a = aaVar;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23509a(C7447Rb rb) {
        C7553lb lbVar = (C7553lb) rb;
        String str = C7490aa.f14738a;
        StringBuilder sb = new StringBuilder("onNetworkStateChanged : isNetworkEnable = ");
        sb.append(lbVar.f14932b);
        C7513ec.m16639a(4, str, sb.toString());
        if (lbVar.f14932b) {
            C7379Fb.m16300a().mo23817b(new C7455T(this));
        }
    }
}
