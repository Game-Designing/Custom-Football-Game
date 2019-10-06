package p363i.p369c.p371b;

import java.util.HashMap;
import java.util.Map;

/* renamed from: i.c.b.c */
/* compiled from: MessageFormatter */
public final class C14239c {
    /* renamed from: a */
    public static final C14237a m45799a(String messagePattern, Object arg1, Object arg2) {
        return m45800a(messagePattern, new Object[]{arg1, arg2});
    }

    /* renamed from: a */
    static final Throwable m45802a(Object[] argArray) {
        if (argArray == null || argArray.length == 0) {
            return null;
        }
        Object lastEntry = argArray[argArray.length - 1];
        if (lastEntry instanceof Throwable) {
            return (Throwable) lastEntry;
        }
        return null;
    }

    /* renamed from: a */
    public static final C14237a m45800a(String messagePattern, Object[] argArray) {
        Throwable throwableCandidate = m45802a(argArray);
        Object[] args = argArray;
        if (throwableCandidate != null) {
            args = m45816b(argArray);
        }
        return m45801a(messagePattern, args, throwableCandidate);
    }

    /* renamed from: b */
    private static Object[] m45816b(Object[] argArray) {
        if (argArray == null || argArray.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int trimemdLen = argArray.length - 1;
        Object[] trimmed = new Object[trimemdLen];
        System.arraycopy(argArray, 0, trimmed, 0, trimemdLen);
        return trimmed;
    }

    /* renamed from: a */
    public static final C14237a m45801a(String messagePattern, Object[] argArray, Throwable throwable) {
        if (messagePattern == null) {
            return new C14237a(null, argArray, throwable);
        }
        if (argArray == null) {
            return new C14237a(messagePattern);
        }
        int i = 0;
        StringBuilder sbuf = new StringBuilder(messagePattern.length() + 50);
        int L = 0;
        while (L < argArray.length) {
            int j = messagePattern.indexOf("{}", i);
            if (j != -1) {
                if (!m45815b(messagePattern, j)) {
                    sbuf.append(messagePattern, i, j);
                    m45804a(sbuf, argArray[L], (Map<Object[], Object>) new HashMap<Object[],Object>());
                    i = j + 2;
                } else if (!m45814a(messagePattern, j)) {
                    L--;
                    sbuf.append(messagePattern, i, j - 1);
                    sbuf.append('{');
                    i = j + 1;
                } else {
                    sbuf.append(messagePattern, i, j - 1);
                    m45804a(sbuf, argArray[L], (Map<Object[], Object>) new HashMap<Object[],Object>());
                    i = j + 2;
                }
                L++;
            } else if (i == 0) {
                return new C14237a(messagePattern, argArray, throwable);
            } else {
                sbuf.append(messagePattern, i, messagePattern.length());
                return new C14237a(sbuf.toString(), argArray, throwable);
            }
        }
        sbuf.append(messagePattern, i, messagePattern.length());
        return new C14237a(sbuf.toString(), argArray, throwable);
    }

    /* renamed from: b */
    static final boolean m45815b(String messagePattern, int delimeterStartIndex) {
        if (delimeterStartIndex != 0 && messagePattern.charAt(delimeterStartIndex - 1) == '\\') {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static final boolean m45814a(String messagePattern, int delimeterStartIndex) {
        if (delimeterStartIndex < 2 || messagePattern.charAt(delimeterStartIndex - 2) != '\\') {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static void m45804a(StringBuilder sbuf, Object o, Map<Object[], Object> seenMap) {
        if (o == null) {
            sbuf.append("null");
            return;
        }
        if (!o.getClass().isArray()) {
            m45803a(sbuf, o);
        } else if (o instanceof boolean[]) {
            m45813a(sbuf, (boolean[]) o);
        } else if (o instanceof byte[]) {
            m45805a(sbuf, (byte[]) o);
        } else if (o instanceof char[]) {
            m45806a(sbuf, (char[]) o);
        } else if (o instanceof short[]) {
            m45812a(sbuf, (short[]) o);
        } else if (o instanceof int[]) {
            m45809a(sbuf, (int[]) o);
        } else if (o instanceof long[]) {
            m45810a(sbuf, (long[]) o);
        } else if (o instanceof float[]) {
            m45808a(sbuf, (float[]) o);
        } else if (o instanceof double[]) {
            m45807a(sbuf, (double[]) o);
        } else {
            m45811a(sbuf, (Object[]) o, seenMap);
        }
    }

    /* renamed from: a */
    private static void m45803a(StringBuilder sbuf, Object o) {
        try {
            sbuf.append(o.toString());
        } catch (Throwable t) {
            StringBuilder sb = new StringBuilder();
            sb.append("SLF4J: Failed toString() invocation on an object of type [");
            sb.append(o.getClass().getName());
            sb.append("]");
            C14245i.m45848a(sb.toString(), t);
            sbuf.append("[FAILED toString()]");
        }
    }

    /* renamed from: a */
    private static void m45811a(StringBuilder sbuf, Object[] a, Map<Object[], Object> seenMap) {
        sbuf.append('[');
        if (!seenMap.containsKey(a)) {
            seenMap.put(a, null);
            int len = a.length;
            for (int i = 0; i < len; i++) {
                m45804a(sbuf, a[i], seenMap);
                if (i != len - 1) {
                    sbuf.append(", ");
                }
            }
            seenMap.remove(a);
        } else {
            sbuf.append("...");
        }
        sbuf.append(']');
    }

    /* renamed from: a */
    private static void m45813a(StringBuilder sbuf, boolean[] a) {
        sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    /* renamed from: a */
    private static void m45805a(StringBuilder sbuf, byte[] a) {
        sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    /* renamed from: a */
    private static void m45806a(StringBuilder sbuf, char[] a) {
        sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    /* renamed from: a */
    private static void m45812a(StringBuilder sbuf, short[] a) {
        sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    /* renamed from: a */
    private static void m45809a(StringBuilder sbuf, int[] a) {
        sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    /* renamed from: a */
    private static void m45810a(StringBuilder sbuf, long[] a) {
        sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    /* renamed from: a */
    private static void m45808a(StringBuilder sbuf, float[] a) {
        sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    /* renamed from: a */
    private static void m45807a(StringBuilder sbuf, double[] a) {
        sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }
}
