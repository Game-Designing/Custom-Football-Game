package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.C8274c;
import com.google.android.exoplayer2.C8362o;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.C8278c;
import com.google.android.exoplayer2.drm.C8280e;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.p182a.C8106d;
import com.google.android.exoplayer2.p182a.C8107e;
import com.google.android.exoplayer2.util.C8505C;
import com.google.android.exoplayer2.util.C8507E;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8531r;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class MediaCodecRenderer extends C8274c {

    /* renamed from: j */
    private static final byte[] f17995j = C8509F.m20456a("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");

    /* renamed from: A */
    private float f17996A;

    /* renamed from: B */
    private float f17997B;

    /* renamed from: C */
    private boolean f17998C;

    /* renamed from: D */
    private ArrayDeque<C8338a> f17999D;

    /* renamed from: E */
    private DecoderInitializationException f18000E;

    /* renamed from: F */
    private C8338a f18001F;

    /* renamed from: G */
    private int f18002G;

    /* renamed from: H */
    private boolean f18003H;

    /* renamed from: I */
    private boolean f18004I;

    /* renamed from: J */
    private boolean f18005J;

    /* renamed from: K */
    private boolean f18006K;

    /* renamed from: L */
    private boolean f18007L;

    /* renamed from: M */
    private boolean f18008M;

    /* renamed from: N */
    private boolean f18009N;

    /* renamed from: O */
    private boolean f18010O;

    /* renamed from: P */
    private boolean f18011P;

    /* renamed from: Q */
    private ByteBuffer[] f18012Q;

    /* renamed from: R */
    private ByteBuffer[] f18013R;

    /* renamed from: S */
    private long f18014S;

    /* renamed from: T */
    private int f18015T;

    /* renamed from: U */
    private int f18016U;

    /* renamed from: V */
    private ByteBuffer f18017V;

    /* renamed from: W */
    private boolean f18018W;

    /* renamed from: X */
    private boolean f18019X;

    /* renamed from: Y */
    private int f18020Y;

    /* renamed from: Z */
    private int f18021Z;

    /* renamed from: aa */
    private boolean f18022aa;

    /* renamed from: ba */
    private boolean f18023ba;

    /* renamed from: ca */
    private boolean f18024ca;

    /* renamed from: da */
    private boolean f18025da;

    /* renamed from: ea */
    private boolean f18026ea;

    /* renamed from: fa */
    private boolean f18027fa;

    /* renamed from: ga */
    protected C8106d f18028ga;

    /* renamed from: k */
    private final C8341d f18029k;

    /* renamed from: l */
    private final C8278c<C8280e> f18030l;

    /* renamed from: m */
    private final boolean f18031m;

    /* renamed from: n */
    private final float f18032n;

    /* renamed from: o */
    private final C8107e f18033o;

    /* renamed from: p */
    private final C8107e f18034p;

    /* renamed from: q */
    private final C8362o f18035q;

    /* renamed from: r */
    private final C8505C<Format> f18036r;

    /* renamed from: s */
    private final List<Long> f18037s;

    /* renamed from: t */
    private final BufferInfo f18038t;

    /* renamed from: u */
    private Format f18039u;

    /* renamed from: v */
    private Format f18040v;

    /* renamed from: w */
    private Format f18041w;

    /* renamed from: x */
    private DrmSession<C8280e> f18042x;

    /* renamed from: y */
    private DrmSession<C8280e> f18043y;

    /* renamed from: z */
    private MediaCodec f18044z;

    public static class DecoderInitializationException extends Exception {

        /* renamed from: a */
        public final String f18045a;

        /* renamed from: b */
        public final boolean f18046b;

        /* renamed from: c */
        public final String f18047c;

        /* renamed from: d */
        public final String f18048d;

        /* renamed from: e */
        public final DecoderInitializationException f18049e;

        public DecoderInitializationException(Format format, Throwable cause, boolean secureDecoderRequired, int errorCode) {
            StringBuilder sb = new StringBuilder();
            sb.append("Decoder init failed: [");
            sb.append(errorCode);
            sb.append("], ");
            sb.append(format);
            this(sb.toString(), cause, format.f16507g, secureDecoderRequired, null, m19616a(errorCode), null);
        }

        public DecoderInitializationException(Format format, Throwable cause, boolean secureDecoderRequired, String decoderName) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Decoder init failed: ");
            sb.append(decoderName);
            sb.append(", ");
            sb.append(format);
            String sb2 = sb.toString();
            String str2 = format.f16507g;
            if (C8509F.f18793a >= 21) {
                str = m19617a(cause);
            } else {
                str = null;
            }
            this(sb2, cause, str2, secureDecoderRequired, decoderName, str, null);
        }

        private DecoderInitializationException(String message, Throwable cause, String mimeType, boolean secureDecoderRequired, String decoderName, String diagnosticInfo, DecoderInitializationException fallbackDecoderInitializationException) {
            super(message, cause);
            this.f18045a = mimeType;
            this.f18046b = secureDecoderRequired;
            this.f18047c = decoderName;
            this.f18048d = diagnosticInfo;
            this.f18049e = fallbackDecoderInitializationException;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public DecoderInitializationException m19614a(DecoderInitializationException fallbackException) {
            DecoderInitializationException decoderInitializationException = new DecoderInitializationException(getMessage(), getCause(), this.f18045a, this.f18046b, this.f18047c, this.f18048d, fallbackException);
            return decoderInitializationException;
        }

        @TargetApi(21)
        /* renamed from: a */
        private static String m19617a(Throwable cause) {
            if (cause instanceof CodecException) {
                return ((CodecException) cause).getDiagnosticInfo();
            }
            return null;
        }

        /* renamed from: a */
        private static String m19616a(int errorCode) {
            String sign = errorCode < 0 ? "neg_" : "";
            StringBuilder sb = new StringBuilder();
            sb.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
            sb.append(sign);
            sb.append(Math.abs(errorCode));
            return sb.toString();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract float mo25141a(float f, Format format, Format[] formatArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo25142a(MediaCodec mediaCodec, C8338a aVar, Format format, Format format2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo25144a(C8341d dVar, C8278c<C8280e> cVar, Format format) throws DecoderQueryException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo25153a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo25154a(C8107e eVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo25155a(C8338a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f) throws DecoderQueryException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo25156a(String str, long j, long j2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo25160a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z, Format format) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo25163c(long j);

    public MediaCodecRenderer(int trackType, C8341d mediaCodecSelector, C8278c<C8280e> drmSessionManager, boolean playClearSamplesWithoutKeys, float assumedMinimumCodecOperatingRate) {
        super(trackType);
        C8514e.m20490b(C8509F.f18793a >= 16);
        C8514e.m20486a(mediaCodecSelector);
        this.f18029k = mediaCodecSelector;
        this.f18030l = drmSessionManager;
        this.f18031m = playClearSamplesWithoutKeys;
        this.f18032n = assumedMinimumCodecOperatingRate;
        this.f18033o = new C8107e(0);
        this.f18034p = C8107e.m18277h();
        this.f18035q = new C8362o();
        this.f18036r = new C8505C<>();
        this.f18037s = new ArrayList();
        this.f18038t = new BufferInfo();
        this.f18020Y = 0;
        this.f18021Z = 0;
        this.f17997B = -1.0f;
        this.f17996A = 1.0f;
    }

    /* renamed from: m */
    public final int mo25512m() {
        return 8;
    }

    /* renamed from: a */
    public final int mo25507a(Format format) throws ExoPlaybackException {
        try {
            return mo25144a(this.f18029k, this.f18030l, format);
        } catch (DecoderQueryException e) {
            throw ExoPlaybackException.m18241a(e, mo25381o());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C8338a> mo25148a(C8341d mediaCodecSelector, Format format, boolean requiresSecureDecoder) throws DecoderQueryException {
        return mediaCodecSelector.mo25540a(format.f16507g, requiresSecureDecoder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public final void mo25518z() throws ExoPlaybackException {
        if (this.f18044z == null) {
            Format format = this.f18039u;
            if (format != null) {
                this.f18042x = this.f18043y;
                String mimeType = format.f16507g;
                MediaCrypto wrappedMediaCrypto = null;
                boolean drmSessionRequiresSecureDecoder = false;
                DrmSession<C8280e> drmSession = this.f18042x;
                if (drmSession != null) {
                    C8280e mediaCrypto = (C8280e) drmSession.mo25399a();
                    if (mediaCrypto != null) {
                        wrappedMediaCrypto = mediaCrypto.mo25409a();
                        drmSessionRequiresSecureDecoder = mediaCrypto.mo25410a(mimeType);
                    } else if (this.f18042x.getError() == null) {
                        return;
                    }
                    if (mo25140C()) {
                        int drmSessionState = this.f18042x.getState();
                        if (drmSessionState == 1) {
                            throw ExoPlaybackException.m18241a(this.f18042x.getError(), mo25381o());
                        } else if (drmSessionState != 4) {
                            return;
                        }
                    }
                }
                try {
                    if (m19570a(wrappedMediaCrypto, drmSessionRequiresSecureDecoder)) {
                        String codecName = this.f18001F.f18061a;
                        this.f18002G = mo26187a(codecName);
                        this.f18003H = m19582e(codecName);
                        this.f18004I = m19571a(codecName, this.f18039u);
                        this.f18005J = m19580d(codecName);
                        this.f18006K = m19576b(codecName);
                        this.f18007L = m19578c(codecName);
                        this.f18008M = m19577b(codecName, this.f18039u);
                        this.f18011P = m19575b(this.f18001F) || mo25516x();
                        this.f18014S = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                        m19562K();
                        m19563L();
                        this.f18027fa = true;
                        this.f18028ga.f16545a++;
                    }
                } catch (DecoderInitializationException e) {
                    throw ExoPlaybackException.m18241a(e, mo25381o());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25510a(C8338a codecInfo) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo25516x() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final Format mo25511d(long presentationTimeUs) {
        Format format = (Format) this.f18036r.mo26046a(presentationTimeUs);
        if (format != null) {
            this.f18041w = format;
        }
        return format;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public final MediaCodec mo25514v() {
        return this.f18044z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public final C8338a mo25515w() {
        return this.f18001F;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25157a(boolean joining) throws ExoPlaybackException {
        this.f18028ga = new C8106d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25152a(long positionUs, boolean joining) throws ExoPlaybackException {
        this.f18024ca = false;
        this.f18025da = false;
        if (this.f18044z != null) {
            mo25513u();
        }
        this.f18036r.mo26047a();
    }

    /* renamed from: a */
    public final void mo25508a(float operatingRate) throws ExoPlaybackException {
        this.f17996A = operatingRate;
        m19564M();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo25167r() {
        this.f18039u = null;
        this.f17999D = null;
        try {
            mo25506A();
            try {
                if (this.f18042x != null) {
                    this.f18030l.mo25407a(this.f18042x);
                }
                try {
                    if (!(this.f18043y == null || this.f18043y == this.f18042x)) {
                        this.f18030l.mo25407a(this.f18043y);
                    }
                } finally {
                    this.f18042x = null;
                    this.f18043y = null;
                }
            } catch (Throwable th) {
                if (!(this.f18043y == null || this.f18043y == this.f18042x)) {
                    this.f18030l.mo25407a(this.f18043y);
                }
                throw th;
            } finally {
                this.f18042x = null;
                this.f18043y = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.f18043y == null || this.f18043y == this.f18042x)) {
                    this.f18030l.mo25407a(this.f18043y);
                }
                throw th2;
            } finally {
                this.f18042x = null;
                this.f18043y = null;
            }
        } finally {
            this.f18042x = null;
            this.f18043y = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public void mo25506A() {
        this.f18014S = -9223372036854775807L;
        m19562K();
        m19563L();
        this.f18026ea = false;
        this.f18018W = false;
        this.f18037s.clear();
        m19561J();
        this.f18001F = null;
        this.f18019X = false;
        this.f18022aa = false;
        this.f18004I = false;
        this.f18005J = false;
        this.f18002G = 0;
        this.f18003H = false;
        this.f18006K = false;
        this.f18008M = false;
        this.f18009N = false;
        this.f18010O = false;
        this.f18011P = false;
        this.f18023ba = false;
        this.f18020Y = 0;
        this.f18021Z = 0;
        this.f17998C = false;
        MediaCodec mediaCodec = this.f18044z;
        if (mediaCodec != null) {
            this.f18028ga.f16546b++;
            try {
                mediaCodec.stop();
                try {
                    this.f18044z.release();
                    this.f18044z = null;
                    DrmSession<C8280e> drmSession = this.f18042x;
                    if (drmSession != null && this.f18043y != drmSession) {
                        try {
                            this.f18030l.mo25407a(drmSession);
                        } finally {
                            this.f18042x = null;
                        }
                    }
                } catch (Throwable th) {
                    this.f18044z = null;
                    DrmSession<C8280e> drmSession2 = this.f18042x;
                    if (!(drmSession2 == null || this.f18043y == drmSession2)) {
                        this.f18030l.mo25407a(drmSession2);
                    }
                    throw th;
                } finally {
                    this.f18042x = null;
                }
            } catch (Throwable th2) {
                this.f18044z = null;
                DrmSession<C8280e> drmSession3 = this.f18042x;
                if (!(drmSession3 == null || this.f18043y == drmSession3)) {
                    try {
                        this.f18030l.mo25407a(drmSession3);
                    } finally {
                        this.f18042x = null;
                    }
                }
                throw th2;
            } finally {
                this.f18042x = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void mo25168s() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void mo25169t() {
    }

    /* renamed from: a */
    public void mo25509a(long positionUs, long elapsedRealtimeUs) throws ExoPlaybackException {
        if (this.f18025da) {
            mo25139B();
            return;
        }
        if (this.f18039u == null) {
            this.f18034p.mo25020a();
            int result = mo25366a(this.f18035q, this.f18034p, true);
            if (result == -5) {
                mo25161b(this.f18035q.f18117a);
            } else if (result == -4) {
                C8514e.m20490b(this.f18034p.mo25025c());
                this.f18024ca = true;
                m19557F();
                return;
            } else {
                return;
            }
        }
        mo25518z();
        if (this.f18044z != null) {
            C8507E.m20417a("drainAndFeed");
            do {
            } while (mo26190b(positionUs, elapsedRealtimeUs));
            do {
            } while (m19555D());
            C8507E.m20416a();
        } else {
            this.f18028ga.f16548d += mo25370b(positionUs);
            this.f18034p.mo25020a();
            int result2 = mo25366a(this.f18035q, this.f18034p, false);
            if (result2 == -5) {
                mo25161b(this.f18035q.f18117a);
            } else if (result2 == -4) {
                C8514e.m20490b(this.f18034p.mo25025c());
                this.f18024ca = true;
                m19557F();
            }
        }
        this.f18028ga.mo25029a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void mo25513u() throws ExoPlaybackException {
        this.f18014S = -9223372036854775807L;
        m19562K();
        m19563L();
        this.f18027fa = true;
        this.f18026ea = false;
        this.f18018W = false;
        this.f18037s.clear();
        this.f18009N = false;
        this.f18010O = false;
        if (this.f18005J || (this.f18006K && this.f18023ba)) {
            mo25506A();
            mo25518z();
        } else if (this.f18021Z != 0) {
            mo25506A();
            mo25518z();
        } else {
            this.f18044z.flush();
            this.f18022aa = false;
        }
        if (this.f18019X && this.f18039u != null) {
            this.f18020Y = 1;
        }
    }

    /* renamed from: a */
    private boolean m19570a(MediaCrypto crypto, boolean drmSessionRequiresSecureDecoder) throws DecoderInitializationException {
        if (this.f17999D == null) {
            try {
                this.f17999D = new ArrayDeque<>(m19573b(drmSessionRequiresSecureDecoder));
                this.f18000E = null;
            } catch (DecoderQueryException e) {
                throw new DecoderInitializationException(this.f18039u, (Throwable) e, drmSessionRequiresSecureDecoder, -49998);
            }
        }
        if (!this.f17999D.isEmpty()) {
            do {
                C8338a codecInfo = (C8338a) this.f17999D.peekFirst();
                if (!mo25510a(codecInfo)) {
                    return false;
                }
                try {
                    m19569a(codecInfo, crypto);
                    return true;
                } catch (Exception e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to initialize decoder: ");
                    sb.append(codecInfo);
                    C8526n.m20532b("MediaCodecRenderer", sb.toString(), e2);
                    this.f17999D.removeFirst();
                    DecoderInitializationException exception = new DecoderInitializationException(this.f18039u, (Throwable) e2, drmSessionRequiresSecureDecoder, codecInfo.f18061a);
                    DecoderInitializationException decoderInitializationException = this.f18000E;
                    if (decoderInitializationException == null) {
                        this.f18000E = exception;
                    } else {
                        this.f18000E = decoderInitializationException.m19614a(exception);
                    }
                    if (this.f17999D.isEmpty()) {
                        throw this.f18000E;
                    }
                }
            } while (this.f17999D.isEmpty());
            throw this.f18000E;
        }
        throw new DecoderInitializationException(this.f18039u, (Throwable) null, drmSessionRequiresSecureDecoder, -49999);
    }

    /* renamed from: b */
    private List<C8338a> m19573b(boolean drmSessionRequiresSecureDecoder) throws DecoderQueryException {
        List<MediaCodecInfo> codecInfos = mo25148a(this.f18029k, this.f18039u, drmSessionRequiresSecureDecoder);
        if (codecInfos.isEmpty() && drmSessionRequiresSecureDecoder) {
            codecInfos = mo25148a(this.f18029k, this.f18039u, false);
            if (!codecInfos.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Drm session requires secure decoder for ");
                sb.append(this.f18039u.f16507g);
                sb.append(", but no secure decoder available. Trying to proceed with ");
                sb.append(codecInfos);
                sb.append(".");
                C8526n.m20534d("MediaCodecRenderer", sb.toString());
            }
        }
        return codecInfos;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19569a(com.google.android.exoplayer2.mediacodec.C8338a r19, android.media.MediaCrypto r20) throws java.lang.Exception {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r1 = 0
            java.lang.String r9 = r8.f18061a
            r18.m19564M()
            float r0 = r7.f17997B
            float r2 = r7.f18032n
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            r10 = r0
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x007d }
            r11 = r2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r0.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r2 = "createCodec:"
            r0.append(r2)     // Catch:{ Exception -> 0x007d }
            r0.append(r9)     // Catch:{ Exception -> 0x007d }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x007d }
            com.google.android.exoplayer2.util.C8507E.m20417a(r0)     // Catch:{ Exception -> 0x007d }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r9)     // Catch:{ Exception -> 0x007d }
            r13 = r0
            com.google.android.exoplayer2.util.C8507E.m20416a()     // Catch:{ Exception -> 0x007b }
            java.lang.String r0 = "configureCodec"
            com.google.android.exoplayer2.util.C8507E.m20417a(r0)     // Catch:{ Exception -> 0x007b }
            com.google.android.exoplayer2.Format r4 = r7.f18039u     // Catch:{ Exception -> 0x007b }
            if (r10 == 0) goto L_0x0044
            float r0 = r7.f17997B     // Catch:{ Exception -> 0x007b }
            r6 = r0
            goto L_0x0048
        L_0x0044:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0048:
            r1 = r18
            r2 = r19
            r3 = r13
            r5 = r20
            r1.mo25155a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x007b }
            r7.f17998C = r10     // Catch:{ Exception -> 0x007b }
            com.google.android.exoplayer2.util.C8507E.m20416a()     // Catch:{ Exception -> 0x007b }
            java.lang.String r0 = "startCodec"
            com.google.android.exoplayer2.util.C8507E.m20417a(r0)     // Catch:{ Exception -> 0x007b }
            r13.start()     // Catch:{ Exception -> 0x007b }
            com.google.android.exoplayer2.util.C8507E.m20416a()     // Catch:{ Exception -> 0x007b }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x007b }
            r14 = r0
            r7.m19568a(r13)     // Catch:{ Exception -> 0x007b }
            r7.f18044z = r13
            r7.f18001F = r8
            long r16 = r14 - r11
            r1 = r18
            r2 = r9
            r3 = r14
            r5 = r16
            r1.mo25156a(r2, r3, r5)
            return
        L_0x007b:
            r0 = move-exception
            goto L_0x007f
        L_0x007d:
            r0 = move-exception
            r13 = r1
        L_0x007f:
            if (r13 == 0) goto L_0x0087
            r18.m19561J()
            r13.release()
        L_0x0087:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.m19569a(com.google.android.exoplayer2.mediacodec.a, android.media.MediaCrypto):void");
    }

    /* renamed from: a */
    private void m19568a(MediaCodec codec) {
        if (C8509F.f18793a < 21) {
            this.f18012Q = codec.getInputBuffers();
            this.f18013R = codec.getOutputBuffers();
        }
    }

    /* renamed from: J */
    private void m19561J() {
        if (C8509F.f18793a < 21) {
            this.f18012Q = null;
            this.f18013R = null;
        }
    }

    /* renamed from: a */
    private ByteBuffer mo25149a(int inputIndex) {
        if (C8509F.f18793a >= 21) {
            return this.f18044z.getInputBuffer(inputIndex);
        }
        return this.f18012Q[inputIndex];
    }

    /* renamed from: b */
    private ByteBuffer m19572b(int outputIndex) {
        if (C8509F.f18793a >= 21) {
            return this.f18044z.getOutputBuffer(outputIndex);
        }
        return this.f18013R[outputIndex];
    }

    /* renamed from: E */
    private boolean m19556E() {
        return this.f18016U >= 0;
    }

    /* renamed from: K */
    private void m19562K() {
        this.f18015T = -1;
        this.f18033o.f16555c = null;
    }

    /* renamed from: L */
    private void m19563L() {
        this.f18016U = -1;
        this.f18017V = null;
    }

    /* renamed from: D */
    private boolean m19555D() throws ExoPlaybackException {
        int result;
        MediaCodec mediaCodec = this.f18044z;
        if (mediaCodec == null || this.f18021Z == 2 || this.f18024ca) {
            return false;
        }
        if (this.f18015T < 0) {
            this.f18015T = mediaCodec.dequeueInputBuffer(0);
            int i = this.f18015T;
            if (i < 0) {
                return false;
            }
            this.f18033o.f16555c = mo25149a(i);
            this.f18033o.mo25020a();
        }
        if (this.f18021Z == 1) {
            if (!this.f18011P) {
                this.f18023ba = true;
                this.f18044z.queueInputBuffer(this.f18015T, 0, 0, 0, 4);
                m19562K();
            }
            this.f18021Z = 2;
            return false;
        } else if (this.f18009N) {
            this.f18009N = false;
            this.f18033o.f16555c.put(f17995j);
            this.f18044z.queueInputBuffer(this.f18015T, 0, f17995j.length, 0, 0);
            m19562K();
            this.f18022aa = true;
            return true;
        } else {
            int adaptiveReconfigurationBytes = 0;
            if (this.f18026ea) {
                result = -4;
            } else {
                if (this.f18020Y == 1) {
                    for (int i2 = 0; i2 < this.f18039u.f16509i.size(); i2++) {
                        this.f18033o.f16555c.put((byte[]) this.f18039u.f16509i.get(i2));
                    }
                    this.f18020Y = 2;
                }
                adaptiveReconfigurationBytes = this.f18033o.f16555c.position();
                result = mo25366a(this.f18035q, this.f18033o, false);
            }
            if (result == -3) {
                return false;
            }
            if (result == -5) {
                if (this.f18020Y == 2) {
                    this.f18033o.mo25020a();
                    this.f18020Y = 1;
                }
                mo25161b(this.f18035q.f18117a);
                return true;
            } else if (this.f18033o.mo25025c()) {
                if (this.f18020Y == 2) {
                    this.f18033o.mo25020a();
                    this.f18020Y = 1;
                }
                this.f18024ca = true;
                if (!this.f18022aa) {
                    m19557F();
                    return false;
                }
                try {
                    if (!this.f18011P) {
                        this.f18023ba = true;
                        this.f18044z.queueInputBuffer(this.f18015T, 0, 0, 0, 4);
                        m19562K();
                    }
                    return false;
                } catch (CryptoException e) {
                    throw ExoPlaybackException.m18241a(e, mo25381o());
                }
            } else if (!this.f18027fa || this.f18033o.mo25026d()) {
                this.f18027fa = false;
                boolean bufferEncrypted = this.f18033o.mo25032f();
                this.f18026ea = m19579c(bufferEncrypted);
                if (this.f18026ea) {
                    return false;
                }
                if (this.f18004I && !bufferEncrypted) {
                    C8531r.m20557a(this.f18033o.f16555c);
                    if (this.f18033o.f16555c.position() == 0) {
                        return true;
                    }
                    this.f18004I = false;
                }
                try {
                    long presentationTimeUs = this.f18033o.f16556d;
                    if (this.f18033o.mo25022b()) {
                        this.f18037s.add(Long.valueOf(presentationTimeUs));
                    }
                    if (this.f18040v != null) {
                        this.f18036r.mo26048a(presentationTimeUs, this.f18040v);
                        this.f18040v = null;
                    }
                    this.f18033o.mo25031e();
                    mo25154a(this.f18033o);
                    if (bufferEncrypted) {
                        this.f18044z.queueSecureInputBuffer(this.f18015T, 0, m19566a(this.f18033o, adaptiveReconfigurationBytes), presentationTimeUs, 0);
                    } else {
                        this.f18044z.queueInputBuffer(this.f18015T, 0, this.f18033o.f16555c.limit(), presentationTimeUs, 0);
                    }
                    m19562K();
                    this.f18022aa = true;
                    this.f18020Y = 0;
                    this.f18028ga.f16547c++;
                    return true;
                } catch (CryptoException e2) {
                    throw ExoPlaybackException.m18241a(e2, mo25381o());
                }
            } else {
                this.f18033o.mo25020a();
                if (this.f18020Y == 2) {
                    this.f18020Y = 1;
                }
                return true;
            }
        }
    }

    /* renamed from: c */
    private boolean m19579c(boolean bufferEncrypted) throws ExoPlaybackException {
        boolean z = false;
        if (this.f18042x == null || (!bufferEncrypted && this.f18031m)) {
            return false;
        }
        int drmSessionState = this.f18042x.getState();
        if (drmSessionState != 1) {
            if (drmSessionState != 4) {
                z = true;
            }
            return z;
        }
        throw ExoPlaybackException.m18241a(this.f18042x.getError(), mo25381o());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0085, code lost:
        if (r4.f16513m == r0.f16513m) goto L_0x0089;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo25161b(com.google.android.exoplayer2.Format r8) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r7 = this;
            com.google.android.exoplayer2.Format r0 = r7.f18039u
            r7.f18039u = r8
            r7.f18040v = r8
            com.google.android.exoplayer2.Format r1 = r7.f18039u
            com.google.android.exoplayer2.drm.DrmInitData r1 = r1.f16510j
            r2 = 0
            if (r0 != 0) goto L_0x000f
            r3 = r2
            goto L_0x0011
        L_0x000f:
            com.google.android.exoplayer2.drm.DrmInitData r3 = r0.f16510j
        L_0x0011:
            boolean r1 = com.google.android.exoplayer2.util.C8509F.m20455a(r1, r3)
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x004f
            com.google.android.exoplayer2.Format r4 = r7.f18039u
            com.google.android.exoplayer2.drm.DrmInitData r4 = r4.f16510j
            if (r4 == 0) goto L_0x004d
            com.google.android.exoplayer2.drm.c<com.google.android.exoplayer2.drm.e> r2 = r7.f18030l
            if (r2 == 0) goto L_0x003d
            android.os.Looper r4 = android.os.Looper.myLooper()
            com.google.android.exoplayer2.Format r5 = r7.f18039u
            com.google.android.exoplayer2.drm.DrmInitData r5 = r5.f16510j
            com.google.android.exoplayer2.drm.DrmSession r2 = r2.mo25406a(r4, r5)
            r7.f18043y = r2
            com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.e> r2 = r7.f18043y
            com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.e> r4 = r7.f18042x
            if (r2 != r4) goto L_0x004f
            com.google.android.exoplayer2.drm.c<com.google.android.exoplayer2.drm.e> r4 = r7.f18030l
            r4.mo25407a(r2)
            goto L_0x004f
        L_0x003d:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Media requires a DrmSessionManager"
            r2.<init>(r3)
            int r3 = r7.mo25381o()
            com.google.android.exoplayer2.ExoPlaybackException r2 = com.google.android.exoplayer2.ExoPlaybackException.m18241a(r2, r3)
            throw r2
        L_0x004d:
            r7.f18043y = r2
        L_0x004f:
            r2 = 0
            com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.e> r4 = r7.f18043y
            com.google.android.exoplayer2.drm.DrmSession<com.google.android.exoplayer2.drm.e> r5 = r7.f18042x
            if (r4 != r5) goto L_0x0094
            android.media.MediaCodec r4 = r7.f18044z
            if (r4 == 0) goto L_0x0094
            com.google.android.exoplayer2.mediacodec.a r5 = r7.f18001F
            com.google.android.exoplayer2.Format r6 = r7.f18039u
            int r4 = r7.mo25142a(r4, r5, r0, r6)
            if (r4 == 0) goto L_0x0094
            if (r4 == r3) goto L_0x0092
            r5 = 3
            if (r4 != r5) goto L_0x008c
            boolean r4 = r7.f18003H
            if (r4 != 0) goto L_0x0094
            r2 = 1
            r7.f18019X = r3
            r7.f18020Y = r3
            int r4 = r7.f18002G
            r5 = 2
            if (r4 == r5) goto L_0x0089
            if (r4 != r3) goto L_0x0088
            com.google.android.exoplayer2.Format r4 = r7.f18039u
            int r5 = r4.f16512l
            int r6 = r0.f16512l
            if (r5 != r6) goto L_0x0088
            int r4 = r4.f16513m
            int r5 = r0.f16513m
            if (r4 != r5) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r3 = 0
        L_0x0089:
            r7.f18009N = r3
            goto L_0x0094
        L_0x008c:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L_0x0092:
            r2 = 1
        L_0x0094:
            if (r2 != 0) goto L_0x009a
            r7.m19560I()
            goto L_0x009d
        L_0x009a:
            r7.m19564M()
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.mo25161b(com.google.android.exoplayer2.Format):void");
    }

    /* renamed from: b */
    public boolean mo25162b() {
        return this.f18025da;
    }

    public boolean isReady() {
        return this.f18039u != null && !this.f18026ea && (mo25383q() || m19556E() || (this.f18014S != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f18014S));
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public long mo25517y() {
        return 0;
    }

    /* renamed from: M */
    private void m19564M() throws ExoPlaybackException {
        Format format = this.f18039u;
        if (format != null && C8509F.f18793a >= 23) {
            float codecOperatingRate = mo25141a(this.f17996A, format, mo25382p());
            if (this.f17997B != codecOperatingRate) {
                this.f17997B = codecOperatingRate;
                if (this.f18044z != null && this.f18021Z == 0) {
                    if (codecOperatingRate == -1.0f && this.f17998C) {
                        m19560I();
                    } else if (codecOperatingRate != -1.0f && (this.f17998C || codecOperatingRate > this.f18032n)) {
                        Bundle codecParameters = new Bundle();
                        codecParameters.putFloat("operating-rate", codecOperatingRate);
                        this.f18044z.setParameters(codecParameters);
                        this.f17998C = true;
                    }
                }
            }
        }
    }

    /* renamed from: I */
    private void m19560I() throws ExoPlaybackException {
        this.f17999D = null;
        if (this.f18022aa) {
            this.f18021Z = 1;
            return;
        }
        mo25506A();
        mo25518z();
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d8  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean mo26190b(long r18, long r20) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r17 = this;
            r14 = r17
            boolean r0 = r17.m19556E()
            r15 = 1
            r13 = 0
            if (r0 != 0) goto L_0x00a4
            boolean r0 = r14.f18007L
            if (r0 == 0) goto L_0x002b
            boolean r0 = r14.f18023ba
            if (r0 == 0) goto L_0x002b
            android.media.MediaCodec r0 = r14.f18044z     // Catch:{ IllegalStateException -> 0x001f }
            android.media.MediaCodec$BufferInfo r1 = r14.f18038t     // Catch:{ IllegalStateException -> 0x001f }
            long r2 = r17.mo25517y()     // Catch:{ IllegalStateException -> 0x001f }
            int r0 = r0.dequeueOutputBuffer(r1, r2)     // Catch:{ IllegalStateException -> 0x001f }
            goto L_0x0037
        L_0x001f:
            r0 = move-exception
            r17.m19557F()
            boolean r1 = r14.f18025da
            if (r1 == 0) goto L_0x002a
            r17.mo25506A()
        L_0x002a:
            return r13
        L_0x002b:
            android.media.MediaCodec r0 = r14.f18044z
            android.media.MediaCodec$BufferInfo r1 = r14.f18038t
            long r2 = r17.mo25517y()
            int r0 = r0.dequeueOutputBuffer(r1, r2)
        L_0x0037:
            if (r0 >= 0) goto L_0x0058
            r1 = -2
            if (r0 != r1) goto L_0x0040
            r17.m19559H()
            return r15
        L_0x0040:
            r1 = -3
            if (r0 != r1) goto L_0x0047
            r17.m19558G()
            return r15
        L_0x0047:
            boolean r1 = r14.f18011P
            if (r1 == 0) goto L_0x0057
            boolean r1 = r14.f18024ca
            if (r1 != 0) goto L_0x0054
            int r1 = r14.f18021Z
            r2 = 2
            if (r1 != r2) goto L_0x0057
        L_0x0054:
            r17.m19557F()
        L_0x0057:
            return r13
        L_0x0058:
            boolean r1 = r14.f18010O
            if (r1 == 0) goto L_0x0064
            r14.f18010O = r13
            android.media.MediaCodec r1 = r14.f18044z
            r1.releaseOutputBuffer(r0, r13)
            return r15
        L_0x0064:
            android.media.MediaCodec$BufferInfo r1 = r14.f18038t
            int r2 = r1.size
            if (r2 != 0) goto L_0x0074
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0074
            r17.m19557F()
            return r13
        L_0x0074:
            r14.f18016U = r0
            java.nio.ByteBuffer r1 = r14.m19572b(r0)
            r14.f18017V = r1
            java.nio.ByteBuffer r1 = r14.f18017V
            if (r1 == 0) goto L_0x0093
            android.media.MediaCodec$BufferInfo r2 = r14.f18038t
            int r2 = r2.offset
            r1.position(r2)
            java.nio.ByteBuffer r1 = r14.f18017V
            android.media.MediaCodec$BufferInfo r2 = r14.f18038t
            int r3 = r2.offset
            int r2 = r2.size
            int r3 = r3 + r2
            r1.limit(r3)
        L_0x0093:
            android.media.MediaCodec$BufferInfo r1 = r14.f18038t
            long r1 = r1.presentationTimeUs
            boolean r1 = r14.mo26194e(r1)
            r14.f18018W = r1
            android.media.MediaCodec$BufferInfo r1 = r14.f18038t
            long r1 = r1.presentationTimeUs
            r14.mo25511d(r1)
        L_0x00a4:
            boolean r0 = r14.f18007L
            if (r0 == 0) goto L_0x00dc
            boolean r0 = r14.f18023ba
            if (r0 == 0) goto L_0x00dc
            android.media.MediaCodec r6 = r14.f18044z     // Catch:{ IllegalStateException -> 0x00ce }
            java.nio.ByteBuffer r7 = r14.f18017V     // Catch:{ IllegalStateException -> 0x00ce }
            int r8 = r14.f18016U     // Catch:{ IllegalStateException -> 0x00ce }
            android.media.MediaCodec$BufferInfo r0 = r14.f18038t     // Catch:{ IllegalStateException -> 0x00ce }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x00ce }
            android.media.MediaCodec$BufferInfo r0 = r14.f18038t     // Catch:{ IllegalStateException -> 0x00ce }
            long r10 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x00ce }
            boolean r12 = r14.f18018W     // Catch:{ IllegalStateException -> 0x00ce }
            com.google.android.exoplayer2.Format r0 = r14.f18041w     // Catch:{ IllegalStateException -> 0x00ce }
            r1 = r17
            r2 = r18
            r4 = r20
            r16 = 0
            r13 = r0
            boolean r0 = r1.mo25160a(r2, r4, r6, r7, r8, r9, r10, r12, r13)     // Catch:{ IllegalStateException -> 0x00cc }
            goto L_0x00f8
        L_0x00cc:
            r0 = move-exception
            goto L_0x00d1
        L_0x00ce:
            r0 = move-exception
            r16 = 0
        L_0x00d1:
            r17.m19557F()
            boolean r1 = r14.f18025da
            if (r1 == 0) goto L_0x00db
            r17.mo25506A()
        L_0x00db:
            return r16
        L_0x00dc:
            r16 = 0
            android.media.MediaCodec r6 = r14.f18044z
            java.nio.ByteBuffer r7 = r14.f18017V
            int r8 = r14.f18016U
            android.media.MediaCodec$BufferInfo r0 = r14.f18038t
            int r9 = r0.flags
            long r10 = r0.presentationTimeUs
            boolean r12 = r14.f18018W
            com.google.android.exoplayer2.Format r13 = r14.f18041w
            r1 = r17
            r2 = r18
            r4 = r20
            boolean r0 = r1.mo25160a(r2, r4, r6, r7, r8, r9, r10, r12, r13)
        L_0x00f8:
            if (r0 == 0) goto L_0x0115
            android.media.MediaCodec$BufferInfo r1 = r14.f18038t
            long r1 = r1.presentationTimeUs
            r14.mo25163c(r1)
            android.media.MediaCodec$BufferInfo r1 = r14.f18038t
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x010b
            r1 = 1
            goto L_0x010c
        L_0x010b:
            r1 = 0
        L_0x010c:
            r17.m19563L()
            if (r1 != 0) goto L_0x0112
            return r15
        L_0x0112:
            r17.m19557F()
        L_0x0115:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.mo26190b(long, long):boolean");
    }

    /* renamed from: H */
    private void m19559H() throws ExoPlaybackException {
        MediaFormat format = this.f18044z.getOutputFormat();
        if (this.f18002G != 0 && format.getInteger("width") == 32 && format.getInteger("height") == 32) {
            this.f18010O = true;
            return;
        }
        if (this.f18008M) {
            format.setInteger("channel-count", 1);
        }
        mo25153a(this.f18044z, format);
    }

    /* renamed from: G */
    private void m19558G() {
        if (C8509F.f18793a < 21) {
            this.f18013R = this.f18044z.getOutputBuffers();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public void mo25139B() throws ExoPlaybackException {
    }

    /* renamed from: F */
    private void m19557F() throws ExoPlaybackException {
        if (this.f18021Z == 2) {
            mo25506A();
            mo25518z();
            return;
        }
        this.f18025da = true;
        mo25139B();
    }

    /* renamed from: e */
    private boolean mo26194e(long presentationTimeUs) {
        int size = this.f18037s.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.f18037s.get(i)).longValue() == presentationTimeUs) {
                this.f18037s.remove(i);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static CryptoInfo m19566a(C8107e buffer, int adaptiveReconfigurationBytes) {
        CryptoInfo cryptoInfo = buffer.f16554b.mo25027a();
        if (adaptiveReconfigurationBytes == 0) {
            return cryptoInfo;
        }
        if (cryptoInfo.numBytesOfClearData == null) {
            cryptoInfo.numBytesOfClearData = new int[1];
        }
        int[] iArr = cryptoInfo.numBytesOfClearData;
        iArr[0] = iArr[0] + adaptiveReconfigurationBytes;
        return cryptoInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        if ("AFTB".equals(com.google.android.exoplayer2.util.C8509F.f18796d) != false) goto L_0x001e;
     */
    /* renamed from: C */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean mo25140C() {
        /*
            r2 = this;
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18795c
            java.lang.String r1 = "Amazon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r1 = "AFTM"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r1 = "AFTB"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.mo25140C():boolean");
    }

    /* renamed from: d */
    private static boolean m19580d(String name) {
        int i = C8509F.f18793a;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(name) || "OMX.SEC.avc.dec.secure".equals(name))) || (C8509F.f18793a == 19 && C8509F.f18796d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(name) || "OMX.Exynos.avc.dec.secure".equals(name)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        if ("tilapia".equals(com.google.android.exoplayer2.util.C8509F.f18794b) != false) goto L_0x0076;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int mo26187a(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r1 = 25
            if (r0 > r1) goto L_0x0038
            java.lang.String r0 = "OMX.Exynos.avc.dec.secure"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r1 = "SM-T585"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L_0x0036
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r1 = "SM-A510"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L_0x0036
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r1 = "SM-A520"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L_0x0036
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r1 = "SM-J700"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0038
        L_0x0036:
            r0 = 2
            return r0
        L_0x0038:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r1 = 24
            if (r0 >= r1) goto L_0x0078
            java.lang.String r0 = "OMX.Nvidia.h264.decode"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x004e
            java.lang.String r0 = "OMX.Nvidia.h264.decode.secure"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0078
        L_0x004e:
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r1 = "flounder"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r1 = "flounder_lte"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r1 = "grouper"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r1 = "tilapia"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0078
        L_0x0076:
            r0 = 1
            return r0
        L_0x0078:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.mo26187a(java.lang.String):int");
    }

    /* renamed from: e */
    private static boolean m19582e(String name) {
        return C8509F.f18796d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(name);
    }

    /* renamed from: a */
    private static boolean m19571a(String name, Format format) {
        return C8509F.f18793a < 21 && format.f16509i.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(name);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r3.f18066f != false) goto L_0x0030;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m19575b(com.google.android.exoplayer2.mediacodec.C8338a r3) {
        /*
            java.lang.String r0 = r3.f18061a
            int r1 = com.google.android.exoplayer2.util.C8509F.f18793a
            r2 = 17
            if (r1 > r2) goto L_0x0018
            java.lang.String r1 = "OMX.rk.video_decoder.avc"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0030
            java.lang.String r1 = "OMX.allwinner.video.decoder.avc"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0030
        L_0x0018:
            java.lang.String r1 = com.google.android.exoplayer2.util.C8509F.f18795c
            java.lang.String r2 = "Amazon"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = com.google.android.exoplayer2.util.C8509F.f18796d
            java.lang.String r2 = "AFTS"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0032
            boolean r1 = r3.f18066f
            if (r1 == 0) goto L_0x0032
        L_0x0030:
            r1 = 1
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.m19575b(com.google.android.exoplayer2.mediacodec.a):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r2) == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if ("stvm8".equals(com.google.android.exoplayer2.util.C8509F.f18794b) != false) goto L_0x0028;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m19576b(java.lang.String r2) {
        /*
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r1 = 23
            if (r0 > r1) goto L_0x000e
            java.lang.String r0 = "OMX.google.vorbis.decoder"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0038
        L_0x000e:
            int r0 = com.google.android.exoplayer2.util.C8509F.f18793a
            r1 = 19
            if (r0 > r1) goto L_0x003a
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r1 = "hb2000"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0028
            java.lang.String r0 = com.google.android.exoplayer2.util.C8509F.f18794b
            java.lang.String r1 = "stvm8"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003a
        L_0x0028:
            java.lang.String r0 = "OMX.amlogic.avc.decoder.awesome"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0038
            java.lang.String r0 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x003a
        L_0x0038:
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.m19576b(java.lang.String):boolean");
    }

    /* renamed from: c */
    private static boolean m19578c(String name) {
        return C8509F.f18793a == 21 && "OMX.google.aac.decoder".equals(name);
    }

    /* renamed from: b */
    private static boolean m19577b(String name, Format format) {
        if (C8509F.f18793a > 18 || format.f16520t != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(name)) {
            return false;
        }
        return true;
    }
}
