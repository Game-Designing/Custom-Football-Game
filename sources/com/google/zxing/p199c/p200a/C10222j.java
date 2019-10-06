package com.google.zxing.p199c.p200a;

import com.google.zxing.C10207b;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.c.a.j */
/* compiled from: HighLevelEncoder */
public final class C10222j {
    /* renamed from: a */
    private static char m33312a(char ch, int codewordPosition) {
        int i = ch + ((codewordPosition * Opcodes.FCMPL) % 253) + 1;
        int tempVariable = i;
        return (char) (i <= 254 ? tempVariable : tempVariable - 254);
    }

    /* renamed from: a */
    public static String m33317a(String msg, C10224l shape, C10207b minSize, C10207b maxSize) {
        C10219g[] encoders = {new C10213a(), new C10215c(), new C10225m(), new C10226n(), new C10218f(), new C10214b()};
        C10220h hVar = new C10220h(msg);
        C10220h context = hVar;
        hVar.mo33558a(shape);
        context.mo33557a(minSize, maxSize);
        String str = "\u001e\u0004";
        if (msg.startsWith("[)>\u001e05\u001d") && msg.endsWith(str)) {
            context.mo33555a(236);
            context.mo33556a(2);
            context.f30986f += 7;
        } else if (msg.startsWith("[)>\u001e06\u001d") && msg.endsWith(str)) {
            context.mo33555a(237);
            context.mo33556a(2);
            context.f30986f += 7;
        }
        int encodingMode = 0;
        while (context.mo33568h()) {
            encoders[encodingMode].mo33544a(context);
            if (context.mo33565e() >= 0) {
                encodingMode = context.mo33565e();
                context.mo33569i();
            }
        }
        int len = context.mo33554a();
        context.mo33571k();
        int capacity = context.mo33567g().mo33572a();
        if (!(len >= capacity || encodingMode == 0 || encodingMode == 5)) {
            context.mo33555a(254);
        }
        StringBuilder b = context.mo33560b();
        StringBuilder codewords = b;
        if (b.length() < capacity) {
            codewords.append(129);
        }
        while (codewords.length() < capacity) {
            codewords.append(m33312a(129, codewords.length() + 1));
        }
        return context.mo33560b().toString();
    }

    /* renamed from: a */
    static int m33314a(CharSequence msg, int startpos, int currentMode) {
        float[] charCounts;
        CharSequence charSequence = msg;
        int i = startpos;
        if (i >= msg.length()) {
            return currentMode;
        }
        int i2 = 6;
        if (currentMode == 0) {
            charCounts = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            charCounts = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            charCounts[currentMode] = 0.0f;
        }
        int charsProcessed = 0;
        while (i + charsProcessed != msg.length()) {
            char c = charSequence.charAt(i + charsProcessed);
            charsProcessed++;
            if (m33319b(c)) {
                charCounts[0] = charCounts[0] + 0.5f;
            } else if (m33320c(c)) {
                charCounts[0] = (float) Math.ceil((double) charCounts[0]);
                charCounts[0] = charCounts[0] + 2.0f;
            } else {
                charCounts[0] = (float) Math.ceil((double) charCounts[0]);
                charCounts[0] = charCounts[0] + 1.0f;
            }
            if (m33321d(c)) {
                charCounts[1] = charCounts[1] + 0.6666667f;
            } else if (m33320c(c)) {
                charCounts[1] = charCounts[1] + 2.6666667f;
            } else {
                charCounts[1] = charCounts[1] + 1.3333334f;
            }
            if (m33323f(c)) {
                charCounts[2] = charCounts[2] + 0.6666667f;
            } else if (m33320c(c)) {
                charCounts[2] = charCounts[2] + 2.6666667f;
            } else {
                charCounts[2] = charCounts[2] + 1.3333334f;
            }
            if (m33324g(c)) {
                charCounts[3] = charCounts[3] + 0.6666667f;
            } else if (m33320c(c)) {
                charCounts[3] = charCounts[3] + 4.3333335f;
            } else {
                charCounts[3] = charCounts[3] + 3.3333333f;
            }
            if (m33322e(c)) {
                charCounts[4] = charCounts[4] + 0.75f;
            } else if (m33320c(c)) {
                charCounts[4] = charCounts[4] + 4.25f;
            } else {
                charCounts[4] = charCounts[4] + 3.25f;
            }
            if (m33325h(c)) {
                charCounts[5] = charCounts[5] + 4.0f;
            } else {
                charCounts[5] = charCounts[5] + 1.0f;
            }
            if (charsProcessed >= 4) {
                int[] intCharCounts = new int[i2];
                byte[] mins = new byte[i2];
                m33316a(charCounts, intCharCounts, (int) MoPubClientPositioning.NO_REPEAT, mins);
                int minCount = m33315a(mins);
                if (intCharCounts[0] < intCharCounts[5] && intCharCounts[0] < intCharCounts[1] && intCharCounts[0] < intCharCounts[2] && intCharCounts[0] < intCharCounts[3] && intCharCounts[0] < intCharCounts[4]) {
                    return 0;
                }
                if (intCharCounts[5] < intCharCounts[0] || mins[1] + mins[2] + mins[3] + mins[4] == 0) {
                    return 5;
                }
                if (minCount == 1 && mins[4] > 0) {
                    return 4;
                }
                if (minCount == 1 && mins[2] > 0) {
                    return 2;
                }
                if (minCount == 1 && mins[3] > 0) {
                    return 3;
                }
                if (intCharCounts[1] + 1 < intCharCounts[0] && intCharCounts[1] + 1 < intCharCounts[5] && intCharCounts[1] + 1 < intCharCounts[4] && intCharCounts[1] + 1 < intCharCounts[2]) {
                    if (intCharCounts[1] < intCharCounts[3]) {
                        return 1;
                    }
                    if (intCharCounts[1] == intCharCounts[3]) {
                        int p = i + charsProcessed + 1;
                        while (p < msg.length()) {
                            char charAt = charSequence.charAt(p);
                            char tc = charAt;
                            if (!m33326i(charAt)) {
                                if (!m33324g(tc)) {
                                    break;
                                }
                                p++;
                            } else {
                                return 3;
                            }
                        }
                        return 1;
                    }
                }
            }
            i2 = 6;
        }
        byte[] mins2 = new byte[i2];
        int[] intCharCounts2 = new int[i2];
        int min = m33316a(charCounts, intCharCounts2, (int) MoPubClientPositioning.NO_REPEAT, mins2);
        int minCount2 = m33315a(mins2);
        if (intCharCounts2[0] == min) {
            return 0;
        }
        if (minCount2 == 1 && mins2[5] > 0) {
            return 5;
        }
        if (minCount2 == 1 && mins2[4] > 0) {
            return 4;
        }
        if (minCount2 != 1 || mins2[2] <= 0) {
            return (minCount2 != 1 || mins2[3] <= 0) ? 1 : 3;
        }
        return 2;
    }

