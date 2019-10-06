package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.engine.p120a.C6250e;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c.a.h */
/* compiled from: CenterInside */
public class C6154h extends C6151e {

    /* renamed from: a */
    private static final byte[] f10860a = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(C6344g.f11318a);

    /* access modifiers changed from: protected */
    public Bitmap transform(C6250e pool, Bitmap toTransform, int outWidth, int outHeight) {
        return C6182v.m11734b(pool, toTransform, outWidth, outHeight);
    }

    public boolean equals(Object o) {
        return o instanceof C6154h;
    }

    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterInside".hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f10860a);
    }
}
