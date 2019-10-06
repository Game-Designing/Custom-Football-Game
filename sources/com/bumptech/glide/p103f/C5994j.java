package com.bumptech.glide.p103f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.C5956e;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.C6328s;
import com.bumptech.glide.load.engine.C6328s.C6332d;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.p113c.p116c.C6197a;
import com.bumptech.glide.p103f.p104a.C5975h;
import com.bumptech.glide.p103f.p104a.C5976i;
import com.bumptech.glide.p103f.p105b.C5985c;
import com.bumptech.glide.p107h.C6020e;
import com.bumptech.glide.p107h.C6026k;
import com.bumptech.glide.p107h.p108a.C6008d;
import com.bumptech.glide.p107h.p108a.C6008d.C6009a;
import com.bumptech.glide.p107h.p108a.C6008d.C6011c;
import com.bumptech.glide.p107h.p108a.C6015g;
import com.bumptech.glide.request.SingleRequest;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.f.j */
/* compiled from: SingleRequest */
public final class C5994j<R> implements C5986c, C5975h, C5992h, C6011c {

    /* renamed from: a */
    private static final C1269m<C5994j<?>> f10589a = C6008d.m11222a(150, (C6009a<T>) new C5993i<T>());

    /* renamed from: b */
    private static final boolean f10590b = Log.isLoggable("Request", 2);

    /* renamed from: A */
    private int f10591A;

    /* renamed from: B */
    private int f10592B;

    /* renamed from: c */
    private boolean f10593c;

    /* renamed from: d */
    private final String f10594d;

    /* renamed from: e */
    private final C6015g f10595e;

    /* renamed from: f */
    private C5990f<R> f10596f;

    /* renamed from: g */
    private C5987d f10597g;

    /* renamed from: h */
    private Context f10598h;

    /* renamed from: i */
    private C5956e f10599i;

    /* renamed from: j */
    private Object f10600j;

    /* renamed from: k */
    private Class<R> f10601k;

    /* renamed from: l */
    private C5991g f10602l;

    /* renamed from: m */
    private int f10603m;

    /* renamed from: n */
    private int f10604n;

    /* renamed from: o */
    private C6001h f10605o;

    /* renamed from: p */
    private C5976i<R> f10606p;

    /* renamed from: q */
    private C5990f<R> f10607q;

    /* renamed from: r */
    private C6328s f10608r;

    /* renamed from: s */
    private C5985c<? super R> f10609s;

    /* renamed from: t */
    private C6236E<R> f10610t;

    /* renamed from: u */
    private C6332d f10611u;

    /* renamed from: v */
    private long f10612v;

    /* renamed from: w */
    private C5995a f10613w;

    /* renamed from: x */
    private Drawable f10614x;

    /* renamed from: y */
    private Drawable f10615y;

    /* renamed from: z */
    private Drawable f10616z;

    /* renamed from: com.bumptech.glide.f.j$a */
    /* compiled from: SingleRequest */
    private enum C5995a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    /* renamed from: a */
    public static <R> C5994j<R> m11166a(Context context, C5956e glideContext, Object model, Class<R> transcodeClass, C5991g requestOptions, int overrideWidth, int overrideHeight, C6001h priority, C5976i<R> target, C5990f<R> targetListener, C5990f<R> requestListener, C5987d requestCoordinator, C6328s engine, C5985c<? super R> animationFactory) {
        C5994j<R> jVar = (C5994j) f10589a.mo9148a();
        if (jVar == null) {
            jVar = new C5994j<>();
        }
        jVar.m11171b(context, glideContext, model, transcodeClass, requestOptions, overrideWidth, overrideHeight, priority, target, targetListener, requestListener, requestCoordinator, engine, animationFactory);
        return jVar;
    }

    C5994j() {
        this.f10594d = f10590b ? String.valueOf(super.hashCode()) : null;
        this.f10595e = C6015g.m11235a();
    }

