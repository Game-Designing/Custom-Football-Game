package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.mopub.mobileads.t */
/* compiled from: BaseHtmlWebView */
class C11451t implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ BaseHtmlWebView f35419a;

    C11451t(BaseHtmlWebView this$0) {
        this.f35419a = this$0;
    }

    public boolean onTouch(View v, MotionEvent event) {
        this.f35419a.f34700c.onTouchEvent(event);
        return event.getAction() == 2;
    }
}
