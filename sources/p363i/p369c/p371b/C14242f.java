package p363i.p369c.p371b;

import java.io.ObjectStreamException;
import java.io.Serializable;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: i.c.b.f */
/* compiled from: NamedLoggerBase */
abstract class C14242f implements C14236b, Serializable {

    /* renamed from: a */
    protected String f43171a;

    C14242f() {
    }

    /* renamed from: a */
    public String mo44361a() {
        return this.f43171a;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return C14246c.m45851a(mo44361a());
    }
}
