package p002b.p003c.p053g.p061f;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: b.c.g.f.b */
/* compiled from: ArrayMap */
public class C1253b<K, V> extends C1273q<K, V> implements Map<K, V> {

    /* renamed from: h */
    C1261j<K, V> f4024h;

    public C1253b() {
    }

    public C1253b(int capacity) {
        super(capacity);
    }

    public C1253b(C1273q map) {
        super(map);
    }

    /* renamed from: b */
    private C1261j<K, V> m5886b() {
        if (this.f4024h == null) {
            this.f4024h = new C1252a(this);
        }
        return this.f4024h;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        mo9154a(this.f4080g + map.size());
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    public boolean mo9025a(Collection<?> collection) {
        return C1261j.m5934c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m5886b().mo9086d();
    }

    public Set<K> keySet() {
        return m5886b().mo9087e();
    }

    public Collection<V> values() {
        return m5886b().mo9088f();
    }
}
