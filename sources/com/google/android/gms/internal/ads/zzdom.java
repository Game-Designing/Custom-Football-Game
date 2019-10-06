package com.google.android.gms.internal.ads;

public enum zzdom {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, Integer.valueOf(0)),
    LONG(Long.TYPE, Long.class, Long.valueOf(0)),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.valueOf(false)),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdmr.class, zzdmr.class, zzdmr.f27972a),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    

    /* renamed from: l */
    private final Class<?> f28101l;

    /* renamed from: m */
    private final Class<?> f28102m;

    /* renamed from: n */
    private final Object f28103n;

    private zzdom(Class<?> cls, Class<?> cls2, Object obj) {
        this.f28101l = cls;
        this.f28102m = cls2;
        this.f28103n = obj;
    }

    /* renamed from: e */
    public final Class<?> mo31618e() {
        return this.f28102m;
    }
}
