package com.flurry.sdk;

import com.flurry.sdk.C7554lc.C7555a;

/* renamed from: com.flurry.sdk.fa */
class C7516fa implements C7555a<byte[], Void> {

    /* renamed from: a */
    final /* synthetic */ C7523ga f14828a;

    C7516fa(C7523ga gaVar) {
        this.f14828a = gaVar;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23837a(C7554lc lcVar, Object obj) {
        int i = lcVar.f15017x;
        if (i <= 0) {
            C7513ec.m16651d(C7523ga.f14851a, "Server Error: ".concat(String.valueOf(i)));
        } else if (i < 200 || i >= 300) {
            C7513ec.m16639a(3, C7523ga.f14851a, "Pulse logging report sent unsuccessfully, HTTP response:".concat(String.valueOf(i)));
        } else {
            C7513ec.m16639a(3, C7523ga.f14851a, "Pulse logging report sent successfully HTTP response:".concat(String.valueOf(i)));
            this.f14828a.f14855e.clear();
            this.f14828a.f14854d.mo23882a(this.f14828a.f14855e);
        }
    }
}
