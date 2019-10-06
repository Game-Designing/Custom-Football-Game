package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.C8509F;

/* renamed from: com.google.android.exoplayer2.audio.m */
/* compiled from: AudioTimestampPoller */
final class C8130m {

    /* renamed from: a */
    private final C8131a f16681a;

    /* renamed from: b */
    private int f16682b;

    /* renamed from: c */
    private long f16683c;

    /* renamed from: d */
    private long f16684d;

    /* renamed from: e */
    private long f16685e;

    /* renamed from: f */
    private long f16686f;

    @TargetApi(19)
    /* renamed from: com.google.android.exoplayer2.audio.m$a */
    /* compiled from: AudioTimestampPoller */
    private static final class C8131a {

        /* renamed from: a */
        private final AudioTrack f16687a;

        /* renamed from: b */
        private final AudioTimestamp f16688b = new AudioTimestamp();

        /* renamed from: c */
        private long f16689c;

        /* renamed from: d */
        private long f16690d;

        /* renamed from: e */
        private long f16691e;

        public C8131a(AudioTrack audioTrack) {
            this.f16687a = audioTrack;
        }

        /* renamed from: c */
        public boolean mo25122c() {
            boolean updated = this.f16687a.getTimestamp(this.f16688b);
            if (updated) {
                long rawPositionFrames = this.f16688b.framePosition;
                if (this.f16690d > rawPositionFrames) {
                    this.f16689c++;
                }
                this.f16690d = rawPositionFrames;
                this.f16691e = (this.f16689c << 32) + rawPositionFrames;
            }
            return updated;
        }

        /* renamed from: b */
        public long mo25121b() {
            return this.f16688b.nanoTime / 1000;
        }

        /* renamed from: a */
        public long mo25120a() {
            return this.f16691e;
        }
    }

    public C8130m(AudioTrack audioTrack) {
        if (C8509F.f18793a >= 19) {
            this.f16681a = new C8131a(audioTrack);
            mo25119g();
            return;
        }
        this.f16681a = null;
        m18422a(3);
    }

    /* renamed from: a */
    public boolean mo25113a(long systemTimeUs) {
        C8131a aVar = this.f16681a;
        if (aVar == null || systemTimeUs - this.f16685e < this.f16684d) {
            return false;
        }
        this.f16685e = systemTimeUs;
        boolean updatedTimestamp = aVar.mo25122c();
        int i = this.f16682b;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (updatedTimestamp) {
                        mo25119g();
                    }
                } else if (!updatedTimestamp) {
                    mo25119g();
                }
            } else if (!updatedTimestamp) {
                mo25119g();
            } else if (this.f16681a.mo25120a() > this.f16686f) {
                m18422a(2);
            }
        } else if (updatedTimestamp) {
            if (this.f16681a.mo25121b() >= this.f16683c) {
                this.f16686f = this.f16681a.mo25120a();
                m18422a(1);
            } else {
                updatedTimestamp = false;
            }
        } else if (systemTimeUs - this.f16683c > 500000) {
            m18422a(3);
        }
        return updatedTimestamp;
    }

    /* renamed from: f */
    public void mo25118f() {
        m18422a(4);
    }

    /* renamed from: a */
    public void mo25112a() {
        if (this.f16682b == 4) {
            mo25119g();
        }
    }

    /* renamed from: d */
    public boolean mo25116d() {
        int i = this.f16682b;
        return i == 1 || i == 2;
    }

    /* renamed from: e */
    public boolean mo25117e() {
        return this.f16682b == 2;
    }

    /* renamed from: g */
    public void mo25119g() {
        if (this.f16681a != null) {
            m18422a(0);
        }
    }

    /* renamed from: c */
    public long mo25115c() {
        C8131a aVar = this.f16681a;
        if (aVar != null) {
            return aVar.mo25121b();
        }
        return -9223372036854775807L;
    }

    /* renamed from: b */
    public long mo25114b() {
        C8131a aVar = this.f16681a;
        if (aVar != null) {
            return aVar.mo25120a();
        }
        return -1;
    }

    /* renamed from: a */
    private void m18422a(int state) {
        this.f16682b = state;
        if (state == 0) {
            this.f16685e = 0;
            this.f16686f = -1;
            this.f16683c = System.nanoTime() / 1000;
            this.f16684d = 5000;
        } else if (state == 1) {
            this.f16684d = 5000;
        } else if (state == 2 || state == 3) {
            this.f16684d = 10000000;
        } else if (state == 4) {
            this.f16684d = 500000;
        } else {
            throw new IllegalStateException();
        }
    }
}
