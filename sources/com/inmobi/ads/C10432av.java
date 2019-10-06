package com.inmobi.ads;

import android.media.MediaPlayer;

/* renamed from: com.inmobi.ads.av */
/* compiled from: NativeMediaPlayer */
public final class C10432av extends MediaPlayer {

    /* renamed from: d */
    private static final Object f31742d = new Object();

    /* renamed from: e */
    private static C10432av f31743e;

    /* renamed from: f */
    private static int f31744f = 0;

    /* renamed from: a */
    int f31745a = 0;

    /* renamed from: b */
    int f31746b = 0;

    /* renamed from: c */
    private C10432av f31747c;

    /* renamed from: a */
    public static C10432av m34161a() {
        synchronized (f31742d) {
            if (f31743e == null) {
                return new C10432av();
            }
            C10432av avVar = f31743e;
            f31743e = avVar.f31747c;
            avVar.f31747c = null;
            f31744f--;
            return avVar;
        }
    }

    /* renamed from: b */
    public final void mo34138b() {
        if (!(3 == this.f31745a)) {
            synchronized (f31742d) {
                if (f31744f < 5) {
                    this.f31747c = f31743e;
                    f31743e = this;
                    f31744f++;
                }
            }
        }
    }
}
