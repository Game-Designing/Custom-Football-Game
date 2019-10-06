package com.smaato.soma;

import android.content.ActivityNotFoundException;
import android.os.Message;
import com.smaato.soma.p236a.C12137x;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p255d.C12315h;

/* renamed from: com.smaato.soma.C */
/* compiled from: BannerView */
class C12040C extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Message f37878a;

    /* renamed from: b */
    final /* synthetic */ C12043a f37879b;

    C12040C(C12043a this$1, Message message) {
        this.f37879b = this$1;
        this.f37878a = message;
    }

    public Void process() throws Exception {
        C12369fa tempBannerView = (C12369fa) this.f37879b.mo39239a().get();
        if (tempBannerView == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleMessage() with");
        sb.append(this.f37878a.what);
        String str = "BannerView";
        C12146d.m39965a(new C12147e(str, sb.toString(), 1, C12143a.DEBUG));
        Message message = this.f37878a;
        int i = message.what;
        if (i == 101) {
            if (tempBannerView.getCurrentPackage().mo39365p()) {
                C12042D.this.mo39814a(this.f37878a.getData());
            } else {
                C12042D.this.mo39228i();
                tempBannerView.getBannerState().mo39644e();
                C12137x.m39951a().mo39378b(C12042D.this.getCurrentPackage(), tempBannerView);
                C12315h.m40496c().mo39732a();
                C12042D.this.f38635f.mo39351b(false);
                C12042D.this.mo39831h();
            }
        } else if (i == 102) {
            if (!(tempBannerView == null || tempBannerView.getCurrentPackage() == null)) {
                if (!tempBannerView.getCurrentPackage().mo39365p()) {
                    tempBannerView.getBannerState().mo39641b();
                    if (C12042D.this.mo39230o()) {
                        C12042D.this.mo39256a();
                    }
                } else if (!C12042D.this.f38635f.mo39366q()) {
                    tempBannerView.getBannerState().mo39642c();
                    C12042D.this.mo39819c();
                    C12042D.this.f38635f.mo39351b(true);
                } else if (C12042D.this.f38635f.mo39360k() != null) {
                    C12042D.this.f38635f.mo39360k().mo39455j();
                }
                C12042D.this.mo39234p();
            }
        } else if (i == 104) {
            try {
                C12137x.m39951a().mo39377a(true);
                tempBannerView.getBannerState().mo39642c();
                C12042D.this.mo39819c();
                C12042D.this.f38635f.mo39351b(true);
            } catch (Exception e) {
            }
        } else if (i == 105) {
            try {
                String url = C12042D.this.getCurrentPackage().mo39361l().getUrl();
                tempBannerView.getBannerState().mo39641b();
                ((ExpandedBannerActivity) C12042D.this.getCurrentPackage().mo39356g()).finish();
                C12142b.m39962a(url, C12042D.this.getContext());
                C12042D.this.mo39822e();
            } catch (ActivityNotFoundException e2) {
                C12146d.m39965a(new C12147e(str, "Please declare com.smaato.soma.ExpandedBannerActivity in your AndroidManifest.xml", 0, C12143a.ERROR));
            } catch (Exception e3) {
                C12146d.m39965a(new C12147e(str, "Exception inside Internal Browser", 0, C12143a.ERROR));
            }
        } else if (i == 103) {
            C12042D.this.mo39820c(message.getData());
        } else if (i == 106) {
            C12042D.this.mo39821d(message.getData());
        } else if (i == 107) {
            C12042D.this.mo39823e(message.getData());
        } else if (i == 108) {
            C12042D.this.mo39817b(message.getData());
        }
        return null;
    }
}
