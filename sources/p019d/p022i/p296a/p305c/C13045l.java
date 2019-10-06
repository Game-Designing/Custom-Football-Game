package p019d.p022i.p296a.p305c;

import android.view.View;

/* renamed from: d.i.a.c.l */
/* compiled from: ViewScrollChangeEvent */
public final class C13045l extends C13038e<View> {

    /* renamed from: b */
    private final int f40024b;

    /* renamed from: c */
    private final int f40025c;

    /* renamed from: d */
    private final int f40026d;

    /* renamed from: e */
    private final int f40027e;

    /* renamed from: a */
    public static C13045l m42497a(View view, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        C13045l lVar = new C13045l(view, scrollX, scrollY, oldScrollX, oldScrollY);
        return lVar;
    }

    protected C13045l(View view, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        super(view);
        this.f40024b = scrollX;
        this.f40025c = scrollY;
        this.f40026d = oldScrollX;
        this.f40027e = oldScrollY;
    }

    /* renamed from: c */
    public int mo41934c() {
        return this.f40025c;
    }

    /* renamed from: b */
    public int mo41933b() {
        return this.f40027e;
    }

    public int hashCode() {
        return (((((((((17 * 37) + mo41928a().hashCode()) * 37) + this.f40024b) * 37) + this.f40025c) * 37) + this.f40026d) * 37) + this.f40027e;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof C13045l)) {
            return false;
        }
        C13045l other = (C13045l) o;
        if (!(other.mo41928a() == mo41928a() && other.f40024b == this.f40024b && other.f40025c == this.f40025c && other.f40026d == this.f40026d && other.f40027e == this.f40027e)) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ViewScrollChangeEvent{scrollX=");
        sb.append(this.f40024b);
        sb.append(", scrollY=");
        sb.append(this.f40025c);
        sb.append(", oldScrollX=");
        sb.append(this.f40026d);
        sb.append(", oldScrollY=");
        sb.append(this.f40027e);
        sb.append('}');
        return sb.toString();
    }
}
