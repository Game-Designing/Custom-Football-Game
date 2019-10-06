package p019d.p273h.p276c.p280d;

import p019d.p273h.p276c.p280d.C12800c.C12801a;

/* renamed from: d.h.c.d.g */
/* compiled from: PublisherLogger */
public class C12805g extends C12800c {

    /* renamed from: c */
    private C12803e f39421c;

    public C12805g(C12803e logListener, int debugLevel) {
        super("publisher", debugLevel);
        this.f39421c = logListener;
    }

    /* renamed from: b */
    public synchronized void mo41427b(C12801a tag, String message, int logLevel) {
        if (!(this.f39421c == null || message == null)) {
            this.f39421c.mo41435a(tag, message, logLevel);
        }
    }

    /* renamed from: a */
    public void mo41426a(C12801a tag, String message, Throwable e) {
        if (e != null) {
            mo41427b(tag, e.getMessage(), 3);
        }
    }
}
