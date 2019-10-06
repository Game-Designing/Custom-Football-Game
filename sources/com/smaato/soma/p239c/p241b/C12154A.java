package com.smaato.soma.p239c.p241b;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: com.smaato.soma.c.b.A */
/* compiled from: ScreenMetricsWaiter */
class C12154A implements OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ View f38107a;

    /* renamed from: b */
    final /* synthetic */ C12155B f38108b;

    C12154A(C12155B this$1, View view) {
        this.f38108b = this$1;
        this.f38107a = view;
    }

    public boolean onPreDraw() {
        this.f38107a.getViewTreeObserver().removeOnPreDrawListener(this);
        C12159F.m39996h();
        return true;
    }
}
