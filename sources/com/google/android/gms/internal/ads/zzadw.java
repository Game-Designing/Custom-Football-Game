package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzadw extends zzaej {

    /* renamed from: b */
    private final Drawable f24260b;

    /* renamed from: c */
    private final Uri f24261c;

    /* renamed from: d */
    private final double f24262d;

    /* renamed from: e */
    private final int f24263e;

    /* renamed from: f */
    private final int f24264f;

    public zzadw(Drawable drawable, Uri uri, double d, int i, int i2) {
        this.f24260b = drawable;
        this.f24261c = uri;
        this.f24262d = d;
        this.f24263e = i;
        this.f24264f = i2;
    }

    /* renamed from: Pa */
    public final IObjectWrapper mo29639Pa() throws RemoteException {
        return ObjectWrapper.m22188a(this.f24260b);
    }

    public final Uri getUri() throws RemoteException {
        return this.f24261c;
    }

    /* renamed from: ha */
    public final double mo29643ha() {
        return this.f24262d;
    }

    public final int getWidth() {
        return this.f24263e;
    }

    public final int getHeight() {
        return this.f24264f;
    }
}
