package p019d.p022i.p296a.p298b.p303c.p304a;

import android.support.p001v7.widget.RecyclerView;
import p019d.p022i.p296a.p305c.C13038e;

/* renamed from: d.i.a.b.c.a.a */
/* compiled from: RecyclerViewScrollEvent */
public final class C13020a extends C13038e<RecyclerView> {

    /* renamed from: b */
    private final int f39993b;

    /* renamed from: c */
    private final int f39994c;

    /* renamed from: a */
    public static C13020a m42480a(RecyclerView recyclerView, int dx, int dy) {
        return new C13020a(recyclerView, dx, dy);
    }

    private C13020a(RecyclerView recyclerView, int dx, int dy) {
        super(recyclerView);
        this.f39993b = dx;
        this.f39994c = dy;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof C13020a)) {
            return false;
        }
        C13020a other = (C13020a) o;
        if (!(other.mo41928a() == mo41928a() && this.f39993b == other.f39993b && this.f39994c == other.f39994c)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((17 * 37) + ((RecyclerView) mo41928a()).hashCode()) * 37) + this.f39993b) * 37) + this.f39994c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerViewScrollEvent{view=");
        sb.append(mo41928a());
        sb.append(", dx=");
        sb.append(this.f39993b);
        sb.append(", dy=");
        sb.append(this.f39994c);
        sb.append('}');
        return sb.toString();
    }
}
