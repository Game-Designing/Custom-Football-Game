package com.google.zxing.p204f.p205a;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.f.a.c */
/* compiled from: Version */
public final class C10265c {

    /* renamed from: a */
    private static final int[] f31112a = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: b */
    private static final C10265c[] f31113b = m33442d();

    /* renamed from: c */
    private final int f31114c;

    /* renamed from: d */
    private final int[] f31115d;

    /* renamed from: e */
    private final C10267b[] f31116e;

    /* renamed from: f */
    private final int f31117f;

    /* renamed from: com.google.zxing.f.a.c$a */
    /* compiled from: Version */
    public static final class C10266a {

        /* renamed from: a */
        private final int f31118a;

        /* renamed from: b */
        private final int f31119b;

        C10266a(int count, int dataCodewords) {
            this.f31118a = count;
            this.f31119b = dataCodewords;
        }

        /* renamed from: a */
        public int mo33623a() {
            return this.f31118a;
        }

        /* renamed from: b */
        public int mo33624b() {
            return this.f31119b;
        }
    }

    /* renamed from: com.google.zxing.f.a.c$b */
    /* compiled from: Version */
    public static final class C10267b {

        /* renamed from: a */
        private final int f31120a;

        /* renamed from: b */
        private final C10266a[] f31121b;

        C10267b(int ecCodewordsPerBlock, C10266a... ecBlocks) {
            this.f31120a = ecCodewordsPerBlock;
            this.f31121b = ecBlocks;
        }

        /* renamed from: b */
        public int mo33626b() {
            return this.f31120a;
        }

        /* renamed from: c */
        public int mo33627c() {
            int total = 0;
            for (C10266a ecBlock : this.f31121b) {
                total += ecBlock.mo33623a();
            }
            return total;
        }

        /* renamed from: d */
        public int mo33628d() {
            return this.f31120a * mo33627c();
        }

        /* renamed from: a */
        public C10266a[] mo33625a() {
            return this.f31121b;
        }
    }

    private C10265c(int versionNumber, int[] alignmentPatternCenters, C10267b... ecBlocks) {
        this.f31114c = versionNumber;
        this.f31115d = alignmentPatternCenters;
        this.f31116e = ecBlocks;
        int total = 0;
        int ecCodewords = ecBlocks[0].mo33626b();
        for (C10266a ecBlock : ecBlocks[0].mo33625a()) {
            total += ecBlock.mo33623a() * (ecBlock.mo33624b() + ecCodewords);
        }
        this.f31117f = total;
    }

    /* renamed from: c */
    public int mo33621c() {
        return this.f31114c;
    }

    /* renamed from: b */
    public int mo33620b() {
        return this.f31117f;
    }

    /* renamed from: a */
    public int mo33618a() {
        return (this.f31114c * 4) + 17;
    }

    /* renamed from: a */
    public C10267b mo33619a(C10263a ecLevel) {
        return this.f31116e[ecLevel.ordinal()];
    }

