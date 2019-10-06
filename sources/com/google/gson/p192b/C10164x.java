package com.google.gson.p192b;

import com.google.gson.internal.LinkedTreeMap.Node;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: com.google.gson.b.x */
/* compiled from: LinkedTreeMap */
public final class C10164x<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a */
    private static final Comparator<Comparable> f30835a = new C10162v();

    /* renamed from: b */
    Comparator<? super K> f30836b;

    /* renamed from: c */
    C10168d<K, V> f30837c;

    /* renamed from: d */
    int f30838d;

    /* renamed from: e */
    int f30839e;

    /* renamed from: f */
    final C10168d<K, V> f30840f;

    /* renamed from: g */
    private C10165a f30841g;

    /* renamed from: h */
    private C10166b f30842h;

    /* renamed from: com.google.gson.b.x$a */
    /* compiled from: LinkedTreeMap */
    class C10165a extends AbstractSet<Entry<K, V>> {
        C10165a() {
        }

        public int size() {
            return C10164x.this.f30838d;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C10163w(this);
        }

        public boolean contains(Object o) {
            return (o instanceof Entry) && C10164x.this.mo33387a((Entry) o) != null;
        }

        public boolean remove(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Node<K, V> node = C10164x.this.mo33387a((Entry) o);
            if (node == null) {
                return false;
            }
            C10164x.this.mo33388a((C10168d<K, V>) node, true);
            return true;
        }

        public void clear() {
            C10164x.this.clear();
        }
    }

    /* renamed from: com.google.gson.b.x$b */
    /* compiled from: LinkedTreeMap */
    final class C10166b extends AbstractSet<K> {
        C10166b() {
        }

        public int size() {
            return C10164x.this.f30838d;
        }

        public Iterator<K> iterator() {
            return new C10169y(this);
        }

        public boolean contains(Object o) {
            return C10164x.this.containsKey(o);
        }

        public boolean remove(Object key) {
            return C10164x.this.mo33389b(key) != null;
        }

        public void clear() {
            C10164x.this.clear();
        }
    }

    /* renamed from: com.google.gson.b.x$c */
    /* compiled from: LinkedTreeMap */
    private abstract class C10167c<T> implements Iterator<T> {

        /* renamed from: a */
        C10168d<K, V> f30845a;

        /* renamed from: b */
        C10168d<K, V> f30846b = null;

        /* renamed from: c */
        int f30847c;

        C10167c() {
            C10164x xVar = C10164x.this;
            this.f30845a = xVar.f30840f.f30852d;
            this.f30847c = xVar.f30839e;
        }

        public final boolean hasNext() {
            return this.f30845a != C10164x.this.f30840f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final C10168d<K, V> mo33408a() {
            Node<K, V> e = this.f30845a;
            C10164x xVar = C10164x.this;
            if (e == xVar.f30840f) {
                throw new NoSuchElementException();
            } else if (xVar.f30839e == this.f30847c) {
                this.f30845a = e.f30852d;
                this.f30846b = e;
                return e;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            C10168d<K, V> dVar = this.f30846b;
            if (dVar != null) {
                C10164x.this.mo33388a(dVar, true);
                this.f30846b = null;
                this.f30847c = C10164x.this.f30839e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.google.gson.b.x$d */
    /* compiled from: LinkedTreeMap */
    static final class C10168d<K, V> implements Entry<K, V> {

        /* renamed from: a */
        C10168d<K, V> f30849a;

        /* renamed from: b */
        C10168d<K, V> f30850b;

        /* renamed from: c */
        C10168d<K, V> f30851c;

        /* renamed from: d */
        C10168d<K, V> f30852d;

        /* renamed from: e */
        C10168d<K, V> f30853e;

        /* renamed from: f */
        final K f30854f;

        /* renamed from: g */
        V f30855g;

        /* renamed from: h */
        int f30856h;

        C10168d() {
            this.f30854f = null;
            this.f30853e = this;
            this.f30852d = this;
        }

        C10168d(C10168d<K, V> parent, K key, C10168d<K, V> next, C10168d<K, V> prev) {
            this.f30849a = parent;
            this.f30854f = key;
            this.f30856h = 1;
            this.f30852d = next;
            this.f30853e = prev;
            prev.f30852d = this;
            next.f30853e = this;
        }

        public K getKey() {
            return this.f30854f;
        }

        public V getValue() {
            return this.f30855g;
        }

        public V setValue(V value) {
            V oldValue = this.f30855g;
            this.f30855g = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            boolean z = false;
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry other = (Entry) o;
            K k = this.f30854f;
            if (k != null ? k.equals(other.getKey()) : other.getKey() == null) {
                V v = this.f30855g;
                if (v != null ? v.equals(other.getValue()) : other.getValue() == null) {
                    z = true;
                }
            }
            return z;
        }

        public int hashCode() {
            K k = this.f30854f;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f30855g;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f30854f);
            sb.append("=");
            sb.append(this.f30855g);
            return sb.toString();
        }

        /* renamed from: a */
        public C10168d<K, V> mo33411a() {
            C10168d dVar = this;
            C10168d<K, V> dVar2 = dVar.f30850b;
            while (dVar2 != null) {
                dVar = dVar2;
                dVar2 = dVar.f30850b;
            }
            return dVar;
        }

        /* renamed from: b */
        public C10168d<K, V> mo33412b() {
            C10168d dVar = this;
            C10168d<K, V> dVar2 = dVar.f30851c;
            while (dVar2 != null) {
                dVar = dVar2;
                dVar2 = dVar.f30851c;
            }
            return dVar;
        }
    }

    public C10164x() {
        this(f30835a);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Comparator<? super K>, code=java.util.Comparator, for r2v0, types: [java.util.Comparator<? super K>, java.util.Comparator] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C10164x(java.util.Comparator r2) {
        /*
            r1 = this;
            r1.<init>()
            r0 = 0
            r1.f30838d = r0
            r1.f30839e = r0
            com.google.gson.b.x$d r0 = new com.google.gson.b.x$d
            r0.<init>()
            r1.f30840f = r0
            if (r2 == 0) goto L_0x0013
            r0 = r2
            goto L_0x0015
        L_0x0013:
            java.util.Comparator<java.lang.Comparable> r0 = f30835a
        L_0x0015:
            r1.f30836b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p192b.C10164x.<init>(java.util.Comparator):void");
    }

    public int size() {
        return this.f30838d;
    }

    public V get(Object key) {
        Node<K, V> node = mo33385a(key);
        if (node != null) {
            return node.f30855g;
        }
        return null;
    }

    public boolean containsKey(Object key) {
        return mo33385a(key) != null;
    }

    public V put(K key, V value) {
        if (key != null) {
            Node<K, V> created = mo33386a(key, true);
            V result = created.f30855g;
            created.f30855g = value;
            return result;
        }
        throw new NullPointerException("key == null");
    }

    public void clear() {
        this.f30837c = null;
        this.f30838d = 0;
        this.f30839e++;
        Node<K, V> header = this.f30840f;
        header.f30853e = header;
        header.f30852d = header;
    }

    public V remove(Object key) {
        Node<K, V> node = mo33389b(key);
        if (node != null) {
            return node.f30855g;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10168d<K, V> mo33386a(K key, boolean create) {
        Node<K, V> created;
        int i;
        Comparator<? super K> comparator = this.f30836b;
        C10168d<K, V> dVar = this.f30837c;
        int comparison = 0;
        if (dVar != null) {
            Comparable comparable = comparator == f30835a ? (Comparable) key : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(dVar.f30854f);
                } else {
                    i = comparator.compare(key, dVar.f30854f);
                }
                comparison = i;
                if (comparison == 0) {
                    return dVar;
                }
                C10168d<K, V> dVar2 = comparison < 0 ? dVar.f30850b : dVar.f30851c;
                if (dVar2 == null) {
                    break;
                }
                dVar = dVar2;
            }
        }
        if (!create) {
            return null;
        }
        Node<K, V> header = this.f30840f;
        if (dVar != null) {
            created = new C10168d<>(dVar, key, header, header.f30853e);
            if (comparison < 0) {
                dVar.f30850b = created;
            } else {
                dVar.f30851c = created;
            }
            m33109b(dVar, true);
        } else if (comparator != f30835a || (key instanceof Comparable)) {
            created = new C10168d<>(dVar, key, header, header.f30853e);
            this.f30837c = created;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(key.getClass().getName());
            sb.append(" is not Comparable");
            throw new ClassCastException(sb.toString());
        }
        this.f30838d++;
        this.f30839e++;
        return created;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10168d<K, V> mo33385a(Object key) {
        C10168d<K, V> dVar = null;
        if (key != null) {
            try {
                dVar = mo33386a((K) key, false);
            } catch (ClassCastException e) {
                return null;
            }
        }
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10168d<K, V> mo33387a(Entry<?, ?> entry) {
        C10168d a = mo33385a(entry.getKey());
        if (a != null && m33107a((Object) a.f30855g, entry.getValue())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m33107a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33388a(C10168d<K, V> node, boolean unlink) {
        if (unlink) {
            C10168d<K, V> dVar = node.f30853e;
            dVar.f30852d = node.f30852d;
            node.f30852d.f30853e = dVar;
        }
        Node<K, V> left = node.f30850b;
        Node<K, V> right = node.f30851c;
        Node<K, V> originalParent = node.f30849a;
        if (left == null || right == null) {
            if (left != null) {
                m33106a(node, (C10168d<K, V>) left);
                node.f30850b = null;
            } else if (right != null) {
                m33106a(node, (C10168d<K, V>) right);
                node.f30851c = null;
            } else {
                m33106a(node, null);
            }
            m33109b(originalParent, false);
            this.f30838d--;
            this.f30839e++;
            return;
        }
        Node<K, V> adjacent = left.f30856h > right.f30856h ? left.mo33412b() : right.mo33411a();
        mo33388a((C10168d<K, V>) adjacent, false);
        int leftHeight = 0;
        Node<K, V> left2 = node.f30850b;
        if (left2 != null) {
            leftHeight = left2.f30856h;
            adjacent.f30850b = left2;
            left2.f30849a = adjacent;
            node.f30850b = null;
        }
        int rightHeight = 0;
        Node<K, V> right2 = node.f30851c;
        if (right2 != null) {
            rightHeight = right2.f30856h;
            adjacent.f30851c = right2;
            right2.f30849a = adjacent;
            node.f30851c = null;
        }
        adjacent.f30856h = Math.max(leftHeight, rightHeight) + 1;
        m33106a(node, (C10168d<K, V>) adjacent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C10168d<K, V> mo33389b(Object key) {
        Node<K, V> node = mo33385a(key);
        if (node != null) {
            mo33388a((C10168d<K, V>) node, true);
        }
        return node;
    }

    /* renamed from: a */
    private void m33106a(C10168d<K, V> node, C10168d<K, V> replacement) {
        Node<K, V> parent = node.f30849a;
        node.f30849a = null;
        if (replacement != null) {
            replacement.f30849a = parent;
        }
        if (parent == null) {
            this.f30837c = replacement;
        } else if (parent.f30850b == node) {
            parent.f30850b = replacement;
        } else {
            parent.f30851c = replacement;
        }
    }

    /* renamed from: b */
    private void m33109b(C10168d<K, V> unbalanced, boolean insert) {
        for (C10168d<K, V> dVar = unbalanced; dVar != null; dVar = dVar.f30849a) {
            Node<K, V> left = dVar.f30850b;
            Node<K, V> right = dVar.f30851c;
            int rightLeftHeight = 0;
            int leftHeight = left != null ? left.f30856h : 0;
            int rightHeight = right != null ? right.f30856h : 0;
            int delta = leftHeight - rightHeight;
            if (delta == -2) {
                Node<K, V> rightLeft = right.f30850b;
                Node<K, V> rightRight = right.f30851c;
                int rightRightHeight = rightRight != null ? rightRight.f30856h : 0;
                if (rightLeft != null) {
                    rightLeftHeight = rightLeft.f30856h;
                }
                int rightDelta = rightLeftHeight - rightRightHeight;
                if (rightDelta == -1 || (rightDelta == 0 && !insert)) {
                    m33105a(dVar);
                } else {
                    m33108b((C10168d<K, V>) right);
                    m33105a(dVar);
                }
                if (insert) {
                    return;
                }
            } else if (delta == 2) {
                Node<K, V> leftLeft = left.f30850b;
                Node<K, V> leftRight = left.f30851c;
                int leftRightHeight = leftRight != null ? leftRight.f30856h : 0;
                if (leftLeft != null) {
                    rightLeftHeight = leftLeft.f30856h;
                }
                int leftDelta = rightLeftHeight - leftRightHeight;
                if (leftDelta == 1 || (leftDelta == 0 && !insert)) {
                    m33108b(dVar);
                } else {
                    m33105a((C10168d<K, V>) left);
                    m33108b(dVar);
                }
                if (insert) {
                    return;
                }
            } else if (delta == 0) {
                dVar.f30856h = leftHeight + 1;
                if (insert) {
                    return;
                }
            } else {
                dVar.f30856h = Math.max(leftHeight, rightHeight) + 1;
                if (!insert) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m33105a(C10168d<K, V> root) {
        Node<K, V> left = root.f30850b;
        Node<K, V> pivot = root.f30851c;
        Node<K, V> pivotLeft = pivot.f30850b;
        Node<K, V> pivotRight = pivot.f30851c;
        root.f30851c = pivotLeft;
        if (pivotLeft != null) {
            pivotLeft.f30849a = root;
        }
        m33106a(root, (C10168d<K, V>) pivot);
        pivot.f30850b = root;
        root.f30849a = pivot;
        int i = 0;
        root.f30856h = Math.max(left != null ? left.f30856h : 0, pivotLeft != null ? pivotLeft.f30856h : 0) + 1;
        int i2 = root.f30856h;
        if (pivotRight != null) {
            i = pivotRight.f30856h;
        }
        pivot.f30856h = Math.max(i2, i) + 1;
    }

    /* renamed from: b */
    private void m33108b(C10168d<K, V> root) {
        Node<K, V> pivot = root.f30850b;
        Node<K, V> right = root.f30851c;
        Node<K, V> pivotLeft = pivot.f30850b;
        Node<K, V> pivotRight = pivot.f30851c;
        root.f30850b = pivotRight;
        if (pivotRight != null) {
            pivotRight.f30849a = root;
        }
        m33106a(root, (C10168d<K, V>) pivot);
        pivot.f30851c = root;
        root.f30849a = pivot;
        int i = 0;
        root.f30856h = Math.max(right != null ? right.f30856h : 0, pivotRight != null ? pivotRight.f30856h : 0) + 1;
        int i2 = root.f30856h;
        if (pivotLeft != null) {
            i = pivotLeft.f30856h;
        }
        pivot.f30856h = Math.max(i2, i) + 1;
    }

    public Set<Entry<K, V>> entrySet() {
        C10165a aVar = this.f30841g;
        if (aVar != null) {
            return aVar;
        }
        C10165a aVar2 = new C10165a<>();
        this.f30841g = aVar2;
        return aVar2;
    }

    public Set<K> keySet() {
        C10166b bVar = this.f30842h;
        if (bVar != null) {
            return bVar;
        }
        C10166b bVar2 = new C10166b<>();
        this.f30842h = bVar2;
        return bVar2;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
