package com.bumptech.glide.load.p111b;

import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p106g.C6000c;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.b.c */
/* compiled from: ByteArrayLoader */
public class C6091c<Data> implements C6128u<byte[], Data> {

    /* renamed from: a */
    private final C6093b<Data> f10770a;

    /* renamed from: com.bumptech.glide.load.b.c$a */
    /* compiled from: ByteArrayLoader */
    public static class C6092a implements C6130v<byte[], ByteBuffer> {
        /* renamed from: a */
        public C6128u<byte[], ByteBuffer> mo18893a(C6136y multiFactory) {
            return new C6091c(new C6090b(this));
        }
    }

    /* renamed from: com.bumptech.glide.load.b.c$b */
    /* compiled from: ByteArrayLoader */
    public interface C6093b<Data> {
        /* renamed from: a */
        Class<Data> mo18912a();

        /* renamed from: a */
        Data mo18913a(byte[] bArr);
    }

    /* renamed from: com.bumptech.glide.load.b.c$c */
    /* compiled from: ByteArrayLoader */
    private static class C6094c<Data> implements C6042d<Data> {

        /* renamed from: a */
        private final byte[] f10771a;

        /* renamed from: b */
        private final C6093b<Data> f10772b;

        C6094c(byte[] model, C6093b<Data> converter) {
            this.f10771a = model;
            this.f10772b = converter;
        }

        /* renamed from: a */
        public void mo18853a(C6001h priority, C6043a<? super Data> callback) {
            callback.mo18868a(this.f10772b.mo18913a(this.f10771a));
        }

        /* renamed from: b */
        public void mo18854b() {
        }

        public void cancel() {
        }

        /* renamed from: a */
        public Class<Data> mo18847a() {
            return this.f10772b.mo18912a();
        }

        /* renamed from: c */
        public C6031a mo18855c() {
            return C6031a.LOCAL;
        }
    }

    /* renamed from: com.bumptech.glide.load.b.c$d */
    /* compiled from: ByteArrayLoader */
    public static class C6095d implements C6130v<byte[], InputStream> {
        /* renamed from: a */
        public C6128u<byte[], InputStream> mo18893a(C6136y multiFactory) {
            return new C6091c(new C6096d(this));
        }
    }

    public C6091c(C6093b<Data> converter) {
        this.f10770a = converter;
    }

    /* renamed from: a */
    public C6129a<Data> mo18889a(byte[] model, int width, int height, C6349k options) {
        return new C6129a<>(new C6000c(model), new C6094c(model, this.f10770a));
    }

    /* renamed from: a */
    public boolean mo18891a(byte[] model) {
        return true;
    }
}
