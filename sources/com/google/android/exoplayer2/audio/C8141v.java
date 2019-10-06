package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.C8274c;
import com.google.android.exoplayer2.C8438u;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioSink.C8109a;
import com.google.android.exoplayer2.audio.AudioSink.ConfigurationException;
import com.google.android.exoplayer2.audio.AudioSink.InitializationException;
import com.google.android.exoplayer2.audio.AudioSink.WriteException;
import com.google.android.exoplayer2.audio.C8128l.C8129a;
import com.google.android.exoplayer2.drm.C8278c;
import com.google.android.exoplayer2.drm.C8280e;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.mediacodec.C8338a;
import com.google.android.exoplayer2.mediacodec.C8341d;
import com.google.android.exoplayer2.mediacodec.C8343f;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.p182a.C8107e;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8528p;
import com.google.android.exoplayer2.util.C8529q;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.audio.v */
/* compiled from: MediaCodecAudioRenderer */
public class C8141v extends MediaCodecRenderer implements C8528p {

    /* renamed from: ha */
    private final Context f16741ha;
    /* access modifiers changed from: private */

    /* renamed from: ia */
    public final C8129a f16742ia;

    /* renamed from: ja */
    private final AudioSink f16743ja;

    /* renamed from: ka */
    private final long[] f16744ka;

    /* renamed from: la */
    private int f16745la;

    /* renamed from: ma */
    private boolean f16746ma;

    /* renamed from: na */
    private boolean f16747na;

    /* renamed from: oa */
    private boolean f16748oa;

    /* renamed from: pa */
    private MediaFormat f16749pa;

    /* renamed from: qa */
    private int f16750qa;

    /* renamed from: ra */
    private int f16751ra;

    /* renamed from: sa */
    private int f16752sa;

    /* renamed from: ta */
    private int f16753ta;

    /* renamed from: ua */
    private long f16754ua;

    /* renamed from: va */
    private boolean f16755va;
    /* access modifiers changed from: private */

    /* renamed from: wa */
    public boolean f16756wa;

    /* renamed from: xa */
    private long f16757xa;

    /* renamed from: ya */
    private int f16758ya;

    /* renamed from: com.google.android.exoplayer2.audio.v$a */
    /* compiled from: MediaCodecAudioRenderer */
    private final class C8142a implements C8109a {
        private C8142a() {
        }

        /* renamed from: a */
        public void mo25069a(int audioSessionId) {
            C8141v.this.f16742ia.mo25100a(audioSessionId);
            C8141v.this.mo25149a(audioSessionId);
        }

        /* renamed from: a */
        public void mo25068a() {
            C8141v.this.mo25140C();
            C8141v.this.f16756wa = true;
        }

        /* renamed from: a */
        public void mo25070a(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
            C8141v.this.f16742ia.mo25101a(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
            C8141v.this.mo25150a(bufferSize, bufferSizeMs, elapsedSinceLastFeedMs);
        }
    }

    public C8141v(Context context, C8341d mediaCodecSelector) {
        this(context, mediaCodecSelector, null, false);
    }

    public C8141v(Context context, C8341d mediaCodecSelector, C8278c<C8280e> drmSessionManager, boolean playClearSamplesWithoutKeys) {
        this(context, mediaCodecSelector, drmSessionManager, playClearSamplesWithoutKeys, null, null);
    }

    public C8141v(Context context, C8341d mediaCodecSelector, C8278c<C8280e> drmSessionManager, boolean playClearSamplesWithoutKeys, Handler eventHandler, C8128l eventListener) {
        this(context, mediaCodecSelector, drmSessionManager, playClearSamplesWithoutKeys, eventHandler, eventListener, null, new AudioProcessor[0]);
    }

    public C8141v(Context context, C8341d mediaCodecSelector, C8278c<C8280e> drmSessionManager, boolean playClearSamplesWithoutKeys, Handler eventHandler, C8128l eventListener, C8127k audioCapabilities, AudioProcessor... audioProcessors) {
        this(context, mediaCodecSelector, drmSessionManager, playClearSamplesWithoutKeys, eventHandler, eventListener, new DefaultAudioSink(audioCapabilities, audioProcessors));
    }

