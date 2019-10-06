package com.google.zxing.p204f.p206b;

import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10208a;
import com.google.zxing.p204f.p205a.C10263a;
import com.google.zxing.p204f.p205a.C10265c;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.f.b.f */
/* compiled from: MatrixUtil */
final class C10273f {

    /* renamed from: a */
    private static final int[][] f31129a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b */
    private static final int[][] f31130b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c */
    private static final int[][] f31131c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, Opcodes.ISHR, -1}, new int[]{6, 30, 54, 78, 102, Opcodes.IAND, -1}, new int[]{6, 26, 52, 78, 104, Opcodes.IXOR, -1}, new int[]{6, 30, 56, 82, 108, Opcodes.I2F, -1}, new int[]{6, 34, 60, 86, 112, Opcodes.L2D, -1}, new int[]{6, 30, 58, 86, 114, Opcodes.D2I, -1}, new int[]{6, 34, 62, 90, 118, Opcodes.I2C, -1}, new int[]{6, 30, 54, 78, 102, Opcodes.IAND, 150}, new int[]{6, 24, 50, 76, 102, 128, Opcodes.IFNE}, new int[]{6, 28, 54, 80, 106, Opcodes.IINC, Opcodes.IFLE}, new int[]{6, 32, 58, 84, 110, Opcodes.L2I, Opcodes.IF_ICMPGE}, new int[]{6, 26, 54, 82, 110, Opcodes.L2D, Opcodes.IF_ACMPNE}, new int[]{6, 30, 58, 86, 114, Opcodes.D2I, Opcodes.TABLESWITCH}};

    /* renamed from: d */
    private static final int[][] f31132d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: a */
    static void m33501a(C10269b matrix) {
        matrix.mo33632a(-1);
    }

    /* renamed from: a */
    static void m33496a(C10208a dataBits, C10263a ecLevel, C10265c version, int maskPattern, C10269b matrix) throws WriterException {
        m33501a(matrix);
        m33500a(version, matrix);
        m33498a(ecLevel, maskPattern, matrix);
        m33503b(version, matrix);
        m33495a(dataBits, maskPattern, matrix);
    }

    /* renamed from: a */
    static void m33500a(C10265c version, C10269b matrix) throws WriterException {
        m33508c(matrix);
        m33504b(matrix);
        m33507c(version, matrix);
        m33510d(matrix);
    }

    /* renamed from: a */
    static void m33498a(C10263a ecLevel, int maskPattern, C10269b matrix) throws WriterException {
        C10208a typeInfoBits = new C10208a();
        m33497a(ecLevel, maskPattern, typeInfoBits);
        for (int i = 0; i < typeInfoBits.mo33519a(); i++) {
            boolean bit = typeInfoBits.mo33524a((typeInfoBits.mo33519a() - 1) - i);
            int[][] iArr = f31132d;
            matrix.mo33634a(iArr[i][0], iArr[i][1], bit);
            if (i < 8) {
                matrix.mo33634a((matrix.mo33637c() - i) - 1, 8, bit);
            } else {
                matrix.mo33634a(8, (matrix.mo33636b() - 7) + (i - 8), bit);
            }
        }
    }

    /* renamed from: b */
    static void m33503b(C10265c version, C10269b matrix) throws WriterException {
        if (version.mo33621c() >= 7) {
            C10208a versionInfoBits = new C10208a();
            m33499a(version, versionInfoBits);
            int bitIndex = 17;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    boolean bit = versionInfoBits.mo33524a(bitIndex);
                    bitIndex--;
                    matrix.mo33634a(i, (matrix.mo33636b() - 11) + j, bit);
                    matrix.mo33634a((matrix.mo33636b() - 11) + j, i, bit);
                }
            }
        }
    }

    /* renamed from: a */
    static void m33495a(C10208a dataBits, int maskPattern, C10269b matrix) throws WriterException {
        boolean bit;
        int bitIndex = 0;
        int direction = -1;
        int x = matrix.mo33637c() - 1;
        int y = matrix.mo33636b() - 1;
        while (x > 0) {
            if (x == 6) {
                x--;
            }
            while (y >= 0 && y < matrix.mo33636b()) {
                for (int i = 0; i < 2; i++) {
                    int xx = x - i;
                    if (m33505b((int) matrix.mo33631a(xx, y))) {
                        if (bitIndex < dataBits.mo33519a()) {
                            bit = dataBits.mo33524a(bitIndex);
                            bitIndex++;
                        } else {
                            bit = false;
                        }
                        if (maskPattern != -1 && C10272e.m33486a(maskPattern, xx, y)) {
                            bit = !bit;
                        }
                        matrix.mo33634a(xx, y, bit);
                    }
                }
                y += direction;
            }
            direction = -direction;
            y += direction;
            x -= 2;
        }
        if (bitIndex != dataBits.mo33519a()) {
            StringBuilder sb = new StringBuilder("Not all bits consumed: ");
            sb.append(bitIndex);
            sb.append('/');
            sb.append(dataBits.mo33519a());
            throw new WriterException(sb.toString());
        }
    }

    /* renamed from: a */
    static int m33492a(int value) {
        return 32 - Integer.numberOfLeadingZeros(value);
    }

    /* renamed from: a */
    static int m33493a(int value, int poly) {
        if (poly != 0) {
            int msbSetInPoly = m33492a(poly);
            int value2 = value << (msbSetInPoly - 1);
            while (m33492a(value2) >= msbSetInPoly) {
                value2 ^= poly << (m33492a(value2) - msbSetInPoly);
            }
            return value2;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    /* renamed from: a */
    static void m33497a(C10263a ecLevel, int maskPattern, C10208a bits) throws WriterException {
        if (C10274g.m33511a(maskPattern)) {
            int typeInfo = (ecLevel.mo33615e() << 3) | maskPattern;
            bits.mo33520a(typeInfo, 5);
            bits.mo33520a(m33493a(typeInfo, 1335), 10);
            C10208a aVar = new C10208a();
            C10208a maskBits = aVar;
            aVar.mo33520a(21522, 15);
            bits.mo33526b(maskBits);
            if (bits.mo33519a() != 15) {
                StringBuilder sb = new StringBuilder("should not happen but we got: ");
                sb.append(bits.mo33519a());
                throw new WriterException(sb.toString());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    /* renamed from: a */
    static void m33499a(C10265c version, C10208a bits) throws WriterException {
        bits.mo33520a(version.mo33621c(), 6);
        bits.mo33520a(m33493a(version.mo33621c(), 7973), 12);
        if (bits.mo33519a() != 18) {
            StringBuilder sb = new StringBuilder("should not happen but we got: ");
            sb.append(bits.mo33519a());
            throw new WriterException(sb.toString());
        }
    }

    /* renamed from: b */
    private static boolean m33505b(int value) {
        return value == -1;
    }

    /* renamed from: d */
    private static void m33510d(C10269b matrix) {
        for (int i = 8; i < matrix.mo33637c() - 8; i++) {
            int bit = (i + 1) % 2;
            if (m33505b((int) matrix.mo33631a(i, 6))) {
                matrix.mo33633a(i, 6, bit);
            }
            if (m33505b((int) matrix.mo33631a(6, i))) {
                matrix.mo33633a(6, i, bit);
            }
        }
    }

    /* renamed from: b */
    private static void m33504b(C10269b matrix) throws WriterException {
        if (matrix.mo33631a(8, matrix.mo33636b() - 8) != 0) {
            matrix.mo33633a(8, matrix.mo33636b() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    /* renamed from: a */
    private static void m33494a(int xStart, int yStart, C10269b matrix) throws WriterException {
        int x = 0;
        while (x < 8) {
            if (m33505b((int) matrix.mo33631a(xStart + x, yStart))) {
                matrix.mo33633a(xStart + x, yStart, 0);
                x++;
            } else {
                throw new WriterException();
            }
        }
    }

    /* renamed from: d */
    private static void m33509d(int xStart, int yStart, C10269b matrix) throws WriterException {
        int y = 0;
        while (y < 7) {
            if (m33505b((int) matrix.mo33631a(xStart, yStart + y))) {
                matrix.mo33633a(xStart, yStart + y, 0);
                y++;
            } else {
                throw new WriterException();
            }
        }
    }

    /* renamed from: b */
    private static void m33502b(int xStart, int yStart, C10269b matrix) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                matrix.mo33633a(xStart + x, yStart + y, f31130b[y][x]);
            }
        }
    }

    /* renamed from: c */
    private static void m33506c(int xStart, int yStart, C10269b matrix) {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                matrix.mo33633a(xStart + x, yStart + y, f31129a[y][x]);
            }
        }
    }

    /* renamed from: c */
    private static void m33508c(C10269b matrix) throws WriterException {
        int pdpWidth = f31129a[0].length;
        m33506c(0, 0, matrix);
        m33506c(matrix.mo33637c() - pdpWidth, 0, matrix);
        m33506c(0, matrix.mo33637c() - pdpWidth, matrix);
        m33494a(0, 7, matrix);
        m33494a(matrix.mo33637c() - 8, 7, matrix);
        m33494a(0, matrix.mo33637c() - 8, matrix);
        m33509d(7, 0, matrix);
        m33509d((matrix.mo33636b() - 7) - 1, 0, matrix);
        m33509d(7, matrix.mo33636b() - 7, matrix);
    }

    /* renamed from: c */
    private static void m33507c(C10265c version, C10269b matrix) {
        if (version.mo33621c() >= 2) {
            int index = version.mo33621c() - 1;
            int[][] iArr = f31131c;
            int[] coordinates = iArr[index];
            int numCoordinates = iArr[index].length;
            for (int i = 0; i < numCoordinates; i++) {
                for (int j = 0; j < numCoordinates; j++) {
                    int y = coordinates[i];
                    int i2 = coordinates[j];
                    int x = i2;
                    if (!(i2 == -1 || y == -1 || !m33505b((int) matrix.mo33631a(x, y)))) {
                        m33502b(x - 2, y - 2, matrix);
                    }
                }
            }
        }
    }
}
