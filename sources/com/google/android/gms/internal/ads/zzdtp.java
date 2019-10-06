package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzdtp<T> {

    /* renamed from: a */
    private final List<T> f28308a = new ArrayList(11);

    private zzdtp(int i) {
    }

    /* renamed from: a */
    public static <T> zzdtp<T> m30116a(int i) {
        return new zzdtp<>(11);
    }

    /* renamed from: a */
    public final zzdtp<T> mo31701a(T t) {
        List<T> list = this.f28308a;
        zzdto.m30114a(t, "Set contributions cannot be null");
        list.add(t);
        return this;
    }

    /* renamed from: a */
    public final zzdtp<T> mo31702a(Collection<? extends T> collection) {
        for (Object a : collection) {
            zzdto.m30114a(a, "Set contributions cannot be null");
        }
        this.f28308a.addAll(collection);
        return this;
    }

    /* renamed from: a */
    public final Set<T> mo31703a() {
        int size = this.f28308a.size();
        if (size == 0) {
            return Collections.emptySet();
        }
        if (size != 1) {
            return Collections.unmodifiableSet(new HashSet(this.f28308a));
        }
        return Collections.singleton(this.f28308a.get(0));
    }
}
