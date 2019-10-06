package p019d.p143b.p144a.p147c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.adview.C5861g;
import java.lang.ref.SoftReference;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.K */
public class C7080K {

    /* renamed from: a */
    protected final C7142c f13259a;

    /* renamed from: b */
    protected final C7134a f13260b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C7251a f13261c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f13262d;

    /* renamed from: e */
    private String f13263e;

    /* renamed from: f */
    private SoftReference<C7254d> f13264f;

    /* renamed from: g */
    private final Object f13265g = new Object();

    /* renamed from: h */
    private volatile String f13266h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C7189nc f13267i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile boolean f13268j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SoftReference<C5861g> f13269k;

    public C7080K(String str, C7267q qVar) {
        this.f13259a = (C7142c) qVar;
        this.f13260b = (C7134a) qVar.mo23037a();
        this.f13263e = str;
    }

    /* renamed from: a */
    private void m14785a(C7071Hc hc, Context context, C7255e eVar, C7260j jVar, C7253c cVar, C7252b bVar) {
        C7071Hc hc2 = hc;
        Context context2 = context;
        C7260j jVar2 = jVar;
        C7253c cVar2 = cVar;
        String str = "IncentivizedAdController";
        if (!hc.mo22759d().equals(C7258h.f14103b)) {
            C7262l b = this.f13259a.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to render an ad of type ");
            sb.append(hc.mo22759d());
            sb.append(" in an Incentivized Ad interstitial.");
            b.mo22916b(str, sb.toString());
        } else if (!C7209sc.m15479a((C7251a) hc, this.f13259a)) {
            m14793a((C7251a) hc, jVar2, cVar2);
            return;
        } else {
            if (hc.mo22760g() == C7063Fc.f13210b) {
                if (!C7209sc.m15478a(hc2 instanceof C7048C ? (C7234z) this.f13259a.mo23063h().mo23143c(hc.mo22762n()) : (C7234z) hc2, context, this.f13259a)) {
                    this.f13259a.mo23049b().mo22921e(str, "Failed to render an ad: video cache has been removed.");
                }
            }
            C7084L l = new C7084L(this, hc, context, eVar, jVar, cVar, bVar);
            boolean booleanValue = ((Boolean) this.f13259a.mo23039a(C7196pb.f13873ra)).booleanValue();
            if (booleanValue && (context2 instanceof Activity)) {
                Activity activity = (Activity) context2;
                if (!activity.isFinishing()) {
                    C7129Z a = C7114U.m14935a();
                    a.mo22996a(this.f13259a);
                    a.mo22994a(activity);
                    a.mo22995a(this);
                    a.mo22997a(eVar);
                    a.mo22998a((Runnable) l);
                    a.mo22993a().mo22978a((C7251a) hc);
                    return;
                }
            }
            if (booleanValue) {
                this.f13259a.mo23049b().mo22921e(str, "Unable to show Incentivized Ad prompt. Must pass in an active Activity context.");
            }
            l.run();
            return;
        }
        m14793a((C7251a) hc, jVar2, cVar2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14789a(C7234z zVar, C7255e eVar) {
        this.f13267i = new C7189nc(zVar, eVar, this.f13259a);
        this.f13259a.mo23027C().mo22970a((C7184mb) this.f13267i, C7113Tb.BACKGROUND);
    }

    /* renamed from: a */
    private void m14790a(C7235za zaVar, Activity activity, C7255e eVar, C7253c cVar, C7252b bVar) {
        C7177kc kcVar = new C7177kc();
        kcVar.mo23194a(bVar);
        kcVar.mo23195a(cVar);
        kcVar.mo23196a(eVar);
        this.f13259a.mo23076u().mo23097a(zaVar, this.f13262d, activity, kcVar);
        m14791a((C7251a) zaVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14791a(C7251a aVar) {
        C7251a aVar2 = this.f13261c;
        if (aVar2 != null && (!(aVar2 instanceof C7048C) ? aVar == aVar2 : aVar == ((C7048C) aVar2).mo22764q())) {
            this.f13261c = null;
        }
        this.f13262d = null;
    }

    /* renamed from: a */
    private void m14792a(C7251a aVar, Context context, C7255e eVar, C7260j jVar, C7253c cVar, C7252b bVar) {
        String str;
        C7262l lVar;
        if (aVar == null) {
            aVar = this.f13261c;
        }
        C7071Hc hc = (C7071Hc) aVar;
        String str2 = "IncentivizedAdController";
        if (hc != null) {
            if (hc.mo22760g() == C7063Fc.f13211c) {
                C7251a a = C7209sc.m15466a((C7251a) hc, (C7267q) this.f13259a);
                if (!(a instanceof C7235za)) {
                    lVar = this.f13259a.mo23049b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Skipping mediated incentivized video playback: an unknown ad was pre-loaded: '");
                    sb.append(a);
                    sb.append("'");
                    str = sb.toString();
                } else if (context instanceof Activity) {
                    m14790a((C7235za) a, (Activity) context, eVar, cVar, bVar);
                    return;
                } else {
                    this.f13259a.mo23049b().mo22921e(str2, "Skipping incentivized video playback: Activity required.");
                    m14793a((C7251a) hc, jVar, cVar);
                    return;
                }
            } else {
                m14785a(hc, context, eVar, jVar, cVar, bVar);
                return;
            }
        } else {
            lVar = this.f13259a.mo23049b();
            str = "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.";
        }
        lVar.mo22921e(str2, str);
        m14798c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14793a(C7251a aVar, C7260j jVar, C7253c cVar) {
        C7171ja.m15280a(jVar, aVar, 0.0d, false, this.f13259a);
        C7171ja.m15284b(cVar, aVar, this.f13259a);
    }

    /* renamed from: c */
    private void m14798c() {
        SoftReference<C7254d> softReference = this.f13264f;
        if (softReference != null) {
            C7254d dVar = (C7254d) softReference.get();
            if (dVar != null) {
                dVar.failedToReceiveAd(-300);
            }
        }
    }

    /* renamed from: d */
    private C7255e m14799d() {
        return new C7088M(this);
    }

    /* renamed from: a */
    public void mo22871a(C7251a aVar, Context context, String str, C7255e eVar, C7260j jVar, C7253c cVar, C7252b bVar) {
        if (eVar == null) {
            eVar = m14799d();
        }
        C7255e eVar2 = eVar;
        this.f13262d = str;
        m14792a(aVar, context, eVar2, jVar, cVar, bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22872a(C7251a aVar, C7255e eVar) {
        C7171ja.m15278a(eVar, aVar, (C7267q) this.f13259a);
    }

    /* renamed from: a */
    public void mo22873a(C7254d dVar) {
        String str = "IncentivizedAdController";
        this.f13259a.mo23049b().mo22918c(str, "User requested preload of incentivized ad...");
        this.f13264f = new SoftReference<>(dVar);
        if (mo22876a()) {
            this.f13259a.mo23049b().mo22921e(str, "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (dVar != null) {
                dVar.adReceived(this.f13261c);
            }
            return;
        }
        mo22878b((C7254d) new C7092N(this, dVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22874a(String str) {
        synchronized (this.f13265g) {
            this.f13266h = str;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22875a(String str, Context context) {
        if (str != null && ((Boolean) this.f13259a.mo23039a(C7196pb.f13878sa)).booleanValue()) {
            new C7108S(this.f13259a, context, str).mo22950a();
        }
    }

    /* renamed from: a */
    public boolean mo22876a() {
        return this.f13261c != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo22877b() {
        String str;
        synchronized (this.f13265g) {
            str = this.f13266h;
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22878b(C7254d dVar) {
        if (!TextUtils.isEmpty(this.f13263e)) {
            this.f13260b.mo23010a(this.f13263e, dVar);
        } else {
            this.f13260b.mo23007a(dVar);
        }
    }
}
