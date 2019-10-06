package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.Qa */
final class C9928Qa implements Iterator<Entry<K, V>> {

    /* renamed from: a */
    private int f30026a;

    /* renamed from: b */
    private boolean f30027b;

    /* renamed from: c */
    private Iterator<Entry<K, V>> f30028c;

    /* renamed from: d */
    private final /* synthetic */ C9912Ia f30029d;

    private C9928Qa(C9912Ia ia) {
        this.f30029d = ia;
        this.f30026a = -1;
    }

    public final boolean hasNext() {
        if (this.f30026a + 1 < this.f30029d.f30006b.size() || (!this.f30029d.f30007c.isEmpty() && m31879a().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.f30027b) {
            this.f30027b = false;
            this.f30029d.m31851f();
            if (this.f30026a < this.f30029d.f30006b.size()) {
                C9912Ia ia = this.f30029d;
                int i = this.f30026a;
                this.f30026a = i - 1;
                ia.m31848c(i);
                return;
            }
            m31879a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* renamed from: a */
    private final Iterator<Entry<K, V>> m31879a() {
        if (this.f30028c == null) {
            this.f30028c = this.f30029d.f30007c.entrySet().iterator();
        }
        return this.f30028c;
    }

    public final /* synthetic */ Object next() {
        this.f30027b = true;
        int i = this.f30026a + 1;
        this.f30026a = i;
        if (i < this.f30029d.f30006b.size()) {
            return (Entry) this.f30029d.f30006b.get(this.f30026a);
        }
        return (Entry) m31879a().next();
    }

    /* synthetic */ C9928Qa(C9912Ia ia, C9914Ja ja) {
        this(ia);
    }
}
