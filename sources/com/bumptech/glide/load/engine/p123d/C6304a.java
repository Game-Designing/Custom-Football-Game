package com.bumptech.glide.load.engine.p123d;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.C6060b;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.engine.p121b.C6282i;

/* renamed from: com.bumptech.glide.load.engine.d.a */
/* compiled from: BitmapPreFiller */
public final class C6304a {

    /* renamed from: a */
    private final C6282i f11163a;

    /* renamed from: b */
    private final C6250e f11164b;

    /* renamed from: c */
    private final C6060b f11165c;

    /* renamed from: d */
    private final Handler f11166d = new Handler(Looper.getMainLooper());

    public C6304a(C6282i memoryCache, C6250e bitmapPool, C6060b defaultFormat) {
        this.f11163a = memoryCache;
        this.f11164b = bitmapPool;
        this.f11165c = defaultFormat;
    }
}
