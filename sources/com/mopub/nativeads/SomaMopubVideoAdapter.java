package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.smaato.soma.C12394h;
import com.smaato.soma.p261j.C12446N;
import com.smaato.soma.p261j.C12486u;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

public class SomaMopubVideoAdapter extends CustomEventInterstitial implements C12486u {

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f36044b;

    /* renamed from: c */
    private C12446N f36045c;

    /* renamed from: d */
    private CustomEventInterstitialListener f36046d;

    /* renamed from: e */
    private Handler f36047e;

    /* renamed from: f */
    private static /* synthetic */ boolean[] m38394f() {
        boolean[] zArr = f36044b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5484428411347062524L, "com/mopub/nativeads/SomaMopubVideoAdapter", 30);
        f36044b = probes;
        return probes;
    }

    public SomaMopubVideoAdapter() {
        m38394f()[0] = true;
    }

    /* renamed from: a */
    static /* synthetic */ CustomEventInterstitialListener m38388a(SomaMopubVideoAdapter x0) {
        boolean[] f = m38394f();
        CustomEventInterstitialListener customEventInterstitialListener = x0.f36046d;
        f[25] = true;
        return customEventInterstitialListener;
    }

    /* renamed from: a */
    static /* synthetic */ C12446N m38389a(SomaMopubVideoAdapter x0, C12446N x1) {
        boolean[] f = m38394f();
        x0.f36045c = x1;
        f[27] = true;
        return x1;
    }

    /* renamed from: a */
    static /* synthetic */ void m38390a(SomaMopubVideoAdapter x0, Map x1, C12394h x2) {
        boolean[] f = m38394f();
        x0.m38391a(x1, x2);
        f[29] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Handler m38392b(SomaMopubVideoAdapter x0) {
        boolean[] f = m38394f();
        Handler handler = x0.f36047e;
        f[26] = true;
        return handler;
    }

    /* renamed from: c */
    static /* synthetic */ C12446N m38393c(SomaMopubVideoAdapter x0) {
        boolean[] f = m38394f();
        C12446N n = x0.f36045c;
        f[28] = true;
        return n;
    }

    public void onReadyToShow() {
        boolean[] f = m38394f();
        C11627nb nbVar = new C11627nb(this);
        f[1] = true;
        nbVar.execute();
        f[2] = true;
    }

    public void onWillShow() {
        boolean[] f = m38394f();
        C11633pb pbVar = new C11633pb(this);
        f[3] = true;
        pbVar.execute();
        f[4] = true;
    }

    public void onWillOpenLandingPage() {
        boolean[] f = m38394f();
        C11639rb rbVar = new C11639rb(this);
        f[5] = true;
        rbVar.execute();
        f[6] = true;
    }

    public void onWillClose() {
        boolean[] f = m38394f();
        C11645tb tbVar = new C11645tb(this);
        f[7] = true;
        tbVar.execute();
        f[8] = true;
    }

    public void onFailedToLoadAd() {
        boolean[] f = m38394f();
        C11651vb vbVar = new C11651vb(this);
        f[9] = true;
        vbVar.execute();
        f[10] = true;
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> serverExtras) {
        boolean[] f = m38394f();
        this.f36046d = customEventInterstitialListener;
        f[11] = true;
        this.f36047e = new Handler(Looper.getMainLooper());
        f[12] = true;
        C11654wb wbVar = new C11654wb(this, context, serverExtras);
        f[13] = true;
        wbVar.execute();
        f[14] = true;
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        boolean[] f = m38394f();
        C11660yb ybVar = new C11660yb(this);
        f[15] = true;
        ybVar.execute();
        f[16] = true;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        boolean[] f = m38394f();
        C12446N n = this.f36045c;
        if (n == null) {
            f[17] = true;
        } else {
            f[18] = true;
            n.mo39966b();
            this.f36045c = null;
            f[19] = true;
        }
        f[20] = true;
    }

    /* renamed from: a */
    private void m38391a(Map<String, String> serverExtras, C12394h adSettings) {
        boolean[] f = m38394f();
        long publisherId = Long.parseLong((String) serverExtras.get("publisherId"));
        f[21] = true;
        long adSpaceId = Long.parseLong((String) serverExtras.get("adSpaceId"));
        f[22] = true;
        adSettings.mo39886b(publisherId);
        f[23] = true;
        adSettings.mo39881a(adSpaceId);
        f[24] = true;
    }
}
