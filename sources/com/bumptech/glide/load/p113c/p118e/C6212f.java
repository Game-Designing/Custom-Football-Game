package com.bumptech.glide.load.p113c.p118e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.p113c.p114a.C6150d;
import com.bumptech.glide.p107h.C6024i;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c.e.f */
/* compiled from: GifDrawableTransformation */
public class C6212f implements C6352n<C6208c> {

    /* renamed from: a */
    private final C6352n<Bitmap> f10953a;

    public C6212f(C6352n<Bitmap> wrapped) {
        C6024i.m11264a(wrapped);
        this.f10953a = wrapped;
    }

    public C6236E<C6208c> transform(Context context, C6236E<C6208c> resource, int outWidth, int outHeight) {
        C6208c drawable = (C6208c) resource.get();
        Resource<Bitmap> bitmapResource = new C6150d<>(drawable.mo19047c(), C5926c.m10916a(context).mo18581c());
        Resource<Bitmap> transformed = this.f10953a.transform(context, bitmapResource, outWidth, outHeight);
        if (!bitmapResource.equals(transformed)) {
            bitmapResource.mo18969b();
        }
        drawable.mo19045a(this.f10953a, (Bitmap) transformed.get());
        return resource;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C6212f)) {
            return false;
        }
        return this.f10953a.equals(((C6212f) o).f10953a);
    }

    public int hashCode() {
        return this.f10953a.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f10953a.updateDiskCacheKey(messageDigest);
    }
}
