package com.mopub.common;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.mopub.common.r */
/* compiled from: MoPubBrowser */
class C11281r implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubBrowser f34577a;

    C11281r(MoPubBrowser this$0) {
        this.f34577a = this$0;
    }

    public void onClick(View v) {
        if (this.f34577a.f34341a.canGoForward()) {
            this.f34577a.f34341a.goForward();
        }
    }
}
