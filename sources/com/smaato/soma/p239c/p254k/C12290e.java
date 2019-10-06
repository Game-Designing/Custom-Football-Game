package com.smaato.soma.p239c.p254k;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.smaato.soma.interstitial.C12428r;

/* renamed from: com.smaato.soma.c.k.e */
/* compiled from: CustomWebView */
class C12290e implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C12291f f38461a;

    C12290e(C12291f this$1) {
        this.f38461a = this$1;
    }

    public void onClick(View v) {
        Context ctx = v.getContext();
        if (this.f38461a.f38462a.f38481c instanceof C12428r) {
            ctx = ((C12428r) this.f38461a.f38462a.f38481c).getActivityContext();
        }
        this.f38461a.f38462a.mo39718a(ctx);
    }
}
