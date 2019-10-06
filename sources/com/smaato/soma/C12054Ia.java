package com.smaato.soma;

import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.p251h.C12274f;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.Ia */
/* compiled from: LoadingStateDelegateImp */
public class C12054Ia implements C12274f {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WeakReference<C12369fa> f37913a;

    public C12054Ia(C12369fa baseView) {
        this.f37913a = new WeakReference<>(baseView);
    }

    /* renamed from: k */
    public void mo39273k() {
        C12146d.m39966a((Object) new C12041Ca(this));
        WeakReference<C12369fa> weakReference = this.f37913a;
        if (weakReference != null) {
            C12369fa tempBannerView = (C12369fa) weakReference.get();
            if (tempBannerView != null && tempBannerView.getNextPackage() != null) {
                tempBannerView.getNextPackage().mo39340a();
                tempBannerView.setNextPackage(null);
            }
        }
    }

    /* renamed from: e */
    public void mo39267e() {
        C12146d.m39966a((Object) new C12044Da(this));
        WeakReference<C12369fa> weakReference = this.f37913a;
        if (weakReference != null) {
            C12369fa tempBannerView = (C12369fa) weakReference.get();
            if (tempBannerView != null) {
                tempBannerView.mo39221g();
                if (tempBannerView.getNextPackage() != null) {
                    tempBannerView.getNextPackage().mo39340a();
                    tempBannerView.setNextPackage(null);
                }
            }
        }
    }

    /* renamed from: i */
    public void mo39271i() {
        C12146d.m39966a((Object) new C12046Ea(this));
        WeakReference<C12369fa> weakReference = this.f37913a;
        if (weakReference != null) {
            C12369fa tempBannerView = (C12369fa) weakReference.get();
            if (tempBannerView != null && tempBannerView.getNextPackage() != null && tempBannerView.getNextPackage().mo39354e() != null) {
                tempBannerView.getNextPackage().mo39341a(tempBannerView.getContext(), tempBannerView, tempBannerView.getLoadingState(), tempBannerView.getBannerAnimatorHandler());
            }
        }
    }

    /* renamed from: h */
    public void mo39270h() {
        new Thread(new C12050Ga(this)).start();
    }

    /* renamed from: d */
    public void mo39266d() {
        C12146d.m39966a((Object) new C12052Ha(this));
        WeakReference<C12369fa> weakReference = this.f37913a;
        if (weakReference != null) {
            C12369fa tempBannerView = (C12369fa) weakReference.get();
            if (tempBannerView != null && tempBannerView.getNextPackage() != null) {
                if (tempBannerView.getNextPackage().mo39365p() && tempBannerView.getNextPackage().mo39360k() != null) {
                    tempBannerView.getNextPackage().mo39360k().mo39454i();
                }
                if (!(tempBannerView instanceof C12042D)) {
                    tempBannerView.getBannerState().mo39643d();
                }
            } else if (tempBannerView != null && tempBannerView.getCurrentPackage() != null && tempBannerView.getCurrentPackage().mo39360k() != null && tempBannerView.getCurrentPackage().mo39365p()) {
                tempBannerView.getCurrentPackage().mo39360k().mo39454i();
            }
        }
    }

    /* renamed from: g */
    public void mo39269g() {
    }

    /* renamed from: a */
    public void mo39263a() {
    }

    /* renamed from: j */
    public void mo39272j() {
    }

    /* renamed from: l */
    public void mo39274l() {
    }

    /* renamed from: f */
    public void mo39268f() {
    }

    /* renamed from: n */
    public void mo39276n() {
    }

    /* renamed from: m */
    public void mo39275m() {
    }

    /* renamed from: b */
    public void mo39264b() {
    }

    /* renamed from: c */
    public void mo39265c() {
    }
}
