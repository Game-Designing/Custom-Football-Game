package com.bumptech.glide.load.p109a;

import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.p109a.C6044e.C6045a;
import com.bumptech.glide.load.p113c.p114a.C6177s;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.l */
/* compiled from: InputStreamRewinder */
public final class C6055l implements C6044e<InputStream> {

    /* renamed from: a */
    private final C6177s f10731a;

    /* renamed from: com.bumptech.glide.load.a.l$a */
    /* compiled from: InputStreamRewinder */
    public static final class C6056a implements C6045a<InputStream> {

        /* renamed from: a */
        private final C6245b f10732a;

        public C6056a(C6245b byteArrayPool) {
            this.f10732a = byteArrayPool;
        }

        /* renamed from: a */
        public C6044e<InputStream> mo18871a(InputStream data) {
            return new C6055l(data, this.f10732a);
        }

        /* renamed from: a */
        public Class<InputStream> mo18872a() {
            return InputStream.class;
        }
    }

    C6055l(InputStream is, C6245b byteArrayPool) {
        this.f10731a = new C6177s(is, byteArrayPool);
        this.f10731a.mark(5242880);
    }

    /* renamed from: a */
    public InputStream m11382a() throws IOException {
        this.f10731a.reset();
        return this.f10731a;
    }

    /* renamed from: b */
    public void mo18870b() {
        this.f10731a.mo19005b();
    }
}
