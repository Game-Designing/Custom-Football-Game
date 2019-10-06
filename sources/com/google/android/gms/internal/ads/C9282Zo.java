package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.Zo */
final class C9282Zo extends C9240Xo {

    /* renamed from: c */
    private static final Class<?> f22031c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private C9282Zo() {
        super();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final <L> List<L> mo28696a(Object obj, long j) {
        return m23371a(obj, j, 10);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo28698b(Object obj, long j) {
        Object obj2;
        List list = (List) C9132Sp.m23009f(obj, j);
        if (list instanceof zzdot) {
            obj2 = ((zzdot) list).mo31633y();
        } else if (!f22031c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof C9696rp) || !(list instanceof zzdoj)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzdoj zzdoj = (zzdoj) list;
                if (zzdoj.mo29067t()) {
                    zzdoj.mo29068u();
                }
                return;
            }
        } else {
            return;
        }
        C9132Sp.m22986a(obj, j, obj2);
    }

    /* renamed from: a */
    private static <L> List<L> m23371a(Object obj, long j, int i) {
        List<L> list;
        List<L> c = m23372c(obj, j);
        if (c.isEmpty()) {
            if (c instanceof zzdot) {
                list = new zzdos<>(i);
            } else if (!(c instanceof C9696rp) || !(c instanceof zzdoj)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzdoj) c).mo28270b(i);
            }
            C9132Sp.m22986a(obj, j, (Object) list);
            return list;
        } else if (f22031c.isAssignableFrom(c.getClass())) {
            ArrayList arrayList = new ArrayList(c.size() + i);
            arrayList.addAll(c);
            C9132Sp.m22986a(obj, j, (Object) arrayList);
            return arrayList;
        } else if (c instanceof zzdqw) {
            zzdos zzdos = new zzdos(c.size() + i);
            zzdos.addAll((zzdqw) c);
            C9132Sp.m22986a(obj, j, (Object) zzdos);
            return zzdos;
        } else if (!(c instanceof C9696rp) || !(c instanceof zzdoj)) {
            return c;
        } else {
            zzdoj zzdoj = (zzdoj) c;
            if (zzdoj.mo29067t()) {
                return c;
            }
            zzdoj b = zzdoj.mo28270b(c.size() + i);
            C9132Sp.m22986a(obj, j, (Object) b);
            return b;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final <E> void mo28697a(Object obj, Object obj2, long j) {
        List c = m23372c(obj2, j);
        List a = m23371a(obj, j, c.size());
        int size = a.size();
        int size2 = c.size();
        if (size > 0 && size2 > 0) {
            a.addAll(c);
        }
        if (size > 0) {
            c = a;
        }
        C9132Sp.m22986a(obj, j, (Object) c);
    }

    /* renamed from: c */
    private static <E> List<E> m23372c(Object obj, long j) {
        return (List) C9132Sp.m23009f(obj, j);
    }
}
