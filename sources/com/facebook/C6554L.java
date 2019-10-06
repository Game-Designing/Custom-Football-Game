package com.facebook;

import com.facebook.GraphRequest.C6548e;

/* renamed from: com.facebook.L */
/* compiled from: RequestProgress */
class C6554L implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6548e f11842a;

    /* renamed from: b */
    final /* synthetic */ long f11843b;

    /* renamed from: c */
    final /* synthetic */ long f11844c;

    /* renamed from: d */
    final /* synthetic */ C6555M f11845d;

    C6554L(C6555M this$0, C6548e eVar, long j, long j2) {
        this.f11845d = this$0;
        this.f11842a = eVar;
        this.f11843b = j;
        this.f11844c = j2;
    }

    public void run() {
        this.f11842a.mo19702a(this.f11843b, this.f11844c);
    }
}
