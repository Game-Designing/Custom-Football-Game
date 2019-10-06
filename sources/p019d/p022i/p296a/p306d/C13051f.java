package p019d.p022i.p296a.p306d;

import android.text.Editable;
import android.widget.TextView;
import p019d.p022i.p296a.p305c.C13038e;

/* renamed from: d.i.a.d.f */
/* compiled from: TextViewAfterTextChangeEvent */
public final class C13051f extends C13038e<TextView> {

    /* renamed from: b */
    private final Editable f40032b;

    /* renamed from: a */
    public static C13051f m42505a(TextView view, Editable editable) {
        return new C13051f(view, editable);
    }

    private C13051f(TextView view, Editable editable) {
        super(view);
        this.f40032b = editable;
    }

    /* renamed from: b */
    public Editable mo41940b() {
        return this.f40032b;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof C13051f)) {
            return false;
        }
        C13051f other = (C13051f) o;
        if (other.mo41928a() != mo41928a() || !this.f40032b.equals(other.f40032b)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((17 * 37) + ((TextView) mo41928a()).hashCode()) * 37) + this.f40032b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewAfterTextChangeEvent{editable=");
        sb.append(this.f40032b);
        sb.append(", view=");
        sb.append(mo41928a());
        sb.append('}');
        return sb.toString();
    }
}
