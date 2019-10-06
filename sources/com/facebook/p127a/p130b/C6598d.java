package com.facebook.p127a.p130b;

import com.facebook.C6787r;
import com.facebook.internal.C6738z;
import com.facebook.p127a.p128a.C6591m.C6592a;

/* renamed from: com.facebook.a.b.d */
/* compiled from: ActivityLifecycleTracker */
class C6598d implements C6592a {

    /* renamed from: a */
    final /* synthetic */ C6738z f11979a;

    /* renamed from: b */
    final /* synthetic */ String f11980b;

    C6598d(C6738z zVar, String str) {
        this.f11979a = zVar;
        this.f11980b = str;
    }

    /* renamed from: a */
    public void mo19777a() {
        C6738z zVar = this.f11979a;
        boolean codelessSetupEnabled = true;
        boolean codelessEventsEnabled = zVar != null && zVar.mo19974b();
        if (!C6787r.m13821k()) {
            codelessSetupEnabled = false;
        }
        if (codelessEventsEnabled && codelessSetupEnabled) {
            C6602h.m13087b(this.f11980b);
        }
    }
}
