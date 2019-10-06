package com.bumptech.glide.load.p111b;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderRegistry.ModelLoaderCache.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1269m;

/* renamed from: com.bumptech.glide.load.b.w */
/* compiled from: ModelLoaderRegistry */
public class C6131w {

    /* renamed from: a */
    private final C6136y f10817a;

    /* renamed from: b */
    private final C6132a f10818b;

    /* renamed from: com.bumptech.glide.load.b.w$a */
    /* compiled from: ModelLoaderRegistry */
    private static class C6132a {

        /* renamed from: a */
        private final Map<Class<?>, C6133a<?>> f10819a = new HashMap();

        /* renamed from: com.bumptech.glide.load.b.w$a$a */
        /* compiled from: ModelLoaderRegistry */
        private static class C6133a<Model> {

            /* renamed from: a */
            final List<C6128u<Model, ?>> f10820a;

            public C6133a(List<C6128u<Model, ?>> loaders) {
                this.f10820a = loaders;
            }
        }

        C6132a() {
        }

        /* renamed from: a */
        public void mo18956a() {
            this.f10819a.clear();
        }

        /* renamed from: a */
        public <Model> void mo18957a(Class<Model> modelClass, List<C6128u<Model, ?>> loaders) {
            if (((C6133a) this.f10819a.put(modelClass, new C6133a(loaders))) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Already cached loaders for model: ");
                sb.append(modelClass);
                throw new IllegalStateException(sb.toString());
            }
        }

        /* renamed from: a */
        public <Model> List<C6128u<Model, ?>> mo18955a(Class<Model> modelClass) {
            Entry<Model> entry = (C6133a) this.f10819a.get(modelClass);
            if (entry == null) {
                return null;
            }
            return entry.f10820a;
        }
    }

    public C6131w(C1269m<List<Throwable>> throwableListPool) {
        this(new C6136y(throwableListPool));
    }

    private C6131w(C6136y multiModelLoaderFactory) {
        this.f10818b = new C6132a();
        this.f10817a = multiModelLoaderFactory;
    }

    /* renamed from: a */
    public synchronized <Model, Data> void mo18954a(Class<Model> modelClass, Class<Data> dataClass, C6130v<? extends Model, ? extends Data> factory) {
        this.f10817a.mo18961a(modelClass, dataClass, factory);
        this.f10818b.mo18956a();
    }

    /* renamed from: a */
    public synchronized <A> List<C6128u<A, ?>> mo18953a(A model) {
        List<ModelLoader<A, ?>> filteredLoaders;
        List<ModelLoader<A, ?>> modelLoaders = m11574b(m11573b(model));
        int size = modelLoaders.size();
        filteredLoaders = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ModelLoader<A, ?> loader = (C6128u) modelLoaders.get(i);
            if (loader.mo18891a(model)) {
                filteredLoaders.add(loader);
            }
        }
        return filteredLoaders;
    }

    /* renamed from: a */
    public synchronized List<Class<?>> mo18952a(Class<?> modelClass) {
        return this.f10817a.mo18962b(modelClass);
    }

    /* renamed from: b */
    private <A> List<C6128u<A, ?>> m11574b(Class<A> modelClass) {
        List<ModelLoader<A, ?>> loaders = this.f10818b.mo18955a(modelClass);
        if (loaders != null) {
            return loaders;
        }
        List<ModelLoader<A, ?>> loaders2 = Collections.unmodifiableList(this.f10817a.mo18960a(modelClass));
        this.f10818b.mo18957a(modelClass, loaders2);
        return loaders2;
    }

    /* renamed from: b */
    private static <A> Class<A> m11573b(A model) {
        return model.getClass();
    }
}
