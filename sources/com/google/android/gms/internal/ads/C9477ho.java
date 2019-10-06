package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.ads.ho */
final class C9477ho {

    /* renamed from: a */
    private final ConcurrentHashMap<C9499io, List<Throwable>> f22424a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f22425b = new ReferenceQueue<>();

    C9477ho() {
    }

    /* renamed from: a */
    public final List<Throwable> mo28992a(Throwable th, boolean z) {
        Reference poll = this.f22425b.poll();
        while (poll != null) {
            this.f22424a.remove(poll);
            poll = this.f22425b.poll();
        }
        List<Throwable> list = (List) this.f22424a.get(new C9499io(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> list2 = (List) this.f22424a.putIfAbsent(new C9499io(th, this.f22425b), vector);
        return list2 == null ? vector : list2;
    }
}
