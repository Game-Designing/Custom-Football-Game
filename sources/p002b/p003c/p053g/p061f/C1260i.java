package p002b.p003c.p053g.p061f;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: b.c.g.f.i */
/* compiled from: LruCache */
public class C1260i<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f4046a;

    /* renamed from: b */
    private int f4047b;

    /* renamed from: c */
    private int f4048c;

    /* renamed from: d */
    private int f4049d;

    /* renamed from: e */
    private int f4050e;

    /* renamed from: f */
    private int f4051f;

    /* renamed from: g */
    private int f4052g;

    /* renamed from: h */
    private int f4053h;

    public C1260i(int maxSize) {
        if (maxSize > 0) {
            this.f4048c = maxSize;
            this.f4046a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public void resize(int maxSize) {
        if (maxSize > 0) {
            synchronized (this) {
                this.f4048c = maxSize;
            }
            trimToSize(maxSize);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r2 = mo9067a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r2 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r5.f4050e++;
        r1 = r5.f4046a.put(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r1 == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        r5.f4046a.put(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        r5.f4047b += m5927b(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        if (r1 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        mo9068a(false, r6, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        trimToSize(r5.f4048c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x005a
            monitor-enter(r5)
            r0 = 0
            java.util.LinkedHashMap<K, V> r1 = r5.f4046a     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0014
            int r0 = r5.f4052g     // Catch:{ all -> 0x0058 }
            int r0 = r0 + 1
            r5.f4052g = r0     // Catch:{ all -> 0x0058 }
            monitor-exit(r5)     // Catch:{ all -> 0x0058 }
            return r1
        L_0x0014:
            int r2 = r5.f4053h     // Catch:{ all -> 0x0058 }
            int r2 = r2 + 1
            r5.f4053h = r2     // Catch:{ all -> 0x0058 }
            monitor-exit(r5)     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r5.mo9067a(r6)
            if (r2 != 0) goto L_0x0022
            return r0
        L_0x0022:
            monitor-enter(r5)
            int r0 = r5.f4050e     // Catch:{ all -> 0x004f }
            int r0 = r0 + 1
            r5.f4050e = r0     // Catch:{ all -> 0x004f }
            java.util.LinkedHashMap<K, V> r0 = r5.f4046a     // Catch:{ all -> 0x004f }
            java.lang.Object r0 = r0.put(r6, r2)     // Catch:{ all -> 0x004f }
            r1 = r0
            if (r1 == 0) goto L_0x0038
            java.util.LinkedHashMap<K, V> r0 = r5.f4046a     // Catch:{ all -> 0x004f }
            r0.put(r6, r1)     // Catch:{ all -> 0x004f }
            goto L_0x0041
        L_0x0038:
            int r0 = r5.f4047b     // Catch:{ all -> 0x004f }
            int r3 = r5.m5927b(r6, r2)     // Catch:{ all -> 0x004f }
            int r0 = r0 + r3
            r5.f4047b = r0     // Catch:{ all -> 0x004f }
        L_0x0041:
            monitor-exit(r5)     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x0049
            r0 = 0
            r5.mo9068a(r0, r6, r2, r1)
            return r1
        L_0x0049:
            int r0 = r5.f4048c
            r5.trimToSize(r0)
            return r2
        L_0x004f:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x004f }
            throw r0
        L_0x0052:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0056:
            monitor-exit(r5)     // Catch:{ all -> 0x0058 }
            throw r0
        L_0x0058:
            r0 = move-exception
            goto L_0x0056
        L_0x005a:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "key == null"
            r0.<init>(r1)
            goto L_0x0063
        L_0x0062:
            throw r0
        L_0x0063:
            goto L_0x0062
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p061f.C1260i.get(java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r0 == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        mo9068a(false, r4, r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        trimToSize(r3.f4048c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V put(K r4, V r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0038
            if (r5 == 0) goto L_0x0038
            monitor-enter(r3)
            r0 = 0
            int r1 = r3.f4049d     // Catch:{ all -> 0x0033 }
            int r1 = r1 + 1
            r3.f4049d = r1     // Catch:{ all -> 0x0033 }
            int r1 = r3.f4047b     // Catch:{ all -> 0x0033 }
            int r2 = r3.m5927b(r4, r5)     // Catch:{ all -> 0x0033 }
            int r1 = r1 + r2
            r3.f4047b = r1     // Catch:{ all -> 0x0033 }
            java.util.LinkedHashMap<K, V> r1 = r3.f4046a     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r1.put(r4, r5)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0026
            int r1 = r3.f4047b     // Catch:{ all -> 0x0036 }
            int r2 = r3.m5927b(r4, r0)     // Catch:{ all -> 0x0036 }
            int r1 = r1 - r2
            r3.f4047b = r1     // Catch:{ all -> 0x0036 }
        L_0x0026:
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x002d
            r1 = 0
            r3.mo9068a(r1, r4, r0, r5)
        L_0x002d:
            int r1 = r3.f4048c
            r3.trimToSize(r1)
            return r0
        L_0x0033:
            r1 = move-exception
        L_0x0034:
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            throw r1
        L_0x0036:
            r1 = move-exception
            goto L_0x0034
        L_0x0038:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "key == null || value == null"
            r0.<init>(r1)
            goto L_0x0041
        L_0x0040:
            throw r0
        L_0x0041:
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p061f.C1260i.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        throw new java.lang.IllegalStateException(r3.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0003:
            monitor-enter(r6)
            int r3 = r6.f4047b     // Catch:{ all -> 0x0075 }
            if (r3 < 0) goto L_0x0056
            java.util.LinkedHashMap<K, V> r3 = r6.f4046a     // Catch:{ all -> 0x0075 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0075 }
            if (r3 == 0) goto L_0x0014
            int r3 = r6.f4047b     // Catch:{ all -> 0x0075 }
            if (r3 != 0) goto L_0x0056
        L_0x0014:
            int r3 = r6.f4047b     // Catch:{ all -> 0x0075 }
            if (r3 <= r7) goto L_0x0054
            java.util.LinkedHashMap<K, V> r3 = r6.f4046a     // Catch:{ all -> 0x0075 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0075 }
            if (r3 == 0) goto L_0x0021
            goto L_0x0054
        L_0x0021:
            java.util.LinkedHashMap<K, V> r3 = r6.f4046a     // Catch:{ all -> 0x0075 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x0075 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0075 }
            java.lang.Object r3 = r3.next()     // Catch:{ all -> 0x0075 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0075 }
            java.lang.Object r1 = r3.getKey()     // Catch:{ all -> 0x0075 }
            java.lang.Object r2 = r3.getValue()     // Catch:{ all -> 0x0052 }
            java.util.LinkedHashMap<K, V> r4 = r6.f4046a     // Catch:{ all -> 0x0078 }
            r4.remove(r1)     // Catch:{ all -> 0x0078 }
            int r4 = r6.f4047b     // Catch:{ all -> 0x0078 }
            int r5 = r6.m5927b(r1, r2)     // Catch:{ all -> 0x0078 }
            int r4 = r4 - r5
            r6.f4047b = r4     // Catch:{ all -> 0x0078 }
            int r4 = r6.f4051f     // Catch:{ all -> 0x0078 }
            r5 = 1
            int r4 = r4 + r5
            r6.f4051f = r4     // Catch:{ all -> 0x0078 }
            monitor-exit(r6)     // Catch:{ all -> 0x0078 }
            r6.mo9068a(r5, r1, r2, r0)
            goto L_0x0003
        L_0x0052:
            r0 = move-exception
            goto L_0x0076
        L_0x0054:
            monitor-exit(r6)     // Catch:{ all -> 0x0075 }
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0075 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r3.<init>()     // Catch:{ all -> 0x0075 }
            java.lang.Class r4 = r6.getClass()     // Catch:{ all -> 0x0075 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0075 }
            r3.append(r4)     // Catch:{ all -> 0x0075 }
            java.lang.String r4 = ".sizeOf() is reporting inconsistent results!"
            r3.append(r4)     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0075 }
            r0.<init>(r3)     // Catch:{ all -> 0x0075 }
            throw r0     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            monitor-exit(r6)     // Catch:{ all -> 0x0078 }
            throw r0
        L_0x0078:
            r0 = move-exception
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p061f.C1260i.trimToSize(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        mo9068a(false, r6, r1, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        if (r1 == null) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V remove(K r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0025
            monitor-enter(r5)
            r0 = 0
            java.util.LinkedHashMap<K, V> r1 = r5.f4046a     // Catch:{ all -> 0x001d }
            java.lang.Object r1 = r1.remove(r6)     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x0015
            int r2 = r5.f4047b     // Catch:{ all -> 0x0023 }
            int r3 = r5.m5927b(r6, r1)     // Catch:{ all -> 0x0023 }
            int r2 = r2 - r3
            r5.f4047b = r2     // Catch:{ all -> 0x0023 }
        L_0x0015:
            monitor-exit(r5)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x001c
            r2 = 0
            r5.mo9068a(r2, r6, r1, r0)
        L_0x001c:
            return r1
        L_0x001d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0021:
            monitor-exit(r5)     // Catch:{ all -> 0x0023 }
            throw r0
        L_0x0023:
            r0 = move-exception
            goto L_0x0021
        L_0x0025:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "key == null"
            r0.<init>(r1)
            goto L_0x002e
        L_0x002d:
            throw r0
        L_0x002e:
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p061f.C1260i.remove(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9068a(boolean evicted, K k, V v, V v2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public V mo9067a(K k) {
        return null;
    }

    /* renamed from: b */
    private int m5927b(K key, V value) {
        int result = mo9066a(key, value);
        if (result >= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Negative size: ");
        sb.append(key);
        sb.append("=");
        sb.append(value);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo9066a(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.f4047b;
    }

    public final synchronized int maxSize() {
        return this.f4048c;
    }

    public final synchronized int hitCount() {
        return this.f4052g;
    }

    public final synchronized int missCount() {
        return this.f4053h;
    }

    public final synchronized int createCount() {
        return this.f4050e;
    }

    public final synchronized int putCount() {
        return this.f4049d;
    }

    public final synchronized int evictionCount() {
        return this.f4051f;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.f4046a);
    }

    public final synchronized String toString() {
        int accesses;
        accesses = this.f4052g + this.f4053h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f4048c), Integer.valueOf(this.f4052g), Integer.valueOf(this.f4053h), Integer.valueOf(accesses != 0 ? (this.f4052g * 100) / accesses : 0)});
    }
}
