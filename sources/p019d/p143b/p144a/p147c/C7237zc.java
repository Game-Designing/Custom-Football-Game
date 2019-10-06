package p019d.p143b.p144a.p147c;

import java.util.LinkedHashSet;
import java.util.List;
import p019d.p143b.p149c.C7247a;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;

/* renamed from: d.b.a.c.zc */
public class C7237zc extends C7160gb {
    C7237zc(C7142c cVar) {
        super(cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7059Ec mo22953a(C7231ya yaVar) {
        return ((C7071Hc) yaVar).mo22762n();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7184mb mo22954a(C7059Ec ec) {
        C7090Mb mb = new C7090Mb(ec, this, this.f13541a);
        mb.mo22903a(true);
        return mb;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22955a() {
        for (C7059Ec ec : C7059Ec.m14677b(this.f13541a)) {
            if (!ec.mo22804e()) {
                mo22964h(ec);
            }
        }
    }

    /* renamed from: a */
    public void mo22816a(C7059Ec ec, int i) {
        mo23144c(ec, i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22956a(Object obj, C7059Ec ec, int i) {
        if (obj instanceof C7060F) {
            ((C7060F) obj).mo22816a(ec, i);
        }
        if (obj instanceof C7254d) {
            ((C7254d) obj).failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22957a(Object obj, C7231ya yaVar) {
        ((C7254d) obj).adReceived((C7251a) yaVar);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo22958a(LinkedHashSet linkedHashSet) {
        super.mo22958a(linkedHashSet);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo23140a(C7059Ec ec, Object obj) {
        return super.mo23140a(ec, obj);
    }

    public void adReceived(C7251a aVar) {
        mo23145c((C7231ya) aVar);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo22959b(C7059Ec ec, int i) {
        super.mo22959b(ec, i);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo22960b(C7059Ec ec, Object obj) {
        super.mo22960b(ec, obj);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ boolean mo23142b(C7059Ec ec) {
        return super.mo23142b(ec);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ C7231ya mo23143c(C7059Ec ec) {
        return super.mo23143c(ec);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ C7231ya mo23146d(C7059Ec ec) {
        return super.mo23146d(ec);
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
    }

    public void onNativeAdsLoaded(List<C7247a> list) {
    }
}
