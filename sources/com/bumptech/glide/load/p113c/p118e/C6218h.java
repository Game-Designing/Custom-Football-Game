package com.bumptech.glide.load.p113c.p118e;

import android.graphics.Bitmap;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.p114a.C6150d;
import com.bumptech.glide.p099b.C5920a;

/* renamed from: com.bumptech.glide.load.c.e.h */
/* compiled from: GifFrameResourceDecoder */
public final class C6218h implements C6350l<C5920a, Bitmap> {

    /* renamed from: a */
    private final C6250e f10975a;

    public C6218h(C6250e bitmapPool) {
        this.f10975a = bitmapPool;
    }

    /* renamed from: a */
    public boolean mo18973a(C5920a source, C6349k options) {
        return true;
    }

    /* renamed from: a */
    public C6236E<Bitmap> mo18972a(C5920a source, int width, int height, C6349k options) {
        return C6150d.m11623a(source.mo18550a(), this.f10975a);
    }
}
