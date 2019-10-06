package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.C8274c;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.C8278c;
import com.google.android.exoplayer2.drm.C8280e;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.mediacodec.C8338a;
import com.google.android.exoplayer2.mediacodec.C8341d;
import com.google.android.exoplayer2.mediacodec.C8343f;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.p182a.C8106d;
import com.google.android.exoplayer2.p182a.C8107e;
import com.google.android.exoplayer2.util.C8507E;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8529q;
import com.google.android.exoplayer2.video.C8566p.C8567a;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.video.m */
/* compiled from: MediaCodecVideoRenderer */
public class C8559m extends MediaCodecRenderer {

    /* renamed from: ha */
    private static final int[] f18928ha = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: ia */
    private static boolean f18929ia;

    /* renamed from: ja */
    private static boolean f18930ja;

    /* renamed from: Aa */
    private long f18931Aa;

    /* renamed from: Ba */
    private int f18932Ba;

    /* renamed from: Ca */
    private int f18933Ca;

    /* renamed from: Da */
    private int f18934Da;

    /* renamed from: Ea */
    private long f18935Ea;

    /* renamed from: Fa */
    private int f18936Fa;

    /* renamed from: Ga */
    private float f18937Ga;

    /* renamed from: Ha */
    private int f18938Ha;

    /* renamed from: Ia */
    private int f18939Ia;

    /* renamed from: Ja */
    private int f18940Ja;

    /* renamed from: Ka */
    private float f18941Ka;

    /* renamed from: La */
    private int f18942La;

    /* renamed from: Ma */
    private int f18943Ma;

    /* renamed from: Na */
    private int f18944Na;

    /* renamed from: Oa */
    private float f18945Oa;

    /* renamed from: Pa */
    private boolean f18946Pa;

    /* renamed from: Qa */
    private int f18947Qa;

    /* renamed from: Ra */
    C8561b f18948Ra;

    /* renamed from: Sa */
    private long f18949Sa;

    /* renamed from: Ta */
    private long f18950Ta;

    /* renamed from: Ua */
    private int f18951Ua;

    /* renamed from: Va */
    private C8562n f18952Va;

    /* renamed from: ka */
    private final Context f18953ka;

    /* renamed from: la */
    private final C8563o f18954la;

    /* renamed from: ma */
    private final C8567a f18955ma;

    /* renamed from: na */
    private final long f18956na;

    /* renamed from: oa */
    private final int f18957oa;

    /* renamed from: pa */
    private final boolean f18958pa;

    /* renamed from: qa */
    private final long[] f18959qa;

    /* renamed from: ra */
    private final long[] f18960ra;

    /* renamed from: sa */
    private C8560a f18961sa;

    /* renamed from: ta */
    private boolean f18962ta;

    /* renamed from: ua */
    private Surface f18963ua;

    /* renamed from: va */
    private Surface f18964va;

    /* renamed from: wa */
    private int f18965wa;

    /* renamed from: xa */
    private boolean f18966xa;

    /* renamed from: ya */
    private long f18967ya;

    /* renamed from: za */
    private long f18968za;

    /* renamed from: com.google.android.exoplayer2.video.m$a */
    /* compiled from: MediaCodecVideoRenderer */
    protected static final class C8560a {

        /* renamed from: a */
        public final int f18969a;

        /* renamed from: b */
        public final int f18970b;

        /* renamed from: c */
        public final int f18971c;

        public C8560a(int width, int height, int inputSize) {
            this.f18969a = width;
            this.f18970b = height;
            this.f18971c = inputSize;
        }
    }

    @TargetApi(23)
    /* renamed from: com.google.android.exoplayer2.video.m$b */
    /* compiled from: MediaCodecVideoRenderer */
    private final class C8561b implements OnFrameRenderedListener {
        private C8561b(MediaCodec codec) {
            codec.setOnFrameRenderedListener(this, new Handler());
        }

        public void onFrameRendered(MediaCodec codec, long presentationTimeUs, long nanoTime) {
            C8559m mVar = C8559m.this;
            if (this == mVar.f18948Ra) {
                mVar.mo26194e(presentationTimeUs);
            }
        }
    }

    public C8559m(Context context, C8341d mediaCodecSelector, long allowedJoiningTimeMs, Handler eventHandler, C8566p eventListener, int maxDroppedFramesToNotify) {
        this(context, mediaCodecSelector, allowedJoiningTimeMs, null, false, eventHandler, eventListener, maxDroppedFramesToNotify);
    }

