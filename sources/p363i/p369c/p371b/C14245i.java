package p363i.p369c.p371b;

import java.io.PrintStream;

/* renamed from: i.c.b.i */
/* compiled from: Util */
public final class C14245i {

    /* renamed from: a */
    private static boolean f43182a = false;

    /* renamed from: c */
    public static String m45850c(String key) {
        if (key != null) {
            try {
                return System.getProperty(key);
            } catch (SecurityException e) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("null input");
        }
    }

    /* renamed from: b */
    public static boolean m45849b(String key) {
        String value = m45850c(key);
        if (value == null) {
            return false;
        }
        return value.equalsIgnoreCase("true");
    }

    /* renamed from: a */
    public static final void m45848a(String msg, Throwable t) {
        System.err.println(msg);
        System.err.println("Reported exception:");
        t.printStackTrace();
    }

    /* renamed from: a */
    public static final void m45847a(String msg) {
        PrintStream printStream = System.err;
        StringBuilder sb = new StringBuilder();
        sb.append("SLF4J: ");
        sb.append(msg);
        printStream.println(sb.toString());
    }
}
