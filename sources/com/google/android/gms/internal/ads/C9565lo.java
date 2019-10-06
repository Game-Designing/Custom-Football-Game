package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.ads.lo */
abstract class C9565lo<E> extends AbstractList<E> implements zzdoj<E> {

    /* renamed from: a */
    private boolean f22728a = true;

    C9565lo() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        mo29061a();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        mo29061a();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        mo29061a();
        return super.addAll(i, collection);
    }

    public void clear() {
        mo29061a();
        super.clear();
    }

    /* renamed from: t */
    public boolean mo29067t() {
        return this.f22728a;
    }

    /* renamed from: u */
    public final void mo29068u() {
        this.f22728a = false;
    }

    public boolean remove(Object obj) {
        mo29061a();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        mo29061a();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        mo29061a();
        return super.retainAll(collection);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo29061a() {
        if (!this.f22728a) {
            throw new UnsupportedOperationException();
        }
    }
}
