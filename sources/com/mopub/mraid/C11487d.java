package com.mopub.mraid;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.mopub.mraid.d */
/* compiled from: MraidBridge */
class C11487d implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ MraidBridge f35564a;

    C11487d(MraidBridge this$0) {
        this.f35564a = this$0;
    }

    public boolean onTouch(View v, MotionEvent event) {
        this.f35564a.f35487f.onTouchEvent(event);
        int action = event.getAction();
        if ((action == 0 || action == 1) && !v.hasFocus()) {
            v.requestFocus();
        }
        return false;
    }
}
