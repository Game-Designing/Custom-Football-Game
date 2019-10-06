package com.bumptech.glide.load.p113c.p114a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c.a.o */
/* compiled from: DrawableTransformation */
public class C6173o implements C6352n<Drawable> {

    /* renamed from: a */
    private final C6352n<Bitmap> f10891a;

    /* renamed from: b */
    private final boolean f10892b;

    public C6173o(C6352n<Bitmap> wrapped, boolean isRequired) {
        this.f10891a = wrapped;
        this.f10892b = isRequired;
    }

    /* renamed from: a */
    public C6352n<BitmapDrawable> mo19001a() {
        return this;
    }

    public C6236E<Drawable> transform(Context context, C6236E<Drawable> resource, int outWidth, int outHeight) {
        Drawable drawable = (Drawable) resource.get();
        Resource<Bitmap> bitmapResourceToTransform = C6172n.m11700a(C5926c.m10916a(context).mo18581c(), drawable, outWidth, outHeight);
        if (bitmapResourceToTransform != null) {
            Resource<Bitmap> transformedBitmapResource = this.f10891a.transform(context, bitmapResourceToTransform, outWidth, outHeight);
            if (!transformedBitmapResource.equals(bitmapResourceToTransform)) {
                return m11702a(context, transformedBitmapResource);
            }
            transformedBitmapResource.mo18969b();
            return resource;
        } else if (!this.f10892b) {
            return resource;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to convert ");
            sb.append(drawable);
            sb.append(" to a Bitmap");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private C6236E<Drawable> m11702a(Context context, C6236E<Bitmap> transformed) {
        return C6176r.m11707a(context.getResources(), transformed);
    }

    public boolean equals(Object o) {
        if (!(o instanceof C6173o)) {
            return false;
        }
        return this.f10891a.equals(((C6173o) o).f10891a);
    }

    public int hashCode() {
        return this.f10891a.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f10891a.updateDiskCacheKey(messageDigest);
    }
}
