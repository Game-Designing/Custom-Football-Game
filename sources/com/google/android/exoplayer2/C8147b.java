package com.google.android.exoplayer2;

import com.google.android.exoplayer2.C8098D.C8100b;

/* renamed from: com.google.android.exoplayer2.b */
/* compiled from: BasePlayer */
public abstract class C8147b implements C8543v {

    /* renamed from: a */
    protected final C8100b f16815a = new C8100b();

    /* renamed from: a */
    public final void mo25180a(long positionMs) {
        mo25470a(mo25482j(), positionMs);
    }

    public final void stop() {
        mo25476b(false);
    }

    /* renamed from: b */
    public final long mo25181b() {
        C8098D timeline = mo25483k();
        if (timeline.mo24986c()) {
            return -9223372036854775807L;
        }
        return timeline.mo24982a(mo25482j(), this.f16815a).mo25004b();
    }
}
