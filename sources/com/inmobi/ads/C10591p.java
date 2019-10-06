package com.inmobi.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10545i.C10575b;
import com.inmobi.ads.C10545i.C10578e;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.p212c.C10491a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.RenderView;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.inmobi.ads.p */
/* compiled from: BannerAdUnit */
public class C10591p extends C10545i implements ActivityLifecycleCallbacks {

    /* renamed from: B */
    private static final String f32265B = C10591p.class.getSimpleName();

    /* renamed from: C */
    private static final String f32266C = InMobiBanner.class.getSimpleName();

    /* renamed from: A */
    public String f32267A;

    /* renamed from: D */
    private boolean f32268D;

    /* renamed from: E */
    private int f32269E = 0;

    /* renamed from: y */
    public boolean f32270y = false;

    /* renamed from: z */
    boolean f32271z = false;

    /* renamed from: a */
    public static C10591p m34724a(Context context, C10455bi biVar, C10575b bVar, int i) {
        C10591p pVar;
        C10545i iVar = (C10545i) C10491a.f31975a.get(biVar);
        if (iVar instanceof C10591p) {
            pVar = (C10591p) iVar;
        } else {
            pVar = null;
        }
        if (pVar == null || 1 != i) {
            if (pVar == null) {
                new StringBuilder("Creating new adUnit for placement-ID : ").append(biVar.f31801a);
                pVar = new C10591p(context, biVar.f31801a, bVar);
                if (i != 0) {
                    C10491a.f31975a.put(biVar, pVar);
                }
            } else {
                new StringBuilder("Found pre-fetching adUnit for placement-ID : ").append(biVar.f31801a);
                super.mo34080a(context);
                C10491a.f31975a.remove(biVar);
                pVar.f32268D = true;
            }
            pVar.mo34285a(bVar);
            pVar.mo33972a(biVar.f31806f);
            return pVar;
        }
        throw new IllegalStateException("There's already a pre-loading going on for the same placementID");
    }

    private C10591p(Context context, long j, C10575b bVar) {
        super(context, j, bVar);
    }

