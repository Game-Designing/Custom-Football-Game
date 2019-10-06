package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzdtq<T> implements zzdti<Set<T>> {

    /* renamed from: a */
    private static final zzdti<Set<Object>> f28309a = zzdtj.m30109a(Collections.emptySet());

    /* renamed from: b */
    private final List<zzdtu<T>> f28310b;

    /* renamed from: c */
    private final List<zzdtu<Collection<T>>> f28311c;

    /* renamed from: a */
    public static <T> zzdts<T> m30120a(int i, int i2) {
        return new zzdts<>(i, i2);
    }

    private zzdtq(List<zzdtu<T>> list, List<zzdtu<Collection<T>>> list2) {
        this.f28310b = list;
        this.f28311c = list2;
    }

    public final /* synthetic */ Object get() {
        int size = this.f28310b.size();
        ArrayList arrayList = new ArrayList(this.f28311c.size());
        int size2 = this.f28311c.size();
        int i = size;
        for (int i2 = 0; i2 < size2; i2++) {
            Collection collection = (Collection) ((zzdtu) this.f28311c.get(i2)).get();
            i += collection.size();
            arrayList.add(collection);
        }
        HashSet b = zzdtf.m30103b(i);
        int size3 = this.f28310b.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Object obj = ((zzdtu) this.f28310b.get(i3)).get();
            zzdto.m30113a(obj);
            b.add(obj);
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object next : (Collection) arrayList.get(i4)) {
                zzdto.m30113a(next);
                b.add(next);
            }
        }
        return Collections.unmodifiableSet(b);
    }
}
