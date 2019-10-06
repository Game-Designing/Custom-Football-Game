package p019d.p143b.p144a.p147c;

import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;

/* renamed from: d.b.a.c._a */
class C7132_a implements C7248b {

    /* renamed from: a */
    final /* synthetic */ C7248b f13426a;

    /* renamed from: b */
    final /* synthetic */ C7115Ua f13427b;

    C7132_a(C7115Ua ua, C7248b bVar) {
        this.f13427b = ua;
        this.f13426a = bVar;
    }

    public void onNativeAdsFailedToLoad(int i) {
        C7248b bVar = this.f13426a;
        if (bVar != null) {
            bVar.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List<C7247a> list) {
        C7248b bVar = this.f13426a;
        if (bVar != null) {
            bVar.onNativeAdsLoaded(list);
        }
    }
}
