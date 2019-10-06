package p019d.p273h.p276c.p280d;

import java.lang.Thread.UncaughtExceptionHandler;
import p019d.p273h.p276c.p280d.C12800c.C12801a;

/* renamed from: d.h.c.d.h */
/* compiled from: ThreadExceptionHandler */
public class C12806h implements UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable ex) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.NATIVE;
        StringBuilder sb = new StringBuilder();
        sb.append("Thread name =");
        sb.append(thread.getName());
        c.mo41426a(aVar, sb.toString(), ex);
    }
}
