package p026rx.p400f;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: rx.f.x */
/* compiled from: RxJavaPlugins */
public class C14953x {

    /* renamed from: a */
    private static final C14953x f44274a = new C14953x();

    /* renamed from: b */
    static final C14931b f44275b = new C14951v();

    /* renamed from: c */
    private final AtomicReference<C14931b> f44276c = new AtomicReference<>();

    /* renamed from: d */
    private final AtomicReference<C14949t> f44277d = new AtomicReference<>();

    /* renamed from: e */
    private final AtomicReference<C14955z> f44278e = new AtomicReference<>();

    /* renamed from: f */
    private final AtomicReference<C14930a> f44279f = new AtomicReference<>();

    /* renamed from: g */
    private final AtomicReference<C14954y> f44280g = new AtomicReference<>();

    @Deprecated
    /* renamed from: c */
    public static C14953x m46727c() {
        return f44274a;
    }

    C14953x() {
    }

    /* renamed from: b */
    public C14931b mo46162b() {
        if (this.f44276c.get() == null) {
            Object impl = m46726a(C14931b.class, System.getProperties());
            if (impl == null) {
                this.f44276c.compareAndSet(null, f44275b);
            } else {
                this.f44276c.compareAndSet(null, (C14931b) impl);
            }
        }
        return (C14931b) this.f44276c.get();
    }

    /* renamed from: d */
    public C14949t mo46163d() {
        if (this.f44277d.get() == null) {
            Object impl = m46726a(C14949t.class, System.getProperties());
            if (impl == null) {
                this.f44277d.compareAndSet(null, C14950u.m46725a());
            } else {
                this.f44277d.compareAndSet(null, (C14949t) impl);
            }
        }
        return (C14949t) this.f44277d.get();
    }

    /* renamed from: f */
    public C14955z mo46165f() {
        if (this.f44278e.get() == null) {
            Object impl = m46726a(C14955z.class, System.getProperties());
            if (impl == null) {
                this.f44278e.compareAndSet(null, C14929A.m46680a());
            } else {
                this.f44278e.compareAndSet(null, (C14955z) impl);
            }
        }
        return (C14955z) this.f44278e.get();
    }

    /* renamed from: a */
    public C14930a mo46161a() {
        if (this.f44279f.get() == null) {
            Object impl = m46726a(C14930a.class, System.getProperties());
            if (impl == null) {
                this.f44279f.compareAndSet(null, new C14952w(this));
            } else {
                this.f44279f.compareAndSet(null, (C14930a) impl);
            }
        }
        return (C14930a) this.f44279f.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b4 A[SYNTHETIC, Splitter:B:18:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0148  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Object m46726a(java.lang.Class<?> r16, java.util.Properties r17) {
        /*
            java.lang.Object r0 = r17.clone()
            r1 = r0
            java.util.Properties r1 = (java.util.Properties) r1
            java.lang.String r2 = r16.getSimpleName()
            java.lang.String r3 = "rxjava.plugin."
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r2)
            java.lang.String r4 = ".implementation"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = r1.getProperty(r4)
            if (r0 != 0) goto L_0x00b1
            java.lang.String r5 = ".class"
            java.lang.String r6 = ".impl"
            java.util.Set r7 = r1.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0033:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00b1
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r9 = r8.getKey()
            java.lang.String r9 = r9.toString()
            boolean r10 = r9.startsWith(r3)
            if (r10 == 0) goto L_0x00b0
            boolean r10 = r9.endsWith(r5)
            if (r10 == 0) goto L_0x00b0
            java.lang.Object r10 = r8.getValue()
            java.lang.String r10 = r10.toString()
            boolean r11 = r2.equals(r10)
            if (r11 == 0) goto L_0x00b0
            r11 = 0
            int r12 = r9.length()
            int r13 = r5.length()
            int r12 = r12 - r13
            java.lang.String r11 = r9.substring(r11, r12)
            int r12 = r3.length()
            java.lang.String r11 = r11.substring(r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r3)
            r12.append(r11)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            java.lang.String r0 = r1.getProperty(r12)
            if (r0 == 0) goto L_0x0091
            r5 = r0
            goto L_0x00b2
        L_0x0091:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Implementing class declaration for "
            r14.append(r15)
            r14.append(r2)
            java.lang.String r15 = " missing: "
            r14.append(r15)
            r14.append(r12)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x00b0:
            goto L_0x0033
        L_0x00b1:
            r5 = r0
        L_0x00b2:
            if (r5 == 0) goto L_0x0148
            java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch:{ ClassCastException -> 0x0123, ClassNotFoundException -> 0x0106, InstantiationException -> 0x00e9, IllegalAccessException -> 0x00cc }
            r6 = r16
            java.lang.Class r7 = r0.asSubclass(r6)     // Catch:{ ClassCastException -> 0x00ca, ClassNotFoundException -> 0x00c8, InstantiationException -> 0x00c6, IllegalAccessException -> 0x00c4 }
            r0 = r7
            java.lang.Object r7 = r0.newInstance()     // Catch:{ ClassCastException -> 0x00ca, ClassNotFoundException -> 0x00c8, InstantiationException -> 0x00c6, IllegalAccessException -> 0x00c4 }
            return r7
        L_0x00c4:
            r0 = move-exception
            goto L_0x00cf
        L_0x00c6:
            r0 = move-exception
            goto L_0x00ec
        L_0x00c8:
            r0 = move-exception
            goto L_0x0109
        L_0x00ca:
            r0 = move-exception
            goto L_0x0126
        L_0x00cc:
            r0 = move-exception
            r6 = r16
        L_0x00cf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            java.lang.String r9 = " implementation not able to be accessed: "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8, r0)
            throw r7
        L_0x00e9:
            r0 = move-exception
            r6 = r16
        L_0x00ec:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            java.lang.String r9 = " implementation not able to be instantiated: "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8, r0)
            throw r7
        L_0x0106:
            r0 = move-exception
            r6 = r16
        L_0x0109:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            java.lang.String r9 = " implementation class not found: "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8, r0)
            throw r7
        L_0x0123:
            r0 = move-exception
            r6 = r16
        L_0x0126:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            java.lang.String r9 = " implementation is not an instance of "
            r8.append(r9)
            r8.append(r2)
            java.lang.String r9 = ": "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8, r0)
            throw r7
        L_0x0148:
            r6 = r16
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p400f.C14953x.m46726a(java.lang.Class, java.util.Properties):java.lang.Object");
    }

    /* renamed from: e */
    public C14954y mo46164e() {
        if (this.f44280g.get() == null) {
            Object impl = m46726a(C14954y.class, System.getProperties());
            if (impl == null) {
                this.f44280g.compareAndSet(null, C14954y.m46739e());
            } else {
                this.f44280g.compareAndSet(null, (C14954y) impl);
            }
        }
        return (C14954y) this.f44280g.get();
    }
}
