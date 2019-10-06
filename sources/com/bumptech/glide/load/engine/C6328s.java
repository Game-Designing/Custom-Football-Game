package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.C5956e;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.p121b.C6269a;
import com.bumptech.glide.load.engine.p121b.C6269a.C6270a;
import com.bumptech.glide.load.engine.p121b.C6272b;
import com.bumptech.glide.load.engine.p121b.C6282i;
import com.bumptech.glide.load.engine.p121b.C6282i.C6283a;
import com.bumptech.glide.load.engine.p122c.C6295b;
import com.bumptech.glide.p103f.C5992h;
import com.bumptech.glide.p107h.C6020e;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import com.bumptech.glide.p107h.p108a.C6008d;
import com.bumptech.glide.p107h.p108a.C6008d.C6009a;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.engine.s */
/* compiled from: Engine */
public class C6328s implements C6337v, C6283a, C6341a {

    /* renamed from: a */
    private static final boolean f11254a = Log.isLoggable("Engine", 2);

    /* renamed from: b */
    private final C6232A f11255b;

    /* renamed from: c */
    private final C6339x f11256c;

    /* renamed from: d */
    private final C6282i f11257d;

    /* renamed from: e */
    private final C6330b f11258e;

    /* renamed from: f */
    private final C6240H f11259f;

    /* renamed from: g */
    private final C6331c f11260g;

    /* renamed from: h */
    private final C6329a f11261h;

    /* renamed from: i */
    private final C6291c f11262i;

    /* renamed from: com.bumptech.glide.load.engine.s$a */
    /* compiled from: Engine */
    static class C6329a {

        /* renamed from: a */
        final C6315d f11263a;

        /* renamed from: b */
        final C1269m<C6311j<?>> f11264b = C6008d.m11222a(150, (C6009a<T>) new C6327r<T>(this));

        /* renamed from: c */
        private int f11265c;

