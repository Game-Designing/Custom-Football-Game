package com.mopub.common;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.mopub.common.q */
/* compiled from: MoPubBrowser */
class C11280q implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubBrowser f34576a;

    C11280q(MoPubBrowser this$0) {
        this.f34576a = this$0;
    }

    public void onClick(View v) {
        if (this.f34576a.f34341a.canGoBack()) {
            this.f34576a.f34341a.goBack();
        }
    }
}
