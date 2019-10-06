package com.bumptech.glide.load.engine.p120a;

import com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry;
import com.bumptech.glide.load.engine.p120a.C6263m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.a.h */
/* compiled from: GroupedLinkedMap */
class C6253h<K extends C6263m, V> {

    /* renamed from: a */
    private final C6254a<K, V> f11057a = new C6254a<>();

    /* renamed from: b */
    private final Map<K, C6254a<K, V>> f11058b = new HashMap();

    /* renamed from: com.bumptech.glide.load.engine.a.h$a */
    /* compiled from: GroupedLinkedMap */
    private static class C6254a<K, V> {

        /* renamed from: a */
        final K f11059a;

        /* renamed from: b */
        private List<V> f11060b;

        /* renamed from: c */
        C6254a<K, V> f11061c;

        /* renamed from: d */
        C6254a<K, V> f11062d;

        C6254a() {
            this(null);
        }

        C6254a(K key) {
            this.f11062d = this;
            this.f11061c = this;
            this.f11059a = key;
        }

        /* renamed from: a */
        public V mo19157a() {
            int valueSize = mo19159b();
            if (valueSize > 0) {
                return this.f11060b.remove(valueSize - 1);
            }
            return null;
        }

        /* renamed from: b */
        public int mo19159b() {
            List<V> list = this.f11060b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* renamed from: a */
        public void mo19158a(V value) {
            if (this.f11060b == null) {
                this.f11060b = new ArrayList();
            }
            this.f11060b.add(value);
        }
    }

    C6253h() {
    }

    /* renamed from: a */
    public void mo19155a(K key, V value) {
        C6254a aVar = (C6254a) this.f11058b.get(key);
        if (aVar == null) {
            aVar = new C6254a(key);
            m11956b(aVar);
            this.f11058b.put(key, aVar);
        } else {
            key.mo19139a();
        }
        aVar.mo19158a(value);
    }

    /* renamed from: a */
    public V mo19154a(K key) {
        C6254a aVar = (C6254a) this.f11058b.get(key);
        if (aVar == null) {
            aVar = new C6254a(key);
            this.f11058b.put(key, aVar);
        } else {
            key.mo19139a();
        }
        m11955a(aVar);
        return aVar.mo19157a();
    }

    /* renamed from: a */
    public V mo19153a() {
        for (LinkedEntry<K, V> last = this.f11057a.f11062d; !last.equals(this.f11057a); last = last.f11062d) {
            V removed = last.mo19157a();
            if (removed != null) {
                return removed;
            }
            m11957c(last);
            this.f11058b.remove(last.f11059a);
            ((C6263m) last.f11059a).mo19139a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean hadAtLeastOneItem = false;
        for (LinkedEntry<K, V> current = this.f11057a.f11061c; !current.equals(this.f11057a); current = current.f11061c) {
            hadAtLeastOneItem = true;
            sb.append('{');
            sb.append(current.f11059a);
            sb.append(':');
            sb.append(current.mo19159b());
            sb.append("}, ");
        }
        if (hadAtLeastOneItem) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    /* renamed from: a */
    private void m11955a(C6254a<K, V> entry) {
        m11957c(entry);
        C6254a<K, V> aVar = this.f11057a;
        entry.f11062d = aVar;
        entry.f11061c = aVar.f11061c;
        m11958d(entry);
    }

    /* renamed from: b */
    private void m11956b(C6254a<K, V> entry) {
        m11957c(entry);
        C6254a<K, V> aVar = this.f11057a;
        entry.f11062d = aVar.f11062d;
        entry.f11061c = aVar;
        m11958d(entry);
    }

    /* renamed from: d */
    private static <K, V> void m11958d(C6254a<K, V> entry) {
        entry.f11061c.f11062d = entry;
        entry.f11062d.f11061c = entry;
    }

    /* renamed from: c */
    private static <K, V> void m11957c(C6254a<K, V> entry) {
        C6254a<K, V> aVar = entry.f11062d;
        aVar.f11061c = entry.f11061c;
        entry.f11061c.f11062d = aVar;
    }
}
