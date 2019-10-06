package com.bumptech.glide.load.p113c.p118e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.load.C6060b;
import com.bumptech.glide.load.C6230e;
import com.bumptech.glide.load.C6230e.C6231a;
import com.bumptech.glide.load.C6343f;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.C6193b;
import com.bumptech.glide.p099b.C5920a;
import com.bumptech.glide.p099b.C5920a.C5921a;
import com.bumptech.glide.p099b.C5923c;
import com.bumptech.glide.p099b.C5924d;
import com.bumptech.glide.p099b.C5925e;
import com.bumptech.glide.p107h.C6020e;
import com.bumptech.glide.p107h.C6026k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.c.e.a */
/* compiled from: ByteBufferGifDecoder */
public class C6204a implements C6350l<ByteBuffer, C6208c> {

    /* renamed from: a */
    private static final C6205a f10932a = new C6205a();

    /* renamed from: b */
    private static final C6206b f10933b = new C6206b();

    /* renamed from: c */
    private final Context f10934c;

    /* renamed from: d */
    private final List<C6230e> f10935d;

    /* renamed from: e */
    private final C6206b f10936e;

    /* renamed from: f */
    private final C6205a f10937f;

    /* renamed from: g */
    private final C6207b f10938g;

    /* renamed from: com.bumptech.glide.load.c.e.a$a */
    /* compiled from: ByteBufferGifDecoder */
    static class C6205a {
        C6205a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C5920a mo19041a(C5921a provider, C5923c header, ByteBuffer data, int sampleSize) {
            return new C5925e(provider, header, data, sampleSize);
        }
    }

    /* renamed from: com.bumptech.glide.load.c.e.a$b */
    /* compiled from: ByteBufferGifDecoder */
    static class C6206b {

        /* renamed from: a */
        private final Queue<C5924d> f10939a = C6026k.m11280a(0);

        C6206b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public synchronized C5924d mo19042a(ByteBuffer buffer) {
            C5924d result;
            result = (C5924d) this.f10939a.poll();
            if (result == null) {
                result = new C5924d();
            }
            result.mo18570a(buffer);
            return result;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public synchronized void mo19043a(C5924d parser) {
            parser.mo18571a();
            this.f10939a.offer(parser);
        }
    }

    public C6204a(Context context, List<C6230e> parsers, C6250e bitmapPool, C6245b arrayPool) {
        this(context, parsers, bitmapPool, arrayPool, f10933b, f10932a);
    }

    C6204a(Context context, List<C6230e> parsers, C6250e bitmapPool, C6245b arrayPool, C6206b parserPool, C6205a gifDecoderFactory) {
        this.f10934c = context.getApplicationContext();
        this.f10935d = parsers;
        this.f10937f = gifDecoderFactory;
        this.f10938g = new C6207b(bitmapPool, arrayPool);
        this.f10936e = parserPool;
    }

    /* renamed from: a */
    public boolean mo18973a(ByteBuffer source, C6349k options) throws IOException {
        return !((Boolean) options.mo19310a(C6219i.f10977b)).booleanValue() && C6343f.m12241a(this.f10935d, source) == C6231a.GIF;
    }

    /* renamed from: a */
    public C6211e mo18972a(ByteBuffer source, int width, int height, C6349k options) {
        C5924d parser = this.f10936e.mo19042a(source);
        try {
            return m11795a(source, width, height, parser, options);
        } finally {
            this.f10936e.mo19043a(parser);
        }
    }

    /* renamed from: a */
    private C6211e m11795a(ByteBuffer byteBuffer, int width, int height, C5924d parser, C6349k options) {
        String str = "Decoded GIF from stream in ";
        String str2 = "BufferGifDecoder";
        long startTime = C6020e.m11250a();
        try {
            C5923c header = parser.mo18572b();
            if (header.mo18567b() > 0) {
                if (header.mo18568c() == 0) {
                    Config config = options.mo19310a(C6219i.f10976a) == C6060b.PREFER_RGB_565 ? Config.RGB_565 : Config.ARGB_8888;
                    int sampleSize = m11794a(header, width, height);
                    C5920a gifDecoder = this.f10937f.mo19041a(this.f10938g, header, byteBuffer, sampleSize);
                    gifDecoder.mo18551a(config);
                    gifDecoder.advance();
                    Bitmap firstFrame = gifDecoder.mo18550a();
                    if (firstFrame == null) {
                        if (Log.isLoggable(str2, 2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(C6020e.m11249a(startTime));
                            Log.v(str2, sb.toString());
                        }
                        return null;
                    }
                    C5920a gifDecoder2 = gifDecoder;
                    int i = sampleSize;
                    C6208c cVar = new C6208c(this.f10934c, gifDecoder2, C6193b.m11761a(), width, height, firstFrame);
                    C6211e eVar = new C6211e(cVar);
                    if (Log.isLoggable(str2, 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(C6020e.m11249a(startTime));
                        Log.v(str2, sb2.toString());
                    }
                    return eVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(C6020e.m11249a(startTime));
                Log.v(str2, sb3.toString());
            }
        }
    }

    /* renamed from: a */
    private static int m11794a(C5923c gifHeader, int targetWidth, int targetHeight) {
        int exactSampleSize = Math.min(gifHeader.mo18566a() / targetHeight, gifHeader.mo18569d() / targetWidth);
        int sampleSize = Math.max(1, exactSampleSize == 0 ? 0 : Integer.highestOneBit(exactSampleSize));
        String str = "BufferGifDecoder";
        if (Log.isLoggable(str, 2) && sampleSize > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Downsampling GIF, sampleSize: ");
            sb.append(sampleSize);
            sb.append(", target dimens: [");
            sb.append(targetWidth);
            String str2 = "x";
            sb.append(str2);
            sb.append(targetHeight);
            sb.append("], actual dimens: [");
            sb.append(gifHeader.mo18569d());
            sb.append(str2);
            sb.append(gifHeader.mo18566a());
            sb.append("]");
            Log.v(str, sb.toString());
        }
        return sampleSize;
    }
}
