package p002b.p003c.p053g.p061f;

/* renamed from: b.c.g.f.h */
/* compiled from: LongSparseArray */
public class C1259h<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f4041a = new Object();

    /* renamed from: b */
    private boolean f4042b;

    /* renamed from: c */
    private long[] f4043c;

    /* renamed from: d */
    private Object[] f4044d;

    /* renamed from: e */
    private int f4045e;

    public C1259h() {
        this(10);
    }

    public C1259h(int initialCapacity) {
        this.f4042b = false;
        if (initialCapacity == 0) {
            this.f4043c = C1256e.f4037b;
            this.f4044d = C1256e.f4038c;
        } else {
            int initialCapacity2 = C1256e.m5912c(initialCapacity);
            this.f4043c = new long[initialCapacity2];
            this.f4044d = new Object[initialCapacity2];
        }
        this.f4045e = 0;
    }

    public C1259h<E> clone() {
        C1259h<E> hVar = null;
        try {
            hVar = (C1259h) super.clone();
            hVar.f4043c = (long[]) this.f4043c.clone();
            hVar.f4044d = (Object[]) this.f4044d.clone();
            return hVar;
        } catch (CloneNotSupportedException e) {
            return hVar;
        }
    }

    /* renamed from: b */
    public E mo9058b(long key) {
        return mo9059b(key, null);
    }

    /* renamed from: b */
    public E mo9059b(long key, E valueIfKeyNotFound) {
        int i = C1256e.m5909a(this.f4043c, this.f4045e, key);
        if (i >= 0) {
            E[] eArr = this.f4044d;
            if (eArr[i] != f4041a) {
                return eArr[i];
            }
        }
        return valueIfKeyNotFound;
    }

    /* renamed from: a */
    public void mo9055a(long key) {
        int i = C1256e.m5909a(this.f4043c, this.f4045e, key);
        if (i >= 0) {
            Object[] objArr = this.f4044d;
            Object obj = objArr[i];
            Object obj2 = f4041a;
            if (obj != obj2) {
                objArr[i] = obj2;
                this.f4042b = true;
            }
        }
    }

    /* renamed from: b */
    public void mo9060b(int index) {
        Object[] objArr = this.f4044d;
        Object obj = objArr[index];
        Object obj2 = f4041a;
        if (obj != obj2) {
            objArr[index] = obj2;
            this.f4042b = true;
        }
    }

    /* renamed from: c */
    private void m5915c() {
        int n = this.f4045e;
        int o = 0;
        long[] keys = this.f4043c;
        Object[] values = this.f4044d;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != f4041a) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }
                o++;
            }
        }
        this.f4042b = false;
        this.f4045e = o;
    }

    /* renamed from: c */
    public void mo9063c(long key, E value) {
        int i = C1256e.m5909a(this.f4043c, this.f4045e, key);
        if (i >= 0) {
            this.f4044d[i] = value;
        } else {
            int i2 = i ^ -1;
            if (i2 < this.f4045e) {
                Object[] objArr = this.f4044d;
                if (objArr[i2] == f4041a) {
                    this.f4043c[i2] = key;
                    objArr[i2] = value;
                    return;
                }
            }
            if (this.f4042b && this.f4045e >= this.f4043c.length) {
                m5915c();
                i2 = C1256e.m5909a(this.f4043c, this.f4045e, key) ^ -1;
            }
            int i3 = this.f4045e;
            if (i3 >= this.f4043c.length) {
                int n = C1256e.m5912c(i3 + 1);
                long[] nkeys = new long[n];
                Object[] nvalues = new Object[n];
                long[] jArr = this.f4043c;
                System.arraycopy(jArr, 0, nkeys, 0, jArr.length);
                Object[] objArr2 = this.f4044d;
                System.arraycopy(objArr2, 0, nvalues, 0, objArr2.length);
                this.f4043c = nkeys;
                this.f4044d = nvalues;
            }
            int n2 = this.f4045e;
            if (n2 - i2 != 0) {
                long[] jArr2 = this.f4043c;
                System.arraycopy(jArr2, i2, jArr2, i2 + 1, n2 - i2);
                Object[] objArr3 = this.f4044d;
                System.arraycopy(objArr3, i2, objArr3, i2 + 1, this.f4045e - i2);
            }
            this.f4043c[i2] = key;
            this.f4044d[i2] = value;
            this.f4045e++;
        }
    }

    /* renamed from: b */
    public int mo9057b() {
        if (this.f4042b) {
            m5915c();
        }
        return this.f4045e;
    }

    /* renamed from: a */
    public long mo9053a(int index) {
        if (this.f4042b) {
            m5915c();
        }
        return this.f4043c[index];
    }

    /* renamed from: c */
    public E mo9062c(int index) {
        if (this.f4042b) {
            m5915c();
        }
        return this.f4044d[index];
    }

    /* renamed from: c */
    public int mo9061c(long key) {
        if (this.f4042b) {
            m5915c();
        }
        return C1256e.m5909a(this.f4043c, this.f4045e, key);
    }

    /* renamed from: a */
    public void mo9054a() {
        int n = this.f4045e;
        Object[] values = this.f4044d;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.f4045e = 0;
        this.f4042b = false;
    }

    /* renamed from: a */
    public void mo9056a(long key, E value) {
        int i = this.f4045e;
        if (i == 0 || key > this.f4043c[i - 1]) {
            if (this.f4042b && this.f4045e >= this.f4043c.length) {
                m5915c();
            }
            int pos = this.f4045e;
            if (pos >= this.f4043c.length) {
                int n = C1256e.m5912c(pos + 1);
                long[] nkeys = new long[n];
                Object[] nvalues = new Object[n];
                long[] jArr = this.f4043c;
                System.arraycopy(jArr, 0, nkeys, 0, jArr.length);
                Object[] objArr = this.f4044d;
                System.arraycopy(objArr, 0, nvalues, 0, objArr.length);
                this.f4043c = nkeys;
                this.f4044d = nvalues;
            }
            this.f4043c[pos] = key;
            this.f4044d[pos] = value;
            this.f4045e = pos + 1;
            return;
        }
        mo9063c(key, value);
    }

    public String toString() {
        if (mo9057b() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f4045e * 28);
        buffer.append('{');
        for (int i = 0; i < this.f4045e; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append(mo9053a(i));
            buffer.append('=');
            Object value = mo9062c(i);
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
