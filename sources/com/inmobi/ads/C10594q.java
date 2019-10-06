package com.inmobi.ads;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.inmobi.ads.q */
/* compiled from: BannerRefreshHandler */
final class C10594q extends Handler {

    /* renamed from: a */
    private InMobiBanner f32274a;

    C10594q(InMobiBanner inMobiBanner) {
        this.f32274a = inMobiBanner;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            this.f32274a.mo33715a(true);
        }
    }
}
