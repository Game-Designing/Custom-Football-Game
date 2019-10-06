package com.mopub.nativeads;

import android.util.Log;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.listeners.VideoEventListener;
import com.mopub.nativeads.InMobiNativeCustomEvent.InMobiNativeAd;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.t */
/* compiled from: InMobiNativeCustomEvent */
class C11643t extends VideoEventListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36235a;

    /* renamed from: b */
    final /* synthetic */ InMobiNativeAd f36236b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38468a() {
        boolean[] zArr = f36235a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3429033821290850599L, "com/mopub/nativeads/InMobiNativeCustomEvent$InMobiNativeAd$2", 7);
        f36235a = probes;
        return probes;
    }

    C11643t(InMobiNativeAd this$0) {
        boolean[] a = m38468a();
        this.f36236b = this$0;
        a[0] = true;
    }

    public void onVideoCompleted(InMobiNative inMobiNative) {
        boolean[] a = m38468a();
        super.onVideoCompleted(inMobiNative);
        a[1] = true;
        Log.d("InMobiNativeAd", "InMobi Native Video completed");
        a[2] = true;
    }

    public void onVideoSkipped(InMobiNative inMobiNative) {
        boolean[] a = m38468a();
        super.onVideoSkipped(inMobiNative);
        a[3] = true;
        Log.d("InMobiNativeAd", "InMobi Native Video skipped");
        a[4] = true;
    }

    public void onAudioStateChanged(InMobiNative inMobiNative, boolean b) {
        boolean[] a = m38468a();
        super.onAudioStateChanged(inMobiNative, b);
        a[5] = true;
        Log.d("InMobiNativeAd", "InMobi Native Video onAudioStateChanged");
        a[6] = true;
    }
}
