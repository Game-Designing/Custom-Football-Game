package p019d.p143b.p144a.p147c;

import java.util.concurrent.atomic.AtomicReference;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.zb */
class C7236zb implements C7198q<String> {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f14059a;

    /* renamed from: b */
    final /* synthetic */ String f14060b;

    /* renamed from: c */
    final /* synthetic */ C7232yb f14061c;

    C7236zb(C7232yb ybVar, AtomicReference atomicReference, String str) {
        this.f14061c = ybVar;
        this.f14059a = atomicReference;
        this.f14060b = str;
    }

    /* renamed from: a */
    public void mo22856a(int i) {
        C7232yb ybVar = this.f14061c;
        C7262l lVar = ybVar.f13626c;
        String str = ybVar.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load resource from '");
        sb.append(this.f14060b);
        sb.append("'");
        lVar.mo22916b(str, sb.toString());
    }

    /* renamed from: a */
    public void mo22857a(String str, int i) {
        this.f14059a.set(str);
    }
}
