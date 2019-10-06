package p019d.p143b.p144a.p147c;

/* renamed from: d.b.a.c.rb */
public class C7204rb<T> implements Comparable {

    /* renamed from: a */
    private static int f13935a = 0;

    /* renamed from: b */
    private final int f13936b;

    /* renamed from: c */
    private final String f13937c;

    /* renamed from: d */
    private final T f13938d;

    private C7204rb(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (t != null) {
            this.f13937c = str;
            this.f13938d = t;
            int i = f13935a;
            this.f13936b = i;
            f13935a = i + 1;
        } else {
            throw new IllegalArgumentException("No default value specified");
        }
    }

    /* renamed from: a */
    public int mo23234a() {
        return this.f13936b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public T mo23235a(Object obj) {
        return this.f13938d.getClass().cast(obj);
    }

    /* renamed from: b */
    public String mo23236b() {
        return this.f13937c;
    }

    /* renamed from: c */
    public T mo23237c() {
        return this.f13938d;
    }

    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof C7204rb)) {
            return 0;
        }
        return this.f13937c.compareTo(((C7204rb) obj).mo23236b());
    }
}
