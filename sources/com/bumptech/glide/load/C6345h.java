package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.C6236E;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.bumptech.glide.load.h */
/* compiled from: MultiTransformation */
public class C6345h<T> implements C6352n<T> {

    /* renamed from: a */
    private final Collection<? extends C6352n<T>> f11319a;

    @SafeVarargs
    public C6345h(C6352n<T>... transformations) {
        if (transformations.length != 0) {
            this.f11319a = Arrays.asList(transformations);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public C6236E<T> transform(Context context, C6236E<T> resource, int outWidth, int outHeight) {
        C6236E<T> e = resource;
        Iterator it = this.f11319a.iterator();
        while (it.hasNext()) {
            C6236E<T> transform = ((C6352n) it.next()).transform(context, e, outWidth, outHeight);
            if (e != null && !e.equals(resource) && !e.equals(transform)) {
                e.mo18969b();
            }
            e = transform;
        }
        return e;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C6345h)) {
            return false;
        }
        return this.f11319a.equals(((C6345h) o).f11319a);
    }

    public int hashCode() {
        return this.f11319a.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator it = this.f11319a.iterator();
        while (it.hasNext()) {
            ((C6352n) it.next()).updateDiskCacheKey(messageDigest);
        }
    }
}
