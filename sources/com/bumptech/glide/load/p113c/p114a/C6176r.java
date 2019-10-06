package com.bumptech.glide.load.p113c.p114a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.C6342z;
import com.bumptech.glide.p107h.C6024i;

/* renamed from: com.bumptech.glide.load.c.a.r */
/* compiled from: LazyBitmapDrawableResource */
public final class C6176r implements C6236E<BitmapDrawable>, C6342z {

    /* renamed from: a */
    private final Resources f10898a;

    /* renamed from: b */
    private final C6236E<Bitmap> f10899b;

    /* renamed from: a */
    public static C6236E<BitmapDrawable> m11707a(Resources resources, C6236E<Bitmap> bitmapResource) {
        if (bitmapResource == null) {
            return null;
        }
        return new C6176r(resources, bitmapResource);
    }

    private C6176r(Resources resources, C6236E<Bitmap> bitmapResource) {
        C6024i.m11264a(resources);
        this.f10898a = resources;
        C6024i.m11264a(bitmapResource);
        this.f10899b = bitmapResource;
    }

    /* renamed from: c */
    public Class<BitmapDrawable> mo18970c() {
        return BitmapDrawable.class;
    }

    public BitmapDrawable get() {
        return new BitmapDrawable(this.f10898a, (Bitmap) this.f10899b.get());
    }

    /* renamed from: a */
    public int mo18968a() {
        return this.f10899b.mo18968a();
    }

    /* renamed from: b */
    public void mo18969b() {
        this.f10899b.mo18969b();
    }

    public void initialize() {
        C6236E<Bitmap> e = this.f10899b;
        if (e instanceof C6342z) {
            ((C6342z) e).initialize();
        }
    }
}
