package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

@zzard
public final class zzaya {

    /* renamed from: a */
    private boolean f24971a = false;

    /* renamed from: b */
    private float f24972b = 1.0f;

    /* renamed from: a */
    public final synchronized void mo30263a(float f) {
        this.f24972b = f;
    }

    /* renamed from: a */
    public final synchronized float mo30262a() {
        return m26210c() ? this.f24972b : 1.0f;
    }

    /* renamed from: a */
    public final synchronized void mo30264a(boolean z) {
        this.f24971a = z;
    }

    /* renamed from: b */
    public final synchronized boolean mo30265b() {
        return this.f24971a;
    }

    /* renamed from: c */
    private final synchronized boolean m26210c() {
        return this.f24972b >= 0.0f;
    }

    /* renamed from: a */
    public static float m26209a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return ((float) streamVolume) / ((float) streamMaxVolume);
    }
}
