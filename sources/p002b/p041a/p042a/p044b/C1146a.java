package p002b.p041a.p042a.p044b;

import android.arch.core.internal.SafeIterableMap.Entry;
import java.util.HashMap;
import java.util.Map;

/* renamed from: b.a.a.b.a */
/* compiled from: FastSafeIterableMap */
public class C1146a<K, V> extends C1148c<K, V> {

    /* renamed from: e */
    private HashMap<K, C1151c<K, V>> f3800e = new HashMap<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1151c<K, V> mo8750a(K k) {
        return (C1151c) this.f3800e.get(k);
    }

    /* renamed from: b */
    public V mo8751b(K key, V v) {
        Entry<K, V> current = mo8750a(key);
        if (current != null) {
            return current.f3806b;
        }
        this.f3800e.put(key, mo8755a(key, v));
        return null;
    }

    public V remove(K key) {
        V removed = super.remove(key);
        this.f3800e.remove(key);
        return removed;
    }

    public boolean contains(K key) {
        return this.f3800e.containsKey(key);
    }

    /* renamed from: b */
    public Map.Entry<K, V> mo8752b(K k) {
        if (contains(k)) {
            return ((C1151c) this.f3800e.get(k)).f3808d;
        }
        return null;
    }
}
