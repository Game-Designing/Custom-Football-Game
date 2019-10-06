package com.fasterxml.jackson.core.p134io;

import android.support.p001v7.widget.LinearLayoutManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.fasterxml.jackson.core.io.NumberOutput */
public final class NumberOutput {
    private static int BILLION = 1000000000;
    private static long BILLION_L = 1000000000;
    private static long MAX_INT_AS_LONG = 2147483647L;
    private static int MILLION = 1000000;
    private static long MIN_INT_AS_LONG = -2147483648L;
    static final String SMALLEST_INT = String.valueOf(LinearLayoutManager.INVALID_OFFSET);
    static final String SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    private static final int[] TRIPLET_TO_CHARS = new int[1000];
    private static final String[] sSmallIntStrs = {BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static final String[] sSmallIntStrs2 = {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};

    static {
        int fullIx = 0;
        for (int i1 = 0; i1 < 10; i1++) {
            for (int i2 = 0; i2 < 10; i2++) {
                int i3 = 0;
                while (i3 < 10) {
                    int fullIx2 = fullIx + 1;
                    TRIPLET_TO_CHARS[fullIx] = ((i1 + 48) << 16) | ((i2 + 48) << 8) | (i3 + 48);
                    i3++;
                    fullIx = fullIx2;
                }
            }
        }
    }

    public static int outputInt(int v, char[] b, int off) {
        int off2;
        if (v < 0) {
            if (v == Integer.MIN_VALUE) {
                return _outputSmallestI(b, off);
            }
            int off3 = off + 1;
            b[off] = '-';
            v = -v;
            off = off3;
        }
        if (v >= MILLION) {
            int thousands = BILLION;
            if (v >= thousands) {
                int v2 = v - thousands;
                if (v2 >= thousands) {
                    v2 -= thousands;
                    off2 = off + 1;
                    b[off] = '2';
                } else {
                    off2 = off + 1;
                    b[off] = '1';
                }
                return _outputFullBillion(v2, b, off2);
            }
            int off4 = v / 1000;
            int ones = v - (off4 * 1000);
            int v3 = off4;
            int newValue = off4 / 1000;
            return _full3(ones, b, _full3(v3 - (newValue * 1000), b, _leading3(newValue, b, off)));
        } else if (v >= 1000) {
            int thousands2 = v / 1000;
            return _full3(v - (thousands2 * 1000), b, _leading3(thousands2, b, off));
        } else if (v >= 10) {
            return _leading3(v, b, off);
        } else {
            b[off] = (char) (v + 48);
            return off + 1;
        }
    }

    public static int outputInt(int v, byte[] b, int off) {
        int off2;
        int thousands;
        if (v < 0) {
            if (v == Integer.MIN_VALUE) {
                return _outputSmallestI(b, off);
            }
            int off3 = off + 1;
            b[off] = 45;
            v = -v;
            off = off3;
        }
        if (v < MILLION) {
            if (v >= 1000) {
                int off4 = v / 1000;
                thousands = _full3(v - (off4 * 1000), b, _leading3(off4, b, off));
            } else if (v < 10) {
                thousands = off + 1;
                b[off] = (byte) (v + 48);
            } else {
                thousands = _leading3(v, b, off);
            }
            return thousands;
        }
        int off5 = BILLION;
        if (v >= off5) {
            int v2 = v - off5;
            if (v2 >= off5) {
                v2 -= off5;
                off2 = off + 1;
                b[off] = 50;
            } else {
                off2 = off + 1;
                b[off] = 49;
            }
            return _outputFullBillion(v2, b, off2);
        }
        int off6 = v / 1000;
        int ones = v - (off6 * 1000);
        int v3 = off6;
        int newValue = off6 / 1000;
        return _full3(ones, b, _full3(v3 - (newValue * 1000), b, _leading3(newValue, b, off)));
    }

    public static int outputLong(long v, char[] b, int off) {
        int off2;
        if (v < 0) {
            if (v > MIN_INT_AS_LONG) {
                return outputInt((int) v, b, off);
            }
            if (v == Long.MIN_VALUE) {
                return _outputSmallestL(b, off);
            }
            int off3 = off + 1;
            b[off] = '-';
            v = -v;
            off = off3;
        } else if (v <= MAX_INT_AS_LONG) {
            return outputInt((int) v, b, off);
        }
        long j = BILLION_L;
        long upper = v / j;
        long v2 = v - (upper * j);
        if (upper < j) {
            off2 = _outputUptoBillion((int) upper, b, off);
        } else {
            long hi = upper / j;
            long upper2 = upper - (j * hi);
            off2 = _outputFullBillion((int) upper2, b, _leading3((int) hi, b, off));
        }
        return _outputFullBillion((int) v2, b, off2);
    }

    public static int outputLong(long v, byte[] b, int off) {
        int off2;
        if (v < 0) {
            if (v > MIN_INT_AS_LONG) {
                return outputInt((int) v, b, off);
            }
            if (v == Long.MIN_VALUE) {
                return _outputSmallestL(b, off);
            }
            int off3 = off + 1;
            b[off] = 45;
            v = -v;
            off = off3;
        } else if (v <= MAX_INT_AS_LONG) {
            return outputInt((int) v, b, off);
        }
        long j = BILLION_L;
        long upper = v / j;
        long v2 = v - (upper * j);
        if (upper < j) {
            off2 = _outputUptoBillion((int) upper, b, off);
        } else {
            long hi = upper / j;
            long upper2 = upper - (j * hi);
            off2 = _outputFullBillion((int) upper2, b, _leading3((int) hi, b, off));
        }
        return _outputFullBillion((int) v2, b, off2);
    }

    public static String toString(int v) {
        String[] strArr = sSmallIntStrs;
        if (v < strArr.length) {
            if (v >= 0) {
                return strArr[v];
            }
            int v2 = (-v) - 1;
            String[] strArr2 = sSmallIntStrs2;
            if (v2 < strArr2.length) {
                return strArr2[v2];
            }
        }
        return Integer.toString(v);
    }

    public static String toString(long v) {
        if (v > 2147483647L || v < -2147483648L) {
            return Long.toString(v);
        }
        return toString((int) v);
    }

    public static String toString(double v) {
        return Double.toString(v);
    }

    public static String toString(float v) {
        return Float.toString(v);
    }

    private static int _outputUptoBillion(int v, char[] b, int off) {
        if (v >= MILLION) {
            int thousands = v / 1000;
            int ones = v - (thousands * 1000);
            int millions = thousands / 1000;
            int thousands2 = thousands - (millions * 1000);
            int off2 = _leading3(millions, b, off);
            int[] iArr = TRIPLET_TO_CHARS;
            int enc = iArr[thousands2];
            int off3 = off2 + 1;
            b[off2] = (char) (enc >> 16);
            int off4 = off3 + 1;
            b[off3] = (char) ((enc >> 8) & Opcodes.LAND);
            int off5 = off4 + 1;
            b[off4] = (char) (enc & Opcodes.LAND);
            int enc2 = iArr[ones];
            int off6 = off5 + 1;
            b[off5] = (char) (enc2 >> 16);
            int off7 = off6 + 1;
            b[off6] = (char) ((enc2 >> 8) & Opcodes.LAND);
            int off8 = off7 + 1;
            b[off7] = (char) (enc2 & Opcodes.LAND);
            return off8;
        } else if (v < 1000) {
            return _leading3(v, b, off);
        } else {
            int thousands3 = v / 1000;
            return _outputUptoMillion(b, off, thousands3, v - (thousands3 * 1000));
        }
    }

    private static int _outputFullBillion(int v, char[] b, int off) {
        int thousands = v / 1000;
        int ones = v - (thousands * 1000);
        int millions = thousands / 1000;
        int[] iArr = TRIPLET_TO_CHARS;
        int enc = iArr[millions];
        int off2 = off + 1;
        b[off] = (char) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (char) ((enc >> 8) & Opcodes.LAND);
        int off4 = off3 + 1;
        b[off3] = (char) (enc & Opcodes.LAND);
        int enc2 = iArr[thousands - (millions * 1000)];
        int enc3 = off4 + 1;
        b[off4] = (char) (enc2 >> 16);
        int off5 = enc3 + 1;
        b[enc3] = (char) ((enc2 >> 8) & Opcodes.LAND);
        int off6 = off5 + 1;
        b[off5] = (char) (enc2 & Opcodes.LAND);
        int enc4 = iArr[ones];
        int off7 = off6 + 1;
        b[off6] = (char) (enc4 >> 16);
        int off8 = off7 + 1;
        b[off7] = (char) ((enc4 >> 8) & Opcodes.LAND);
        int off9 = off8 + 1;
        b[off8] = (char) (enc4 & Opcodes.LAND);
        return off9;
    }

    private static int _outputUptoBillion(int v, byte[] b, int off) {
        if (v >= MILLION) {
            int thousands = v / 1000;
            int ones = v - (thousands * 1000);
            int millions = thousands / 1000;
            int thousands2 = thousands - (millions * 1000);
            int off2 = _leading3(millions, b, off);
            int[] iArr = TRIPLET_TO_CHARS;
            int enc = iArr[thousands2];
            int off3 = off2 + 1;
            b[off2] = (byte) (enc >> 16);
            int off4 = off3 + 1;
            b[off3] = (byte) (enc >> 8);
            int off5 = off4 + 1;
            b[off4] = (byte) enc;
            int enc2 = iArr[ones];
            int off6 = off5 + 1;
            b[off5] = (byte) (enc2 >> 16);
            int off7 = off6 + 1;
            b[off6] = (byte) (enc2 >> 8);
            int off8 = off7 + 1;
            b[off7] = (byte) enc2;
            return off8;
        } else if (v < 1000) {
            return _leading3(v, b, off);
        } else {
            int thousands3 = v / 1000;
            return _outputUptoMillion(b, off, thousands3, v - (thousands3 * 1000));
        }
    }

    private static int _outputFullBillion(int v, byte[] b, int off) {
        int thousands = v / 1000;
        int ones = v - (thousands * 1000);
        int millions = thousands / 1000;
        int thousands2 = thousands - (millions * 1000);
        int[] iArr = TRIPLET_TO_CHARS;
        int enc = iArr[millions];
        int off2 = off + 1;
        b[off] = (byte) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (byte) (enc >> 8);
        int off4 = off3 + 1;
        b[off3] = (byte) enc;
        int enc2 = iArr[thousands2];
        int enc3 = off4 + 1;
        b[off4] = (byte) (enc2 >> 16);
        int off5 = enc3 + 1;
        b[enc3] = (byte) (enc2 >> 8);
        int off6 = off5 + 1;
        b[off5] = (byte) enc2;
        int enc4 = iArr[ones];
        int off7 = off6 + 1;
        b[off6] = (byte) (enc4 >> 16);
        int off8 = off7 + 1;
        b[off7] = (byte) (enc4 >> 8);
        int off9 = off8 + 1;
        b[off8] = (byte) enc4;
        return off9;
    }

    private static int _outputUptoMillion(char[] b, int off, int thousands, int ones) {
        int enc = TRIPLET_TO_CHARS[thousands];
        if (thousands > 9) {
            if (thousands > 99) {
                int off2 = off + 1;
                b[off] = (char) (enc >> 16);
                off = off2;
            }
            int off3 = off + 1;
            b[off] = (char) ((enc >> 8) & Opcodes.LAND);
            off = off3;
        }
        int off4 = off + 1;
        b[off] = (char) (enc & Opcodes.LAND);
        int enc2 = TRIPLET_TO_CHARS[ones];
        int enc3 = off4 + 1;
        b[off4] = (char) (enc2 >> 16);
        int off5 = enc3 + 1;
        b[enc3] = (char) ((enc2 >> 8) & Opcodes.LAND);
        int off6 = off5 + 1;
        b[off5] = (char) (enc2 & Opcodes.LAND);
        return off6;
    }

    private static int _outputUptoMillion(byte[] b, int off, int thousands, int ones) {
        int enc = TRIPLET_TO_CHARS[thousands];
        if (thousands > 9) {
            if (thousands > 99) {
                int off2 = off + 1;
                b[off] = (byte) (enc >> 16);
                off = off2;
            }
            int off3 = off + 1;
            b[off] = (byte) (enc >> 8);
            off = off3;
        }
        int off4 = off + 1;
        b[off] = (byte) enc;
        int enc2 = TRIPLET_TO_CHARS[ones];
        int enc3 = off4 + 1;
        b[off4] = (byte) (enc2 >> 16);
        int off5 = enc3 + 1;
        b[enc3] = (byte) (enc2 >> 8);
        int off6 = off5 + 1;
        b[off5] = (byte) enc2;
        return off6;
    }

    private static int _leading3(int t, char[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        if (t > 9) {
            if (t > 99) {
                int off2 = off + 1;
                b[off] = (char) (enc >> 16);
                off = off2;
            }
            int off3 = off + 1;
            b[off] = (char) ((enc >> 8) & Opcodes.LAND);
            off = off3;
        }
        int off4 = off + 1;
        b[off] = (char) (enc & Opcodes.LAND);
        return off4;
    }

    private static int _leading3(int t, byte[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        if (t > 9) {
            if (t > 99) {
                int off2 = off + 1;
                b[off] = (byte) (enc >> 16);
                off = off2;
            }
            int off3 = off + 1;
            b[off] = (byte) (enc >> 8);
            off = off3;
        }
        int off4 = off + 1;
        b[off] = (byte) enc;
        return off4;
    }

    private static int _full3(int t, char[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        int off2 = off + 1;
        b[off] = (char) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (char) ((enc >> 8) & Opcodes.LAND);
        int off4 = off3 + 1;
        b[off3] = (char) (enc & Opcodes.LAND);
        return off4;
    }

    private static int _full3(int t, byte[] b, int off) {
        int enc = TRIPLET_TO_CHARS[t];
        int off2 = off + 1;
        b[off] = (byte) (enc >> 16);
        int off3 = off2 + 1;
        b[off2] = (byte) (enc >> 8);
        int off4 = off3 + 1;
        b[off3] = (byte) enc;
        return off4;
    }

    private static int _outputSmallestL(char[] b, int off) {
        int len = SMALLEST_LONG.length();
        SMALLEST_LONG.getChars(0, len, b, off);
        return off + len;
    }

    private static int _outputSmallestL(byte[] b, int off) {
        int len = SMALLEST_LONG.length();
        int i = 0;
        while (i < len) {
            int off2 = off + 1;
            b[off] = (byte) SMALLEST_LONG.charAt(i);
            i++;
            off = off2;
        }
        return off;
    }

    private static int _outputSmallestI(char[] b, int off) {
        int len = SMALLEST_INT.length();
        SMALLEST_INT.getChars(0, len, b, off);
        return off + len;
    }

    private static int _outputSmallestI(byte[] b, int off) {
        int len = SMALLEST_INT.length();
        int i = 0;
        while (i < len) {
            int off2 = off + 1;
            b[off] = (byte) SMALLEST_INT.charAt(i);
            i++;
            off = off2;
        }
        return off;
    }
}
