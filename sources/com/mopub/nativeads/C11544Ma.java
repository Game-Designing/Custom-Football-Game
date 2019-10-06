package com.mopub.nativeads;

import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12367f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.Ma */
/* compiled from: SomaMopubAdapter */
class C11544Ma implements C12367f {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f35775a;

    /* renamed from: b */
    final /* synthetic */ CustomEventBannerListener f35776b;

    /* renamed from: c */
    final /* synthetic */ SomaMopubAdapter f35777c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38199a() {
        boolean[] zArr = f35775a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6681977185792813761L, "com/mopub/nativeads/SomaMopubAdapter$1", 3);
        f35775a = probes;
        return probes;
    }

    C11544Ma(SomaMopubAdapter this$0, CustomEventBannerListener customEventBannerListener) {
        boolean[] a = m38199a();
        this.f35777c = this$0;
        this.f35776b = customEventBannerListener;
        a[0] = true;
    }

    public void onReceiveAd(C12322e arg0, C12064Na arg1) {
        boolean[] a = m38199a();
        C11542La la = new C11542La(this, arg1);
        a[1] = true;
        la.execute();
        a[2] = true;
    }
}
