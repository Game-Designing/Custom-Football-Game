package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.Ra */
class C9929Ra extends AbstractSet<Entry<K, V>> {

    /* renamed from: a */
    private final /* synthetic */ C9912Ia f30030a;

    private C9929Ra(C9912Ia ia) {
        this.f30030a = ia;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new C9928Qa(this.f30030a, null);
    }

    public int size() {
        return this.f30030a.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.f30030a.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f30030a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f30030a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f30030a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ C9929Ra(C9912Ia ia, C9914Ja ja) {
        this(ia);
    }
}
