package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzxg extends AbstractList<String> implements zzve, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzve f30378a;

    public zzxg(zzve zzve) {
        this.f30378a = zzve;
    }

    /* renamed from: f */
    public final Object mo32917f(int i) {
        return this.f30378a.mo32917f(i);
    }

    public final int size() {
        return this.f30378a.size();
    }

    public final ListIterator<String> listIterator(int i) {
        return new C9943Ya(this, i);
    }

    public final Iterator<String> iterator() {
        return new C9945Za(this);
    }

    /* renamed from: A */
    public final List<?> mo32915A() {
        return this.f30378a.mo32915A();
    }

    /* renamed from: z */
    public final zzve mo32922z() {
        return this;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.f30378a.get(i);
    }
}
