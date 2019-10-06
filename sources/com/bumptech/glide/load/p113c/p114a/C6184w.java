package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.p107h.C6026k;

/* renamed from: com.bumptech.glide.load.c.a.w */
/* compiled from: UnitBitmapDecoder */
public final class C6184w implements C6350l<Bitmap, Bitmap> {

    /* renamed from: com.bumptech.glide.load.c.a.w$a */
    /* compiled from: UnitBitmapDecoder */
    private static final class C6185a implements C6236E<Bitmap> {

        /* renamed from: a */
        private final Bitmap f10917a;

        C6185a(Bitmap bitmap) {
            this.f10917a = bitmap;
        }

        /* renamed from: c */
        public Class<Bitmap> mo18970c() {
            return Bitmap.class;
        }

        public Bitmap get() {
            return this.f10917a;
        }

        /* renamed from: a */
        public int mo18968a() {
            return C6026k.m11274a(this.f10917a);
        }

        /* renamed from: b */
        public void mo18969b() {
        }
    }

    /* renamed from: a */
    public boolean mo18973a(Bitmap source, C6349k options) {
        return true;
    }

    /* renamed from: a */
    public C6236E<Bitmap> mo18972a(Bitmap source, int width, int height, C6349k options) {
        return new C6185a(source);
    }
}
