package com.smaato.soma;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.smaato.soma.la */
/* compiled from: ExpandedBannerActivity */
class C12496la implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ExpandedBannerActivity f38955a;

    C12496la(ExpandedBannerActivity this$0) {
        this.f38955a = this$0;
    }

    public boolean onTouch(View v, MotionEvent event) {
        return ((Boolean) new C12494ka(this, event, v).execute()).booleanValue();
    }
}
