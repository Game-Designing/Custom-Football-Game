package com.smaato.soma.p258g;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.smaato.soma.g.d */
/* compiled from: NativeAd */
class C12375d implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C12389r f38653a;

    C12375d(C12389r this$0) {
        this.f38653a = this$0;
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 1) {
            v.performClick();
        }
        return true;
    }
}
