package p363i.p369c.p370a;

import java.util.Queue;
import p363i.p369c.C14236b;
import p363i.p369c.C14251d;
import p363i.p369c.p371b.C14243g;

/* renamed from: i.c.a.a */
/* compiled from: EventRecodingLogger */
public class C14232a implements C14236b {

    /* renamed from: a */
    String f43147a;

    /* renamed from: b */
    C14243g f43148b;

    /* renamed from: c */
    Queue<C14235d> f43149c;

    public C14232a(C14243g logger, Queue<C14235d> eventQueue) {
        this.f43148b = logger;
        this.f43147a = logger.mo44367b();
        this.f43149c = eventQueue;
    }

    /* renamed from: a */
    private void m45772a(C14233b level, String msg, Object[] args, Throwable throwable) {
        m45771a(level, null, msg, args, throwable);
    }

    /* renamed from: a */
    private void m45771a(C14233b level, C14251d marker, String msg, Object[] args, Throwable throwable) {
        C14235d loggingEvent = new C14235d();
        loggingEvent.mo44351a(System.currentTimeMillis());
        loggingEvent.mo44352a(level);
        loggingEvent.mo44353a(this.f43148b);
        loggingEvent.mo44354a(this.f43147a);
        loggingEvent.mo44357b(msg);
        loggingEvent.mo44356a(args);
        loggingEvent.mo44355a(throwable);
        loggingEvent.mo44358c(Thread.currentThread().getName());
        this.f43149c.add(loggingEvent);
    }

    public boolean isTraceEnabled() {
        return true;
    }

    /* renamed from: c */
    public void mo44345c(String msg) {
        m45772a(C14233b.f43154e, msg, null, null);
    }

    public boolean isDebugEnabled() {
        return true;
    }

    /* renamed from: a */
    public void mo44340a(String msg) {
        m45772a(C14233b.f43154e, msg, null, null);
    }

    /* renamed from: a */
    public void mo44341a(String format, Object arg1, Object arg2) {
        m45772a(C14233b.f43153d, format, new Object[]{arg1, arg2}, null);
    }

    /* renamed from: c */
    public void mo44346c(String msg, Throwable t) {
        m45772a(C14233b.f43153d, msg, null, t);
    }

    /* renamed from: a */
    public void mo44342a(String msg, Throwable t) {
        m45772a(C14233b.f43152c, msg, null, t);
    }

    /* renamed from: b */
    public void mo44343b(String msg) {
        m45772a(C14233b.f43151b, msg, null, null);
    }

    /* renamed from: b */
    public void mo44344b(String msg, Throwable t) {
        m45772a(C14233b.f43151b, msg, null, t);
    }
}