    public C8559m(Context context, C8341d mediaCodecSelector, long allowedJoiningTimeMs, C8278c<C8280e> drmSessionManager, boolean playClearSamplesWithoutKeys, Handler eventHandler, C8566p eventListener, int maxDroppedFramesToNotify) {
        super(2, mediaCodecSelector, drmSessionManager, playClearSamplesWithoutKeys, 30.0f);
        this.f18956na = allowedJoiningTimeMs;
        this.f18957oa = maxDroppedFramesToNotify;
        this.f18953ka = context.getApplicationContext();
        this.f18954la = new C8563o(this.f18953ka);
        this.f18955ma = new C8567a(eventHandler, eventListener);
        this.f18958pa = m20666P();
        this.f18959qa = new long[10];
        this.f18960ra = new long[10];
        this.f18950Ta = -9223372036854775807L;
        this.f18949Sa = -9223372036854775807L;
        this.f18968za = -9223372036854775807L;
        this.f18938Ha = -1;
        this.f18939Ia = -1;
        this.f18941Ka = -1.0f;
        this.f18937Ga = -1.0f;
        this.f18965wa = 1;
        m20665O();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo25144a(C8341d mediaCodecSelector, C8278c<C8280e> drmSessionManager, Format format) throws DecoderQueryException {
        int tunnelingSupport = 0;
        if (!C8529q.m20549h(format.f16507g)) {
            return 0;
        }
        boolean requiresSecureDecryption = false;
        DrmInitData drmInitData = format.f16510j;
        if (drmInitData != null) {
            for (int i = 0; i < drmInitData.f17539d; i++) {
                requiresSecureDecryption |= drmInitData.mo25388a(i).f17545f;
            }
        }
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.mo25540a(format.f16507g, requiresSecureDecryption);
        int i2 = 2;
        if (decoderInfos.isEmpty()) {
            if (!requiresSecureDecryption || mediaCodecSelector.mo25540a(format.f16507g, false).isEmpty()) {
                i2 = 1;
            }
            return i2;
        } else if (!C8274c.m19204a(drmSessionManager, drmInitData)) {
            return 2;
        } else {
            C8338a decoderInfo = (C8338a) decoderInfos.get(0);
            boolean isFormatSupported = decoderInfo.mo25532a(format);
            int adaptiveSupport = decoderInfo.mo25537b(format) ? 16 : 8;
            if (decoderInfo.f18065e) {
                tunnelingSupport = 32;
            }
            return adaptiveSupport | tunnelingSupport | (isFormatSupported ? 4 : 3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25157a(boolean joining) throws ExoPlaybackException {
        super.mo25157a(joining);
        this.f18947Qa = mo25380n().f16471b;
        this.f18946Pa = this.f18947Qa != 0;
        this.f18955ma.mo26226b(this.f18028ga);
        this.f18954la.mo26199b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25158a(Format[] formats, long offsetUs) throws ExoPlaybackException {
        if (this.f18950Ta == -9223372036854775807L) {
            this.f18950Ta = offsetUs;
        } else {
            int i = this.f18951Ua;
            if (i == this.f18959qa.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(this.f18959qa[this.f18951Ua - 1]);
                C8526n.m20534d("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.f18951Ua = i + 1;
            }
            long[] jArr = this.f18959qa;
            int i2 = this.f18951Ua;
            jArr[i2 - 1] = offsetUs;
            this.f18960ra[i2 - 1] = this.f18949Sa;
        }
        super.mo25158a(formats, offsetUs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25152a(long positionUs, boolean joining) throws ExoPlaybackException {
        super.mo25152a(positionUs, joining);
        m20664N();
        this.f18967ya = -9223372036854775807L;
        this.f18933Ca = 0;
        this.f18949Sa = -9223372036854775807L;
        int i = this.f18951Ua;
        if (i != 0) {
            this.f18950Ta = this.f18959qa[i - 1];
            this.f18951Ua = 0;
        }
        if (joining) {
            m20671U();
        } else {
            this.f18968za = -9223372036854775807L;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r9.f18946Pa != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r9.f18963ua == r0) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isReady() {
        /*
            r9 = this;
            boolean r0 = super.isReady()
            r1 = 1
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0025
            boolean r0 = r9.f18966xa
            if (r0 != 0) goto L_0x0022
            android.view.Surface r0 = r9.f18964va
            if (r0 == 0) goto L_0x0018
            android.view.Surface r4 = r9.f18963ua
            if (r4 == r0) goto L_0x0022
        L_0x0018:
            android.media.MediaCodec r0 = r9.mo25514v()
            if (r0 == 0) goto L_0x0022
            boolean r0 = r9.f18946Pa
            if (r0 == 0) goto L_0x0025
        L_0x0022:
            r9.f18968za = r2
            return r1
        L_0x0025:
            long r4 = r9.f18968za
            r0 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x002d
            return r0
        L_0x002d:
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r9.f18968za
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0038
            return r1
        L_0x0038:
            r9.f18968za = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.C8559m.isReady():boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void mo25168s() {
        super.mo25168s();
        this.f18932Ba = 0;
        this.f18931Aa = SystemClock.elapsedRealtime();
        this.f18935Ea = SystemClock.elapsedRealtime() * 1000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void mo25169t() {
        this.f18968za = -9223372036854775807L;
        m20667Q();
        super.mo25169t();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo25167r() {
        this.f18938Ha = -1;
        this.f18939Ia = -1;
        this.f18941Ka = -1.0f;
        this.f18937Ga = -1.0f;
        this.f18950Ta = -9223372036854775807L;
        this.f18949Sa = -9223372036854775807L;
        this.f18951Ua = 0;
        m20665O();
        m20664N();
        this.f18954la.mo26198a();
        this.f18948Ra = null;
        this.f18946Pa = false;
        try {
            super.mo25167r();
        } finally {
            this.f18028ga.mo25029a();
            this.f18955ma.mo26220a(this.f18028ga);
        }
    }

    /* renamed from: a */
    public void mo25151a(int messageType, Object message) throws ExoPlaybackException {
        if (messageType == 1) {
            m20678a((Surface) message);
        } else if (messageType == 4) {
            this.f18965wa = ((Integer) message).intValue();
            MediaCodec codec = mo25514v();
            if (codec != null) {
                codec.setVideoScalingMode(this.f18965wa);
            }
        } else if (messageType == 6) {
            this.f18952Va = (C8562n) message;
        } else {
            super.mo25151a(messageType, message);
        }
    }

    /* renamed from: a */
    private void m20678a(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            if (this.f18964va != null) {
                surface = this.f18964va;
            } else {
                C8338a codecInfo = mo25515w();
                if (codecInfo != null && m20680c(codecInfo)) {
                    this.f18964va = DummySurface.m20653a(this.f18953ka, codecInfo.f18066f);
                    surface = this.f18964va;
                }
            }
        }
        if (this.f18963ua != surface) {
            this.f18963ua = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec codec = mo25514v();
                if (C8509F.f18793a < 23 || codec == null || surface == null || this.f18962ta) {
                    mo25506A();
                    mo25518z();
                } else {
                    m20676a(codec, surface);
                }
            }
            if (surface == null || surface == this.f18964va) {
                m20665O();
                m20664N();
                return;
            }
            m20670T();
            m20664N();
            if (state == 2) {
                m20671U();
            }
        } else if (surface != null && surface != this.f18964va) {
            m20670T();
            m20669S();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25510a(C8338a codecInfo) {
        return this.f18963ua != null || m20680c(codecInfo);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo25516x() {
        return this.f18946Pa;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25155a(C8338a codecInfo, MediaCodec codec, Format format, MediaCrypto crypto, float codecOperatingRate) throws DecoderQueryException {
        this.f18961sa = mo26184a(codecInfo, format, mo25382p());
        MediaFormat mediaFormat = mo26183a(format, this.f18961sa, codecOperatingRate, this.f18958pa, this.f18947Qa);
        if (this.f18963ua == null) {
            C8514e.m20490b(m20680c(codecInfo));
            if (this.f18964va == null) {
                this.f18964va = DummySurface.m20653a(this.f18953ka, codecInfo.f18066f);
            }
            this.f18963ua = this.f18964va;
        }
        codec.configure(mediaFormat, this.f18963ua, crypto, 0);
        if (C8509F.f18793a >= 23 && this.f18946Pa) {
            this.f18948Ra = new C8561b(codec);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo25142a(MediaCodec codec, C8338a codecInfo, Format oldFormat, Format newFormat) {
        int i = 1;
        if (codecInfo.mo25533a(oldFormat, newFormat, true)) {
            int i2 = newFormat.f16512l;
            C8560a aVar = this.f18961sa;
            if (i2 <= aVar.f18969a && newFormat.f16513m <= aVar.f18970b && m20679b(codecInfo, newFormat) <= this.f18961sa.f18971c) {
                if (!oldFormat.mo25013a(newFormat)) {
                    i = 3;
                }
                return i;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public void mo25506A() {
        try {
            super.mo25506A();
        } finally {
            this.f18934Da = 0;
            Surface surface = this.f18964va;
            if (surface != null) {
                if (this.f18963ua == surface) {
                    this.f18963ua = null;
                }
                this.f18964va.release();
                this.f18964va = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void mo25513u() throws ExoPlaybackException {
        super.mo25513u();
        this.f18934Da = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo25141a(float operatingRate, Format format, Format[] streamFormats) {
        float maxFrameRate = -1.0f;
        for (Format streamFormat : streamFormats) {
            float streamFrameRate = streamFormat.f16514n;
            if (streamFrameRate != -1.0f) {
                maxFrameRate = Math.max(maxFrameRate, streamFrameRate);
            }
        }
        if (maxFrameRate == -1.0f) {
            return -1.0f;
        }
        return maxFrameRate * operatingRate;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25156a(String name, long initializedTimestampMs, long initializationDurationMs) {
        this.f18955ma.mo26221a(name, initializedTimestampMs, initializationDurationMs);
        this.f18962ta = mo26187a(name);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25161b(Format newFormat) throws ExoPlaybackException {
        super.mo25161b(newFormat);
        this.f18955ma.mo26219a(newFormat);
        this.f18937Ga = newFormat.f16516p;
        this.f18936Fa = newFormat.f16515o;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25154a(C8107e buffer) {
        this.f18934Da++;
        this.f18949Sa = Math.max(buffer.f16556d, this.f18949Sa);
        if (C8509F.f18793a < 23 && this.f18946Pa) {
            mo26194e(buffer.f16556d);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25153a(MediaCodec codec, MediaFormat outputFormat) {
        int width;
        int i;
        String str = "crop-right";
        String str2 = "crop-top";
        String str3 = "crop-bottom";
        String str4 = "crop-left";
        boolean hasCrop = outputFormat.containsKey(str) && outputFormat.containsKey(str4) && outputFormat.containsKey(str3) && outputFormat.containsKey(str2);
        if (hasCrop) {
            width = (outputFormat.getInteger(str) - outputFormat.getInteger(str4)) + 1;
        } else {
            width = outputFormat.getInteger("width");
        }
        if (hasCrop) {
            i = (outputFormat.getInteger(str3) - outputFormat.getInteger(str2)) + 1;
        } else {
            i = outputFormat.getInteger("height");
        }
        m20675a(codec, width, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25160a(long positionUs, long elapsedRealtimeUs, MediaCodec codec, ByteBuffer buffer, int bufferIndex, int bufferFlags, long bufferPresentationTimeUs, boolean shouldSkip, Format format) throws ExoPlaybackException {
        long presentationTimeUs;
        long presentationTimeUs2;
        long unadjustedFrameReleaseTimeNs;
        long j = positionUs;
        long j2 = elapsedRealtimeUs;
        MediaCodec mediaCodec = codec;
        int i = bufferIndex;
        long j3 = bufferPresentationTimeUs;
        if (this.f18967ya == -9223372036854775807L) {
            this.f18967ya = j;
        }
        long presentationTimeUs3 = j3 - this.f18950Ta;
        if (shouldSkip) {
            mo26191c(mediaCodec, i, presentationTimeUs3);
            return true;
        }
        long earlyUs = j3 - j;
        if (this.f18963ua != this.f18964va) {
            long elapsedRealtimeNowUs = SystemClock.elapsedRealtime() * 1000;
            boolean isStarted = getState() == 2;
            if (!this.f18966xa) {
                presentationTimeUs = presentationTimeUs3;
            } else if (!isStarted || !mo26193d(earlyUs, elapsedRealtimeNowUs - this.f18935Ea)) {
                if (!isStarted) {
                } else if (j == this.f18967ya) {
                    long j4 = presentationTimeUs3;
                } else {
                    long earlyUs2 = earlyUs - (elapsedRealtimeNowUs - j2);
                    long systemTimeNs = System.nanoTime();
                    long unadjustedFrameReleaseTimeNs2 = systemTimeNs + (earlyUs2 * 1000);
                    long adjustedReleaseTimeNs = this.f18954la.mo26197a(j3, unadjustedFrameReleaseTimeNs2);
                    long earlyUs3 = (adjustedReleaseTimeNs - systemTimeNs) / 1000;
                    if (mo26190b(earlyUs3, j2)) {
                        long j5 = unadjustedFrameReleaseTimeNs2;
                        unadjustedFrameReleaseTimeNs = earlyUs3;
                        presentationTimeUs2 = presentationTimeUs3;
                        if (mo26186a(codec, bufferIndex, presentationTimeUs3, positionUs)) {
                            return false;
                        }
                    } else {
                        presentationTimeUs2 = presentationTimeUs3;
                        long j6 = unadjustedFrameReleaseTimeNs2;
                        unadjustedFrameReleaseTimeNs = earlyUs3;
                    }
                    if (mo26192c(unadjustedFrameReleaseTimeNs, j2)) {
                        mo26185a(mediaCodec, i, presentationTimeUs2);
                        return true;
                    }
                    long presentationTimeUs4 = presentationTimeUs2;
                    if (C8509F.f18793a < 21) {
                        long presentationTimeUs5 = presentationTimeUs4;
                        if (unadjustedFrameReleaseTimeNs < 30000) {
                            if (unadjustedFrameReleaseTimeNs > 11000) {
                                try {
                                    Thread.sleep((unadjustedFrameReleaseTimeNs - 10000) / 1000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                    return false;
                                }
                            }
                            m20674a(presentationTimeUs5, adjustedReleaseTimeNs, format);
                            mo26188b(mediaCodec, i, presentationTimeUs5);
                            return true;
                        }
                    } else if (unadjustedFrameReleaseTimeNs < 50000) {
                        long presentationTimeUs6 = presentationTimeUs4;
                        m20674a(presentationTimeUs4, adjustedReleaseTimeNs, format);
                        mo26189b(codec, bufferIndex, presentationTimeUs6, adjustedReleaseTimeNs);
                        return true;
                    }
                    return false;
                }
                return false;
            } else {
                presentationTimeUs = presentationTimeUs3;
            }
            long releaseTimeNs = System.nanoTime();
            long j7 = earlyUs;
            long presentationTimeUs7 = presentationTimeUs;
            m20674a(presentationTimeUs, releaseTimeNs, format);
            if (C8509F.f18793a >= 21) {
                mo26189b(codec, bufferIndex, presentationTimeUs7, releaseTimeNs);
                long j8 = presentationTimeUs7;
            } else {
                mo26188b(mediaCodec, i, presentationTimeUs7);
            }
            return true;
        } else if (!m20681f(earlyUs)) {
            return false;
        } else {
            mo26191c(mediaCodec, i, presentationTimeUs3);
            return true;
        }
    }

    /* renamed from: a */
    private void m20675a(MediaCodec codec, int width, int height) {
        this.f18938Ha = width;
        this.f18939Ia = height;
        this.f18941Ka = this.f18937Ga;
        if (C8509F.f18793a >= 21) {
            int i = this.f18936Fa;
            if (i == 90 || i == 270) {
                int rotatedHeight = this.f18938Ha;
                this.f18938Ha = this.f18939Ia;
                this.f18939Ia = rotatedHeight;
                this.f18941Ka = 1.0f / this.f18941Ka;
            }
        } else {
            this.f18940Ja = this.f18936Fa;
        }
        codec.setVideoScalingMode(this.f18965wa);
    }

    /* renamed from: a */
    private void m20674a(long presentationTimeUs, long releaseTimeNs, Format format) {
        C8562n nVar = this.f18952Va;
        if (nVar != null) {
            nVar.mo26196a(presentationTimeUs, releaseTimeNs, format);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo26194e(long presentationTimeUs) {
        Format format = mo25511d(presentationTimeUs);
        if (format != null) {
            m20675a(mo25514v(), format.f16512l, format.f16513m);
        }
        m20668R();
        mo25140C();
        mo25163c(presentationTimeUs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo25163c(long presentationTimeUs) {
        this.f18934Da--;
        while (true) {
            int i = this.f18951Ua;
            if (i != 0 && presentationTimeUs >= this.f18960ra[0]) {
                long[] jArr = this.f18959qa;
                this.f18950Ta = jArr[0];
                this.f18951Ua = i - 1;
                System.arraycopy(jArr, 1, jArr, 0, this.f18951Ua);
                long[] jArr2 = this.f18960ra;
                System.arraycopy(jArr2, 1, jArr2, 0, this.f18951Ua);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo26192c(long earlyUs, long elapsedRealtimeUs) {
        return m20681f(earlyUs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo26190b(long earlyUs, long elapsedRealtimeUs) {
        return m20683g(earlyUs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo26193d(long earlyUs, long elapsedSinceLastRenderUs) {
        return m20681f(earlyUs) && elapsedSinceLastRenderUs > 100000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo26191c(MediaCodec codec, int index, long presentationTimeUs) {
        C8507E.m20417a("skipVideoBuffer");
        codec.releaseOutputBuffer(index, false);
        C8507E.m20416a();
        this.f18028ga.f16550f++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26185a(MediaCodec codec, int index, long presentationTimeUs) {
        C8507E.m20417a("dropVideoBuffer");
        codec.releaseOutputBuffer(index, false);
        C8507E.m20416a();
        mo25149a(1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo26186a(MediaCodec codec, int index, long presentationTimeUs, long positionUs) throws ExoPlaybackException {
        int droppedSourceBufferCount = mo25370b(positionUs);
        if (droppedSourceBufferCount == 0) {
            return false;
        }
        this.f18028ga.f16553i++;
        mo25149a(this.f18934Da + droppedSourceBufferCount);
        mo25513u();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25149a(int droppedBufferCount) {
        C8106d dVar = this.f18028ga;
        dVar.f16551g += droppedBufferCount;
        this.f18932Ba += droppedBufferCount;
        this.f18933Ca += droppedBufferCount;
        dVar.f16552h = Math.max(this.f18933Ca, dVar.f16552h);
        int i = this.f18957oa;
        if (i > 0 && this.f18932Ba >= i) {
            m20667Q();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo26188b(MediaCodec codec, int index, long presentationTimeUs) {
        m20668R();
        C8507E.m20417a("releaseOutputBuffer");
        codec.releaseOutputBuffer(index, true);
        C8507E.m20416a();
        this.f18935Ea = SystemClock.elapsedRealtime() * 1000;
        this.f18028ga.f16549e++;
        this.f18933Ca = 0;
        mo25140C();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    /* renamed from: b */
    public void mo26189b(MediaCodec codec, int index, long presentationTimeUs, long releaseTimeNs) {
        m20668R();
        C8507E.m20417a("releaseOutputBuffer");
        codec.releaseOutputBuffer(index, releaseTimeNs);
        C8507E.m20416a();
        this.f18935Ea = SystemClock.elapsedRealtime() * 1000;
        this.f18028ga.f16549e++;
        this.f18933Ca = 0;
        mo25140C();
    }

    /* renamed from: c */
    private boolean m20680c(C8338a codecInfo) {
        return C8509F.f18793a >= 23 && !this.f18946Pa && !mo26187a(codecInfo.f18061a) && (!codecInfo.f18066f || DummySurface.m20655a(this.f18953ka));
    }

    /* renamed from: U */
    private void m20671U() {
        this.f18968za = this.f18956na > 0 ? SystemClock.elapsedRealtime() + this.f18956na : -9223372036854775807L;
    }

    /* renamed from: N */
    private void m20664N() {
        this.f18966xa = false;
        if (C8509F.f18793a >= 23 && this.f18946Pa) {
            MediaCodec codec = mo25514v();
            if (codec != null) {
                this.f18948Ra = new C8561b(codec);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: C */
    public void mo25140C() {
        if (!this.f18966xa) {
            this.f18966xa = true;
            this.f18955ma.mo26224b(this.f18963ua);
        }
    }

    /* renamed from: S */
    private void m20669S() {
        if (this.f18966xa) {
            this.f18955ma.mo26224b(this.f18963ua);
        }
    }

    /* renamed from: O */
    private void m20665O() {
        this.f18942La = -1;
        this.f18943Ma = -1;
        this.f18945Oa = -1.0f;
        this.f18944Na = -1;
    }

    /* renamed from: R */
    private void m20668R() {
        if (this.f18938Ha != -1 || this.f18939Ia != -1) {
            if (this.f18942La != this.f18938Ha || this.f18943Ma != this.f18939Ia || this.f18944Na != this.f18940Ja || this.f18945Oa != this.f18941Ka) {
                this.f18955ma.mo26222b(this.f18938Ha, this.f18939Ia, this.f18940Ja, this.f18941Ka);
                this.f18942La = this.f18938Ha;
                this.f18943Ma = this.f18939Ia;
                this.f18944Na = this.f18940Ja;
                this.f18945Oa = this.f18941Ka;
            }
        }
    }

    /* renamed from: T */
    private void m20670T() {
        if (this.f18942La != -1 || this.f18943Ma != -1) {
            this.f18955ma.mo26222b(this.f18942La, this.f18943Ma, this.f18944Na, this.f18945Oa);
        }
    }

    /* renamed from: Q */
    private void m20667Q() {
        if (this.f18932Ba > 0) {
            long now = SystemClock.elapsedRealtime();
            this.f18955ma.mo26217a(this.f18932Ba, now - this.f18931Aa);
            this.f18932Ba = 0;
            this.f18931Aa = now;
        }
    }

    /* renamed from: f */
    private static boolean m20681f(long earlyUs) {
        return earlyUs < -30000;
    }

    /* renamed from: g */
    private static boolean m20683g(long earlyUs) {
        return earlyUs < -500000;
    }

    @TargetApi(23)
    /* renamed from: a */
    private static void m20676a(MediaCodec codec, Surface surface) {
        codec.setOutputSurface(surface);
    }

    @TargetApi(21)
    /* renamed from: a */
    private static void m20677a(MediaFormat mediaFormat, int tunnelingAudioSessionId) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", tunnelingAudioSessionId);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public MediaFormat mo26183a(Format format, C8560a codecMaxValues, float codecOperatingRate, boolean deviceNeedsNoPostProcessWorkaround, int tunnelingAudioSessionId) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", format.f16507g);
        mediaFormat.setInteger("width", format.f16512l);
        mediaFormat.setInteger("height", format.f16513m);
        C8343f.m19679a(mediaFormat, format.f16509i);
        C8343f.m19676a(mediaFormat, "frame-rate", format.f16514n);
        C8343f.m19677a(mediaFormat, "rotation-degrees", format.f16515o);
        C8343f.m19675a(mediaFormat, format.f16519s);
        mediaFormat.setInteger("max-width", codecMaxValues.f18969a);
        mediaFormat.setInteger("max-height", codecMaxValues.f18970b);
        C8343f.m19677a(mediaFormat, "max-input-size", codecMaxValues.f18971c);
        if (C8509F.f18793a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (codecOperatingRate != -1.0f) {
                mediaFormat.setFloat("operating-rate", codecOperatingRate);
            }
        }
        if (deviceNeedsNoPostProcessWorkaround) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (tunnelingAudioSessionId != 0) {
            m20677a(mediaFormat, tunnelingAudioSessionId);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C8560a mo26184a(C8338a codecInfo, Format format, Format[] streamFormats) throws DecoderQueryException {
        int maxWidth = format.f16512l;
        int maxHeight = format.f16513m;
        if (m20682f(codecInfo.f18061a)) {
            maxWidth = Math.max(maxWidth, 1920);
            maxHeight = Math.max(maxHeight, 1089);
        }
        int maxInputSize = m20679b(codecInfo, format);
        if (streamFormats.length == 1) {
            if (maxInputSize != -1) {
                int codecMaxInputSize = m20672a(codecInfo, format.f16507g, format.f16512l, format.f16513m);
                if (codecMaxInputSize != -1) {
                    maxInputSize = Math.min((int) (((float) maxInputSize) * 1.5f), codecMaxInputSize);
                }
            }
            return new C8560a(maxWidth, maxHeight, maxInputSize);
        }
        boolean haveUnknownDimensions = false;
        int maxInputSize2 = maxInputSize;
        int maxHeight2 = maxHeight;
        int maxWidth2 = maxWidth;
        for (Format streamFormat : streamFormats) {
            if (codecInfo.mo25533a(format, streamFormat, false)) {
                haveUnknownDimensions |= streamFormat.f16512l == -1 || streamFormat.f16513m == -1;
                maxWidth2 = Math.max(maxWidth2, streamFormat.f16512l);
                maxHeight2 = Math.max(maxHeight2, streamFormat.f16513m);
                maxInputSize2 = Math.max(maxInputSize2, m20679b(codecInfo, streamFormat));
            }
        }
        if (haveUnknownDimensions) {
            StringBuilder sb = new StringBuilder();
            sb.append("Resolutions unknown. Codec max resolution: ");
            sb.append(maxWidth2);
            String str = "x";
            sb.append(str);
            sb.append(maxHeight2);
            String str2 = "MediaCodecVideoRenderer";
            C8526n.m20534d(str2, sb.toString());
            Point codecMaxSize = m20673a(codecInfo, format);
            if (codecMaxSize != null) {
                maxWidth2 = Math.max(maxWidth2, codecMaxSize.x);
                maxHeight2 = Math.max(maxHeight2, codecMaxSize.y);
                maxInputSize2 = Math.max(maxInputSize2, m20672a(codecInfo, format.f16507g, maxWidth2, maxHeight2));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Codec max resolution adjusted to: ");
                sb2.append(maxWidth2);
                sb2.append(str);
                sb2.append(maxHeight2);
                C8526n.m20534d(str2, sb2.toString());
            }
        }
        return new C8560a(maxWidth2, maxHeight2, maxInputSize2);
    }

    /* renamed from: a */
    private static Point m20673a(C8338a codecInfo, Format format) throws DecoderQueryException {
        float aspectRatio;
        int formatShortEdgePx;
        C8338a aVar = codecInfo;
        Format format2 = format;
        int i = 0;
        boolean isVerticalVideo = format2.f16513m > format2.f16512l;
        int formatLongEdgePx = isVerticalVideo ? format2.f16513m : format2.f16512l;
        int formatShortEdgePx2 = isVerticalVideo ? format2.f16512l : format2.f16513m;
        float aspectRatio2 = ((float) formatShortEdgePx2) / ((float) formatLongEdgePx);
        int[] iArr = f18928ha;
        int length = iArr.length;
        while (i < length) {
            int longEdgePx = iArr[i];
            int shortEdgePx = (int) (((float) longEdgePx) * aspectRatio2);
            if (longEdgePx <= formatLongEdgePx) {
                float f = aspectRatio2;
            } else if (shortEdgePx <= formatShortEdgePx2) {
                int i2 = formatShortEdgePx2;
                float f2 = aspectRatio2;
            } else {
                if (C8509F.f18793a >= 21) {
                    Point alignedSize = aVar.mo25529a(isVerticalVideo ? shortEdgePx : longEdgePx, isVerticalVideo ? longEdgePx : shortEdgePx);
                    formatShortEdgePx = formatShortEdgePx2;
                    aspectRatio = aspectRatio2;
                    if (aVar.mo25531a(alignedSize.x, alignedSize.y, (double) format2.f16514n)) {
                        return alignedSize;
                    }
                } else {
                    formatShortEdgePx = formatShortEdgePx2;
                    aspectRatio = aspectRatio2;
                    int longEdgePx2 = C8509F.m20432a(longEdgePx, 16) * 16;
                    int shortEdgePx2 = C8509F.m20432a(shortEdgePx, 16) * 16;
                    if (longEdgePx2 * shortEdgePx2 <= MediaCodecUtil.m19626b()) {
                        return new Point(isVerticalVideo ? shortEdgePx2 : longEdgePx2, isVerticalVideo ? longEdgePx2 : shortEdgePx2);
                    }
                }
                i++;
                formatShortEdgePx2 = formatShortEdgePx;
                aspectRatio2 = aspectRatio;
            }
            return null;
        }
        float f3 = aspectRatio2;
        return null;
    }

    /* renamed from: b */
    private static int m20679b(C8338a codecInfo, Format format) {
        if (format.f16508h == -1) {
            return m20672a(codecInfo, format.f16507g, format.f16512l, format.f16513m);
        }
        int totalInitializationDataSize = 0;
        for (int i = 0; i < format.f16509i.size(); i++) {
            totalInitializationDataSize += ((byte[]) format.f16509i.get(i)).length;
        }
        return format.f16508h + totalInitializationDataSize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0090, code lost:
        if (r7.f18066f != false) goto L_0x00a5;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m20672a(com.google.android.exoplayer2.mediacodec.C8338a r7, java.lang.String r8, int r9, int r10) {
        /*
            r0 = -1
            if (r9 == r0) goto L_0x00b0
            if (r10 != r0) goto L_0x0007
            goto L_0x00b0
        L_0x0007:
            int r1 = r8.hashCode()
            r2 = 5
            r3 = 4
            r4 = 1
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0013
            r1 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0013
            r1 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0013
            r1 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0013
            r1 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0013
            r1 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0013
            r1 = 0
            goto L_0x0051
        L_0x0050:
            r1 = -1
        L_0x0051:
            if (r1 == 0) goto L_0x00a6
            if (r1 == r4) goto L_0x00a6
            if (r1 == r6) goto L_0x0066
            if (r1 == r5) goto L_0x0062
            if (r1 == r3) goto L_0x005e
            if (r1 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r0 = r9 * r10
            r1 = 4
            goto L_0x00aa
        L_0x0062:
            int r0 = r9 * r10
            r1 = 2
            goto L_0x00aa
        L_0x0066:
            java.lang.String r1 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r2 = "BRAVIA 4K 2015"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x00a5
            java.lang.String r1 = com.google.android.exoplayer2.util.C8509F.f18795c
            java.lang.String r2 = "Amazon"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r2 = "KFSOWI"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x00a5
            java.lang.String r1 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r2 = "AFTS"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0093
            boolean r1 = r7.f18066f
            if (r1 == 0) goto L_0x0093
            goto L_0x00a5
        L_0x0093:
            r0 = 16
            int r1 = com.google.android.exoplayer2.util.C8509F.m20432a(r9, r0)
            int r2 = com.google.android.exoplayer2.util.C8509F.m20432a(r10, r0)
            int r1 = r1 * r2
            int r1 = r1 * 16
            int r0 = r1 * 16
            r1 = 2
            goto L_0x00aa
        L_0x00a5:
            return r0
        L_0x00a6:
            int r0 = r9 * r10
            r1 = 2
        L_0x00aa:
            int r2 = r0 * 3
            int r3 = r1 * 2
            int r2 = r2 / r3
            return r2
        L_0x00b0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.C8559m.m20672a(com.google.android.exoplayer2.mediacodec.a, java.lang.String, int, int):int");
    }

    /* renamed from: P */
    private static boolean m20666P() {
        return "NVIDIA".equals(C8509F.f18795c);
    }

    /* renamed from: f */
    private static boolean m20682f(String name) {
        return "OMX.amlogic.avc.decoder.awesome".equals(name) && C8509F.f18793a <= 25;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x0630 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo26187a(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "OMX.google"
            boolean r0 = r8.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.Class<com.google.android.exoplayer2.video.m> r0 = com.google.android.exoplayer2.video.C8559m.class
            monitor-enter(r0)
            boolean r2 = f18929ia     // Catch:{ all -> 0x063c }
            if (r2 != 0) goto L_0x0638
            int r2 = com.google.android.exoplayer2.util.C8509F.f18793a     // Catch:{ all -> 0x063c }
            r3 = 27
            r4 = 1
            if (r2 > r3) goto L_0x0030
            java.lang.String r2 = "dangal"
            java.lang.String r5 = com.google.android.exoplayer2.util.C8509F.f18794b     // Catch:{ all -> 0x063c }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x063c }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "HWEML"
            java.lang.String r5 = com.google.android.exoplayer2.util.C8509F.f18794b     // Catch:{ all -> 0x063c }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0030
        L_0x002c:
            f18930ja = r4     // Catch:{ all -> 0x063c }
            goto L_0x0636
        L_0x0030:
            int r2 = com.google.android.exoplayer2.util.C8509F.f18793a     // Catch:{ all -> 0x063c }
            if (r2 < r3) goto L_0x0036
            goto L_0x0636
        L_0x0036:
            java.lang.String r2 = com.google.android.exoplayer2.util.C8509F.f18794b     // Catch:{ all -> 0x063c }
            int r5 = r2.hashCode()     // Catch:{ all -> 0x063c }
            r6 = -1
            switch(r5) {
                case -2144781245: goto L_0x05f6;
                case -2144781185: goto L_0x05eb;
                case -2144781160: goto L_0x05e0;
                case -2097309513: goto L_0x05d5;
                case -2022874474: goto L_0x05ca;
                case -1978993182: goto L_0x05bf;
                case -1978990237: goto L_0x05b4;
                case -1936688988: goto L_0x05a9;
                case -1936688066: goto L_0x059e;
                case -1936688065: goto L_0x0592;
                case -1931988508: goto L_0x0586;
                case -1696512866: goto L_0x057a;
                case -1680025915: goto L_0x056e;
                case -1615810839: goto L_0x0562;
                case -1554255044: goto L_0x0556;
                case -1481772737: goto L_0x054a;
                case -1481772730: goto L_0x053e;
                case -1481772729: goto L_0x0532;
                case -1320080169: goto L_0x0526;
                case -1217592143: goto L_0x051a;
                case -1180384755: goto L_0x050e;
                case -1139198265: goto L_0x0502;
                case -1052835013: goto L_0x04f6;
                case -993250464: goto L_0x04eb;
                case -965403638: goto L_0x04df;
                case -958336948: goto L_0x04d3;
                case -879245230: goto L_0x04c7;
                case -842500323: goto L_0x04bb;
                case -821392978: goto L_0x04b0;
                case -797483286: goto L_0x04a4;
                case -794946968: goto L_0x0498;
                case -788334647: goto L_0x048c;
                case -782144577: goto L_0x0480;
                case -575125681: goto L_0x0474;
                case -521118391: goto L_0x0468;
                case -430914369: goto L_0x045c;
                case -290434366: goto L_0x0450;
                case -282781963: goto L_0x0444;
                case -277133239: goto L_0x0438;
                case -173639913: goto L_0x042c;
                case -56598463: goto L_0x0420;
                case 2126: goto L_0x0414;
                case 2564: goto L_0x0408;
                case 2715: goto L_0x03fc;
                case 2719: goto L_0x03f0;
                case 3483: goto L_0x03e4;
                case 73405: goto L_0x03d8;
                case 75739: goto L_0x03cc;
                case 76779: goto L_0x03c0;
                case 78669: goto L_0x03b4;
                case 79305: goto L_0x03a8;
                case 80618: goto L_0x039c;
                case 88274: goto L_0x0390;
                case 98846: goto L_0x0384;
                case 98848: goto L_0x0378;
                case 99329: goto L_0x036c;
                case 101481: goto L_0x0360;
                case 1513190: goto L_0x0355;
                case 1514184: goto L_0x034a;
                case 1514185: goto L_0x033f;
                case 2436959: goto L_0x0333;
                case 2463773: goto L_0x0327;
                case 2464648: goto L_0x031b;
                case 2689555: goto L_0x030f;
                case 3154429: goto L_0x0303;
                case 3284551: goto L_0x02f7;
                case 3351335: goto L_0x02eb;
                case 3386211: goto L_0x02df;
                case 41325051: goto L_0x02d3;
                case 55178625: goto L_0x02c7;
                case 61542055: goto L_0x02bc;
                case 65355429: goto L_0x02b0;
                case 66214468: goto L_0x02a4;
                case 66214470: goto L_0x0298;
                case 66214473: goto L_0x028c;
                case 66215429: goto L_0x0280;
                case 66215431: goto L_0x0274;
                case 66215433: goto L_0x0268;
                case 66216390: goto L_0x025c;
                case 76402249: goto L_0x0250;
                case 76404105: goto L_0x0244;
                case 76404911: goto L_0x0238;
                case 80963634: goto L_0x022c;
                case 82882791: goto L_0x0220;
                case 98715550: goto L_0x0214;
                case 102844228: goto L_0x0208;
                case 165221241: goto L_0x01fd;
                case 182191441: goto L_0x01f1;
                case 245388979: goto L_0x01e5;
                case 287431619: goto L_0x01d9;
                case 307593612: goto L_0x01cd;
                case 308517133: goto L_0x01c1;
                case 316215098: goto L_0x01b5;
                case 316215116: goto L_0x01a9;
                case 316246811: goto L_0x019d;
                case 316246818: goto L_0x0191;
                case 407160593: goto L_0x0185;
                case 507412548: goto L_0x0179;
                case 793982701: goto L_0x016d;
                case 794038622: goto L_0x0161;
                case 794040393: goto L_0x0155;
                case 835649806: goto L_0x0149;
                case 917340916: goto L_0x013e;
                case 958008161: goto L_0x0132;
                case 1060579533: goto L_0x0126;
                case 1150207623: goto L_0x011a;
                case 1176899427: goto L_0x010e;
                case 1280332038: goto L_0x0102;
                case 1306947716: goto L_0x00f6;
                case 1349174697: goto L_0x00ea;
                case 1522194893: goto L_0x00de;
                case 1691543273: goto L_0x00d2;
                case 1709443163: goto L_0x00c6;
                case 1865889110: goto L_0x00ba;
                case 1906253259: goto L_0x00ae;
                case 1977196784: goto L_0x00a2;
                case 2006372676: goto L_0x0096;
                case 2029784656: goto L_0x008a;
                case 2030379515: goto L_0x007e;
                case 2033393791: goto L_0x0072;
                case 2047190025: goto L_0x0066;
                case 2047252157: goto L_0x005a;
                case 2048319463: goto L_0x004e;
                case 2048855701: goto L_0x0042;
                default: goto L_0x0040;
            }     // Catch:{ all -> 0x063c }
        L_0x0040:
            goto L_0x0601
        L_0x0042:
            java.lang.String r3 = "HWWAS-H"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 54
            goto L_0x0602
        L_0x004e:
            java.lang.String r3 = "HWVNS-H"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 53
            goto L_0x0602
        L_0x005a:
            java.lang.String r5 = "ELUGA_Prim"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 27
            goto L_0x0602
        L_0x0066:
            java.lang.String r3 = "ELUGA_Note"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 26
            goto L_0x0602
        L_0x0072:
            java.lang.String r3 = "ASUS_X00AD_2"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 11
            goto L_0x0602
        L_0x007e:
            java.lang.String r3 = "HWCAM-H"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 52
            goto L_0x0602
        L_0x008a:
            java.lang.String r3 = "HWBLN-H"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 51
            goto L_0x0602
        L_0x0096:
            java.lang.String r3 = "BRAVIA_ATV3_4K"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 15
            goto L_0x0602
        L_0x00a2:
            java.lang.String r3 = "Infinix-X572"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 57
            goto L_0x0602
        L_0x00ae:
            java.lang.String r3 = "PB2-670M"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 85
            goto L_0x0602
        L_0x00ba:
            java.lang.String r3 = "santoni"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 101(0x65, float:1.42E-43)
            goto L_0x0602
        L_0x00c6:
            java.lang.String r3 = "iball8735_9806"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 56
            goto L_0x0602
        L_0x00d2:
            java.lang.String r3 = "CPH1609"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 19
            goto L_0x0602
        L_0x00de:
            java.lang.String r3 = "woods_f"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 117(0x75, float:1.64E-43)
            goto L_0x0602
        L_0x00ea:
            java.lang.String r3 = "htc_e56ml_dtul"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 49
            goto L_0x0602
        L_0x00f6:
            java.lang.String r3 = "EverStar_S"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 29
            goto L_0x0602
        L_0x0102:
            java.lang.String r3 = "hwALE-H"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 50
            goto L_0x0602
        L_0x010e:
            java.lang.String r3 = "itel_S41"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 59
            goto L_0x0602
        L_0x011a:
            java.lang.String r3 = "LS-5017"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 65
            goto L_0x0602
        L_0x0126:
            java.lang.String r3 = "panell_d"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 81
            goto L_0x0602
        L_0x0132:
            java.lang.String r3 = "j2xlteins"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 60
            goto L_0x0602
        L_0x013e:
            java.lang.String r3 = "A7000plus"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 7
            goto L_0x0602
        L_0x0149:
            java.lang.String r3 = "manning"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 67
            goto L_0x0602
        L_0x0155:
            java.lang.String r3 = "GIONEE_WBL7519"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 47
            goto L_0x0602
        L_0x0161:
            java.lang.String r3 = "GIONEE_WBL7365"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 46
            goto L_0x0602
        L_0x016d:
            java.lang.String r3 = "GIONEE_WBL5708"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 45
            goto L_0x0602
        L_0x0179:
            java.lang.String r3 = "QM16XE_U"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 99
            goto L_0x0602
        L_0x0185:
            java.lang.String r3 = "Pixi5-10_4G"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 91
            goto L_0x0602
        L_0x0191:
            java.lang.String r3 = "TB3-850M"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 109(0x6d, float:1.53E-43)
            goto L_0x0602
        L_0x019d:
            java.lang.String r3 = "TB3-850F"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 108(0x6c, float:1.51E-43)
            goto L_0x0602
        L_0x01a9:
            java.lang.String r3 = "TB3-730X"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 107(0x6b, float:1.5E-43)
            goto L_0x0602
        L_0x01b5:
            java.lang.String r3 = "TB3-730F"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 106(0x6a, float:1.49E-43)
            goto L_0x0602
        L_0x01c1:
            java.lang.String r3 = "A7020a48"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 9
            goto L_0x0602
        L_0x01cd:
            java.lang.String r3 = "A7010a48"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 8
            goto L_0x0602
        L_0x01d9:
            java.lang.String r3 = "griffin"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 48
            goto L_0x0602
        L_0x01e5:
            java.lang.String r3 = "marino_f"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 68
            goto L_0x0602
        L_0x01f1:
            java.lang.String r3 = "CPY83_I00"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 20
            goto L_0x0602
        L_0x01fd:
            java.lang.String r3 = "A2016a40"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 5
            goto L_0x0602
        L_0x0208:
            java.lang.String r3 = "le_x6"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 64
            goto L_0x0602
        L_0x0214:
            java.lang.String r3 = "i9031"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 55
            goto L_0x0602
        L_0x0220:
            java.lang.String r3 = "X3_HK"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 119(0x77, float:1.67E-43)
            goto L_0x0602
        L_0x022c:
            java.lang.String r3 = "V23GB"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 112(0x70, float:1.57E-43)
            goto L_0x0602
        L_0x0238:
            java.lang.String r3 = "Q4310"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 97
            goto L_0x0602
        L_0x0244:
            java.lang.String r3 = "Q4260"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 95
            goto L_0x0602
        L_0x0250:
            java.lang.String r3 = "PRO7S"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 93
            goto L_0x0602
        L_0x025c:
            java.lang.String r3 = "F3311"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 36
            goto L_0x0602
        L_0x0268:
            java.lang.String r3 = "F3215"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 35
            goto L_0x0602
        L_0x0274:
            java.lang.String r3 = "F3213"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 34
            goto L_0x0602
        L_0x0280:
            java.lang.String r3 = "F3211"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 33
            goto L_0x0602
        L_0x028c:
            java.lang.String r3 = "F3116"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 32
            goto L_0x0602
        L_0x0298:
            java.lang.String r3 = "F3113"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 31
            goto L_0x0602
        L_0x02a4:
            java.lang.String r3 = "F3111"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 30
            goto L_0x0602
        L_0x02b0:
            java.lang.String r3 = "E5643"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 24
            goto L_0x0602
        L_0x02bc:
            java.lang.String r3 = "A1601"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 4
            goto L_0x0602
        L_0x02c7:
            java.lang.String r3 = "Aura_Note_2"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 12
            goto L_0x0602
        L_0x02d3:
            java.lang.String r3 = "MEIZU_M5"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 69
            goto L_0x0602
        L_0x02df:
            java.lang.String r3 = "p212"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 78
            goto L_0x0602
        L_0x02eb:
            java.lang.String r3 = "mido"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 71
            goto L_0x0602
        L_0x02f7:
            java.lang.String r3 = "kate"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 63
            goto L_0x0602
        L_0x0303:
            java.lang.String r3 = "fugu"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 38
            goto L_0x0602
        L_0x030f:
            java.lang.String r3 = "XE2X"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 120(0x78, float:1.68E-43)
            goto L_0x0602
        L_0x031b:
            java.lang.String r3 = "Q427"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 96
            goto L_0x0602
        L_0x0327:
            java.lang.String r3 = "Q350"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 94
            goto L_0x0602
        L_0x0333:
            java.lang.String r3 = "P681"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 79
            goto L_0x0602
        L_0x033f:
            java.lang.String r3 = "1714"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 2
            goto L_0x0602
        L_0x034a:
            java.lang.String r3 = "1713"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 1
            goto L_0x0602
        L_0x0355:
            java.lang.String r3 = "1601"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 0
            goto L_0x0602
        L_0x0360:
            java.lang.String r3 = "flo"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 37
            goto L_0x0602
        L_0x036c:
            java.lang.String r3 = "deb"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 23
            goto L_0x0602
        L_0x0378:
            java.lang.String r3 = "cv3"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 22
            goto L_0x0602
        L_0x0384:
            java.lang.String r3 = "cv1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 21
            goto L_0x0602
        L_0x0390:
            java.lang.String r3 = "Z80"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 123(0x7b, float:1.72E-43)
            goto L_0x0602
        L_0x039c:
            java.lang.String r3 = "QX1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 100
            goto L_0x0602
        L_0x03a8:
            java.lang.String r3 = "PLE"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 92
            goto L_0x0602
        L_0x03b4:
            java.lang.String r3 = "P85"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 80
            goto L_0x0602
        L_0x03c0:
            java.lang.String r3 = "MX6"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 72
            goto L_0x0602
        L_0x03cc:
            java.lang.String r3 = "M5c"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 66
            goto L_0x0602
        L_0x03d8:
            java.lang.String r3 = "JGZ"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 61
            goto L_0x0602
        L_0x03e4:
            java.lang.String r3 = "mh"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 70
            goto L_0x0602
        L_0x03f0:
            java.lang.String r3 = "V5"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 113(0x71, float:1.58E-43)
            goto L_0x0602
        L_0x03fc:
            java.lang.String r3 = "V1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 111(0x6f, float:1.56E-43)
            goto L_0x0602
        L_0x0408:
            java.lang.String r3 = "Q5"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 98
            goto L_0x0602
        L_0x0414:
            java.lang.String r3 = "C1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 16
            goto L_0x0602
        L_0x0420:
            java.lang.String r3 = "woods_fn"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 118(0x76, float:1.65E-43)
            goto L_0x0602
        L_0x042c:
            java.lang.String r3 = "ELUGA_A3_Pro"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 25
            goto L_0x0602
        L_0x0438:
            java.lang.String r3 = "Z12_PRO"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 122(0x7a, float:1.71E-43)
            goto L_0x0602
        L_0x0444:
            java.lang.String r3 = "BLACK-1X"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 13
            goto L_0x0602
        L_0x0450:
            java.lang.String r3 = "taido_row"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 105(0x69, float:1.47E-43)
            goto L_0x0602
        L_0x045c:
            java.lang.String r3 = "Pixi4-7_3G"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 90
            goto L_0x0602
        L_0x0468:
            java.lang.String r3 = "GIONEE_GBL7360"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 41
            goto L_0x0602
        L_0x0474:
            java.lang.String r3 = "GiONEE_CBL7513"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 39
            goto L_0x0602
        L_0x0480:
            java.lang.String r3 = "OnePlus5T"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 77
            goto L_0x0602
        L_0x048c:
            java.lang.String r3 = "whyred"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 116(0x74, float:1.63E-43)
            goto L_0x0602
        L_0x0498:
            java.lang.String r3 = "watson"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 115(0x73, float:1.61E-43)
            goto L_0x0602
        L_0x04a4:
            java.lang.String r3 = "SVP-DTV15"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 103(0x67, float:1.44E-43)
            goto L_0x0602
        L_0x04b0:
            java.lang.String r3 = "A7000-a"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 6
            goto L_0x0602
        L_0x04bb:
            java.lang.String r3 = "nicklaus_f"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 74
            goto L_0x0602
        L_0x04c7:
            java.lang.String r3 = "tcl_eu"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 110(0x6e, float:1.54E-43)
            goto L_0x0602
        L_0x04d3:
            java.lang.String r3 = "ELUGA_Ray_X"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 28
            goto L_0x0602
        L_0x04df:
            java.lang.String r3 = "s905x018"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 104(0x68, float:1.46E-43)
            goto L_0x0602
        L_0x04eb:
            java.lang.String r3 = "A10-70F"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 3
            goto L_0x0602
        L_0x04f6:
            java.lang.String r3 = "namath"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 73
            goto L_0x0602
        L_0x0502:
            java.lang.String r3 = "Slate_Pro"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 102(0x66, float:1.43E-43)
            goto L_0x0602
        L_0x050e:
            java.lang.String r3 = "iris60"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 58
            goto L_0x0602
        L_0x051a:
            java.lang.String r3 = "BRAVIA_ATV2"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 14
            goto L_0x0602
        L_0x0526:
            java.lang.String r3 = "GiONEE_GBL7319"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 40
            goto L_0x0602
        L_0x0532:
            java.lang.String r3 = "panell_dt"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 84
            goto L_0x0602
        L_0x053e:
            java.lang.String r3 = "panell_ds"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 83
            goto L_0x0602
        L_0x054a:
            java.lang.String r3 = "panell_dl"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 82
            goto L_0x0602
        L_0x0556:
            java.lang.String r3 = "vernee_M5"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 114(0x72, float:1.6E-43)
            goto L_0x0602
        L_0x0562:
            java.lang.String r3 = "Phantom6"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 89
            goto L_0x0602
        L_0x056e:
            java.lang.String r3 = "ComioS1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 17
            goto L_0x0602
        L_0x057a:
            java.lang.String r3 = "XT1663"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 121(0x79, float:1.7E-43)
            goto L_0x0602
        L_0x0586:
            java.lang.String r3 = "AquaPowerM"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 10
            goto L_0x0602
        L_0x0592:
            java.lang.String r3 = "PGN611"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 88
            goto L_0x0602
        L_0x059e:
            java.lang.String r3 = "PGN610"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 87
            goto L_0x0602
        L_0x05a9:
            java.lang.String r3 = "PGN528"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 86
            goto L_0x0602
        L_0x05b4:
            java.lang.String r3 = "NX573J"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 76
            goto L_0x0602
        L_0x05bf:
            java.lang.String r3 = "NX541J"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 75
            goto L_0x0602
        L_0x05ca:
            java.lang.String r3 = "CP8676_I02"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 18
            goto L_0x0602
        L_0x05d5:
            java.lang.String r3 = "K50a40"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 62
            goto L_0x0602
        L_0x05e0:
            java.lang.String r3 = "GIONEE_SWW1631"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 44
            goto L_0x0602
        L_0x05eb:
            java.lang.String r3 = "GIONEE_SWW1627"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 43
            goto L_0x0602
        L_0x05f6:
            java.lang.String r3 = "GIONEE_SWW1609"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0040
            r2 = 42
            goto L_0x0602
        L_0x0601:
            r2 = -1
        L_0x0602:
            switch(r2) {
                case 0: goto L_0x0606;
                case 1: goto L_0x0606;
                case 2: goto L_0x0606;
                case 3: goto L_0x0606;
                case 4: goto L_0x0606;
                case 5: goto L_0x0606;
                case 6: goto L_0x0606;
                case 7: goto L_0x0606;
                case 8: goto L_0x0606;
                case 9: goto L_0x0606;
                case 10: goto L_0x0606;
                case 11: goto L_0x0606;
                case 12: goto L_0x0606;
                case 13: goto L_0x0606;
                case 14: goto L_0x0606;
                case 15: goto L_0x0606;
                case 16: goto L_0x0606;
                case 17: goto L_0x0606;
                case 18: goto L_0x0606;
                case 19: goto L_0x0606;
                case 20: goto L_0x0606;
                case 21: goto L_0x0606;
                case 22: goto L_0x0606;
                case 23: goto L_0x0606;
                case 24: goto L_0x0606;
                case 25: goto L_0x0606;
                case 26: goto L_0x0606;
                case 27: goto L_0x0606;
                case 28: goto L_0x0606;
                case 29: goto L_0x0606;
                case 30: goto L_0x0606;
                case 31: goto L_0x0606;
                case 32: goto L_0x0606;
                case 33: goto L_0x0606;
                case 34: goto L_0x0606;
                case 35: goto L_0x0606;
                case 36: goto L_0x0606;
                case 37: goto L_0x0606;
                case 38: goto L_0x0606;
                case 39: goto L_0x0606;
                case 40: goto L_0x0606;
                case 41: goto L_0x0606;
                case 42: goto L_0x0606;
                case 43: goto L_0x0606;
                case 44: goto L_0x0606;
                case 45: goto L_0x0606;
                case 46: goto L_0x0606;
                case 47: goto L_0x0606;
                case 48: goto L_0x0606;
                case 49: goto L_0x0606;
                case 50: goto L_0x0606;
                case 51: goto L_0x0606;
                case 52: goto L_0x0606;
                case 53: goto L_0x0606;
                case 54: goto L_0x0606;
                case 55: goto L_0x0606;
                case 56: goto L_0x0606;
                case 57: goto L_0x0606;
                case 58: goto L_0x0606;
                case 59: goto L_0x0606;
                case 60: goto L_0x0606;
                case 61: goto L_0x0606;
                case 62: goto L_0x0606;
                case 63: goto L_0x0606;
                case 64: goto L_0x0606;
                case 65: goto L_0x0606;
                case 66: goto L_0x0606;
                case 67: goto L_0x0606;
                case 68: goto L_0x0606;
                case 69: goto L_0x0606;
                case 70: goto L_0x0606;
                case 71: goto L_0x0606;
                case 72: goto L_0x0606;
                case 73: goto L_0x0606;
                case 74: goto L_0x0606;
                case 75: goto L_0x0606;
                case 76: goto L_0x0606;
                case 77: goto L_0x0606;
                case 78: goto L_0x0606;
                case 79: goto L_0x0606;
                case 80: goto L_0x0606;
                case 81: goto L_0x0606;
                case 82: goto L_0x0606;
                case 83: goto L_0x0606;
                case 84: goto L_0x0606;
                case 85: goto L_0x0606;
                case 86: goto L_0x0606;
                case 87: goto L_0x0606;
                case 88: goto L_0x0606;
                case 89: goto L_0x0606;
                case 90: goto L_0x0606;
                case 91: goto L_0x0606;
                case 92: goto L_0x0606;
                case 93: goto L_0x0606;
                case 94: goto L_0x0606;
                case 95: goto L_0x0606;
                case 96: goto L_0x0606;
                case 97: goto L_0x0606;
                case 98: goto L_0x0606;
                case 99: goto L_0x0606;
                case 100: goto L_0x0606;
                case 101: goto L_0x0606;
                case 102: goto L_0x0606;
                case 103: goto L_0x0606;
                case 104: goto L_0x0606;
                case 105: goto L_0x0606;
                case 106: goto L_0x0606;
                case 107: goto L_0x0606;
                case 108: goto L_0x0606;
                case 109: goto L_0x0606;
                case 110: goto L_0x0606;
                case 111: goto L_0x0606;
                case 112: goto L_0x0606;
                case 113: goto L_0x0606;
                case 114: goto L_0x0606;
                case 115: goto L_0x0606;
                case 116: goto L_0x0606;
                case 117: goto L_0x0606;
                case 118: goto L_0x0606;
                case 119: goto L_0x0606;
                case 120: goto L_0x0606;
                case 121: goto L_0x0606;
                case 122: goto L_0x0606;
                case 123: goto L_0x0606;
                default: goto L_0x0605;
            }     // Catch:{ all -> 0x063c }
        L_0x0605:
            goto L_0x0609
        L_0x0606:
            f18930ja = r4     // Catch:{ all -> 0x063c }
        L_0x0609:
            java.lang.String r2 = com.google.android.exoplayer2.util.C8509F.f18796d     // Catch:{ all -> 0x063c }
            int r3 = r2.hashCode()     // Catch:{ all -> 0x063c }
            r5 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r3 == r5) goto L_0x0624
            r1 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r3 == r1) goto L_0x061a
        L_0x0619:
            goto L_0x062d
        L_0x061a:
            java.lang.String r1 = "AFTN"
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x063c }
            if (r1 == 0) goto L_0x0619
            r1 = 1
            goto L_0x062e
        L_0x0624:
            java.lang.String r3 = "AFTA"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x063c }
            if (r2 == 0) goto L_0x0619
            goto L_0x062e
        L_0x062d:
            r1 = -1
        L_0x062e:
            if (r1 == 0) goto L_0x0633
            if (r1 == r4) goto L_0x0633
            goto L_0x0636
        L_0x0633:
            f18930ja = r4     // Catch:{ all -> 0x063c }
        L_0x0636:
            f18929ia = r4     // Catch:{ all -> 0x063c }
        L_0x0638:
            monitor-exit(r0)     // Catch:{ all -> 0x063c }
            boolean r0 = f18930ja
            return r0
        L_0x063c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x063c }
            goto L_0x0640
        L_0x063f:
            throw r1
        L_0x0640:
            goto L_0x063f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.C8559m.mo26187a(java.lang.String):boolean");
    }
}
