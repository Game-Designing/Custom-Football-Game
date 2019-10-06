package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.mediation.C8081a;
import com.google.ads.mediation.C8083c;
import com.google.ads.mediation.C8091d;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbad;
import p019d.p271g.p272a.C12720a;
import p019d.p271g.p272a.C12722c;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, C8090e>, MediationInterstitialAdapter<CustomEventExtras, C8090e> {

    /* renamed from: a */
    private View f16457a;
    @VisibleForTesting

    /* renamed from: b */
    private CustomEventBanner f16458b;
    @VisibleForTesting

    /* renamed from: c */
    private CustomEventInterstitial f16459c;

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    static final class C8084a implements C8087b {

        /* renamed from: a */
        private final CustomEventAdapter f16460a;

        /* renamed from: b */
        private final C8083c f16461b;

        public C8084a(CustomEventAdapter customEventAdapter, C8083c cVar) {
            this.f16460a = customEventAdapter;
            this.f16461b = cVar;
        }
    }

    @VisibleForTesting
    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    class C8085b implements C8088c {

        /* renamed from: a */
        private final CustomEventAdapter f16462a;

        /* renamed from: b */
        private final C8091d f16463b;

        public C8085b(CustomEventAdapter customEventAdapter, C8091d dVar) {
            this.f16462a = customEventAdapter;
            this.f16463b = dVar;
        }
    }

    /* renamed from: a */
    private static <T> T m18195a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbad.m26359d(sb.toString());
            return null;
        }
    }

    public final void destroy() {
        CustomEventBanner customEventBanner = this.f16458b;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.f16459c;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.f16457a;
    }

    public final Class<C8090e> getServerParametersType() {
        return C8090e.class;
    }

    public final void requestBannerAd(C8083c cVar, Activity activity, C8090e eVar, C12722c cVar2, C8081a aVar, CustomEventExtras customEventExtras) {
        this.f16458b = (CustomEventBanner) m18195a(eVar.f16466b);
        if (this.f16458b == null) {
            cVar.mo24948a(this, C12720a.INTERNAL_ERROR);
            return;
        }
        this.f16458b.requestBannerAd(new C8084a(this, cVar), activity, eVar.f16465a, eVar.f16467c, cVar2, aVar, customEventExtras == null ? null : customEventExtras.getExtra(eVar.f16465a));
    }

    public final void requestInterstitialAd(C8091d dVar, Activity activity, C8090e eVar, C8081a aVar, CustomEventExtras customEventExtras) {
        this.f16459c = (CustomEventInterstitial) m18195a(eVar.f16466b);
        if (this.f16459c == null) {
            dVar.mo24955a(this, C12720a.INTERNAL_ERROR);
            return;
        }
        this.f16459c.requestInterstitialAd(new C8085b(this, dVar), activity, eVar.f16465a, eVar.f16467c, aVar, customEventExtras == null ? null : customEventExtras.getExtra(eVar.f16465a));
    }

    public final void showInterstitial() {
        this.f16459c.showInterstitial();
    }
}
