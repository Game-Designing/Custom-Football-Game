package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
@zzard
public final class zzbcy {

    /* renamed from: a */
    private final long f25116a = TimeUnit.MILLISECONDS.toNanos(((Long) zzyt.m31536e().mo29599a(zzacu.f23962L)).longValue());

    /* renamed from: b */
    private long f25117b;

    /* renamed from: c */
    private boolean f25118c = true;

    zzbcy() {
    }

    /* renamed from: a */
    public final void mo30417a() {
        this.f25118c = true;
    }

    /* renamed from: a */
    public final void mo30418a(SurfaceTexture surfaceTexture, zzbcn zzbcn) {
        if (zzbcn != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.f25118c || Math.abs(timestamp - this.f25117b) >= this.f25116a) {
                this.f25118c = false;
                this.f25117b = timestamp;
                zzaxi.f24961a.post(new C9852zd(this, zzbcn));
            }
        }
    }
}
