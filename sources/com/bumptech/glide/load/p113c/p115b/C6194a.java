package com.bumptech.glide.load.p113c.p115b;

import com.bumptech.glide.load.p109a.C6044e;
import com.bumptech.glide.load.p109a.C6044e.C6045a;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.c.b.a */
/* compiled from: ByteBufferRewinder */
public class C6194a implements C6044e<ByteBuffer> {

    /* renamed from: a */
    private final ByteBuffer f10927a;

    /* renamed from: com.bumptech.glide.load.c.b.a$a */
    /* compiled from: ByteBufferRewinder */
    public static class C6195a implements C6045a<ByteBuffer> {
        /* renamed from: a */
        public C6044e<ByteBuffer> mo18871a(ByteBuffer data) {
            return new C6194a(data);
        }

        /* renamed from: a */
        public Class<ByteBuffer> mo18872a() {
            return ByteBuffer.class;
        }
    }

    public C6194a(ByteBuffer buffer) {
        this.f10927a = buffer;
    }

    /* renamed from: a */
    public ByteBuffer m11763a() {
        this.f10927a.position(0);
        return this.f10927a;
    }

    /* renamed from: b */
    public void mo18870b() {
    }
}
