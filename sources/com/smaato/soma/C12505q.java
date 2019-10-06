package com.smaato.soma;

import com.smaato.soma.p236a.C12137x;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.p251h.C12269c;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.q */
/* compiled from: BannerStateDelegateImp */
public class C12505q implements C12269c {

    /* renamed from: a */
    private WeakReference<C12369fa> f38964a;

    public C12505q(C12369fa baseView) {
        this.f38964a = new WeakReference<>(baseView);
    }

    /* renamed from: c */
    public void mo39647c() {
        C12146d.m39966a((Object) new C12495l(this));
        C12369fa temp = (C12369fa) this.f38964a.get();
        if (temp != null) {
            temp.mo39835m();
        }
    }

    /* renamed from: j */
    public void mo39654j() {
        C12146d.m39966a((Object) new C12497m(this));
        C12369fa tempBannerView = (C12369fa) this.f38964a.get();
        if (tempBannerView != null) {
            tempBannerView.getLoadingState().mo39659b();
        }
    }

    /* renamed from: h */
    public void mo39652h() {
        C12146d.m39966a((Object) new C12499n(this));
        C12369fa tempBannerView = (C12369fa) this.f38964a.get();
        if (tempBannerView != null) {
            tempBannerView.getLoadingState().mo39664g();
            C12137x.m39951a().mo39376a(tempBannerView.getCurrentPackage(), tempBannerView);
        }
    }

    /* renamed from: d */
    public void mo39648d() {
        C12146d.m39966a((Object) new C12501o(this));
        C12369fa tempBannerView = (C12369fa) this.f38964a.get();
        if (tempBannerView != null && tempBannerView.getBannerStateListener() != null) {
            C12507r tempBannerStateListener = tempBannerView.getBannerStateListener();
            if (tempBannerStateListener != null) {
                tempBannerStateListener.onWillCloseLandingPage(tempBannerView);
            }
            tempBannerView.getCurrentPackage().mo39348b();
        }
    }

    /* renamed from: g */
    public void mo39651g() {
        C12146d.m39966a((Object) new C12503p(this));
        C12369fa tempBannerView = (C12369fa) this.f38964a.get();
        C12507r tempBannerStateListener = tempBannerView.getBannerStateListener();
        if (tempBannerStateListener != null) {
            tempBannerStateListener.onWillCloseLandingPage(tempBannerView);
        }
        if (tempBannerView != null && tempBannerView.getCurrentPackage() != null) {
            tempBannerView.getCurrentPackage().mo39348b();
        }
    }

    /* renamed from: i */
    public void mo39653i() {
    }

    /* renamed from: a */
    public void mo39645a() {
    }

    /* renamed from: b */
    public void mo39646b() {
    }

    /* renamed from: e */
    public void mo39649e() {
    }

    /* renamed from: f */
    public void mo39650f() {
    }
}
