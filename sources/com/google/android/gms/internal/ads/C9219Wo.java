package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.ads.Wo */
final class C9219Wo<K> implements Iterator<Entry<K, Object>> {

    /* renamed from: a */
    private Iterator<Entry<K, Object>> f21904a;

    public C9219Wo(Iterator<Entry<K, Object>> it) {
        this.f21904a = it;
    }

    public final boolean hasNext() {
        return this.f21904a.hasNext();
    }

    public final void remove() {
        this.f21904a.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.f21904a.next();
        if (entry.getValue() instanceof zzdon) {
            return new C9198Vo(entry);
        }
        return entry;
    }
}