        C6329a(C6315d diskCacheProvider) {
            this.f11263a = diskCacheProvider;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <R> C6311j<R> mo19282a(C5956e glideContext, Object model, C6338w loadKey, C6344g signature, int width, int height, Class<?> resourceClass, Class<R> transcodeClass, C6001h priority, C6326q diskCacheStrategy, Map<Class<?>, C6352n<?>> transformations, boolean isTransformationRequired, boolean isScaleOnlyOrNoTransform, boolean onlyRetrieveFromCache, C6349k options, C6312a<R> callback) {
            C5956e eVar = glideContext;
            Object obj = model;
            C6338w wVar = loadKey;
            C6344g gVar = signature;
            int i = width;
            int i2 = height;
            Class<?> cls = resourceClass;
            Class<R> cls2 = transcodeClass;
            C6001h hVar = priority;
            C6326q qVar = diskCacheStrategy;
            Map<Class<?>, C6352n<?>> map = transformations;
            boolean z = isTransformationRequired;
            boolean z2 = isScaleOnlyOrNoTransform;
            boolean z3 = onlyRetrieveFromCache;
            C6349k kVar = options;
            C6312a<R> aVar = callback;
            C6311j jVar = (C6311j) this.f11264b.mo9148a();
            C6024i.m11264a(jVar);
            C6311j<R> jVar2 = jVar;
            C6311j<R> jVar3 = jVar2;
            int i3 = this.f11265c;
            int i4 = i3;
            this.f11265c = i3 + 1;
            jVar3.mo19252a(eVar, obj, wVar, gVar, i, i2, cls, cls2, hVar, qVar, map, z, z2, z3, kVar, aVar, i4);
            return jVar2;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.s$b */
    /* compiled from: Engine */
    static class C6330b {

        /* renamed from: a */
        final C6295b f11266a;

        /* renamed from: b */
        final C6295b f11267b;

        /* renamed from: c */
        final C6295b f11268c;

        /* renamed from: d */
        final C6295b f11269d;

        /* renamed from: e */
        final C6337v f11270e;

        /* renamed from: f */
        final C1269m<C6334u<?>> f11271f = C6008d.m11222a(150, (C6009a<T>) new C6333t<T>(this));

        C6330b(C6295b diskCacheExecutor, C6295b sourceExecutor, C6295b sourceUnlimitedExecutor, C6295b animationExecutor, C6337v listener) {
            this.f11266a = diskCacheExecutor;
            this.f11267b = sourceExecutor;
            this.f11268c = sourceUnlimitedExecutor;
            this.f11269d = animationExecutor;
            this.f11270e = listener;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <R> C6334u<R> mo19283a(C6344g key, boolean isMemoryCacheable, boolean useUnlimitedSourceGeneratorPool, boolean useAnimationPool, boolean onlyRetrieveFromCache) {
            C6334u<R> uVar = (C6334u) this.f11271f.mo9148a();
            C6024i.m11264a(uVar);
            C6334u<R> uVar2 = uVar;
            uVar2.mo19285a(key, isMemoryCacheable, useUnlimitedSourceGeneratorPool, useAnimationPool, onlyRetrieveFromCache);
            return uVar2;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.s$c */
    /* compiled from: Engine */
    private static class C6331c implements C6315d {

        /* renamed from: a */
        private final C6270a f11272a;

        /* renamed from: b */
        private volatile C6269a f11273b;

        C6331c(C6270a factory) {
            this.f11272a = factory;
        }

        /* renamed from: a */
        public C6269a mo19266a() {
            if (this.f11273b == null) {
                synchronized (this) {
                    if (this.f11273b == null) {
                        this.f11273b = this.f11272a.build();
                    }
                    if (this.f11273b == null) {
                        this.f11273b = new C6272b();
                    }
                }
            }
            return this.f11273b;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.s$d */
    /* compiled from: Engine */
    public static class C6332d {

        /* renamed from: a */
        private final C6334u<?> f11274a;

        /* renamed from: b */
        private final C5992h f11275b;

        C6332d(C5992h cb, C6334u<?> engineJob) {
            this.f11275b = cb;
            this.f11274a = engineJob;
        }

        /* renamed from: a */
        public void mo19284a() {
            this.f11274a.mo19289b(this.f11275b);
        }
    }

    public C6328s(C6282i memoryCache, C6270a diskCacheFactory, C6295b diskCacheExecutor, C6295b sourceExecutor, C6295b sourceUnlimitedExecutor, C6295b animationExecutor, boolean isActiveResourceRetentionAllowed) {
        this(memoryCache, diskCacheFactory, diskCacheExecutor, sourceExecutor, sourceUnlimitedExecutor, animationExecutor, null, null, null, null, null, null, isActiveResourceRetentionAllowed);
    }

    C6328s(C6282i cache, C6270a diskCacheFactory, C6295b diskCacheExecutor, C6295b sourceExecutor, C6295b sourceUnlimitedExecutor, C6295b animationExecutor, C6232A jobs, C6339x keyFactory, C6291c activeResources, C6330b engineJobFactory, C6329a decodeJobFactory, C6240H resourceRecycler, boolean isActiveResourceRetentionAllowed) {
        C6291c activeResources2;
        C6339x keyFactory2;
        C6232A jobs2;
        C6330b engineJobFactory2;
        C6329a decodeJobFactory2;
        C6240H resourceRecycler2;
        this.f11257d = cache;
        this.f11260g = new C6331c(diskCacheFactory);
        if (activeResources == null) {
            activeResources2 = new C6291c(isActiveResourceRetentionAllowed);
        } else {
            boolean z = isActiveResourceRetentionAllowed;
            activeResources2 = activeResources;
        }
        this.f11262i = activeResources2;
        activeResources2.mo19202a((C6341a) this);
        if (keyFactory == null) {
            keyFactory2 = new C6339x();
        } else {
            keyFactory2 = keyFactory;
        }
        this.f11256c = keyFactory2;
        if (jobs == null) {
            jobs2 = new C6232A();
        } else {
            jobs2 = jobs;
        }
        this.f11255b = jobs2;
        if (engineJobFactory == null) {
            engineJobFactory2 = new C6330b(diskCacheExecutor, sourceExecutor, sourceUnlimitedExecutor, animationExecutor, this);
        } else {
            engineJobFactory2 = engineJobFactory;
        }
        this.f11258e = engineJobFactory2;
        if (decodeJobFactory == null) {
            decodeJobFactory2 = new C6329a(this.f11260g);
        } else {
            decodeJobFactory2 = decodeJobFactory;
        }
        this.f11261h = decodeJobFactory2;
        if (resourceRecycler == null) {
            resourceRecycler2 = new C6240H();
        } else {
            resourceRecycler2 = resourceRecycler;
        }
        this.f11259f = resourceRecycler2;
        cache.mo19189a((C6283a) this);
    }

    /* renamed from: a */
    public <R> C6332d mo19277a(C5956e glideContext, Object model, C6344g signature, int width, int height, Class<?> resourceClass, Class<R> transcodeClass, C6001h priority, C6326q diskCacheStrategy, Map<Class<?>, C6352n<?>> transformations, boolean isTransformationRequired, boolean isScaleOnlyOrNoTransform, C6349k options, boolean isMemoryCacheable, boolean useUnlimitedSourceExecutorPool, boolean useAnimationPool, boolean onlyRetrieveFromCache, C5992h cb) {
        boolean z = isMemoryCacheable;
        C5992h hVar = cb;
        C6026k.m11283b();
        long startTime = f11254a ? C6020e.m11250a() : 0;
        C6338w key = this.f11256c.mo19297a(model, signature, width, height, transformations, resourceClass, transcodeClass, options);
        C6340y a = m12197a((C6344g) key, z);
        if (a != null) {
            hVar.mo18775a(a, C6031a.MEMORY_CACHE);
            if (f11254a) {
                m12198a("Loaded resource from active resources", startTime, (C6344g) key);
            }
            return null;
        }
        C6340y b = m12199b(key, z);
        if (b != null) {
            hVar.mo18775a(b, C6031a.MEMORY_CACHE);
            if (f11254a) {
                m12198a("Loaded resource from cache", startTime, (C6344g) key);
            }
            return null;
        }
        C6334u a2 = this.f11255b.mo19095a((C6344g) key, onlyRetrieveFromCache);
        if (a2 != null) {
            a2.mo19287a(hVar);
            if (f11254a) {
                m12198a("Added to existing load", startTime, (C6344g) key);
            }
            return new C6332d(hVar, a2);
        }
        C6334u a3 = this.f11258e.mo19283a(key, isMemoryCacheable, useUnlimitedSourceExecutorPool, useAnimationPool, onlyRetrieveFromCache);
        C6334u uVar = a2;
        C6340y yVar = b;
        C6340y yVar2 = a;
        DecodeJob<R> decodeJob = this.f11261h.mo19282a(glideContext, model, key, signature, width, height, resourceClass, transcodeClass, priority, diskCacheStrategy, transformations, isTransformationRequired, isScaleOnlyOrNoTransform, onlyRetrieveFromCache, options, a3);
        this.f11255b.mo19096a((C6344g) key, a3);
        a3.mo19287a(hVar);
        a3.mo19290b((C6311j<R>) decodeJob);
        if (f11254a) {
            m12198a("Started new load", startTime, (C6344g) key);
        }
        return new C6332d(hVar, a3);
    }

    /* renamed from: a */
    private static void m12198a(String log, long startTime, C6344g key) {
        StringBuilder sb = new StringBuilder();
        sb.append(log);
        sb.append(" in ");
        sb.append(C6020e.m11249a(startTime));
        sb.append("ms, key: ");
        sb.append(key);
        Log.v("Engine", sb.toString());
    }

    /* renamed from: a */
    private C6340y<?> m12197a(C6344g key, boolean isMemoryCacheable) {
        if (!isMemoryCacheable) {
            return null;
        }
        EngineResource<?> active = this.f11262i.mo19205b(key);
        if (active != null) {
            active.mo19299d();
        }
        return active;
    }

    /* renamed from: b */
    private C6340y<?> m12199b(C6344g key, boolean isMemoryCacheable) {
        if (!isMemoryCacheable) {
            return null;
        }
        EngineResource<?> cached = m12196a(key);
        if (cached != null) {
            cached.mo19299d();
            this.f11262i.mo19204a(key, cached);
        }
        return cached;
    }

    /* renamed from: a */
    private C6340y<?> m12196a(C6344g key) {
        C6236E a = this.f11257d.mo19186a(key);
        if (a == null) {
            return null;
        }
        if (a instanceof C6340y) {
            return (C6340y) a;
        }
        return new C6340y<>(a, true, true);
    }

    /* renamed from: b */
    public void mo19281b(C6236E<?> resource) {
        C6026k.m11283b();
        if (resource instanceof C6340y) {
            ((C6340y) resource).mo19302g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    /* renamed from: a */
    public void mo19279a(C6334u<?> engineJob, C6344g key, C6340y<?> resource) {
        C6026k.m11283b();
        if (resource != null) {
            resource.mo19298a(key, this);
            if (resource.mo19301f()) {
                this.f11262i.mo19204a(key, resource);
            }
        }
        this.f11255b.mo19097b(key, engineJob);
    }

    /* renamed from: a */
    public void mo19278a(C6334u<?> engineJob, C6344g key) {
        C6026k.m11283b();
        this.f11255b.mo19097b(key, engineJob);
    }

    /* renamed from: a */
    public void mo19192a(C6236E<?> resource) {
        C6026k.m11283b();
        this.f11259f.mo19117a(resource);
    }

    /* renamed from: a */
    public void mo19280a(C6344g cacheKey, C6340y<?> resource) {
        C6026k.m11283b();
        this.f11262i.mo19203a(cacheKey);
        if (resource.mo19301f()) {
            this.f11257d.mo19187a(cacheKey, resource);
        } else {
            this.f11259f.mo19117a(resource);
        }
    }
}
