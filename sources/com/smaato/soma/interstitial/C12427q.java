package com.smaato.soma.interstitial;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Message;
import android.view.ViewGroup;
import com.smaato.soma.C12142b;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12398ha;
import com.smaato.soma.ExpandedBannerActivity;
import com.smaato.soma.p236a.C12137x;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p255d.C12315h;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.interstitial.q */
/* compiled from: InterstitialBannerView */
class C12427q extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Message f38796a;

    /* renamed from: b */
    final /* synthetic */ C12429a f38797b;

    C12427q(C12429a this$1, Message message) {
        this.f38797b = this$1;
        this.f38796a = message;
    }

    public Void process() throws Exception {
        C12369fa tempBannerView = (C12369fa) this.f38797b.mo39931a().get();
        if (tempBannerView == null) {
            return null;
        }
        Message message = this.f38796a;
        int i = message.what;
        String str = "Exception inside Internal Browser";
        String str2 = "InterstitialBannerView";
        if (i == 101) {
            if (!C12428r.this.f38635f.mo39365p()) {
                ((ViewGroup) tempBannerView.getParent()).removeView(tempBannerView);
                tempBannerView.clearAnimation();
                tempBannerView.clearFocus();
                tempBannerView.destroyDrawingCache();
                tempBannerView.getBannerState().mo39644e();
                C12137x.m39951a().mo39378b(C12428r.this.getCurrentPackage(), tempBannerView);
                C12315h.m40496c().mo39732a();
                C12428r.this.mo39228i();
                try {
                    ExpandedBannerActivity.f37892a = new WeakReference<>(C12428r.this.getCurrentPackage());
                    Intent i2 = new Intent(C12428r.this.getActivityContext(), ExpandedBannerActivity.class);
                    C12428r.this.f38635f.mo39351b(false);
                    ((InterstitialActivity) C12428r.this.getActivityContext()).startActivityForResult(i2, 1);
                } catch (ActivityNotFoundException e) {
                    C12146d.m39965a(new C12147e(str2, "Please declare com.smaato.soma.ExpandedBannerActivity in your AndroidManifest.xml. android.content.ActivityNotFoundException occured", 0, C12143a.ERROR));
                } catch (Exception e2) {
                    C12146d.m39965a(new C12147e(str2, str, 0, C12143a.ERROR));
                }
            }
        } else if (i == 102) {
            m40836a(tempBannerView);
        } else if (i == 104) {
            m40836a(tempBannerView);
        } else if (i == 105) {
            try {
                String url = C12428r.this.getCurrentPackage().mo39361l().getUrl();
                tempBannerView.getBannerState().mo39641b();
                ((ExpandedBannerActivity) C12428r.this.getCurrentPackage().mo39356g()).finish();
                C12142b.m39962a(url, C12428r.this.getContext());
                C12428r.this.mo39822e();
            } catch (ActivityNotFoundException e3) {
                C12146d.m39965a(new C12147e(str2, "Please declare com.smaato.soma.ExpandedBannerActivity in your AndroidManifest.xml", 2, C12143a.ERROR));
            } catch (Exception e4) {
                C12146d.m39965a(new C12147e(str2, str, 2, C12143a.ERROR));
            }
        } else if (i == 106) {
            C12428r.this.mo39821d(message.getData());
        } else if (i == 107) {
            C12428r.this.mo39823e(message.getData());
        } else if (i == 108) {
            C12428r.this.mo39817b(message.getData());
        }
        return null;
    }

    /* renamed from: a */
    private void m40836a(C12369fa tempBannerView) {
        String str = "InterstitialBannerView";
        if (!C12428r.this.f38635f.mo39366q()) {
            tempBannerView.getBannerState().mo39642c();
            C12428r.this.f38635f.mo39351b(true);
            try {
                if (C12428r.this.getCurrentPackage().mo39357h() instanceof InterstitialActivity) {
                    ((InterstitialActivity) C12428r.this.getCurrentPackage().mo39357h()).finishActivity(1);
                    ((InterstitialActivity) C12428r.this.getCurrentPackage().mo39357h()).finish();
                }
                if (C12428r.this.getCurrentPackage().mo39357h() instanceof ExpandedBannerActivity) {
                    ((ExpandedBannerActivity) C12428r.this.getCurrentPackage().mo39357h()).finish();
                }
                if (C12428r.this.getCurrentPackage().mo39365p() && C12428r.this.getCurrentPackage().mo39356g() != null && !((ExpandedBannerActivity) C12428r.this.f38635f.mo39356g()).mo39250e()) {
                    C12146d.m39965a(new C12147e(str, "ExpandedBannerActivity being finished with handle(Values.MESSAGE_CLOSE)", 1, C12143a.DEBUG));
                    ((ExpandedBannerActivity) C12428r.this.getCurrentPackage().mo39356g()).finish();
                    C12428r.this.f38635f.mo39351b(true);
                }
            } catch (ActivityNotFoundException e) {
                C12146d.m39965a(new C12147e(str, "Please declare com.smaato.soma.ExpandedBannerActivity in your AndroidManifest.xml. ActivityNotFoundException occured", 2, C12143a.ERROR));
            } catch (Exception e2) {
                C12146d.m39965a(new C12147e(str, "Exception inside Internal Browser", 2, C12143a.ERROR));
            }
        }
    }
}
