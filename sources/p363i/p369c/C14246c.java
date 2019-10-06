package p363i.p369c;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import p363i.p369c.p370a.C14234c;
import p363i.p369c.p370a.C14235d;
import p363i.p369c.p371b.C14241e;
import p363i.p369c.p371b.C14243g;
import p363i.p369c.p371b.C14244h;
import p363i.p369c.p371b.C14245i;
import p363i.p369c.p372c.C14250d;

/* renamed from: i.c.c */
/* compiled from: LoggerFactory */
public final class C14246c {

    /* renamed from: a */
    static volatile int f43183a = 0;

    /* renamed from: b */
    static C14244h f43184b = new C14244h();

    /* renamed from: c */
    static C14241e f43185c = new C14241e();

    /* renamed from: d */
    static boolean f43186d = C14245i.m45849b("slf4j.detectLoggerNameMismatch");

    /* renamed from: e */
    private static final String[] f43187e = {"1.6", "1.7"};

    /* renamed from: f */
    private static String f43188f = "org/slf4j/impl/StaticLoggerBinder.class";

    private C14246c() {
    }

    /* renamed from: g */
    private static final void m45866g() {
        m45861c();
        if (f43183a == 3) {
            m45868i();
        }
    }

    /* renamed from: b */
    private static boolean m45860b(String msg) {
        if (msg == null) {
            return false;
        }
        if (!msg.contains("org/slf4j/impl/StaticLoggerBinder") && !msg.contains("org.slf4j.impl.StaticLoggerBinder")) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static final void m45861c() {
        Set set = null;
        try {
            if (!m45865f()) {
                set = m45852a();
                m45862c(set);
            }
            C14250d.m45891c();
            f43183a = 3;
            m45859b(set);
            m45864e();
            m45867h();
            f43184b.mo44373a();
        } catch (NoClassDefFoundError ncde) {
            if (m45860b(ncde.getMessage())) {
                f43183a = 4;
                C14245i.m45847a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                C14245i.m45847a("Defaulting to no-operation (NOP) logger implementation");
                C14245i.m45847a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            m45856a((Throwable) ncde);
            throw ncde;
        } catch (NoSuchMethodError nsme) {
            String msg = nsme.getMessage();
            if (msg != null && msg.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f43183a = 2;
                C14245i.m45847a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                C14245i.m45847a("Your binding is version 1.5.5 or earlier.");
                C14245i.m45847a("Upgrade your binding to version 1.6.x.");
            }
            throw nsme;
        } catch (Exception e) {
            m45856a((Throwable) e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        }
    }

    /* renamed from: e */
    private static void m45864e() {
        synchronized (f43184b) {
            f43184b.mo44376d();
            for (C14243g substLogger : f43184b.mo44375c()) {
                substLogger.mo44366a(m45851a(substLogger.mo44367b()));
            }
        }
    }

    /* renamed from: a */
    static void m45856a(Throwable t) {
        f43183a = 2;
        C14245i.m45848a("Failed to instantiate SLF4J LoggerFactory", t);
    }

    /* renamed from: h */
    private static void m45867h() {
        LinkedBlockingQueue<SubstituteLoggingEvent> queue = f43184b.mo44374b();
        int queueSize = queue.size();
        int count = 0;
        List<SubstituteLoggingEvent> eventList = new ArrayList<>(128);
        while (queue.drainTo(eventList, 128) != 0) {
            Iterator i$ = eventList.iterator();
            while (i$.hasNext()) {
                C14235d event = (C14235d) i$.next();
                m45854a(event);
                int count2 = count + 1;
                if (count == 0) {
                    m45855a(event, queueSize);
                }
                count = count2;
            }
            eventList.clear();
        }
    }

    /* renamed from: a */
    private static void m45855a(C14235d event, int queueSize) {
        if (event.mo44350a().mo44368c()) {
            m45853a(queueSize);
        } else if (!event.mo44350a().mo44369d()) {
            m45863d();
        }
    }

    /* renamed from: a */
    private static void m45854a(C14235d event) {
        if (event != null) {
            C14243g substLogger = event.mo44350a();
            String loggerName = substLogger.mo44367b();
            if (!substLogger.mo44370e()) {
                if (!substLogger.mo44369d()) {
                    if (substLogger.mo44368c()) {
                        substLogger.mo44365a((C14234c) event);
                    } else {
                        C14245i.m45847a(loggerName);
                    }
                }
                return;
            }
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
    }

    /* renamed from: d */
    private static void m45863d() {
        C14245i.m45847a("The following set of substitute loggers may have been accessed");
        C14245i.m45847a("during the initialization phase. Logging calls during this");
        C14245i.m45847a("phase were not honored. However, subsequent logging calls to these");
        C14245i.m45847a("loggers will work as normally expected.");
        C14245i.m45847a("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    /* renamed from: a */
    private static void m45853a(int eventCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("A number (");
        sb.append(eventCount);
        sb.append(") of logging calls during the initialization phase have been intercepted and are");
        C14245i.m45847a(sb.toString());
        C14245i.m45847a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        C14245i.m45847a("See also http://www.slf4j.org/codes.html#replay");
    }

    /* renamed from: i */
    private static final void m45868i() {
        try {
            String requested = C14250d.f43207b;
            boolean match = false;
            for (String aAPI_COMPATIBILITY_LIST : f43187e) {
                if (requested.startsWith(aAPI_COMPATIBILITY_LIST)) {
                    match = true;
                }
            }
            if (!match) {
                StringBuilder sb = new StringBuilder();
                sb.append("The requested version ");
                sb.append(requested);
                sb.append(" by your slf4j binding is not compatible with ");
                sb.append(Arrays.asList(f43187e).toString());
                C14245i.m45847a(sb.toString());
                C14245i.m45847a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError e) {
        } catch (Throwable e2) {
            C14245i.m45848a("Unexpected problem occured during version sanity check", e2);
        }
    }

    /* renamed from: a */
    static Set<URL> m45852a() {
        Enumeration<URL> paths;
        Set<URL> staticLoggerBinderPathSet = new LinkedHashSet<>();
        try {
            ClassLoader loggerFactoryClassLoader = C14246c.class.getClassLoader();
            if (loggerFactoryClassLoader == null) {
                paths = ClassLoader.getSystemResources(f43188f);
            } else {
                paths = loggerFactoryClassLoader.getResources(f43188f);
            }
            while (paths.hasMoreElements()) {
                staticLoggerBinderPathSet.add((URL) paths.nextElement());
            }
        } catch (IOException ioe) {
            C14245i.m45848a("Error getting resources from path", ioe);
        }
        return staticLoggerBinderPathSet;
    }

    /* renamed from: a */
    private static boolean m45857a(Set<URL> binderPathSet) {
        return binderPathSet.size() > 1;
    }

    /* renamed from: c */
    private static void m45862c(Set<URL> binderPathSet) {
        if (m45857a(binderPathSet)) {
            C14245i.m45847a("Class path contains multiple SLF4J bindings.");
            for (URL path : binderPathSet) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found binding in [");
                sb.append(path);
                sb.append("]");
                C14245i.m45847a(sb.toString());
            }
            C14245i.m45847a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /* renamed from: f */
    private static boolean m45865f() {
        String vendor = C14245i.m45850c("java.vendor.url");
        if (vendor == null) {
            return false;
        }
        return vendor.toLowerCase().contains("android");
    }

    /* renamed from: b */
    private static void m45859b(Set<URL> binderPathSet) {
        if (binderPathSet != null && m45857a(binderPathSet)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Actual binding is of type [");
            sb.append(C14250d.m45891c().mo44382b());
            sb.append("]");
            C14245i.m45847a(sb.toString());
        }
    }

    /* renamed from: a */
    public static C14236b m45851a(String name) {
        return m45858b().mo44339a(name);
    }

    /* renamed from: b */
    public static C14231a m45858b() {
        if (f43183a == 0) {
            synchronized (C14246c.class) {
                if (f43183a == 0) {
                    f43183a = 1;
                    m45866g();
                }
            }
        }
        int i = f43183a;
        if (i == 1) {
            return f43184b;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        } else if (i == 3) {
            return C14250d.m45891c().mo44381a();
        } else {
            if (i == 4) {
                return f43185c;
            }
            throw new IllegalStateException("Unreachable code");
        }
    }
}
