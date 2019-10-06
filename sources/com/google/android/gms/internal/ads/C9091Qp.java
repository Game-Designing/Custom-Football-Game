package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.ads.Qp */
final class C9091Qp implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f21625a = this.f21627c.f28120a.listIterator(this.f21626b);

    /* renamed from: b */
    private final /* synthetic */ int f21626b;

    /* renamed from: c */
    private final /* synthetic */ zzdqw f21627c;

    C9091Qp(zzdqw zzdqw, int i) {
        this.f21627c = zzdqw;
        this.f21626b = i;
    }

    public final boolean hasNext() {
        return this.f21625a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f21625a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f21625a.nextIndex();
    }

    public final int previousIndex() {
        return this.f21625a.previousIndex();
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
        return (String) this.f21625a.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f21625a.next();
    }
}
