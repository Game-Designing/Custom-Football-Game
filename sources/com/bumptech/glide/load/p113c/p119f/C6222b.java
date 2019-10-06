package com.bumptech.glide.load.p113c.p119f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.p113c.p114a.C6176r;
import com.bumptech.glide.p107h.C6024i;

/* renamed from: com.bumptech.glide.load.c.f.b */
/* compiled from: BitmapDrawableTranscoder */
public class C6222b implements C6225e<Bitmap, BitmapDrawable> {

    /* renamed from: a */
    private final Resources f10983a;

    public C6222b(Resources resources) {
        C6024i.m11264a(resources);
        this.f10983a = resources;
    }

    /* renamed from: a */
    public C6236E<BitmapDrawable> mo19089a(C6236E<Bitmap> toTranscode, C6349k options) {
        return C6176r.m11707a(this.f10983a, toTranscode);
    }
}
