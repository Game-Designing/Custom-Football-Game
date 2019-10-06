package com.bumptech.glide.load.engine.p120a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* renamed from: com.bumptech.glide.load.engine.a.l */
/* compiled from: LruPoolStrategy */
interface C6262l {
    /* renamed from: a */
    Bitmap mo19132a(int i, int i2, Config config);

    /* renamed from: a */
    void mo19133a(Bitmap bitmap);

    /* renamed from: b */
    String mo19134b(int i, int i2, Config config);

    /* renamed from: b */
    String mo19135b(Bitmap bitmap);

    /* renamed from: c */
    int mo19136c(Bitmap bitmap);

    Bitmap removeLast();
}
