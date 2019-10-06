package p019d.p143b.p144a.p147c;

import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;

/* renamed from: d.b.a.c.Ya */
class C7127Ya implements C7248b {

    /* renamed from: a */
    final /* synthetic */ List f13409a;

    /* renamed from: b */
    final /* synthetic */ C7248b f13410b;

    /* renamed from: c */
    final /* synthetic */ List f13411c;

    /* renamed from: d */
    final /* synthetic */ C7115Ua f13412d;

    C7127Ya(C7115Ua ua, List list, C7248b bVar, List list2) {
        this.f13412d = ua;
        this.f13409a = list;
        this.f13410b = bVar;
        this.f13411c = list2;
    }

    public void onNativeAdsFailedToLoad(int i) {
        C7248b bVar = this.f13410b;
        if (bVar != null) {
            bVar.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List<C7247a> list) {
        this.f13412d.m14956c(this.f13409a, new C7130Za(this));
    }
}
