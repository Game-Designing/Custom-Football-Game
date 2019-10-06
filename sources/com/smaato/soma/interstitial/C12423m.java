package com.smaato.soma.interstitial;

import android.app.Activity;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12330E;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.interstitial.m */
/* compiled from: InterstitialActivity */
class C12423m extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ InterstitialActivity f38792a;

    C12423m(InterstitialActivity this$0) {
        this.f38792a = this$0;
    }

    public Void process() {
        this.f38792a.f38763e = C12430s.m40855a(Long.valueOf(this.f38792a.getIntent().getLongExtra("interstitialViewCacheId", 0)));
        if (this.f38792a.f38763e == null) {
            C12146d.m39965a(new C12147e(InterstitialActivity.f38761c, "InterstitialBannerView is null, closing activity", 1, C12143a.ERROR));
            this.f38792a.finish();
            return null;
        }
        this.f38792a.f38763e.setContext((Activity) new WeakReference<>(this.f38792a).get());
        this.f38792a.f38763e.setBannerStateListener(this.f38792a);
        C12330E.m40539a(this.f38792a.f38763e);
        try {
            this.f38792a.mo39912d().addView(this.f38792a.f38763e, new LayoutParams(-1, -1));
        } catch (Throwable th) {
            this.f38792a.mo39912d().addView(this.f38792a.f38763e, new LayoutParams(-1, -1));
        }
        this.f38792a.mo39911c();
        this.f38792a.f38763e.mo39925o();
        return null;
    }
}
