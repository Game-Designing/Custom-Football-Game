package com.smaato.soma.interstitial;

import android.content.Context;
import com.smaato.soma.C12047F;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12150c;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12367f;
import com.smaato.soma.C12371g;
import com.smaato.soma.C12394h;
import com.smaato.soma.p239c.p242c.C12196i;
import com.smaato.soma.p239c.p246f.C12252w;
import com.smaato.soma.p256e.C12351p.C12352a;
import com.smaato.soma.p257f.C12368a;

/* renamed from: com.smaato.soma.interstitial.l */
/* compiled from: Interstitial */
public class C12420l implements C12368a, C12047F, C12367f, C12371g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f38777a = C12420l.class.getSimpleName();

    /* renamed from: b */
    private C12352a f38778b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f38779c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f38780d;

    /* renamed from: e */
    protected C12428r f38781e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12196i f38782f = new C12196i();

    /* renamed from: g */
    Context f38783g;

    /* renamed from: h */
    C12422b f38784h;

    /* renamed from: i */
    private C12421a f38785i = C12421a.PORTRAIT;

    /* renamed from: com.smaato.soma.interstitial.l$a */
    /* compiled from: Interstitial */
    public enum C12421a {
        PORTRAIT,
        LANDSCAPE
    }

    /* renamed from: com.smaato.soma.interstitial.l$b */
    /* compiled from: Interstitial */
    protected enum C12422b {
        IS_READY,
        IS_NOT_READY
    }

    /* renamed from: a */
    public void mo39914a(C12352a mediationEventInterstitialListener) {
        this.f38778b = mediationEventInterstitialListener;
    }

    public void destroy() {
        try {
            if (this.f38781e != null) {
                this.f38781e.onDetachedFromWindow();
            }
            mo39915a((C12424n) null);
            this.f38783g = null;
            if (this.f38781e != null) {
                this.f38781e.removeAllViews();
                this.f38781e.destroyDrawingCache();
                this.f38781e.mo39225d();
            }
            this.f38781e = null;
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m40827j() {
        C12352a aVar = this.f38778b;
        if (aVar != null) {
            aVar.onWillShow();
        }
    }

    public C12420l(Context context) {
        new C12415g(this, context).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40816a(Context context) {
        this.f38783g = context;
        this.f38781e = new C12428r(this.f38783g);
        this.f38781e.setInterstitialParent(this);
        this.f38781e.mo39816a((C12367f) this);
        this.f38781e.setScalingEnabled(false);
        this.f38781e.getInterstitialParent();
        m40826i();
    }

    /* renamed from: i */
    private void m40826i() {
        if (C12414f.f38769a[m40825h().ordinal()] != 1) {
            this.f38781e.getAdSettings().mo39882a(C12150c.INTERSTITIAL_PORTRAIT);
            return;
        }
        this.f38781e.getAdSettings().mo39882a(C12150c.INTERSTITIAL_LANDSCAPE);
        C12252w.m40307b().mo39625a(false);
    }

    /* renamed from: g */
    public void mo39921g() {
        new C12416h(this).execute();
    }

    /* renamed from: a */
    public void mo39915a(C12424n listener) {
        this.f38782f.mo39481a(listener);
    }

    /* renamed from: c */
    public C12196i mo39916c() {
        return this.f38782f;
    }

    /* renamed from: d */
    public boolean mo39917d() {
        return this.f38784h == C12422b.IS_READY;
    }

    public void onReceiveAd(C12322e sender, C12064Na receivedBanner) {
        new C12417i(this, receivedBanner).execute();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo39920f() {
        this.f38784h = C12422b.IS_READY;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo39919e() {
        this.f38784h = C12422b.IS_NOT_READY;
    }

    /* renamed from: a */
    public void mo39256a() {
        new C12418j(this).execute();
    }

    public C12394h getAdSettings() {
        return (C12394h) new C12419k(this).execute();
    }

    /* renamed from: h */
    private C12421a m40825h() {
        return this.f38785i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40817a(C12421a interstitialOrientation) {
        this.f38785i = interstitialOrientation;
        m40826i();
    }
}
