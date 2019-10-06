package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.ads.Ap */
class C8755Ap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f20464a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<C8902Hp> f20465b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<K, V> f20466c;

    /* renamed from: d */
    private boolean f20467d;

    /* renamed from: e */
    private volatile C8944Jp f20468e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map<K, V> f20469f;

    /* renamed from: g */
    private volatile C8818Dp f20470g;

    /* renamed from: a */
    static <FieldDescriptorType extends zzdnu<FieldDescriptorType>> C8755Ap<FieldDescriptorType, Object> m22284a(int i) {
        return new C8776Bp(i);
    }

    private C8755Ap(int i) {
        this.f20464a = i;
        this.f20465b = Collections.emptyList();
        this.f20466c = Collections.emptyMap();
        this.f20469f = Collections.emptyMap();
    }

    /* renamed from: b */
    public void mo28030b() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f20467d) {
            if (this.f20466c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f20466c);
            }
            this.f20466c = map;
            if (this.f20469f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f20469f);
            }
            this.f20469f = map2;
            this.f20467d = true;
        }
    }

    /* renamed from: a */
    public final boolean mo28028a() {
        return this.f20467d;
    }

    /* renamed from: c */
    public final int mo28031c() {
        return this.f20465b.size();
    }

    /* renamed from: b */
    public final Entry<K, V> mo28029b(int i) {
        return (Entry) this.f20465b.get(i);
    }

    /* renamed from: d */
    public final Iterable<Entry<K, V>> mo28034d() {
        if (this.f20466c.isEmpty()) {
            return C8839Ep.m22491a();
        }
        return this.f20466c.entrySet();
    }

    public int size() {
        return this.f20465b.size() + this.f20466c.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m22283a((K) comparable) >= 0 || this.f20466c.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m22283a((K) comparable);
        if (a >= 0) {
            return ((C8902Hp) this.f20465b.get(a)).getValue();
        }
        return this.f20466c.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        m22291f();
        int a = m22283a(k);
        if (a >= 0) {
            return ((C8902Hp) this.f20465b.get(a)).setValue(v);
        }
        m22291f();
        if (this.f20465b.isEmpty() && !(this.f20465b instanceof ArrayList)) {
            this.f20465b = new ArrayList(this.f20464a);
        }
        int i = -(a + 1);
        if (i >= this.f20464a) {
            return m22292g().put(k, v);
        }
        int size = this.f20465b.size();
        int i2 = this.f20464a;
        if (size == i2) {
            C8902Hp hp = (C8902Hp) this.f20465b.remove(i2 - 1);
            m22292g().put((Comparable) hp.getKey(), hp.getValue());
        }
        this.f20465b.add(i, new C8902Hp(this, k, v));
        return null;
    }

    public void clear() {
        m22291f();
        if (!this.f20465b.isEmpty()) {
            this.f20465b.clear();
        }
        if (!this.f20466c.isEmpty()) {
            this.f20466c.clear();
        }
    }

    public V remove(Object obj) {
        m22291f();
        Comparable comparable = (Comparable) obj;
        int a = m22283a((K) comparable);
        if (a >= 0) {
            return m22288c(a);
        }
        if (this.f20466c.isEmpty()) {
            return null;
        }
        return this.f20466c.remove(comparable);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final V m22288c(int i) {
        m22291f();
        V value = ((C8902Hp) this.f20465b.remove(i)).getValue();
        if (!this.f20466c.isEmpty()) {
            Iterator it = m22292g().entrySet().iterator();
            this.f20465b.add(new C8902Hp(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* renamed from: a */
    private final int m22283a(K k) {
        int size = this.f20465b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) ((C8902Hp) this.f20465b.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) ((C8902Hp) this.f20465b.get(i2)).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.f20468e == null) {
            this.f20468e = new C8944Jp(this, null);
        }
        return this.f20468e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final Set<Entry<K, V>> mo28035e() {
        if (this.f20470g == null) {
            this.f20470g = new C8818Dp(this, null);
        }
        return this.f20470g;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m22291f() {
        if (this.f20467d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: g */
    private final SortedMap<K, V> m22292g() {
        m22291f();
        if (this.f20466c.isEmpty() && !(this.f20466c instanceof TreeMap)) {
            this.f20466c = new TreeMap();
            this.f20469f = ((TreeMap) this.f20466c).descendingMap();
        }
        return (SortedMap) this.f20466c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8755Ap)) {
            return super.equals(obj);
        }
        C8755Ap ap = (C8755Ap) obj;
        int size = size();
        if (size != ap.size()) {
            return false;
        }
        int c = mo28031c();
        if (c != ap.mo28031c()) {
            return entrySet().equals(ap.entrySet());
        }
        for (int i = 0; i < c; i++) {
            if (!mo28029b(i).equals(ap.mo28029b(i))) {
                return false;
            }
        }
        if (c != size) {
            return this.f20466c.equals(ap.f20466c);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < mo28031c(); i2++) {
            i += ((C8902Hp) this.f20465b.get(i2)).hashCode();
        }
        if (this.f20466c.size() > 0) {
            return i + this.f20466c.hashCode();
        }
        return i;
    }

    /* synthetic */ C8755Ap(int i, C8776Bp bp) {
        this(i);
    }
}
