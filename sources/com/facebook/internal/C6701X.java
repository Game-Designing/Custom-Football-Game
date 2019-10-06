package com.facebook.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.facebook.internal.X */
/* compiled from: WebDialog */
class C6701X implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C6702Y f12236a;

    C6701X(C6702Y this$0) {
        this.f12236a = this$0;
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (!v.hasFocus()) {
            v.requestFocus();
        }
        return false;
    }
}
