package com.google.android.gms.internal.measurement;

public enum zzux {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, Integer.valueOf(0)),
    LONG(Long.TYPE, Long.class, Long.valueOf(0)),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.valueOf(false)),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzte.class, zzte.class, zzte.f30248a),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    

    /* renamed from: l */
    private final Class<?> f30359l;

    /* renamed from: m */
    private final Class<?> f30360m;

    /* renamed from: n */
    private final Object f30361n;

    private zzux(Class<?> cls, Class<?> cls2, Object obj) {
        this.f30359l = cls;
        this.f30360m = cls2;
        this.f30361n = obj;
    }

    /* renamed from: e */
    public final Class<?> mo32908e() {
        return this.f30360m;
    }
}
