package com.inmobi.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10545i.C10575b;
import com.inmobi.ads.C10545i.C10578e;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.cache.C10513a;
import com.inmobi.ads.cache.C10517d;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import com.mopub.common.AdType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.inmobi.ads.ac */
/* compiled from: InterstitialAdUnit */
public class C10365ac extends C10545i {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public static final String f31500A = InMobiInterstitial.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: z */
    public static final String f31501z = C10365ac.class.getSimpleName();

    /* renamed from: B */
    private int f31502B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public ArrayList<WeakReference<C10575b>> f31503C;

    /* renamed from: y */
    boolean f31504y;

    /* renamed from: com.inmobi.ads.ac$a */
    /* compiled from: InterstitialAdUnit */
    public static final class C10372a {

        /* renamed from: a */
        static final Map<C10455bi, C10365ac> f31516a = new HashMap();

        /* renamed from: a */
        public static C10365ac m33886a(Context context, C10455bi biVar, C10575b bVar) {
            long j = biVar.f31801a;
            C10365ac acVar = (C10365ac) f31516a.get(biVar);
            if (acVar != null) {
                if (acVar.mo34300h()) {
                    C10365ac.f31501z;
                    StringBuilder sb = new StringBuilder("Found expired adUnit for placement(");
                    sb.append(j);
                    sb.append("), thus clearing it.");
                    acVar.mo33995v();
                }
                acVar.mo34080a(context);
                if (bVar != null) {
                    acVar.mo34285a(bVar);
                }
                return acVar;
            }
            C10365ac acVar2 = new C10365ac(context, j, bVar, 0);
            f31516a.put(biVar, acVar2);
            return acVar2;
        }

        /* renamed from: b */
        static C10365ac m33887b(Context context, C10455bi biVar, C10575b bVar) {
            C10365ac acVar = new C10365ac(context, biVar.f31801a, bVar, 0);
            return acVar;
        }
    }

    /* renamed from: com.inmobi.ads.ac$b */
    /* compiled from: InterstitialAdUnit */
    private final class C10373b extends Exception {
        public C10373b(String str) {
            super(str);
        }
    }

    /* renamed from: com.inmobi.ads.ac$c */
    /* compiled from: InterstitialAdUnit */
    private final class C10374c extends Exception {
        public C10374c(String str) {
            super(str);
        }
    }

    /* synthetic */ C10365ac(Context context, long j, C10575b bVar, byte b) {
        this(context, j, bVar);
    }