    /* renamed from: b */
    private void m11171b(Context context, C5956e glideContext, Object model, Class<R> transcodeClass, C5991g requestOptions, int overrideWidth, int overrideHeight, C6001h priority, C5976i<R> target, C5990f<R> targetListener, C5990f<R> requestListener, C5987d requestCoordinator, C6328s engine, C5985c<? super R> animationFactory) {
        this.f10598h = context;
        this.f10599i = glideContext;
        this.f10600j = model;
        this.f10601k = transcodeClass;
        this.f10602l = requestOptions;
        this.f10603m = overrideWidth;
        this.f10604n = overrideHeight;
        this.f10605o = priority;
        this.f10606p = target;
        this.f10596f = targetListener;
        this.f10607q = requestListener;
        this.f10597g = requestCoordinator;
        this.f10608r = engine;
        this.f10609s = animationFactory;
        this.f10613w = C5995a.PENDING;
    }

    /* renamed from: e */
    public C6015g mo18779e() {
        return this.f10595e;
    }

    /* renamed from: b */
    public void mo18676b() {
        m11172f();
        this.f10598h = null;
        this.f10599i = null;
        this.f10600j = null;
        this.f10601k = null;
        this.f10602l = null;
        this.f10603m = -1;
        this.f10604n = -1;
        this.f10606p = null;
        this.f10607q = null;
        this.f10596f = null;
        this.f10597g = null;
        this.f10609s = null;
        this.f10611u = null;
        this.f10614x = null;
        this.f10615y = null;
        this.f10616z = null;
        this.f10591A = -1;
        this.f10592B = -1;
        f10589a.mo9149a(this);
    }

