package com.bumptech.glide.p102e;

import com.bumptech.glide.load.C6229d;
import com.bumptech.glide.provider.EncoderRegistry.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.bumptech.glide.e.a */
/* compiled from: EncoderRegistry */
public class C5957a {

    /* renamed from: a */
    private final List<C5958a<?>> f10504a = new ArrayList();

    /* renamed from: com.bumptech.glide.e.a$a */
    /* compiled from: EncoderRegistry */
    private static final class C5958a<T> {

        /* renamed from: a */
        private final Class<T> f10505a;

        /* renamed from: b */
        final C6229d<T> f10506b;

        C5958a(Class<T> dataClass, C6229d<T> encoder) {
            this.f10505a = dataClass;
            this.f10506b = encoder;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo18657a(Class<?> dataClass) {
            return this.f10505a.isAssignableFrom(dataClass);
        }
    }

    /* renamed from: a */
    public synchronized <T> C6229d<T> mo18655a(Class<T> dataClass) {
        Iterator it = this.f10504a.iterator();
        while (it.hasNext()) {
            Entry<?> entry = (C5958a) it.next();
            if (entry.mo18657a(dataClass)) {
                return entry.f10506b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized <T> void mo18656a(Class<T> dataClass, C6229d<T> encoder) {
        this.f10504a.add(new C5958a(dataClass, encoder));
    }
}
