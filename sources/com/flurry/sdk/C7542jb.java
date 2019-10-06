package com.flurry.sdk;

import java.util.TimerTask;

/* renamed from: com.flurry.sdk.jb */
class C7542jb extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C7547kb f14896a;

    C7542jb(C7547kb kbVar) {
        this.f14896a = kbVar;
    }

    public final void run() {
        if (this.f14896a.f14915h > 0 && this.f14896a.f14915h < System.currentTimeMillis()) {
            C7513ec.m16639a(4, C7547kb.f14908a, "No location received in 90 seconds , stopping LocationManager");
            this.f14896a.m16720h();
        }
    }
}
