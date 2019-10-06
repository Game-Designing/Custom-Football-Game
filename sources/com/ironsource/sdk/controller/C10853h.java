package com.ironsource.sdk.controller;

import android.view.ViewGroup;

/* renamed from: com.ironsource.sdk.controller.h */
/* compiled from: ControllerView */
class C10853h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C10857j f33107a;

    C10853h(C10857j this$0) {
        this.f33107a = this$0;
    }

    public void run() {
        ViewGroup decorView = this.f33107a.getWindowDecorViewGroup();
        if (decorView != null) {
            decorView.addView(this.f33107a);
        }
    }
}
