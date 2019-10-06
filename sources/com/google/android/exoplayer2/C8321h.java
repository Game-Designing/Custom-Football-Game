package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.trackselection.C8435j;
import com.google.android.exoplayer2.upstream.C8482e;
import com.google.android.exoplayer2.upstream.C8492m.C8493a;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8517g;

/* renamed from: com.google.android.exoplayer2.h */
/* compiled from: ExoPlayerFactory */
public final class C8321h {

    /* renamed from: a */
    private static C8482e f17909a;

    /* renamed from: a */
    public static C8320g m19449a(C8572y[] renderers, C8435j trackSelector, C8363p loadControl) {
        return m19450a(renderers, trackSelector, loadControl, C8509F.m20442a());
    }

    /* renamed from: a */
    public static C8320g m19450a(C8572y[] renderers, C8435j trackSelector, C8363p loadControl, Looper looper) {
        return m19451a(renderers, trackSelector, loadControl, m19452a(), looper);
    }

    /* renamed from: a */
    public static C8320g m19451a(C8572y[] renderers, C8435j trackSelector, C8363p loadControl, C8482e bandwidthMeter, Looper looper) {
        C8323j jVar = new C8323j(renderers, trackSelector, loadControl, bandwidthMeter, C8517g.f18812a, looper);
        return jVar;
    }

    /* renamed from: a */
    private static synchronized C8482e m19452a() {
        C8482e eVar;
        synchronized (C8321h.class) {
            if (f17909a == null) {
                f17909a = new C8493a().mo26029a();
            }
            eVar = f17909a;
        }
        return eVar;
    }
}
