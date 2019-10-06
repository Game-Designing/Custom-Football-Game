package com.bumptech.glide.load.p113c;

import android.content.Context;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6236E;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c.b */
/* compiled from: UnitTransformation */
public final class C6193b<T> implements C6352n<T> {

    /* renamed from: a */
    private static final C6352n<?> f10926a = new C6193b();

    /* renamed from: a */
    public static <T> C6193b<T> m11761a() {
        return (C6193b) f10926a;
    }

    private C6193b() {
    }

    public C6236E<T> transform(Context context, C6236E<T> resource, int outWidth, int outHeight) {
        return resource;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
