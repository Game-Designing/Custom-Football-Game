package com.smaato.soma.p260i;

import android.content.ActivityNotFoundException;
import android.os.Message;
import com.smaato.soma.C12142b;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12398ha;
import com.smaato.soma.ExpandedBannerActivity;
import com.smaato.soma.p236a.C12137x;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.i.f */
/* compiled from: ToasterLayout */
class C12405f extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Message f38740a;

    /* renamed from: b */
    final /* synthetic */ C12407a f38741b;

    C12405f(C12407a this$1, Message message) {
        this.f38741b = this$1;
        this.f38740a = message;
    }

    public Void process() throws Exception {
        C12369fa tempBannerView = (C12369fa) this.f38741b.mo39901a().get();
        if (tempBannerView == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleMessage() with");
        sb.append(this.f38740a.what);
        String str = "Toaster_Layout";
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
        Message message = this.f38740a;
        int i = message.what;
        if (i == 101) {
            if (tempBannerView.getCurrentPackage().mo39365p()) {
                C12406g.this.mo39814a(this.f38740a.getData());
            } else {
                tempBannerView.getBannerState().mo39644e();
                C12137x.m39951a().mo39378b(C12406g.this.getCurrentPackage(), tempBannerView);
                C12406g.this.f38635f.mo39351b(false);
                C12406g.this.f38742q.mo39809c();
                C12406g.this.mo39831h();
            }
        } else if (i == 104) {
            try {
                C12137x.m39951a().mo39377a(true);
                if (!C12406g.this.f38635f.mo39366q()) {
                    tempBannerView.getBannerState().mo39642c();
                } else {
                    tempBannerView.getBannerState().mo39641b();
                }
                C12406g.this.mo39819c();
                C12406g.this.f38635f.mo39351b(true);
            } catch (Exception e) {
            }
        } else if (i == 102) {
            if (!C12406g.this.f38635f.mo39366q()) {
                tempBannerView.getBannerState().mo39642c();
            } else {
                tempBannerView.getBannerState().mo39641b();
            }
            C12406g.this.mo39819c();
        } else if (i == 105) {
            try {
                String url = C12406g.this.getCurrentPackage().mo39361l().getUrl();
                tempBannerView.getBannerState().mo39641b();
                ((ExpandedBannerActivity) C12406g.this.getCurrentPackage().mo39356g()).finish();
                C12142b.m39962a(url, C12406g.this.getContext());
                C12406g.this.mo39822e();
            } catch (ActivityNotFoundException e2) {
                C12146d.m39965a(new C12147e(str, "Please declare com.smaato.soma.ExpandedBannerActivity in your AndroidManifest.xml", 0, C12143a.ERROR));
            } catch (Exception e3) {
                C12146d.m39965a(new C12147e(str, "Exception inside Internal Browser", 0, C12143a.ERROR));
            }
        } else if (i == 103) {
            C12406g.this.mo39820c(message.getData());
        } else if (i == 106) {
            C12406g.this.mo39821d(message.getData());
        } else if (i == 107) {
            C12406g.this.mo39823e(message.getData());
        } else if (i == 108) {
            C12406g.this.mo39817b(message.getData());
        }
        return null;
    }
}
