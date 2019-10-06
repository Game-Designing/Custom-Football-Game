package com.google.zxing.p199c.p200a;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.c.a.i */
/* compiled from: ErrorCorrection */
public final class C10221i {

    /* renamed from: a */
    private static final int[] f30990a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* renamed from: b */
    private static final int[][] f30991b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, Opcodes.D2F, Opcodes.I2F, 240, 92, 254}, new int[]{28, 24, Opcodes.INVOKEINTERFACE, Opcodes.IF_ACMPNE, 223, 248, 116, 255, 110, 61}, new int[]{Opcodes.DRETURN, Opcodes.L2D, 205, 12, Opcodes.MONITORENTER, Opcodes.JSR, 39, 245, 60, 97, Opcodes.ISHL}, new int[]{41, Opcodes.IFEQ, Opcodes.IFLE, 91, 61, 42, Opcodes.D2I, 213, 97, Opcodes.GETSTATIC, 100, 242}, new int[]{Opcodes.IFGE, 97, Opcodes.CHECKCAST, 252, 95, 9, Opcodes.IFGT, 119, Opcodes.L2D, 45, 18, Opcodes.INVOKEDYNAMIC, 83, Opcodes.INVOKEINTERFACE}, new int[]{83, Opcodes.MONITOREXIT, 100, 39, Opcodes.NEWARRAY, 75, 66, 61, 241, 213, 109, Opcodes.LOR, 94, 254, 225, 48, 90, Opcodes.NEWARRAY}, new int[]{15, Opcodes.MONITOREXIT, 244, 9, 233, 71, Opcodes.JSR, 2, Opcodes.NEWARRAY, Opcodes.IF_ICMPNE, Opcodes.IFEQ, Opcodes.I2B, 253, 79, 108, 82, 27, Opcodes.FRETURN, Opcodes.INVOKEDYNAMIC, Opcodes.IRETURN}, new int[]{52, Opcodes.ARRAYLENGTH, 88, 205, 109, 39, Opcodes.ARETURN, 21, Opcodes.IFLT, Opcodes.MULTIANEWARRAY, 251, 223, Opcodes.IFLT, 21, 5, Opcodes.IRETURN, 254, Opcodes.IUSHR, 12, Opcodes.PUTFIELD, Opcodes.INVOKESTATIC, 96, 50, Opcodes.INSTANCEOF}, new int[]{211, 231, 43, 97, 71, 96, 103, Opcodes.FRETURN, 37, Opcodes.DCMPL, Opcodes.TABLESWITCH, 53, 75, 34, 249, Opcodes.LSHL, 17, Opcodes.L2D, 110, 213, Opcodes.F2D, Opcodes.L2I, Opcodes.ISHL, Opcodes.DCMPL, 233, Opcodes.JSR, 93, 255}, new int[]{245, Opcodes.LAND, 242, 218, Opcodes.IXOR, 250, Opcodes.IF_ICMPGE, Opcodes.PUTFIELD, 102, Opcodes.ISHL, 84, Opcodes.PUTSTATIC, 220, 251, 80, Opcodes.INVOKEVIRTUAL, 229, 18, 2, 4, 68, 33, 101, Opcodes.L2F, 95, 119, 115, 44, Opcodes.DRETURN, Opcodes.INVOKESTATIC, 59, 25, 225, 98, 81, 112}, new int[]{77, Opcodes.INSTANCEOF, Opcodes.L2F, 31, 19, 38, 22, Opcodes.IFEQ, 247, 105, Opcodes.ISHR, 2, 245, Opcodes.I2L, 242, 8, Opcodes.DRETURN, 95, 100, 9, Opcodes.GOTO, 105, 214, 111, 57, Opcodes.LSHL, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, Opcodes.RETURN, 226, 5, 9, 5}, new int[]{245, Opcodes.IINC, Opcodes.IRETURN, 223, 96, 32, 117, 22, 238, Opcodes.I2L, 238, 231, 205, Opcodes.NEWARRAY, 237, 87, Opcodes.ATHROW, 106, 16, Opcodes.I2S, 118, 23, 37, 90, Opcodes.TABLESWITCH, 205, Opcodes.LXOR, 88, Opcodes.ISHL, 100, 66, Opcodes.L2D, Opcodes.INVOKEDYNAMIC, 240, 82, 44, Opcodes.ARETURN, 87, Opcodes.NEW, Opcodes.I2S, Opcodes.IF_ICMPNE, Opcodes.DRETURN, 69, 213, 92, 253, 225, 19}, new int[]{Opcodes.DRETURN, 9, 223, 238, 12, 17, 220, 208, 100, 29, Opcodes.DRETURN, Opcodes.TABLESWITCH, 230, Opcodes.CHECKCAST, 215, 235, 150, Opcodes.IF_ICMPEQ, 36, 223, 38, 200, Opcodes.IINC, 54, 228, Opcodes.I2C, 218, 234, 117, 203, 29, 232, Opcodes.D2F, 238, 22, 150, 201, 117, 62, 207, Opcodes.IF_ICMPLE, 13, Opcodes.L2F, 245, Opcodes.LAND, 67, 247, 28, Opcodes.IFLT, 43, 203, 107, 233, 53, Opcodes.D2L, 46}, new int[]{242, 93, Opcodes.RET, 50, Opcodes.D2F, 210, 39, 118, 202, Opcodes.NEWARRAY, 201, Opcodes.ANEWARRAY, Opcodes.D2L, 108, 196, 37, Opcodes.INVOKEINTERFACE, 112, Opcodes.I2F, 230, 245, 63, Opcodes.MULTIANEWARRAY, Opcodes.ARRAYLENGTH, 250, 106, Opcodes.INVOKEINTERFACE, 221, Opcodes.DRETURN, 64, 114, 71, Opcodes.IF_ICMPLT, 44, Opcodes.I2S, 6, 27, 218, 51, 63, 87, 10, 40, Opcodes.IXOR, Opcodes.NEWARRAY, 17, Opcodes.IF_ICMPGT, 31, Opcodes.ARETURN, Opcodes.TABLESWITCH, 4, 107, 232, 7, 94, Opcodes.IF_ACMPNE, 224, Opcodes.IUSHR, 86, 47, 11, 204}, new int[]{220, 228, Opcodes.LRETURN, 89, 251, Opcodes.FCMPL, Opcodes.IF_ICMPEQ, 56, 89, 33, Opcodes.I2S, 244, Opcodes.IFNE, 36, 73, Opcodes.LAND, 213, Opcodes.L2I, 248, Opcodes.GETFIELD, 234, Opcodes.MULTIANEWARRAY, Opcodes.IFLE, Opcodes.RETURN, 68, Opcodes.ISHR, 93, 213, 15, Opcodes.IF_ICMPNE, 227, 236, 66, Opcodes.F2I, Opcodes.IFEQ, Opcodes.INVOKEINTERFACE, 202, Opcodes.GOTO, Opcodes.PUTSTATIC, 25, 220, 232, 96, 210, 231, Opcodes.L2I, 223, 239, Opcodes.PUTFIELD, 241, 59, 52, Opcodes.IRETURN, 25, 49, 232, 211, Opcodes.ANEWARRAY, 64, 54, 108, Opcodes.IFEQ, Opcodes.IINC, 63, 96, 103, 82, Opcodes.INVOKEDYNAMIC}};

    /* renamed from: c */
    private static final int[] f30992c = new int[Opcodes.ACC_NATIVE];

    /* renamed from: d */
    private static final int[] f30993d = new int[255];

    static {
        int p = 1;
        for (int i = 0; i < 255; i++) {
            f30993d[i] = p;
            f30992c[p] = i;
            int i2 = p << 1;
            p = i2;
            if (i2 >= 256) {
                p ^= 301;
            }
        }
    }

    /* renamed from: a */
    public static String m33311a(String codewords, C10223k symbolInfo) {
        if (codewords.length() == symbolInfo.mo33572a()) {
            StringBuilder sb = new StringBuilder(symbolInfo.mo33572a() + symbolInfo.mo33573b());
            StringBuilder sb2 = sb;
            sb.append(codewords);
            int c = symbolInfo.mo33550c();
            int blockCount = c;
            if (c == 1) {
                sb2.append(m33309a((CharSequence) codewords, symbolInfo.mo33573b()));
            } else {
                sb2.setLength(sb2.capacity());
                int[] dataSizes = new int[blockCount];
                int[] errorSizes = new int[blockCount];
                int[] startPos = new int[blockCount];
                for (int i = 0; i < blockCount; i++) {
                    dataSizes[i] = symbolInfo.mo33549a(i + 1);
                    errorSizes[i] = symbolInfo.mo33574b(i + 1);
                    startPos[i] = 0;
                    if (i > 0) {
                        startPos[i] = startPos[i - 1] + dataSizes[i];
                    }
                }
                for (int block = 0; block < blockCount; block++) {
                    StringBuilder temp = new StringBuilder(dataSizes[block]);
                    for (int d = block; d < symbolInfo.mo33572a(); d += blockCount) {
                        temp.append(codewords.charAt(d));
                    }
                    String ecc = m33309a((CharSequence) temp.toString(), errorSizes[block]);
                    int pos = 0;
                    int e = block;
                    while (e < errorSizes[block] * blockCount) {
                        int pos2 = pos + 1;
                        sb2.setCharAt(symbolInfo.mo33572a() + e, ecc.charAt(pos));
                        e += blockCount;
                        pos = pos2;
                    }
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    /* renamed from: a */
    private static String m33309a(CharSequence codewords, int numECWords) {
        return m33310a(codewords, 0, codewords.length(), numECWords);
    }

    /* renamed from: a */
    private static String m33310a(CharSequence codewords, int start, int len, int numECWords) {
        int table = -1;
        int i = 0;
        while (true) {
            int[] iArr = f30990a;
            if (i >= iArr.length) {
                break;
            } else if (iArr[i] == numECWords) {
                table = i;
                break;
            } else {
                i++;
            }
        }
        if (table >= 0) {
            int[] poly = f30991b[table];
            char[] ecc = new char[numECWords];
            for (int i2 = 0; i2 < numECWords; i2++) {
                ecc[i2] = 0;
            }
            for (int i3 = start; i3 < start + len; i3++) {
                int m = ecc[numECWords - 1] ^ codewords.charAt(i3);
                for (int k = numECWords - 1; k > 0; k--) {
                    if (m == 0 || poly[k] == 0) {
                        ecc[k] = ecc[k - 1];
                    } else {
                        char c = ecc[k - 1];
                        int[] iArr2 = f30993d;
                        int[] iArr3 = f30992c;
                        ecc[k] = (char) (c ^ iArr2[(iArr3[m] + iArr3[poly[k]]) % 255]);
                    }
                }
                if (m == 0 || poly[0] == 0) {
                    ecc[0] = 0;
                } else {
                    int[] iArr4 = f30993d;
                    int[] iArr5 = f30992c;
                    ecc[0] = (char) iArr4[(iArr5[m] + iArr5[poly[0]]) % 255];
                }
            }
            char[] eccReversed = new char[numECWords];
            for (int i4 = 0; i4 < numECWords; i4++) {
                eccReversed[i4] = ecc[(numECWords - i4) - 1];
            }
            return String.valueOf(eccReversed);
        }
        StringBuilder sb = new StringBuilder("Illegal number of error correction codewords specified: ");
        sb.append(numECWords);
        throw new IllegalArgumentException(sb.toString());
    }
}
