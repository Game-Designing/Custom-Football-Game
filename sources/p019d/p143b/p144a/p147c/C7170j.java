package p019d.p143b.p144a.p147c;

/* renamed from: d.b.a.c.j */
class C7170j {

    /* renamed from: a */
    private final String f13598a;

    /* renamed from: b */
    private final boolean f13599b;

    C7170j(String str, boolean z) {
        this.f13598a = str;
        this.f13599b = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo23177a() {
        return this.f13598a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo23178b() {
        return this.f13599b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BidToken{mBase64EncodedId='");
        sb.append(this.f13598a);
        sb.append('\'');
        sb.append(", mIsIdfaCollected=");
        sb.append(this.f13599b);
        sb.append('}');
        return sb.toString();
    }
}
