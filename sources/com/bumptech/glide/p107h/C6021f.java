package com.bumptech.glide.p107h;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.h.f */
/* compiled from: LruCache */
public class C6021f<T, Y> {

    /* renamed from: a */
    private final Map<T, Y> f10656a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    private final long f10657b;

    /* renamed from: c */
    private long f10658c;

    /* renamed from: d */
    private long f10659d;

    public C6021f(long size) {
        this.f10657b = size;
        this.f10658c = size;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo18816b(Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18815a(T t, Y y) {
    }

    /* renamed from: b */
    public synchronized long mo18817b() {
        return this.f10658c;
    }

    /* renamed from: a */
    public synchronized Y mo18812a(T key) {
        return this.f10656a.get(key);
    }

    /* renamed from: b */
    public synchronized Y mo18818b(T key, Y item) {
        int itemSize = mo18816b(item);
        if (((long) itemSize) >= this.f10658c) {
            mo18815a(key, item);
            return null;
        }
        if (item != null) {
            this.f10659d += (long) itemSize;
        }
        Y old = this.f10656a.put(key, item);
        if (old != null) {
            this.f10659d -= (long) mo18816b(old);
            if (!old.equals(item)) {
                mo18815a(key, old);
            }
        }
        m11251c();
        return old;
    }

    /* renamed from: c */
    public synchronized Y mo18819c(T key) {
        Y value;
        value = this.f10656a.remove(key);
        if (value != null) {
            this.f10659d -= (long) mo18816b(value);
        }
        return value;
    }

    /* renamed from: a */
    public void mo18813a() {
        mo18814a(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo18814a(long size) {
        while (this.f10659d > size) {
            Iterator<Entry<T, Y>> cacheIterator = this.f10656a.entrySet().iterator();
            Entry<T, Y> last = (Entry) cacheIterator.next();
            Y toRemove = last.getValue();
            this.f10659d -= (long) mo18816b(toRemove);
            T key = last.getKey();
            cacheIterator.remove();
            mo18815a(key, toRemove);
        }
    }

    /* renamed from: c */
    private void m11251c() {
        mo18814a(this.f10658c);
    }
}
