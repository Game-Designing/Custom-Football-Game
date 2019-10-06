package p019d.p273h.p276c.p280d;

import java.util.ArrayList;
import java.util.Iterator;
import p019d.p273h.p276c.p280d.C12800c.C12801a;

/* renamed from: d.h.c.d.d */
/* compiled from: IronSourceLoggerManager */
public class C12802d extends C12800c implements C12803e {

    /* renamed from: c */
    private static C12802d f39418c;

    /* renamed from: d */
    private ArrayList<C12800c> f39419d = new ArrayList<>();

    /* renamed from: e */
    private boolean f39420e = false;

    private C12802d(String loggerName) {
        super(loggerName);
        m41614e();
    }

    /* renamed from: e */
    private void m41614e() {
        this.f39419d.add(new C12798a(1));
    }

    /* renamed from: c */
    public static synchronized C12802d m41613c() {
        C12802d dVar;
        synchronized (C12802d.class) {
            if (f39418c == null) {
                f39418c = new C12802d(C12802d.class.getSimpleName());
            }
            dVar = f39418c;
        }
        return dVar;
    }

    /* renamed from: b */
    public static synchronized C12802d m41612b(int debugLevel) {
        C12802d dVar;
        synchronized (C12802d.class) {
            if (f39418c == null) {
                f39418c = new C12802d(C12802d.class.getSimpleName());
            } else {
                f39418c.f39407a = debugLevel;
            }
            dVar = f39418c;
        }
        return dVar;
    }

    /* renamed from: a */
    public void mo41436a(C12800c toAdd) {
        this.f39419d.add(toAdd);
    }

    /* renamed from: b */
    public synchronized void mo41427b(C12801a tag, String message, int logLevel) {
        if (logLevel >= this.f39407a) {
            Iterator it = this.f39419d.iterator();
            while (it.hasNext()) {
                C12800c logger = (C12800c) it.next();
                if (logger.mo41431a() <= logLevel) {
                    logger.mo41427b(tag, message, logLevel);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo41435a(C12801a tag, String message, int logLevel) {
        mo41427b(tag, message, logLevel);
    }

    /* renamed from: a */
    public synchronized void mo41426a(C12801a tag, String message, Throwable e) {
        if (e == null) {
            Iterator it = this.f39419d.iterator();
            while (it.hasNext()) {
                ((C12800c) it.next()).mo41427b(tag, message, 3);
            }
        } else {
            Iterator it2 = this.f39419d.iterator();
            while (it2.hasNext()) {
                ((C12800c) it2.next()).mo41426a(tag, message, e);
            }
        }
    }

    /* renamed from: a */
    private C12800c m41611a(String loggerName) {
        Iterator it = this.f39419d.iterator();
        while (it.hasNext()) {
            C12800c logger = (C12800c) it.next();
            if (logger.mo41433b().equals(loggerName)) {
                return logger;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo41437a(String loggerName, int debugLevel) {
        if (loggerName != null) {
            C12800c logger = m41611a(loggerName);
            String str = ")";
            String str2 = " ,debugLevel:";
            if (logger == null) {
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to find logger:setLoggerDebugLevel(loggerName:");
                sb.append(loggerName);
                sb.append(str2);
                sb.append(debugLevel);
                sb.append(str);
                mo41427b(aVar, sb.toString(), 0);
            } else if (debugLevel < 0 || debugLevel > 3) {
                this.f39419d.remove(logger);
            } else {
                C12801a aVar2 = C12801a.NATIVE;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setLoggerDebugLevel(loggerName:");
                sb2.append(loggerName);
                sb2.append(str2);
                sb2.append(debugLevel);
                sb2.append(str);
                mo41427b(aVar2, sb2.toString(), 0);
                logger.mo41432a(debugLevel);
            }
        }
    }

    /* renamed from: d */
    public boolean mo41438d() {
        return this.f39420e;
    }
}
