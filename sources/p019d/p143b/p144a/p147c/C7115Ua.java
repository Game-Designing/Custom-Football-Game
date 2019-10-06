package p019d.p143b.p144a.p147c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;
import p019d.p143b.p149c.C7249c;
import p019d.p143b.p149c.C7250d;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Ua */
class C7115Ua implements C7250d {

    /* renamed from: a */
    private final C7142c f13388a;

    C7115Ua(C7142c cVar) {
        this.f13388a = cVar;
    }

    /* renamed from: a */
    private List<C7154f> m14942a(C7247a aVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((C7154f) aVar);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14949a(C7248b bVar, int i) {
        if (bVar != null) {
            try {
                bVar.onNativeAdsFailedToLoad(i);
            } catch (Exception e) {
                this.f13388a.mo23049b().mo22919c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14950a(C7248b bVar, List<C7247a> list) {
        if (bVar != null) {
            try {
                bVar.onNativeAdsLoaded(list);
            } catch (Exception e) {
                this.f13388a.mo23049b().mo22919c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14951a(C7249c cVar, C7247a aVar, int i, boolean z) {
        if (cVar == null) {
            return;
        }
        if (z) {
            try {
                cVar.mo22977b(aVar, i);
            } catch (Exception e) {
                this.f13388a.mo23049b().mo22919c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            cVar.mo22975a(aVar, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14952a(C7249c cVar, C7247a aVar, boolean z) {
        if (cVar == null) {
            return;
        }
        if (z) {
            try {
                cVar.mo22974a(aVar);
            } catch (Exception e) {
                this.f13388a.mo23049b().mo22919c("NativeAdService", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            cVar.mo22976b(aVar);
        }
    }

    /* renamed from: a */
    private void m14953a(String str, int i, C7248b bVar) {
        this.f13388a.mo23027C().mo22970a((C7184mb) new C7098Ob(str, i, this.f13388a, new C7118Va(this, bVar)), C7113Tb.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14954b(C7247a aVar, C7249c cVar) {
        if (aVar.mo23132r()) {
            cVar.mo22974a(aVar);
            return;
        }
        this.f13388a.mo23027C().mo22970a((C7184mb) new C7054Db(this.f13388a, m14942a(aVar), (C7249c) new C7124Xa(this, cVar)), C7113Tb.MAIN);
    }

    /* renamed from: b */
    private void m14955b(List<C7154f> list, C7248b bVar) {
        this.f13388a.mo23027C().mo22970a((C7184mb) new C7046Bb(this.f13388a, list, (C7248b) new C7132_a(this, bVar)), C7113Tb.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14956c(List<C7154f> list, C7248b bVar) {
        this.f13388a.mo23027C().mo22970a((C7184mb) new C7054Db(this.f13388a, list, (C7248b) new C7136ab(this, bVar)), C7113Tb.MAIN);
    }

    /* renamed from: a */
    public void mo22979a(int i, C7248b bVar) {
        mo22980a(i, (String) null, bVar);
    }

    /* renamed from: a */
    public void mo22980a(int i, String str, C7248b bVar) {
        String str2 = "NativeAdService";
        if (i > 0) {
            this.f13388a.mo23066k();
            if (i == 1) {
                C7059Ec b = C7059Ec.m14676b(str, this.f13388a);
                C7247a aVar = (C7247a) this.f13388a.mo23064i().mo22961e(b);
                if (aVar != null) {
                    this.f13388a.mo23049b().mo22918c(str2, "Preloaded native ad found");
                    m14950a(bVar, Arrays.asList(new C7247a[]{aVar}));
                } else {
                    m14953a(str, 1, bVar);
                }
                if (((Boolean) this.f13388a.mo23039a(C7196pb.f13894vb)).booleanValue()) {
                    this.f13388a.mo23064i().mo22965i(b);
                    return;
                }
                return;
            }
            m14953a(str, i, bVar);
            return;
        }
        C7262l b2 = this.f13388a.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Requested invalid number of native ads: ");
        sb.append(i);
        b2.mo22921e(str2, sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22981a(C7059Ec ec) {
        this.f13388a.mo23063h().mo22964h(ec);
        int h = ec.mo22808h();
        if (h == 0 && this.f13388a.mo23063h().mo23142b(ec)) {
            h = 1;
        }
        this.f13388a.mo23063h().mo22959b(ec, h);
    }

    /* renamed from: a */
    public void mo22982a(C7247a aVar, C7249c cVar) {
        this.f13388a.mo23066k();
        if (aVar.mo23131q()) {
            cVar.mo22976b(aVar);
            m14954b(aVar, cVar);
            return;
        }
        this.f13388a.mo23027C().mo22970a((C7184mb) new C7046Bb(this.f13388a, m14942a(aVar), (C7249c) new C7121Wa(this, cVar)), C7113Tb.MAIN);
    }

    /* renamed from: a */
    public void mo22983a(List<C7247a> list, C7248b bVar) {
        int intValue = ((Integer) this.f13388a.mo23039a(C7196pb.f13691Fb)).intValue();
        if (intValue > 0) {
            int size = list.size();
            if (size == 0) {
                if (bVar != null) {
                    bVar.onNativeAdsFailedToLoad(-700);
                }
                return;
            }
            int min = Math.min(intValue, size);
            List subList = list.subList(0, min);
            m14955b(subList, (C7248b) new C7127Ya(this, subList, bVar, list.subList(min, size)));
        } else if (bVar != null) {
            bVar.onNativeAdsLoaded(list);
        }
    }
}