    /* renamed from: a */
    public final void mo34080a(Context context) {
        super.mo34080a(context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: O */
    public final void mo33969O() {
        RenderView renderView = (RenderView) mo34302j();
        if (renderView != null) {
            this.f32271z = true;
            renderView.mo33678a();
        }
    }

    /* renamed from: b */
    public final void mo34393b(boolean z) {
        if (z) {
            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
            String str = f32266C;
            StringBuilder sb = new StringBuilder("Initiating Banner refresh for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
        }
        InternalLogLevel internalLogLevel2 = InternalLogLevel.DEBUG;
        String str2 = f32266C;
        StringBuilder sb2 = new StringBuilder("Fetching a Banner ad for placement id: ");
        sb2.append(this.f32168d);
        Logger.m35065a(internalLogLevel2, str2, sb2.toString());
        this.f32187w = false;
        this.f32270y = z;
        int i = this.f32165a;
        if (1 == i) {
            Logger.m35065a(InternalLogLevel.ERROR, f32265B, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            if (!this.f32268D) {
                mo33973a(new InMobiAdRequestStatus(StatusCode.REQUEST_PENDING), false);
            }
        } else if (2 == i || 8 == i) {
            mo33973a(new InMobiAdRequestStatus(StatusCode.AD_ACTIVE), false);
            InternalLogLevel internalLogLevel3 = InternalLogLevel.ERROR;
            String str3 = f32266C;
            StringBuilder sb3 = new StringBuilder("An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ");
            sb3.append(this.f32168d);
            Logger.m35065a(internalLogLevel3, str3, sb3.toString());
        } else {
            super.mo33992n();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public final int mo33994r() {
        int i = this.f32165a;
        if (1 == i || 2 == i) {
            this.f32183s.post(new Runnable() {
                public final void run() {
                    C10591p.this.mo33973a(new InMobiAdRequestStatus(StatusCode.REQUEST_PENDING), false);
                }
            });
            InternalLogLevel internalLogLevel = InternalLogLevel.ERROR;
            String str = f32266C;
            StringBuilder sb = new StringBuilder("An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str, sb.toString());
            return 2;
        } else if (i != 8) {
            return super.mo33994r();
        } else {
            this.f32183s.post(new Runnable() {
                public final void run() {
                    C10591p.this.mo33973a(new InMobiAdRequestStatus(StatusCode.AD_ACTIVE), false);
                }
            });
            InternalLogLevel internalLogLevel2 = InternalLogLevel.ERROR;
            String str2 = f32266C;
            StringBuilder sb2 = new StringBuilder("An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ");
            sb2.append(this.f32168d);
            Logger.m35065a(internalLogLevel2, str2, sb2.toString());
            return 3;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo33979b(C10359a aVar) {
    }

    /* renamed from: q */
    public final void mo33993q() {
        super.mo33993q();
    }

    /* renamed from: H */
    public final void mo33966H() {
        if (1 == this.f32165a) {
            this.f32165a = 9;
            if (!this.f32178n) {
                this.f32268D = false;
                mo34393b(false);
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
            if (!this.f32178n) {
                C10575b f = mo34298f();
                if (f != null) {
                    this.f32268D = false;
                    String str = "";
                    mo34287a(f, "VAR", str);
                    mo34287a(f, "ARN", str);
                    f.mo33748a(inMobiAdRequestStatus);
                    return;
                }
                C10578e eVar = this.f32181q;
                if (eVar != null) {
                    eVar.mo33745a(this, inMobiAdRequestStatus);
                }
                return;
            }
            C10578e eVar2 = this.f32181q;
            if (eVar2 != null) {
                eVar2.mo33745a(this, inMobiAdRequestStatus);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: P */
    public final boolean mo34389P() {
        return this.f32165a == 8;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final RenderView mo33990k() {
        RenderView k = super.mo33990k();
        if (this.f32271z) {
            k.mo33678a();
        }
        return k;
    }

    /* renamed from: b */
    public final String mo33976b() {
        return "banner";
    }

    /* renamed from: c */
    public final String mo33981c() {
        return this.f32267A;
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
        e.put("u-rt", this.f32270y ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        e.put("mk-ad-slot", this.f32267A);
        return e;
    }

    /* renamed from: c */
    public final void mo33982c(long j, C10359a aVar) {
        String str = "Unable to load ad; SDK encountered an internal error";
        try {
            super.mo33982c(j, aVar);
            InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
            String str2 = f32266C;
            StringBuilder sb = new StringBuilder("Banner ad fetch successful for placement id: ");
            sb.append(this.f32168d);
            Logger.m35065a(internalLogLevel, str2, sb.toString());
            if (j == this.f32168d && this.f32165a == 2) {
                mo34290a(false, mo33990k());
                try {
                    InternalLogLevel internalLogLevel2 = InternalLogLevel.DEBUG;
                    String str3 = f32266C;
                    StringBuilder sb2 = new StringBuilder("Started loading banner ad markup in WebView for placement id: ");
                    sb2.append(this.f32168d);
                    Logger.m35065a(internalLogLevel2, str3, sb2.toString());
                    mo34286a(null, this.f32172h, null, null);
                } catch (Exception e) {
                    mo34278C();
                    if (mo34298f() != null) {
                        mo34298f().mo33748a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                    }
                    Logger.m35065a(InternalLogLevel.ERROR, f32266C, str);
                    new StringBuilder("Loading ad markup into container encountered an unexpected error: ").append(e.getMessage());
                }
            }
        } catch (Exception e2) {
            Logger.m35065a(InternalLogLevel.ERROR, f32266C, str);
            new StringBuilder("Handling ad fetch successful encountered an unexpected error: ").append(e2.getMessage());
        }
    }

    /* renamed from: a */
    public final void mo33974a(RenderView renderView) {
        try {
            super.mo33974a(renderView);
            if (this.f32165a == 2) {
                mo34278C();
                this.f32165a = 4;
                mo34280F();
                InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                String str = f32266C;
                StringBuilder sb = new StringBuilder("Successfully loaded Banner ad markup in the WebView for placement id: ");
                sb.append(this.f32168d);
                Logger.m35065a(internalLogLevel, str, sb.toString());
                if (mo34298f() != null) {
                    mo34298f().mo33747a();
                }
                mo34305s();
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f32266C, "Unable to load ad; SDK encountered an internal error");
            new StringBuilder("Loading ad markup into container encountered an unexpected error: ").append(e.getMessage());
        }
    }

    /* renamed from: b */
    public final void mo34053b(RenderView renderView) {
        try {
            super.mo34053b(renderView);
            if (this.f32165a == 4) {
                this.f32165a = 7;
                mo34296d("AdRendered");
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f32266C, "Unable to load ad; SDK encountered an internal error");
            new StringBuilder("BannerAdUnit.onRenderViewVisible threw unexpected error: ").append(e.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo33984c(com.inmobi.rendering.RenderView r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            super.mo33984c(r5)     // Catch:{ Exception -> 0x004a }
            int r5 = r4.f32165a     // Catch:{ Exception -> 0x004a }
            r0 = 7
            r1 = 8
            if (r5 != r0) goto L_0x003b
            int r5 = r4.f32269E     // Catch:{ Exception -> 0x004a }
            int r5 = r5 + 1
            r4.f32269E = r5     // Catch:{ Exception -> 0x004a }
            r4.f32165a = r1     // Catch:{ Exception -> 0x004a }
            com.inmobi.commons.core.utilities.Logger$InternalLogLevel r5 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.DEBUG     // Catch:{ Exception -> 0x004a }
            java.lang.String r0 = f32266C     // Catch:{ Exception -> 0x004a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            java.lang.String r2 = "Successfully displayed banner ad for placement Id : "
            r1.<init>(r2)     // Catch:{ Exception -> 0x004a }
            long r2 = r4.f32168d     // Catch:{ Exception -> 0x004a }
            r1.append(r2)     // Catch:{ Exception -> 0x004a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x004a }
            com.inmobi.commons.core.utilities.Logger.m35065a(r5, r0, r1)     // Catch:{ Exception -> 0x004a }
            com.inmobi.ads.i$b r5 = r4.mo34298f()     // Catch:{ Exception -> 0x004a }
            if (r5 == 0) goto L_0x0046
            com.inmobi.ads.i$b r5 = r4.mo34298f()     // Catch:{ Exception -> 0x004a }
            r5.mo33753d()     // Catch:{ Exception -> 0x004a }
            monitor-exit(r4)
            return
        L_0x003b:
            int r5 = r4.f32165a     // Catch:{ Exception -> 0x004a }
            if (r5 != r1) goto L_0x0046
            int r5 = r4.f32269E     // Catch:{ Exception -> 0x004a }
            int r5 = r5 + 1
            r4.f32269E = r5     // Catch:{ Exception -> 0x004a }
        L_0x0046:
            monitor-exit(r4)
            return
        L_0x0048:
            r5 = move-exception
            goto L_0x0064
        L_0x004a:
            r5 = move-exception
            com.inmobi.commons.core.utilities.Logger$InternalLogLevel r0 = com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = f32266C     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "Unable to display ad; SDK encountered an internal error"
            com.inmobi.commons.core.utilities.Logger.m35065a(r0, r1, r2)     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = "BannerAdUnit.onAdScreenDisplayed threw unexpected error: "
            r0.<init>(r1)     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0048 }
            r0.append(r5)     // Catch:{ all -> 0x0048 }
            monitor-exit(r4)
            return
        L_0x0064:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10591p.mo33984c(com.inmobi.rendering.RenderView):void");
    }

    /* renamed from: d */
    public final synchronized void mo33986d(RenderView renderView) {
        try {
            super.mo33986d(renderView);
            if (this.f32165a == 8) {
                int i = this.f32269E - 1;
                this.f32269E = i;
                if (i == 0) {
                    this.f32165a = 7;
                    if (mo34298f() != null) {
                        mo34298f().mo33754e();
                    }
                }
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f32266C, "Unable to dismiss ad; SDK encountered an internal error");
            new StringBuilder("BannerAdUnit.onAdScreenDismissed threw unexpected error: ").append(e.getMessage());
        }
    }

    /* renamed from: Q */
    public final void mo34390Q() {
        int i = this.f32165a;
        if (i == 4 || i == 7 || i == 8) {
            AdContainer j = mo34302j();
            if (j != null) {
                C10503ca viewableAd = j.getViewableAd();
                if (viewableAd != null) {
                    viewableAd.mo33962d();
                }
            }
        }
    }

    /* renamed from: R */
    public final void mo34391R() {
        int i = this.f32165a;
        if (i == 4 || i == 7 || i == 8) {
            AdContainer j = mo34302j();
            if (j != null) {
                C10503ca viewableAd = j.getViewableAd();
                if (viewableAd != null) {
                    viewableAd.mo33959a(new View[0]);
                }
            }
        }
    }

    /* renamed from: S */
    public final void mo34392S() {
        if (mo34283a() instanceof Activity) {
            ((Activity) mo34283a()).getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        Context a = mo34283a();
        if (a != null && a.equals(activity)) {
            mo34391R();
        }
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        Context a = mo34283a();
        if (a != null && a.equals(activity)) {
            mo34390Q();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        Context a = mo34283a();
        if (a != null && a.equals(activity)) {
            ((Activity) a).getApplication().unregisterActivityLifecycleCallbacks(this);
            mo33995v();
        }
    }
}
