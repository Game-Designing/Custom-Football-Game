package p363i.p369c.p372c;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.AccessController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p363i.p369c.p371b.C14237a;
import p363i.p369c.p371b.C14238b;
import p363i.p369c.p371b.C14239c;
import p363i.p369c.p371b.C14245i;

/* renamed from: i.c.c.b */
/* compiled from: SimpleLogger */
public class C14248b extends C14238b {

    /* renamed from: b */
    private static long f43189b = System.currentTimeMillis();

    /* renamed from: c */
    private static final Properties f43190c = new Properties();

    /* renamed from: d */
    private static boolean f43191d = false;

    /* renamed from: e */
    private static int f43192e = 20;

    /* renamed from: f */
    private static boolean f43193f = false;

    /* renamed from: g */
    private static String f43194g = null;

    /* renamed from: h */
    private static DateFormat f43195h = null;

    /* renamed from: i */
    private static boolean f43196i = true;

    /* renamed from: j */
    private static boolean f43197j = true;

    /* renamed from: k */
    private static boolean f43198k = false;

    /* renamed from: l */
    private static String f43199l = "System.err";

    /* renamed from: m */
    private static PrintStream f43200m = null;

    /* renamed from: n */
    private static boolean f43201n = false;

    /* renamed from: o */
    private static String f43202o = "WARN";

    /* renamed from: p */
    protected int f43203p = 20;

    /* renamed from: q */
    private transient String f43204q = null;

    /* renamed from: e */
    private static String m45877e(String name) {
        String prop = null;
        try {
            prop = System.getProperty(name);
        } catch (SecurityException e) {
        }
        return prop == null ? f43190c.getProperty(name) : prop;
    }

    /* renamed from: a */
    private static String m45869a(String name, String defaultValue) {
        String prop = m45877e(name);
        return prop == null ? defaultValue : prop;
    }

    /* renamed from: a */
    private static boolean m45872a(String name, boolean defaultValue) {
        String prop = m45877e(name);
        return prop == null ? defaultValue : "true".equalsIgnoreCase(prop);
    }

    /* renamed from: b */
    static void m45873b() {
        if (!f43191d) {
            f43191d = true;
            m45879f();
            String defaultLogLevelString = m45869a("org.slf4j.simpleLogger.defaultLogLevel", (String) null);
            if (defaultLogLevelString != null) {
                f43192e = m45878f(defaultLogLevelString);
            }
            f43197j = m45872a("org.slf4j.simpleLogger.showLogName", f43197j);
            f43198k = m45872a("org.slf4j.simpleLogger.showShortLogName", f43198k);
            f43193f = m45872a("org.slf4j.simpleLogger.showDateTime", f43193f);
            f43196i = m45872a("org.slf4j.simpleLogger.showThreadName", f43196i);
            f43194g = m45869a("org.slf4j.simpleLogger.dateTimeFormat", f43194g);
            f43201n = m45872a("org.slf4j.simpleLogger.levelInBrackets", f43201n);
            f43202o = m45869a("org.slf4j.simpleLogger.warnLevelString", f43202o);
            f43199l = m45869a("org.slf4j.simpleLogger.logFile", f43199l);
            f43200m = m45874d(f43199l);
            String str = f43194g;
            if (str != null) {
                try {
                    f43195h = new SimpleDateFormat(str);
                } catch (IllegalArgumentException e) {
                    C14245i.m45848a("Bad date format in simplelogger.properties; will output relative time", e);
                }
            }
        }
    }

