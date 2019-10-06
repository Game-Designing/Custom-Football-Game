package com.bumptech.glide.p102e;

import com.bumptech.glide.load.C6351m;
import com.bumptech.glide.provider.ResourceEncoderRegistry.Entry;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.e.f */
/* compiled from: ResourceEncoderRegistry */
public class C5964f {

    /* renamed from: a */
    private final List<C5965a<?>> f10518a = new ArrayList();

    /* renamed from: com.bumptech.glide.e.f$a */
    /* compiled from: ResourceEncoderRegistry */
    private static final class C5965a<T> {

        /* renamed from: a */
        private final Class<T> f10519a;

        /* renamed from: b */
        final C6351m<T> f10520b;

        C5965a(Class<T> resourceClass, C6351m<T> encoder) {
            this.f10519a = resourceClass;
            this.f10520b = encoder;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo18672a(Class<?> resourceClass) {
            return this.f10519a.isAssignableFrom(resourceClass);
        }
    }

    /* renamed from: a */
    public synchronized <Z> void mo18671a(Class<Z> resourceClass, C6351m<Z> encoder) {
        this.f10518a.add(new C5965a(resourceClass, encoder));
    }

    /* renamed from: a */
    public synchronized <Z> C6351m<Z> mo18670a(Class<Z> resourceClass) {
        int size = this.f10518a.size();
        for (int i = 0; i < size; i++) {
            Entry<?> entry = (C5965a) this.f10518a.get(i);
            if (entry.mo18672a(resourceClass)) {
                return entry.f10520b;
            }
        }
        return null;
    }
}
