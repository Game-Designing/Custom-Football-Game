package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.measurement.Za */
final class C9945Za implements Iterator<String> {

    /* renamed from: a */
    private Iterator<String> f30050a = this.f30051b.f30378a.iterator();

    /* renamed from: b */
    private final /* synthetic */ zzxg f30051b;

    C9945Za(zzxg zzxg) {
        this.f30051b = zzxg;
    }

    public final boolean hasNext() {
        return this.f30050a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f30050a.next();
    }
}
