package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.c */
/* compiled from: ActiveResources */
final class C6291c {

    /* renamed from: a */
    private final boolean f11130a;

    /* renamed from: b */
    private final Handler f11131b = new Handler(Looper.getMainLooper(), new C6243a(this));

    /* renamed from: c */
    final Map<C6344g, C6293b> f11132c = new HashMap();

    /* renamed from: d */
    private C6341a f11133d;

    /* renamed from: e */
    private ReferenceQueue<C6340y<?>> f11134e;

    /* renamed from: f */
    private Thread f11135f;

    /* renamed from: g */
    private volatile boolean f11136g;

    /* renamed from: h */
    private volatile C6292a f11137h;

    /* renamed from: com.bumptech.glide.load.engine.c$a */
    /* compiled from: ActiveResources */
    interface C6292a {
        /* renamed from: a */
        void mo19206a();
    }

    /* renamed from: com.bumptech.glide.load.engine.c$b */
    /* compiled from: ActiveResources */
    static final class C6293b extends WeakReference<C6340y<?>> {

        /* renamed from: a */
        final C6344g f11138a;

        /* renamed from: b */
        final boolean f11139b;

        /* renamed from: c */
        C6236E<?> f11140c;

        C6293b(C6344g key, C6340y<?> referent, ReferenceQueue<? super C6340y<?>> queue, boolean isActiveResourceRetentionAllowed) {
            C6236E<?> e;
            super(referent, queue);
            C6024i.m11264a(key);
            this.f11138a = key;
            if (!referent.mo19301f() || !isActiveResourceRetentionAllowed) {
                e = null;
            } else {
                C6236E<?> e2 = referent.mo19300e();
                C6024i.m11264a(e2);
                e = e2;
            }
            this.f11140c = e;
            this.f11139b = referent.mo19301f();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo19207a() {
            this.f11140c = null;
            clear();
        }
    }

    C6291c(boolean isActiveResourceRetentionAllowed) {
        this.f11130a = isActiveResourceRetentionAllowed;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19202a(C6341a listener) {
        this.f11133d = listener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19204a(C6344g key, C6340y<?> resource) {
        C6293b removed = (C6293b) this.f11132c.put(key, new C6293b(key, resource, m12071b(), this.f11130a));
        if (removed != null) {
            removed.mo19207a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19203a(C6344g key) {
        C6293b removed = (C6293b) this.f11132c.remove(key);
        if (removed != null) {
            removed.mo19207a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C6340y<?> mo19205b(C6344g key) {
        C6293b activeRef = (C6293b) this.f11132c.get(key);
        if (activeRef == null) {
            return null;
        }
        EngineResource<?> active = (C6340y) activeRef.get();
        if (active == null) {
            mo19201a(activeRef);
        }
        return active;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19201a(C6293b ref) {
        C6026k.m11283b();
        this.f11132c.remove(ref.f11138a);
        if (ref.f11139b) {
            C6236E<?> e = ref.f11140c;
            if (e != null) {
                C6340y yVar = new C6340y(e, true, false);
                yVar.mo19298a(ref.f11138a, this.f11133d);
                this.f11133d.mo19280a(ref.f11138a, yVar);
            }
        }
    }

    /* renamed from: b */
    private ReferenceQueue<C6340y<?>> m12071b() {
        if (this.f11134e == null) {
            this.f11134e = new ReferenceQueue<>();
            this.f11135f = new Thread(new C6268b(this), "glide-active-resources");
            this.f11135f.start();
        }
        return this.f11134e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19200a() {
        while (!this.f11136g) {
            try {
                this.f11131b.obtainMessage(1, (C6293b) this.f11134e.remove()).sendToTarget();
                C6292a current = this.f11137h;
                if (current != null) {
                    current.mo19206a();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
