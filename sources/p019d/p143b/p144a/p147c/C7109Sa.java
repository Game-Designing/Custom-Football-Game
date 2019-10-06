package p019d.p143b.p144a.p147c;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7248b;
import p019d.p143b.p149c.C7249c;
import p019d.p143b.p150d.C7251a;

/* renamed from: d.b.a.c.Sa */
public class C7109Sa extends C7160gb {
    public C7109Sa(C7142c cVar) {
        super(cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7059Ec mo22953a(C7231ya yaVar) {
        return ((C7154f) yaVar).mo23111a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7184mb mo22954a(C7059Ec ec) {
        return new C7098Ob(null, 1, this.f13541a, this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22955a() {
        mo22964h(C7059Ec.m14685j(this.f13541a));
    }

    /* renamed from: a */
    public void mo22816a(C7059Ec ec, int i) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22956a(Object obj, C7059Ec ec, int i) {
        ((C7248b) obj).onNativeAdsFailedToLoad(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22957a(Object obj, C7231ya yaVar) {
        C7248b bVar = (C7248b) obj;
        bVar.onNativeAdsLoaded(Arrays.asList(new C7247a[]{(C7247a) yaVar}));
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo22958a(LinkedHashSet linkedHashSet) {
        super.mo22958a(linkedHashSet);
    }

    public void adReceived(C7251a aVar) {
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo22959b(C7059Ec ec, int i) {
        super.mo22959b(ec, i);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo22960b(C7059Ec ec, Object obj) {
        super.mo22960b(ec, obj);
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ C7231ya mo22961e(C7059Ec ec) {
        return super.mo22961e(ec);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ boolean mo22962f(C7059Ec ec) {
        return super.mo22962f(ec);
    }

    public void failedToReceiveAd(int i) {
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ void mo22963g(C7059Ec ec) {
        super.mo22963g(ec);
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ void mo22964h(C7059Ec ec) {
        super.mo22964h(ec);
    }

    /* renamed from: i */
    public /* bridge */ /* synthetic */ void mo22965i(C7059Ec ec) {
        super.mo22965i(ec);
    }

    public void onNativeAdsFailedToLoad(int i) {
        mo23144c(C7059Ec.m14685j(this.f13541a), i);
    }

    public void onNativeAdsLoaded(List<C7247a> list) {
        C7247a aVar = (C7247a) list.get(0);
        if (((Boolean) this.f13541a.mo23039a(C7196pb.f13810ec)).booleanValue()) {
            this.f13541a.m15077c().mo22982a(aVar, (C7249c) new C7112Ta(this));
        } else {
            mo23145c((C7231ya) aVar);
        }
    }
}
