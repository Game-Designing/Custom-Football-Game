package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.p116c.C6200d;

/* renamed from: com.bumptech.glide.load.c.a.t */
/* compiled from: ResourceBitmapDecoder */
public class C6179t implements C6350l<Uri, Bitmap> {

    /* renamed from: a */
    private final C6200d f10906a;

    /* renamed from: b */
    private final C6250e f10907b;

    public C6179t(C6200d drawableDecoder, C6250e bitmapPool) {
        this.f10906a = drawableDecoder;
        this.f10907b = bitmapPool;
    }

    /* renamed from: a */
    public boolean mo18973a(Uri source, C6349k options) {
        return "android.resource".equals(source.getScheme());
    }

    /* renamed from: a */
    public C6236E<Bitmap> mo18972a(Uri source, int width, int height, C6349k options) {
        Resource<Drawable> drawableResource = this.f10906a.mo18972a(source, width, height, options);
        if (drawableResource == null) {
            return null;
        }
        return C6172n.m11700a(this.f10907b, (Drawable) drawableResource.get(), width, height);
    }
}
