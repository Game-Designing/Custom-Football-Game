package com.ironsource.sdk.controller;

import android.view.View.OnSystemUiVisibilityChangeListener;

/* renamed from: com.ironsource.sdk.controller.ha */
/* compiled from: OpenUrlActivity */
class C10854ha implements OnSystemUiVisibilityChangeListener {

    /* renamed from: a */
    final /* synthetic */ OpenUrlActivity f33108a;

    C10854ha(OpenUrlActivity this$0) {
        this.f33108a = this$0;
    }

    public void onSystemUiVisibilityChange(int visibility) {
        if ((visibility & 4098) == 0) {
            this.f33108a.f33037i.removeCallbacks(this.f33108a.f33039k);
            this.f33108a.f33037i.postDelayed(this.f33108a.f33039k, 500);
        }
    }
}
