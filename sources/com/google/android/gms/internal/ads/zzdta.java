package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzdta<E> extends AbstractList<E> {

    /* renamed from: a */
    private static final zzdtc f28283a = zzdtc.m30099a(zzdta.class);

    /* renamed from: b */
    List<E> f28284b;

    /* renamed from: c */
    Iterator<E> f28285c;

    public zzdta(List<E> list, Iterator<E> it) {
        this.f28284b = list;
        this.f28285c = it;
    }

    public E get(int i) {
        if (this.f28284b.size() > i) {
            return this.f28284b.get(i);
        }
        if (this.f28285c.hasNext()) {
            this.f28284b.add(this.f28285c.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new C9739tq(this);
    }

    public int size() {
        f28283a.mo31691a("potentially expensive size() call");
        f28283a.mo31691a("blowup running");
        while (this.f28285c.hasNext()) {
            this.f28284b.add(this.f28285c.next());
        }
        return this.f28284b.size();
    }
}
