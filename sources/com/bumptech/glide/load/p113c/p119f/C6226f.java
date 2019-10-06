package com.bumptech.glide.load.p113c.p119f;

import com.bumptech.glide.load.resource.transcode.TranscoderRegistry.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.bumptech.glide.load.c.f.f */
/* compiled from: TranscoderRegistry */
public class C6226f {

    /* renamed from: a */
    private final List<C6227a<?, ?>> f10987a = new ArrayList();

    /* renamed from: com.bumptech.glide.load.c.f.f$a */
    /* compiled from: TranscoderRegistry */
    private static final class C6227a<Z, R> {

        /* renamed from: a */
        private final Class<Z> f10988a;

        /* renamed from: b */
        private final Class<R> f10989b;

        /* renamed from: c */
        final C6225e<Z, R> f10990c;

        C6227a(Class<Z> fromClass, Class<R> toClass, C6225e<Z, R> transcoder) {
            this.f10988a = fromClass;
            this.f10989b = toClass;
            this.f10990c = transcoder;
        }

        /* renamed from: a */
        public boolean mo19093a(Class<?> fromClass, Class<?> toClass) {
            return this.f10988a.isAssignableFrom(fromClass) && toClass.isAssignableFrom(this.f10989b);
        }
    }

    /* renamed from: a */
    public synchronized <Z, R> void mo19091a(Class<Z> decodedClass, Class<R> transcodedClass, C6225e<Z, R> transcoder) {
        this.f10987a.add(new C6227a(decodedClass, transcodedClass, transcoder));
    }

    /* renamed from: a */
    public synchronized <Z, R> C6225e<Z, R> mo19090a(Class<Z> resourceClass, Class<R> transcodedClass) {
        if (transcodedClass.isAssignableFrom(resourceClass)) {
            return C6228g.m11872a();
        }
        Iterator it = this.f10987a.iterator();
        while (it.hasNext()) {
            Entry<?, ?> entry = (C6227a) it.next();
            if (entry.mo19093a(resourceClass, transcodedClass)) {
                return entry.f10990c;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No transcoder registered to transcode from ");
        sb.append(resourceClass);
        sb.append(" to ");
        sb.append(transcodedClass);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public synchronized <Z, R> List<Class<R>> mo19092b(Class<Z> resourceClass, Class<R> transcodeClass) {
        List<Class<R>> transcodeClasses = new ArrayList<>();
        if (transcodeClass.isAssignableFrom(resourceClass)) {
            transcodeClasses.add(transcodeClass);
            return transcodeClasses;
        }
        Iterator it = this.f10987a.iterator();
        while (it.hasNext()) {
            if (((C6227a) it.next()).mo19093a(resourceClass, transcodeClass)) {
                transcodeClasses.add(transcodeClass);
            }
        }
        return transcodeClasses;
    }
}
