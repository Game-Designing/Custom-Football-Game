package com.bumptech.glide.load.engine.p120a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* renamed from: com.bumptech.glide.load.engine.a.f */
/* compiled from: BitmapPoolAdapter */
public class C6251f implements C6250e {
    /* renamed from: a */
    public void mo19000a(Bitmap bitmap) {
        bitmap.recycle();
    }

    /* renamed from: a */
    public Bitmap mo19148a(int width, int height, Config config) {
        return Bitmap.createBitmap(width, height, config);
    }

    /* renamed from: b */
    public Bitmap mo19151b(int width, int height, Config config) {
        return mo19148a(width, height, config);
    }

    /* renamed from: a */
    public void mo19149a() {
    }

    /* renamed from: a */
    public void mo19150a(int level) {
    }
}
