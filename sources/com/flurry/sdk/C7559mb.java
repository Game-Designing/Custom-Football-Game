package com.flurry.sdk;

import android.app.Activity;

/* renamed from: com.flurry.sdk.mb */
class C7559mb implements C7452Sb<C7395Ib> {

    /* renamed from: a */
    final /* synthetic */ C7570ob f14943a;

    C7559mb(C7570ob obVar) {
        this.f14943a = obVar;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23509a(C7447Rb rb) {
        C7395Ib ib = (C7395Ib) rb;
        Activity activity = (Activity) ib.f14499b.get();
        if (activity == null) {
            C7513ec.m16639a(3, C7570ob.f14968a, "Activity has been destroyed, don't update network state.");
            return;
        }
        if (C7565nb.f14962a[ib.f14500c - 1] == 1) {
            C7570ob obVar = this.f14943a;
            obVar.f14971d = obVar.m16756a(activity);
        }
    }
}
