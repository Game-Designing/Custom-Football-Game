package com.ironsource.sdk.controller;

import p019d.p273h.p285d.p295h.C13004g;

/* renamed from: com.ironsource.sdk.controller.d */
/* compiled from: ControllerActivity */
class C10844d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ControllerActivity f33091a;

    C10844d(ControllerActivity this$0) {
        this.f33091a = this$0;
    }

    public void run() {
        this.f33091a.getWindow().getDecorView().setSystemUiVisibility(C13004g.m42441a(this.f33091a.f32996f));
    }
}
