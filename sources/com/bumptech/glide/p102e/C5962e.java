package com.bumptech.glide.p102e;

import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.provider.ResourceDecoderRegistry.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.e.e */
/* compiled from: ResourceDecoderRegistry */
public class C5962e {

    /* renamed from: a */
    private final List<String> f10513a = new ArrayList();

    /* renamed from: b */
    private final Map<String, List<C5963a<?, ?>>> f10514b = new HashMap();

    /* renamed from: com.bumptech.glide.e.e$a */
    /* compiled from: ResourceDecoderRegistry */
    private static class C5963a<T, R> {

        /* renamed from: a */
        private final Class<T> f10515a;

        /* renamed from: b */
        final Class<R> f10516b;

        /* renamed from: c */
        final C6350l<T, R> f10517c;

        public C5963a(Class<T> dataClass, Class<R> resourceClass, C6350l<T, R> decoder) {
            this.f10515a = dataClass;
            this.f10516b = resourceClass;
            this.f10517c = decoder;
        }

        /* renamed from: a */
        public boolean mo18669a(Class<?> dataClass, Class<?> resourceClass) {
            return this.f10515a.isAssignableFrom(dataClass) && resourceClass.isAssignableFrom(this.f10516b);
        }
    }

    /* renamed from: a */
    public synchronized void mo18667a(List<String> buckets) {
        List<String> previousBuckets = new ArrayList<>(this.f10513a);
        this.f10513a.clear();
        this.f10513a.addAll(buckets);
        for (String previousBucket : previousBuckets) {
            if (!buckets.contains(previousBucket)) {
                this.f10513a.add(previousBucket);
            }
        }
    }

    /* renamed from: a */
    public synchronized <T, R> List<C6350l<T, R>> mo18665a(Class<T> dataClass, Class<R> resourceClass) {
        List<ResourceDecoder<T, R>> result;
        result = new ArrayList<>();
        for (String bucket : this.f10513a) {
            List<Entry<?, ?>> entries = (List) this.f10514b.get(bucket);
            if (entries != null) {
                for (Entry<?, ?> entry : entries) {
                    if (entry.mo18669a(dataClass, resourceClass)) {
                        result.add(entry.f10517c);
                    }
                }
            }
        }
        return result;
    }

    /* renamed from: b */
    public synchronized <T, R> List<Class<R>> mo18668b(Class<T> dataClass, Class<R> resourceClass) {
        List<Class<R>> result;
        result = new ArrayList<>();
        for (String bucket : this.f10513a) {
            List<Entry<?, ?>> entries = (List) this.f10514b.get(bucket);
            if (entries != null) {
                for (Entry<?, ?> entry : entries) {
                    if (entry.mo18669a(dataClass, resourceClass) && !result.contains(entry.f10516b)) {
                        result.add(entry.f10516b);
                    }
                }
            }
        }
        return result;
    }

    /* renamed from: a */
    public synchronized <T, R> void mo18666a(String bucket, C6350l<T, R> decoder, Class<T> dataClass, Class<R> resourceClass) {
        m11026a(bucket).add(new C5963a(dataClass, resourceClass, decoder));
    }

    /* renamed from: a */
    private synchronized List<C5963a<?, ?>> m11026a(String bucket) {
        List<C5963a<?, ?>> list;
        if (!this.f10513a.contains(bucket)) {
            this.f10513a.add(bucket);
        }
        list = (List) this.f10514b.get(bucket);
        if (list == null) {
            list = new ArrayList<>();
            this.f10514b.put(bucket, list);
        }
        return list;
    }
}
