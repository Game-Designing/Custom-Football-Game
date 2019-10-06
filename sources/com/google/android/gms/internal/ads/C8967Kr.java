package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* renamed from: com.google.android.gms.internal.ads.Kr */
final class C8967Kr extends Thread {

    /* renamed from: a */
    private final /* synthetic */ AudioTrack f21414a;

    /* renamed from: b */
    private final /* synthetic */ zzmh f21415b;

    C8967Kr(zzmh zzmh, AudioTrack audioTrack) {
        this.f21415b = zzmh;
        this.f21414a = audioTrack;
    }

    public final void run() {
        try {
            this.f21414a.flush();
            this.f21414a.release();
        } finally {
            this.f21415b.f28883h.open();
        }
    }
}
