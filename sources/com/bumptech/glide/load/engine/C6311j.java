package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.C5956e;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6145c;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6351m;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6307g.C6308a;
import com.bumptech.glide.load.engine.p121b.C6269a;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6044e;
import com.bumptech.glide.load.p113c.p114a.C6169l;
import com.bumptech.glide.p107h.C6020e;
import com.bumptech.glide.p107h.p108a.C6008d.C6011c;
import com.bumptech.glide.p107h.p108a.C6013e;
import com.bumptech.glide.p107h.p108a.C6015g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.engine.j */
/* compiled from: DecodeJob */
class C6311j<R> implements C6308a, Runnable, Comparable<C6311j<?>>, C6011c {

    /* renamed from: A */
    private C6031a f11193A;

    /* renamed from: B */
    private C6042d<?> f11194B;

    /* renamed from: C */
    private volatile C6307g f11195C;

    /* renamed from: D */
    private volatile boolean f11196D;

    /* renamed from: E */
    private volatile boolean f11197E;

    /* renamed from: a */
    private final C6309h<R> f11198a = new C6309h<>();

    /* renamed from: b */
    private final List<Throwable> f11199b = new ArrayList();

    /* renamed from: c */
    private final C6015g f11200c = C6015g.m11235a();

    /* renamed from: d */
    private final C6315d f11201d;

    /* renamed from: e */
    private final C1269m<C6311j<?>> f11202e;

    /* renamed from: f */
    private final C6314c<?> f11203f = new C6314c<>();

    /* renamed from: g */
    private final C6316e f11204g = new C6316e();

    /* renamed from: h */
    private C5956e f11205h;

    /* renamed from: i */
    private C6344g f11206i;

    /* renamed from: j */
    private C6001h f11207j;

    /* renamed from: k */
    private C6338w f11208k;

    /* renamed from: l */
    private int f11209l;

    /* renamed from: m */
    private int f11210m;

    /* renamed from: n */
    private C6326q f11211n;

    /* renamed from: o */
    private C6349k f11212o;

    /* renamed from: p */
    private C6312a<R> f11213p;

    /* renamed from: q */
    private int f11214q;

    /* renamed from: r */
    private C6318g f11215r;

    /* renamed from: s */
    private C6317f f11216s;

    /* renamed from: t */
    private long f11217t;

    /* renamed from: u */
    private boolean f11218u;

    /* renamed from: v */
    private Object f11219v;

    /* renamed from: w */
    private Thread f11220w;

    /* renamed from: x */
    private C6344g f11221x;

    /* renamed from: y */
    private C6344g f11222y;

    /* renamed from: z */
    private Object f11223z;

    /* renamed from: com.bumptech.glide.load.engine.j$a */
    /* compiled from: DecodeJob */
    interface C6312a<R> {
        /* renamed from: a */
        void mo19258a(C6236E<R> e, C6031a aVar);

        /* renamed from: a */
        void mo19259a(GlideException glideException);

        /* renamed from: a */
        void mo19260a(C6311j<?> jVar);
    }

    /* renamed from: com.bumptech.glide.load.engine.j$b */
    /* compiled from: DecodeJob */
    private final class C6313b<Z> implements C6320a<Z> {

        /* renamed from: a */
        private final C6031a f11224a;

        C6313b(C6031a dataSource) {
            this.f11224a = dataSource;
        }

