package com.bumptech.glide.p102e;

import com.bumptech.glide.p107h.C6023h;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: com.bumptech.glide.e.d */
/* compiled from: ModelToResourceClassCache */
public class C5961d {

    /* renamed from: a */
    private final AtomicReference<C6023h> f10511a = new AtomicReference<>();

    /* renamed from: b */
    private final C1253b<C6023h, List<Class<?>>> f10512b = new C1253b<>();

    /* renamed from: a */
    public List<Class<?>> mo18663a(Class<?> modelClass, Class<?> resourceClass) {
        List<Class<?>> result;
        C6023h key = (C6023h) this.f10511a.getAndSet(null);
        if (key == null) {
            key = new C6023h(modelClass, resourceClass);
        } else {
            key.mo18826a(modelClass, resourceClass);
        }
        synchronized (this.f10512b) {
            result = (List) this.f10512b.get(key);
        }
        this.f10511a.set(key);
        return result;
    }

    /* renamed from: a */
    public void mo18664a(Class<?> modelClass, Class<?> resourceClass, List<Class<?>> resourceClasses) {
        synchronized (this.f10512b) {
            this.f10512b.put(new C6023h(modelClass, resourceClass), resourceClasses);
        }
    }
}
