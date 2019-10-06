package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Jp */
class C8944Jp extends AbstractSet<Entry<K, V>> {

    /* renamed from: a */
    private final /* synthetic */ C8755Ap f21363a;

    private C8944Jp(C8755Ap ap) {
        this.f21363a = ap;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new C8923Ip(this.f21363a, null);
    }

    public int size() {
        return this.f21363a.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.f21363a.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f21363a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f21363a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f21363a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ C8944Jp(C8755Ap ap, C8776Bp bp) {
        this(ap);
    }
}
