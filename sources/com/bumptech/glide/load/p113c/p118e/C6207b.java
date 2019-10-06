package com.bumptech.glide.load.p113c.p118e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.p099b.C5920a.C5921a;

/* renamed from: com.bumptech.glide.load.c.e.b */
/* compiled from: GifBitmapProvider */
public final class C6207b implements C5921a {

    /* renamed from: a */
    private final C6250e f10940a;

    /* renamed from: b */
    private final C6245b f10941b;

    public C6207b(C6250e bitmapPool, C6245b arrayPool) {
        this.f10940a = bitmapPool;
        this.f10941b = arrayPool;
    }

    /* renamed from: a */
    public Bitmap mo18560a(int width, int height, Config config) {
        return this.f10940a.mo19151b(width, height, config);
    }

    /* renamed from: a */
    public void mo18561a(Bitmap bitmap) {
        this.f10940a.mo19000a(bitmap);
    }

    /* renamed from: a */
    public byte[] mo18564a(int size) {
        C6245b bVar = this.f10941b;
        if (bVar == null) {
            return new byte[size];
        }
        return (byte[]) bVar.mo19127a(size, byte[].class);
    }

    /* renamed from: a */
    public void mo18562a(byte[] bytes) {
        C6245b bVar = this.f10941b;
        if (bVar != null) {
            bVar.put(bytes);
        }
    }

    /* renamed from: b */
    public int[] mo18565b(int size) {
        C6245b bVar = this.f10941b;
        if (bVar == null) {
            return new int[size];
        }
        return (int[]) bVar.mo19127a(size, int[].class);
    }

    /* renamed from: a */
    public void mo18563a(int[] array) {
        C6245b bVar = this.f10941b;
        if (bVar != null) {
            bVar.put(array);
        }
    }
}
