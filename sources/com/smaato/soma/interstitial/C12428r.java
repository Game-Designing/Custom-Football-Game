package com.smaato.soma.interstitial;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.smaato.soma.C12369fa;
import com.smaato.soma.p236a.C12125n;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p242c.C12196i;
import com.smaato.soma.p256e.C12351p;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.interstitial.r */
/* compiled from: InterstitialBannerView */
public class C12428r extends C12369fa {

    /* renamed from: q */
    private C12429a f38798q;

    /* renamed from: r */
    private boolean f38799r = false;

    /* renamed from: s */
    private C12420l f38800s;
    @Deprecated

    /* renamed from: t */
    private WeakReference<C12351p> f38801t;
    @Deprecated

    /* renamed from: u */
    private WeakReference<C12351p> f38802u;

    /* renamed from: com.smaato.soma.interstitial.r$a */
    /* compiled from: InterstitialBannerView */
    private class C12429a extends Handler {

        /* renamed from: a */
        private WeakReference<C12369fa> f38803a;

        /* renamed from: b */
        private C12369fa f38804b;

        /* synthetic */ C12429a(C12428r x0, C12369fa x1, C12425o x2) {
            this(x1);
        }

        private C12429a(C12369fa baseView) {
            super(Looper.getMainLooper());
            this.f38803a = null;
            this.f38804b = baseView;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public WeakReference<C12369fa> mo39931a() {
            if (this.f38803a == null) {
                this.f38803a = new WeakReference<>(this.f38804b);
            }
            return this.f38803a;
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            new C12427q(this, msg).execute();
        }
    }

    public C12428r(Context context) {
        super(context);
    }

    public void setInterstitialParent(C12420l parent) {
        this.f38800s = parent;
    }

    public C12420l getInterstitialParent() {
        return this.f38800s;
    }

    public C12196i getInterstitialAdDispatcher() {
        C12420l lVar = this.f38800s;
        if (lVar != null) {
            return lVar.mo39916c();
        }
        return null;
    }

    @Deprecated
    public void setMediationReference(WeakReference<C12351p> mediationEventInterstitialReference) {
        this.f38801t = mediationEventInterstitialReference;
    }

    @Deprecated
    public void setCustomMediationReference(WeakReference<C12351p> customEventInterstitialReference) {
        this.f38802u = customEventInterstitialReference;
    }

    public Handler getBannerAnimatorHandler() {
        if (this.f38798q == null) {
            this.f38798q = new C12429a(this, this, null);
        }
        return this.f38798q;
    }

    /* renamed from: n */
    public void mo39229n() {
        C12125n nVar = this.f38635f;
        if (nVar != null && nVar.mo39360k() != null && this.f38635f.mo39365p()) {
            this.f38635f.mo39360k().mo39455j();
            this.f38635f.mo39360k().mo39449d();
        }
    }

    /* renamed from: d */
    public void mo39225d() {
        try {
            super.mo39225d();
            if (this.f38798q != null) {
                this.f38798q.removeCallbacksAndMessages(null);
            }
            setBannerStateListener(null);
            this.f38635f.mo39350b(null);
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: protected */
    public void setContext(Activity context) {
        new C12425o(this, context).execute();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public void mo39925o() {
        C12125n nVar = this.f38635f;
        if (nVar != null) {
            nVar.mo39368s();
        }
    }

    public final Context getActivityContext() {
        return this.f38635f.mo39357h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo39221g() {
        if (this.f38799r) {
            this.f38800s.mo39920f();
            getInterstitialAdDispatcher().mo39482b();
            this.f38799r = false;
        }
        super.mo39221g();
    }

    /* access modifiers changed from: protected */
    public final void setShouldNotifyIdle(boolean shouldNotifyIdle) {
        this.f38799r = shouldNotifyIdle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo39832j() {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        new C12426p(this).execute();
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        String str = "InterstitialBannerView";
        try {
            if (!(this.f38801t == null || this.f38801t.get() == null)) {
                ((C12351p) this.f38801t.get()).mo39737a();
            }
        } catch (NoClassDefFoundError | RuntimeException e) {
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e(str, "Exception during clearing mMediationEventInterstitialReference", 1, C12143a.DEBUG));
        }
        try {
            if (!(this.f38802u == null || this.f38802u.get() == null)) {
                ((C12351p) this.f38802u.get()).mo39737a();
            }
        } catch (NoClassDefFoundError | RuntimeException e3) {
        } catch (Exception e4) {
            C12146d.m39965a(new C12147e(str, "Exception during clearing mCustomEventInterstitialReference", 1, C12143a.DEBUG));
        }
        mo39834l();
        super.onDetachedFromWindow();
    }
}
