package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzael extends Image {

    /* renamed from: a */
    private final zzaei f24277a;

    /* renamed from: b */
    private final Drawable f24278b;

    /* renamed from: c */
    private final Uri f24279c;

    /* renamed from: d */
    private final double f24280d;

    /* renamed from: e */
    private final int f24281e;

    /* renamed from: f */
    private final int f24282f;

    public zzael(zzaei zzaei) {
        Drawable drawable;
        int i;
        String str = "";
        this.f24277a = zzaei;
        Uri uri = null;
        try {
            IObjectWrapper Pa = this.f24277a.mo29639Pa();
            if (Pa != null) {
                drawable = (Drawable) ObjectWrapper.m22187H(Pa);
            } else {
                drawable = null;
            }
        } catch (RemoteException e) {
            zzbad.m26356b(str, e);
            drawable = null;
        }
        this.f24278b = drawable;
        try {
            uri = this.f24277a.getUri();
        } catch (RemoteException e2) {
            zzbad.m26356b(str, e2);
        }
        this.f24279c = uri;
        double d = 1.0d;
        try {
            d = this.f24277a.mo29643ha();
        } catch (RemoteException e3) {
            zzbad.m26356b(str, e3);
        }
        this.f24280d = d;
        int i2 = -1;
        try {
            i = this.f24277a.getWidth();
        } catch (RemoteException e4) {
            zzbad.m26356b(str, e4);
            i = -1;
        }
        this.f24281e = i;
        try {
            i2 = this.f24277a.getHeight();
        } catch (RemoteException e5) {
            zzbad.m26356b(str, e5);
        }
        this.f24282f = i2;
    }

    public final Drawable getDrawable() {
        return this.f24278b;
    }

    public final Uri getUri() {
        return this.f24279c;
    }

    public final double getScale() {
        return this.f24280d;
    }

    public final int getWidth() {
        return this.f24281e;
    }

    public final int getHeight() {
        return this.f24282f;
    }
}
