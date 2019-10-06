package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

public enum zzdnv {
    DOUBLE(0, C9048Oo.SCALAR, zzdom.DOUBLE),
    FLOAT(1, C9048Oo.SCALAR, zzdom.FLOAT),
    INT64(2, C9048Oo.SCALAR, zzdom.LONG),
    UINT64(3, C9048Oo.SCALAR, zzdom.LONG),
    INT32(4, C9048Oo.SCALAR, zzdom.INT),
    FIXED64(5, C9048Oo.SCALAR, zzdom.LONG),
    FIXED32(6, C9048Oo.SCALAR, zzdom.INT),
    BOOL(7, C9048Oo.SCALAR, zzdom.BOOLEAN),
    STRING(8, C9048Oo.SCALAR, zzdom.STRING),
    MESSAGE(9, C9048Oo.SCALAR, zzdom.MESSAGE),
    BYTES(10, C9048Oo.SCALAR, zzdom.BYTE_STRING),
    UINT32(11, C9048Oo.SCALAR, zzdom.INT),
    ENUM(12, C9048Oo.SCALAR, zzdom.ENUM),
    SFIXED32(13, C9048Oo.SCALAR, zzdom.INT),
    SFIXED64(14, C9048Oo.SCALAR, zzdom.LONG),
    SINT32(15, C9048Oo.SCALAR, zzdom.INT),
    SINT64(16, C9048Oo.SCALAR, zzdom.LONG),
    GROUP(17, C9048Oo.SCALAR, zzdom.MESSAGE),
    DOUBLE_LIST(18, C9048Oo.VECTOR, zzdom.DOUBLE),
    FLOAT_LIST(19, C9048Oo.VECTOR, zzdom.FLOAT),
    INT64_LIST(20, C9048Oo.VECTOR, zzdom.LONG),
    UINT64_LIST(21, C9048Oo.VECTOR, zzdom.LONG),
    INT32_LIST(22, C9048Oo.VECTOR, zzdom.INT),
    FIXED64_LIST(23, C9048Oo.VECTOR, zzdom.LONG),
    FIXED32_LIST(24, C9048Oo.VECTOR, zzdom.INT),
    BOOL_LIST(25, C9048Oo.VECTOR, zzdom.BOOLEAN),
    STRING_LIST(26, C9048Oo.VECTOR, zzdom.STRING),
    MESSAGE_LIST(27, C9048Oo.VECTOR, zzdom.MESSAGE),
    BYTES_LIST(28, C9048Oo.VECTOR, zzdom.BYTE_STRING),
    UINT32_LIST(29, C9048Oo.VECTOR, zzdom.INT),
    ENUM_LIST(30, C9048Oo.VECTOR, zzdom.ENUM),
    SFIXED32_LIST(31, C9048Oo.VECTOR, zzdom.INT),
    SFIXED64_LIST(32, C9048Oo.VECTOR, zzdom.LONG),
    SINT32_LIST(33, C9048Oo.VECTOR, zzdom.INT),
    SINT64_LIST(34, C9048Oo.VECTOR, zzdom.LONG),
    DOUBLE_LIST_PACKED(35, C9048Oo.PACKED_VECTOR, zzdom.DOUBLE),
    FLOAT_LIST_PACKED(36, C9048Oo.PACKED_VECTOR, zzdom.FLOAT),
    INT64_LIST_PACKED(37, C9048Oo.PACKED_VECTOR, zzdom.LONG),
    UINT64_LIST_PACKED(38, C9048Oo.PACKED_VECTOR, zzdom.LONG),
    INT32_LIST_PACKED(39, C9048Oo.PACKED_VECTOR, zzdom.INT),
    FIXED64_LIST_PACKED(40, C9048Oo.PACKED_VECTOR, zzdom.LONG),
    FIXED32_LIST_PACKED(41, C9048Oo.PACKED_VECTOR, zzdom.INT),
    BOOL_LIST_PACKED(42, C9048Oo.PACKED_VECTOR, zzdom.BOOLEAN),
    UINT32_LIST_PACKED(43, C9048Oo.PACKED_VECTOR, zzdom.INT),
    ENUM_LIST_PACKED(44, C9048Oo.PACKED_VECTOR, zzdom.ENUM),
    SFIXED32_LIST_PACKED(45, C9048Oo.PACKED_VECTOR, zzdom.INT),
    SFIXED64_LIST_PACKED(46, C9048Oo.PACKED_VECTOR, zzdom.LONG),
    SINT32_LIST_PACKED(47, C9048Oo.PACKED_VECTOR, zzdom.INT),
    SINT64_LIST_PACKED(48, C9048Oo.PACKED_VECTOR, zzdom.LONG),
    GROUP_LIST(49, C9048Oo.VECTOR, zzdom.MESSAGE),
    MAP(50, C9048Oo.MAP, zzdom.VOID);
    

    /* renamed from: Z */
    private static final zzdnv[] f28032Z = null;

    /* renamed from: aa */
    private static final Type[] f28034aa = null;

    /* renamed from: ca */
    private final zzdom f28061ca;

    /* renamed from: da */
    private final int f28062da;

    /* renamed from: ea */
    private final C9048Oo f28063ea;

    /* renamed from: fa */
    private final Class<?> f28064fa;

    /* renamed from: ga */
    private final boolean f28065ga;

    private zzdnv(int i, C9048Oo oo, zzdom zzdom) {
        this.f28062da = i;
        this.f28063ea = oo;
        this.f28061ca = zzdom;
        int i2 = C9027No.f21518a[oo.ordinal()];
        if (i2 == 1) {
            this.f28064fa = zzdom.mo31618e();
        } else if (i2 != 2) {
            this.f28064fa = null;
        } else {
            this.f28064fa = zzdom.mo31618e();
        }
        boolean z = false;
        if (oo == C9048Oo.SCALAR) {
            int i3 = C9027No.f21519b[zzdom.ordinal()];
            if (!(i3 == 1 || i3 == 2 || i3 == 3)) {
                z = true;
            }
        }
        this.f28065ga = z;
    }

    /* renamed from: e */
    public final int mo31600e() {
        return this.f28062da;
    }

    static {
        int i;
        f28034aa = new Type[0];
        zzdnv[] values = values();
        f28032Z = new zzdnv[values.length];
        for (zzdnv zzdnv : values) {
            f28032Z[zzdnv.f28062da] = zzdnv;
        }
    }
}
