package com.smaato.soma;

import android.os.Message;
import android.view.ViewGroup;
import com.smaato.soma.C12037Ba.C12038a;
import com.smaato.soma.p236a.C12137x;

/* renamed from: com.smaato.soma.Aa */
/* compiled from: FullScreenBanner */
class C12035Aa extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Message f37868a;

    /* renamed from: b */
    final /* synthetic */ C12039a f37869b;

    C12035Aa(C12039a this$2, Message message) {
        this.f37869b = this$2;
        this.f37868a = message;
    }

    public Void process() throws Exception {
        C12369fa tempBannerView = (C12369fa) this.f37869b.mo39223a().get();
        if (tempBannerView == null) {
            return null;
        }
        int i = this.f37868a.what;
        if (i == 101) {
            ((ViewGroup) tempBannerView.getParent()).removeView(tempBannerView);
            tempBannerView.clearAnimation();
            tempBannerView.clearFocus();
            tempBannerView.destroyDrawingCache();
            tempBannerView.getBannerState().mo39644e();
            C12137x.m39951a().mo39378b(C12038a.this.getCurrentPackage(), tempBannerView);
            C12038a.this.mo39831h();
        } else if (i == 102) {
            tempBannerView.getBannerState().mo39641b();
        } else if (i == 104) {
            tempBannerView.getBannerState().mo39641b();
        }
        return null;
    }
}