    /* renamed from: d */
    private static PrintStream m45874d(String logFile) {
        if ("System.err".equalsIgnoreCase(logFile)) {
            return System.err;
        }
        if ("System.out".equalsIgnoreCase(logFile)) {
            return System.out;
        }
        try {
            return new PrintStream(new FileOutputStream(logFile));
        } catch (FileNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not open [");
            sb.append(logFile);
            sb.append("]. Defaulting to System.err");
            C14245i.m45848a(sb.toString(), e);
            return System.err;
        }
    }

    /* renamed from: f */
    private static void m45879f() {
        InputStream in = (InputStream) AccessController.doPrivileged(new C14247a());
        if (in != null) {
            try {
                f43190c.load(in);
                in.close();
            } catch (IOException e) {
            }
        }
    }

    C14248b(String name) {
        this.f43171a = name;
        String levelString = mo44380c();
        if (levelString != null) {
            this.f43203p = m45878f(levelString);
        } else {
            this.f43203p = f43192e;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo44380c() {
        String tempName = this.f43171a;
        String levelString = null;
        int indexOfLastDot = tempName.length();
        while (levelString == null && indexOfLastDot > -1) {
            tempName = tempName.substring(0, indexOfLastDot);
            StringBuilder sb = new StringBuilder();
            sb.append("org.slf4j.simpleLogger.log.");
            sb.append(tempName);
            levelString = m45869a(sb.toString(), (String) null);
            indexOfLastDot = String.valueOf(tempName).lastIndexOf(".");
        }
        return levelString;
    }

    /* renamed from: f */
    private static int m45878f(String levelStr) {
        if ("trace".equalsIgnoreCase(levelStr)) {
            return 0;
        }
        if ("debug".equalsIgnoreCase(levelStr)) {
            return 10;
        }
        if ("info".equalsIgnoreCase(levelStr)) {
            return 20;
        }
        if (Malware.WARN.equalsIgnoreCase(levelStr)) {
            return 30;
        }
        if ("error".equalsIgnoreCase(levelStr)) {
            return 40;
        }
        return 20;
    }

    /* renamed from: a */
    private void m45871a(int level, String message, Throwable t) {
        if (mo44379a(level)) {
            StringBuilder buf = new StringBuilder(32);
            if (f43193f) {
                if (f43195h != null) {
                    buf.append(m45876e());
                    buf.append(' ');
                } else {
                    buf.append(System.currentTimeMillis() - f43189b);
                    buf.append(' ');
                }
            }
            if (f43196i) {
                buf.append('[');
                buf.append(Thread.currentThread().getName());
                buf.append("] ");
            }
            if (f43201n) {
                buf.append('[');
            }
            if (level == 0) {
                buf.append("TRACE");
            } else if (level == 10) {
                buf.append("DEBUG");
            } else if (level == 20) {
                buf.append("INFO");
            } else if (level == 30) {
                buf.append(f43202o);
            } else if (level == 40) {
                buf.append("ERROR");
            }
            if (f43201n) {
                buf.append(']');
            }
            buf.append(' ');
            String str = " - ";
            if (f43198k) {
                if (this.f43204q == null) {
                    this.f43204q = m45875d();
                }
                buf.append(String.valueOf(this.f43204q));
                buf.append(str);
            } else if (f43197j) {
                buf.append(String.valueOf(this.f43171a));
                buf.append(str);
            }
            buf.append(message);
            mo44378a(buf, t);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo44378a(StringBuilder buf, Throwable t) {
        f43200m.println(buf.toString());
        if (t != null) {
            t.printStackTrace(f43200m);
        }
        f43200m.flush();
    }

    /* renamed from: e */
    private String m45876e() {
        Date now = new Date();
        synchronized (f43195h) {
            try {
                String dateText = f43195h.format(now);
                return dateText;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* renamed from: d */
    private String m45875d() {
        return this.f43171a.substring(this.f43171a.lastIndexOf(".") + 1);
    }

    /* renamed from: a */
    private void m45870a(int level, String format, Object arg1, Object arg2) {
        if (mo44379a(level)) {
            C14237a tp = C14239c.m45799a(format, arg1, arg2);
            m45871a(level, tp.mo44359a(), tp.mo44360b());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo44379a(int logLevel) {
        return logLevel >= this.f43203p;
    }

    public boolean isTraceEnabled() {
        return mo44379a(0);
    }

    /* renamed from: c */
    public void mo44345c(String msg) {
        m45871a(0, msg, (Throwable) null);
    }

    public boolean isDebugEnabled() {
        return mo44379a(10);
    }

    /* renamed from: a */
    public void mo44340a(String msg) {
        m45871a(10, msg, (Throwable) null);
    }

    /* renamed from: a */
    public void mo44341a(String format, Object param1, Object param2) {
        m45870a(10, format, param1, param2);
    }

    /* renamed from: c */
    public void mo44346c(String msg, Throwable t) {
        m45871a(10, msg, t);
    }

    /* renamed from: a */
    public void mo44342a(String msg, Throwable t) {
        m45871a(20, msg, t);
    }

    /* renamed from: b */
    public void mo44343b(String msg) {
        m45871a(30, msg, (Throwable) null);
    }

    /* renamed from: b */
    public void mo44344b(String msg, Throwable t) {
        m45871a(30, msg, t);
    }
}
