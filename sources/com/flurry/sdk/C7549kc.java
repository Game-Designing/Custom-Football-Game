package com.flurry.sdk;

import com.flurry.sdk.C7577pc.C7579b;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.kc */
class C7549kc implements C7579b {

    /* renamed from: a */
    final /* synthetic */ C7554lc f14923a;

    C7549kc(C7554lc lcVar) {
        this.f14923a = lcVar;
    }

    /* renamed from: a */
    public final void mo23975a(OutputStream outputStream) throws Exception {
        if (this.f14923a.f14935D != null && this.f14923a.f14937F != null) {
            this.f14923a.f14937F.mo23856a(outputStream, this.f14923a.f14935D);
        }
    }

    /* renamed from: a */
    public final void mo23974a(C7577pc pcVar, InputStream inputStream) throws Exception {
        if (pcVar.mo23991e() && this.f14923a.f14938G != null) {
            C7554lc lcVar = this.f14923a;
            lcVar.f14936E = lcVar.f14938G.mo23855a(inputStream);
        }
    }

    /* renamed from: a */
    public final void mo23973a() {
        C7554lc.m16735d(this.f14923a);
    }
}
