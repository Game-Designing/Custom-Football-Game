package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.p179l.C7930d;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.mraid.m */
final class C7964m extends C7950a {
    C7964m(Map<String, String> map, C7930d dVar) {
        super(map, dVar);
    }

    /* renamed from: a */
    public final void mo24813a() {
        int a = mo24812a("w");
        int a2 = mo24812a("h");
        int a3 = mo24812a("offsetX");
        int a4 = mo24812a("offsetY");
        boolean c = mo24816c("allowOffscreen");
        mo24814b("customClosePosition");
        if (a <= 0) {
            a = this.f16231c.f16167D;
        }
        int i = a;
        if (a2 <= 0) {
            a2 = this.f16231c.f16168E;
        }
        this.f16231c.mo24769a(i, a2, a3, a4, c);
    }
}