    /* renamed from: a */
    private static int m33316a(float[] charCounts, int[] intCharCounts, int min, byte[] mins) {
        Arrays.fill(mins, 0);
        for (int i = 0; i < 6; i++) {
            intCharCounts[i] = (int) Math.ceil((double) charCounts[i]);
            int current = intCharCounts[i];
            if (min > current) {
                min = current;
                Arrays.fill(mins, 0);
            }
            if (min == current) {
                mins[i] = (byte) (mins[i] + 1);
            }
        }
        return min;
    }

    /* renamed from: a */
    private static int m33315a(byte[] mins) {
        int minCount = 0;
        for (int i = 0; i < 6; i++) {
            minCount += mins[i];
        }
        return minCount;
    }

    /* renamed from: b */
    static boolean m33319b(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /* renamed from: c */
    static boolean m33320c(char ch) {
        return ch >= 128 && ch <= 255;
    }

    /* renamed from: d */
    private static boolean m33321d(char ch) {
        return ch == ' ' || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z');
    }

    /* renamed from: f */
    private static boolean m33323f(char ch) {
        return ch == ' ' || (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z');
    }

    /* renamed from: g */
    private static boolean m33324g(char ch) {
        return m33326i(ch) || ch == ' ' || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z');
    }

    /* renamed from: i */
    private static boolean m33326i(char ch) {
        return ch == 13 || ch == '*' || ch == '>';
    }

    /* renamed from: e */
    private static boolean m33322e(char ch) {
        return ch >= ' ' && ch <= '^';
    }

    /* renamed from: h */
    private static boolean m33325h(char ch) {
        return false;
    }

    /* renamed from: a */
    public static int m33313a(CharSequence msg, int startpos) {
        int count = 0;
        int len = msg.length();
        int idx = startpos;
        if (startpos < len) {
            char ch = msg.charAt(startpos);
            while (m33319b(ch) && idx < len) {
                count++;
                idx++;
                if (idx < len) {
                    ch = msg.charAt(idx);
                }
            }
        }
        return count;
    }

    /* renamed from: a */
    static void m33318a(char c) {
        String hex = Integer.toHexString(c);
        StringBuilder sb = new StringBuilder();
        sb.append("0000".substring(0, 4 - hex.length()));
        sb.append(hex);
        String hex2 = sb.toString();
        StringBuilder sb2 = new StringBuilder("Illegal character: ");
        sb2.append(c);
        sb2.append(" (0x");
        sb2.append(hex2);
        sb2.append(')');
        throw new IllegalArgumentException(sb2.toString());
    }
}
