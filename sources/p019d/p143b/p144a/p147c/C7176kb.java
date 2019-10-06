package p019d.p143b.p144a.p147c;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: d.b.a.c.kb */
class C7176kb extends LinkedHashMap<String, C7081Ka> {

    /* renamed from: a */
    final /* synthetic */ C7072I f13606a;

    private C7176kb(C7072I i) {
        this.f13606a = i;
    }

    /* synthetic */ C7176kb(C7072I i, C7175ka kaVar) {
        this(i);
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Entry<String, C7081Ka> entry) {
        return size() > ((Integer) this.f13606a.f13241a.mo23039a(C7196pb.f13743Pd)).intValue();
    }
}
