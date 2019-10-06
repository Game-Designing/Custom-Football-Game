package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

public enum zzui {
    DOUBLE(0, C9958ca.SCALAR, zzux.DOUBLE),
    FLOAT(1, C9958ca.SCALAR, zzux.FLOAT),
    INT64(2, C9958ca.SCALAR, zzux.LONG),
    UINT64(3, C9958ca.SCALAR, zzux.LONG),
    INT32(4, C9958ca.SCALAR, zzux.INT),
    FIXED64(5, C9958ca.SCALAR, zzux.LONG),
    FIXED32(6, C9958ca.SCALAR, zzux.INT),
    BOOL(7, C9958ca.SCALAR, zzux.BOOLEAN),
    STRING(8, C9958ca.SCALAR, zzux.STRING),
    MESSAGE(9, C9958ca.SCALAR, zzux.MESSAGE),
    BYTES(10, C9958ca.SCALAR, zzux.BYTE_STRING),
    UINT32(11, C9958ca.SCALAR, zzux.INT),
    ENUM(12, C9958ca.SCALAR, zzux.ENUM),
    SFIXED32(13, C9958ca.SCALAR, zzux.INT),
    SFIXED64(14, C9958ca.SCALAR, zzux.LONG),
    SINT32(15, C9958ca.SCALAR, zzux.INT),
    SINT64(16, C9958ca.SCALAR, zzux.LONG),
    GROUP(17, C9958ca.SCALAR, zzux.MESSAGE),
    DOUBLE_LIST(18, C9958ca.VECTOR, zzux.DOUBLE),
    FLOAT_LIST(19, C9958ca.VECTOR, zzux.FLOAT),
    INT64_LIST(20, C9958ca.VECTOR, zzux.LONG),
    UINT64_LIST(21, C9958ca.VECTOR, zzux.LONG),
    INT32_LIST(22, C9958ca.VECTOR, zzux.INT),
    FIXED64_LIST(23, C9958ca.VECTOR, zzux.LONG),
    FIXED32_LIST(24, C9958ca.VECTOR, zzux.INT),
    BOOL_LIST(25, C9958ca.VECTOR, zzux.BOOLEAN),
    STRING_LIST(26, C9958ca.VECTOR, zzux.STRING),
    MESSAGE_LIST(27, C9958ca.VECTOR, zzux.MESSAGE),
    BYTES_LIST(28, C9958ca.VECTOR, zzux.BYTE_STRING),
    UINT32_LIST(29, C9958ca.VECTOR, zzux.INT),
    ENUM_LIST(30, C9958ca.VECTOR, zzux.ENUM),
    SFIXED32_LIST(31, C9958ca.VECTOR, zzux.INT),
    SFIXED64_LIST(32, C9958ca.VECTOR, zzux.LONG),
    SINT32_LIST(33, C9958ca.VECTOR, zzux.INT),
    SINT64_LIST(34, C9958ca.VECTOR, zzux.LONG),
    DOUBLE_LIST_PACKED(35, C9958ca.PACKED_VECTOR, zzux.DOUBLE),
    FLOAT_LIST_PACKED(36, C9958ca.PACKED_VECTOR, zzux.FLOAT),
    INT64_LIST_PACKED(37, C9958ca.PACKED_VECTOR, zzux.LONG),
    UINT64_LIST_PACKED(38, C9958ca.PACKED_VECTOR, zzux.LONG),
    INT32_LIST_PACKED(39, C9958ca.PACKED_VECTOR, zzux.INT),
    FIXED64_LIST_PACKED(40, C9958ca.PACKED_VECTOR, zzux.LONG),
    FIXED32_LIST_PACKED(41, C9958ca.PACKED_VECTOR, zzux.INT),
    BOOL_LIST_PACKED(42, C9958ca.PACKED_VECTOR, zzux.BOOLEAN),
    UINT32_LIST_PACKED(43, C9958ca.PACKED_VECTOR, zzux.INT),
    ENUM_LIST_PACKED(44, C9958ca.PACKED_VECTOR, zzux.ENUM),
    SFIXED32_LIST_PACKED(45, C9958ca.PACKED_VECTOR, zzux.INT),
    SFIXED64_LIST_PACKED(46, C9958ca.PACKED_VECTOR, zzux.LONG),
    SINT32_LIST_PACKED(47, C9958ca.PACKED_VECTOR, zzux.INT),
    SINT64_LIST_PACKED(48, C9958ca.PACKED_VECTOR, zzux.LONG),
    GROUP_LIST(49, C9958ca.VECTOR, zzux.MESSAGE),
    MAP(50, C9958ca.MAP, zzux.VOID);
    

    /* renamed from: Z */
    private static final zzui[] f30291Z = null;

    /* renamed from: aa */
    private static final Type[] f30293aa = null;

    /* renamed from: ca */
    private final zzux f30320ca;

    /* renamed from: da */
    private final int f30321da;

    /* renamed from: ea */
    private final C9958ca f30322ea;

    /* renamed from: fa */
    private final Class<?> f30323fa;

    /* renamed from: ga */
    private final boolean f30324ga;

    private zzui(int i, C9958ca caVar, zzux zzux) {
        this.f30321da = i;
        this.f30322ea = caVar;
        this.f30320ca = zzux;
        int i2 = C9955ba.f30084a[caVar.ordinal()];
        if (i2 == 1) {
            this.f30323fa = zzux.mo32908e();
        } else if (i2 != 2) {
            this.f30323fa = null;
        } else {
            this.f30323fa = zzux.mo32908e();
        }
        boolean z = false;
        if (caVar == C9958ca.SCALAR) {
            int i3 = C9955ba.f30085b[zzux.ordinal()];
            if (!(i3 == 1 || i3 == 2 || i3 == 3)) {
                z = true;
            }
        }
        this.f30324ga = z;
    }

    /* renamed from: e */
    public final int mo32891e() {
        return this.f30321da;
    }

    static {
        int i;
        f30293aa = new Type[0];
        zzui[] values = values();
        f30291Z = new zzui[values.length];
        for (zzui zzui : values) {
            f30291Z[zzui.f30321da] = zzui;
        }
    }
}
