package com.ironsource.sdk.controller;

import android.view.View.OnSystemUiVisibilityChangeListener;

/* renamed from: com.ironsource.sdk.controller.e */
/* compiled from: ControllerActivity */
class C10846e implements OnSystemUiVisibilityChangeListener {

    /* renamed from: a */
    final /* synthetic */ ControllerActivity f33094a;

    C10846e(ControllerActivity this$0) {
        this.f33094a = this$0;
    }

    public void onSystemUiVisibilityChange(int visibility) {
        if ((visibility & 4098) == 0) {
            this.f33094a.f32997g.removeCallbacks(this.f33094a.f32998h);
            this.f33094a.f32997g.postDelayed(this.f33094a.f32998h, 500);
        }
    }
}
