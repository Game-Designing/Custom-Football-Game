package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.measurement.Ya */
final class C9943Ya implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f30043a = this.f30045c.f30378a.listIterator(this.f30044b);

    /* renamed from: b */
    private final /* synthetic */ int f30044b;

    /* renamed from: c */
    private final /* synthetic */ zzxg f30045c;

    C9943Ya(zzxg zzxg, int i) {
        this.f30045c = zzxg;
        this.f30044b = i;
    }

    public final boolean hasNext() {
        return this.f30043a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f30043a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f30043a.nextIndex();
    }

    public final int previousIndex() {
        return this.f30043a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return (String) this.f30043a.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f30043a.next();
    }
}
