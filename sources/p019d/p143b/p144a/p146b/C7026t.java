package p019d.p143b.p144a.p146b;

/* renamed from: d.b.a.b.t */
class C7026t {

    /* renamed from: a */
    private final String f13106a;

    /* renamed from: b */
    private final C7024s f13107b;

    /* renamed from: c */
    private final long f13108c;

    private C7026t(String str, long j, C7024s sVar) {
        this.f13106a = str;
        this.f13108c = j;
        this.f13107b = sVar;
    }

    /* synthetic */ C7026t(String str, long j, C7024s sVar, C7022r rVar) {
        this(str, j, sVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m14539a() {
        return this.f13106a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public long m14541b() {
        return this.f13108c;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public C7024s m14544c() {
        return this.f13107b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7026t)) {
            return false;
        }
        C7026t tVar = (C7026t) obj;
        String str = this.f13106a;
        if (str != null) {
            z = str.equalsIgnoreCase(tVar.f13106a);
        } else if (tVar.f13106a != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f13106a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CountdownProxy{identifier='");
        sb.append(this.f13106a);
        sb.append('\'');
        sb.append(", countdownStepMillis=");
        sb.append(this.f13108c);
        sb.append('}');
        return sb.toString();
    }
}
