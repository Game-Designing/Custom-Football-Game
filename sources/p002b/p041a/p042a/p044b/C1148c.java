package p002b.p041a.p042a.p044b;

import android.arch.core.internal.SafeIterableMap;
import android.arch.core.internal.SafeIterableMap.DescendingIterator;
import android.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import android.arch.core.internal.SafeIterableMap.ListIterator;
import android.arch.core.internal.SafeIterableMap.SupportRemove;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: b.a.a.b.c */
/* compiled from: SafeIterableMap */
public class C1148c<K, V> implements Iterable<Entry<K, V>> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1151c<K, V> f3801a;

    /* renamed from: b */
    private C1151c<K, V> f3802b;

    /* renamed from: c */
    private WeakHashMap<C1154f<K, V>, Boolean> f3803c = new WeakHashMap<>();

    /* renamed from: d */
    private int f3804d = 0;

    /* renamed from: b.a.a.b.c$a */
    /* compiled from: SafeIterableMap */
    static class C1149a<K, V> extends C1153e<K, V> {
        C1149a(C1151c<K, V> start, C1151c<K, V> expectedEnd) {
            super(start, expectedEnd);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public C1151c<K, V> mo8765c(C1151c<K, V> entry) {
            return entry.f3807c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1151c<K, V> mo8764b(C1151c<K, V> entry) {
            return entry.f3808d;
        }
    }

    /* renamed from: b.a.a.b.c$b */
    /* compiled from: SafeIterableMap */
    private static class C1150b<K, V> extends C1153e<K, V> {
        C1150b(C1151c<K, V> start, C1151c<K, V> expectedEnd) {
            super(start, expectedEnd);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public C1151c<K, V> mo8765c(C1151c<K, V> entry) {
            return entry.f3808d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1151c<K, V> mo8764b(C1151c<K, V> entry) {
            return entry.f3807c;
        }
    }

    /* renamed from: b.a.a.b.c$c */
    /* compiled from: SafeIterableMap */
    static class C1151c<K, V> implements Entry<K, V> {

        /* renamed from: a */
        final K f3805a;

        /* renamed from: b */
        final V f3806b;

        /* renamed from: c */
        C1151c<K, V> f3807c;

        /* renamed from: d */
        C1151c<K, V> f3808d;

        C1151c(K key, V value) {
            this.f3805a = key;
            this.f3806b = value;
        }

        public K getKey() {
            return this.f3805a;
        }

        public V getValue() {
            return this.f3806b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3805a);
            sb.append("=");
            sb.append(this.f3806b);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1151c)) {
                return false;
            }
            C1151c entry = (C1151c) obj;
            if (!this.f3805a.equals(entry.f3805a) || !this.f3806b.equals(entry.f3806b)) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: b.a.a.b.c$d */
    /* compiled from: SafeIterableMap */
    private class C1152d implements Iterator<Entry<K, V>>, C1154f<K, V> {

        /* renamed from: a */
        private C1151c<K, V> f3809a;

        /* renamed from: b */
        private boolean f3810b;

        private C1152d() {
            this.f3810b = true;
        }

        /* renamed from: a */
        public void mo8771a(C1151c<K, V> entry) {
            C1151c<K, V> cVar = this.f3809a;
            if (entry == cVar) {
                this.f3809a = cVar.f3808d;
                this.f3810b = this.f3809a == null;
            }
        }

        public boolean hasNext() {
            boolean z = true;
            if (this.f3810b) {
                if (C1148c.this.f3801a == null) {
                    z = false;
                }
                return z;
            }
            C1151c<K, V> cVar = this.f3809a;
            if (cVar == null || cVar.f3807c == null) {
                z = false;
            }
            return z;
        }

        public Entry<K, V> next() {
            if (this.f3810b) {
                this.f3810b = false;
                this.f3809a = C1148c.this.f3801a;
            } else {
                C1151c<K, V> cVar = this.f3809a;
                this.f3809a = cVar != null ? cVar.f3807c : null;
            }
            return this.f3809a;
        }
    }

    /* renamed from: b.a.a.b.c$e */
    /* compiled from: SafeIterableMap */
    private static abstract class C1153e<K, V> implements Iterator<Entry<K, V>>, C1154f<K, V> {

        /* renamed from: a */
        C1151c<K, V> f3812a;

        /* renamed from: b */
        C1151c<K, V> f3813b;

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public abstract C1151c<K, V> mo8764b(C1151c<K, V> cVar);

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public abstract C1151c<K, V> mo8765c(C1151c<K, V> cVar);

        C1153e(C1151c<K, V> start, C1151c<K, V> expectedEnd) {
            this.f3812a = expectedEnd;
            this.f3813b = start;
        }

        public boolean hasNext() {
            return this.f3813b != null;
        }

        /* renamed from: a */
        public void mo8771a(C1151c<K, V> entry) {
            if (this.f3812a == entry && entry == this.f3813b) {
                this.f3813b = null;
                this.f3812a = null;
            }
            C1151c<K, V> cVar = this.f3812a;
            if (cVar == entry) {
                this.f3812a = mo8764b(cVar);
            }
            if (this.f3813b == entry) {
                this.f3813b = m5626a();
            }
        }

        /* renamed from: a */
        private C1151c<K, V> m5626a() {
            C1151c<K, V> cVar = this.f3813b;
            C1151c<K, V> cVar2 = this.f3812a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return mo8765c(cVar);
        }

        public Entry<K, V> next() {
            Entry<K, V> result = this.f3813b;
            this.f3813b = m5626a();
            return result;
        }
    }

    /* renamed from: b.a.a.b.c$f */
    /* compiled from: SafeIterableMap */
    interface C1154f<K, V> {
        /* renamed from: a */
        void mo8771a(C1151c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1151c<K, V> mo8750a(K k) {
        SafeIterableMap.Entry<K, V> currentNode = this.f3801a;
        while (currentNode != null && !currentNode.f3805a.equals(k)) {
            currentNode = currentNode.f3807c;
        }
        return currentNode;
    }

    /* renamed from: b */
    public V mo8751b(K key, V v) {
        SafeIterableMap.Entry<K, V> entry = mo8750a(key);
        if (entry != null) {
            return entry.f3806b;
        }
        mo8755a(key, v);
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1151c<K, V> mo8755a(K key, V v) {
        SafeIterableMap.Entry<K, V> newEntry = new C1151c<>(key, v);
        this.f3804d++;
        C1151c<K, V> cVar = this.f3802b;
        if (cVar == null) {
            this.f3801a = newEntry;
            this.f3802b = this.f3801a;
            return newEntry;
        }
        cVar.f3807c = newEntry;
        newEntry.f3808d = cVar;
        this.f3802b = newEntry;
        return newEntry;
    }

    public V remove(K key) {
        SafeIterableMap.Entry<K, V> toRemove = mo8750a(key);
        if (toRemove == null) {
            return null;
        }
        this.f3804d--;
        if (!this.f3803c.isEmpty()) {
            for (SupportRemove<K, V> iter : this.f3803c.keySet()) {
                iter.mo8771a(toRemove);
            }
        }
        C1151c<K, V> cVar = toRemove.f3808d;
        if (cVar != null) {
            cVar.f3807c = toRemove.f3807c;
        } else {
            this.f3801a = toRemove.f3807c;
        }
        C1151c<K, V> cVar2 = toRemove.f3807c;
        if (cVar2 != null) {
            cVar2.f3808d = toRemove.f3808d;
        } else {
            this.f3802b = toRemove.f3808d;
        }
        toRemove.f3807c = null;
        toRemove.f3808d = null;
        return toRemove.f3806b;
    }

    public int size() {
        return this.f3804d;
    }

    public Iterator<Entry<K, V>> iterator() {
        ListIterator<K, V> iterator = new C1149a<>(this.f3801a, this.f3802b);
        this.f3803c.put(iterator, Boolean.valueOf(false));
        return iterator;
    }

    public Iterator<Entry<K, V>> descendingIterator() {
        DescendingIterator<K, V> iterator = new C1150b<>(this.f3802b, this.f3801a);
        this.f3803c.put(iterator, Boolean.valueOf(false));
        return iterator;
    }

    /* renamed from: b */
    public C1152d mo8757b() {
        IteratorWithAdditions iterator = new C1152d<>();
        this.f3803c.put(iterator, Boolean.valueOf(false));
        return iterator;
    }

    /* renamed from: a */
    public Entry<K, V> mo8756a() {
        return this.f3801a;
    }

    /* renamed from: c */
    public Entry<K, V> mo8758c() {
        return this.f3802b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1148c)) {
            return false;
        }
        C1148c map = (C1148c) obj;
        if (size() != map.size()) {
            return false;
        }
        Iterator<Entry<K, V>> iterator1 = iterator();
        Iterator iterator2 = map.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            Entry<K, V> next1 = (Entry) iterator1.next();
            Object next2 = iterator2.next();
            if ((next1 == null && next2 != null) || (next1 != null && !next1.equals(next2))) {
                return false;
            }
        }
        if (iterator1.hasNext() || iterator2.hasNext()) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Iterator<Entry<K, V>> iterator = iterator();
        while (iterator.hasNext()) {
            builder.append(((Entry) iterator.next()).toString());
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
