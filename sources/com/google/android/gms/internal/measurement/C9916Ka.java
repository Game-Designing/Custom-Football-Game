package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.Ka */
final class C9916Ka implements Iterator<Entry<K, V>> {

    /* renamed from: a */
    private int f30014a;

    /* renamed from: b */
    private Iterator<Entry<K, V>> f30015b;

    /* renamed from: c */
    private final /* synthetic */ C9912Ia f30016c;

    private C9916Ka(C9912Ia ia) {
        this.f30016c = ia;
        this.f30014a = this.f30016c.f30006b.size();
    }

    public final boolean hasNext() {
        int i = this.f30014a;
        return (i > 0 && i <= this.f30016c.f30006b.size()) || m31864a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    private final Iterator<Entry<K, V>> m31864a() {
        if (this.f30015b == null) {
            this.f30015b = this.f30016c.f30010f.entrySet().iterator();
        }
        return this.f30015b;
    }

    public final /* synthetic */ Object next() {
        if (m31864a().hasNext()) {
            return (Entry) m31864a().next();
        }
        List b = this.f30016c.f30006b;
        int i = this.f30014a - 1;
        this.f30014a = i;
        return (Entry) b.get(i);
    }

    /* synthetic */ C9916Ka(C9912Ia ia, C9914Ja ja) {
        this(ia);
    }
}
