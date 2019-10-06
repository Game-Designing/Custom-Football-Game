package com.google.zxing.p199c.p200a;

import com.google.zxing.C10207b;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.c.a.k */
/* compiled from: SymbolInfo */
public class C10223k {

    /* renamed from: a */
    static final C10223k[] f30994a;

    /* renamed from: b */
    private static C10223k[] f30995b;

    /* renamed from: c */
    private final boolean f30996c;

    /* renamed from: d */
    private final int f30997d;

    /* renamed from: e */
    private final int f30998e;

    /* renamed from: f */
    public final int f30999f;

    /* renamed from: g */
    public final int f31000g;

    /* renamed from: h */
    private final int f31001h;

    /* renamed from: i */
    private final int f31002i;

    /* renamed from: j */
    private final int f31003j;

    static {
        C10223k kVar = new C10223k(false, 3, 5, 8, 8, 1);
        C10223k kVar2 = new C10223k(false, 5, 7, 10, 10, 1);
        C10223k kVar3 = new C10223k(true, 5, 7, 16, 6, 1);
        C10223k kVar4 = new C10223k(false, 8, 10, 12, 12, 1);
        C10223k kVar5 = new C10223k(true, 10, 11, 14, 6, 2);
        C10223k kVar6 = new C10223k(false, 12, 12, 14, 14, 1);
        C10223k kVar7 = new C10223k(true, 16, 14, 24, 10, 1);
        C10223k kVar8 = new C10223k(false, 18, 14, 16, 16, 1);
        C10223k kVar9 = new C10223k(false, 22, 18, 18, 18, 1);
        C10223k kVar10 = new C10223k(true, 22, 18, 16, 10, 2);
        C10223k kVar11 = new C10223k(false, 30, 20, 20, 20, 1);
        C10223k kVar12 = new C10223k(true, 32, 24, 16, 14, 2);
        C10223k kVar13 = new C10223k(false, 36, 24, 22, 22, 1);
        C10223k kVar14 = new C10223k(false, 44, 28, 24, 24, 1);
        C10223k kVar15 = new C10223k(true, 49, 28, 22, 14, 2);
        C10223k kVar16 = new C10223k(false, 62, 36, 14, 14, 4);
        C10223k kVar17 = new C10223k(false, 86, 42, 16, 16, 4);
        C10223k kVar18 = new C10223k(false, 114, 48, 18, 18, 4);
        C10223k kVar19 = new C10223k(false, Opcodes.D2F, 56, 20, 20, 4);
        C10223k kVar20 = new C10223k(false, Opcodes.FRETURN, 68, 22, 22, 4);
        C10223k kVar21 = new C10223k(false, 204, 84, 24, 24, 4, 102, 42);
        C10223k kVar22 = new C10223k(false, 280, 112, 14, 14, 16, Opcodes.F2L, 56);
        C10223k kVar23 = new C10223k(false, 368, Opcodes.D2F, 16, 16, 16, 92, 36);
        C10223k kVar24 = new C10223k(false, 456, Opcodes.CHECKCAST, 18, 18, 16, 114, 48);
        C10223k kVar25 = new C10223k(false, 576, 224, 20, 20, 16, Opcodes.D2F, 56);
        C10223k kVar26 = new C10223k(false, 696, 272, 22, 22, 16, Opcodes.FRETURN, 68);
        C10223k kVar27 = new C10223k(false, 816, 336, 24, 24, 16, Opcodes.L2I, 56);
        C10223k kVar28 = new C10223k(false, 1050, 408, 18, 18, 36, Opcodes.DRETURN, 68);
        C10223k kVar29 = new C10223k(false, 1304, 496, 20, 20, 36, Opcodes.IF_ICMPGT, 62);
        C10223k[] kVarArr = {kVar, kVar2, kVar3, kVar4, kVar5, kVar6, kVar7, kVar8, kVar9, kVar10, kVar11, kVar12, kVar13, kVar14, kVar15, kVar16, kVar17, kVar18, kVar19, kVar20, kVar21, kVar22, kVar23, kVar24, kVar25, kVar26, kVar27, kVar28, kVar29, new C10216d()};
        f30994a = kVarArr;
        f30995b = kVarArr;
    }

    public C10223k(boolean rectangular, int dataCapacity, int errorCodewords, int matrixWidth, int matrixHeight, int dataRegions) {
        this(rectangular, dataCapacity, errorCodewords, matrixWidth, matrixHeight, dataRegions, dataCapacity, errorCodewords);
    }

    C10223k(boolean rectangular, int dataCapacity, int errorCodewords, int matrixWidth, int matrixHeight, int dataRegions, int rsBlockData, int rsBlockError) {
        this.f30996c = rectangular;
        this.f30997d = dataCapacity;
        this.f30998e = errorCodewords;
        this.f30999f = matrixWidth;
        this.f31000g = matrixHeight;
        this.f31001h = dataRegions;
        this.f31002i = rsBlockData;
        this.f31003j = rsBlockError;
    }

    /* renamed from: a */
    public static C10223k m33327a(int dataCodewords, C10224l shape, C10207b minSize, C10207b maxSize, boolean fail) {
        C10223k[] kVarArr;
        for (C10223k symbol : f30995b) {
            if ((shape != C10224l.FORCE_SQUARE || !symbol.f30996c) && ((shape != C10224l.FORCE_RECTANGLE || symbol.f30996c) && ((minSize == null || (symbol.mo33578g() >= minSize.mo33515b() && symbol.mo33577f() >= minSize.mo33514a())) && ((maxSize == null || (symbol.mo33578g() <= maxSize.mo33515b() && symbol.mo33577f() <= maxSize.mo33514a())) && dataCodewords <= symbol.f30997d)))) {
                return symbol;
            }
        }
        if (!fail) {
            return null;
        }
        StringBuilder sb = new StringBuilder("Can't find a symbol arrangement that matches the message. Data codewords: ");
        sb.append(dataCodewords);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: h */
    private int m33328h() {
        int i = this.f31001h;
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    /* renamed from: i */
    private int m33329i() {
        int i = this.f31001h;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    /* renamed from: e */
    public final int mo33576e() {
        return m33328h() * this.f30999f;
    }

    /* renamed from: d */
    public final int mo33575d() {
        return m33329i() * this.f31000g;
    }

    /* renamed from: g */
    public final int mo33578g() {
        return mo33576e() + (m33328h() << 1);
    }

    /* renamed from: f */
    public final int mo33577f() {
        return mo33575d() + (m33329i() << 1);
    }

    /* renamed from: c */
    public int mo33550c() {
        return this.f30997d / this.f31002i;
    }

    /* renamed from: a */
    public final int mo33572a() {
        return this.f30997d;
    }

    /* renamed from: b */
    public final int mo33573b() {
        return this.f30998e;
    }

    /* renamed from: a */
    public int mo33549a(int index) {
        return this.f31002i;
    }

    /* renamed from: b */
    public final int mo33574b(int index) {
        return this.f31003j;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f30996c ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f30999f);
        sb.append('x');
        sb.append(this.f31000g);
        sb.append(", symbol size ");
        sb.append(mo33578g());
        sb.append('x');
        sb.append(mo33577f());
        sb.append(", symbol data size ");
        sb.append(mo33576e());
        sb.append('x');
        sb.append(mo33575d());
        sb.append(", codewords ");
        sb.append(this.f30997d);
        sb.append('+');
        sb.append(this.f30998e);
        return sb.toString();
    }
}
