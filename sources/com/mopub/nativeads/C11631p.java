package com.mopub.nativeads;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.mopub.nativeads.InMobiNativeCustomEvent.InMobiNativeAd;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.p */
/* compiled from: InMobiNativeAdRenderer */
class C11631p implements OnGlobalLayoutListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36210a;

    /* renamed from: b */
    final /* synthetic */ ViewGroup f36211b;

    /* renamed from: c */
    final /* synthetic */ InMobiNativeAd f36212c;

    /* renamed from: d */
    final /* synthetic */ C11536a f36213d;

    /* renamed from: e */
    final /* synthetic */ InMobiNativeAdRenderer f36214e;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38460a() {
        boolean[] zArr = f36210a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(562017048638688004L, "com/mopub/nativeads/InMobiNativeAdRenderer$2", 8);
        f36210a = probes;
        return probes;
    }

    C11631p(InMobiNativeAdRenderer this$0, ViewGroup viewGroup, InMobiNativeAd inMobiNativeAd, C11536a aVar) {
        boolean[] a = m38460a();
        this.f36214e = this$0;
        this.f36211b = viewGroup;
        this.f36212c = inMobiNativeAd;
        this.f36213d = aVar;
        a[0] = true;
    }

    public void onGlobalLayout() {
        boolean[] a = m38460a();
        ViewTreeObserver viewTreeObserver = this.f36211b.getViewTreeObserver();
        a[1] = true;
        viewTreeObserver.removeOnGlobalLayoutListener(this);
        InMobiNativeAd inMobiNativeAd = this.f36212c;
        C11536a aVar = this.f36213d;
        a[2] = true;
        ViewGroup primaryAdViewLayout = aVar.getPrimaryAdViewLayout();
        a[3] = true;
        View primaryAdView = inMobiNativeAd.getPrimaryAdView(primaryAdViewLayout);
        if (primaryAdView == null) {
            a[4] = true;
        } else {
            a[5] = true;
            this.f36211b.addView(primaryAdView);
            a[6] = true;
        }
        a[7] = true;
    }
}
