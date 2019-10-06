package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.tp */
final class C9738tp<E> extends C9565lo<E> {

    /* renamed from: b */
    private static final C9738tp<Object> f23030b;

    /* renamed from: c */
    private final List<E> f23031c;

    /* renamed from: b */
    public static <E> C9738tp<E> m24099b() {
        return f23030b;
    }

    private C9738tp(List<E> list) {
        this.f23031c = list;
    }

    public final void add(int i, E e) {
        mo29061a();
        this.f23031c.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.f23031c.get(i);
    }

    public final E remove(int i) {
        mo29061a();
        E remove = this.f23031c.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        mo29061a();
        E e2 = this.f23031c.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.f23031c.size();
    }

    /* renamed from: b */
    public final /* synthetic */ zzdoj mo28270b(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f23031c);
            return new C9738tp(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        C9738tp<Object> tpVar = new C9738tp<>(new ArrayList(0));
        f23030b = tpVar;
        tpVar.mo29068u();
    }
}
