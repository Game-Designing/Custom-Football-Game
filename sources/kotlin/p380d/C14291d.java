package kotlin.p380d;

/* renamed from: kotlin.d.d */
/* compiled from: Ranges.kt */
public final class C14291d extends C14288b implements C14287a<Integer> {

    /* renamed from: e */
    private static final C14291d f43227e = new C14291d(1, 0);

    /* renamed from: f */
    public static final C14292a f43228f = new C14292a(null);

    /* renamed from: kotlin.d.d$a */
    /* compiled from: Ranges.kt */
    public static final class C14292a {
        private C14292a() {
        }

        public /* synthetic */ C14292a(C14280e $constructor_marker) {
            this();
        }
    }

    public C14291d(int start, int endInclusive) {
        super(start, endInclusive, 1);
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    public boolean equals(Object other) {
        return (other instanceof C14291d) && ((isEmpty() && ((C14291d) other).isEmpty()) || (getFirst() == ((C14291d) other).getFirst() && getLast() == ((C14291d) other).getLast()));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFirst());
        sb.append("..");
        sb.append(getLast());
        return sb.toString();
    }
}
