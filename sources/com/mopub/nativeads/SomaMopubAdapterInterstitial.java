package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.smaato.soma.C12394h;
import com.smaato.soma.interstitial.C12420l;
import com.smaato.soma.interstitial.C12424n;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

public class SomaMopubAdapterInterstitial extends CustomEventInterstitial implements C12424n {

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f36033b;

    /* renamed from: c */
    private C12420l f36034c;

    /* renamed from: d */
    private CustomEventInterstitialListener f36035d;

    /* renamed from: e */
    private Handler f36036e;

    /* renamed from: f */
    private static /* synthetic */ boolean[] m38378f() {
        boolean[] zArr = f36033b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6179139507597805863L, "com/mopub/nativeads/SomaMopubAdapterInterstitial", 33);
        f36033b = probes;
        return probes;
    }

    public SomaMopubAdapterInterstitial() {
        m38378f()[0] = true;
    }

    /* renamed from: a */
    static /* synthetic */ CustomEventInterstitialListener m38371a(SomaMopubAdapterInterstitial x0) {
        boolean[] f = m38378f();
        CustomEventInterstitialListener customEventInterstitialListener = x0.f36035d;
        f[28] = true;
        return customEventInterstitialListener;
    }

    /* renamed from: a */
    static /* synthetic */ void m38372a(SomaMopubAdapterInterstitial x0, String x1, C12143a x2) {
        boolean[] f = m38378f();
        x0.m38374a(x1, x2);
        f[30] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m38373a(SomaMopubAdapterInterstitial x0, Map x1, C12394h x2) {
        boolean[] f = m38378f();
        x0.m38375a(x1, x2);
        f[32] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Handler m38376b(SomaMopubAdapterInterstitial x0) {
        boolean[] f = m38378f();
        Handler handler = x0.f36036e;
        f[29] = true;
        return handler;
    }

    /* renamed from: c */
    static /* synthetic */ C12420l m38377c(SomaMopubAdapterInterstitial x0) {
        boolean[] f = m38378f();
        C12420l lVar = x0.f36034c;
        f[31] = true;
        return lVar;
    }

    public void onReadyToShow() {
        boolean[] f = m38378f();
        C11565Ra ra = new C11565Ra(this);
        f[1] = true;
        ra.execute();
        f[2] = true;
    }

    public void onWillShow() {
        boolean[] f = m38378f();
        C11570Ta ta = new C11570Ta(this);
        f[3] = true;
        ta.execute();
        f[4] = true;
    }

    public void onWillOpenLandingPage() {
        boolean[] f = m38378f();
        C11574Va va = new C11574Va(this);
        f[5] = true;
        va.execute();
        f[6] = true;
    }

    public void onWillClose() {
        boolean[] f = m38378f();
        C11578Xa xa = new C11578Xa(this);
        f[7] = true;
        xa.execute();
        f[8] = true;
    }

    public void onFailedToLoadAd() {
        boolean[] f = m38378f();
        C11582Za za = new C11582Za(this);
        f[9] = true;
        za.execute();
        f[10] = true;
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> serverExtras) {
        boolean[] f = m38378f();
        this.f36036e = new Handler(Looper.getMainLooper());
        this.f36035d = customEventInterstitialListener;
        if (this.f36034c != null) {
            f[11] = true;
        } else {
            f[12] = true;
            this.f36034c = new C12420l(context);
            f[13] = true;
            this.f36034c.mo39915a((C12424n) this);
            f[14] = true;
        }
        C11583_a _aVar = new C11583_a(this, serverExtras);
        f[15] = true;
        _aVar.execute();
        f[16] = true;
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        boolean[] f = m38378f();
        C11589bb bbVar = new C11589bb(this);
        f[17] = true;
        bbVar.execute();
        f[18] = true;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        boolean[] f = m38378f();
        C12420l lVar = this.f36034c;
        if (lVar == null) {
            f[19] = true;
        } else {
            f[20] = true;
            lVar.destroy();
            this.f36034c = null;
            f[21] = true;
        }
        f[22] = true;
    }

    /* renamed from: a */
    private void m38375a(Map<String, String> serverExtras, C12394h adSettings) {
        boolean[] f = m38378f();
        long publisherId = Long.parseLong((String) serverExtras.get("publisherId"));
        f[23] = true;
        long adSpaceId = Long.parseLong((String) serverExtras.get("adSpaceId"));
        f[24] = true;
        adSettings.mo39886b(publisherId);
        f[25] = true;
        adSettings.mo39881a(adSpaceId);
        f[26] = true;
    }

    /* renamed from: a */
    private void m38374a(String str, C12143a debugCategory) {
        boolean[] f = m38378f();
        C12146d.m39965a(new C12147e("SomaMopubAdapterInterstitial", str, 1, debugCategory));
        f[27] = true;
    }
}
