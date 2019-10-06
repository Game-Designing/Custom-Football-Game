package p019d.p143b.p148b;

/* renamed from: d.b.b.e */
public class C7242e {

    /* renamed from: a */
    private final String f14068a;

    /* renamed from: b */
    private final long f14069b;

    public C7242e(String str, long j) {
        if (str != null) {
            this.f14068a = str;
            this.f14069b = j;
            return;
        }
        throw new IllegalArgumentException("No adapter name specified");
    }

    /* renamed from: a */
    public String mo23468a() {
        return this.f14068a;
    }

    /* renamed from: b */
    public long mo23469b() {
        return this.f14069b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Adapter Stats - <");
        sb.append(this.f14068a);
        sb.append(" : loaded in ");
        sb.append(this.f14069b);
        sb.append("milliseconds>]");
        return sb.toString();
    }
}
