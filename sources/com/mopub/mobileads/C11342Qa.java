package com.mopub.mobileads;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: com.mopub.mobileads.Qa */
/* compiled from: VastVideoViewController */
class C11342Qa implements OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ Activity f34894a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f34895b;

    C11342Qa(VastVideoViewController this$0, Activity activity) {
        this.f34895b = this$0;
        this.f34894a = activity;
    }

    public void onGlobalLayout() {
        VastVideoViewController vastVideoViewController = this.f34895b;
        vastVideoViewController.f35096t = vastVideoViewController.mo37360a(this.f34894a);
        this.f34895b.f35098v.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
