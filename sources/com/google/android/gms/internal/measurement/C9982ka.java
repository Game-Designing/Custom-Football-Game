package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.ka */
final class C9982ka extends C9976ia {

    /* renamed from: c */
    private static final Class<?> f30126c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private C9982ka() {
        super();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32734a(Object obj, long j) {
        Object obj2;
        List list = (List) C9946_a.m32016f(obj, j);
        if (list instanceof zzve) {
            obj2 = ((zzve) list).mo32922z();
        } else if (!f30126c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof C9900Ca) || !(list instanceof zzuu)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzuu zzuu = (zzuu) list;
                if (zzuu.mo32546w()) {
                    zzuu.mo32545s();
                }
                return;
            }
        } else {
            return;
        }
        C9946_a.m31994a(obj, j, obj2);
    }

    /* renamed from: a */
    private static <L> List<L> m32111a(Object obj, long j, int i) {
        List<L> list;
        List<L> b = m32112b(obj, j);
        if (b.isEmpty()) {
            if (b instanceof zzve) {
                list = new zzvd<>(i);
            } else if (!(b instanceof C9900Ca) || !(b instanceof zzuu)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzuu) b).mo32721e(i);
            }
            C9946_a.m31994a(obj, j, (Object) list);
            return list;
        } else if (f30126c.isAssignableFrom(b.getClass())) {
            ArrayList arrayList = new ArrayList(b.size() + i);
            arrayList.addAll(b);
            C9946_a.m31994a(obj, j, (Object) arrayList);
            return arrayList;
        } else if (b instanceof zzxg) {
            zzvd zzvd = new zzvd(b.size() + i);
            zzvd.addAll((zzxg) b);
            C9946_a.m31994a(obj, j, (Object) zzvd);
            return zzvd;
        } else if (!(b instanceof C9900Ca) || !(b instanceof zzuu)) {
            return b;
        } else {
            zzuu zzuu = (zzuu) b;
            if (zzuu.mo32546w()) {
                return b;
            }
            zzuu e = zzuu.mo32721e(b.size() + i);
            C9946_a.m31994a(obj, j, (Object) e);
            return e;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final <E> void mo32735a(Object obj, Object obj2, long j) {
        List b = m32112b(obj2, j);
        List a = m32111a(obj, j, b.size());
        int size = a.size();
        int size2 = b.size();
        if (size > 0 && size2 > 0) {
            a.addAll(b);
        }
        if (size > 0) {
            b = a;
        }
        C9946_a.m31994a(obj, j, (Object) b);
    }

    /* renamed from: b */
    private static <E> List<E> m32112b(Object obj, long j) {
        return (List) C9946_a.m32016f(obj, j);
    }
}
