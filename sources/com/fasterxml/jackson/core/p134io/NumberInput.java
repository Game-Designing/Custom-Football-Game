package com.fasterxml.jackson.core.p134io;

import java.math.BigDecimal;

/* renamed from: com.fasterxml.jackson.core.io.NumberInput */
public final class NumberInput {
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);

    public static int parseInt(char[] ch, int off, int len) {
        int num = ch[off] - '0';
        if (len > 4) {
            int off2 = off + 1;
            int off3 = off2 + 1;
            int off4 = off3 + 1;
            off = off4 + 1;
            num = (((((((num * 10) + (ch[off2] - '0')) * 10) + (ch[off3] - '0')) * 10) + (ch[off4] - '0')) * 10) + (ch[off] - '0');
            len -= 4;
            if (len > 4) {
                int off5 = off + 1;
                int off6 = off5 + 1;
                int off7 = off6 + 1;
                return (((((((num * 10) + (ch[off5] - '0')) * 10) + (ch[off6] - '0')) * 10) + (ch[off7] - '0')) * 10) + (ch[off7 + 1] - '0');
            }
        }
        if (len > 1) {
            int off8 = off + 1;
            num = (num * 10) + (ch[off8] - '0');
            if (len > 2) {
                int off9 = off8 + 1;
                num = (num * 10) + (ch[off9] - '0');
                if (len > 3) {
                    num = (num * 10) + (ch[off9 + 1] - '0');
                }
            }
        }
        return num;
    }

    public static int parseInt(String s) {
        int offset;
        boolean neg = false;
        char c = s.charAt(0);
        int len = s.length();
        if (c == '-') {
            neg = true;
        }
        if (neg) {
            if (len == 1 || len > 10) {
                return Integer.parseInt(s);
            }
            offset = 1 + 1;
            c = s.charAt(1);
        } else if (len > 9) {
            return Integer.parseInt(s);
        } else {
            offset = 1;
        }
        if (c > '9' || c < '0') {
            return Integer.parseInt(s);
        }
        int num = c - '0';
        if (offset < len) {
            int offset2 = offset + 1;
            char c2 = s.charAt(offset);
            if (c2 > '9' || c2 < '0') {
                return Integer.parseInt(s);
            }
            num = (num * 10) + (c2 - '0');
            if (offset2 < len) {
                int offset3 = offset2 + 1;
                char c3 = s.charAt(offset2);
                if (c3 > '9' || c3 < '0') {
                    return Integer.parseInt(s);
                }
                num = (num * 10) + (c3 - '0');
                if (offset3 < len) {
                    while (true) {
                        int offset4 = offset3 + 1;
                        char c4 = s.charAt(offset3);
                        if (c4 <= '9' && c4 >= '0') {
                            num = (num * 10) + (c4 - '0');
                            if (offset4 >= len) {
                                int i = offset4;
                                break;
                            }
                            offset3 = offset4;
                        }
                    }
                    return Integer.parseInt(s);
                }
            }
        }
        return neg ? -num : num;
    }

    public static long parseLong(char[] ch, int off, int len) {
        int len1 = len - 9;
        return ((long) parseInt(ch, off + len1, 9)) + (((long) parseInt(ch, off, len1)) * 1000000000);
    }

    public static long parseLong(String s) {
        if (s.length() <= 9) {
            return (long) parseInt(s);
        }
        return Long.parseLong(s);
    }

    public static boolean inLongRange(char[] ch, int off, int len, boolean negative) {
        String cmpStr = negative ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int cmpLen = cmpStr.length();
        boolean z = true;
        if (len < cmpLen) {
            return true;
        }
        if (len > cmpLen) {
            return false;
        }
        for (int i = 0; i < cmpLen; i++) {
            int diff = ch[off + i] - cmpStr.charAt(i);
            if (diff != 0) {
                if (diff >= 0) {
                    z = false;
                }
                return z;
            }
        }
        return true;
    }

    public static boolean inLongRange(String s, boolean negative) {
        String cmp = negative ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int cmpLen = cmp.length();
        int alen = s.length();
        boolean z = true;
        if (alen < cmpLen) {
            return true;
        }
        if (alen > cmpLen) {
            return false;
        }
        for (int i = 0; i < cmpLen; i++) {
            int diff = s.charAt(i) - cmp.charAt(i);
            if (diff != 0) {
                if (diff >= 0) {
                    z = false;
                }
                return z;
            }
        }
        return true;
    }

    public static int parseAsInt(String s, int def) {
        if (s == null) {
            return def;
        }
        String s2 = s.trim();
        int len = s2.length();
        if (len == 0) {
            return def;
        }
        int i = 0;
        if (0 < len) {
            char c = s2.charAt(0);
            if (c == '+') {
                s2 = s2.substring(1);
                len = s2.length();
            } else if (c == '-') {
                i = 0 + 1;
            }
        }
        while (i < len) {
            char c2 = s2.charAt(i);
            if (c2 > '9' || c2 < '0') {
                try {
                    return (int) parseDouble(s2);
                } catch (NumberFormatException e) {
                    return def;
                }
            } else {
                i++;
            }
        }
        try {
            return Integer.parseInt(s2);
        } catch (NumberFormatException e2) {
            return def;
        }
    }

    public static long parseAsLong(String s, long def) {
        if (s == null) {
            return def;
        }
        String s2 = s.trim();
        int len = s2.length();
        if (len == 0) {
            return def;
        }
        int i = 0;
        if (0 < len) {
            char c = s2.charAt(0);
            if (c == '+') {
                s2 = s2.substring(1);
                len = s2.length();
            } else if (c == '-') {
                i = 0 + 1;
            }
        }
        while (i < len) {
            char c2 = s2.charAt(i);
            if (c2 > '9' || c2 < '0') {
                try {
                    return (long) parseDouble(s2);
                } catch (NumberFormatException e) {
                    return def;
                }
            } else {
                i++;
            }
        }
        try {
            return Long.parseLong(s2);
        } catch (NumberFormatException e2) {
            return def;
        }
    }

    public static double parseDouble(String s) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(s)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(s);
    }

    public static BigDecimal parseBigDecimal(String s) throws NumberFormatException {
        try {
            return new BigDecimal(s);
        } catch (NumberFormatException e) {
            throw _badBD(s);
        }
    }

    public static BigDecimal parseBigDecimal(char[] b) throws NumberFormatException {
        return parseBigDecimal(b, 0, b.length);
    }

    public static BigDecimal parseBigDecimal(char[] b, int off, int len) throws NumberFormatException {
        try {
            return new BigDecimal(b, off, len);
        } catch (NumberFormatException e) {
            throw _badBD(new String(b, off, len));
        }
    }

    private static NumberFormatException _badBD(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("Value \"");
        sb.append(s);
        sb.append("\" can not be represented as BigDecimal");
        return new NumberFormatException(sb.toString());
    }
}
