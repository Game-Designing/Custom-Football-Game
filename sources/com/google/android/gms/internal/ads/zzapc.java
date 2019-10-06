package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzapc extends zzaow {

    /* renamed from: b */
    private final RtbAdapter f24518b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MediationInterstitialAd f24519c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MediationRewardedAd f24520d;

    public zzapc(RtbAdapter rtbAdapter) {
        this.f24518b = rtbAdapter;
    }

    /* renamed from: a */
    public final void mo29958a(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaoj zzaoj, zzamv zzamv, zzyd zzyd) throws RemoteException {
        zzxz zzxz2 = zzxz;
        zzyd zzyd2 = zzyd;
        try {
            C9288_a _aVar = new C9288_a(this, zzaoj, zzamv);
            RtbAdapter rtbAdapter = this.f24518b;
            Context context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
            Bundle t = m25612t(str2);
            Bundle d = m25611d(zzxz2);
            boolean c = m25610c(zzxz);
            Location location = zzxz2.f29733k;
            int i = zzxz2.f29729g;
            int i2 = zzxz2.f29742t;
            String a = m25609a(str2, zzxz);
            AdSize zza = zzb.zza(zzyd2.f29772e, zzyd2.f29769b, zzyd2.f29768a);
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration(context, str, t, d, c, location, i, i2, a, zza);
            rtbAdapter.loadBannerAd(mediationBannerAdConfiguration, _aVar);
        } catch (Throwable th) {
            zzbad.m26356b("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29959a(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaom zzaom, zzamv zzamv) throws RemoteException {
        zzxz zzxz2 = zzxz;
        try {
            C9310ab abVar = new C9310ab(this, zzaom, zzamv);
            RtbAdapter rtbAdapter = this.f24518b;
            MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration = new MediationInterstitialAdConfiguration((Context) ObjectWrapper.m22187H(iObjectWrapper), str, m25612t(str2), m25611d(zzxz2), m25610c(zzxz), zzxz2.f29733k, zzxz2.f29729g, zzxz2.f29742t, m25609a(str2, zzxz));
            rtbAdapter.loadInterstitialAd(mediationInterstitialAdConfiguration, abVar);
        } catch (Throwable th) {
            zzbad.m26356b("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29961a(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaos zzaos, zzamv zzamv) throws RemoteException {
        zzxz zzxz2 = zzxz;
        try {
            C9332bb bbVar = new C9332bb(this, zzaos, zzamv);
            RtbAdapter rtbAdapter = this.f24518b;
            MediationRewardedAdConfiguration mediationRewardedAdConfiguration = new MediationRewardedAdConfiguration((Context) ObjectWrapper.m22187H(iObjectWrapper), str, m25612t(str2), m25611d(zzxz2), m25610c(zzxz), zzxz2.f29733k, zzxz2.f29729g, zzxz2.f29742t, m25609a(str2, zzxz));
            rtbAdapter.loadRewardedAd(mediationRewardedAdConfiguration, bbVar);
        } catch (Throwable th) {
            zzbad.m26356b("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo29960a(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaop zzaop, zzamv zzamv) throws RemoteException {
        zzxz zzxz2 = zzxz;
        try {
            C9354cb cbVar = new C9354cb(this, zzaop, zzamv);
            RtbAdapter rtbAdapter = this.f24518b;
            MediationNativeAdConfiguration mediationNativeAdConfiguration = new MediationNativeAdConfiguration((Context) ObjectWrapper.m22187H(iObjectWrapper), str, m25612t(str2), m25611d(zzxz2), m25610c(zzxz), zzxz2.f29733k, zzxz2.f29729g, zzxz2.f29742t, m25609a(str2, zzxz));
            rtbAdapter.loadNativeAd(mediationNativeAdConfiguration, cbVar);
        } catch (Throwable th) {
            zzbad.m26356b("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    /* renamed from: u */
    public final boolean mo29964u(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.f24519c;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.m22187H(iObjectWrapper));
        } catch (Throwable th) {
            zzbad.m26356b("", th);
        }
        return true;
    }

    /* renamed from: v */
    public final boolean mo29965v(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.f24520d;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.m22187H(iObjectWrapper));
        } catch (Throwable th) {
            zzbad.m26356b("", th);
        }
        return true;
    }

    public final zzaar getVideoController() {
        RtbAdapter rtbAdapter = this.f24518b;
        if (!(rtbAdapter instanceof zza)) {
            return null;
        }
        try {
            return ((zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzbad.m26356b("", th);
            return null;
        }
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo29957a(com.google.android.gms.dynamic.IObjectWrapper r8, java.lang.String r9, android.os.Bundle r10, android.os.Bundle r11, com.google.android.gms.internal.ads.zzyd r12, com.google.android.gms.internal.ads.zzaoy r13) throws android.os.RemoteException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.db r0 = new com.google.android.gms.internal.ads.db     // Catch:{ Throwable -> 0x0075 }
            r0.<init>(r7, r13)     // Catch:{ Throwable -> 0x0075 }
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r13 = r7.f24518b     // Catch:{ Throwable -> 0x0075 }
            com.google.android.gms.ads.mediation.MediationConfiguration r1 = new com.google.android.gms.ads.mediation.MediationConfiguration     // Catch:{ Throwable -> 0x0075 }
            r2 = -1
            int r3 = r9.hashCode()     // Catch:{ Throwable -> 0x0075 }
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1396342996: goto L_0x0034;
                case -1052618729: goto L_0x002a;
                case -239580146: goto L_0x0020;
                case 604727084: goto L_0x0016;
                default: goto L_0x0015;
            }     // Catch:{ Throwable -> 0x0075 }
        L_0x0015:
            goto L_0x003d
        L_0x0016:
            java.lang.String r3 = "interstitial"
            boolean r9 = r9.equals(r3)     // Catch:{ Throwable -> 0x0075 }
            if (r9 == 0) goto L_0x0015
            r2 = 1
            goto L_0x003d
        L_0x0020:
            java.lang.String r3 = "rewarded"
            boolean r9 = r9.equals(r3)     // Catch:{ Throwable -> 0x0075 }
            if (r9 == 0) goto L_0x0015
            r2 = 2
            goto L_0x003d
        L_0x002a:
            java.lang.String r3 = "native"
            boolean r9 = r9.equals(r3)     // Catch:{ Throwable -> 0x0075 }
            if (r9 == 0) goto L_0x0015
            r2 = 3
            goto L_0x003d
        L_0x0034:
            java.lang.String r3 = "banner"
            boolean r9 = r9.equals(r3)     // Catch:{ Throwable -> 0x0075 }
            if (r9 == 0) goto L_0x0015
            r2 = 0
        L_0x003d:
            if (r2 == 0) goto L_0x0056
            if (r2 == r6) goto L_0x0053
            if (r2 == r5) goto L_0x0050
            if (r2 != r4) goto L_0x0048
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.NATIVE     // Catch:{ Throwable -> 0x0075 }
            goto L_0x0058
        L_0x0048:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ Throwable -> 0x0075 }
            java.lang.String r9 = "Internal Error"
            r8.<init>(r9)     // Catch:{ Throwable -> 0x0075 }
            throw r8     // Catch:{ Throwable -> 0x0075 }
        L_0x0050:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.REWARDED     // Catch:{ Throwable -> 0x0075 }
            goto L_0x0058
        L_0x0053:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.INTERSTITIAL     // Catch:{ Throwable -> 0x0075 }
            goto L_0x0058
        L_0x0056:
            com.google.android.gms.ads.AdFormat r9 = com.google.android.gms.ads.AdFormat.BANNER     // Catch:{ Throwable -> 0x0075 }
        L_0x0058:
            r1.<init>(r9, r11)     // Catch:{ Throwable -> 0x0075 }
            com.google.android.gms.ads.mediation.rtb.RtbSignalData r9 = new com.google.android.gms.ads.mediation.rtb.RtbSignalData     // Catch:{ Throwable -> 0x0075 }
            java.lang.Object r8 = com.google.android.gms.dynamic.ObjectWrapper.m22187H(r8)     // Catch:{ Throwable -> 0x0075 }
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ Throwable -> 0x0075 }
            int r11 = r12.f29772e     // Catch:{ Throwable -> 0x0075 }
            int r2 = r12.f29769b     // Catch:{ Throwable -> 0x0075 }
            java.lang.String r12 = r12.f29768a     // Catch:{ Throwable -> 0x0075 }
            com.google.android.gms.ads.AdSize r11 = com.google.android.gms.ads.zzb.zza(r11, r2, r12)     // Catch:{ Throwable -> 0x0075 }
            r9.<init>(r8, r1, r10, r11)     // Catch:{ Throwable -> 0x0075 }
            r13.collectSignals(r9, r0)     // Catch:{ Throwable -> 0x0075 }
            return
        L_0x0075:
            r8 = move-exception
            java.lang.String r9 = "Error generating signals for RTB"
            com.google.android.gms.internal.ads.zzbad.m26356b(r9, r8)
            android.os.RemoteException r8 = new android.os.RemoteException
            r8.<init>()
            goto L_0x0082
        L_0x0081:
            throw r8
        L_0x0082:
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapc.mo29957a(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.internal.ads.zzyd, com.google.android.gms.internal.ads.zzaoy):void");
    }

    /* renamed from: _a */
    public final zzapj mo29956_a() throws RemoteException {
        return zzapj.m25624a(this.f24518b.getVersionInfo());
    }

    /* renamed from: Wa */
    public final zzapj mo29955Wa() throws RemoteException {
        return zzapj.m25624a(this.f24518b.getSDKVersionInfo());
    }

    /* renamed from: x */
    public final void mo29966x(IObjectWrapper iObjectWrapper) {
    }

    /* renamed from: a */
    public final void mo29962a(String[] strArr, Bundle[] bundleArr) {
    }

    /* renamed from: t */
    private static Bundle m25612t(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        String str2 = "Server parameters: ";
        zzbad.m26359d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                bundle2.putString(str3, jSONObject.getString(str3));
            }
            return bundle2;
        } catch (JSONException e) {
            zzbad.m26356b("", e);
            throw new RemoteException();
        }
    }

    /* renamed from: c */
    private static boolean m25610c(zzxz zzxz) {
        if (!zzxz.f29728f) {
            zzyt.m31532a();
            if (!zzazt.m26311a()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static String m25609a(String str, zzxz zzxz) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException e) {
            return zzxz.f29743u;
        }
    }

    /* renamed from: d */
    private final Bundle m25611d(zzxz zzxz) {
        Bundle bundle = zzxz.f29735m;
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle(this.f24518b.getClass().getName());
            if (bundle2 != null) {
                return bundle2;
            }
        }
        return new Bundle();
    }
}
