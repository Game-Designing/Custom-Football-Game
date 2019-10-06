package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.tq */
final class C9739tq implements Iterator<E> {

    /* renamed from: a */
    private int f23032a = 0;

    /* renamed from: b */
    private final /* synthetic */ zzdta f23033b;

    C9739tq(zzdta zzdta) {
        this.f23033b = zzdta;
    }

    public final boolean hasNext() {
        return this.f23032a < this.f23033b.f28284b.size() || this.f23033b.f28285c.hasNext();
    }

    public final E next() {
        while (this.f23032a >= this.f23033b.f28284b.size()) {
            zzdta zzdta = this.f23033b;
            zzdta.f28284b.add(zzdta.f28285c.next());
        }
        List<E> list = this.f23033b.f28284b;
        int i = this.f23032a;
        this.f23032a = i + 1;
        return list.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
