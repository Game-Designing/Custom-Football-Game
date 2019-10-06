package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.nativeads.InMobiNativeCustomEvent.InMobiNativeAd;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.o */
/* compiled from: InMobiNativeAdRenderer */
class C11628o implements OnClickListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36202a;

    /* renamed from: b */
    final /* synthetic */ InMobiNativeAd f36203b;

    /* renamed from: c */
    final /* synthetic */ InMobiNativeAdRenderer f36204c;

    /* renamed from: h */
    private static /* synthetic */ boolean[] m38457h() {
        boolean[] zArr = f36202a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8177675436308271559L, "com/mopub/nativeads/InMobiNativeAdRenderer$1", 2);
        f36202a = probes;
        return probes;
    }

    C11628o(InMobiNativeAdRenderer this$0, InMobiNativeAd inMobiNativeAd) {
        boolean[] h = m38457h();
        this.f36204c = this$0;
        this.f36203b = inMobiNativeAd;
        h[0] = true;
    }

    public void onClick(View view) {
        boolean[] h = m38457h();
        this.f36203b.onCtaClick();
        h[1] = true;
    }
}
