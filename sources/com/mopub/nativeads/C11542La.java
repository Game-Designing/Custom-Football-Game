package com.mopub.nativeads;

import com.mopub.mobileads.MoPubErrorCode;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p238b.C12143a;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.La */
/* compiled from: SomaMopubAdapter */
class C11542La extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f35771a;

    /* renamed from: b */
    final /* synthetic */ C12064Na f35772b;

    /* renamed from: c */
    final /* synthetic */ C11544Ma f35773c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38198a() {
        boolean[] zArr = f35771a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1894043987231027318L, "com/mopub/nativeads/SomaMopubAdapter$1$1", 8);
        f35771a = probes;
        return probes;
    }

    C11542La(C11544Ma this$1, C12064Na na) {
        boolean[] a = m38198a();
        this.f35773c = this$1;
        this.f35772b = na;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38198a();
        if (this.f35772b.getStatus() == C12111b.f37995c) {
            a[1] = true;
            SomaMopubAdapter.m38367a(this.f35773c.f35777c, "NO_FILL", C12143a.DEBUG);
            a[2] = true;
            this.f35773c.f35776b.onBannerFailed(MoPubErrorCode.NO_FILL);
            a[3] = true;
        } else {
            SomaMopubAdapter.m38367a(this.f35773c.f35777c, "Ad available", C12143a.DEBUG);
            a[4] = true;
            C11544Ma ma = this.f35773c;
            ma.f35776b.onBannerLoaded(SomaMopubAdapter.m38366a(ma.f35777c));
            a[5] = true;
        }
        a[6] = true;
        return null;
    }
}