        /* renamed from: a */
        public C6236E<Z> mo19261a(C6236E<Z> decoded) {
            return C6311j.this.mo19251a(this.f11224a, decoded);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.j$c */
    /* compiled from: DecodeJob */
    private static class C6314c<Z> {

        /* renamed from: a */
        private C6344g f11226a;

        /* renamed from: b */
        private C6351m<Z> f11227b;

        /* renamed from: c */
        private C6235D<Z> f11228c;

        C6314c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <X> void mo19264a(C6344g key, C6351m<X> encoder, C6235D<X> toEncode) {
            this.f11226a = key;
            this.f11227b = encoder;
            this.f11228c = toEncode;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo19263a(C6315d diskCacheProvider, C6349k options) {
            C6013e.m11232a("DecodeJob.encode");
            try {
                diskCacheProvider.mo19266a().mo19177a(this.f11226a, new C6306f(this.f11227b, this.f11228c, options));
            } finally {
                this.f11228c.mo19100d();
                C6013e.m11231a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo19265b() {
            return this.f11228c != null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo19262a() {
            this.f11226a = null;
            this.f11227b = null;
            this.f11228c = null;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.j$d */
    /* compiled from: DecodeJob */
    interface C6315d {
        /* renamed from: a */
        C6269a mo19266a();
    }

    /* renamed from: com.bumptech.glide.load.engine.j$e */
    /* compiled from: DecodeJob */
    private static class C6316e {

        /* renamed from: a */
        private boolean f11229a;

        /* renamed from: b */
        private boolean f11230b;

        /* renamed from: c */
        private boolean f11231c;

        C6316e() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public synchronized boolean mo19268a(boolean isRemovedFromQueue) {
            this.f11229a = true;
            return m12163b(isRemovedFromQueue);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public synchronized boolean mo19267a() {
            this.f11230b = true;
            return m12163b(false);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public synchronized boolean mo19269b() {
            this.f11231c = true;
            return m12163b(false);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public synchronized void mo19270c() {
            this.f11230b = false;
            this.f11229a = false;
            this.f11231c = false;
        }

        /* renamed from: b */
        private boolean m12163b(boolean isRemovedFromQueue) {
            return (this.f11231c || isRemovedFromQueue || this.f11230b) && this.f11229a;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.j$f */
    /* compiled from: DecodeJob */
    private enum C6317f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* renamed from: com.bumptech.glide.load.engine.j$g */
    /* compiled from: DecodeJob */
    private enum C6318g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    C6311j(C6315d diskCacheProvider, C1269m<C6311j<?>> pool) {
        this.f11201d = diskCacheProvider;
        this.f11202e = pool;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C6311j<R> mo19252a(C5956e glideContext, Object model, C6338w loadKey, C6344g signature, int width, int height, Class<?> resourceClass, Class<R> transcodeClass, C6001h priority, C6326q diskCacheStrategy, Map<Class<?>, C6352n<?>> transformations, boolean isTransformationRequired, boolean isScaleOnlyOrNoTransform, boolean onlyRetrieveFromCache, C6349k options, C6312a<R> callback, int order) {
        int i = width;
        int i2 = height;
        C6326q qVar = diskCacheStrategy;
        this.f11198a.mo19232a(glideContext, model, signature, i, i2, qVar, resourceClass, transcodeClass, priority, options, transformations, isTransformationRequired, isScaleOnlyOrNoTransform, this.f11201d);
        this.f11205h = glideContext;
        this.f11206i = signature;
        this.f11207j = priority;
        this.f11208k = loadKey;
        this.f11209l = i;
        this.f11210m = i2;
        this.f11211n = qVar;
        this.f11218u = onlyRetrieveFromCache;
        this.f11212o = options;
        this.f11213p = callback;
        this.f11214q = order;
        this.f11216s = C6317f.INITIALIZE;
        this.f11219v = model;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo19256i() {
        C6318g firstStage = m12129a(C6318g.INITIALIZE);
        return firstStage == C6318g.RESOURCE_CACHE || firstStage == C6318g.DATA_CACHE;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19253a(boolean isRemovedFromQueue) {
        if (this.f11204g.mo19268a(isRemovedFromQueue)) {
            m12140w();
        }
    }

    /* renamed from: u */
    private void m12138u() {
        if (this.f11204g.mo19267a()) {
            m12140w();
        }
    }

    /* renamed from: v */
    private void m12139v() {
        if (this.f11204g.mo19269b()) {
            m12140w();
        }
    }

    /* renamed from: w */
    private void m12140w() {
        this.f11204g.mo19270c();
        this.f11203f.mo19262a();
        this.f11198a.mo19231a();
        this.f11196D = false;
        this.f11205h = null;
        this.f11206i = null;
        this.f11212o = null;
        this.f11207j = null;
        this.f11208k = null;
        this.f11213p = null;
        this.f11215r = null;
        this.f11195C = null;
        this.f11220w = null;
        this.f11221x = null;
        this.f11223z = null;
        this.f11193A = null;
        this.f11194B = null;
        this.f11217t = 0;
        this.f11197E = false;
        this.f11219v = null;
        this.f11199b.clear();
        this.f11202e.mo9149a(this);
    }

    /* renamed from: a */
    public int compareTo(C6311j<?> other) {
        int result = getPriority() - other.getPriority();
        if (result == 0) {
            return this.f11214q - other.f11214q;
        }
        return result;
    }

    private int getPriority() {
        return this.f11207j.ordinal();
    }

    /* renamed from: g */
    public void mo19255g() {
        this.f11197E = true;
        C6307g local = this.f11195C;
        if (local != null) {
            local.cancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r1 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            java.lang.String r0 = "DecodeJob"
            java.lang.Object r1 = r5.f11219v
            java.lang.String r2 = "DecodeJob#run(model=%s)"
            com.bumptech.glide.p107h.p108a.C6013e.m11233a(r2, r1)
            com.bumptech.glide.load.a.d<?> r1 = r5.f11194B
            boolean r2 = r5.f11197E     // Catch:{ Throwable -> 0x0029 }
            if (r2 == 0) goto L_0x001b
            r5.m12137t()     // Catch:{ Throwable -> 0x0029 }
            if (r1 == 0) goto L_0x0017
            r1.mo18854b()
        L_0x0017:
            com.bumptech.glide.p107h.p108a.C6013e.m11231a()
            return
        L_0x001b:
            r5.m12142y()     // Catch:{ Throwable -> 0x0029 }
            if (r1 == 0) goto L_0x0023
        L_0x0020:
            r1.mo18854b()
        L_0x0023:
            com.bumptech.glide.p107h.p108a.C6013e.m11231a()
            goto L_0x0066
        L_0x0027:
            r0 = move-exception
            goto L_0x0069
        L_0x0029:
            r2 = move-exception
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x0051
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            r3.<init>()     // Catch:{ all -> 0x0027 }
            java.lang.String r4 = "DecodeJob threw unexpectedly, isCancelled: "
            r3.append(r4)     // Catch:{ all -> 0x0027 }
            boolean r4 = r5.f11197E     // Catch:{ all -> 0x0027 }
            r3.append(r4)     // Catch:{ all -> 0x0027 }
            java.lang.String r4 = ", stage: "
            r3.append(r4)     // Catch:{ all -> 0x0027 }
            com.bumptech.glide.load.engine.j$g r4 = r5.f11215r     // Catch:{ all -> 0x0027 }
            r3.append(r4)     // Catch:{ all -> 0x0027 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0027 }
            android.util.Log.d(r0, r3, r2)     // Catch:{ all -> 0x0027 }
        L_0x0051:
            com.bumptech.glide.load.engine.j$g r0 = r5.f11215r     // Catch:{ all -> 0x0027 }
            com.bumptech.glide.load.engine.j$g r3 = com.bumptech.glide.load.engine.C6311j.C6318g.ENCODE     // Catch:{ all -> 0x0027 }
            if (r0 == r3) goto L_0x005f
            java.util.List<java.lang.Throwable> r0 = r5.f11199b     // Catch:{ all -> 0x0027 }
            r0.add(r2)     // Catch:{ all -> 0x0027 }
            r5.m12137t()     // Catch:{ all -> 0x0027 }
        L_0x005f:
            boolean r0 = r5.f11197E     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0067
            if (r1 == 0) goto L_0x0023
            goto L_0x0020
        L_0x0066:
            return
        L_0x0067:
            throw r2     // Catch:{ all -> 0x0027 }
        L_0x0069:
            if (r1 == 0) goto L_0x006e
            r1.mo18854b()
        L_0x006e:
            com.bumptech.glide.p107h.p108a.C6013e.m11231a()
            goto L_0x0073
        L_0x0072:
            throw r0
        L_0x0073:
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.C6311j.run():void");
    }

    /* renamed from: y */
    private void m12142y() {
        int i = C6310i.f11190a[this.f11216s.ordinal()];
        if (i == 1) {
            this.f11215r = m12129a(C6318g.INITIALIZE);
            this.f11195C = m12136s();
            m12141x();
        } else if (i == 2) {
            m12141x();
        } else if (i == 3) {
            m12135j();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized run reason: ");
            sb.append(this.f11216s);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: s */
    private C6307g m12136s() {
        int i = C6310i.f11191b[this.f11215r.ordinal()];
        if (i == 1) {
            return new C6237F(this.f11198a, this);
        }
        if (i == 2) {
            return new C6303d(this.f11198a, this);
        }
        if (i == 3) {
            return new C6242I(this.f11198a, this);
        }
        if (i == 4) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized stage: ");
        sb.append(this.f11215r);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: x */
    private void m12141x() {
        this.f11220w = Thread.currentThread();
        this.f11217t = C6020e.m11250a();
        boolean isStarted = false;
        while (!this.f11197E && this.f11195C != null) {
            boolean a = this.f11195C.mo19101a();
            isStarted = a;
            if (a) {
                break;
            }
            this.f11215r = m12129a(this.f11215r);
            this.f11195C = m12136s();
            if (this.f11215r == C6318g.SOURCE) {
                mo19121f();
                return;
            }
        }
        if ((this.f11215r == C6318g.FINISHED || this.f11197E) && !isStarted) {
            m12137t();
        }
    }

    /* renamed from: t */
    private void m12137t() {
        m12143z();
        this.f11213p.mo19259a(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList<Throwable>(this.f11199b)));
        m12139v();
    }

    /* renamed from: a */
    private void m12131a(C6236E<R> resource, C6031a dataSource) {
        m12143z();
        this.f11213p.mo19258a(resource, dataSource);
    }

    /* renamed from: z */
    private void m12143z() {
        this.f11200c.mo18795b();
        if (!this.f11196D) {
            this.f11196D = true;
            return;
        }
        throw new IllegalStateException("Already notified");
    }

    /* renamed from: a */
    private C6318g m12129a(C6318g current) {
        int i = C6310i.f11191b[current.ordinal()];
        if (i == 1) {
            return this.f11211n.mo19273a() ? C6318g.DATA_CACHE : m12129a(C6318g.DATA_CACHE);
        } else if (i == 2) {
            return this.f11218u ? C6318g.FINISHED : C6318g.SOURCE;
        } else if (i == 3 || i == 4) {
            return C6318g.FINISHED;
        } else {
            if (i == 5) {
                return this.f11211n.mo19276b() ? C6318g.RESOURCE_CACHE : m12129a(C6318g.RESOURCE_CACHE);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized stage: ");
            sb.append(current);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f */
    public void mo19121f() {
        this.f11216s = C6317f.SWITCH_TO_SOURCE_SERVICE;
        this.f11213p.mo19260a(this);
    }

    /* renamed from: a */
    public void mo19120a(C6344g sourceKey, Object data, C6042d<?> fetcher, C6031a dataSource, C6344g attemptedKey) {
        this.f11221x = sourceKey;
        this.f11223z = data;
        this.f11194B = fetcher;
        this.f11193A = dataSource;
        this.f11222y = attemptedKey;
        if (Thread.currentThread() != this.f11220w) {
            this.f11216s = C6317f.DECODE_DATA;
            this.f11213p.mo19260a(this);
            return;
        }
        C6013e.m11232a("DecodeJob.decodeFromRetrievedData");
        try {
            m12135j();
        } finally {
            C6013e.m11231a();
        }
    }

    /* renamed from: a */
    public void mo19119a(C6344g attemptedKey, Exception e, C6042d<?> fetcher, C6031a dataSource) {
        fetcher.mo18854b();
        GlideException exception = new GlideException("Fetching data failed", (Throwable) e);
        exception.mo19106a(attemptedKey, dataSource, fetcher.mo18847a());
        this.f11199b.add(exception);
        if (Thread.currentThread() != this.f11220w) {
            this.f11216s = C6317f.SWITCH_TO_SOURCE_SERVICE;
            this.f11213p.mo19260a(this);
            return;
        }
        m12141x();
    }

    /* renamed from: j */
    private void m12135j() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.f11217t;
            StringBuilder sb = new StringBuilder();
            sb.append("data: ");
            sb.append(this.f11223z);
            sb.append(", cache key: ");
            sb.append(this.f11221x);
            sb.append(", fetcher: ");
            sb.append(this.f11194B);
            m12133a("Retrieved data", j, sb.toString());
        }
        C6236E e = null;
        try {
            e = m12126a(this.f11194B, (Data) this.f11223z, this.f11193A);
        } catch (GlideException e2) {
            e2.mo19105a(this.f11222y, this.f11193A);
            this.f11199b.add(e2);
        }
        if (e != null) {
            m12134b(e, this.f11193A);
        } else {
            m12141x();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private void m12134b(C6236E<R> resource, C6031a dataSource) {
        if (resource instanceof C6342z) {
            ((C6342z) resource).initialize();
        }
        C6236E e = resource;
        C6235D d = 0;
        if (this.f11203f.mo19265b()) {
            C6235D a = C6235D.m11885a(resource);
            e = a;
            d = a;
        }
        m12131a(e, dataSource);
        this.f11215r = C6318g.ENCODE;
        try {
            if (this.f11203f.mo19265b()) {
                this.f11203f.mo19263a(this.f11201d, this.f11212o);
            }
            if (d != 0) {
                d.mo19100d();
            }
            m12138u();
        } catch (Throwable th) {
            if (d != 0) {
                d.mo19100d();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private <Data> C6236E<R> m12126a(C6042d<?> fetcher, Data data, C6031a dataSource) throws GlideException {
        if (data == null) {
            fetcher.mo18854b();
            return null;
        }
        try {
            long startTime = C6020e.m11250a();
            Resource<R> result = m12127a(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded result ");
                sb.append(result);
                m12132a(sb.toString(), startTime);
            }
            return result;
        } finally {
            fetcher.mo18854b();
        }
    }

    /* renamed from: a */
    private <Data> C6236E<R> m12127a(Data data, C6031a dataSource) throws GlideException {
        return m12128a(data, dataSource, (C6233B<Data, ResourceType, R>) this.f11198a.mo19228a(data.getClass()));
    }

    /* renamed from: a */
    private C6349k m12130a(C6031a dataSource) {
        C6349k options = this.f11212o;
        if (VERSION.SDK_INT < 26 || options.mo19310a(C6169l.f10880d) != null) {
            return options;
        }
        if (dataSource == C6031a.RESOURCE_DISK_CACHE || this.f11198a.mo19249n()) {
            options = new C6349k();
            options.mo19311a(this.f11212o);
            options.mo19309a(C6169l.f10880d, Boolean.valueOf(true));
        }
        return options;
    }

    /* renamed from: a */
    private <Data, ResourceType> C6236E<R> m12128a(Data data, C6031a dataSource, C6233B<Data, ResourceType, R> path) throws GlideException {
        C6349k options = m12130a(dataSource);
        C6044e b = this.f11205h.mo18654f().mo18525b(data);
        try {
            return path.mo19098a(b, options, this.f11209l, this.f11210m, new C6313b(dataSource));
        } finally {
            b.mo18870b();
        }
    }

    /* renamed from: a */
    private void m12132a(String message, long startTime) {
        m12133a(message, startTime, (String) null);
    }

    /* renamed from: a */
    private void m12133a(String message, long startTime, String extraArgs) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        sb.append(" in ");
        sb.append(C6020e.m11249a(startTime));
        sb.append(", load key: ");
        sb.append(this.f11208k);
        if (extraArgs != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(extraArgs);
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    /* renamed from: e */
    public C6015g mo18779e() {
        return this.f11200c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <Z> C6236E<Z> mo19251a(C6031a dataSource, C6236E<Z> decoded) {
        C6352n nVar;
        C6236E<Z> e;
        C6145c encodeStrategy;
        C6351m mVar;
        C6344g key;
        C6351m mVar2;
        C6031a aVar = dataSource;
        C6236E<Z> e2 = decoded;
        Class<Z> resourceSubClass = decoded.get().getClass();
        C6236E<Z> e3 = decoded;
        if (aVar != C6031a.RESOURCE_DISK_CACHE) {
            C6352n b = this.f11198a.mo19235b(resourceSubClass);
            nVar = b;
            e = b.transform(this.f11205h, e2, this.f11209l, this.f11210m);
        } else {
            nVar = null;
            e = e3;
        }
        if (!e2.equals(e)) {
            decoded.mo18969b();
        }
        if (this.f11198a.mo19236b(e)) {
            C6351m a = this.f11198a.mo19229a(e);
            mVar = a;
            encodeStrategy = a.mo18974a(this.f11212o);
        } else {
            mVar = null;
            encodeStrategy = C6145c.NONE;
        }
        C6236E<Z> e4 = e;
        boolean isFromAlternateCacheKey = !this.f11198a.mo19233a(this.f11221x);
        if (!this.f11211n.mo19275a(isFromAlternateCacheKey, aVar, encodeStrategy)) {
            C6351m mVar3 = mVar;
            return e4;
        } else if (mVar != null) {
            int i = C6310i.f11192c[encodeStrategy.ordinal()];
            if (i == 1) {
                mVar2 = mVar;
                key = new C6305e(this.f11221x, this.f11206i);
            } else if (i == 2) {
                boolean z = isFromAlternateCacheKey;
                mVar2 = mVar;
                C6238G g = new C6238G(this.f11198a.mo19234b(), this.f11221x, this.f11206i, this.f11209l, this.f11210m, nVar, resourceSubClass, this.f11212o);
                key = g;
            } else {
                C6351m mVar4 = mVar;
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown strategy: ");
                sb.append(encodeStrategy);
                throw new IllegalArgumentException(sb.toString());
            }
            C6235D a2 = C6235D.m11885a(e);
            this.f11203f.mo19264a(key, mVar2, a2);
            return a2;
        } else {
            C6351m mVar5 = mVar;
            throw new NoResultEncoderAvailableException(e.get().getClass());
        }
    }
}