    /* renamed from: a */
    public void mo18673a() {
        m11172f();
        this.f10595e.mo18795b();
        this.f10612v = C6020e.m11250a();
        if (this.f10600j == null) {
            if (C6026k.m11285b(this.f10603m, this.f10604n)) {
                this.f10591A = this.f10603m;
                this.f10592B = this.f10604n;
            }
            m11169a(new GlideException("Received null model"), m11177k() == null ? 5 : 3);
            return;
        }
        C5995a aVar = this.f10613w;
        if (aVar == C5995a.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (aVar == C5995a.COMPLETE) {
            mo18775a(this.f10610t, C6031a.MEMORY_CACHE);
        } else {
            this.f10613w = C5995a.WAITING_FOR_SIZE;
            if (C6026k.m11285b(this.f10603m, this.f10604n)) {
                mo18703a(this.f10603m, this.f10604n);
            } else {
                this.f10606p.getSize(this);
            }
            C5995a aVar2 = this.f10613w;
            if ((aVar2 == C5995a.RUNNING || aVar2 == C5995a.WAITING_FOR_SIZE) && m11174h()) {
                this.f10606p.onLoadStarted(m11178l());
            }
            if (f10590b) {
                StringBuilder sb = new StringBuilder();
                sb.append("finished run method in ");
                sb.append(C6020e.m11249a(this.f10612v));
                m11170a(sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo18778d() {
        m11172f();
        this.f10595e.mo18795b();
        this.f10606p.removeCallback(this);
        this.f10613w = C5995a.CANCELLED;
        C6332d dVar = this.f10611u;
        if (dVar != null) {
            dVar.mo19284a();
            this.f10611u = null;
        }
    }

    /* renamed from: f */
    private void m11172f() {
        if (this.f10593c) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public void clear() {
        C6026k.m11283b();
        m11172f();
        this.f10595e.mo18795b();
        if (this.f10613w != C5995a.CLEARED) {
            mo18778d();
            C6236E<R> e = this.f10610t;
            if (e != null) {
                m11167a(e);
            }
            if (m11173g()) {
                this.f10606p.onLoadCleared(m11178l());
            }
            this.f10613w = C5995a.CLEARED;
        }
    }

    public void pause() {
        clear();
        this.f10613w = C5995a.PAUSED;
    }

    /* renamed from: a */
    private void m11167a(C6236E<?> resource) {
        this.f10608r.mo19281b(resource);
        this.f10610t = null;
    }

    public boolean isRunning() {
        C5995a aVar = this.f10613w;
        return aVar == C5995a.RUNNING || aVar == C5995a.WAITING_FOR_SIZE;
    }

    public boolean isComplete() {
        return this.f10613w == C5995a.COMPLETE;
    }

    /* renamed from: c */
    public boolean mo18678c() {
        return isComplete();
    }

    public boolean isCancelled() {
        C5995a aVar = this.f10613w;
        return aVar == C5995a.CANCELLED || aVar == C5995a.CLEARED;
    }

    public boolean isFailed() {
        return this.f10613w == C5995a.FAILED;
    }

    /* renamed from: j */
    private Drawable m11176j() {
        if (this.f10614x == null) {
            this.f10614x = this.f10602l.mo18760k();
            if (this.f10614x == null && this.f10602l.mo18758h() > 0) {
                this.f10614x = m11165a(this.f10602l.mo18758h());
            }
        }
        return this.f10614x;
    }

    /* renamed from: l */
    private Drawable m11178l() {
        if (this.f10615y == null) {
            this.f10615y = this.f10602l.mo18767r();
            if (this.f10615y == null && this.f10602l.mo18768s() > 0) {
                this.f10615y = m11165a(this.f10602l.mo18768s());
            }
        }
        return this.f10615y;
    }

    /* renamed from: k */
    private Drawable m11177k() {
        if (this.f10616z == null) {
            this.f10616z = this.f10602l.mo18761l();
            if (this.f10616z == null && this.f10602l.mo18762m() > 0) {
                this.f10616z = m11165a(this.f10602l.mo18762m());
            }
        }
        return this.f10616z;
    }

    /* renamed from: a */
    private Drawable m11165a(int resourceId) {
        return C6197a.m11771a((Context) this.f10599i, resourceId, this.f10602l.mo18773y() != null ? this.f10602l.mo18773y() : this.f10598h.getTheme());
    }

    /* renamed from: p */
    private void m11182p() {
        if (m11174h()) {
            Drawable error = null;
            if (this.f10600j == null) {
                error = m11177k();
            }
            if (error == null) {
                error = m11176j();
            }
            if (error == null) {
                error = m11178l();
            }
            this.f10606p.onLoadFailed(error);
        }
    }

    /* renamed from: a */
    public void mo18703a(int width, int height) {
        this.f10595e.mo18795b();
        if (f10590b) {
            StringBuilder sb = new StringBuilder();
            sb.append("Got onSizeReady in ");
            sb.append(C6020e.m11249a(this.f10612v));
            m11170a(sb.toString());
        }
        if (this.f10613w == C5995a.WAITING_FOR_SIZE) {
            this.f10613w = C5995a.RUNNING;
            float sizeMultiplier = this.f10602l.mo18772x();
            this.f10591A = m11164a(width, sizeMultiplier);
            this.f10592B = m11164a(height, sizeMultiplier);
            if (f10590b) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("finished setup for calling load in ");
                sb2.append(C6020e.m11249a(this.f10612v));
                m11170a(sb2.toString());
            }
            C6328s sVar = this.f10608r;
            float f = sizeMultiplier;
            C5956e eVar = this.f10599i;
            C6332d a = sVar.mo19277a(eVar, this.f10600j, this.f10602l.mo18771w(), this.f10591A, this.f10592B, this.f10602l.mo18770u(), this.f10601k, this.f10605o, this.f10602l.mo18756d(), this.f10602l.mo18774z(), this.f10602l.mo18728G(), this.f10602l.mo18726E(), this.f10602l.mo18764o(), this.f10602l.mo18724C(), this.f10602l.mo18723B(), this.f10602l.mo18722A(), this.f10602l.mo18763n(), this);
            this.f10611u = a;
            if (this.f10613w != C5995a.RUNNING) {
                this.f10611u = null;
            }
            if (f10590b) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("finished onSizeReady in ");
                sb3.append(C6020e.m11249a(this.f10612v));
                m11170a(sb3.toString());
            }
        }
    }

    /* renamed from: a */
    private static int m11164a(int size, float sizeMultiplier) {
        return size == Integer.MIN_VALUE ? size : Math.round(((float) size) * sizeMultiplier);
    }

    /* renamed from: i */
    private boolean m11175i() {
        C5987d dVar = this.f10597g;
        return dVar == null || dVar.mo18679c(this);
    }

    /* renamed from: g */
    private boolean m11173g() {
        C5987d dVar = this.f10597g;
        return dVar == null || dVar.mo18684f(this);
    }

    /* renamed from: h */
    private boolean m11174h() {
        C5987d dVar = this.f10597g;
        return dVar == null || dVar.mo18677b(this);
    }

    /* renamed from: m */
    private boolean m11179m() {
        C5987d dVar = this.f10597g;
        return dVar == null || !dVar.mo18682d();
    }

    /* renamed from: o */
    private void m11181o() {
        C5987d dVar = this.f10597g;
        if (dVar != null) {
            dVar.mo18683e(this);
        }
    }

    /* renamed from: n */
    private void m11180n() {
        C5987d dVar = this.f10597g;
        if (dVar != null) {
            dVar.mo18681d(this);
        }
    }

    /* renamed from: a */
    public void mo18775a(C6236E<?> resource, C6031a dataSource) {
        this.f10595e.mo18795b();
        this.f10611u = null;
        if (resource == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive a Resource<R> with an object of ");
            sb.append(this.f10601k);
            sb.append(" inside, but instead got null.");
            mo18776a(new GlideException(sb.toString()));
            return;
        }
        Object received = resource.get();
        if (received == null || !this.f10601k.isAssignableFrom(received.getClass())) {
            m11167a(resource);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected to receive an object of ");
            sb2.append(this.f10601k);
            sb2.append(" but instead got ");
            String str = "";
            sb2.append(received != null ? received.getClass() : str);
            sb2.append("{");
            sb2.append(received);
            sb2.append("} inside Resource{");
            sb2.append(resource);
            sb2.append("}.");
            if (received == null) {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            sb2.append(str);
            mo18776a(new GlideException(sb2.toString()));
        } else if (!m11175i()) {
            m11167a(resource);
            this.f10613w = C5995a.COMPLETE;
        } else {
            m11168a(resource, received, dataSource);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0092, code lost:
        if (r8.f10596f.mo18713a(r10, r8.f10600j, r8.f10606p, r11, r6) == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x007f, code lost:
        if (r8.f10607q.mo18713a(r10, r8.f10600j, r8.f10606p, r11, r6) == false) goto L_0x0081;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11168a(com.bumptech.glide.load.engine.C6236E<R> r9, R r10, com.bumptech.glide.load.C6031a r11) {
        /*
            r8 = this;
            boolean r6 = r8.m11179m()
            com.bumptech.glide.f.j$a r0 = com.bumptech.glide.p103f.C5994j.C5995a.COMPLETE
            r8.f10613w = r0
            r8.f10610t = r9
            com.bumptech.glide.e r0 = r8.f10599i
            int r0 = r0.mo18652d()
            r1 = 3
            if (r0 > r1) goto L_0x006a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Finished loading "
            r0.append(r1)
            java.lang.Class r1 = r10.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = " from "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " for "
            r0.append(r1)
            java.lang.Object r1 = r8.f10600j
            r0.append(r1)
            java.lang.String r1 = " with size ["
            r0.append(r1)
            int r1 = r8.f10591A
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            int r1 = r8.f10592B
            r0.append(r1)
            java.lang.String r1 = "] in "
            r0.append(r1)
            long r1 = r8.f10612v
            double r1 = com.bumptech.glide.p107h.C6020e.m11249a(r1)
            r0.append(r1)
            java.lang.String r1 = " ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Glide"
            android.util.Log.d(r1, r0)
        L_0x006a:
            r0 = 1
            r8.f10593c = r0
            r7 = 0
            com.bumptech.glide.f.f<R> r0 = r8.f10607q     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0081
            com.bumptech.glide.f.f<R> r0 = r8.f10607q     // Catch:{ all -> 0x00a6 }
            java.lang.Object r2 = r8.f10600j     // Catch:{ all -> 0x00a6 }
            com.bumptech.glide.f.a.i<R> r3 = r8.f10606p     // Catch:{ all -> 0x00a6 }
            r1 = r10
            r4 = r11
            r5 = r6
            boolean r0 = r0.mo18713a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x009f
        L_0x0081:
            com.bumptech.glide.f.f<R> r0 = r8.f10596f     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0094
            com.bumptech.glide.f.f<R> r0 = r8.f10596f     // Catch:{ all -> 0x00a6 }
            java.lang.Object r2 = r8.f10600j     // Catch:{ all -> 0x00a6 }
            com.bumptech.glide.f.a.i<R> r3 = r8.f10606p     // Catch:{ all -> 0x00a6 }
            r1 = r10
            r4 = r11
            r5 = r6
            boolean r0 = r0.mo18713a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x009f
        L_0x0094:
            com.bumptech.glide.f.b.c<? super R> r0 = r8.f10609s     // Catch:{ all -> 0x00a6 }
            com.bumptech.glide.f.b.b r0 = r0.mo18711a(r11, r6)     // Catch:{ all -> 0x00a6 }
            com.bumptech.glide.f.a.i<R> r1 = r8.f10606p     // Catch:{ all -> 0x00a6 }
            r1.onResourceReady(r10, r0)     // Catch:{ all -> 0x00a6 }
        L_0x009f:
            r8.f10593c = r7
            r8.m11181o()
            return
        L_0x00a6:
            r0 = move-exception
            r8.f10593c = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p103f.C5994j.m11168a(com.bumptech.glide.load.engine.E, java.lang.Object, com.bumptech.glide.load.a):void");
    }

    /* renamed from: a */
    public void mo18776a(GlideException e) {
        m11169a(e, 5);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private void m11169a(GlideException e, int maxLogLevel) {
        this.f10595e.mo18795b();
        int logLevel = this.f10599i.mo18652d();
        if (logLevel <= maxLogLevel) {
            StringBuilder sb = new StringBuilder();
            sb.append("Load failed for ");
            sb.append(this.f10600j);
            sb.append(" with size [");
            sb.append(this.f10591A);
            sb.append("x");
            sb.append(this.f10592B);
            sb.append("]");
            String str = "Glide";
            Log.w(str, sb.toString(), e);
            if (logLevel <= 4) {
                e.mo19107a(str);
            }
        }
        this.f10611u = null;
        this.f10613w = C5995a.FAILED;
        this.f10593c = true;
        try {
            if ((this.f10607q == null || !this.f10607q.mo18712a(e, this.f10600j, this.f10606p, m11179m())) && (this.f10596f == null || !this.f10596f.mo18712a(e, this.f10600j, this.f10606p, m11179m()))) {
                m11182p();
            }
            this.f10593c = false;
            m11180n();
        } catch (Throwable th) {
            this.f10593c = false;
            throw th;
        }
    }

    /* renamed from: a */
    public boolean mo18675a(C5986c o) {
        boolean z = false;
        if (!(o instanceof C5994j)) {
            return false;
        }
        SingleRequest<?> that = (C5994j) o;
        if (this.f10603m == that.f10603m && this.f10604n == that.f10604n && C6026k.m11282a(this.f10600j, that.f10600j) && this.f10601k.equals(that.f10601k) && this.f10602l.equals(that.f10602l) && this.f10605o == that.f10605o && (this.f10607q == null ? that.f10607q == null : that.f10607q != null)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private void m11170a(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(" this: ");
        sb.append(this.f10594d);
        Log.v("Request", sb.toString());
    }
}
