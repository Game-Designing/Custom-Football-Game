package com.smaato.soma.p239c.p246f;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.p256e.C12330E;

/* renamed from: com.smaato.soma.c.f.g */
/* compiled from: AdDownloader */
class C12235g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f38322a;

    /* renamed from: b */
    final /* synthetic */ C12236h f38323b;

    C12235g(C12236h this$1, View view) {
        this.f38323b = this$1;
        this.f38322a = view;
    }

    public void run() {
        C12330E.m40539a(this.f38322a);
        this.f38323b.f38324a.f38352u.removeAllViews();
        if (this.f38322a.getLayoutParams() != null) {
            this.f38322a.setLayoutParams(new LayoutParams(-2, -2));
        }
        this.f38323b.f38324a.f38352u.addView(this.f38322a);
    }
}
