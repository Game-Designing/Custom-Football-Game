package p002b.p003c.p053g.p061f;

/* renamed from: b.c.g.f.r */
/* compiled from: SparseArrayCompat */
public class C1274r<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f4081a = new Object();

    /* renamed from: b */
    private boolean f4082b;

    /* renamed from: c */
    private int[] f4083c;

    /* renamed from: d */
    private Object[] f4084d;

    /* renamed from: e */
    private int f4085e;

    public C1274r() {
        this(10);
    }

    public C1274r(int initialCapacity) {
        this.f4082b = false;
        if (initialCapacity == 0) {
            this.f4083c = C1256e.f4036a;
            this.f4084d = C1256e.f4038c;
        } else {
            int initialCapacity2 = C1256e.m5911b(initialCapacity);
            this.f4083c = new int[initialCapacity2];
            this.f4084d = new Object[initialCapacity2];
        }
        this.f4085e = 0;
    }

    public C1274r<E> clone() {
        C1274r<E> rVar = null;
        try {
            rVar = (C1274r) super.clone();
            rVar.f4083c = (int[]) this.f4083c.clone();
            rVar.f4084d = (Object[]) this.f4084d.clone();
            return rVar;
        } catch (CloneNotSupportedException e) {
            return rVar;
        }
    }

    /* renamed from: b */
    public E mo9175b(int key) {
        return mo9176b(key, null);
    }

    /* renamed from: b */
    public E mo9176b(int key, E valueIfKeyNotFound) {
        int i = C1256e.m5908a(this.f4083c, this.f4085e, key);
        if (i >= 0) {
            E[] eArr = this.f4084d;
            if (eArr[i] != f4081a) {
                return eArr[i];
            }
        }
        return valueIfKeyNotFound;
    }

    /* renamed from: a */
    public void mo9172a(int key) {
        int i = C1256e.m5908a(this.f4083c, this.f4085e, key);
        if (i >= 0) {
            Object[] objArr = this.f4084d;
            Object obj = objArr[i];
            Object obj2 = f4081a;
            if (obj != obj2) {
                objArr[i] = obj2;
                this.f4082b = true;
            }
        }
    }

    /* renamed from: e */
    public void mo9181e(int key) {
        mo9172a(key);
    }

    /* renamed from: c */
    private void m5973c() {
        int n = this.f4085e;
        int o = 0;
        int[] keys = this.f4083c;
        Object[] values = this.f4084d;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != f4081a) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }
                o++;
            }
        }
        this.f4082b = false;
        this.f4085e = o;
    }

    /* renamed from: c */
    public void mo9178c(int key, E value) {
        int i = C1256e.m5908a(this.f4083c, this.f4085e, key);
        if (i >= 0) {
            this.f4084d[i] = value;
        } else {
            int i2 = i ^ -1;
            if (i2 < this.f4085e) {
                Object[] objArr = this.f4084d;
                if (objArr[i2] == f4081a) {
                    this.f4083c[i2] = key;
                    objArr[i2] = value;
                    return;
                }
            }
            if (this.f4082b && this.f4085e >= this.f4083c.length) {
                m5973c();
                i2 = C1256e.m5908a(this.f4083c, this.f4085e, key) ^ -1;
            }
            int i3 = this.f4085e;
            if (i3 >= this.f4083c.length) {
                int n = C1256e.m5911b(i3 + 1);
                int[] nkeys = new int[n];
                Object[] nvalues = new Object[n];
                int[] iArr = this.f4083c;
                System.arraycopy(iArr, 0, nkeys, 0, iArr.length);
                Object[] objArr2 = this.f4084d;
                System.arraycopy(objArr2, 0, nvalues, 0, objArr2.length);
                this.f4083c = nkeys;
                this.f4084d = nvalues;
            }
            int n2 = this.f4085e;
            if (n2 - i2 != 0) {
                int[] iArr2 = this.f4083c;
                System.arraycopy(iArr2, i2, iArr2, i2 + 1, n2 - i2);
                Object[] objArr3 = this.f4084d;
                System.arraycopy(objArr3, i2, objArr3, i2 + 1, this.f4085e - i2);
            }
            this.f4083c[i2] = key;
            this.f4084d[i2] = value;
            this.f4085e++;
        }
    }

    /* renamed from: b */
    public int mo9174b() {
        if (this.f4082b) {
            m5973c();
        }
        return this.f4085e;
    }

    /* renamed from: d */
    public int mo9180d(int index) {
        if (this.f4082b) {
            m5973c();
        }
        return this.f4083c[index];
    }

    /* renamed from: f */
    public E mo9182f(int index) {
        if (this.f4082b) {
            m5973c();
        }
        return this.f4084d[index];
    }

    /* renamed from: c */
    public int mo9177c(int key) {
        if (this.f4082b) {
            m5973c();
        }
        return C1256e.m5908a(this.f4083c, this.f4085e, key);
    }

    /* renamed from: a */
    public void mo9171a() {
        int n = this.f4085e;
        Object[] values = this.f4084d;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.f4085e = 0;
        this.f4082b = false;
    }

    /* renamed from: a */
    public void mo9173a(int key, E value) {
        int i = this.f4085e;
        if (i == 0 || key > this.f4083c[i - 1]) {
            if (this.f4082b && this.f4085e >= this.f4083c.length) {
                m5973c();
            }
            int pos = this.f4085e;
            if (pos >= this.f4083c.length) {
                int n = C1256e.m5911b(pos + 1);
                int[] nkeys = new int[n];
                Object[] nvalues = new Object[n];
                int[] iArr = this.f4083c;
                System.arraycopy(iArr, 0, nkeys, 0, iArr.length);
                Object[] objArr = this.f4084d;
                System.arraycopy(objArr, 0, nvalues, 0, objArr.length);
                this.f4083c = nkeys;
                this.f4084d = nvalues;
            }
            this.f4083c[pos] = key;
            this.f4084d[pos] = value;
            this.f4085e = pos + 1;
            return;
        }
        mo9178c(key, value);
    }

    public String toString() {
        if (mo9174b() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f4085e * 28);
        buffer.append('{');
        for (int i = 0; i < this.f4085e; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append(mo9180d(i));
            buffer.append('=');
            Object value = mo9182f(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}
