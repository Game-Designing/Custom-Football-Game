package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Cp */
final class C8797Cp implements Iterator<Entry<K, V>> {

    /* renamed from: a */
    private int f20570a;

    /* renamed from: b */
    private Iterator<Entry<K, V>> f20571b;

    /* renamed from: c */
    private final /* synthetic */ C8755Ap f20572c;

    private C8797Cp(C8755Ap ap) {
        this.f20572c = ap;
        this.f20570a = this.f20572c.f20465b.size();
    }

    public final boolean hasNext() {
        int i = this.f20570a;
        return (i > 0 && i <= this.f20572c.f20465b.size()) || m22372a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    private final Iterator<Entry<K, V>> m22372a() {
        if (this.f20571b == null) {
            this.f20571b = this.f20572c.f20469f.entrySet().iterator();
        }
        return this.f20571b;
    }

    public final /* synthetic */ Object next() {
        if (m22372a().hasNext()) {
            return (Entry) m22372a().next();
        }
        List b = this.f20572c.f20465b;
        int i = this.f20570a - 1;
        this.f20570a = i;
        return (Entry) b.get(i);
    }

    /* synthetic */ C8797Cp(C8755Ap ap, C8776Bp bp) {
        this(ap);
    }
}
