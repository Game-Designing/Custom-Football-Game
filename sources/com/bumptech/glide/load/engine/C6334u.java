package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.engine.p122c.C6295b;
import com.bumptech.glide.p103f.C5992h;
import com.bumptech.glide.p107h.C6026k;
import com.bumptech.glide.p107h.p108a.C6008d.C6011c;
import com.bumptech.glide.p107h.p108a.C6015g;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.engine.u */
/* compiled from: EngineJob */
class C6334u<R> implements C6312a<R>, C6011c {

    /* renamed from: a */
    private static final C6335a f11277a = new C6335a();

    /* renamed from: b */
    private static final Handler f11278b = new Handler(Looper.getMainLooper(), new C6336b());

    /* renamed from: c */
    private final List<C5992h> f11279c;

    /* renamed from: d */
    private final C6015g f11280d;

    /* renamed from: e */
    private final C1269m<C6334u<?>> f11281e;

    /* renamed from: f */
    private final C6335a f11282f;

    /* renamed from: g */
    private final C6337v f11283g;

    /* renamed from: h */
    private final C6295b f11284h;

    /* renamed from: i */
    private final C6295b f11285i;

    /* renamed from: j */
    private final C6295b f11286j;

    /* renamed from: k */
    private final C6295b f11287k;

    /* renamed from: l */
    private C6344g f11288l;

    /* renamed from: m */
    private boolean f11289m;

    /* renamed from: n */
    private boolean f11290n;

    /* renamed from: o */
    private boolean f11291o;

    /* renamed from: p */
    private boolean f11292p;

    /* renamed from: q */
    private C6236E<?> f11293q;

    /* renamed from: r */
    private C6031a f11294r;

    /* renamed from: s */
    private boolean f11295s;

    /* renamed from: t */
    private GlideException f11296t;

    /* renamed from: u */
    private boolean f11297u;

    /* renamed from: v */
    private List<C5992h> f11298v;

    /* renamed from: w */
    private C6340y<?> f11299w;

    /* renamed from: x */
    private C6311j<R> f11300x;

    /* renamed from: y */
    private volatile boolean f11301y;

    /* renamed from: com.bumptech.glide.load.engine.u$a */
    /* compiled from: EngineJob */
    static class C6335a {
        C6335a() {
        }

