package android.arch.lifecycle;

import android.arch.lifecycle.C0148d.C0000a;
import android.arch.lifecycle.C0148d.C0149b;
import p002b.p041a.p042a.p043a.C1143c;
import p002b.p041a.p042a.p044b.C1148c;

public abstract class LiveData<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object f178a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f179b = new Object();

    /* renamed from: c */
    private C1148c<C0159n<T>, C0142a> f180c = new C1148c<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f181d = 0;

    /* renamed from: e */
    private volatile Object f182e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile Object f183f;

    /* renamed from: g */
    private int f184g;

    /* renamed from: h */
    private boolean f185h;

    /* renamed from: i */
    private boolean f186i;

    /* renamed from: j */
    private final Runnable f187j;

    class LifecycleBoundObserver extends C0142a implements GenericLifecycleObserver {

        /* renamed from: e */
        final C0001f f188e;

        LifecycleBoundObserver(C0001f owner, C0159n<T> observer) {
            super(observer);
            this.f188e = owner;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo3741b() {
            return this.f188e.getLifecycle().mo3750a().mo3753a(C0149b.STARTED);
        }

        /* renamed from: a */
        public void mo3724a(C0001f source, C0000a event) {
            if (this.f188e.getLifecycle().mo3750a() == C0149b.DESTROYED) {
                LiveData.this.mo3732a(this.f190a);
            } else {
                mo3742a(mo3741b());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo3740a(C0001f owner) {
            return this.f188e == owner;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3739a() {
            this.f188e.getLifecycle().mo3752b(this);
        }
    }

    /* renamed from: android.arch.lifecycle.LiveData$a */
    private abstract class C0142a {

        /* renamed from: a */
        final C0159n<T> f190a;

        /* renamed from: b */
        boolean f191b;

        /* renamed from: c */
        int f192c = -1;

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public abstract boolean mo3741b();

        C0142a(C0159n<T> observer) {
            this.f190a = observer;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo3740a(C0001f owner) {
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3739a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3742a(boolean newActive) {
            if (newActive != this.f191b) {
                this.f191b = newActive;
                int i = 1;
                boolean wasInactive = LiveData.this.f181d == 0;
                LiveData liveData = LiveData.this;
                int c = liveData.f181d;
                if (!this.f191b) {
                    i = -1;
                }
                liveData.f181d = c + i;
                if (wasInactive && this.f191b) {
                    LiveData.this.mo3737d();
                }
                if (LiveData.this.f181d == 0 && !this.f191b) {
                    LiveData.this.mo3738e();
                }
                if (this.f191b) {
                    LiveData.this.m808b(this);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo3737d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract void mo3738e();

    public LiveData() {
        Object obj = f178a;
        this.f182e = obj;
        this.f183f = obj;
        this.f184g = -1;
        this.f187j = new C0156k(this);
    }

    /* renamed from: a */
    private void m804a(C0142a observer) {
        if (observer.f191b) {
            if (!observer.mo3741b()) {
                observer.mo3742a(false);
                return;
            }
            int i = observer.f192c;
            int i2 = this.f184g;
            if (i < i2) {
                observer.f192c = i2;
                observer.f190a.mo3758a(this.f182e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=android.arch.lifecycle.LiveData$a<>, code=android.arch.lifecycle.LiveData$ObserverWrapper<>, for r4v0, types: [android.arch.lifecycle.LiveData$a<>] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m808b(android.arch.lifecycle.LiveData.ObserverWrapper r4) {
        /*
            r3 = this;
            boolean r0 = r3.f185h
            r1 = 1
            if (r0 == 0) goto L_0x0008
            r3.f186i = r1
            return
        L_0x0008:
            r3.f185h = r1
        L_0x000a:
            r0 = 0
            r3.f186i = r0
            if (r4 == 0) goto L_0x0014
            r3.m804a(r4)
            r4 = 0
            goto L_0x0033
        L_0x0014:
            b.a.a.b.c<android.arch.lifecycle.n<T>, android.arch.lifecycle.LiveData$a<>> r1 = r3.f180c
            b.a.a.b.c$d r1 = r1.mo8757b()
        L_0x001a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getValue()
            android.arch.lifecycle.LiveData$a r2 = (android.arch.lifecycle.LiveData.C0142a) r2
            r3.m804a(r2)
            boolean r2 = r3.f186i
            if (r2 == 0) goto L_0x001a
        L_0x0033:
            boolean r1 = r3.f186i
            if (r1 != 0) goto L_0x003a
            r3.f185h = r0
            return
        L_0x003a:
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.LiveData.m808b(android.arch.lifecycle.LiveData$a):void");
    }

    /* renamed from: a */
    public void mo3731a(C0001f owner, C0159n<T> observer) {
        if (owner.getLifecycle().mo3750a() != C0149b.DESTROYED) {
            LifecycleBoundObserver wrapper = new LifecycleBoundObserver<>(owner, observer);
            ObserverWrapper existing = (C0142a) this.f180c.mo8751b(observer, wrapper);
            if (existing != null && !existing.mo3740a(owner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (existing == null) {
                owner.getLifecycle().mo3751a(wrapper);
            }
        }
    }

    /* renamed from: a */
    public void mo3732a(C0159n<T> observer) {
        m806a("removeObserver");
        ObserverWrapper removed = (C0142a) this.f180c.remove(observer);
        if (removed != null) {
            removed.mo3739a();
            removed.mo3742a(false);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000e, code lost:
        if (r1 != false) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0011, code lost:
        p002b.p041a.p042a.p043a.C1143c.m5601b().mo8749b(r4.f187j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3733a(T r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f179b
            monitor-enter(r0)
            r1 = 0
            java.lang.Object r2 = r4.f183f     // Catch:{ all -> 0x001b }
            java.lang.Object r3 = f178a     // Catch:{ all -> 0x001b }
            if (r2 != r3) goto L_0x000b
            r1 = 1
        L_0x000b:
            r4.f183f = r5     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x0011
            return
        L_0x0011:
            b.a.a.a.c r0 = p002b.p041a.p042a.p043a.C1143c.m5601b()
            java.lang.Runnable r2 = r4.f187j
            r0.mo8749b(r2)
            return
        L_0x001b:
            r2 = move-exception
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r2
        L_0x001e:
            r2 = move-exception
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.LiveData.mo3733a(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3735b(T value) {
        m806a("setValue");
        this.f184g++;
        this.f182e = value;
        m808b(null);
    }

    /* renamed from: b */
    public T mo3734b() {
        Object data = this.f182e;
        if (data != f178a) {
            return data;
        }
        return null;
    }

    /* renamed from: c */
    public boolean mo3736c() {
        return this.f181d > 0;
    }

    /* renamed from: a */
    private static void m806a(String methodName) {
        if (!C1143c.m5601b().mo8748a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot invoke ");
            sb.append(methodName);
            sb.append(" on a background");
            sb.append(" thread");
            throw new IllegalStateException(sb.toString());
        }
    }
}
