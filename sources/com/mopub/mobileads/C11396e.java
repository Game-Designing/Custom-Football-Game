package com.mopub.mobileads;

import android.view.View;

/* renamed from: com.mopub.mobileads.e */
/* compiled from: AdViewController */
class C11396e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f35253a;

    /* renamed from: b */
    final /* synthetic */ AdViewController f35254b;

    C11396e(AdViewController this$0, View view) {
        this.f35254b = this$0;
        this.f35253a = view;
    }

    public void run() {
        MoPubView moPubView = this.f35254b.getMoPubView();
        if (moPubView != null) {
            moPubView.removeAllViews();
            View view = this.f35253a;
            moPubView.addView(view, this.f35254b.m37239b(view));
        }
    }
}
