package com.bumptech.glide.load.p113c.p114a;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.p107h.C6026k;

/* renamed from: com.bumptech.glide.load.c.a.e */
/* compiled from: BitmapTransformation */
public abstract class C6151e implements C6352n<Bitmap> {
    /* access modifiers changed from: protected */
    public abstract Bitmap transform(C6250e eVar, Bitmap bitmap, int i, int i2);

    public final C6236E<Bitmap> transform(Context context, C6236E<Bitmap> resource, int outWidth, int outHeight) {
        if (C6026k.m11285b(outWidth, outHeight)) {
            C6250e bitmapPool = C5926c.m10916a(context).mo18581c();
            Bitmap toTransform = (Bitmap) resource.get();
            Bitmap transformed = transform(bitmapPool, toTransform, outWidth == Integer.MIN_VALUE ? toTransform.getWidth() : outWidth, outHeight == Integer.MIN_VALUE ? toTransform.getHeight() : outHeight);
            if (toTransform.equals(transformed)) {
                return resource;
            }
            return C6150d.m11623a(transformed, bitmapPool);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot apply transformation on width: ");
        sb.append(outWidth);
        sb.append(" or height: ");
        sb.append(outHeight);
        sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        throw new IllegalArgumentException(sb.toString());
    }
}
