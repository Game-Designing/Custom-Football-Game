package p019d.p143b.p148b;

/* renamed from: d.b.b.d */
public class C7241d {

    /* renamed from: a */
    private final String f14062a;

    /* renamed from: b */
    private final String f14063b;

    /* renamed from: c */
    private final String f14064c;

    /* renamed from: d */
    private final C7243f f14065d;

    /* renamed from: e */
    private final C7239b f14066e;

    /* renamed from: f */
    private final C7240c f14067f;

    public C7241d(String str, String str2, String str3, C7243f fVar) {
        this(str, str2, str3, fVar, null, null);
    }

    public C7241d(String str, String str2, String str3, C7243f fVar, C7239b bVar, C7240c cVar) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No class name specified");
        } else if (fVar != null) {
            this.f14062a = str;
            this.f14063b = str2;
            this.f14064c = str3;
            this.f14065d = fVar;
            this.f14066e = bVar;
            this.f14067f = cVar;
        } else {
            throw new IllegalArgumentException("No status specified");
        }
    }

    /* renamed from: a */
    public String mo23464a() {
        return this.f14062a;
    }

    /* renamed from: b */
    public C7243f mo23465b() {
        return this.f14065d;
    }

    /* renamed from: c */
    public String mo23466c() {
        return this.f14064c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Adapter Info - <");
        sb.append(this.f14062a);
        sb.append(" : ");
        sb.append(this.f14063b);
        sb.append("> v");
        sb.append(this.f14064c);
        sb.append(" with configuration: ");
        sb.append(this.f14067f);
        sb.append("]");
        return sb.toString();
    }
}
