package com.mopub.nativeads;

import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12507r;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Pa */
/* compiled from: SomaMopubAdapter */
class C11562Pa implements C12507r {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36008a;

    /* renamed from: b */
    final /* synthetic */ CustomEventBannerListener f36009b;

    /* renamed from: c */
    final /* synthetic */ SomaMopubAdapter f36010c;

    /* renamed from: b */
    private static /* synthetic */ boolean[] m38352b() {
        boolean[] zArr = f36008a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5036739312254998400L, "com/mopub/nativeads/SomaMopubAdapter$2", 5);
        f36008a = probes;
        return probes;
    }

    C11562Pa(SomaMopubAdapter this$0, CustomEventBannerListener customEventBannerListener) {
        boolean[] b = m38352b();
        this.f36010c = this$0;
        this.f36009b = customEventBannerListener;
        b[0] = true;
    }

    public void onWillOpenLandingPage(C12369fa arg0) {
        boolean[] b = m38352b();
        C11553Na na = new C11553Na(this);
        b[1] = true;
        na.execute();
        b[2] = true;
    }

    public void onWillCloseLandingPage(C12369fa arg0) {
        boolean[] b = m38352b();
        C11560Oa oa = new C11560Oa(this);
        b[3] = true;
        oa.execute();
        b[4] = true;
    }
}
