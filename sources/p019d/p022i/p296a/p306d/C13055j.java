package p019d.p022i.p296a.p306d;

import android.view.KeyEvent;
import android.widget.TextView;
import p019d.p022i.p296a.p305c.C13038e;

/* renamed from: d.i.a.d.j */
/* compiled from: TextViewEditorActionEvent */
public final class C13055j extends C13038e<TextView> {

    /* renamed from: b */
    private final int f40038b;

    /* renamed from: c */
    private final KeyEvent f40039c;

    /* renamed from: a */
    public static C13055j m42508a(TextView view, int actionId, KeyEvent keyEvent) {
        return new C13055j(view, actionId, keyEvent);
    }

    private C13055j(TextView view, int actionId, KeyEvent keyEvent) {
        super(view);
        this.f40038b = actionId;
        this.f40039c = keyEvent;
    }

    /* renamed from: b */
    public int mo41948b() {
        return this.f40038b;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof C13055j)) {
            return false;
        }
        C13055j other = (C13055j) o;
        if (other.mo41928a() == mo41928a() && other.f40038b == this.f40038b) {
            KeyEvent keyEvent = other.f40039c;
            if (keyEvent == null) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int result = ((((17 * 37) + ((TextView) mo41928a()).hashCode()) * 37) + this.f40038b) * 37;
        KeyEvent keyEvent = this.f40039c;
        return result + (keyEvent != null ? keyEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextViewEditorActionEvent{view=");
        sb.append(mo41928a());
        sb.append(", actionId=");
        sb.append(this.f40038b);
        sb.append(", keyEvent=");
        sb.append(this.f40039c);
        sb.append('}');
        return sb.toString();
    }
}
