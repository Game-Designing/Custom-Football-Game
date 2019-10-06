package com.flurry.sdk;

import android.app.Activity;

/* renamed from: com.flurry.sdk.kd */
class C7550kd implements C7452Sb<C7395Ib> {

    /* renamed from: a */
    final /* synthetic */ C7585qd f14924a;

    C7550kd(C7585qd qdVar) {
        this.f14924a = qdVar;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23509a(C7447Rb rb) {
        C7395Ib ib = (C7395Ib) rb;
        Activity activity = (Activity) ib.f14499b.get();
        if (activity == null) {
            C7513ec.m16641a(C7585qd.f15036a, "Activity has been destroyed, can't pass ActivityLifecycleEvent to adobject.");
            return;
        }
        int i = C7580pd.f15027a[ib.f14500c - 1];
        if (i == 1) {
            String e = C7585qd.f15036a;
            StringBuilder sb = new StringBuilder("Automatic onStartSession for context:");
            sb.append(ib.f14499b);
            C7513ec.m16639a(3, e, sb.toString());
            this.f14924a.m16793e(activity);
        } else if (i != 2) {
            if (i == 3) {
                String e2 = C7585qd.f15036a;
                StringBuilder sb2 = new StringBuilder("Automatic onEndSession (destroyed) for context:");
                sb2.append(ib.f14499b);
                C7513ec.m16639a(3, e2, sb2.toString());
                this.f14924a.mo24007d(activity);
            }
        } else {
            String e3 = C7585qd.f15036a;
            StringBuilder sb3 = new StringBuilder("Automatic onEndSession for context:");
            sb3.append(ib.f14499b);
            C7513ec.m16639a(3, e3, sb3.toString());
            this.f14924a.mo24007d(activity);
        }
    }
}
