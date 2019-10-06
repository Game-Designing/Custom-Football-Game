package com.smaato.soma.p258g;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.moat.analytics.mobile.sma.NativeDisplayTracker.MoatUserInteractionType;

/* renamed from: com.smaato.soma.g.g */
/* compiled from: NativeAd */
class C12378g implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C12389r f38657a;

    C12378g(C12389r this$0) {
        this.f38657a = this$0;
    }

    public boolean onTouch(View v, MotionEvent event) {
        this.f38657a.m40697a(MoatUserInteractionType.TOUCH);
        return false;
    }
}
