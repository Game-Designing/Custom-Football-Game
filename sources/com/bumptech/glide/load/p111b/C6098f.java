package com.bumptech.glide.load.p111b;

import android.util.Log;
import com.bumptech.glide.C6001h;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.p109a.C6042d;
import com.bumptech.glide.load.p109a.C6042d.C6043a;
import com.bumptech.glide.load.p111b.C6128u.C6129a;
import com.bumptech.glide.p106g.C6000c;
import com.bumptech.glide.p107h.C6002a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.b.f */
/* compiled from: ByteBufferFileLoader */
public class C6098f implements C6128u<File, ByteBuffer> {

    /* renamed from: com.bumptech.glide.load.b.f$a */
    /* compiled from: ByteBufferFileLoader */
    private static final class C6099a implements C6042d<ByteBuffer> {

        /* renamed from: a */
        private final File f10774a;

        C6099a(File file) {
            this.f10774a = file;
        }

        /* renamed from: a */
        public void mo18853a(C6001h priority, C6043a<? super ByteBuffer> callback) {
            try {
                callback.mo18868a(C6002a.m11212a(this.f10774a));
            } catch (IOException e) {
                String str = "ByteBufferFileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to obtain ByteBuffer for file", e);
                }
                callback.mo18867a((Exception) e);
            }
        }

        /* renamed from: b */
        public void mo18854b() {
        }

        public void cancel() {
        }

        /* renamed from: a */
        public Class<ByteBuffer> mo18847a() {
            return ByteBuffer.class;
        }

        /* renamed from: c */
        public C6031a mo18855c() {
            return C6031a.LOCAL;
        }
    }

    /* renamed from: com.bumptech.glide.load.b.f$b */
    /* compiled from: ByteBufferFileLoader */
    public static class C6100b implements C6130v<File, ByteBuffer> {
        /* renamed from: a */
        public C6128u<File, ByteBuffer> mo18893a(C6136y multiFactory) {
            return new C6098f();
        }
    }

    /* renamed from: a */
    public C6129a<ByteBuffer> mo18889a(File file, int width, int height, C6349k options) {
        return new C6129a<>(new C6000c(file), new C6099a(file));
    }

    /* renamed from: a */
    public boolean mo18891a(File file) {
        return true;
    }
}
