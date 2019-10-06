package com.google.android.exoplayer2;

/* renamed from: com.google.android.exoplayer2.A */
/* compiled from: RendererConfiguration */
public final class C8095A {

    /* renamed from: a */
    public static final C8095A f16470a = new C8095A(0);

    /* renamed from: b */
    public final int f16471b;

    public C8095A(int tunnelingAudioSessionId) {
        this.f16471b = tunnelingAudioSessionId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f16471b != ((C8095A) obj).f16471b) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f16471b;
    }
}
