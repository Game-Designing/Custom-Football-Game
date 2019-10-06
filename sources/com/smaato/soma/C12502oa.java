package com.smaato.soma;

import android.view.View;
import android.view.View.OnClickListener;
import com.smaato.soma.p236a.C12125n;

/* renamed from: com.smaato.soma.oa */
/* compiled from: ExpandedBannerActivity */
class C12502oa implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExpandedBannerActivity f38961a;

    C12502oa(ExpandedBannerActivity this$0) {
        this.f38961a = this$0;
    }

    public void onClick(View v) {
        if (this.f38961a.f37897f != null) {
            C12125n currentPackage = this.f38961a.mo39249d();
            if (currentPackage != null) {
                currentPackage.mo39351b(true);
            }
            this.f38961a.f37897f.getBannerAnimatorHandler().sendMessage(this.f38961a.f37897f.getBannerAnimatorHandler().obtainMessage(105));
            return;
        }
        C12142b.m39962a(this.f38961a.f37901j.getUrl(), this.f38961a);
        this.f38961a.m39818f();
    }
}
