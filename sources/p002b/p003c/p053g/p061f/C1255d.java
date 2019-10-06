package p002b.p003c.p053g.p061f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: b.c.g.f.d */
/* compiled from: ArraySet */
public final class C1255d<E> implements Collection<E>, Set<E> {

    /* renamed from: a */
    private static final int[] f4026a = new int[0];

    /* renamed from: b */
    private static final Object[] f4027b = new Object[0];

    /* renamed from: c */
    private static Object[] f4028c;

    /* renamed from: d */
    private static int f4029d;

    /* renamed from: e */
    private static Object[] f4030e;

    /* renamed from: f */
    private static int f4031f;

    /* renamed from: g */
    private int[] f4032g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Object[] f4033h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f4034i;

    /* renamed from: j */
    private C1261j<E, E> f4035j;

    /* renamed from: a */
    private int m5898a(Object key, int hash) {
        int N = this.f4034i;
        if (N == 0) {
            return -1;
        }
        int index = C1256e.m5908a(this.f4032g, N, hash);
        if (index < 0 || key.equals(this.f4033h[index])) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f4032g[end] == hash) {
            if (key.equals(this.f4033h[end])) {
                return end;
            }
            end++;
        }
        int i = index - 1;
        while (i >= 0 && this.f4032g[i] == hash) {
            if (key.equals(this.f4033h[i])) {
                return i;
            }
            i--;
        }
        return end ^ -1;
    }

    /* renamed from: b */
    private int m5901b() {
        int N = this.f4034i;
        if (N == 0) {
            return -1;
        }
        int index = C1256e.m5908a(this.f4032g, N, 0);
        if (index < 0 || this.f4033h[index] == null) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f4032g[end] == 0) {
            if (this.f4033h[end] == null) {
                return end;
            }
            end++;
        }
        int i = index - 1;
        while (i >= 0 && this.f4032g[i] == 0) {
            if (this.f4033h[i] == null) {
                return i;
            }
            i--;
        }
        return end ^ -1;
    }

    /* renamed from: j */
    private void m5903j(int size) {
        if (size == 8) {
            synchronized (C1255d.class) {
                if (f4030e != null) {
                    Object[] array = f4030e;
                    this.f4033h = array;
                    f4030e = (Object[]) array[0];
                    this.f4032g = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    f4031f--;
                    return;
                }
            }
        } else if (size == 4) {
            synchronized (C1255d.class) {
                if (f4028c != null) {
                    Object[] array2 = f4028c;
                    this.f4033h = array2;
                    f4028c = (Object[]) array2[0];
                    this.f4032g = (int[]) array2[1];
                    array2[1] = null;
                    array2[0] = null;
                    f4029d--;
                    return;
                }
            }
        }
        this.f4032g = new int[size];
        this.f4033h = new Object[size];
    }

    /* renamed from: a */
    private static void m5900a(int[] hashes, Object[] array, int size) {
        if (hashes.length == 8) {
            synchronized (C1255d.class) {
                if (f4031f < 10) {
                    array[0] = f4030e;
                    array[1] = hashes;
                    for (int i = size - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    f4030e = array;
                    f4031f++;
                }
            }
        } else if (hashes.length == 4) {
            synchronized (C1255d.class) {
                if (f4029d < 10) {
                    array[0] = f4028c;
                    array[1] = hashes;
                    for (int i2 = size - 1; i2 >= 2; i2--) {
                        array[i2] = null;
                    }
                    f4028c = array;
                    f4029d++;
                }
            }
        }
    }

    public C1255d() {
        this(0);
    }

    public C1255d(int capacity) {
        if (capacity == 0) {
            this.f4032g = f4026a;
            this.f4033h = f4027b;
        } else {
            m5903j(capacity);
        }
        this.f4034i = 0;
    }

    public void clear() {
        int i = this.f4034i;
        if (i != 0) {
            m5900a(this.f4032g, this.f4033h, i);
            this.f4032g = f4026a;
            this.f4033h = f4027b;
            this.f4034i = 0;
        }
    }

    /* renamed from: a */
    public void mo9030a(int minimumCapacity) {
        if (this.f4032g.length < minimumCapacity) {
            int[] ohashes = this.f4032g;
            Object[] oarray = this.f4033h;
            m5903j(minimumCapacity);
            int i = this.f4034i;
            if (i > 0) {
                System.arraycopy(ohashes, 0, this.f4032g, 0, i);
                System.arraycopy(oarray, 0, this.f4033h, 0, this.f4034i);
            }
            m5900a(ohashes, oarray, this.f4034i);
        }
    }

    public boolean contains(Object key) {
        return indexOf(key) >= 0;
    }

    public int indexOf(Object key) {
        return key == null ? m5901b() : m5898a(key, key.hashCode());
    }

    /* renamed from: i */
    public E mo9039i(int index) {
        return this.f4033h[index];
    }

    public boolean isEmpty() {
        return this.f4034i <= 0;
    }

    public boolean add(E value) {
        int index;
        int hash;
        if (value == null) {
            hash = 0;
            index = m5901b();
        } else {
            hash = value.hashCode();
            index = m5898a(value, hash);
        }
        if (index >= 0) {
            return false;
        }
        int index2 = index ^ -1;
        int i = this.f4034i;
        if (i >= this.f4032g.length) {
            int i2 = 4;
            if (i >= 8) {
                i2 = (i >> 1) + i;
            } else if (i >= 4) {
                i2 = 8;
            }
            int n = i2;
            int[] ohashes = this.f4032g;
            Object[] oarray = this.f4033h;
            m5903j(n);
            int[] iArr = this.f4032g;
            if (iArr.length > 0) {
                System.arraycopy(ohashes, 0, iArr, 0, ohashes.length);
                System.arraycopy(oarray, 0, this.f4033h, 0, oarray.length);
            }
            m5900a(ohashes, oarray, this.f4034i);
        }
        int i3 = this.f4034i;
        if (index2 < i3) {
            int[] iArr2 = this.f4032g;
            System.arraycopy(iArr2, index2, iArr2, index2 + 1, i3 - index2);
            Object[] objArr = this.f4033h;
            System.arraycopy(objArr, index2, objArr, index2 + 1, this.f4034i - index2);
        }
        this.f4032g[index2] = hash;
        this.f4033h[index2] = value;
        this.f4034i++;
        return true;
    }

    public boolean remove(Object object) {
        int index = indexOf(object);
        if (index < 0) {
            return false;
        }
        mo9037h(index);
        return true;
    }

    /* renamed from: h */
    public E mo9037h(int index) {
        Object[] objArr = this.f4033h;
        Object old = objArr[index];
        int i = this.f4034i;
        if (i <= 1) {
            m5900a(this.f4032g, objArr, i);
            this.f4032g = f4026a;
            this.f4033h = f4027b;
            this.f4034i = 0;
        } else {
            int[] iArr = this.f4032g;
            int i2 = 8;
            if (iArr.length <= 8 || i >= iArr.length / 3) {
                this.f4034i--;
                int i3 = this.f4034i;
                if (index < i3) {
                    int[] iArr2 = this.f4032g;
                    System.arraycopy(iArr2, index + 1, iArr2, index, i3 - index);
                    Object[] objArr2 = this.f4033h;
                    System.arraycopy(objArr2, index + 1, objArr2, index, this.f4034i - index);
                }
                this.f4033h[this.f4034i] = null;
            } else {
                if (i > 8) {
                    i2 = i + (i >> 1);
                }
                int n = i2;
                int[] ohashes = this.f4032g;
                Object[] oarray = this.f4033h;
                m5903j(n);
                this.f4034i--;
                if (index > 0) {
                    System.arraycopy(ohashes, 0, this.f4032g, 0, index);
                    System.arraycopy(oarray, 0, this.f4033h, 0, index);
                }
                int i4 = this.f4034i;
                if (index < i4) {
                    System.arraycopy(ohashes, index + 1, this.f4032g, index, i4 - index);
                    System.arraycopy(oarray, index + 1, this.f4033h, index, this.f4034i - index);
                }
            }
        }
        return old;
    }

    public int size() {
        return this.f4034i;
    }

    public Object[] toArray() {
        int i = this.f4034i;
        Object[] result = new Object[i];
        System.arraycopy(this.f4033h, 0, result, 0, i);
        return result;
    }

    public <T> T[] toArray(T[] array) {
        if (array.length < this.f4034i) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), this.f4034i);
        }
        System.arraycopy(this.f4033h, 0, array, 0, this.f4034i);
        int length = array.length;
        int i = this.f4034i;
        if (length > i) {
            array[i] = null;
        }
        return array;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> set = (Set) object;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f4034i) {
            try {
                if (!set.contains(mo9039i(i))) {
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
    }

    public int hashCode() {
        int[] hashes = this.f4032g;
        int result = 0;
        for (int i = 0; i < this.f4034i; i++) {
            result += hashes[i];
        }
        return result;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f4034i * 14);
        buffer.append('{');
        for (int i = 0; i < this.f4034i; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            Object value = mo9039i(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Set)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }

    /* renamed from: a */
    private C1261j<E, E> m5899a() {
        if (this.f4035j == null) {
            this.f4035j = new C1254c(this);
        }
        return this.f4035j;
    }

    public Iterator<E> iterator() {
        return m5899a().mo9087e().iterator();
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        mo9030a(this.f4034i + collection.size());
        boolean added = false;
        for (E value : collection) {
            added |= add(value);
        }
        return added;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removed = false;
        for (Object value : collection) {
            removed |= remove(value);
        }
        return removed;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean removed = false;
        for (int i = this.f4034i - 1; i >= 0; i--) {
            if (!collection.contains(this.f4033h[i])) {
                mo9037h(i);
                removed = true;
            }
        }
        return removed;
    }
}
