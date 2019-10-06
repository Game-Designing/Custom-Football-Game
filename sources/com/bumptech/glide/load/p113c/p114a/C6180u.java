package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.p114a.C6169l.C6170a;
import com.bumptech.glide.p107h.C6019d;
import com.bumptech.glide.p107h.C6022g;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.c.a.u */
/* compiled from: StreamBitmapDecoder */
public class C6180u implements C6350l<InputStream, Bitmap> {

    /* renamed from: a */
    private final C6169l f10908a;

    /* renamed from: b */
    private final C6245b f10909b;

    /* renamed from: com.bumptech.glide.load.c.a.u$a */
    /* compiled from: StreamBitmapDecoder */
    static class C6181a implements C6170a {

        /* renamed from: a */
        private final C6177s f10910a;

        /* renamed from: b */
        private final C6019d f10911b;

        C6181a(C6177s bufferedStream, C6019d exceptionStream) {
            this.f10910a = bufferedStream;
            this.f10911b = exceptionStream;
        }

        /* renamed from: a */
        public void mo18994a() {
            this.f10910a.mo19003a();
        }

        /* renamed from: a */
        public void mo18995a(C6250e bitmapPool, Bitmap downsampled) throws IOException {
            IOException streamException = this.f10911b.mo18800a();
            if (streamException != null) {
                if (downsampled != null) {
                    bitmapPool.mo19000a(downsampled);
                }
                throw streamException;
            }
        }
    }

    public C6180u(C6169l downsampler, C6245b byteArrayPool) {
        this.f10908a = downsampler;
        this.f10909b = byteArrayPool;
    }

    /* renamed from: a */
    public boolean mo18973a(InputStream source, C6349k options) {
        return this.f10908a.mo18998a(source);
    }

    /* renamed from: a */
    public C6236E<Bitmap> mo18972a(InputStream source, int width, int height, C6349k options) throws IOException {
        boolean ownsBufferedStream;
        C6177s bufferedStream;
        if (source instanceof C6177s) {
            bufferedStream = (C6177s) source;
            ownsBufferedStream = false;
        } else {
            bufferedStream = new C6177s(source, this.f10909b);
            ownsBufferedStream = true;
        }
        C6019d exceptionStream = C6019d.m11245a(bufferedStream);
        try {
            return this.f10908a.mo18997a((InputStream) new C6022g(exceptionStream), width, height, options, (C6170a) new C6181a(bufferedStream, exceptionStream));
        } finally {
            exceptionStream.mo18802b();
            if (ownsBufferedStream) {
                bufferedStream.mo19005b();
            }
        }
    }
}
