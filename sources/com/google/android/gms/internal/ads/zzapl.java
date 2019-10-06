package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;
import p002b.p003c.p049c.C1163b;
import p002b.p003c.p049c.C1163b.C1164a;

@zzard
public final class zzapl implements MediationInterstitialAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f24524a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MediationInterstitialListener f24525b;

    /* renamed from: c */
    private Uri f24526c;

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f24525b = mediationInterstitialListener;
        if (this.f24525b == null) {
            zzbad.m26359d("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzbad.m26359d("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f24525b.onAdFailedToLoad(this, 0);
        } else {
            if (!(PlatformVersion.m22108b() && zzads.m24825a(context))) {
                zzbad.m26359d("Default browser does not support custom tabs. Bailing out.");
                this.f24525b.onAdFailedToLoad(this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzbad.m26359d("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.f24525b.onAdFailedToLoad(this, 0);
                return;
            }
            this.f24524a = (Activity) context;
            this.f24526c = Uri.parse(string);
            this.f24525b.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        C1163b b = new C1164a().mo8787b();
        b.f3816a.setData(this.f24526c);
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(new zzc(b.f3816a), null, new C9420fb(this), null, new zzbai(0, 0, false));
        zzaxi.f24961a.post(new C9442gb(this, adOverlayInfoParcel));
        zzk.zzlk().mo30173e();
    }

    public final void onDestroy() {
        zzbad.m26352a("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzbad.m26352a("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzbad.m26352a("Resuming AdMobCustomTabsAdapter adapter.");
    }
}
