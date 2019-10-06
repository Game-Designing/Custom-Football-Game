package com.google.android.gms.internal.measurement;

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

/* renamed from: com.google.android.gms.internal.measurement.Ia */
class C9912Ia<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f30005a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<C9926Pa> f30006b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<K, V> f30007c;

    /* renamed from: d */
    private boolean f30008d;

    /* renamed from: e */
    private volatile C9929Ra f30009e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map<K, V> f30010f;

    /* renamed from: g */
    private volatile C9918La f30011g;

    /* renamed from: a */
    static <FieldDescriptorType extends zzuh<FieldDescriptorType>> C9912Ia<FieldDescriptorType, Object> m31844a(int i) {
        return new C9914Ja(i);
    }

    private C9912Ia(int i) {
        this.f30005a = i;
        this.f30006b = Collections.emptyList();
        this.f30007c = Collections.emptyMap();
        this.f30010f = Collections.emptyMap();
    }

    /* renamed from: b */
    public void mo32568b() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f30008d) {
            if (this.f30007c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f30007c);
            }
            this.f30007c = map;
            if (this.f30010f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f30010f);
            }
            this.f30010f = map2;
            this.f30008d = true;
        }
    }

    /* renamed from: a */
    public final boolean mo32566a() {
        return this.f30008d;
    }

    /* renamed from: c */
    public final int mo32569c() {
        return this.f30006b.size();
    }

    /* renamed from: b */
    public final Entry<K, V> mo32567b(int i) {
        return (Entry) this.f30006b.get(i);
    }

    /* renamed from: d */
    public final Iterable<Entry<K, V>> mo32572d() {
        if (this.f30007c.isEmpty()) {
            return C9920Ma.m31867a();
        }
        return this.f30007c.entrySet();
    }

    public int size() {
        return this.f30006b.size() + this.f30007c.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m31843a((K) comparable) >= 0 || this.f30007c.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = m31843a((K) comparable);
        if (a >= 0) {
            return ((C9926Pa) this.f30006b.get(a)).getValue();
        }
        return this.f30007c.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        m31851f();
        int a = m31843a(k);
        if (a >= 0) {
            return ((C9926Pa) this.f30006b.get(a)).setValue(v);
        }
        m31851f();
        if (this.f30006b.isEmpty() && !(this.f30006b instanceof ArrayList)) {
            this.f30006b = new ArrayList(this.f30005a);
        }
        int i = -(a + 1);
        if (i >= this.f30005a) {
            return m31852g().put(k, v);
        }
        int size = this.f30006b.size();
        int i2 = this.f30005a;
        if (size == i2) {
            C9926Pa pa = (C9926Pa) this.f30006b.remove(i2 - 1);
            m31852g().put((Comparable) pa.getKey(), pa.getValue());
        }
        this.f30006b.add(i, new C9926Pa(this, k, v));
        return null;
    }

    public void clear() {
        m31851f();
        if (!this.f30006b.isEmpty()) {
            this.f30006b.clear();
        }
        if (!this.f30007c.isEmpty()) {
            this.f30007c.clear();
        }
    }

    public V remove(Object obj) {
        m31851f();
        Comparable comparable = (Comparable) obj;
        int a = m31843a((K) comparable);
        if (a >= 0) {
            return m31848c(a);
        }
        if (this.f30007c.isEmpty()) {
            return null;
        }
        return this.f30007c.remove(comparable);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final V m31848c(int i) {
        m31851f();
        V value = ((C9926Pa) this.f30006b.remove(i)).getValue();
        if (!this.f30007c.isEmpty()) {
            Iterator it = m31852g().entrySet().iterator();
            this.f30006b.add(new C9926Pa(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* renamed from: a */
    private final int m31843a(K k) {
        int size = this.f30006b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) ((C9926Pa) this.f30006b.get(size)).getKey());
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
            int compareTo2 = k.compareTo((Comparable) ((C9926Pa) this.f30006b.get(i2)).getKey());
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
        if (this.f30009e == null) {
            this.f30009e = new C9929Ra(this, null);
        }
        return this.f30009e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final Set<Entry<K, V>> mo32573e() {
        if (this.f30011g == null) {
            this.f30011g = new C9918La(this, null);
        }
        return this.f30011g;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m31851f() {
        if (this.f30008d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: g */
    private final SortedMap<K, V> m31852g() {
        m31851f();
        if (this.f30007c.isEmpty() && !(this.f30007c instanceof TreeMap)) {
            this.f30007c = new TreeMap();
            this.f30010f = ((TreeMap) this.f30007c).descendingMap();
        }
        return (SortedMap) this.f30007c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9912Ia)) {
            return super.equals(obj);
        }
        C9912Ia ia = (C9912Ia) obj;
        int size = size();
        if (size != ia.size()) {
            return false;
        }
        int c = mo32569c();
        if (c != ia.mo32569c()) {
            return entrySet().equals(ia.entrySet());
        }
        for (int i = 0; i < c; i++) {
            if (!mo32567b(i).equals(ia.mo32567b(i))) {
                return false;
            }
        }
        if (c != size) {
            return this.f30007c.equals(ia.f30007c);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < mo32569c(); i2++) {
            i += ((C9926Pa) this.f30006b.get(i2)).hashCode();
        }
        if (this.f30007c.size() > 0) {
            return i + this.f30007c.hashCode();
        }
        return i;
    }

    /* synthetic */ C9912Ia(int i, C9914Ja ja) {
        this(i);
    }
}
