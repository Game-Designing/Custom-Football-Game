package p346g.p347a;

import java.util.EventObject;

/* renamed from: g.a.c */
/* compiled from: ServiceEvent */
public abstract class C13820c extends EventObject implements Cloneable {
    /* renamed from: a */
    public abstract C13815a mo43165a();

    /* renamed from: b */
    public abstract C13821d mo43166b();

    /* renamed from: c */
    public abstract String mo43167c();

    /* renamed from: d */
    public abstract String mo43169d();

    public C13820c(Object eventSource) {
        super(eventSource);
    }

    public C13820c clone() {
        try {
            return (C13820c) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
