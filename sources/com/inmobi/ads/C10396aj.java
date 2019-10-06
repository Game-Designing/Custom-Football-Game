package com.inmobi.ads;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10545i.C10575b;
import com.inmobi.ads.C10545i.C10578e;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.cache.C10513a;
import com.inmobi.ads.cache.C10517d;
import com.inmobi.ads.p212c.C10491a;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.inmobi.ads.aj */
/* compiled from: NativeAdUnit */
public final class C10396aj extends C10545i {
    /* access modifiers changed from: 0000 */

    /* renamed from: y */
    public static final String f31597y = C10396aj.class.getSimpleName();

    /* renamed from: A */
    boolean f31598A = false;

    /* renamed from: B */
    private boolean f31599B;

    /* renamed from: C */
    private C10359a f31600C;

    /* renamed from: D */
    private int f31601D = 0;

    /* renamed from: z */
    WeakReference<View> f31602z;

    /* renamed from: a */
    public static C10396aj m34024a(Context context, C10455bi biVar, C10575b bVar, int i) {
        C10396aj ajVar;
        C10545i iVar = (C10545i) C10491a.f31975a.get(biVar);
        if (iVar instanceof C10396aj) {
            ajVar = (C10396aj) iVar;
        } else {
            ajVar = null;
        }
        if (ajVar == null || 1 != i) {
            if (ajVar == null) {
                new StringBuilder("Creating new adUnit for placement-ID : ").append(biVar.f31801a);
                ajVar = new C10396aj(context, biVar.f31801a, bVar);
                if (i != 0) {
                    C10491a.f31975a.put(biVar, ajVar);
                }
            } else {
                new StringBuilder("Found pre-fetching adUnit for placement-ID : ").append(biVar.f31801a);
                ajVar.mo34080a(context);
                C10491a.f31975a.remove(biVar);
                ajVar.f31599B = true;
            }
            ajVar.mo34285a(bVar);
            ajVar.mo33972a(biVar.f31806f);
            return ajVar;
        }
        throw new IllegalStateException("There's already a pre-loading going on for the same placementID");
    }

    private C10396aj(Context context, long j, C10575b bVar) {
        super(context, j, bVar);
    }

    /* renamed from: a */
    public final void mo34080a(Context context) {
        super.mo34080a(context);
        m34025b(context);
    }

