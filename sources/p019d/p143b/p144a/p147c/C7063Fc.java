package p019d.p143b.p144a.p147c;

/* renamed from: d.b.a.c.Fc */
public enum C7063Fc {
    f13209a(r2),
    f13210b(r3),
    f13211c(r4);
    

    /* renamed from: e */
    private final String f13213e;

    private C7063Fc(String str) {
        this.f13213e = str;
    }

    /* renamed from: a */
    public static C7063Fc m14702a(String str) {
        return f13210b.toString().equalsIgnoreCase(str) ? f13210b : f13211c.toString().equalsIgnoreCase(str) ? f13211c : f13209a;
    }

    public String toString() {
        return this.f13213e;
    }
}
