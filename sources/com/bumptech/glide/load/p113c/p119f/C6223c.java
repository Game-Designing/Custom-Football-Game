package com.bumptech.glide.load.p113c.p119f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.p114a.C6150d;
import com.bumptech.glide.load.p113c.p118e.C6208c;

/* renamed from: com.bumptech.glide.load.c.f.c */
/* compiled from: DrawableBytesTranscoder */
public final class C6223c implements C6225e<Drawable, byte[]> {

    /* renamed from: a */
    private final C6250e f10984a;

    /* renamed from: b */
    private final C6225e<Bitmap, byte[]> f10985b;

    /* renamed from: c */
    private final C6225e<C6208c, byte[]> f10986c;

    public C6223c(C6250e bitmapPool, C6225e<Bitmap, byte[]> bitmapBytesTranscoder, C6225e<C6208c, byte[]> gifDrawableBytesTranscoder) {
        this.f10984a = bitmapPool;
        this.f10985b = bitmapBytesTranscoder;
        this.f10986c = gifDrawableBytesTranscoder;
    }

    /* renamed from: a */
    public C6236E<byte[]> mo19089a(C6236E<Drawable> toTranscode, C6349k options) {
        Drawable drawable = (Drawable) toTranscode.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f10985b.mo19089a(C6150d.m11623a(((BitmapDrawable) drawable).getBitmap(), this.f10984a), options);
        }
        if (!(drawable instanceof C6208c)) {
            return null;
        }
        C6225e<C6208c, byte[]> eVar = this.f10986c;
        m11864a(toTranscode);
        return eVar.mo19089a(toTranscode, options);
    }

    /* renamed from: a */
    private static C6236E<C6208c> m11864a(C6236E<Drawable> resource) {
        return resource;
    }
}
