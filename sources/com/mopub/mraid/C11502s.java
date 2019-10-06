package com.mopub.mraid;

import android.view.View;

/* renamed from: com.mopub.mraid.s */
/* compiled from: MraidController */
class C11502s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C11479a f35582a;

    C11502s(C11479a this$0) {
        this.f35582a = this$0;
    }

    public void run() {
        View[] a;
        for (View view : this.f35582a.f35524a) {
            if (view.getHeight() > 0 || view.getWidth() > 0) {
                this.f35582a.m38028b();
            } else {
                view.getViewTreeObserver().addOnPreDrawListener(new C11501r(this, view));
            }
        }
    }
}
