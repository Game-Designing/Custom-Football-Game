package com.bumptech.glide.p099b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.b.a */
/* compiled from: GifDecoder */
public interface C5920a {

    /* renamed from: com.bumptech.glide.b.a$a */
    /* compiled from: GifDecoder */
    public interface C5921a {
        /* renamed from: a */
        Bitmap mo18560a(int i, int i2, Config config);

        /* renamed from: a */
        void mo18561a(Bitmap bitmap);

        /* renamed from: a */
        void mo18562a(byte[] bArr);

        /* renamed from: a */
        void mo18563a(int[] iArr);

        /* renamed from: a */
        byte[] mo18564a(int i);

        /* renamed from: b */
        int[] mo18565b(int i);
    }

    /* renamed from: a */
    Bitmap mo18550a();

    /* renamed from: a */
    void mo18551a(Config config);

    void advance();

    /* renamed from: b */
    int mo18553b();

    /* renamed from: c */
    int mo18554c();

    void clear();

    /* renamed from: d */
    void mo18556d();

    /* renamed from: e */
    int mo18557e();

    /* renamed from: f */
    int mo18558f();

    ByteBuffer getData();
}
