package com.flurry.sdk;

/* renamed from: com.flurry.sdk.Fc */
class C7380Fc extends C7364Cd {

    /* renamed from: d */
    final /* synthetic */ String f14438d;

    /* renamed from: e */
    final /* synthetic */ String f14439e;

    /* renamed from: f */
    final /* synthetic */ C7390Hc f14440f;

    C7380Fc(C7390Hc hc, String str, String str2) {
        this.f14440f = hc;
        this.f14438d = str;
        this.f14439e = str2;
    }

    /* renamed from: a */
    public final void mo23803a() {
        if (!this.f14440f.f14485d.mo23888a(this.f14438d, this.f14439e)) {
            String str = this.f14440f.f14482a;
            StringBuilder sb = new StringBuilder("Internal error. Block wasn't deleted with id = ");
            sb.append(this.f14438d);
            C7513ec.m16639a(6, str, sb.toString());
        }
        if (!this.f14440f.f14484c.remove(this.f14438d)) {
            String str2 = this.f14440f.f14482a;
            StringBuilder sb2 = new StringBuilder("Internal error. Block with id = ");
            sb2.append(this.f14438d);
            sb2.append(" was not in progress state");
            C7513ec.m16639a(6, str2, sb2.toString());
        }
    }
}
