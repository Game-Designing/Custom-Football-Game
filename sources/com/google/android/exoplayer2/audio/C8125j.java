package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;

/* renamed from: com.google.android.exoplayer2.audio.j */
/* compiled from: AudioAttributes */
public final class C8125j {

    /* renamed from: a */
    public static final C8125j f16668a = new C8126a().mo25088a();

    /* renamed from: b */
    public final int f16669b;

    /* renamed from: c */
    public final int f16670c;

    /* renamed from: d */
    public final int f16671d;

    /* renamed from: e */
    private AudioAttributes f16672e;

    /* renamed from: com.google.android.exoplayer2.audio.j$a */
    /* compiled from: AudioAttributes */
    public static final class C8126a {

        /* renamed from: a */
        private int f16673a = 0;

        /* renamed from: b */
        private int f16674b = 0;

        /* renamed from: c */
        private int f16675c = 1;

        /* renamed from: a */
        public C8125j mo25088a() {
            return new C8125j(this.f16673a, this.f16674b, this.f16675c);
        }
    }

    private C8125j(int contentType, int flags, int usage) {
        this.f16669b = contentType;
        this.f16670c = flags;
        this.f16671d = usage;
    }

    @TargetApi(21)
    /* renamed from: a */
    public AudioAttributes mo25085a() {
        if (this.f16672e == null) {
            this.f16672e = new Builder().setContentType(this.f16669b).setFlags(this.f16670c).setUsage(this.f16671d).build();
        }
        return this.f16672e;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C8125j other = (C8125j) obj;
        if (!(this.f16669b == other.f16669b && this.f16670c == other.f16670c && this.f16671d == other.f16671d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((17 * 31) + this.f16669b) * 31) + this.f16670c) * 31) + this.f16671d;
    }
}
