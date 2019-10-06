package com.bumptech.glide.load.p113c.p119f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.p113c.p115b.C6196b;
import java.io.ByteArrayOutputStream;

/* renamed from: com.bumptech.glide.load.c.f.a */
/* compiled from: BitmapBytesTranscoder */
public class C6221a implements C6225e<Bitmap, byte[]> {

    /* renamed from: a */
    private final CompressFormat f10981a;

    /* renamed from: b */
    private final int f10982b;

    public C6221a() {
        this(CompressFormat.JPEG, 100);
    }

    public C6221a(CompressFormat compressFormat, int quality) {
        this.f10981a = compressFormat;
        this.f10982b = quality;
    }

    /* renamed from: a */
    public C6236E<byte[]> mo19089a(C6236E<Bitmap> toTranscode, C6349k options) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ((Bitmap) toTranscode.get()).compress(this.f10981a, this.f10982b, os);
        toTranscode.mo18969b();
        return new C6196b(os.toByteArray());
    }
}
