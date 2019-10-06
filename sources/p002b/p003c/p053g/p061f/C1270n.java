package p002b.p003c.p053g.p061f;

/* renamed from: b.c.g.f.n */
/* compiled from: Pools */
public class C1270n<T> implements C1269m<T> {

    /* renamed from: a */
    private final Object[] f4071a;

    /* renamed from: b */
    private int f4072b;

    public C1270n(int maxPoolSize) {
        if (maxPoolSize > 0) {
            this.f4071a = new Object[maxPoolSize];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    /* renamed from: a */
    public T mo9148a() {
        int i = this.f4072b;
        if (i <= 0) {
            return null;
        }
        int lastPooledIndex = i - 1;
        T[] tArr = this.f4071a;
        T instance = tArr[lastPooledIndex];
        tArr[lastPooledIndex] = null;
        this.f4072b = i - 1;
        return instance;
    }

    /* renamed from: a */
    public boolean mo9149a(T instance) {
        if (!m5954b(instance)) {
            int i = this.f4072b;
            Object[] objArr = this.f4071a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = instance;
            this.f4072b = i + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    /* renamed from: b */
    private boolean m5954b(T instance) {
        for (int i = 0; i < this.f4072b; i++) {
            if (this.f4071a[i] == instance) {
                return true;
            }
        }
        return false;
    }
}
