package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.C6342z;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;

/* renamed from: com.bumptech.glide.load.c.a.d */
/* compiled from: BitmapResource */
public class C6150d implements C6236E<Bitmap>, C6342z {

    /* renamed from: a */
    private final Bitmap f10856a;

    /* renamed from: b */
    private final C6250e f10857b;

    /* renamed from: a */
    public static C6150d m11623a(Bitmap bitmap, C6250e bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new C6150d(bitmap, bitmapPool);
    }

    public C6150d(Bitmap bitmap, C6250e bitmapPool) {
        C6024i.m11265a(bitmap, "Bitmap must not be null");
        this.f10856a = bitmap;
        C6024i.m11265a(bitmapPool, "BitmapPool must not be null");
        this.f10857b = bitmapPool;
    }

    /* renamed from: c */
    public Class<Bitmap> mo18970c() {
        return Bitmap.class;
    }

    public Bitmap get() {
        return this.f10856a;
    }

    /* renamed from: a */
    public int mo18968a() {
        return C6026k.m11274a(this.f10856a);
    }

    /* renamed from: b */
    public void mo18969b() {
        this.f10857b.mo19000a(this.f10856a);
    }

    public void initialize() {
        this.f10856a.prepareToDraw();
    }
}
