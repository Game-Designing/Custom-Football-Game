package com.airbnb.lottie;

import android.graphics.Bitmap;

/* renamed from: com.airbnb.lottie.y */
/* compiled from: LottieImageAsset */
public class C5853y {

    /* renamed from: a */
    private final int f10190a;

    /* renamed from: b */
    private final int f10191b;

    /* renamed from: c */
    private final String f10192c;

    /* renamed from: d */
    private final String f10193d;

    /* renamed from: e */
    private final String f10194e;

    /* renamed from: f */
    private Bitmap f10195f;

    public C5853y(int width, int height, String id, String fileName, String dirName) {
        this.f10190a = width;
        this.f10191b = height;
        this.f10192c = id;
        this.f10193d = fileName;
        this.f10194e = dirName;
    }

    /* renamed from: c */
    public String mo18281c() {
        return this.f10192c;
    }

    /* renamed from: b */
    public String mo18280b() {
        return this.f10193d;
    }

    /* renamed from: a */
    public Bitmap mo18278a() {
        return this.f10195f;
    }

    /* renamed from: a */
    public void mo18279a(Bitmap bitmap) {
        this.f10195f = bitmap;
    }
}
