package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

@TargetApi(14)
@zzard
public final class zzbdi implements OnAudioFocusChangeListener {

    /* renamed from: a */
    private final AudioManager f25174a;

    /* renamed from: b */
    private final C8827Ed f25175b;

    /* renamed from: c */
    private boolean f25176c;

    /* renamed from: d */
    private boolean f25177d;

    /* renamed from: e */
    private boolean f25178e;

    /* renamed from: f */
    private float f25179f = 1.0f;

    public zzbdi(Context context, C8827Ed ed) {
        this.f25174a = (AudioManager) context.getSystemService("audio");
        this.f25175b = ed;
    }

    /* renamed from: a */
    public final void mo30439a(boolean z) {
        this.f25178e = z;
        m26542d();
    }

    /* renamed from: a */
    public final void mo30438a(float f) {
        this.f25179f = f;
        m26542d();
    }

    /* renamed from: a */
    public final float mo30437a() {
        float f = this.f25178e ? 0.0f : this.f25179f;
        if (this.f25176c) {
            return f;
        }
        return 0.0f;
    }

    /* renamed from: b */
    public final void mo30440b() {
        this.f25177d = true;
        m26542d();
    }

    /* renamed from: c */
    public final void mo30441c() {
        this.f25177d = false;
        m26542d();
    }

    public final void onAudioFocusChange(int i) {
        this.f25176c = i > 0;
        this.f25175b.mo28179a();
    }

    /* renamed from: d */
    private final void m26542d() {
        boolean z = false;
        boolean z2 = this.f25177d && !this.f25178e && this.f25179f > 0.0f;
        if (z2) {
            boolean z3 = this.f25176c;
            if (!z3) {
                AudioManager audioManager = this.f25174a;
                if (audioManager != null && !z3) {
                    if (audioManager.requestAudioFocus(this, 3, 2) == 1) {
                        z = true;
                    }
                    this.f25176c = z;
                }
                this.f25175b.mo28179a();
                return;
            }
        }
        if (!z2) {
            boolean z4 = this.f25176c;
            if (z4) {
                AudioManager audioManager2 = this.f25174a;
                if (audioManager2 != null && z4) {
                    if (audioManager2.abandonAudioFocus(this) == 0) {
                        z = true;
                    }
                    this.f25176c = z;
                }
                this.f25175b.mo28179a();
            }
        }
    }
}
