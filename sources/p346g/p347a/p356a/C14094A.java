package p346g.p347a.p356a;

import p346g.p347a.C13815a;
import p346g.p347a.C13820c;
import p346g.p347a.C13821d;

/* renamed from: g.a.a.A */
/* compiled from: ServiceEventImpl */
public class C14094A extends C13820c {

    /* renamed from: a */
    private final String f42742a;

    /* renamed from: b */
    private final String f42743b;

    /* renamed from: c */
    private final C13821d f42744c;

    public C14094A(C14164v jmDNS, String type, String name, C13821d info) {
        super(jmDNS);
        this.f42742a = type;
        this.f42743b = name;
        this.f42744c = info;
    }

    /* renamed from: a */
    public C13815a mo43165a() {
        return (C13815a) getSource();
    }

    /* renamed from: d */
    public String mo43169d() {
        return this.f42742a;
    }

    /* renamed from: c */
    public String mo43167c() {
        return this.f42743b;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(System.identityHashCode(this));
        sb.append(" ");
        buf.append(sb.toString());
        buf.append("\n\tname: '");
        buf.append(mo43167c());
        buf.append("' type: '");
        buf.append(mo43169d());
        buf.append("' info: '");
        buf.append(mo43166b());
        buf.append("']");
        return buf.toString();
    }

    /* renamed from: b */
    public C13821d mo43166b() {
        return this.f42744c;
    }

    public C14094A clone() {
        return new C14094A((C14164v) mo43165a(), mo43169d(), mo43167c(), new C14096C(mo43166b()));
    }
}
