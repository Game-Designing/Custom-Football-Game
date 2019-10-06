package com.smaato.soma.p239c.p246f;

import android.view.View;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12331a;
import com.smaato.soma.p256e.C12345k.C12346a;

/* renamed from: com.smaato.soma.c.f.h */
/* compiled from: AdDownloader */
class C12236h implements C12346a {

    /* renamed from: a */
    final /* synthetic */ C12239k f38324a;

    C12236h(C12239k this$0) {
        this.f38324a = this$0;
    }

    /* renamed from: a */
    public void mo39596a(View receivedView) {
        String str = "AdDowndloader_Med_Banner";
        if (receivedView != null) {
            try {
                if (this.f38324a.f38352u != null) {
                    C12239k.f38328a.post(new C12235g(this, receivedView));
                    if (!(this.f38324a.f38357z == null || this.f38324a.f38357z.mo39796f() == null)) {
                        this.f38324a.mo39605a(this.f38324a.f38357z.mo39796f());
                        C12146d.m39965a(new C12147e(str, "Impression Tracking triggered through on Banner displayed", 1, C12143a.DEBUG));
                    }
                    this.f38324a.m40251a(C12331a.BANNER);
                    this.f38324a.m40262e();
                    this.f38324a.m40253a(str, "Ad added successfully onReceiveAd");
                }
            } catch (NoClassDefFoundError e) {
                this.f38324a.mo39606c();
                return;
            } catch (Exception e2) {
                this.f38324a.mo39606c();
                return;
            }
        }
        this.f38324a.mo39606c();
        this.f38324a.m40253a(str, "Ad added successfully onReceiveAd");
    }

    /* renamed from: a */
    public void mo39597a(C12408ia errorCode) {
        if (errorCode != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onBannerFailed with ErrorCode");
            sb.append(errorCode);
            C12146d.m39965a(new C12147e("AdDowndloader_Med_Banner", sb.toString(), 1, C12143a.DEBUG));
        }
        this.f38324a.mo39606c();
    }

    public void onBannerClicked() {
        if (this.f38324a.f38357z != null && this.f38324a.f38357z.mo39792d() != null) {
            C12146d.m39965a(new C12147e("AdDowndloader_Med_Banner", "Click Tracking triggered through onBannerClicked", 1, C12143a.DEBUG));
            C12239k kVar = this.f38324a;
            kVar.mo39605a(kVar.f38357z.mo39792d());
        }
    }
}
