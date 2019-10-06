package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* renamed from: com.google.android.gms.internal.ads.Xq */
final class C9242Xq extends Thread {

    /* renamed from: a */
    private final /* synthetic */ AudioTrack f21932a;

    /* renamed from: b */
    private final /* synthetic */ zzhq f21933b;

    C9242Xq(zzhq zzhq, AudioTrack audioTrack) {
        this.f21933b = zzhq;
        this.f21932a = audioTrack;
    }

    public final void run() {
        try {
            this.f21932a.release();
        } finally {
            this.f21933b.f28537b.open();
        }
    }
}
