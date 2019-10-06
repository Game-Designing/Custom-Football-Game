package p002b.p003c.p053g.p061f;

/* renamed from: b.c.g.f.o */
/* compiled from: Pools */
public class C1271o<T> extends C1270n<T> {

    /* renamed from: c */
    private final Object f4073c = new Object();

    public C1271o(int maxPoolSize) {
        super(maxPoolSize);
    }

    /* renamed from: a */
    public T mo9148a() {
        T a;
        synchronized (this.f4073c) {
            a = super.mo9148a();
        }
        return a;
    }

    /* renamed from: a */
    public boolean mo9149a(T element) {
        boolean a;
        synchronized (this.f4073c) {
            a = super.mo9149a(element);
        }
        return a;
    }
}
