package com.flurry.sdk;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.flurry.sdk.Nb */
public final class C7426Nb<K, V> {

    /* renamed from: a */
    public final Map<K, List<V>> f14567a = new HashMap();

    /* renamed from: b */
    private int f14568b;

    /* renamed from: a */
    public final void mo23865a() {
        this.f14567a.clear();
    }

    /* renamed from: a */
    public final List<V> mo23863a(K k) {
        if (k == null) {
            return Collections.emptyList();
        }
        List<V> a = mo23864a(k, false);
        if (a == null) {
            return Collections.emptyList();
        }
        return a;
    }

    /* renamed from: a */
    public final List<V> mo23864a(K k, boolean z) {
        List<V> list = (List) this.f14567a.get(k);
        if (z && list == null) {
            int i = this.f14568b;
            if (i > 0) {
                list = new ArrayList<>(i);
            } else {
                list = new ArrayList<>();
            }
            this.f14567a.put(k, list);
        }
        return list;
    }

    /* renamed from: a */
    public final void mo23866a(K k, V v) {
        if (k != null) {
            mo23864a(k, true).add(v);
        }
    }

    /* renamed from: b */
    public final boolean mo23869b(K k, V v) {
        if (k == null) {
            return false;
        }
        List a = mo23864a(k, false);
        if (a == null) {
            return false;
        }
        boolean remove = a.remove(v);
        if (a.size() == 0) {
            this.f14567a.remove(k);
        }
        return remove;
    }

    /* renamed from: b */
    public final boolean mo23868b(K k) {
        return ((List) this.f14567a.remove(k)) != null;
    }

    /* renamed from: b */
    public final Collection<Entry<K, V>> mo23867b() {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.f14567a.entrySet()) {
            for (Object simpleImmutableEntry : (List) entry.getValue()) {
                arrayList.add(new SimpleImmutableEntry(entry.getKey(), simpleImmutableEntry));
            }
        }
        return arrayList;
    }
}
