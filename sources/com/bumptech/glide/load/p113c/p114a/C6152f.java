package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.p107h.C6002a;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.c.a.f */
/* compiled from: ByteBufferBitmapDecoder */
public class C6152f implements C6350l<ByteBuffer, Bitmap> {

    /* renamed from: a */
    private final C6169l f10858a;

    public C6152f(C6169l downsampler) {
        this.f10858a = downsampler;
    }

    /* renamed from: a */
    public boolean mo18973a(ByteBuffer source, C6349k options) {
        return this.f10858a.mo18999a(source);
    }

    /* renamed from: a */
    public C6236E<Bitmap> mo18972a(ByteBuffer source, int width, int height, C6349k options) throws IOException {
        return this.f10858a.mo18996a(C6002a.m11215b(source), width, height, options);
    }
}