        /* renamed from: a */
        public <R> C6340y<R> mo19294a(C6236E<R> resource, boolean isMemoryCacheable) {
            return new C6340y<>(resource, isMemoryCacheable, true);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.u$b */
    /* compiled from: EngineJob */
    private static class C6336b implements Callback {
        C6336b() {
        }

        public boolean handleMessage(Message message) {
            EngineJob<?> job = (C6334u) message.obj;
            int i = message.what;
            if (i == 1) {
                job.mo19292d();
            } else if (i == 2) {
                job.mo19291c();
            } else if (i == 3) {
                job.mo19288b();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized message: ");
                sb.append(message.what);
                throw new IllegalStateException(sb.toString());
            }
            return true;
        }
    }

    C6334u(C6295b diskCacheExecutor, C6295b sourceExecutor, C6295b sourceUnlimitedExecutor, C6295b animationExecutor, C6337v listener, C1269m<C6334u<?>> pool) {
        this(diskCacheExecutor, sourceExecutor, sourceUnlimitedExecutor, animationExecutor, listener, pool, f11277a);
    }

    C6334u(C6295b diskCacheExecutor, C6295b sourceExecutor, C6295b sourceUnlimitedExecutor, C6295b animationExecutor, C6337v listener, C1269m<C6334u<?>> pool, C6335a engineResourceFactory) {
        this.f11279c = new ArrayList(2);
        this.f11280d = C6015g.m11235a();
        this.f11284h = diskCacheExecutor;
        this.f11285i = sourceExecutor;
        this.f11286j = sourceUnlimitedExecutor;
        this.f11287k = animationExecutor;
        this.f11283g = listener;
        this.f11281e = pool;
        this.f11282f = engineResourceFactory;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C6334u<R> mo19285a(C6344g key, boolean isCacheable, boolean useUnlimitedSourceGeneratorPool, boolean useAnimationPool, boolean onlyRetrieveFromCache) {
        this.f11288l = key;
        this.f11289m = isCacheable;
        this.f11290n = useUnlimitedSourceGeneratorPool;
        this.f11291o = useAnimationPool;
        this.f11292p = onlyRetrieveFromCache;
        return this;
    }

    /* renamed from: b */
    public void mo19290b(C6311j<R> decodeJob) {
        C6295b executor;
        this.f11300x = decodeJob;
        if (decodeJob.mo19256i()) {
            executor = this.f11284h;
        } else {
            executor = m12213g();
        }
        executor.execute(decodeJob);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19287a(C5992h cb) {
        C6026k.m11283b();
        this.f11280d.mo18795b();
        if (this.f11295s) {
            cb.mo18775a(this.f11299w, this.f11294r);
        } else if (this.f11297u) {
            cb.mo18776a(this.f11296t);
        } else {
            this.f11279c.add(cb);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo19289b(C5992h cb) {
        C6026k.m11283b();
        this.f11280d.mo18795b();
        if (this.f11295s || this.f11297u) {
            m12211c(cb);
            return;
        }
        this.f11279c.remove(cb);
        if (this.f11279c.isEmpty()) {
            mo19286a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo19293f() {
        return this.f11292p;
    }

    /* renamed from: g */
    private C6295b m12213g() {
        if (this.f11290n) {
            return this.f11286j;
        }
        return this.f11291o ? this.f11287k : this.f11285i;
    }

    /* renamed from: c */
    private void m12211c(C5992h cb) {
        if (this.f11298v == null) {
            this.f11298v = new ArrayList(2);
        }
        if (!this.f11298v.contains(cb)) {
            this.f11298v.add(cb);
        }
    }

    /* renamed from: d */
    private boolean m12212d(C5992h cb) {
        List<C5992h> list = this.f11298v;
        return list != null && list.contains(cb);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19286a() {
        if (!this.f11297u && !this.f11295s && !this.f11301y) {
            this.f11301y = true;
            this.f11300x.mo19255g();
            this.f11283g.mo19278a(this, this.f11288l);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo19292d() {
        this.f11280d.mo18795b();
        if (this.f11301y) {
            this.f11293q.mo18969b();
            m12210a(false);
        } else if (this.f11279c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else if (!this.f11295s) {
            this.f11299w = this.f11282f.mo19294a(this.f11293q, this.f11289m);
            this.f11295s = true;
            this.f11299w.mo19299d();
            this.f11283g.mo19279a(this, this.f11288l, this.f11299w);
            int size = this.f11279c.size();
            for (int i = 0; i < size; i++) {
                C5992h cb = (C5992h) this.f11279c.get(i);
                if (!m12212d(cb)) {
                    this.f11299w.mo19299d();
                    cb.mo18775a(this.f11299w, this.f11294r);
                }
            }
            this.f11299w.mo19302g();
            m12210a(false);
        } else {
            throw new IllegalStateException("Already have resource");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo19288b() {
        this.f11280d.mo18795b();
        if (this.f11301y) {
            this.f11283g.mo19278a(this, this.f11288l);
            m12210a(false);
            return;
        }
        throw new IllegalStateException("Not cancelled");
    }

    /* renamed from: a */
    private void m12210a(boolean isRemovedFromQueue) {
        C6026k.m11283b();
        this.f11279c.clear();
        this.f11288l = null;
        this.f11299w = null;
        this.f11293q = null;
        List<C5992h> list = this.f11298v;
        if (list != null) {
            list.clear();
        }
        this.f11297u = false;
        this.f11301y = false;
        this.f11295s = false;
        this.f11300x.mo19253a(isRemovedFromQueue);
        this.f11300x = null;
        this.f11296t = null;
        this.f11294r = null;
        this.f11281e.mo9149a(this);
    }

    /* renamed from: a */
    public void mo19258a(C6236E<R> resource, C6031a dataSource) {
        this.f11293q = resource;
        this.f11294r = dataSource;
        f11278b.obtainMessage(1, this).sendToTarget();
    }

    /* renamed from: a */
    public void mo19259a(GlideException e) {
        this.f11296t = e;
        f11278b.obtainMessage(2, this).sendToTarget();
    }

    /* renamed from: a */
    public void mo19260a(C6311j<?> job) {
        m12213g().execute(job);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo19291c() {
        this.f11280d.mo18795b();
        if (this.f11301y) {
            m12210a(false);
        } else if (this.f11279c.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (!this.f11297u) {
            this.f11297u = true;
            this.f11283g.mo19279a(this, this.f11288l, null);
            for (C5992h cb : this.f11279c) {
                if (!m12212d(cb)) {
                    cb.mo18776a(this.f11296t);
                }
            }
            m12210a(false);
        } else {
            throw new IllegalStateException("Already failed once");
        }
    }

    /* renamed from: e */
    public C6015g mo18779e() {
        return this.f11280d;
    }
}
