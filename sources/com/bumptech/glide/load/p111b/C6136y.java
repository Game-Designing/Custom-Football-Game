package com.bumptech.glide.load.p111b;

import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.MultiModelLoaderFactory.Entry;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p107h.C6024i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.b.y */
/* compiled from: MultiModelLoaderFactory */
public class C6136y {

    /* renamed from: a */
    private static final C6139c f10829a = new C6139c();

    /* renamed from: b */
    private static final C6128u<Object, Object> f10830b = new C6137a();

    /* renamed from: c */
    private final List<C6138b<?, ?>> f10831c;

    /* renamed from: d */
    private final C6139c f10832d;

    /* renamed from: e */
    private final Set<C6138b<?, ?>> f10833e;

    /* renamed from: f */
    private final C1269m<List<Throwable>> f10834f;

    /* renamed from: com.bumptech.glide.load.b.y$a */
    /* compiled from: MultiModelLoaderFactory */
    private static class C6137a implements C6128u<Object, Object> {
        C6137a() {
        }

        /* renamed from: a */
        public C6129a<Object> mo18889a(Object o, int width, int height, C6349k options) {
            return null;
        }

        /* renamed from: a */
        public boolean mo18891a(Object o) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.b.y$b */
    /* compiled from: MultiModelLoaderFactory */
    private static class C6138b<Model, Data> {

        /* renamed from: a */
        private final Class<Model> f10835a;

        /* renamed from: b */
        final Class<Data> f10836b;

        /* renamed from: c */
        final C6130v<? extends Model, ? extends Data> f10837c;

        public C6138b(Class<Model> modelClass, Class<Data> dataClass, C6130v<? extends Model, ? extends Data> factory) {
            this.f10835a = modelClass;
            this.f10836b = dataClass;
            this.f10837c = factory;
        }

        /* renamed from: a */
        public boolean mo18964a(Class<?> modelClass, Class<?> dataClass) {
            return mo18963a(modelClass) && this.f10836b.isAssignableFrom(dataClass);
        }

        /* renamed from: a */
        public boolean mo18963a(Class<?> modelClass) {
            return this.f10835a.isAssignableFrom(modelClass);
        }
    }

    /* renamed from: com.bumptech.glide.load.b.y$c */
    /* compiled from: MultiModelLoaderFactory */
    static class C6139c {
        C6139c() {
        }

        /* renamed from: a */
        public <Model, Data> C6134x<Model, Data> mo18965a(List<C6128u<Model, Data>> modelLoaders, C1269m<List<Throwable>> throwableListPool) {
            return new C6134x<>(modelLoaders, throwableListPool);
        }
    }

    public C6136y(C1269m<List<Throwable>> throwableListPool) {
        this(throwableListPool, f10829a);
    }

    C6136y(C1269m<List<Throwable>> throwableListPool, C6139c factory) {
        this.f10831c = new ArrayList();
        this.f10833e = new HashSet();
        this.f10834f = throwableListPool;
        this.f10832d = factory;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized <Model, Data> void mo18961a(Class<Model> modelClass, Class<Data> dataClass, C6130v<? extends Model, ? extends Data> factory) {
        m11592a(modelClass, dataClass, factory, true);
    }

    /* renamed from: a */
    private <Model, Data> void m11592a(Class<Model> modelClass, Class<Data> dataClass, C6130v<? extends Model, ? extends Data> factory, boolean append) {
        Entry<Model, Data> entry = new C6138b<>(modelClass, dataClass, factory);
        List<C6138b<?, ?>> list = this.f10831c;
        list.add(append ? list.size() : 0, entry);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized <Model> List<C6128u<Model, ?>> mo18960a(Class<Model> modelClass) {
        List<ModelLoader<Model, ?>> loaders;
        try {
            loaders = new ArrayList<>();
            Iterator it = this.f10831c.iterator();
            while (it.hasNext()) {
                Entry<?, ?> entry = (C6138b) it.next();
                if (!this.f10833e.contains(entry)) {
                    if (entry.mo18963a(modelClass)) {
                        this.f10833e.add(entry);
                        loaders.add(m11591a((C6138b<?, ?>) entry));
                        this.f10833e.remove(entry);
                    }
                }
            }
        } catch (Throwable t) {
            this.f10833e.clear();
            throw t;
        }
        return loaders;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized List<Class<?>> mo18962b(Class<?> modelClass) {
        List<Class<?>> result;
        result = new ArrayList<>();
        Iterator it = this.f10831c.iterator();
        while (it.hasNext()) {
            Entry<?, ?> entry = (C6138b) it.next();
            if (!result.contains(entry.f10836b) && entry.mo18963a(modelClass)) {
                result.add(entry.f10836b);
            }
        }
        return result;
    }

    /* renamed from: a */
    public synchronized <Model, Data> C6128u<Model, Data> mo18959a(Class<Model> modelClass, Class<Data> dataClass) {
        try {
            List<ModelLoader<Model, Data>> loaders = new ArrayList<>();
            boolean ignoredAnyEntries = false;
            Iterator it = this.f10831c.iterator();
            while (it.hasNext()) {
                Entry<?, ?> entry = (C6138b) it.next();
                if (this.f10833e.contains(entry)) {
                    ignoredAnyEntries = true;
                } else if (entry.mo18964a(modelClass, dataClass)) {
                    this.f10833e.add(entry);
                    loaders.add(m11591a((C6138b<?, ?>) entry));
                    this.f10833e.remove(entry);
                }
            }
            if (loaders.size() > 1) {
                return this.f10832d.mo18965a(loaders, this.f10834f);
            } else if (loaders.size() == 1) {
                return (C6128u) loaders.get(0);
            } else if (ignoredAnyEntries) {
                return m11590a();
            } else {
                throw new NoModelLoaderAvailableException(modelClass, dataClass);
            }
        } catch (Throwable t) {
            this.f10833e.clear();
            throw t;
        }
    }

    /* renamed from: a */
    private <Model, Data> C6128u<Model, Data> m11591a(C6138b<?, ?> entry) {
        C6128u<Model, Data> a = entry.f10837c.mo18893a(this);
        C6024i.m11264a(a);
        return a;
    }

    /* renamed from: a */
    private static <Model, Data> C6128u<Model, Data> m11590a() {
        return f10830b;
    }
}
