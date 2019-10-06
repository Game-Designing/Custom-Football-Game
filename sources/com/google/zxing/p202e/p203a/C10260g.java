package com.google.zxing.p202e.p203a;

import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10210c;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.RemoteControlWriter;

/* renamed from: com.google.zxing.e.a.g */
/* compiled from: PDF417HighLevelEncoder */
final class C10260g {

    /* renamed from: a */
    private static final byte[] f31087a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, RemoteControlWriter.BLOCK_CMDOK, 0, 0, 0};

    /* renamed from: b */
    private static final byte[] f31088b = {59, 60, 62, RemoteControlWriter.BLOCK_CMDDUMP, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* renamed from: c */
    private static final byte[] f31089c = new byte[128];

    /* renamed from: d */
    private static final byte[] f31090d = new byte[128];

    /* renamed from: e */
    private static final Charset f31091e = Charset.forName("ISO-8859-1");

    static {
        Arrays.fill(f31089c, -1);
        int i = 0;
        while (true) {
            byte[] bArr = f31087a;
            if (i >= bArr.length) {
                break;
            }
            byte b = bArr[i];
            byte b2 = b;
            if (b > 0) {
                f31089c[b2] = (byte) i;
            }
            i++;
        }
        Arrays.fill(f31090d, -1);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f31088b;
            if (i2 < bArr2.length) {
                byte b3 = bArr2[i2];
                byte b4 = b3;
                if (b3 > 0) {
                    f31090d[b4] = (byte) i2;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    static String m33425a(String msg, C10256c compaction, Charset encoding) throws WriterException {
        String str = msg;
        C10256c cVar = compaction;
        Charset encoding2 = encoding;
        StringBuilder sb = new StringBuilder(msg.length());
        if (encoding2 == null) {
            encoding2 = f31091e;
        } else if (!f31091e.equals(encoding2)) {
            C10210c a = C10210c.m33254a(encoding.name());
            C10210c eci = a;
            if (a != null) {
                m33426a(eci.mo33542e(), sb);
            }
        }
        int len = msg.length();
        int p = 0;
        int textSubMode = 0;
        if (cVar == C10256c.TEXT) {
            m33423a((CharSequence) str, 0, len, sb, 0);
        } else if (cVar == C10256c.BYTE) {
            byte[] bytes = str.getBytes(encoding2);
            m33428a(bytes, 0, bytes.length, 1, sb);
        } else if (cVar == C10256c.NUMERIC) {
            sb.append(902);
            m33427a(str, 0, len, sb);
        } else {
            int encodingMode = 0;
            while (p < len) {
                int a2 = m33422a((CharSequence) str, p);
                int n = a2;
                if (a2 >= 13) {
                    sb.append(902);
                    encodingMode = 2;
                    textSubMode = 0;
                    m33427a(str, p, n, sb);
                    p += n;
                } else {
                    int b = m33430b(str, p);
                    int t = b;
                    if (b < 5) {
                        if (n != len) {
                            int a3 = m33424a(str, p, encoding2);
                            int b2 = a3;
                            if (a3 == 0) {
                                b2 = 1;
                            }
                            byte[] bytes2 = str.substring(p, p + b2).getBytes(encoding2);
                            byte[] bytes3 = bytes2;
                            if (bytes2.length == 1 && encodingMode == 0) {
                                m33428a(bytes3, 0, 1, 0, sb);
                            } else {
                                m33428a(bytes3, 0, bytes3.length, encodingMode, sb);
                                encodingMode = 1;
                                textSubMode = 0;
                            }
                            p += b2;
                        }
                    }
                    if (encodingMode != 0) {
                        sb.append(900);
                        encodingMode = 0;
                        textSubMode = 0;
                    }
                    textSubMode = m33423a((CharSequence) str, p, t, sb, textSubMode);
                    p += t;
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static int m33423a(CharSequence msg, int startpos, int count, StringBuilder sb, int initialSubmode) {
        CharSequence charSequence = msg;
        int i = count;
        StringBuilder sb2 = sb;
        StringBuilder tmp = new StringBuilder(i);
        int submode = initialSubmode;
        int idx = 0;
        while (true) {
            char ch = charSequence.charAt(startpos + idx);
            if (submode != 0) {
                if (submode != 1) {
                    if (submode != 2) {
                        if (m33434e(ch)) {
                            tmp.append((char) f31090d[ch]);
                        } else {
                            submode = 0;
                            tmp.append(29);
                        }
                    } else if (m33433d(ch)) {
                        tmp.append((char) f31089c[ch]);
                    } else if (m33431b(ch)) {
                        submode = 0;
                        tmp.append(28);
                    } else if (m33429a(ch)) {
                        submode = 1;
                        tmp.append(27);
                    } else if (startpos + idx + 1 >= i || !m33434e(charSequence.charAt(startpos + idx + 1))) {
                        tmp.append(29);
                        tmp.append((char) f31090d[ch]);
                    } else {
                        submode = 3;
                        tmp.append(25);
                    }
                } else if (m33429a(ch)) {
                    if (ch == ' ') {
                        tmp.append(26);
                    } else {
                        tmp.append((char) (ch - 'a'));
                    }
                } else if (m33431b(ch)) {
                    tmp.append(27);
                    tmp.append((char) (ch - 'A'));
                } else if (m33433d(ch)) {
                    submode = 2;
                    tmp.append(28);
                } else {
                    tmp.append(29);
                    tmp.append((char) f31090d[ch]);
                }
            } else if (m33431b(ch)) {
                if (ch == ' ') {
                    tmp.append(26);
                } else {
                    tmp.append((char) (ch - 'A'));
                }
            } else if (m33429a(ch)) {
                submode = 1;
                tmp.append(27);
            } else if (m33433d(ch)) {
                submode = 2;
                tmp.append(28);
            } else {
                tmp.append(29);
                tmp.append((char) f31090d[ch]);
            }
            idx++;
            if (idx >= i) {
                break;
            }
        }
        char h = 0;
        int len = tmp.length();
        for (int i2 = 0; i2 < len; i2++) {
            if (i2 % 2 != 0) {
                h = (char) ((h * 30) + tmp.charAt(i2));
                sb2.append(h);
            } else {
                h = tmp.charAt(i2);
            }
        }
        if (len % 2 != 0) {
            sb2.append((char) ((h * 30) + 29));
        }
        return submode;
    }

    /* renamed from: a */
    private static void m33428a(byte[] bytes, int startpos, int count, int startmode, StringBuilder sb) {
        if (count == 1 && startmode == 0) {
            sb.append(913);
        } else if (count % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        int idx = startpos;
        if (count >= 6) {
            char[] chars = new char[5];
            while ((startpos + count) - idx >= 6) {
                long t = 0;
                for (int i = 0; i < 6; i++) {
                    t = (t << 8) + ((long) (bytes[idx + i] & 255));
                }
                for (int i2 = 0; i2 < 5; i2++) {
                    chars[i2] = (char) ((int) (t % 900));
                    t /= 900;
                }
                for (int i3 = 4; i3 >= 0; i3--) {
                    sb.append(chars[i3]);
                }
                idx += 6;
            }
        }
        for (int i4 = idx; i4 < startpos + count; i4++) {
            sb.append((char) (bytes[i4] & 255));
        }
    }

    /* renamed from: a */
    private static void m33427a(String msg, int startpos, int count, StringBuilder sb) {
        BigInteger divide;
        int idx = 0;
        StringBuilder tmp = new StringBuilder((count / 3) + 1);
        BigInteger num900 = BigInteger.valueOf(900);
        BigInteger num0 = BigInteger.valueOf(0);
        while (idx < count) {
            tmp.setLength(0);
            int len = Math.min(44, count - idx);
            StringBuilder sb2 = new StringBuilder("1");
            sb2.append(msg.substring(startpos + idx, startpos + idx + len));
            BigInteger bigint = new BigInteger(sb2.toString());
            do {
                tmp.append((char) bigint.mod(num900).intValue());
                divide = bigint.divide(num900);
                bigint = divide;
            } while (!divide.equals(num0));
            for (int i = tmp.length() - 1; i >= 0; i--) {
                sb.append(tmp.charAt(i));
            }
            idx += len;
        }
    }

    /* renamed from: c */
    private static boolean m33432c(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /* renamed from: b */
    private static boolean m33431b(char ch) {
        return ch == ' ' || (ch >= 'A' && ch <= 'Z');
    }

    /* renamed from: a */
    private static boolean m33429a(char ch) {
        return ch == ' ' || (ch >= 'a' && ch <= 'z');
    }

    /* renamed from: d */
    private static boolean m33433d(char ch) {
        return f31089c[ch] != -1;
    }

    /* renamed from: e */
    private static boolean m33434e(char ch) {
        return f31090d[ch] != -1;
    }

    /* renamed from: f */
    private static boolean m33435f(char ch) {
        return ch == 9 || ch == 10 || ch == 13 || (ch >= ' ' && ch <= '~');
    }

    /* renamed from: a */
    private static int m33422a(CharSequence msg, int startpos) {
        int count = 0;
        int len = msg.length();
        int idx = startpos;
        if (startpos < len) {
            char ch = msg.charAt(startpos);
            while (m33432c(ch) && idx < len) {
                count++;
                idx++;
                if (idx < len) {
                    ch = msg.charAt(idx);
                }
            }
        }
        return count;
    }

    /* renamed from: b */
    private static int m33430b(CharSequence msg, int startpos) {
        int len = msg.length();
        int idx = startpos;
        while (idx < len) {
            char ch = msg.charAt(idx);
            int numericCount = 0;
            while (numericCount < 13 && m33432c(ch) && idx < len) {
                numericCount++;
                idx++;
                if (idx < len) {
                    ch = msg.charAt(idx);
                }
            }
            if (numericCount < 13) {
                if (numericCount <= 0) {
                    if (!m33435f(msg.charAt(idx))) {
                        break;
                    }
                    idx++;
                }
            } else {
                return (idx - startpos) - numericCount;
            }
        }
        return idx - startpos;
    }

    /* renamed from: a */
    private static int m33424a(String msg, int startpos, Charset encoding) throws WriterException {
        CharsetEncoder encoder = encoding.newEncoder();
        int len = msg.length();
        int idx = startpos;
        while (idx < len) {
            char ch = msg.charAt(idx);
            int numericCount = 0;
            while (numericCount < 13 && m33432c(ch)) {
                numericCount++;
                int i = idx + numericCount;
                int i2 = i;
                if (i >= len) {
                    break;
                }
                ch = msg.charAt(i2);
            }
            if (numericCount >= 13) {
                return idx - startpos;
            }
            char ch2 = msg.charAt(idx);
            if (encoder.canEncode(ch2)) {
                idx++;
            } else {
                StringBuilder sb = new StringBuilder("Non-encodable character detected: ");
                sb.append(ch2);
                sb.append(" (Unicode: ");
                sb.append(ch2);
                sb.append(')');
                throw new WriterException(sb.toString());
            }
        }
        return idx - startpos;
    }

    /* renamed from: a */
    private static void m33426a(int eci, StringBuilder sb) throws WriterException {
        if (eci >= 0 && eci < 900) {
            sb.append(927);
            sb.append((char) eci);
        } else if (eci < 810900) {
            sb.append(926);
            sb.append((char) ((eci / 900) - 1));
            sb.append((char) (eci % 900));
        } else if (eci < 811800) {
            sb.append(925);
            sb.append((char) (810900 - eci));
        } else {
            StringBuilder sb2 = new StringBuilder("ECI number not in valid range from 0..811799, but was ");
            sb2.append(eci);
            throw new WriterException(sb2.toString());
        }
    }
}