    public C8141v(Context context, C8341d mediaCodecSelector, C8278c<C8280e> drmSessionManager, boolean playClearSamplesWithoutKeys, Handler eventHandler, C8128l eventListener, AudioSink audioSink) {
        super(1, mediaCodecSelector, drmSessionManager, playClearSamplesWithoutKeys, 44100.0f);
        this.f16741ha = context.getApplicationContext();
        this.f16743ja = audioSink;
        this.f16757xa = -9223372036854775807L;
        this.f16744ka = new long[10];
        this.f16742ia = new C8129a(eventHandler, eventListener);
        audioSink.mo25054a((C8109a) new C8142a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo25144a(C8341d mediaCodecSelector, C8278c<C8280e> drmSessionManager, Format format) throws DecoderQueryException {
        String mimeType = format.f16507g;
        if (!C8529q.m20547f(mimeType)) {
            return 0;
        }
        int tunnelingSupport = C8509F.f18793a >= 21 ? 32 : 0;
        boolean supportsFormatDrm = C8274c.m19204a(drmSessionManager, format.f16510j);
        int formatSupport = 4;
        if (supportsFormatDrm && mo25159a(format.f16520t, mimeType) && mediaCodecSelector.mo25539a() != null) {
            return tunnelingSupport | 8 | 4;
        }
        int i = 1;
        if (("audio/raw".equals(mimeType) && !this.f16743ja.mo25057a(format.f16520t, format.f16522v)) || !this.f16743ja.mo25057a(format.f16520t, 2)) {
            return 1;
        }
        boolean requiresSecureDecryption = false;
        DrmInitData drmInitData = format.f16510j;
        if (drmInitData != null) {
            for (int i2 = 0; i2 < drmInitData.f17539d; i2++) {
                requiresSecureDecryption |= drmInitData.mo25388a(i2).f17545f;
            }
        }
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.mo25540a(format.f16507g, requiresSecureDecryption);
        if (decoderInfos.isEmpty()) {
            if (requiresSecureDecryption && !mediaCodecSelector.mo25540a(format.f16507g, false).isEmpty()) {
                i = 2;
            }
            return i;
        } else if (!supportsFormatDrm) {
            return 2;
        } else {
            C8338a decoderInfo = (C8338a) decoderInfos.get(0);
            boolean isFormatSupported = decoderInfo.mo25532a(format);
            int adaptiveSupport = (!isFormatSupported || !decoderInfo.mo25537b(format)) ? 8 : 16;
            if (!isFormatSupported) {
                formatSupport = 3;
            }
            return adaptiveSupport | tunnelingSupport | formatSupport;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<C8338a> mo25148a(C8341d mediaCodecSelector, Format format, boolean requiresSecureDecoder) throws DecoderQueryException {
        if (mo25159a(format.f16520t, format.f16507g)) {
            C8338a passthroughDecoderInfo = mediaCodecSelector.mo25539a();
            if (passthroughDecoderInfo != null) {
                return Collections.singletonList(passthroughDecoderInfo);
            }
        }
        return super.mo25148a(mediaCodecSelector, format, requiresSecureDecoder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25159a(int channelCount, String mimeType) {
        return this.f16743ja.mo25057a(channelCount, C8529q.m20543b(mimeType));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25155a(C8338a codecInfo, MediaCodec codec, Format format, MediaCrypto crypto, float codecOperatingRate) {
        this.f16745la = mo25143a(codecInfo, format, mo25382p());
        this.f16747na = m18489f(codecInfo.f18061a);
        this.f16748oa = m18490g(codecInfo.f18061a);
        this.f16746ma = codecInfo.f18067g;
        String codecMimeType = codecInfo.f18062b;
        if (codecMimeType == null) {
            codecMimeType = "audio/raw";
        }
        MediaFormat mediaFormat = mo25146a(format, codecMimeType, this.f16745la, codecOperatingRate);
        codec.configure(mediaFormat, null, crypto, 0);
        if (this.f16746ma) {
            this.f16749pa = mediaFormat;
            this.f16749pa.setString("mime", format.f16507g);
            return;
        }
        this.f16749pa = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo25142a(MediaCodec codec, C8338a codecInfo, Format oldFormat, Format newFormat) {
        if (m18486a(codecInfo, newFormat) <= this.f16745la && codecInfo.mo25533a(oldFormat, newFormat, true) && oldFormat.f16523w == 0 && oldFormat.f16524x == 0 && newFormat.f16523w == 0 && newFormat.f16524x == 0) {
            return 1;
        }
        return 0;
    }

    /* renamed from: l */
    public C8528p mo25166l() {
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo25141a(float operatingRate, Format format, Format[] streamFormats) {
        int maxSampleRate = -1;
        for (Format streamFormat : streamFormats) {
            int streamSampleRate = streamFormat.f16521u;
            if (streamSampleRate != -1) {
                maxSampleRate = Math.max(maxSampleRate, streamSampleRate);
            }
        }
        if (maxSampleRate == -1) {
            return -1.0f;
        }
        return ((float) maxSampleRate) * operatingRate;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25156a(String name, long initializedTimestampMs, long initializationDurationMs) {
        this.f16742ia.mo25104a(name, initializedTimestampMs, initializationDurationMs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25161b(Format newFormat) throws ExoPlaybackException {
        super.mo25161b(newFormat);
        this.f16742ia.mo25102a(newFormat);
        this.f16750qa = "audio/raw".equals(newFormat.f16507g) ? newFormat.f16522v : 2;
        this.f16751ra = newFormat.f16520t;
        this.f16752sa = newFormat.f16523w;
        this.f16753ta = newFormat.f16524x;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25153a(MediaCodec codec, MediaFormat outputFormat) throws ExoPlaybackException {
        MediaFormat format;
        int encoding;
        int[] channelMap;
        MediaFormat mediaFormat = this.f16749pa;
        if (mediaFormat != null) {
            encoding = C8529q.m20543b(mediaFormat.getString("mime"));
            format = this.f16749pa;
        } else {
            encoding = this.f16750qa;
            format = outputFormat;
        }
        int channelCount = format.getInteger("channel-count");
        int sampleRate = format.getInteger("sample-rate");
        if (this.f16747na && channelCount == 6) {
            int i = this.f16751ra;
            if (i < 6) {
                int[] channelMap2 = new int[i];
                for (int i2 = 0; i2 < this.f16751ra; i2++) {
                    channelMap2[i2] = i2;
                }
                channelMap = channelMap2;
                this.f16743ja.mo25053a(encoding, channelCount, sampleRate, 0, channelMap, this.f16752sa, this.f16753ta);
            }
        }
        channelMap = null;
        try {
            this.f16743ja.mo25053a(encoding, channelCount, sampleRate, 0, channelMap, this.f16752sa, this.f16753ta);
        } catch (ConfigurationException e) {
            throw ExoPlaybackException.m18241a(e, mo25381o());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25149a(int audioSessionId) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public void mo25140C() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25150a(int bufferSize, long bufferSizeMs, long elapsedSinceLastFeedMs) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25157a(boolean joining) throws ExoPlaybackException {
        super.mo25157a(joining);
        this.f16742ia.mo25108b(this.f18028ga);
        int tunnelingAudioSessionId = mo25380n().f16471b;
        if (tunnelingAudioSessionId != 0) {
            this.f16743ja.mo25052a(tunnelingAudioSessionId);
        } else {
            this.f16743ja.mo25062g();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25158a(Format[] formats, long offsetUs) throws ExoPlaybackException {
        super.mo25158a(formats, offsetUs);
        if (this.f16757xa != -9223372036854775807L) {
            int i = this.f16758ya;
            if (i == this.f16744ka.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many stream changes, so dropping change at ");
                sb.append(this.f16744ka[this.f16758ya - 1]);
                C8526n.m20534d("MediaCodecAudioRenderer", sb.toString());
            } else {
                this.f16758ya = i + 1;
            }
            this.f16744ka[this.f16758ya - 1] = this.f16757xa;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25152a(long positionUs, boolean joining) throws ExoPlaybackException {
        super.mo25152a(positionUs, joining);
        this.f16743ja.reset();
        this.f16754ua = positionUs;
        this.f16755va = true;
        this.f16756wa = true;
        this.f16757xa = -9223372036854775807L;
        this.f16758ya = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void mo25168s() {
        super.mo25168s();
        this.f16743ja.play();
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void mo25169t() {
        m18485N();
        this.f16743ja.pause();
        super.mo25169t();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo25167r() {
        try {
            this.f16757xa = -9223372036854775807L;
            this.f16758ya = 0;
            this.f16743ja.mo25050a();
            try {
                super.mo25167r();
            } finally {
                this.f18028ga.mo25029a();
                this.f16742ia.mo25103a(this.f18028ga);
            }
        } catch (Throwable th) {
            super.mo25167r();
            throw th;
        } finally {
            this.f18028ga.mo25029a();
            this.f16742ia.mo25103a(this.f18028ga);
        }
    }

    /* renamed from: b */
    public boolean mo25162b() {
        return super.mo25162b() && this.f16743ja.mo25059b();
    }

    public boolean isReady() {
        return this.f16743ja.mo25061f() || super.isReady();
    }

    /* renamed from: a */
    public long mo25145a() {
        if (getState() == 2) {
            m18485N();
        }
        return this.f16754ua;
    }

    /* renamed from: a */
    public C8438u mo25147a(C8438u playbackParameters) {
        return this.f16743ja.mo25049a(playbackParameters);
    }

    /* renamed from: e */
    public C8438u mo25164e() {
        return this.f16743ja.mo25060e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25154a(C8107e buffer) {
        if (this.f16755va && !buffer.mo25022b()) {
            if (Math.abs(buffer.f16556d - this.f16754ua) > 500000) {
                this.f16754ua = buffer.f16556d;
            }
            this.f16755va = false;
        }
        this.f16757xa = Math.max(buffer.f16556d, this.f16757xa);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo25163c(long presentationTimeUs) {
        while (this.f16758ya != 0 && presentationTimeUs >= this.f16744ka[0]) {
            this.f16743ja.mo25064i();
            this.f16758ya--;
            long[] jArr = this.f16744ka;
            System.arraycopy(jArr, 1, jArr, 0, this.f16758ya);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25160a(long positionUs, long elapsedRealtimeUs, MediaCodec codec, ByteBuffer buffer, int bufferIndex, int bufferFlags, long bufferPresentationTimeUs, boolean shouldSkip, Format format) throws ExoPlaybackException {
        long bufferPresentationTimeUs2;
        MediaCodec mediaCodec = codec;
        int i = bufferIndex;
        if (!this.f16748oa || bufferPresentationTimeUs != 0 || (bufferFlags & 4) == 0 || this.f16757xa == -9223372036854775807L) {
            bufferPresentationTimeUs2 = bufferPresentationTimeUs;
        } else {
            bufferPresentationTimeUs2 = this.f16757xa;
        }
        if (this.f16746ma && (bufferFlags & 2) != 0) {
            codec.releaseOutputBuffer(i, false);
            return true;
        } else if (shouldSkip) {
            codec.releaseOutputBuffer(i, false);
            this.f18028ga.f16550f++;
            this.f16743ja.mo25064i();
            return true;
        } else {
            try {
                ByteBuffer byteBuffer = buffer;
                try {
                    if (!this.f16743ja.mo25058a(buffer, bufferPresentationTimeUs2)) {
                        return false;
                    }
                    codec.releaseOutputBuffer(i, false);
                    this.f18028ga.f16549e++;
                    return true;
                } catch (InitializationException | WriteException e) {
                    e = e;
                    throw ExoPlaybackException.m18241a(e, mo25381o());
                }
            } catch (InitializationException | WriteException e2) {
                e = e2;
                ByteBuffer byteBuffer2 = buffer;
                throw ExoPlaybackException.m18241a(e, mo25381o());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public void mo25139B() throws ExoPlaybackException {
        try {
            this.f16743ja.mo25063h();
        } catch (WriteException e) {
            throw ExoPlaybackException.m18241a(e, mo25381o());
        }
    }

    /* renamed from: a */
    public void mo25151a(int messageType, Object message) throws ExoPlaybackException {
        if (messageType == 2) {
            this.f16743ja.mo25051a(((Float) message).floatValue());
        } else if (messageType == 3) {
            this.f16743ja.mo25055a((C8125j) message);
        } else if (messageType != 5) {
            super.mo25151a(messageType, message);
        } else {
            this.f16743ja.mo25056a((C8134o) message);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo25143a(C8338a codecInfo, Format format, Format[] streamFormats) {
        int maxInputSize = m18486a(codecInfo, format);
        if (streamFormats.length == 1) {
            return maxInputSize;
        }
        int maxInputSize2 = maxInputSize;
        for (Format streamFormat : streamFormats) {
            if (codecInfo.mo25533a(format, streamFormat, false)) {
                maxInputSize2 = Math.max(maxInputSize2, m18486a(codecInfo, streamFormat));
            }
        }
        return maxInputSize2;
    }

    /* renamed from: a */
    private int m18486a(C8338a codecInfo, Format format) {
        if (C8509F.f18793a < 24) {
            if ("OMX.google.raw.decoder".equals(codecInfo.f18061a)) {
                boolean needsRawDecoderWorkaround = true;
                if (C8509F.f18793a == 23) {
                    PackageManager packageManager = this.f16741ha.getPackageManager();
                    if (packageManager != null && packageManager.hasSystemFeature("android.software.leanback")) {
                        needsRawDecoderWorkaround = false;
                    }
                }
                if (needsRawDecoderWorkaround) {
                    return -1;
                }
            }
        }
        return format.f16508h;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public MediaFormat mo25146a(Format format, String codecMimeType, int codecMaxInputSize, float codecOperatingRate) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", codecMimeType);
        mediaFormat.setInteger("channel-count", format.f16520t);
        mediaFormat.setInteger("sample-rate", format.f16521u);
        C8343f.m19679a(mediaFormat, format.f16509i);
        C8343f.m19677a(mediaFormat, "max-input-size", codecMaxInputSize);
        if (C8509F.f18793a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (codecOperatingRate != -1.0f) {
                mediaFormat.setFloat("operating-rate", codecOperatingRate);
            }
        }
        return mediaFormat;
    }

    /* renamed from: N */
    private void m18485N() {
        long j;
        long newCurrentPositionUs = this.f16743ja.mo25048a(mo25162b());
        if (newCurrentPositionUs != Long.MIN_VALUE) {
            if (this.f16756wa) {
                j = newCurrentPositionUs;
            } else {
                j = Math.max(this.f16754ua, newCurrentPositionUs);
            }
            this.f16754ua = j;
            this.f16756wa = false;
        }
    }

    /* renamed from: f */
    private static boolean m18489f(String codecName) {
        if (C8509F.f18793a < 24 && "OMX.SEC.aac.dec".equals(codecName)) {
            if ("samsung".equals(C8509F.f18795c) && (C8509F.f18794b.startsWith("zeroflte") || C8509F.f18794b.startsWith("herolte") || C8509F.f18794b.startsWith("heroqlte"))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private static boolean m18490g(String codecName) {
        if (C8509F.f18793a < 21 && "OMX.SEC.mp3.dec".equals(codecName)) {
            if ("samsung".equals(C8509F.f18795c) && (C8509F.f18794b.startsWith("baffin") || C8509F.f18794b.startsWith("grand") || C8509F.f18794b.startsWith("fortuna") || C8509F.f18794b.startsWith("gprimelte") || C8509F.f18794b.startsWith("j2y18lte") || C8509F.f18794b.startsWith("ms01"))) {
                return true;
            }
        }
        return false;
    }
}
