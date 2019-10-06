package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.measurement.B */
final class C9897B {

    /* renamed from: a */
    private final ConcurrentHashMap<Object, List<Throwable>> f29983a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f29984b = new ReferenceQueue<>();

    C9897B() {
    }
}
