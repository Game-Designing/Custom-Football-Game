package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C8275d;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import java.lang.reflect.Method;

/* renamed from: com.google.android.exoplayer2.audio.n */
/* compiled from: AudioTrackPositionTracker */
final class C8132n {

    /* renamed from: a */
    private final C8133a f16692a;

    /* renamed from: b */
    private final long[] f16693b;

    /* renamed from: c */
    private AudioTrack f16694c;

    /* renamed from: d */
    private int f16695d;

    /* renamed from: e */
    private int f16696e;

    /* renamed from: f */
    private C8130m f16697f;

    /* renamed from: g */
    private int f16698g;

    /* renamed from: h */
    private boolean f16699h;

    /* renamed from: i */
    private long f16700i;

    /* renamed from: j */
    private long f16701j;

    /* renamed from: k */
    private long f16702k;

    /* renamed from: l */
    private Method f16703l;

    /* renamed from: m */
    private long f16704m;

    /* renamed from: n */
    private boolean f16705n;

    /* renamed from: o */
    private boolean f16706o;

    /* renamed from: p */
    private long f16707p;

    /* renamed from: q */
    private long f16708q;

    /* renamed from: r */
    private long f16709r;

    /* renamed from: s */
    private long f16710s;

    /* renamed from: t */
    private int f16711t;

    /* renamed from: u */
    private int f16712u;

    /* renamed from: v */
    private long f16713v;

    /* renamed from: w */
    private long f16714w;

    /* renamed from: x */
    private long f16715x;

    /* renamed from: y */
    private long f16716y;

    /* renamed from: com.google.android.exoplayer2.audio.n$a */
    /* compiled from: AudioTrackPositionTracker */
    public interface C8133a {
        /* renamed from: a */
        void mo25075a(int i, long j);

        /* renamed from: a */
        void mo25076a(long j);

        /* renamed from: a */
        void mo25077a(long j, long j2, long j3, long j4);

        /* renamed from: b */
        void mo25078b(long j, long j2, long j3, long j4);
    }

