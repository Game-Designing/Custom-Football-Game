package com.bumptech.glide.p107h;

import p002b.p003c.p053g.p061f.C1253b;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: com.bumptech.glide.h.b */
/* compiled from: CachedHashCodeArrayMap */
public final class C6017b<K, V> extends C1253b<K, V> {

    /* renamed from: i */
    private int f10649i;

    public void clear() {
        this.f10649i = 0;
        super.clear();
    }

    /* renamed from: a */
    public V mo9153a(int index, V value) {
        this.f10649i = 0;
        return super.mo9153a(index, value);
    }

    public V put(K key, V value) {
        this.f10649i = 0;
        return super.put(key, value);
    }

    /* renamed from: a */
    public void mo9155a(C1273q<? extends K, ? extends V> simpleArrayMap) {
        this.f10649i = 0;
        super.mo9155a(simpleArrayMap);
    }

    /* renamed from: c */
    public V mo9158c(int index) {
        this.f10649i = 0;
        return super.mo9158c(index);
    }

    public int hashCode() {
        if (this.f10649i == 0) {
            this.f10649i = super.hashCode();
        }
        return this.f10649i;
    }
}
