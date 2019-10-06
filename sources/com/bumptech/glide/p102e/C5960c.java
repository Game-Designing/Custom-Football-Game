package com.bumptech.glide.p102e;

import com.bumptech.glide.load.engine.C6233B;
import com.bumptech.glide.load.engine.C6319k;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.p113c.p119f.C6228g;
import com.bumptech.glide.p107h.C6023h;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: com.bumptech.glide.e.c */
/* compiled from: LoadPathCache */
public class C5960c {

    /* renamed from: a */
    private static final C6233B<?, ?, ?> f10508a;

    /* renamed from: b */
    private final C1253b<C6023h, C6233B<?, ?, ?>> f10509b = new C1253b<>();

    /* renamed from: c */
    private final AtomicReference<C6023h> f10510c = new AtomicReference<>();

    static {
        C6319k kVar = new C6319k(Object.class, Object.class, Object.class, Collections.emptyList(), new C6228g(), null);
        C6233B b = new C6233B(Object.class, Object.class, Object.class, Collections.singletonList(kVar), null);
        f10508a = b;
    }

    /* renamed from: a */
    public boolean mo18662a(C6233B<?, ?, ?> path) {
        return f10508a.equals(path);
    }

    /* renamed from: a */
    public <Data, TResource, Transcode> C6233B<Data, TResource, Transcode> mo18660a(Class<Data> dataClass, Class<TResource> resourceClass, Class<Transcode> transcodeClass) {
        LoadPath<?, ?, ?> result;
        C6023h key = m11020b(dataClass, resourceClass, transcodeClass);
        synchronized (this.f10509b) {
            result = (C6233B) this.f10509b.get(key);
        }
        this.f10510c.set(key);
        return result;
    }

    /* renamed from: a */
    public void mo18661a(Class<?> dataClass, Class<?> resourceClass, Class<?> transcodeClass, C6233B<?, ?, ?> loadPath) {
        synchronized (this.f10509b) {
            this.f10509b.put(new C6023h(dataClass, resourceClass, transcodeClass), loadPath != null ? loadPath : f10508a);
        }
    }

    /* renamed from: b */
    private C6023h m11020b(Class<?> dataClass, Class<?> resourceClass, Class<?> transcodeClass) {
        C6023h key = (C6023h) this.f10510c.getAndSet(null);
        if (key == null) {
            key = new C6023h();
        }
        key.mo18827a(dataClass, resourceClass, transcodeClass);
        return key;
    }
}
