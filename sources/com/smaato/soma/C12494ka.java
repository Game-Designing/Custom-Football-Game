package com.smaato.soma;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.smaato.soma.ka */
/* compiled from: ExpandedBannerActivity */
class C12494ka extends C12398ha<Boolean> {

    /* renamed from: a */
    final /* synthetic */ MotionEvent f38951a;

    /* renamed from: b */
    final /* synthetic */ View f38952b;

    /* renamed from: c */
    final /* synthetic */ C12496la f38953c;

    C12494ka(C12496la this$1, MotionEvent motionEvent, View view) {
        this.f38953c = this$1;
        this.f38951a = motionEvent;
        this.f38952b = view;
    }

    public Boolean process() throws Exception {
        int action = this.f38951a.getAction();
        if ((action == 0 || action == 1) && !this.f38952b.hasFocus()) {
            this.f38952b.requestFocus();
        }
        return Boolean.valueOf(false);
    }
}