    private C10365ac(Context context, long j, C10575b bVar) {
        super(context, j, bVar);
        this.f31502B = 0;
        this.f31504y = false;
        this.f31503C = new ArrayList<>(1);
        super.mo33972a(MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final RenderView mo33990k() {
        RenderView k = super.mo33990k();
        if (this.f31504y) {
            k.mo33678a();
        }
        return k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final boolean mo33987d(C10575b bVar) {
        boolean z;
        if (C10545i.m34584m()) {
            mo34288a("MissingDependency");
            mo33973a(new InMobiAdRequestStatus(StatusCode.MISSING_REQUIRED_DEPENDENCIES), true);
            return false;
        }
        this.f32187w = false;
        if (bVar == null) {
            mo34299g();
            return false;
        } else if (-1 == m33850g(bVar)) {
            this.f31503C.add(new WeakReference(bVar));
            if (!C10700d.m35146a()) {
                mo33973a(new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE), true);
                return false;
            }
            int i = this.f32165a;
            String str = "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ";
            if (i == 1) {
                InternalLogLevel internalLogLevel = InternalLogLevel.ERROR;
                String str2 = f31500A;
                StringBuilder sb = new StringBuilder(str);
                sb.append(this.f32168d);
                Logger.m35065a(internalLogLevel, str2, sb.toString());
                z = true;
            } else if (i == 2) {
                if (AdType.HTML.equals(this.f32177m)) {
                    InternalLogLevel internalLogLevel2 = InternalLogLevel.ERROR;
                    String str3 = f31500A;
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append(this.f32168d);
                    Logger.m35065a(internalLogLevel2, str3, sb2.toString());
                } else if (bVar != null) {
                    bVar.mo33782a(true);
                }
                z = true;
            } else if (i == 4) {
                if (bVar != null) {
                    bVar.mo33782a(true);
                }
                z = true;
            } else if (i == 7 || i == 8) {
                InternalLogLevel internalLogLevel3 = InternalLogLevel.ERROR;
                String str4 = f31500A;
                StringBuilder sb3 = new StringBuilder("An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ");
                sb3.append(this.f32168d);
                Logger.m35065a(internalLogLevel3, str4, sb3.toString());
                InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(StatusCode.AD_ACTIVE);
                mo34284a(inMobiAdRequestStatus);
                int g = m33850g(bVar);
                if (g != -1) {
                    this.f31503C.remove(g);
                }
                if (bVar != null) {
                    bVar.mo33748a(inMobiAdRequestStatus);
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return true;
            }
            mo34296d("AdLoadRequested");
            return false;
        } else {
            mo34287a(bVar, "ART", "LoadInProgress");
            return false;
        }
    }

    /* renamed from: n */
    public final void mo33992n() {
    }

    /* renamed from: e */
    public final void mo33988e(C10575b bVar) {
        if (mo33987d(bVar)) {
            super.mo33992n();
        }
    }

    /* renamed from: g */
    private int m33850g(C10575b bVar) {
        int i = -1;
        for (int i2 = 0; i2 < this.f31503C.size(); i2++) {
            WeakReference weakReference = (WeakReference) this.f31503C.get(i2);
            if (weakReference != null) {
                C10575b bVar2 = (C10575b) weakReference.get();
                if (bVar2 != null && bVar2.equals(bVar)) {
                    i = i2;
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public final int mo33994r() {
        int i = this.f32165a;
        if (1 == i) {
            InternalLogLevel internalLogLevel = InternalLogLevel.ERROR;
            String str = f31500A;
            StringBuilder sb = new StringBuilder("An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
            return 2;
        } else if (5 != i) {
            return super.mo33994r();
        } else {
            if (m33841R()) {
                return super.mo33994r();
            }
            return 1;
        }
    }

    /* renamed from: R */
    private boolean m33841R() {
        try {
            if (AdType.HTML.equals(this.f32177m)) {
                if (mo34300h()) {
                    super.mo33995v();
                    return true;
                }
                m33842S();
                return false;
            } else if (!m33848b(true)) {
                return true;
            } else {
                m33842S();
                return false;
            }
        } catch (C10373b e) {
            return true;
        } catch (C10374c e2) {
            return true;
        }
    }

    /* renamed from: S */
    private void m33842S() {
        this.f32183s.post(new Runnable() {
            public final void run() {
                for (int i = 0; i < C10365ac.this.f31503C.size(); i++) {
                    C10575b bVar = (C10575b) ((WeakReference) C10365ac.this.f31503C.get(i)).get();
                    if (bVar == null) {
                        C10365ac.this.mo34299g();
                    } else {
                        String str = "";
                        C10365ac.this.mo34287a(bVar, "VAR", str);
                        C10365ac.this.mo34287a(bVar, "ARF", str);
                        bVar.mo33782a(true);
                        bVar.mo33747a();
                        bVar.mo33781a((C10545i) C10365ac.this);
                    }
                }
                C10365ac.this.f31503C.clear();
            }
        });
    }

    /* renamed from: a */
    public final boolean mo33975a(C10359a aVar) {
        if (!super.mo33975a(aVar)) {
            mo33979b(aVar);
            return false;
        }
        if (aVar instanceof C10444bc) {
            C10444bc bcVar = (C10444bc) aVar;
            C10517d.m34431a();
            C10513a b = C10517d.m34433b(bcVar.f31769l);
            if (b == null || !b.mo34234a()) {
                return false;
            }
            C10475bx bxVar = new C10475bx(b.f32049e, bcVar.f31770m, bcVar.f31771n, bcVar.mo34145h(), bcVar.mo34146i(), this.f32171g.f31901m);
            this.f32174j = bxVar;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo33979b(C10359a aVar) {
        mo34301i().mo34267a(aVar);
    }

    /* renamed from: v */
    public final void mo33995v() {
        super.mo33995v();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final void mo33989f(C10575b bVar) {
        String str = "";
        String str2 = "AVRR";
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mo34287a(bVar, str2, str);
            Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.class.getSimpleName(), "Please ensure that you call show() on the UI thread");
        } else if (bVar == null) {
            mo34299g();
        } else if (!mo33969O()) {
            mo34287a(bVar, str2, str);
            Logger.m35065a(InternalLogLevel.ERROR, f31501z, "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", "ShowIntBeforeReady");
            mo34295c("AdShowFailed", (Map<String, Object>) hashMap);
            bVar.mo33783b();
        } else if (!C10694e.m35115e()) {
            super.mo33995v();
            bVar.mo33783b();
        } else {
            mo34285a(bVar);
            this.f32165a = 7;
            if (AdType.HTML.equals(this.f32177m)) {
                AdContainer j = mo34302j();
                if (mo34300h()) {
                    m33852i(bVar);
                    if (j != null) {
                        j.destroy();
                        return;
                    }
                } else {
                    m33851h(bVar);
                }
                return;
            }
            final WeakReference weakReference = new WeakReference(bVar);
            this.f32180p.execute(new Runnable() {
                public final void run() {
                    final C10575b bVar = (C10575b) weakReference.get();
                    if (bVar != null) {
                        try {
                            if (C10365ac.this.m33848b(false)) {
                                C10365ac.this.mo34286a(bVar, C10365ac.this.f32172h, new Runnable() {
                                    public final void run() {
                                        AdContainer j = C10365ac.this.mo34302j();
                                        C10365ac acVar = C10365ac.this;
                                        RenderView renderView = acVar.f32185u;
                                        if (renderView != null) {
                                            if (j instanceof C10380ah) {
                                                C10380ah ahVar = (C10380ah) j;
                                                ahVar.f31574w = renderView;
                                                ahVar.f31576y = acVar.f32182r;
                                            } else {
                                                acVar.m33852i(bVar);
                                            }
                                        }
                                        C10365ac.this.m33851h(bVar);
                                    }
                                }, Looper.getMainLooper());
                            } else {
                                Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.class.getSimpleName(), "Unable to Show Ad, canShowAd Failed");
                                C10365ac.this.m33852i(bVar);
                            }
                        } catch (C10373b e) {
                            Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.class.getSimpleName(), e.getMessage());
                            C10365ac.this.m33852i(bVar);
                        } catch (C10374c e2) {
                            Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.class.getSimpleName(), e2.getMessage());
                            C10365ac.this.m33852i(bVar);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m33851h(C10575b bVar) {
        mo34296d("ShowInt");
        boolean T = m33843T();
        if (bVar == null) {
            mo34299g();
        } else if (!T) {
            this.f32165a = 3;
            mo34287a(bVar, "AVRR", "");
            bVar.mo33783b();
        } else {
            bVar.mo33784c();
        }
    }

    /* renamed from: T */
    private boolean m33843T() {
        try {
            StringBuilder sb = new StringBuilder(">>> Starting ");
            sb.append(InMobiAdActivity.class.getSimpleName());
            sb.append(" to display interstitial ad ...");
            AdContainer j = mo34302j();
            if (j != null) {
                if (!"unknown".equals(j.getMarkupType())) {
                    int a = InMobiAdActivity.m35177a(j);
                    Intent intent = new Intent(mo34283a(), InMobiAdActivity.class);
                    intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", a);
                    intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
                    intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", AdType.HTML.equals(this.f32177m) ? 200 : 201);
                    intent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
                    C10619a.m34834a(mo34283a(), intent);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.class.getSimpleName(), "Cannot show ad; SDK encountered an unexpected error");
            new StringBuilder("Encountered unexpected error while showing ad: ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
            return false;
        }
    }

    /* renamed from: O */
    public final boolean mo33969O() {
        return this.f32165a == 5;
    }

    /* renamed from: b */
    public final String mo33976b() {
        return "int";
    }

    /* renamed from: c */
    public final String mo33981c() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final PlacementType mo33985d() {
        return PlacementType.PLACEMENT_TYPE_FULLSCREEN;
    }

    /* renamed from: a */
    public final void mo33970a(final long j, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.f32183s.post(new Runnable() {
            public final void run() {
                try {
                    if (j == C10365ac.this.f32168d) {
                        InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                        String Q = C10365ac.f31500A;
                        StringBuilder sb = new StringBuilder("Failed to fetch ad for placement id: ");
                        sb.append(j);
                        sb.append(", reason phrase available in onAdLoadFailed callback.");
                        Logger.m35065a(internalLogLevel, Q, sb.toString());
                        for (int i = 0; i < C10365ac.this.f31503C.size(); i++) {
                            C10575b bVar = (C10575b) ((WeakReference) C10365ac.this.f31503C.get(i)).get();
                            if (bVar == null) {
                                C10365ac.this.mo34299g();
                            } else {
                                String str = "";
                                if (i < C10365ac.this.f31503C.size() - 1) {
                                    C10365ac.this.mo34287a(bVar, "VAR", str);
                                }
                                C10365ac.this.mo34287a(bVar, "ARN", str);
                            }
                        }
                        C10365ac.this.mo33973a(inMobiAdRequestStatus, true);
                    }
                } catch (Exception e) {
                    Logger.m35065a(InternalLogLevel.ERROR, "[InMobi]", "Unable to load Ad; SDK encountered an unexpected error");
                    C10365ac.f31501z;
                    new StringBuilder("onAdFetchFailed with error: ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo33973a(InMobiAdRequestStatus inMobiAdRequestStatus, boolean z) {
        if (this.f32165a == 1 && z) {
            this.f32165a = 3;
        }
        Iterator it = this.f31503C.iterator();
        while (it.hasNext()) {
            C10575b bVar = (C10575b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.mo33748a(inMobiAdRequestStatus);
            } else {
                mo34299g();
            }
        }
        this.f31503C.clear();
        mo34284a(inMobiAdRequestStatus);
        super.mo33995v();
    }

    /* renamed from: c */
    public final void mo33982c(long j, C10359a aVar) {
        String str = "Unable to load ad; SDK encountered an internal error";
        try {
            super.mo33982c(j, aVar);
            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
            String str2 = f31500A;
            StringBuilder sb = new StringBuilder("Interstitial ad successfully fetched for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str2, sb.toString());
            if (j == this.f32168d && this.f32165a == 2) {
                mo34290a(true, mo33990k());
                try {
                    mo34286a(null, this.f32172h, null, null);
                } catch (Exception e) {
                    mo34278C();
                    mo33973a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
                    Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.class.getSimpleName(), str);
                    new StringBuilder("Loading ad markup into container encountered an unexpected error: ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        } catch (Exception e2) {
            Logger.m35065a(InternalLogLevel.ERROR, f31500A, str);
            new StringBuilder("Handling ad fetch successful encountered an unexpected error: ").append(e2.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e2));
        }
    }

    /* renamed from: a */
    public final void mo33971a(long j, boolean z, C10359a aVar) {
        try {
            super.mo33971a(j, z, aVar);
            if (j == this.f32168d) {
                if (1 == this.f32165a && z) {
                    this.f32165a = 2;
                    if (super.mo33975a(aVar)) {
                        mo34287a(mo34298f(), "ARF", "");
                        mo34293c(aVar);
                        if (aVar.f31484j) {
                            this.f32184t = true;
                            mo34281I();
                            return;
                        }
                        Iterator it = this.f31503C.iterator();
                        while (it.hasNext()) {
                            C10575b bVar = (C10575b) ((WeakReference) it.next()).get();
                            if (bVar != null) {
                                bVar.mo33782a(true);
                            } else {
                                mo34299g();
                            }
                        }
                        return;
                    }
                    Iterator it2 = this.f31503C.iterator();
                    while (it2.hasNext()) {
                        C10575b bVar2 = (C10575b) ((WeakReference) it2.next()).get();
                        if (bVar2 != null) {
                            bVar2.mo33782a(false);
                        } else {
                            mo34299g();
                        }
                    }
                } else if (4 == this.f32165a || 5 == this.f32165a || 2 == this.f32165a) {
                    this.f32165a = 0;
                    Iterator it3 = this.f31503C.iterator();
                    while (it3.hasNext()) {
                        C10575b bVar3 = (C10575b) ((WeakReference) it3.next()).get();
                        if (bVar3 != null) {
                            bVar3.mo33748a(new InMobiAdRequestStatus(StatusCode.AD_NO_LONGER_AVAILABLE));
                        } else {
                            mo34299g();
                        }
                        this.f31503C.clear();
                    }
                }
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, InMobiInterstitial.class.getSimpleName(), "Unable to load ad; SDK encountered an internal error");
            new StringBuilder("Handling ad availability change event encountered an unexpected error: ").append(e.getMessage());
        }
    }

    /* renamed from: b */
    public final void mo33977b(long j, boolean z) {
        super.mo33977b(j, z);
        if (!z) {
            if (j == this.f32168d) {
                int i = this.f32165a;
                if (2 == i || 5 == i) {
                    this.f32165a = 0;
                    mo33973a(new InMobiAdRequestStatus(StatusCode.AD_NO_LONGER_AVAILABLE), false);
                }
            }
        } else if (j == this.f32168d && 2 == this.f32165a) {
            if (this.f32184t) {
                this.f32186v = true;
                mo34282J();
                return;
            }
            mo33967K();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: K */
    public final void mo33967K() {
        mo34280F();
        this.f32165a = 5;
        for (int i = 0; i < this.f31503C.size(); i++) {
            C10575b bVar = (C10575b) ((WeakReference) this.f31503C.get(i)).get();
            if (bVar == null) {
                mo34299g();
            } else {
                if (i < this.f31503C.size() - 1) {
                    String str = "";
                    mo34287a(bVar, "VAR", str);
                    mo34287a(bVar, "ARF", str);
                }
                bVar.mo33781a((C10545i) this);
            }
        }
        this.f31503C.clear();
    }

    /* renamed from: x */
    public final void mo33996x() {
        super.mo33996x();
        if (this.f32165a == 4) {
            mo34278C();
            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
            String str = f31500A;
            StringBuilder sb = new StringBuilder("Successfully loaded Interstitial ad markup in the WebView for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
            mo34305s();
            mo33967K();
        }
    }

    /* renamed from: a */
    public final void mo33974a(RenderView renderView) {
        super.mo33974a(renderView);
        if (this.f32165a == 2) {
            this.f32165a = 4;
            mo33968L();
        }
    }

    /* renamed from: z */
    public final void mo33997z() {
        super.mo33997z();
        if (this.f32165a == 4) {
            mo34278C();
            this.f32165a = 3;
            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
            String str = f31500A;
            StringBuilder sb = new StringBuilder("Failed to load the Interstitial markup in the WebView for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
            mo33973a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
        }
    }

    /* renamed from: c */
    public final synchronized void mo33984c(RenderView renderView) {
        super.mo33984c(renderView);
        mo33980b(mo34298f());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo33980b(C10575b bVar) {
        int i = this.f32165a;
        if (i == 7) {
            this.f31502B++;
            if (this.f31502B == 1) {
                mo34296d("AdRendered");
                InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                String str = f31500A;
                StringBuilder sb = new StringBuilder("Successfully displayed Interstitial for placement id: ");
                sb.append(this.f32168d);
                Logger.m35065a(internalLogLevel, str, sb.toString());
                if (bVar != null) {
                    bVar.mo33753d();
                } else {
                    mo34299g();
                }
            } else {
                this.f32165a = 8;
            }
        } else {
            if (i == 8) {
                this.f31502B++;
            }
        }
    }

    /* renamed from: d */
    public final synchronized void mo33986d(RenderView renderView) {
        super.mo33986d(renderView);
        mo33983c(mo34298f());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo33983c(C10575b bVar) {
        int i = this.f32165a;
        if (i == 8) {
            this.f31502B--;
            if (this.f31502B == 1) {
                this.f32165a = 7;
            }
        } else if (i == 7) {
            this.f31502B--;
            mo34296d("IntClosed");
            super.mo33995v();
            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
            String str = f31500A;
            StringBuilder sb = new StringBuilder("Interstitial ad dismissed for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
            if (bVar != null) {
                bVar.mo33754e();
                return;
            }
            mo34299g();
        }
    }

    /* renamed from: E */
    public final void mo33965E() {
        mo34292b("RenderTimeOut");
        if (this.f32175k != null) {
            mo34301i().mo34269a(this.f32175k);
        }
        int i = this.f32165a;
        if (4 == i || 2 == i) {
            this.f32165a = 3;
            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
            String str = f31501z;
            StringBuilder sb = new StringBuilder("Failed to load the Interstitial markup in the webview due to time out for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
            mo33973a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: L */
    public final void mo33968L() {
        Iterator it = this.f31503C.iterator();
        while (it.hasNext()) {
            C10575b bVar = (C10575b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.mo33782a(true);
            } else {
                mo34299g();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m33848b(boolean z) throws C10373b, C10374c {
        C10359a aVar;
        String str = this.f32175k;
        if (str == null) {
            return false;
        }
        if (z) {
            mo34301i();
            C10438b.m34171b();
            aVar = C10528d.m34491c(str);
        } else {
            C10540h i = mo34301i();
            C10540h.m34541c();
            C10528d dVar = i.f32135b;
            C10359a c = C10528d.m34491c(str);
            if (c != null) {
                C10528d.m34484a(str);
            }
            i.mo34268a(i.f32136c);
            aVar = c;
        }
        if (aVar == null) {
            throw new C10373b("No Cached Ad found for AdUnit");
        } else if (mo33975a(aVar)) {
            return true;
        } else {
            throw new C10374c("No Cached Asset for AdUnit");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m33852i(final C10575b bVar) {
        mo34287a(bVar, "AVFB", "");
        this.f32183s.post(new Runnable() {
            public final void run() {
                C10365ac acVar = C10365ac.this;
                acVar.f32165a = 0;
                C10575b bVar = bVar;
                if (bVar != null) {
                    bVar.mo33783b();
                } else {
                    acVar.mo34299g();
                }
            }
        });
    }

    /* renamed from: a */
    public final void mo33972a(MonetizationContext monetizationContext) {
        super.mo33972a(MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY);
    }

    /* renamed from: l */
    public final MonetizationContext mo33991l() {
        return MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public final void mo33993q() {
        this.f32183s.post(new Runnable() {
            public final void run() {
                try {
                    C10365ac.this.f32187w = false;
                    if (C10365ac.this.mo34304p()) {
                        C10365ac.this.mo34294c("IllegalState");
                    } else {
                        C10365ac.super.mo33993q();
                    }
                } catch (Exception e) {
                    Logger.m35065a(InternalLogLevel.ERROR, C10365ac.f31500A, "Unable to Prefetch ad; SDK encountered an unexpected error");
                    C10365ac.f31501z;
                    new StringBuilder("Prefetch failed with unexpected error: ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        });
    }

    /* renamed from: H */
    public final void mo33966H() {
        if (1 == this.f32165a) {
            this.f32165a = 9;
            C10578e eVar = this.f32181q;
            if (eVar != null) {
                eVar.mo33744a(this);
            }
            Iterator it = this.f31503C.iterator();
            while (it.hasNext()) {
                C10575b bVar = (C10575b) ((WeakReference) it.next()).get();
                if (bVar != null) {
                    mo33988e(bVar);
                    return;
                }
                mo34299g();
            }
        }
    }

    /* renamed from: b */
    public final void mo33978b(InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (1 == this.f32165a) {
            this.f32165a = 3;
            C10578e eVar = this.f32181q;
            if (eVar != null) {
                eVar.mo33745a(this, inMobiAdRequestStatus);
            }
            if (this.f31503C.size() > 0) {
                mo33973a(inMobiAdRequestStatus, false);
            }
        }
    }
}
