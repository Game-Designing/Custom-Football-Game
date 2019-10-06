package android.support.constraint.p034a;

/* renamed from: android.support.constraint.a.h */
/* compiled from: Pools */
class C0202h<T> implements C0201g<T> {

    /* renamed from: a */
    private final Object[] f584a;

    /* renamed from: b */
    private int f585b;

    C0202h(int maxPoolSize) {
        if (maxPoolSize > 0) {
            this.f584a = new Object[maxPoolSize];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    /* renamed from: a */
    public T mo4031a() {
        int i = this.f585b;
        if (i <= 0) {
            return null;
        }
        int lastPooledIndex = i - 1;
        T[] tArr = this.f584a;
        T instance = tArr[lastPooledIndex];
        tArr[lastPooledIndex] = null;
        this.f585b = i - 1;
        return instance;
    }

    /* renamed from: a */
    public boolean mo4033a(T instance) {
        int i = this.f585b;
        Object[] objArr = this.f584a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = instance;
        this.f585b = i + 1;
        return true;
    }

    /* renamed from: a */
    public void mo4032a(T[] variables, int count) {
        if (count > variables.length) {
            count = variables.length;
        }
        for (int i = 0; i < count; i++) {
            T instance = variables[i];
            int i2 = this.f585b;
            Object[] objArr = this.f584a;
            if (i2 < objArr.length) {
                objArr[i2] = instance;
                this.f585b = i2 + 1;
            }
        }
    }
}
