package p019d.p143b.p144a.p147c;

import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;

/* renamed from: d.b.a.c.ab */
class C7136ab implements C7248b {

    /* renamed from: a */
    final /* synthetic */ C7248b f13442a;

    /* renamed from: b */
    final /* synthetic */ C7115Ua f13443b;

    C7136ab(C7115Ua ua, C7248b bVar) {
        this.f13443b = ua;
        this.f13442a = bVar;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f13443b.m14949a(this.f13442a, i);
    }

    public void onNativeAdsLoaded(List<C7247a> list) {
        this.f13443b.m14950a(this.f13442a, list);
    }
}
