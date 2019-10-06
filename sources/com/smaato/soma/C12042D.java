package com.smaato.soma;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12345k;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.D */
/* compiled from: BannerView */
public class C12042D extends C12369fa implements C12045E {

    /* renamed from: q */
    protected boolean f37881q = true;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f37882r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f37883s = 60;
    @Deprecated

    /* renamed from: t */
    private WeakReference<C12345k> f37884t;
    @Deprecated

    /* renamed from: u */
    private WeakReference<C12345k> f37885u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Runnable f37886v = new C12513u(this);

    /* renamed from: com.smaato.soma.D$a */
    /* compiled from: BannerView */
    private class C12043a extends Handler {

        /* renamed from: a */
        private WeakReference<C12369fa> f37887a;

        /* renamed from: b */
        private C12369fa f37888b;

        /* synthetic */ C12043a(C12042D x0, C12369fa x1, C12513u x2) {
            this(x1);
        }

        private C12043a(C12369fa baseView) {
            super(Looper.getMainLooper());
            this.f37887a = null;
            this.f37888b = baseView;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public WeakReference<C12369fa> mo39239a() {
            if (this.f37887a == null) {
                this.f37887a = new WeakReference<>(this.f37888b);
            }
            return this.f37887a;
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            new C12040C(this, msg).execute();
        }
    }

    @Deprecated
    public void setMediationReference(WeakReference<C12345k> mediationEventBannerReference) {
        this.f37884t = mediationEventBannerReference;
    }

    @Deprecated
    public void setCustomMediationReference(WeakReference<C12345k> customMediationReference) {
        this.f37885u = customMediationReference;
    }

    public C12042D(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo39226f() {
        setBackgroundColor(0);
        super.mo39226f();
    }

    /* renamed from: o */
    public boolean mo39230o() {
        return this.f37881q;
    }

    /* renamed from: i */
    public void mo39228i() {
        C12146d.m39966a((Object) new C12515v(this));
        this.f37881q = false;
        getBannerAnimatorHandler().removeCallbacksAndMessages(null);
    }

    /* renamed from: p */
    public void mo39234p() {
        C12146d.m39966a((Object) new C12517w(this));
        getBannerAnimatorHandler().removeCallbacksAndMessages(null);
        this.f37881q = this.f37882r;
        if (mo39230o()) {
            getBannerAnimatorHandler().postDelayed(this.f37886v, (long) (this.f37883s * 1000));
        }
    }

    public void setAutoReloadEnabled(boolean autoReloadEnabled) {
        new C12521y(this, autoReloadEnabled).execute();
    }

    public final int getAutoReloadFrequency() {
        return this.f37883s;
    }

    public final void setAutoReloadFrequency(int autoReloadFrequency) {
        new C12523z(this, autoReloadFrequency).execute();
    }

    public final void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        new C12034A(this, hasWindowFocus).execute();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        new C12036B(this).execute();
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        new C12511t(this).execute();
    }

    public Handler getBannerAnimatorHandler() {
        if (this.f38637h == null) {
            setBannerAnimatorHandler(new C12043a(this, this, null));
        }
        return this.f38637h;
    }

    /* renamed from: d */
    public void mo39225d() {
        super.mo39225d();
        mo39229n();
        try {
            if (getBannerAnimatorHandler() != null) {
                getBannerAnimatorHandler().removeCallbacksAndMessages(null);
                setBannerAnimatorHandler(null);
            }
            removeAllViews();
            destroyDrawingCache();
        } catch (Exception e) {
        }
    }

    /* renamed from: n */
    public void mo39229n() {
        String str = "BannerView:onDetachedFromWindow()";
        try {
            if (!(this.f37884t == null || this.f37884t.get() == null)) {
                ((C12345k) this.f37884t.get()).mo39740a();
            }
        } catch (NoClassDefFoundError | RuntimeException e) {
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e(str, "Exception during clearing MoPubMediationBannerReference", 1, C12143a.DEBUG));
        }
        try {
            if (this.f37885u != null && this.f37885u.get() != null) {
                ((C12345k) this.f37885u.get()).mo39740a();
            }
        } catch (NoClassDefFoundError | RuntimeException e3) {
        } catch (Exception e4) {
            C12146d.m39965a(new C12147e(str, "Exception during clearing CustomBannerReference", 1, C12143a.DEBUG));
        }
    }
}
