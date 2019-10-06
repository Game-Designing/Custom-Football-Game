package com.google.android.gms.internal.ads;

public enum zzdri {
    DOUBLE(zzdrn.DOUBLE, 1),
    FLOAT(zzdrn.FLOAT, 5),
    INT64(zzdrn.LONG, 0),
    UINT64(zzdrn.LONG, 0),
    INT32(zzdrn.INT, 0),
    FIXED64(zzdrn.LONG, 1),
    FIXED32(zzdrn.INT, 5),
    BOOL(zzdrn.BOOLEAN, 0),
    STRING(zzdrn.STRING, 2),
    GROUP(zzdrn.MESSAGE, 3),
    MESSAGE(zzdrn.MESSAGE, 2),
    BYTES(zzdrn.BYTE_STRING, 2),
    UINT32(zzdrn.INT, 0),
    ENUM(zzdrn.ENUM, 0),
    SFIXED32(zzdrn.INT, 5),
    SFIXED64(zzdrn.LONG, 1),
    SINT32(zzdrn.INT, 0),
    SINT64(zzdrn.LONG, 0);
    

    /* renamed from: t */
    private final zzdrn f28140t;

    /* renamed from: u */
    private final int f28141u;

    private zzdri(zzdrn zzdrn, int i) {
        this.f28140t = zzdrn;
        this.f28141u = i;
    }

    /* renamed from: e */
    public final zzdrn mo31660e() {
        return this.f28140t;
    }
}
