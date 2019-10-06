package com.applovin.adview;

import android.content.Context;
import android.util.Log;
import p019d.p143b.p144a.p147c.C7080K;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7267q;

/* renamed from: com.applovin.adview.e */
public class C5859e {

    /* renamed from: a */
    private final C7080K f10199a;

    public C5859e(String str, C7267q qVar) {
        if (qVar != null) {
            this.f10199a = mo18319b(str, qVar);
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    public static C5859e m10668a(Context context) {
        return m10669a(C7267q.m15794a(context));
    }

    /* renamed from: a */
    public static C5859e m10669a(C7267q qVar) {
        return m10670a(null, qVar);
    }

    /* renamed from: a */
    public static C5859e m10670a(String str, C7267q qVar) {
        return new C5859e(str, qVar);
    }

    @Deprecated
    /* renamed from: a */
    public void mo18315a(Context context, String str, C7255e eVar, C7260j jVar, C7253c cVar, C7252b bVar) {
        this.f10199a.mo22871a(null, context, str, eVar, jVar, cVar, bVar);
    }

    /* renamed from: a */
    public void mo18316a(C7251a aVar, Context context, C7255e eVar, C7260j jVar, C7253c cVar, C7252b bVar) {
        this.f10199a.mo22871a(aVar, context, null, eVar, jVar, cVar, bVar);
    }

    /* renamed from: a */
    public void mo18317a(C7254d dVar) {
        if (dVar == null) {
            Log.i("AppLovinIncentivizedInterstitial", "AppLovinAdLoadListener was null when preloading incentivized interstitials; using a listener is highly recommended.");
        }
        this.f10199a.mo22873a(dVar);
    }

    /* renamed from: a */
    public boolean mo18318a() {
        return this.f10199a.mo22876a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C7080K mo18319b(String str, C7267q qVar) {
        return new C7080K(str, qVar);
    }
}