    public C8132n(C8133a listener) {
        C8514e.m20486a(listener);
        this.f16692a = listener;
        if (C8509F.f18793a >= 18) {
            try {
                this.f16703l = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        this.f16693b = new long[10];
    }

    /* renamed from: a */
    public void mo25125a(AudioTrack audioTrack, int outputEncoding, int outputPcmFrameSize, int bufferSize) {
        this.f16694c = audioTrack;
        this.f16695d = outputPcmFrameSize;
        this.f16696e = bufferSize;
        this.f16697f = new C8130m(audioTrack);
        this.f16698g = audioTrack.getSampleRate();
        this.f16699h = m18435a(outputEncoding);
        this.f16706o = C8509F.m20478f(outputEncoding);
        this.f16700i = this.f16706o ? m18438f((long) (bufferSize / outputPcmFrameSize)) : -9223372036854775807L;
        this.f16708q = 0;
        this.f16709r = 0;
        this.f16710s = 0;
        this.f16705n = false;
        this.f16713v = -9223372036854775807L;
        this.f16714w = -9223372036854775807L;
        this.f16704m = 0;
    }

    /* renamed from: a */
    public long mo25124a(boolean sourceEnded) {
        long positionUs;
        AudioTrack audioTrack = this.f16694c;
        C8514e.m20486a(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            m18441h();
        }
        long systemTimeUs = System.nanoTime() / 1000;
        C8130m mVar = this.f16697f;
        C8514e.m20486a(mVar);
        C8130m audioTimestampPoller = mVar;
        if (audioTimestampPoller.mo25116d()) {
            long timestampPositionUs = m18438f(audioTimestampPoller.mo25114b());
            if (!audioTimestampPoller.mo25117e()) {
                return timestampPositionUs;
            }
            return timestampPositionUs + (systemTimeUs - audioTimestampPoller.mo25115c());
        }
        if (this.f16712u == 0) {
            positionUs = m18439g();
        } else {
            positionUs = this.f16701j + systemTimeUs;
        }
        if (!sourceEnded) {
            positionUs -= this.f16704m;
        }
        return positionUs;
    }

    /* renamed from: d */
    public void mo25131d() {
        C8130m mVar = this.f16697f;
        C8514e.m20486a(mVar);
        mVar.mo25119g();
    }

    /* renamed from: a */
    public boolean mo25126a() {
        AudioTrack audioTrack = this.f16694c;
        C8514e.m20486a(audioTrack);
        return audioTrack.getPlayState() == 3;
    }

    /* renamed from: e */
    public boolean mo25133e(long writtenFrames) {
        AudioTrack audioTrack = this.f16694c;
        C8514e.m20486a(audioTrack);
        int playState = audioTrack.getPlayState();
        if (this.f16699h) {
            if (playState == 2) {
                this.f16705n = false;
                return false;
            } else if (playState == 1 && m18437f() == 0) {
                return false;
            }
        }
        boolean hadData = this.f16705n;
        this.f16705n = mo25130c(writtenFrames);
        if (hadData && !this.f16705n && playState != 1) {
            C8133a aVar = this.f16692a;
            if (aVar != null) {
                aVar.mo25075a(this.f16696e, C8275d.m19231b(this.f16700i));
            }
        }
        return true;
    }

    /* renamed from: a */
    public int mo25123a(long writtenBytes) {
        return this.f16696e - ((int) (writtenBytes - (m18437f() * ((long) this.f16695d))));
    }

    /* renamed from: d */
    public boolean mo25132d(long writtenFrames) {
        return this.f16714w != -9223372036854775807L && writtenFrames > 0 && SystemClock.elapsedRealtime() - this.f16714w >= 200;
    }

    /* renamed from: b */
    public void mo25127b(long writtenFrames) {
        this.f16715x = m18437f();
        this.f16713v = SystemClock.elapsedRealtime() * 1000;
        this.f16716y = writtenFrames;
    }

    /* renamed from: c */
    public boolean mo25130c(long writtenFrames) {
        return writtenFrames > m18437f() || m18436e();
    }

    /* renamed from: b */
    public boolean mo25128b() {
        m18442i();
        if (this.f16713v != -9223372036854775807L) {
            return false;
        }
        C8130m mVar = this.f16697f;
        C8514e.m20486a(mVar);
        mVar.mo25119g();
        return true;
    }

    /* renamed from: c */
    public void mo25129c() {
        m18442i();
        this.f16694c = null;
        this.f16697f = null;
    }

    /* renamed from: h */
    private void m18441h() {
        long playbackPositionUs = m18439g();
        if (playbackPositionUs != 0) {
            long systemTimeUs = System.nanoTime() / 1000;
            if (systemTimeUs - this.f16702k >= 30000) {
                long[] jArr = this.f16693b;
                int i = this.f16711t;
                jArr[i] = playbackPositionUs - systemTimeUs;
                this.f16711t = (i + 1) % 10;
                int i2 = this.f16712u;
                if (i2 < 10) {
                    this.f16712u = i2 + 1;
                }
                this.f16702k = systemTimeUs;
                this.f16701j = 0;
                int i3 = 0;
                while (true) {
                    int i4 = this.f16712u;
                    if (i3 >= i4) {
                        break;
                    }
                    this.f16701j += this.f16693b[i3] / ((long) i4);
                    i3++;
                }
            }
            if (this.f16699h == 0) {
                m18434a(systemTimeUs, playbackPositionUs);
                m18440g(systemTimeUs);
            }
        }
    }

    /* renamed from: a */
    private void m18434a(long systemTimeUs, long playbackPositionUs) {
        long j = systemTimeUs;
        C8130m mVar = this.f16697f;
        C8514e.m20486a(mVar);
        C8130m audioTimestampPoller = mVar;
        if (audioTimestampPoller.mo25113a(j)) {
            long audioTimestampSystemTimeUs = audioTimestampPoller.mo25115c();
            long audioTimestampPositionFrames = audioTimestampPoller.mo25114b();
            if (Math.abs(audioTimestampSystemTimeUs - j) > 5000000) {
                long j2 = audioTimestampPositionFrames;
                this.f16692a.mo25078b(audioTimestampPositionFrames, audioTimestampSystemTimeUs, systemTimeUs, playbackPositionUs);
                audioTimestampPoller.mo25118f();
            } else {
                long audioTimestampPositionFrames2 = audioTimestampPositionFrames;
                if (Math.abs(m18438f(audioTimestampPositionFrames2) - playbackPositionUs) > 5000000) {
                    this.f16692a.mo25077a(audioTimestampPositionFrames2, audioTimestampSystemTimeUs, systemTimeUs, playbackPositionUs);
                    audioTimestampPoller.mo25118f();
                } else {
                    audioTimestampPoller.mo25112a();
                }
            }
        }
    }

    /* renamed from: g */
    private void m18440g(long systemTimeUs) {
        if (this.f16706o) {
            Method method = this.f16703l;
            if (method != null && systemTimeUs - this.f16707p >= 500000) {
                try {
                    AudioTrack audioTrack = this.f16694c;
                    C8514e.m20486a(audioTrack);
                    Integer num = (Integer) method.invoke(audioTrack, new Object[0]);
                    C8509F.m20443a(num);
                    this.f16704m = (((long) num.intValue()) * 1000) - this.f16700i;
                    this.f16704m = Math.max(this.f16704m, 0);
                    if (this.f16704m > 5000000) {
                        this.f16692a.mo25076a(this.f16704m);
                        this.f16704m = 0;
                    }
                } catch (Exception e) {
                    this.f16703l = null;
                }
                this.f16707p = systemTimeUs;
            }
        }
    }

    /* renamed from: f */
    private long m18438f(long frameCount) {
        return (1000000 * frameCount) / ((long) this.f16698g);
    }

    /* renamed from: i */
    private void m18442i() {
        this.f16701j = 0;
        this.f16712u = 0;
        this.f16711t = 0;
        this.f16702k = 0;
    }

    /* renamed from: e */
    private boolean m18436e() {
        if (this.f16699h) {
            AudioTrack audioTrack = this.f16694c;
            C8514e.m20486a(audioTrack);
            if (audioTrack.getPlayState() == 2 && m18437f() == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m18435a(int outputEncoding) {
        return C8509F.f18793a < 23 && (outputEncoding == 5 || outputEncoding == 6);
    }

    /* renamed from: g */
    private long m18439g() {
        return m18438f(m18437f());
    }

    /* renamed from: f */
    private long m18437f() {
        AudioTrack audioTrack = this.f16694c;
        C8514e.m20486a(audioTrack);
        AudioTrack audioTrack2 = audioTrack;
        if (this.f16713v != -9223372036854775807L) {
            return Math.min(this.f16716y, this.f16715x + ((((long) this.f16698g) * ((SystemClock.elapsedRealtime() * 1000) - this.f16713v)) / 1000000));
        }
        int state = audioTrack2.getPlayState();
        if (state == 1) {
            return 0;
        }
        long rawPlaybackHeadPosition = 4294967295L & ((long) audioTrack2.getPlaybackHeadPosition());
        if (this.f16699h) {
            if (state == 2 && rawPlaybackHeadPosition == 0) {
                this.f16710s = this.f16708q;
            }
            rawPlaybackHeadPosition += this.f16710s;
        }
        if (C8509F.f18793a <= 28) {
            if (rawPlaybackHeadPosition == 0 && this.f16708q > 0 && state == 3) {
                if (this.f16714w == -9223372036854775807L) {
                    this.f16714w = SystemClock.elapsedRealtime();
                }
                return this.f16708q;
            }
            this.f16714w = -9223372036854775807L;
        }
        if (this.f16708q > rawPlaybackHeadPosition) {
            this.f16709r++;
        }
        this.f16708q = rawPlaybackHeadPosition;
        return (this.f16709r << 32) + rawPlaybackHeadPosition;
    }
}
