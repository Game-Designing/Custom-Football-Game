package com.inmobi.commons.core.p218a;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.inmobi.commons.core.a.e */
/* compiled from: InMobiCrashHandler */
public class C10629e implements UncaughtExceptionHandler {

    /* renamed from: b */
    private static final String f32390b = C10629e.class.getSimpleName();

    /* renamed from: a */
    private UncaughtExceptionHandler f32391a;

    C10629e(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f32391a = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (stackTrace[i].getClassName().contains("com.inmobi.")) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            try {
                C10621a.m34854a().mo34422a(new C10628d(thread, th));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                sb.append(th.getMessage());
                sb.append(")");
            }
        }
        this.f32391a.uncaughtException(thread, th);
    }
}
