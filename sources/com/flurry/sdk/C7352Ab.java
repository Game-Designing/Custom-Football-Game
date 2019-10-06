package com.flurry.sdk;

import android.os.SystemClock;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.Ab */
class C7352Ab implements C7452Sb<C7537id> {

    /* renamed from: a */
    final /* synthetic */ C7374Eb f14363a;

    C7352Ab(C7374Eb eb) {
        this.f14363a = eb;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23509a(C7447Rb rb) {
        C7537id idVar = (C7537id) rb;
        if (this.f14363a.f14414b == null || idVar.f14884c == this.f14363a.f14414b.get()) {
            int i = C7367Db.f14389a[idVar.f14885d - 1];
            if (i == 1) {
                C7374Eb eb = this.f14363a;
                C7531hd hdVar = idVar.f14884c;
                idVar.f14883b.get();
                eb.f14414b = new WeakReference<>(hdVar);
                eb.f14415c = System.currentTimeMillis();
                eb.f14416d = SystemClock.elapsedRealtime();
                C7379Fb.m16300a().mo23817b(new C7362Cb(eb));
            } else if (i == 2) {
                C7374Eb eb2 = this.f14363a;
                idVar.f14883b.get();
                eb2.mo23807a();
            } else if (i == 3) {
                C7374Eb eb3 = this.f14363a;
                idVar.f14883b.get();
                eb3.f14417e = SystemClock.elapsedRealtime() - eb3.f14416d;
            } else if (i == 4) {
                C7462Ub.m16528a().mo23911b("com.flurry.android.sdk.FlurrySessionEvent", this.f14363a.f14419g);
            }
        }
    }
}
