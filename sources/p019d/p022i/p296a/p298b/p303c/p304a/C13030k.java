package p019d.p022i.p296a.p298b.p303c.p304a;

import android.support.p001v7.widget.SearchView;
import p019d.p022i.p296a.p305c.C13038e;

/* renamed from: d.i.a.b.c.a.k */
/* compiled from: SearchViewQueryTextEvent */
public final class C13030k extends C13038e<SearchView> {

    /* renamed from: b */
    private final CharSequence f40004b;

    /* renamed from: c */
    private final boolean f40005c;

    /* renamed from: a */
    public static C13030k m42486a(SearchView view, CharSequence queryText, boolean submitted) {
        return new C13030k(view, queryText, submitted);
    }

    private C13030k(SearchView view, CharSequence queryText, boolean submitted) {
        super(view);
        this.f40004b = queryText;
        this.f40005c = submitted;
    }

    /* renamed from: c */
    public CharSequence mo41921c() {
        return this.f40004b;
    }

    /* renamed from: b */
    public boolean mo41920b() {
        return this.f40005c;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof C13030k)) {
            return false;
        }
        C13030k other = (C13030k) o;
        if (!(other.mo41928a() == mo41928a() && other.f40004b.equals(this.f40004b) && other.f40005c == this.f40005c)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((17 * 37) + ((SearchView) mo41928a()).hashCode()) * 37) + this.f40004b.hashCode()) * 37) + (this.f40005c ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchViewQueryTextEvent{view=");
        sb.append(mo41928a());
        sb.append(", queryText=");
        sb.append(this.f40004b);
        sb.append(", submitted=");
        sb.append(this.f40005c);
        sb.append('}');
        return sb.toString();
    }
}
