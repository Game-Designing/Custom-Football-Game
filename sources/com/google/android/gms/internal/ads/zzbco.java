package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
@zzard
public abstract class zzbco extends TextureView implements C8827Ed {

    /* renamed from: a */
    protected final zzbcy f25093a = new zzbcy();

    /* renamed from: b */
    protected final zzbdi f25094b;

    public zzbco(Context context) {
        super(context);
        this.f25094b = new zzbdi(context, this);
    }

    /* renamed from: a */
    public abstract void mo28179a();

    /* renamed from: a */
    public abstract void mo30347a(float f, float f2);

    /* renamed from: a */
    public abstract void mo30348a(zzbcn zzbcn);

    /* renamed from: b */
    public abstract void mo30349b();

    /* renamed from: b */
    public abstract void mo30350b(int i);

    /* renamed from: c */
    public abstract void mo30351c();

    /* renamed from: d */
    public abstract void mo30352d();

    /* renamed from: e */
    public abstract String mo30353e();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setVideoPath(String str);

    /* renamed from: a */
    public void mo30383a(String str, String[] strArr) {
        setVideoPath(str);
    }

    /* renamed from: c */
    public void mo30384c(int i) {
    }

    /* renamed from: d */
    public void mo30385d(int i) {
    }

    /* renamed from: e */
    public void mo30386e(int i) {
    }

    /* renamed from: f */
    public void mo30387f(int i) {
    }

    /* renamed from: g */
    public void mo30388g(int i) {
    }
}