    /* renamed from: a */
    public static C10265c m33441a(int versionNumber) {
        if (versionNumber > 0 && versionNumber <= 40) {
            return f31113b[versionNumber - 1];
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return String.valueOf(this.f31114c);
    }

    /* renamed from: d */
    private static C10265c[] m33442d() {
        return new C10265c[]{new C10265c(1, new int[0], new C10267b(7, new C10266a(1, 19)), new C10267b(10, new C10266a(1, 16)), new C10267b(13, new C10266a(1, 13)), new C10267b(17, new C10266a(1, 9))), new C10265c(2, new int[]{6, 18}, new C10267b(10, new C10266a(1, 34)), new C10267b(16, new C10266a(1, 28)), new C10267b(22, new C10266a(1, 22)), new C10267b(28, new C10266a(1, 16))), new C10265c(3, new int[]{6, 22}, new C10267b(15, new C10266a(1, 55)), new C10267b(26, new C10266a(1, 44)), new C10267b(18, new C10266a(2, 17)), new C10267b(22, new C10266a(2, 13))), new C10265c(4, new int[]{6, 26}, new C10267b(20, new C10266a(1, 80)), new C10267b(18, new C10266a(2, 32)), new C10267b(26, new C10266a(2, 24)), new C10267b(16, new C10266a(4, 9))), new C10265c(5, new int[]{6, 30}, new C10267b(26, new C10266a(1, 108)), new C10267b(24, new C10266a(2, 43)), new C10267b(18, new C10266a(2, 15), new C10266a(2, 16)), new C10267b(22, new C10266a(2, 11), new C10266a(2, 12))), new C10265c(6, new int[]{6, 34}, new C10267b(18, new C10266a(2, 68)), new C10267b(16, new C10266a(4, 27)), new C10267b(24, new C10266a(4, 19)), new C10267b(28, new C10266a(4, 15))), new C10265c(7, new int[]{6, 22, 38}, new C10267b(20, new C10266a(2, 78)), new C10267b(18, new C10266a(4, 31)), new C10267b(18, new C10266a(2, 14), new C10266a(4, 15)), new C10267b(26, new C10266a(4, 13), new C10266a(1, 14))), new C10265c(8, new int[]{6, 24, 42}, new C10267b(24, new C10266a(2, 97)), new C10267b(22, new C10266a(2, 38), new C10266a(2, 39)), new C10267b(22, new C10266a(4, 18), new C10266a(2, 19)), new C10267b(26, new C10266a(4, 14), new C10266a(2, 15))), new C10265c(9, new int[]{6, 26, 46}, new C10267b(30, new C10266a(2, 116)), new C10267b(22, new C10266a(3, 36), new C10266a(2, 37)), new C10267b(20, new C10266a(4, 16), new C10266a(4, 17)), new C10267b(24, new C10266a(4, 12), new C10266a(4, 13))), new C10265c(10, new int[]{6, 28, 50}, new C10267b(18, new C10266a(2, 68), new C10266a(2, 69)), new C10267b(26, new C10266a(4, 43), new C10266a(1, 44)), new C10267b(24, new C10266a(6, 19), new C10266a(2, 20)), new C10267b(28, new C10266a(6, 15), new C10266a(2, 16))), new C10265c(11, new int[]{6, 30, 54}, new C10267b(20, new C10266a(4, 81)), new C10267b(30, new C10266a(1, 50), new C10266a(4, 51)), new C10267b(28, new C10266a(4, 22), new C10266a(4, 23)), new C10267b(24, new C10266a(3, 12), new C10266a(8, 13))), new C10265c(12, new int[]{6, 32, 58}, new C10267b(24, new C10266a(2, 92), new C10266a(2, 93)), new C10267b(22, new C10266a(6, 36), new C10266a(2, 37)), new C10267b(26, new C10266a(4, 20), new C10266a(6, 21)), new C10267b(28, new C10266a(7, 14), new C10266a(4, 15))), new C10265c(13, new int[]{6, 34, 62}, new C10267b(26, new C10266a(4, 107)), new C10267b(22, new C10266a(8, 37), new C10266a(1, 38)), new C10267b(24, new C10266a(8, 20), new C10266a(4, 21)), new C10267b(22, new C10266a(12, 11), new C10266a(4, 12))), new C10265c(14, new int[]{6, 26, 46, 66}, new C10267b(30, new C10266a(3, 115), new C10266a(1, 116)), new C10267b(24, new C10266a(4, 40), new C10266a(5, 41)), new C10267b(20, new C10266a(11, 16), new C10266a(5, 17)), new C10267b(24, new C10266a(11, 12), new C10266a(5, 13))), new C10265c(15, new int[]{6, 26, 48, 70}, new C10267b(22, new C10266a(5, 87), new C10266a(1, 88)), new C10267b(24, new C10266a(5, 41), new C10266a(5, 42)), new C10267b(30, new C10266a(5, 24), new C10266a(7, 25)), new C10267b(24, new C10266a(11, 12), new C10266a(7, 13))), new C10265c(16, new int[]{6, 26, 50, 74}, new C10267b(24, new C10266a(5, 98), new C10266a(1, 99)), new C10267b(28, new C10266a(7, 45), new C10266a(3, 46)), new C10267b(24, new C10266a(15, 19), new C10266a(2, 20)), new C10267b(30, new C10266a(3, 15), new C10266a(13, 16))), new C10265c(17, new int[]{6, 30, 54, 78}, new C10267b(28, new C10266a(1, 107), new C10266a(5, 108)), new C10267b(28, new C10266a(10, 46), new C10266a(1, 47)), new C10267b(28, new C10266a(1, 22), new C10266a(15, 23)), new C10267b(28, new C10266a(2, 14), new C10266a(17, 15))), new C10265c(18, new int[]{6, 30, 56, 82}, new C10267b(30, new C10266a(5, Opcodes.ISHL), new C10266a(1, Opcodes.LSHL)), new C10267b(26, new C10266a(9, 43), new C10266a(4, 44)), new C10267b(28, new C10266a(17, 22), new C10266a(1, 23)), new C10267b(28, new C10266a(2, 14), new C10266a(19, 15))), new C10265c(19, new int[]{6, 30, 58, 86}, new C10267b(28, new C10266a(3, 113), new C10266a(4, 114)), new C10267b(26, new C10266a(3, 44), new C10266a(11, 45)), new C10267b(26, new C10266a(17, 21), new C10266a(4, 22)), new C10267b(26, new C10266a(9, 13), new C10266a(16, 14))), new C10265c(20, new int[]{6, 34, 62, 90}, new C10267b(28, new C10266a(3, 107), new C10266a(5, 108)), new C10267b(26, new C10266a(3, 41), new C10266a(13, 42)), new C10267b(30, new C10266a(15, 24), new C10266a(5, 25)), new C10267b(28, new C10266a(15, 15), new C10266a(10, 16))), new C10265c(21, new int[]{6, 28, 50, 72, 94}, new C10267b(28, new C10266a(4, 116), new C10266a(4, 117)), new C10267b(26, new C10266a(17, 42)), new C10267b(28, new C10266a(17, 22), new C10266a(6, 23)), new C10267b(30, new C10266a(19, 16), new C10266a(6, 17))), new C10265c(22, new int[]{6, 26, 50, 74, 98}, new C10267b(28, new C10266a(2, 111), new C10266a(7, 112)), new C10267b(28, new C10266a(17, 46)), new C10267b(30, new C10266a(7, 24), new C10266a(16, 25)), new C10267b(24, new C10266a(34, 13))), new C10265c(23, new int[]{6, 30, 54, 78, 102}, new C10267b(30, new C10266a(4, Opcodes.LSHL), new C10266a(5, Opcodes.ISHR)), new C10267b(28, new C10266a(4, 47), new C10266a(14, 48)), new C10267b(30, new C10266a(11, 24), new C10266a(14, 25)), new C10267b(30, new C10266a(16, 15), new C10266a(14, 16))), new C10265c(24, new int[]{6, 28, 54, 80, 106}, new C10267b(30, new C10266a(6, 117), new C10266a(4, 118)), new C10267b(28, new C10266a(6, 45), new C10266a(14, 46)), new C10267b(30, new C10266a(11, 24), new C10266a(16, 25)), new C10267b(30, new C10266a(30, 16), new C10266a(2, 17))), new C10265c(25, new int[]{6, 32, 58, 84, 110}, new C10267b(26, new C10266a(8, 106), new C10266a(4, 107)), new C10267b(28, new C10266a(8, 47), new C10266a(13, 48)), new C10267b(30, new C10266a(7, 24), new C10266a(22, 25)), new C10267b(30, new C10266a(22, 15), new C10266a(13, 16))), new C10265c(26, new int[]{6, 30, 58, 86, 114}, new C10267b(28, new C10266a(10, 114), new C10266a(2, 115)), new C10267b(28, new C10266a(19, 46), new C10266a(4, 47)), new C10267b(28, new C10266a(28, 22), new C10266a(6, 23)), new C10267b(30, new C10266a(33, 16), new C10266a(4, 17))), new C10265c(27, new int[]{6, 34, 62, 90, 118}, new C10267b(30, new C10266a(8, Opcodes.ISHR), new C10266a(4, 123)), new C10267b(28, new C10266a(22, 45), new C10266a(3, 46)), new C10267b(30, new C10266a(8, 23), new C10266a(26, 24)), new C10267b(30, new C10266a(12, 15), new C10266a(28, 16))), new C10265c(28, new int[]{6, 26, 50, 74, 98, Opcodes.ISHR}, new C10267b(30, new C10266a(3, 117), new C10266a(10, 118)), new C10267b(28, new C10266a(3, 45), new C10266a(23, 46)), new C10267b(30, new C10266a(4, 24), new C10266a(31, 25)), new C10267b(30, new C10266a(11, 15), new C10266a(31, 16))), new C10265c(29, new int[]{6, 30, 54, 78, 102, Opcodes.IAND}, new C10267b(30, new C10266a(7, 116), new C10266a(7, 117)), new C10267b(28, new C10266a(21, 45), new C10266a(7, 46)), new C10267b(30, new C10266a(1, 23), new C10266a(37, 24)), new C10267b(30, new C10266a(19, 15), new C10266a(26, 16))), new C10265c(30, new int[]{6, 26, 52, 78, 104, Opcodes.IXOR}, new C10267b(30, new C10266a(5, 115), new C10266a(10, 116)), new C10267b(28, new C10266a(19, 47), new C10266a(10, 48)), new C10267b(30, new C10266a(15, 24), new C10266a(25, 25)), new C10267b(30, new C10266a(23, 15), new C10266a(25, 16))), new C10265c(31, new int[]{6, 30, 56, 82, 108, Opcodes.I2F}, new C10267b(30, new C10266a(13, 115), new C10266a(3, 116)), new C10267b(28, new C10266a(2, 46), new C10266a(29, 47)), new C10267b(30, new C10266a(42, 24), new C10266a(1, 25)), new C10267b(30, new C10266a(23, 15), new C10266a(28, 16))), new C10265c(32, new int[]{6, 34, 60, 86, 112, Opcodes.L2D}, new C10267b(30, new C10266a(17, 115)), new C10267b(28, new C10266a(10, 46), new C10266a(23, 47)), new C10267b(30, new C10266a(10, 24), new C10266a(35, 25)), new C10267b(30, new C10266a(19, 15), new C10266a(35, 16))), new C10265c(33, new int[]{6, 30, 58, 86, 114, Opcodes.D2I}, new C10267b(30, new C10266a(17, 115), new C10266a(1, 116)), new C10267b(28, new C10266a(14, 46), new C10266a(21, 47)), new C10267b(30, new C10266a(29, 24), new C10266a(19, 25)), new C10267b(30, new C10266a(11, 15), new C10266a(46, 16))), new C10265c(34, new int[]{6, 34, 62, 90, 118, Opcodes.I2C}, new C10267b(30, new C10266a(13, 115), new C10266a(6, 116)), new C10267b(28, new C10266a(14, 46), new C10266a(23, 47)), new C10267b(30, new C10266a(44, 24), new C10266a(7, 25)), new C10267b(30, new C10266a(59, 16), new C10266a(1, 17))), new C10265c(35, new int[]{6, 30, 54, 78, 102, Opcodes.IAND, 150}, new C10267b(30, new C10266a(12, Opcodes.LSHL), new C10266a(7, Opcodes.ISHR)), new C10267b(28, new C10266a(12, 47), new C10266a(26, 48)), new C10267b(30, new C10266a(39, 24), new C10266a(14, 25)), new C10267b(30, new C10266a(22, 15), new C10266a(41, 16))), new C10265c(36, new int[]{6, 24, 50, 76, 102, 128, Opcodes.IFNE}, new C10267b(30, new C10266a(6, Opcodes.LSHL), new C10266a(14, Opcodes.ISHR)), new C10267b(28, new C10266a(6, 47), new C10266a(34, 48)), new C10267b(30, new C10266a(46, 24), new C10266a(10, 25)), new C10267b(30, new C10266a(2, 15), new C10266a(64, 16))), new C10265c(37, new int[]{6, 28, 54, 80, 106, Opcodes.IINC, Opcodes.IFLE}, new C10267b(30, new C10266a(17, Opcodes.ISHR), new C10266a(4, 123)), new C10267b(28, new C10266a(29, 46), new C10266a(14, 47)), new C10267b(30, new C10266a(49, 24), new C10266a(10, 25)), new C10267b(30, new C10266a(24, 15), new C10266a(46, 16))), new C10265c(38, new int[]{6, 32, 58, 84, 110, Opcodes.L2I, Opcodes.IF_ICMPGE}, new C10267b(30, new C10266a(4, Opcodes.ISHR), new C10266a(18, 123)), new C10267b(28, new C10266a(13, 46), new C10266a(32, 47)), new C10267b(30, new C10266a(48, 24), new C10266a(14, 25)), new C10267b(30, new C10266a(42, 15), new C10266a(32, 16))), new C10265c(39, new int[]{6, 26, 54, 82, 110, Opcodes.L2D, Opcodes.IF_ACMPNE}, new C10267b(30, new C10266a(20, 117), new C10266a(4, 118)), new C10267b(28, new C10266a(40, 47), new C10266a(7, 48)), new C10267b(30, new C10266a(43, 24), new C10266a(22, 25)), new C10267b(30, new C10266a(10, 15), new C10266a(67, 16))), new C10265c(40, new int[]{6, 30, 58, 86, 114, Opcodes.D2I, Opcodes.TABLESWITCH}, new C10267b(30, new C10266a(19, 118), new C10266a(6, 119)), new C10267b(28, new C10266a(18, 47), new C10266a(31, 48)), new C10267b(30, new C10266a(34, 24), new C10266a(34, 25)), new C10267b(30, new C10266a(20, 15), new C10266a(61, 16)))};
    }
}