    /* renamed from: n */
    public final void mo33992n() {
        if (!this.f32187w) {
            C10575b f = mo34298f();
            if (C10545i.m34584m()) {
                mo34288a("MissingDependency");
                if (f != null) {
                    f.mo33748a(new InMobiAdRequestStatus(StatusCode.MISSING_REQUIRED_DEPENDENCIES));
                }
                return;
            }
            int i = this.f32165a;
            if (1 == i || 2 == i) {
                Logger.m35065a(InternalLogLevel.ERROR, f31597y, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
                if (!this.f31599B) {
                    mo33973a(new InMobiAdRequestStatus(StatusCode.REQUEST_PENDING), false);
                }
                return;
            }
            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
            String str = f31597y;
            StringBuilder sb = new StringBuilder("Fetching a Native ad for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
            if (5 != this.f32165a || mo34300h()) {
                super.mo33992n();
                return;
            }
            String str2 = "";
            mo34287a(f, "VAR", str2);
            mo34287a(f, "ARF", str2);
            if (f != null) {
                m34025b(mo34283a());
                f.mo33747a();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public final int mo33994r() {
        int i = this.f32165a;
        if (1 != i && 2 != i) {
            return super.mo33994r();
        }
        InternalLogLevel internalLogLevel = InternalLogLevel.ERROR;
        StringBuilder sb = new StringBuilder("An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ");
        sb.append(this.f32168d);
        Logger.m35065a(internalLogLevel, "InMobi", sb.toString());
        this.f32183s.post(new Runnable() {
            public final void run() {
                C10396aj.this.mo33973a(new InMobiAdRequestStatus(StatusCode.REQUEST_PENDING), false);
            }
        });
        return 2;
    }

    /* renamed from: b */
    private void m34025b(Context context) {
        AdContainer j = mo34302j();
        if (j instanceof C10380ah) {
            ((C10380ah) j).mo34008a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public final void mo33993q() {
        try {
            if (mo34304p()) {
                mo34294c("IllegalState");
            } else {
                super.mo34081a(false);
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Unable to Prefetch ad; SDK encountered an unexpected error");
            new StringBuilder("Prefetch failed with unexpected error: ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    /* renamed from: a */
    public final void mo34081a(boolean z) {
        try {
            if (mo34304p()) {
                mo34294c("IllegalState");
            } else {
                super.mo34081a(z);
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Unable to Prefetch ad; SDK encountered an unexpected error");
            new StringBuilder("Prefetch failed with unexpected error: ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo33979b(C10359a aVar) {
        mo34301i().mo34267a(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo33977b(long j, boolean z) {
        super.mo33977b(j, z);
        boolean z2 = false;
        if (!z) {
            if (j == this.f32168d) {
                int i = this.f32165a;
                if (2 == i || 5 == i) {
                    this.f32165a = 0;
                    if (mo34298f() != null) {
                        mo34298f().mo33748a(new InMobiAdRequestStatus(StatusCode.AD_NO_LONGER_AVAILABLE));
                    }
                }
            }
        } else if (j == this.f32168d && 2 == this.f32165a) {
            C10575b f = mo34298f();
            if (f != null) {
                C10359a aVar = this.f31600C;
                if (aVar != null) {
                    if (aVar instanceof C10444bc) {
                        C10444bc bcVar = (C10444bc) aVar;
                        C10517d.m34431a();
                        C10513a b = C10517d.m34433b(bcVar.f31769l);
                        if (b != null && b.mo34234a()) {
                            C10475bx bxVar = new C10475bx(b.f32049e, bcVar.f31770m, bcVar.f31771n, bcVar.mo34145h(), bcVar.mo34146i(), this.f32171g.f31901m);
                            this.f32174j = bxVar;
                        }
                    }
                    z2 = true;
                }
                if (!z2) {
                    f.mo33748a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                } else if (mo34283a() != null) {
                    if (this.f32184t) {
                        this.f32186v = true;
                        mo34282J();
                        return;
                    }
                    mo33967K();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo33982c(long j, C10359a aVar) {
        super.mo33982c(j, aVar);
        this.f31600C = aVar;
        if (mo33975a(aVar)) {
            if (this.f32182r != 0 || aVar.f31484j) {
                mo34293c(aVar);
            } else {
                mo34290a(true, (RenderView) null);
            }
            if (aVar.f31484j) {
                this.f32184t = true;
                mo34281I();
            }
        }
    }

    /* renamed from: a */
    public final boolean mo33975a(C10359a aVar) {
        if (super.mo33975a(aVar)) {
            return true;
        }
        mo33979b(aVar);
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: K */
    public final void mo33967K() {
        mo34286a(mo34298f(), this.f32172h, new Runnable() {
            public final void run() {
                C10396aj ajVar = C10396aj.this;
                if (2 == ajVar.f32165a) {
                    ajVar.f32165a = 5;
                    AdContainer j = ajVar.mo34302j();
                    C10396aj ajVar2 = C10396aj.this;
                    RenderView renderView = ajVar2.f32185u;
                    C10575b f = ajVar2.mo34298f();
                    if (j instanceof C10380ah) {
                        C10380ah ahVar = (C10380ah) j;
                        ahVar.f31574w = renderView;
                        C10396aj ajVar3 = C10396aj.this;
                        ahVar.f31576y = ajVar3.f32182r;
                        ajVar3.mo34280F();
                        if (f != null) {
                            C10396aj.f31597y;
                            f.mo33747a();
                        }
                    } else {
                        if (f != null) {
                            C10396aj.f31597y;
                            f.mo33748a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                        }
                    }
                }
            }
        }, Looper.getMainLooper());
    }

    /* renamed from: O */
    public final void mo33969O() {
        try {
            super.mo33995v();
            this.f32172h = null;
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not destroy native ad; SDK encountered unexpected error");
            new StringBuilder("SDK encountered unexpected error in destroying native ad unit; ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    /* renamed from: P */
    public final boolean mo34079P() {
        return this.f32165a == 5;
    }

    /* renamed from: b */
    public final String mo33976b() {
        return "native";
    }

    /* renamed from: c */
    public final String mo33981c() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final PlacementType mo33985d() {
        return PlacementType.PLACEMENT_TYPE_INLINE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final Map<String, String> mo34082e() {
        Map<String, String> e = super.mo34082e();
        e.put("a-parentViewWidth", String.valueOf(C10692c.m35104a().f32627a));
        e.put("a-productVersion", "NS-1.0.0-20160411");
        e.put("trackerType", "url_ping");
        return e;
    }

    /* renamed from: H */
    public final void mo33966H() {
        if (1 == this.f32165a) {
            this.f32165a = 9;
            if (!this.f32178n) {
                this.f31599B = false;
                mo33992n();
                return;
            }
            C10578e eVar = this.f32181q;
            if (eVar != null) {
                eVar.mo33744a(this);
            }
        }
    }

    /* renamed from: b */
    public final void mo33978b(InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (1 == this.f32165a) {
            this.f32165a = 3;
            C10575b f = mo34298f();
            if (this.f32178n || f == null) {
                C10578e eVar = this.f32181q;
                if (eVar != null) {
                    eVar.mo33745a(this, inMobiAdRequestStatus);
                }
            } else {
                this.f31599B = false;
                String str = "";
                mo34287a(f, "VAR", str);
                mo34287a(f, "ARN", str);
                f.mo33748a(inMobiAdRequestStatus);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo33980b(C10575b bVar) {
        int i = this.f32165a;
        if (i == 5) {
            this.f32165a = 7;
        } else if (i == 7) {
            this.f31601D++;
        }
        InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
        StringBuilder sb = new StringBuilder("Successfully displayed fullscreen for placement id: ");
        sb.append(this.f32168d);
        Logger.m35065a(internalLogLevel, "InMobi", sb.toString());
        if (this.f31601D == 0) {
            if (bVar != null) {
                bVar.mo33753d();
                return;
            }
            mo34299g();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo33983c(C10575b bVar) {
        if (this.f32165a == 7) {
            int i = this.f31601D;
            if (i > 0) {
                this.f31601D = i - 1;
            } else {
                this.f32165a = 5;
            }
        }
        InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
        StringBuilder sb = new StringBuilder("Successfully dismissed fullscreen for placement id: ");
        sb.append(this.f32168d);
        Logger.m35065a(internalLogLevel, "InMobi", sb.toString());
        if (this.f31601D == 0 && this.f32165a == 5) {
            if (bVar != null) {
                bVar.mo33754e();
                return;
            }
            mo34299g();
        }
    }
}
