package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.p120a.C6245b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.e */
/* compiled from: ImageHeaderParser */
public interface C6230e {

    /* renamed from: com.bumptech.glide.load.e$a */
    /* compiled from: ImageHeaderParser */
    public enum C6231a {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        

        /* renamed from: j */
        private final boolean f11001j;

        private C6231a(boolean hasAlpha) {
            this.f11001j = hasAlpha;
        }

        /* renamed from: e */
        public boolean mo19094e() {
            return this.f11001j;
        }
    }

    /* renamed from: a */
    int mo18980a(InputStream inputStream, C6245b bVar) throws IOException;

    /* renamed from: a */
    C6231a mo18981a(InputStream inputStream) throws IOException;

    /* renamed from: a */
    C6231a mo18982a(ByteBuffer byteBuffer) throws IOException;
}
