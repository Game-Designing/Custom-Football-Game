package p019d.p273h.p276c.p280d;

/* renamed from: d.h.c.d.b */
/* compiled from: IronSourceError */
public class C12799b {

    /* renamed from: a */
    private String f39405a;

    /* renamed from: b */
    private int f39406b;

    public C12799b(int key, String msg) {
        this.f39406b = key;
        if (msg == null) {
            msg = "";
        }
        this.f39405a = msg;
    }

    /* renamed from: a */
    public int mo41428a() {
        return this.f39406b;
    }

    /* renamed from: b */
    public String mo41429b() {
        return this.f39405a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("errorCode:");
        sb.append(this.f39406b);
        sb.append(", errorMessage:");
        sb.append(this.f39405a);
        return sb.toString();
    }
}
