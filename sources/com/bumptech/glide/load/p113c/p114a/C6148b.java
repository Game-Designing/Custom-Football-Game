package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.C6145c;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6351m;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6250e;
import java.io.File;

/* renamed from: com.bumptech.glide.load.c.a.b */
/* compiled from: BitmapDrawableEncoder */
public class C6148b implements C6351m<BitmapDrawable> {

    /* renamed from: a */
    private final C6250e f10851a;

    /* renamed from: b */
    private final C6351m<Bitmap> f10852b;

    public C6148b(C6250e bitmapPool, C6351m<Bitmap> encoder) {
        this.f10851a = bitmapPool;
        this.f10852b = encoder;
    }

    /* renamed from: a */
    public boolean mo18888a(C6236E<BitmapDrawable> data, File file, C6349k options) {
        return this.f10852b.mo18888a(new C6150d(((BitmapDrawable) data.get()).getBitmap(), this.f10851a), file, options);
    }

    /* renamed from: a */
    public C6145c mo18974a(C6349k options) {
        return this.f10852b.mo18974a(options);
    }
}
