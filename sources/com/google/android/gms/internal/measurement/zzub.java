package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zzd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzub {

    /* renamed from: a */
    private static volatile boolean f30262a = false;

    /* renamed from: b */
    private static final Class<?> f30263b = m32508b();

    /* renamed from: c */
    static final zzub f30264c = new zzub(true);

    /* renamed from: d */
    private final Map<Object, zzd<?, ?>> f30265d;

    /* renamed from: b */
    private static Class<?> m32508b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static zzub m32507a() {
        return C9936V.m31929a();
    }

    zzub() {
        this.f30265d = new HashMap();
    }

    private zzub(boolean z) {
        this.f30265d = Collections.emptyMap();
    }
}
