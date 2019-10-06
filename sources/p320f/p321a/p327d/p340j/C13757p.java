package p320f.p321a.p327d.p340j;

/* renamed from: f.a.d.j.p */
/* compiled from: OpenHashSet */
public final class C13757p<T> {

    /* renamed from: a */
    final float f41869a;

    /* renamed from: b */
    int f41870b;

    /* renamed from: c */
    int f41871c;

    /* renamed from: d */
    int f41872d;

    /* renamed from: e */
    T[] f41873e;

    public C13757p() {
        this(16, 0.75f);
    }

    public C13757p(int capacity, float loadFactor) {
        this.f41869a = loadFactor;
        int c = C13758q.m43796a(capacity);
        this.f41870b = c - 1;
        this.f41872d = (int) (((float) c) * loadFactor);
        this.f41873e = new Object[c];
    }

    /* renamed from: a */
    public boolean mo42747a(T value) {
        T curr;
        T[] a = this.f41873e;
        int m = this.f41870b;
        int pos = m43789a(value.hashCode()) & m;
        T curr2 = a[pos];
        if (curr2 != null) {
            if (curr2.equals(value)) {
                return false;
            }
            do {
                pos = (pos + 1) & m;
                curr = a[pos];
                if (curr == null) {
                }
            } while (!curr.equals(value));
            return false;
        }
        a[pos] = value;
        int i = this.f41871c + 1;
        this.f41871c = i;
        if (i >= this.f41872d) {
            mo42749b();
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo42750b(T value) {
        T curr;
        T[] a = this.f41873e;
        int m = this.f41870b;
        int pos = m43789a(value.hashCode()) & m;
        T curr2 = a[pos];
        if (curr2 == null) {
            return false;
        }
        if (curr2.equals(value)) {
            return mo42746a(pos, a, m);
        }
        do {
            pos = (pos + 1) & m;
            curr = a[pos];
            if (curr == null) {
                return false;
            }
        } while (!curr.equals(value));
        return mo42746a(pos, a, m);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo42746a(int pos, T[] a, int m) {
        T curr;
        this.f41871c--;
        while (true) {
            int last = pos;
            pos = (pos + 1) & m;
            while (true) {
                curr = a[pos];
                if (curr == null) {
                    a[last] = null;
                    return true;
                }
                int slot = m43789a(curr.hashCode()) & m;
                if (last <= pos) {
                    if (last >= slot || slot > pos) {
                        break;
                    }
                    pos = (pos + 1) & m;
                } else {
                    if (last >= slot && slot > pos) {
                        break;
                    }
                    pos = (pos + 1) & m;
                }
            }
            a[last] = curr;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42749b() {
        T[] a = this.f41873e;
        int i = a.length;
        int newCap = i << 1;
        int m = newCap - 1;
        T[] b = new Object[newCap];
        int pos = this.f41871c;
        while (true) {
            int j = pos - 1;
            if (pos != 0) {
                do {
                    i--;
                } while (a[i] == null);
                int pos2 = m43789a(a[i].hashCode()) & m;
                if (b[pos2] != null) {
                    do {
                        pos2 = (pos2 + 1) & m;
                    } while (b[pos2] != null);
                }
                b[pos2] = a[i];
                pos = j;
            } else {
                this.f41870b = m;
                this.f41872d = (int) (((float) newCap) * this.f41869a);
                this.f41873e = b;
                return;
            }
        }
    }

    /* renamed from: a */
    static int m43789a(int x) {
        int h = -1640531527 * x;
        return (h >>> 16) ^ h;
    }

    /* renamed from: a */
    public Object[] mo42748a() {
        return this.f41873e;
    }

    /* renamed from: c */
    public int mo42751c() {
        return this.f41871c;
    }
}
