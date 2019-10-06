package com.bumptech.glide.load.p113c.p114a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.p107h.C6024i;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.c.a.a */
/* compiled from: BitmapDrawableDecoder */
public class C6147a<DataType> implements C6350l<DataType, BitmapDrawable> {

    /* renamed from: a */
    private final C6350l<DataType, Bitmap> f10849a;

    /* renamed from: b */
    private final Resources f10850b;

    public C6147a(Resources resources, C6350l<DataType, Bitmap> decoder) {
        C6024i.m11264a(resources);
        this.f10850b = resources;
        C6024i.m11264a(decoder);
        this.f10849a = decoder;
    }

    /* renamed from: a */
    public boolean mo18973a(DataType source, C6349k options) throws IOException {
        return this.f10849a.mo18973a(source, options);
    }

    /* renamed from: a */
    public C6236E<BitmapDrawable> mo18972a(DataType source, int width, int height, C6349k options) throws IOException {
        return C6176r.m11707a(this.f10850b, this.f10849a.mo18972a(source, width, height, options));
    }
}
