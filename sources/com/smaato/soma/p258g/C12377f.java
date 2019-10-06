package com.smaato.soma.p258g;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.moat.analytics.mobile.sma.NativeDisplayTracker.MoatUserInteractionType;

/* renamed from: com.smaato.soma.g.f */
/* compiled from: NativeAd */
class C12377f implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ GestureDetector f38655a;

    /* renamed from: b */
    final /* synthetic */ C12389r f38656b;

    C12377f(C12389r this$0, GestureDetector gestureDetector) {
        this.f38656b = this$0;
        this.f38655a = gestureDetector;
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (!this.f38655a.onTouchEvent(event)) {
            return false;
        }
        this.f38656b.m40697a(MoatUserInteractionType.TOUCH);
        return true;
    }
}
