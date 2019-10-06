package p019d.p143b.p144a.p147c;

import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;

/* renamed from: d.b.a.c.Va */
class C7118Va implements C7248b {

    /* renamed from: a */
    final /* synthetic */ C7248b f13393a;

    /* renamed from: b */
    final /* synthetic */ C7115Ua f13394b;

    C7118Va(C7115Ua ua, C7248b bVar) {
        this.f13394b = ua;
        this.f13393a = bVar;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f13394b.m14949a(this.f13393a, i);
    }

    public void onNativeAdsLoaded(List<C7247a> list) {
        this.f13394b.mo22983a(list, this.f13393a);
    }
}
