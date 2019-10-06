package p019d.p143b.p144a.p147c;

import java.util.ArrayList;
import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;

/* renamed from: d.b.a.c.Za */
class C7130Za implements C7248b {

    /* renamed from: a */
    final /* synthetic */ C7127Ya f13422a;

    C7130Za(C7127Ya ya) {
        this.f13422a = ya;
    }

    public void onNativeAdsFailedToLoad(int i) {
        C7248b bVar = this.f13422a.f13410b;
        if (bVar != null) {
            bVar.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List<C7247a> list) {
        if (this.f13422a.f13410b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f13422a.f13409a);
            arrayList.addAll(this.f13422a.f13411c);
            this.f13422a.f13410b.onNativeAdsLoaded(arrayList);
        }
    }
}
