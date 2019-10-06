package com.smaato.soma;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.smaato.soma.qa */
/* compiled from: ExpandedBannerActivity */
class C12506qa implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExpandedBannerActivity f38965a;

    C12506qa(ExpandedBannerActivity this$0) {
        this.f38965a = this$0;
    }

    public void onClick(View v) {
        if (this.f38965a.f37901j.canGoBack()) {
            this.f38965a.f37901j.goBack();
        }
    }
}
