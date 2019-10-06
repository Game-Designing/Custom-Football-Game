package com.smaato.soma;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.smaato.soma.pa */
/* compiled from: ExpandedBannerActivity */
class C12504pa implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExpandedBannerActivity f38963a;

    C12504pa(ExpandedBannerActivity this$0) {
        this.f38963a = this$0;
    }

    public void onClick(View v) {
        if (this.f38963a.f37901j.canGoForward()) {
            this.f38963a.f37901j.goForward();
        }
    }
}
