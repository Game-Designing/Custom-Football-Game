package p002b.p003c.p053g.p061f;

import android.support.v4.util.SimpleArrayMap;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: b.c.g.f.q */
/* compiled from: SimpleArrayMap */
public class C1273q<K, V> {

    /* renamed from: a */
    static Object[] f4074a;

    /* renamed from: b */
    static int f4075b;

    /* renamed from: c */
    static Object[] f4076c;

    /* renamed from: d */
    static int f4077d;

    /* renamed from: e */
    int[] f4078e;

    /* renamed from: f */
    Object[] f4079f;

    /* renamed from: g */
    int f4080g;

    /* renamed from: a */
    private static int m5960a(int[] hashes, int N, int hash) {
        try {
            return C1256e.m5908a(hashes, N, hash);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo9152a(Object key, int hash) {
        int N = this.f4080g;
        if (N == 0) {
            return -1;
        }
        int index = m5960a(this.f4078e, N, hash);
        if (index < 0 || key.equals(this.f4079f[index << 1])) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f4078e[end] == hash) {
            if (key.equals(this.f4079f[end << 1])) {
                return end;
            }
            end++;
        }
        int i = index - 1;
        while (i >= 0 && this.f4078e[i] == hash) {
            if (key.equals(this.f4079f[i << 1])) {
                return i;
            }
            i--;
        }
        return end ^ -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo9150a() {
        int N = this.f4080g;
        if (N == 0) {
            return -1;
        }
        int index = m5960a(this.f4078e, N, 0);
        if (index < 0 || this.f4079f[index << 1] == null) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f4078e[end] == 0) {
            if (this.f4079f[end << 1] == null) {
                return end;
            }
            end++;
        }
        int i = index - 1;
        while (i >= 0 && this.f4078e[i] == 0) {
            if (this.f4079f[i << 1] == null) {
                return i;
            }
            i--;
        }
        return end ^ -1;
    }

    /* renamed from: e */
    private void m5962e(int size) {
        if (size == 8) {
            synchronized (C1253b.class) {
                if (f4076c != null) {
                    Object[] array = f4076c;
                    this.f4079f = array;
                    f4076c = (Object[]) array[0];
                    this.f4078e = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    f4077d--;
                    return;
                }
            }
        } else if (size == 4) {
            synchronized (C1253b.class) {
                if (f4074a != null) {
                    Object[] array2 = f4074a;
                    this.f4079f = array2;
                    f4074a = (Object[]) array2[0];
                    this.f4078e = (int[]) array2[1];
                    array2[1] = null;
                    array2[0] = null;
                    f4075b--;
                    return;
                }
            }
        }
        this.f4078e = new int[size];
        this.f4079f = new Object[(size << 1)];
    }

    /* renamed from: a */
    private static void m5961a(int[] hashes, Object[] array, int size) {
        if (hashes.length == 8) {
            synchronized (C1253b.class) {
                if (f4077d < 10) {
                    array[0] = f4076c;
                    array[1] = hashes;
                    for (int i = (size << 1) - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    f4076c = array;
                    f4077d++;
                }
            }
        } else if (hashes.length == 4) {
            synchronized (C1253b.class) {
                if (f4075b < 10) {
                    array[0] = f4074a;
                    array[1] = hashes;
                    for (int i2 = (size << 1) - 1; i2 >= 2; i2--) {
                        array[i2] = null;
                    }
                    f4074a = array;
                    f4075b++;
                }
            }
        }
    }

    public C1273q() {
        this.f4078e = C1256e.f4036a;
        this.f4079f = C1256e.f4038c;
        this.f4080g = 0;
    }

    public C1273q(int capacity) {
        if (capacity == 0) {
            this.f4078e = C1256e.f4036a;
            this.f4079f = C1256e.f4038c;
        } else {
            m5962e(capacity);
        }
        this.f4080g = 0;
    }

    public C1273q(C1273q<K, V> map) {
        this();
        if (map != null) {
            mo9155a(map);
        }
    }

    public void clear() {
        if (this.f4080g > 0) {
            int[] ohashes = this.f4078e;
            Object[] oarray = this.f4079f;
            int osize = this.f4080g;
            this.f4078e = C1256e.f4036a;
            this.f4079f = C1256e.f4038c;
            this.f4080g = 0;
            m5961a(ohashes, oarray, osize);
        }
        if (this.f4080g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    public void mo9154a(int minimumCapacity) {
        int osize = this.f4080g;
        if (this.f4078e.length < minimumCapacity) {
            int[] ohashes = this.f4078e;
            Object[] oarray = this.f4079f;
            m5962e(minimumCapacity);
            if (this.f4080g > 0) {
                System.arraycopy(ohashes, 0, this.f4078e, 0, osize);
                System.arraycopy(oarray, 0, this.f4079f, 0, osize << 1);
            }
            m5961a(ohashes, oarray, osize);
        }
        if (this.f4080g != osize) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object key) {
        return mo9151a(key) >= 0;
    }

    /* renamed from: a */
    public int mo9151a(Object key) {
        return key == null ? mo9150a() : mo9152a(key, key.hashCode());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo9156b(Object value) {
        int N = this.f4080g * 2;
        Object[] array = this.f4079f;
        if (value == null) {
            for (int i = 1; i < N; i += 2) {
                if (array[i] == null) {
                    return i >> 1;
                }
            }
        } else {
            for (int i2 = 1; i2 < N; i2 += 2) {
                if (value.equals(array[i2])) {
                    return i2 >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object value) {
        return mo9156b(value) >= 0;
    }

    public V get(Object key) {
        int index = mo9151a(key);
        if (index >= 0) {
            return this.f4079f[(index << 1) + 1];
        }
        return null;
    }

    /* renamed from: b */
    public K mo9157b(int index) {
        return this.f4079f[index << 1];
    }

    /* renamed from: d */
    public V mo9162d(int index) {
        return this.f4079f[(index << 1) + 1];
    }

    /* renamed from: a */
    public V mo9153a(int index, V value) {
        int index2 = (index << 1) + 1;
        V[] vArr = this.f4079f;
        V old = vArr[index2];
        vArr[index2] = value;
        return old;
    }

    public boolean isEmpty() {
        return this.f4080g <= 0;
    }

    public V put(K key, V value) {
        int index;
        int hash;
        int osize = this.f4080g;
        if (key == null) {
            hash = 0;
            index = mo9150a();
        } else {
            hash = key.hashCode();
            index = mo9152a((Object) key, hash);
        }
        if (index >= 0) {
            int index2 = (index << 1) + 1;
            V[] vArr = this.f4079f;
            V old = vArr[index2];
            vArr[index2] = value;
            return old;
        }
        int index3 = index ^ -1;
        if (osize >= this.f4078e.length) {
            int n = 4;
            if (osize >= 8) {
                n = (osize >> 1) + osize;
            } else if (osize >= 4) {
                n = 8;
            }
            int[] ohashes = this.f4078e;
            Object[] oarray = this.f4079f;
            m5962e(n);
            if (osize == this.f4080g) {
                int[] iArr = this.f4078e;
                if (iArr.length > 0) {
                    System.arraycopy(ohashes, 0, iArr, 0, ohashes.length);
                    System.arraycopy(oarray, 0, this.f4079f, 0, oarray.length);
                }
                m5961a(ohashes, oarray, osize);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (index3 < osize) {
            int[] iArr2 = this.f4078e;
            System.arraycopy(iArr2, index3, iArr2, index3 + 1, osize - index3);
            Object[] objArr = this.f4079f;
            System.arraycopy(objArr, index3 << 1, objArr, (index3 + 1) << 1, (this.f4080g - index3) << 1);
        }
        int i = this.f4080g;
        if (osize == i) {
            int[] iArr3 = this.f4078e;
            if (index3 < iArr3.length) {
                iArr3[index3] = hash;
                Object[] objArr2 = this.f4079f;
                objArr2[index3 << 1] = key;
                objArr2[(index3 << 1) + 1] = value;
                this.f4080g = i + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    /* renamed from: a */
    public void mo9155a(C1273q<? extends K, ? extends V> array) {
        int N = array.f4080g;
        mo9154a(this.f4080g + N);
        if (this.f4080g != 0) {
            for (int i = 0; i < N; i++) {
                put(array.mo9157b(i), array.mo9162d(i));
            }
        } else if (N > 0) {
            System.arraycopy(array.f4078e, 0, this.f4078e, 0, N);
            System.arraycopy(array.f4079f, 0, this.f4079f, 0, N << 1);
            this.f4080g = N;
        }
    }

    public V remove(Object key) {
        int index = mo9151a(key);
        if (index >= 0) {
            return mo9158c(index);
        }
        return null;
    }

    /* renamed from: c */
    public V mo9158c(int index) {
        int nsize;
        Object[] objArr = this.f4079f;
        Object old = objArr[(index << 1) + 1];
        int osize = this.f4080g;
        if (osize <= 1) {
            m5961a(this.f4078e, objArr, osize);
            this.f4078e = C1256e.f4036a;
            this.f4079f = C1256e.f4038c;
            nsize = 0;
        } else {
            nsize = osize - 1;
            int[] iArr = this.f4078e;
            int i = 8;
            if (iArr.length <= 8 || this.f4080g >= iArr.length / 3) {
                if (index < nsize) {
                    int[] iArr2 = this.f4078e;
                    System.arraycopy(iArr2, index + 1, iArr2, index, nsize - index);
                    Object[] objArr2 = this.f4079f;
                    System.arraycopy(objArr2, (index + 1) << 1, objArr2, index << 1, (nsize - index) << 1);
                }
                Object[] objArr3 = this.f4079f;
                objArr3[nsize << 1] = null;
                objArr3[(nsize << 1) + 1] = null;
            } else {
                if (osize > 8) {
                    i = osize + (osize >> 1);
                }
                int n = i;
                int[] ohashes = this.f4078e;
                Object[] oarray = this.f4079f;
                m5962e(n);
                if (osize == this.f4080g) {
                    if (index > 0) {
                        System.arraycopy(ohashes, 0, this.f4078e, 0, index);
                        System.arraycopy(oarray, 0, this.f4079f, 0, index << 1);
                    }
                    if (index < nsize) {
                        System.arraycopy(ohashes, index + 1, this.f4078e, index, nsize - index);
                        System.arraycopy(oarray, (index + 1) << 1, this.f4079f, index << 1, (nsize - index) << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        }
        if (osize == this.f4080g) {
            this.f4080g = nsize;
            return old;
        }
        throw new ConcurrentModificationException();
    }

    public int size() {
        return this.f4080g;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof C1273q) {
            SimpleArrayMap<?, ?> map = (C1273q) object;
            if (size() != map.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f4080g) {
                try {
                    K key = mo9157b(i);
                    V mine = mo9162d(i);
                    Object theirs = map.get(key);
                    if (mine == null) {
                        if (theirs != null || !map.containsKey(key)) {
                            return false;
                        }
                    } else if (!mine.equals(theirs)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(object instanceof Map)) {
            return false;
        } else {
            Map<?, ?> map2 = (Map) object;
            if (size() != map2.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f4080g) {
                try {
                    K key2 = mo9157b(i2);
                    V mine2 = mo9162d(i2);
                    Object theirs2 = map2.get(key2);
                    if (mine2 == null) {
                        if (theirs2 != null || !map2.containsKey(key2)) {
                            return false;
                        }
                    } else if (!mine2.equals(theirs2)) {
                        return false;
                    }
                    i2++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] hashes = this.f4078e;
        Object[] array = this.f4079f;
        int result = 0;
        int i = 0;
        int v = 1;
        int s = this.f4080g;
        while (i < s) {
            Object value = array[v];
            result += hashes[i] ^ (value == null ? 0 : value.hashCode());
            i++;
            v += 2;
        }
        return result;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f4080g * 28);
        buffer.append('{');
        for (int i = 0; i < this.f4080g; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            Object key = mo9157b(i);
            String str = "(this Map)";
            if (key != this) {
                buffer.append(key);
            } else {
                buffer.append(str);
            }
            buffer.append('=');
            Object value = mo9162d(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append(str);
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}
