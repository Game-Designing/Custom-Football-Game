package com.fasterxml.jackson.core.p134io;

import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fasterxml.jackson.core.io.CharTypes */
public final class CharTypes {

    /* renamed from: HB */
    private static final byte[] f12548HB;

    /* renamed from: HC */
    private static final char[] f12549HC = "0123456789ABCDEF".toCharArray();
    private static final int[] sHexValues = new int[128];
    private static final int[] sInputCodes;
    private static final int[] sInputCodesComment;
    private static final int[] sInputCodesJsNames;
    private static final int[] sInputCodesUTF8;
    private static final int[] sInputCodesUtf8JsNames;
    private static final int[] sInputCodesWS;
    private static final int[] sOutputEscapes128;

    static {
        int code;
        int len = f12549HC.length;
        f12548HB = new byte[len];
        for (int i = 0; i < len; i++) {
            f12548HB[i] = (byte) f12549HC[i];
        }
        int[] table = new int[Opcodes.ACC_NATIVE];
        for (int i2 = 0; i2 < 32; i2++) {
            table[i2] = -1;
        }
        table[34] = 1;
        table[92] = 1;
        sInputCodes = table;
        int[] table2 = sInputCodes;
        int[] table3 = new int[table2.length];
        System.arraycopy(table2, 0, table3, 0, table3.length);
        for (int c = 128; c < 256; c++) {
            if ((c & 224) == 192) {
                code = 2;
            } else if ((c & 240) == 224) {
                code = 3;
            } else if ((c & 248) == 240) {
                code = 4;
            } else {
                code = -1;
            }
            table3[c] = code;
        }
        sInputCodesUTF8 = table3;
        int[] table4 = new int[Opcodes.ACC_NATIVE];
        Arrays.fill(table4, -1);
        for (int i3 = 33; i3 < 256; i3++) {
            if (Character.isJavaIdentifierPart((char) i3)) {
                table4[i3] = 0;
            }
        }
        table4[64] = 0;
        table4[35] = 0;
        table4[42] = 0;
        table4[45] = 0;
        table4[43] = 0;
        sInputCodesJsNames = table4;
        int[] table5 = new int[Opcodes.ACC_NATIVE];
        System.arraycopy(sInputCodesJsNames, 0, table5, 0, table5.length);
        Arrays.fill(table5, 128, 128, 0);
        sInputCodesUtf8JsNames = table5;
        int[] table6 = new int[Opcodes.ACC_NATIVE];
        System.arraycopy(sInputCodesUTF8, 128, table6, 128, 128);
        Arrays.fill(table6, 0, 32, -1);
        table6[9] = 0;
        table6[10] = 10;
        table6[13] = 13;
        table6[42] = 42;
        sInputCodesComment = table6;
        int[] buf = new int[Opcodes.ACC_NATIVE];
        System.arraycopy(sInputCodesUTF8, 128, buf, 128, 128);
        Arrays.fill(buf, 0, 32, -1);
        buf[32] = 1;
        buf[9] = 1;
        buf[10] = 10;
        buf[13] = 13;
        buf[47] = 47;
        buf[35] = 35;
        sInputCodesWS = buf;
        int[] table7 = new int[128];
        for (int i4 = 0; i4 < 32; i4++) {
            table7[i4] = -1;
        }
        table7[34] = 34;
        table7[92] = 92;
        table7[8] = 98;
        table7[9] = 116;
        table7[12] = 102;
        table7[10] = 110;
        table7[13] = 114;
        sOutputEscapes128 = table7;
        Arrays.fill(sHexValues, -1);
        for (int i5 = 0; i5 < 10; i5++) {
            sHexValues[i5 + 48] = i5;
        }
        for (int i6 = 0; i6 < 6; i6++) {
            int[] iArr = sHexValues;
            iArr[i6 + 97] = i6 + 10;
            iArr[i6 + 65] = i6 + 10;
        }
    }

    public static int[] getInputCodeLatin1() {
        return sInputCodes;
    }

    public static int[] getInputCodeUtf8() {
        return sInputCodesUTF8;
    }

    public static int[] getInputCodeLatin1JsNames() {
        return sInputCodesJsNames;
    }

    public static int[] getInputCodeUtf8JsNames() {
        return sInputCodesUtf8JsNames;
    }

    public static int[] getInputCodeComment() {
        return sInputCodesComment;
    }

    public static int[] get7BitOutputEscapes() {
        return sOutputEscapes128;
    }

    public static int charToHex(int ch) {
        if (ch > 127) {
            return -1;
        }
        return sHexValues[ch];
    }

    public static void appendQuoted(StringBuilder sb, String content) {
        int[] escCodes = sOutputEscapes128;
        int escLen = escCodes.length;
        int len = content.length();
        for (int i = 0; i < len; i++) {
            char c = content.charAt(i);
            if (c >= escLen || escCodes[c] == 0) {
                sb.append(c);
            } else {
                sb.append('\\');
                int escCode = escCodes[c];
                if (escCode < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    char c2 = c;
                    sb.append(f12549HC[c2 >> 4]);
                    sb.append(f12549HC[c2 & 15]);
                } else {
                    sb.append((char) escCode);
                }
            }
        }
    }

    public static char[] copyHexChars() {
        return (char[]) f12549HC.clone();
    }

    public static byte[] copyHexBytes() {
        return (byte[]) f12548HB.clone();
    }
}
