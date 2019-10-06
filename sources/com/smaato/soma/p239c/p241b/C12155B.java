package com.smaato.soma.p239c.p241b;

import android.view.View;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.b.B */
/* compiled from: ScreenMetricsWaiter */
class C12155B extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12156C f38109a;

    C12155B(C12156C this$0) {
        this.f38109a = this$0;
    }

    public Void process() {
        View[] a;
        if (C12159F.f38113b == null) {
            C12159F.m39994f();
            return null;
        }
        for (View view : C12159F.f38113b) {
            if (view.getHeight() > 0 || view.getWidth() > 0) {
                C12159F.m39996h();
            } else {
                view.getViewTreeObserver().addOnPreDrawListener(new C12154A(this, view));
            }
        }
        return null;
    }
}
