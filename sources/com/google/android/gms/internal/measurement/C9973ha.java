package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.measurement.ha */
final class C9973ha<K> implements Iterator<Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Entry<K, Object>> f30117a;

    public C9973ha(Iterator<Entry<K, Object>> it) {
        this.f30117a = it;
    }

    public final boolean hasNext() {
        return this.f30117a.hasNext();
    }

    public final void remove() {
        this.f30117a.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.f30117a.next();
        if (entry.getValue() instanceof zzuy) {
            return new C9970ga(entry);
        }
        return entry;
    }
}
