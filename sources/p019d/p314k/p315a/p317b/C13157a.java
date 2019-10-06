package p019d.p314k.p315a.p317b;

/* renamed from: d.k.a.b.a */
/* compiled from: Header */
public final class C13157a {

    /* renamed from: a */
    private final String f40194a;

    /* renamed from: b */
    private final String f40195b;

    public C13157a(String header, String value) {
        if (header == null) {
            throw new NullPointerException("header cannot be null");
        } else if (!header.contains(":")) {
            if (value == null) {
                value = "";
            }
            this.f40194a = header;
            this.f40195b = value;
        } else {
            throw new IllegalArgumentException("header may not contain ':'");
        }
    }

    /* renamed from: a */
    public String mo42192a() {
        return this.f40194a;
    }

    /* renamed from: b */
    public String mo42193b() {
        return this.f40195b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f40194a);
        sb.append(":");
        sb.append(this.f40195b);
        return sb.toString();
    }
}
