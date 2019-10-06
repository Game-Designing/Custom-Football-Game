package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.E */
abstract class C9903E<E> extends AbstractList<E> implements zzuu<E> {

    /* renamed from: a */
    private boolean f29991a = true;

    C9903E() {
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
        mo32535a();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        mo32535a();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        mo32535a();
        return super.addAll(i, collection);
    }

    public void clear() {
        mo32535a();
        super.clear();
    }

    /* renamed from: w */
    public boolean mo32546w() {
        return this.f29991a;
    }

    /* renamed from: s */
    public final void mo32545s() {
        this.f29991a = false;
    }

    public boolean remove(Object obj) {
        mo32535a();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        mo32535a();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        mo32535a();
        return super.retainAll(collection);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32535a() {
        if (!this.f29991a) {
            throw new UnsupportedOperationException();
        }
    }
}
