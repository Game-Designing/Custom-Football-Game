package com.google.zxing.common.reedsolomon;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.common.reedsolomon.a */
/* compiled from: GenericGF */
public final class C10227a {

    /* renamed from: a */
    public static final C10227a f31008a = new C10227a(4201, Opcodes.ACC_SYNTHETIC, 1);

    /* renamed from: b */
    public static final C10227a f31009b = new C10227a(1033, Opcodes.ACC_ABSTRACT, 1);

    /* renamed from: c */
    public static final C10227a f31010c = new C10227a(67, 64, 1);

    /* renamed from: d */
    public static final C10227a f31011d = new C10227a(19, 16, 1);

    /* renamed from: e */
    public static final C10227a f31012e = new C10227a(285, Opcodes.ACC_NATIVE, 0);

    /* renamed from: f */
    public static final C10227a f31013f;

    /* renamed from: g */
    public static final C10227a f31014g;

    /* renamed from: h */
    public static final C10227a f31015h = f31010c;

    /* renamed from: i */
    private final int[] f31016i;

    /* renamed from: j */
    private final int[] f31017j;

    /* renamed from: k */
    private final C10228b f31018k;

    /* renamed from: l */
    private final C10228b f31019l;

    /* renamed from: m */
    private final int f31020m;

    /* renamed from: n */
    private final int f31021n;

    /* renamed from: o */
    private final int f31022o;

    static {
        C10227a aVar = new C10227a(301, Opcodes.ACC_NATIVE, 1);
        f31013f = aVar;
        f31014g = aVar;
    }

    public C10227a(int primitive, int size, int b) {
        this.f31021n = primitive;
        this.f31020m = size;
        this.f31022o = b;
        this.f31016i = new int[size];
        this.f31017j = new int[size];
        int x = 1;
        for (int i = 0; i < size; i++) {
            this.f31016i[i] = x;
            int i2 = x << 1;
            x = i2;
            if (i2 >= size) {
                x = (x ^ primitive) & (size - 1);
            }
        }
        for (int i3 = 0; i3 < size - 1; i3++) {
            this.f31017j[this.f31016i[i3]] = i3;
        }
        this.f31018k = new C10228b(this, new int[]{0});
        this.f31019l = new C10228b(this, new int[]{1});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C10228b mo33583b() {
        return this.f31018k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C10228b mo33584b(int degree, int coefficient) {
        if (degree < 0) {
            throw new IllegalArgumentException();
        } else if (coefficient == 0) {
            return this.f31018k;
        } else {
            int[] iArr = new int[(degree + 1)];
            int[] coefficients = iArr;
            iArr[0] = coefficient;
            return new C10228b(this, coefficients);
        }
    }

    /* renamed from: a */
    static int m33345a(int a, int b) {
        return a ^ b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo33581a(int a) {
        return this.f31016i[a];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo33585c(int a) {
        if (a != 0) {
            return this.f31017j[a];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo33582b(int a) {
        if (a != 0) {
            return this.f31016i[(this.f31020m - this.f31017j[a]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo33586c(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int[] iArr = this.f31016i;
        int[] iArr2 = this.f31017j;
        return iArr[(iArr2[a] + iArr2[b]) % (this.f31020m - 1)];
    }

    /* renamed from: a */
    public int mo33580a() {
        return this.f31022o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.f31021n));
        sb.append(',');
        sb.append(this.f31020m);
        sb.append(')');
        return sb.toString();
    }
}
