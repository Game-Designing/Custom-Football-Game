package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzabe {

    /* renamed from: a */
    private static zzabe f23864a;

    /* renamed from: b */
    private static final Object f23865b = new Object();

    /* renamed from: c */
    private zzaab f23866c;

    /* renamed from: d */
    private RewardedVideoAd f23867d;

    /* renamed from: e */
    private zztw f23868e;

    /* renamed from: d */
    public static zzabe m24652d() {
        zzabe zzabe;
        synchronized (f23865b) {
            if (f23864a == null) {
                f23864a = new zzabe();
            }
            zzabe = f23864a;
        }
        return zzabe;
    }

    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.gms.internal.ads.zztw, com.google.android.gms.internal.ads.c] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v9, types: [com.google.android.gms.internal.ads.zztw, com.google.android.gms.internal.ads.c]
      assigns: [com.google.android.gms.internal.ads.c]
      uses: [com.google.android.gms.internal.ads.zztw]
      mth insns count: 53
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo29477a(android.content.Context r3, java.lang.String r4, com.google.android.gms.internal.ads.zzabi r5, com.google.android.gms.internal.ads.zztx r6) {
        /*
            r2 = this;
            java.lang.Object r5 = f23865b
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzaab r6 = r2.f23866c     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x0009
            monitor-exit(r5)     // Catch:{ all -> 0x0089 }
            return
        L_0x0009:
            if (r3 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzami.m25219a(r3, r4)     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzyh r6 = com.google.android.gms.internal.ads.zzyt.m31533b()     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.ju r0 = new com.google.android.gms.internal.ads.ju     // Catch:{ RemoteException -> 0x0079 }
            r0.<init>(r6, r3)     // Catch:{ RemoteException -> 0x0079 }
            r6 = 0
            java.lang.Object r0 = r0.mo29114a(r3, r6)     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzaab r0 = (com.google.android.gms.internal.ads.zzaab) r0     // Catch:{ RemoteException -> 0x0079 }
            r2.f23866c = r0     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzaab r0 = r2.f23866c     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzamo r1 = new com.google.android.gms.internal.ads.zzamo     // Catch:{ RemoteException -> 0x0079 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0079 }
            r0.mo29349a(r1)     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzaab r0 = r2.f23866c     // Catch:{ RemoteException -> 0x0079 }
            r0.mo29344E()     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzaab r0 = r2.f23866c     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.b r1 = new com.google.android.gms.internal.ads.b     // Catch:{ RemoteException -> 0x0079 }
            r1.<init>(r2, r3)     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.ObjectWrapper.m22188a(r1)     // Catch:{ RemoteException -> 0x0079 }
            r0.mo29350a(r4, r1)     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzacu.m24782a(r3)     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.f24055_d     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzacr r4 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ RemoteException -> 0x0079 }
            java.lang.Object r3 = r4.mo29599a(r3)     // Catch:{ RemoteException -> 0x0079 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ RemoteException -> 0x0079 }
            boolean r3 = r3.booleanValue()     // Catch:{ RemoteException -> 0x0079 }
            if (r3 != 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.f24093fe     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.zzacr r4 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ RemoteException -> 0x0079 }
            java.lang.Object r3 = r4.mo29599a(r3)     // Catch:{ RemoteException -> 0x0079 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ RemoteException -> 0x0079 }
            boolean r3 = r3.booleanValue()     // Catch:{ RemoteException -> 0x0079 }
            if (r3 == 0) goto L_0x0068
            r6 = 1
            goto L_0x0069
        L_0x0068:
        L_0x0069:
            if (r6 != 0) goto L_0x0078
            java.lang.String r3 = "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time."
            com.google.android.gms.internal.ads.zzbad.m26355b(r3)     // Catch:{ RemoteException -> 0x0079 }
            com.google.android.gms.internal.ads.c r3 = new com.google.android.gms.internal.ads.c     // Catch:{ RemoteException -> 0x0079 }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x0079 }
            r2.f23868e = r3     // Catch:{ RemoteException -> 0x0079 }
        L_0x0078:
            goto L_0x007f
        L_0x0079:
            r3 = move-exception
            java.lang.String r4 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.internal.ads.zzbad.m26358c(r4, r3)     // Catch:{ all -> 0x0089 }
        L_0x007f:
            monitor-exit(r5)     // Catch:{ all -> 0x0089 }
            return
        L_0x0081:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0089 }
            java.lang.String r4 = "Context cannot be null."
            r3.<init>(r4)     // Catch:{ all -> 0x0089 }
            throw r3     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r3 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0089 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabe.mo29477a(android.content.Context, java.lang.String, com.google.android.gms.internal.ads.zzabi, com.google.android.gms.internal.ads.zztx):void");
    }

    /* renamed from: a */
    public final RewardedVideoAd mo29473a(Context context) {
        synchronized (f23865b) {
            if (this.f23867d != null) {
                RewardedVideoAd rewardedVideoAd = this.f23867d;
                return rewardedVideoAd;
            }
            this.f23867d = new zzatj(context, (zzasw) new C9593mu(zzyt.m31533b(), context, new zzamo()).mo29114a(context, false));
            RewardedVideoAd rewardedVideoAd2 = this.f23867d;
            return rewardedVideoAd2;
        }
    }

    /* renamed from: a */
    public final void mo29475a(float f) {
        boolean z = true;
        Preconditions.m21864a(0.0f <= f && f <= 1.0f, (Object) "The app volume must be a value between 0 and 1 inclusive.");
        if (this.f23866c == null) {
            z = false;
        }
        Preconditions.m21868b(z, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.f23866c.mo29346a(f);
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to set app volume.", e);
        }
    }

    /* renamed from: b */
    public final float mo29480b() {
        zzaab zzaab = this.f23866c;
        float f = 1.0f;
        if (zzaab == null) {
            return 1.0f;
        }
        try {
            f = zzaab.mo29345Ra();
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to get app volume.", e);
        }
        return f;
    }

    /* renamed from: a */
    public final void mo29479a(boolean z) {
        Preconditions.m21868b(this.f23866c != null, "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.f23866c.mo29354g(z);
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to set app mute state.", e);
        }
    }

    /* renamed from: c */
    public final boolean mo29481c() {
        zzaab zzaab = this.f23866c;
        boolean z = false;
        if (zzaab == null) {
            return false;
        }
        try {
            z = zzaab.mo29355ga();
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to get app mute state.", e);
        }
        return z;
    }

    /* renamed from: a */
    public final void mo29476a(Context context, String str) {
        Preconditions.m21868b(this.f23866c != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.f23866c.mo29347a(ObjectWrapper.m22188a(context), str);
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to open debug menu.", e);
        }
    }

    /* renamed from: a */
    public final String mo29474a() {
        Preconditions.m21868b(this.f23866c != null, "MobileAds.initialize() must be called prior to getting version string.");
        try {
            return this.f23866c.mo29352fa();
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to get version string.", e);
            return "";
        }
    }

    /* renamed from: a */
    public final void mo29478a(Class<? extends RtbAdapter> cls) {
        try {
            this.f23866c.mo29356p(cls.getCanonicalName());
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to register RtbAdapter", e);
        }
    }

    private zzabe() {
    }
}
