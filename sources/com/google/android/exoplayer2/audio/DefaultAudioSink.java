package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.C8438u;
import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import com.google.android.exoplayer2.audio.AudioSink.C8109a;
import com.google.android.exoplayer2.audio.AudioSink.ConfigurationException;
import com.google.android.exoplayer2.audio.AudioSink.InitializationException;
import com.google.android.exoplayer2.audio.AudioSink.WriteException;
import com.google.android.exoplayer2.audio.C8132n.C8133a;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class DefaultAudioSink implements AudioSink {

    /* renamed from: a */
    public static boolean f16579a = false;

    /* renamed from: b */
    public static boolean f16580b = false;

    /* renamed from: A */
    private C8438u f16581A;

    /* renamed from: B */
    private long f16582B;

    /* renamed from: C */
    private long f16583C;

    /* renamed from: D */
    private ByteBuffer f16584D;

    /* renamed from: E */
    private int f16585E;

    /* renamed from: F */
    private int f16586F;

    /* renamed from: G */
    private long f16587G;

    /* renamed from: H */
    private long f16588H;

    /* renamed from: I */
    private int f16589I;

    /* renamed from: J */
    private long f16590J;

    /* renamed from: K */
    private long f16591K;

    /* renamed from: L */
    private int f16592L;

    /* renamed from: M */
    private int f16593M;

    /* renamed from: N */
    private long f16594N;

    /* renamed from: O */
    private float f16595O;

    /* renamed from: P */
    private AudioProcessor[] f16596P;

    /* renamed from: Q */
    private ByteBuffer[] f16597Q;

    /* renamed from: R */
    private ByteBuffer f16598R;

    /* renamed from: S */
    private ByteBuffer f16599S;

    /* renamed from: T */
    private byte[] f16600T;

    /* renamed from: U */
    private int f16601U;

    /* renamed from: V */
    private int f16602V;

    /* renamed from: W */
    private boolean f16603W;

    /* renamed from: X */
    private boolean f16604X;

    /* renamed from: Y */
    private int f16605Y;

    /* renamed from: Z */
    private C8134o f16606Z;

    /* renamed from: aa */
    private boolean f16607aa;
    /* access modifiers changed from: private */

    /* renamed from: ba */
    public long f16608ba;

    /* renamed from: c */
    private final C8127k f16609c;

    /* renamed from: d */
    private final C8111a f16610d;

    /* renamed from: e */
    private final boolean f16611e;

    /* renamed from: f */
    private final C8135p f16612f;

    /* renamed from: g */
    private final C8108A f16613g;

    /* renamed from: h */
    private final AudioProcessor[] f16614h;

    /* renamed from: i */
    private final AudioProcessor[] f16615i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final ConditionVariable f16616j;

    /* renamed from: k */
    private final C8132n f16617k;

    /* renamed from: l */
    private final ArrayDeque<C8113c> f16618l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C8109a f16619m;

    /* renamed from: n */
    private AudioTrack f16620n;

    /* renamed from: o */
    private AudioTrack f16621o;

    /* renamed from: p */
    private boolean f16622p;

    /* renamed from: q */
    private boolean f16623q;

    /* renamed from: r */
    private int f16624r;

    /* renamed from: s */
    private int f16625s;

    /* renamed from: t */
    private int f16626t;

    /* renamed from: u */
    private int f16627u;

    /* renamed from: v */
    private C8125j f16628v;

    /* renamed from: w */
    private boolean f16629w;

    /* renamed from: x */
    private boolean f16630x;

    /* renamed from: y */
    private int f16631y;

    /* renamed from: z */
    private C8438u f16632z;

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        /* synthetic */ InvalidAudioTrackTimestampException(String x0, C8136q x1) {
            this(x0);
        }

        private InvalidAudioTrackTimestampException(String message) {
            super(message);
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$a */
    public interface C8111a {
        /* renamed from: a */
        long mo25071a(long j);

        /* renamed from: a */
        C8438u mo25072a(C8438u uVar);

        /* renamed from: a */
        AudioProcessor[] mo25073a();

        /* renamed from: b */
        long mo25074b();
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$b */
    public static class C8112b implements C8111a {

        /* renamed from: a */
        private final AudioProcessor[] f16633a;

        /* renamed from: b */
        private final C8144x f16634b = new C8144x();

        /* renamed from: c */
        private final C8146z f16635c = new C8146z();

        public C8112b(AudioProcessor... audioProcessors) {
            this.f16633a = (AudioProcessor[]) Arrays.copyOf(audioProcessors, audioProcessors.length + 2);
            AudioProcessor[] audioProcessorArr = this.f16633a;
            audioProcessorArr[audioProcessors.length] = this.f16634b;
            audioProcessorArr[audioProcessors.length + 1] = this.f16635c;
        }

        /* renamed from: a */
        public AudioProcessor[] mo25073a() {
            return this.f16633a;
        }

        /* renamed from: a */
        public C8438u mo25072a(C8438u playbackParameters) {
            this.f16634b.mo25170a(playbackParameters.f18485d);
            return new C8438u(this.f16635c.mo25179b(playbackParameters.f18483b), this.f16635c.mo25177a(playbackParameters.f18484c), playbackParameters.f18485d);
        }

        /* renamed from: a */
        public long mo25071a(long playoutDuration) {
            return this.f16635c.mo25178a(playoutDuration);
        }

        /* renamed from: b */
        public long mo25074b() {
            return this.f16634b.mo25171h();
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$c */
    private static final class C8113c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C8438u f16636a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long f16637b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final long f16638c;

        /* synthetic */ C8113c(C8438u x0, long x1, long x2, C8136q x3) {
            this(x0, x1, x2);
        }

        private C8113c(C8438u playbackParameters, long mediaTimeUs, long positionUs) {
            this.f16636a = playbackParameters;
            this.f16637b = mediaTimeUs;
            this.f16638c = positionUs;
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$d */
    private final class C8114d implements C8133a {
        private C8114d() {
        }

        /* synthetic */ C8114d(DefaultAudioSink x0, C8136q x1) {
            this();
        }

        /* renamed from: a */
        public void mo25077a(long audioTimestampPositionFrames, long audioTimestampSystemTimeUs, long systemTimeUs, long playbackPositionUs) {
            StringBuilder sb = new StringBuilder();
            sb.append("Spurious audio timestamp (frame position mismatch): ");
            sb.append(audioTimestampPositionFrames);
            String str = ", ";
            sb.append(str);
            sb.append(audioTimestampSystemTimeUs);
            sb.append(str);
            sb.append(systemTimeUs);
            sb.append(str);
            sb.append(playbackPositionUs);
            sb.append(str);
            sb.append(DefaultAudioSink.this.m18350m());
            sb.append(str);
            sb.append(DefaultAudioSink.this.m18351n());
            String message = sb.toString();
            if (!DefaultAudioSink.f16580b) {
                C8526n.m20534d("AudioTrack", message);
                return;
            }
            throw new InvalidAudioTrackTimestampException(message, null);
        }

        /* renamed from: b */
        public void mo25078b(long audioTimestampPositionFrames, long audioTimestampSystemTimeUs, long systemTimeUs, long playbackPositionUs) {
            StringBuilder sb = new StringBuilder();
            sb.append("Spurious audio timestamp (system clock mismatch): ");
            sb.append(audioTimestampPositionFrames);
            String str = ", ";
            sb.append(str);
            sb.append(audioTimestampSystemTimeUs);
            sb.append(str);
            sb.append(systemTimeUs);
            sb.append(str);
            sb.append(playbackPositionUs);
            sb.append(str);
            sb.append(DefaultAudioSink.this.m18350m());
            sb.append(str);
            sb.append(DefaultAudioSink.this.m18351n());
            String message = sb.toString();
            if (!DefaultAudioSink.f16580b) {
                C8526n.m20534d("AudioTrack", message);
                return;
            }
            throw new InvalidAudioTrackTimestampException(message, null);
        }

        /* renamed from: a */
        public void mo25076a(long latencyUs) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring impossibly large audio latency: ");
            sb.append(latencyUs);
            C8526n.m20534d("AudioTrack", sb.toString());
        }

        /* renamed from: a */
        public void mo25075a(int bufferSize, long bufferSizeMs) {
            if (DefaultAudioSink.this.f16619m != null) {
                DefaultAudioSink.this.f16619m.mo25070a(bufferSize, bufferSizeMs, SystemClock.elapsedRealtime() - DefaultAudioSink.this.f16608ba);
            }
        }
    }

    public DefaultAudioSink(C8127k audioCapabilities, AudioProcessor[] audioProcessors) {
        this(audioCapabilities, audioProcessors, false);
    }

    public DefaultAudioSink(C8127k audioCapabilities, AudioProcessor[] audioProcessors, boolean enableConvertHighResIntPcmToFloat) {
        this(audioCapabilities, (C8111a) new C8112b(audioProcessors), enableConvertHighResIntPcmToFloat);
    }

    public DefaultAudioSink(C8127k audioCapabilities, C8111a audioProcessorChain, boolean enableConvertHighResIntPcmToFloat) {
        this.f16609c = audioCapabilities;
        C8514e.m20486a(audioProcessorChain);
        this.f16610d = audioProcessorChain;
        this.f16611e = enableConvertHighResIntPcmToFloat;
        this.f16616j = new ConditionVariable(true);
        this.f16617k = new C8132n(new C8114d(this, null));
        this.f16612f = new C8135p();
        this.f16613g = new C8108A();
        ArrayList<AudioProcessor> toIntPcmAudioProcessors = new ArrayList<>();
        Collections.addAll(toIntPcmAudioProcessors, new AudioProcessor[]{new C8143w(), this.f16612f, this.f16613g});
        Collections.addAll(toIntPcmAudioProcessors, audioProcessorChain.mo25073a());
        this.f16614h = (AudioProcessor[]) toIntPcmAudioProcessors.toArray(new AudioProcessor[toIntPcmAudioProcessors.size()]);
        this.f16615i = new AudioProcessor[]{new C8139t()};
        this.f16595O = 1.0f;
        this.f16593M = 0;
        this.f16628v = C8125j.f16668a;
        this.f16605Y = 0;
        this.f16606Z = new C8134o(0, 0.0f);
        this.f16581A = C8438u.f18482a;
        this.f16602V = -1;
        this.f16596P = new AudioProcessor[0];
        this.f16597Q = new ByteBuffer[0];
        this.f16618l = new ArrayDeque<>();
    }

    /* renamed from: a */
    public void mo25054a(C8109a listener) {
        this.f16619m = listener;
    }

    /* renamed from: a */
    public boolean mo25057a(int channelCount, int encoding) {
        boolean z = true;
        if (C8509F.m20478f(encoding)) {
            if (encoding == 4 && C8509F.f18793a < 21) {
                z = false;
            }
            return z;
        }
        C8127k kVar = this.f16609c;
        if (kVar == null || !kVar.mo25090a(encoding) || (channelCount != -1 && channelCount > this.f16609c.mo25089a())) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public long mo25048a(boolean sourceEnded) {
        if (!m18354q() || this.f16593M == 0) {
            return Long.MIN_VALUE;
        }
        return this.f16594N + m18329a(m18333b(Math.min(this.f16617k.mo25124a(sourceEnded), m18341d(m18351n()))));
    }

    /* renamed from: a */
    public void mo25053a(int inputEncoding, int inputChannelCount, int inputSampleRate, int specifiedBufferSize, int[] outputChannels, int trimStartFrames, int trimEndFrames) throws ConfigurationException {
        int[] outputChannels2;
        int encoding;
        int i = inputEncoding;
        boolean flush = false;
        this.f16624r = inputSampleRate;
        int channelCount = inputChannelCount;
        int channelCount2 = inputSampleRate;
        this.f16622p = C8509F.m20478f(inputEncoding);
        int i2 = 0;
        boolean z = true;
        this.f16623q = this.f16611e && mo25057a(channelCount, 4) && C8509F.m20477e(inputEncoding);
        if (this.f16622p) {
            this.f16586F = C8509F.m20462b(i, channelCount);
        }
        int encoding2 = inputEncoding;
        boolean processingEnabled = this.f16622p && i != 4;
        if (!processingEnabled || this.f16623q) {
            z = false;
        }
        this.f16630x = z;
        if (C8509F.f18793a < 21 && channelCount == 8 && outputChannels == null) {
            outputChannels2 = new int[6];
            for (int i3 = 0; i3 < outputChannels2.length; i3++) {
                outputChannels2[i3] = i3;
            }
        } else {
            outputChannels2 = outputChannels;
        }
        if (processingEnabled) {
            this.f16613g.mo25034a(trimStartFrames, trimEndFrames);
            this.f16612f.mo25136a(outputChannels2);
            AudioProcessor[] k = m18348k();
            int length = k.length;
            encoding = encoding2;
            int sampleRate = channelCount2;
            int channelCount3 = channelCount;
            boolean flush2 = false;
            while (i2 < length) {
                AudioProcessor audioProcessor = k[i2];
                try {
                    flush2 |= audioProcessor.mo25037a(sampleRate, channelCount3, encoding);
                    if (audioProcessor.mo25036a()) {
                        channelCount3 = audioProcessor.mo25040d();
                        sampleRate = audioProcessor.mo25041e();
                        encoding = audioProcessor.mo25042f();
                    }
                    i2++;
                } catch (UnhandledFormatException e) {
                    throw new ConfigurationException((Throwable) e);
                }
            }
            flush = flush2;
            channelCount = channelCount3;
            channelCount2 = sampleRate;
        } else {
            int i4 = trimStartFrames;
            int i5 = trimEndFrames;
            encoding = encoding2;
        }
        int channelConfig = m18326a(channelCount, this.f16622p);
        if (channelConfig == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported channel count: ");
            sb.append(channelCount);
            throw new ConfigurationException(sb.toString());
        } else if (flush || !m18354q() || this.f16627u != encoding || this.f16625s != channelCount2 || this.f16626t != channelConfig) {
            reset();
            this.f16629w = processingEnabled;
            this.f16625s = channelCount2;
            this.f16626t = channelConfig;
            this.f16627u = encoding;
            this.f16589I = this.f16622p ? C8509F.m20462b(this.f16627u, channelCount) : -1;
            this.f16631y = specifiedBufferSize != 0 ? specifiedBufferSize : m18349l();
        }
    }

    /* renamed from: l */
    private int m18349l() {
        if (this.f16622p) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.f16625s, this.f16626t, this.f16627u);
            C8514e.m20490b(minBufferSize != -2);
            return C8509F.m20433a(minBufferSize * 4, ((int) m18337c(250000)) * this.f16589I, (int) Math.max((long) minBufferSize, m18337c(750000) * ((long) this.f16589I)));
        }
        int rate = m18332b(this.f16627u);
        if (this.f16627u == 5) {
            rate *= 2;
        }
        return (int) ((((long) rate) * 250000) / 1000000);
    }

    /* renamed from: t */
    private void m18357t() {
        AudioProcessor[] k;
        ArrayList<AudioProcessor> newAudioProcessors = new ArrayList<>();
        for (AudioProcessor audioProcessor : m18348k()) {
            if (audioProcessor.mo25036a()) {
                newAudioProcessors.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int count = newAudioProcessors.size();
        this.f16596P = (AudioProcessor[]) newAudioProcessors.toArray(new AudioProcessor[count]);
        this.f16597Q = new ByteBuffer[count];
        m18347j();
    }

    /* renamed from: j */
    private void m18347j() {
        int i = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.f16596P;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                audioProcessor.flush();
                this.f16597Q[i] = audioProcessor.mo25039c();
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: o */
    private void m18352o() throws InitializationException {
        this.f16616j.block();
        this.f16621o = m18353p();
        int audioSessionId = this.f16621o.getAudioSessionId();
        if (f16579a && C8509F.f18793a < 21) {
            AudioTrack audioTrack = this.f16620n;
            if (!(audioTrack == null || audioSessionId == audioTrack.getAudioSessionId())) {
                m18355r();
            }
            if (this.f16620n == null) {
                this.f16620n = m18340c(audioSessionId);
            }
        }
        if (this.f16605Y != audioSessionId) {
            this.f16605Y = audioSessionId;
            C8109a aVar = this.f16619m;
            if (aVar != null) {
                aVar.mo25069a(audioSessionId);
            }
        }
        this.f16581A = this.f16630x ? this.f16610d.mo25072a(this.f16581A) : C8438u.f18482a;
        m18357t();
        this.f16617k.mo25125a(this.f16621o, this.f16627u, this.f16589I, this.f16631y);
        m18356s();
        int i = this.f16606Z.f16717a;
        if (i != 0) {
            this.f16621o.attachAuxEffect(i);
            this.f16621o.setAuxEffectSendLevel(this.f16606Z.f16718b);
        }
    }

    public void play() {
        this.f16604X = true;
        if (m18354q()) {
            this.f16617k.mo25131d();
            this.f16621o.play();
        }
    }

    /* renamed from: i */
    public void mo25064i() {
        if (this.f16593M == 1) {
            this.f16593M = 2;
        }
    }

    /* renamed from: a */
    public boolean mo25058a(ByteBuffer buffer, long presentationTimeUs) throws InitializationException, WriteException {
        ByteBuffer byteBuffer = buffer;
        long j = presentationTimeUs;
        ByteBuffer byteBuffer2 = this.f16598R;
        C8514e.m20488a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!m18354q()) {
            m18352o();
            if (this.f16604X) {
                play();
            }
        }
        if (!this.f16617k.mo25133e(m18351n())) {
            return false;
        }
        String str = "AudioTrack";
        if (this.f16598R == null) {
            if (!buffer.hasRemaining()) {
                return true;
            }
            if (!this.f16622p && this.f16592L == 0) {
                this.f16592L = m18325a(this.f16627u, byteBuffer);
                if (this.f16592L == 0) {
                    return true;
                }
            }
            if (this.f16632z != null) {
                if (!m18343d()) {
                    return false;
                }
                C8438u newPlaybackParameters = this.f16632z;
                this.f16632z = null;
                C8438u newPlaybackParameters2 = this.f16610d.mo25072a(newPlaybackParameters);
                ArrayDeque<C8113c> arrayDeque = this.f16618l;
                C8113c cVar = r12;
                C8113c cVar2 = new C8113c(newPlaybackParameters2, Math.max(0, j), m18341d(m18351n()), null);
                arrayDeque.add(cVar);
                m18357t();
            }
            if (this.f16593M == 0) {
                this.f16594N = Math.max(0, j);
                this.f16593M = 1;
            } else {
                long expectedPresentationTimeUs = this.f16594N + m18344e(m18350m() - this.f16613g.mo25045h());
                if (this.f16593M == 1 && Math.abs(expectedPresentationTimeUs - j) > 200000) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Discontinuity detected [expected ");
                    sb.append(expectedPresentationTimeUs);
                    sb.append(", got ");
                    sb.append(j);
                    sb.append("]");
                    C8526n.m20531b(str, sb.toString());
                    this.f16593M = 2;
                }
                if (this.f16593M == 2) {
                    long adjustmentUs = j - expectedPresentationTimeUs;
                    this.f16594N += adjustmentUs;
                    this.f16593M = 1;
                    C8109a aVar = this.f16619m;
                    if (!(aVar == null || adjustmentUs == 0)) {
                        aVar.mo25068a();
                    }
                }
            }
            if (this.f16622p) {
                this.f16587G += (long) buffer.remaining();
            } else {
                this.f16588H += (long) this.f16592L;
            }
            this.f16598R = byteBuffer;
        }
        if (this.f16629w) {
            m18346f(j);
        } else {
            m18336b(this.f16598R, j);
        }
        if (!this.f16598R.hasRemaining()) {
            this.f16598R = null;
            return true;
        } else if (!this.f16617k.mo25132d(m18351n())) {
            return false;
        } else {
            C8526n.m20534d(str, "Resetting stalled audio track");
            reset();
            return true;
        }
    }

    /* renamed from: f */
    private void m18346f(long avSyncPresentationTimeUs) throws WriteException {
        ByteBuffer input;
        int count = this.f16596P.length;
        int index = count;
        while (index >= 0) {
            if (index > 0) {
                input = this.f16597Q[index - 1];
            } else {
                input = this.f16598R;
                if (input == null) {
                    input = AudioProcessor.f16572a;
                }
            }
            if (index == count) {
                m18336b(input, avSyncPresentationTimeUs);
            } else {
                AudioProcessor audioProcessor = this.f16596P[index];
                audioProcessor.mo25035a(input);
                ByteBuffer output = audioProcessor.mo25039c();
                this.f16597Q[index] = output;
                if (output.hasRemaining()) {
                    index++;
                }
            }
            if (!input.hasRemaining()) {
                index--;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m18336b(ByteBuffer buffer, long avSyncPresentationTimeUs) throws WriteException {
        if (buffer.hasRemaining()) {
            ByteBuffer byteBuffer = this.f16599S;
            boolean z = true;
            if (byteBuffer != null) {
                C8514e.m20488a(byteBuffer == buffer);
            } else {
                this.f16599S = buffer;
                if (C8509F.f18793a < 21) {
                    int bytesRemaining = buffer.remaining();
                    byte[] bArr = this.f16600T;
                    if (bArr == null || bArr.length < bytesRemaining) {
                        this.f16600T = new byte[bytesRemaining];
                    }
                    int originalPosition = buffer.position();
                    buffer.get(this.f16600T, 0, bytesRemaining);
                    buffer.position(originalPosition);
                    this.f16601U = 0;
                }
            }
            int bytesRemaining2 = buffer.remaining();
            int bytesWritten = 0;
            if (C8509F.f18793a < 21) {
                int bytesToWrite = this.f16617k.mo25123a(this.f16590J);
                if (bytesToWrite > 0) {
                    bytesWritten = this.f16621o.write(this.f16600T, this.f16601U, Math.min(bytesRemaining2, bytesToWrite));
                    if (bytesWritten > 0) {
                        this.f16601U += bytesWritten;
                        buffer.position(buffer.position() + bytesWritten);
                    }
                }
            } else if (this.f16607aa) {
                if (avSyncPresentationTimeUs == -9223372036854775807L) {
                    z = false;
                }
                C8514e.m20490b(z);
                bytesWritten = m18328a(this.f16621o, buffer, bytesRemaining2, avSyncPresentationTimeUs);
            } else {
                bytesWritten = m18327a(this.f16621o, buffer, bytesRemaining2);
            }
            this.f16608ba = SystemClock.elapsedRealtime();
            if (bytesWritten >= 0) {
                if (this.f16622p) {
                    this.f16590J += (long) bytesWritten;
                }
                if (bytesWritten == bytesRemaining2) {
                    if (!this.f16622p) {
                        this.f16591K += (long) this.f16592L;
                    }
                    this.f16599S = null;
                }
                return;
            }
            throw new WriteException(bytesWritten);
        }
    }

    /* renamed from: h */
    public void mo25063h() throws WriteException {
        if (!this.f16603W && m18354q() && m18343d()) {
            this.f16617k.mo25127b(m18351n());
            this.f16621o.stop();
            this.f16585E = 0;
            this.f16603W = true;
        }
    }

    /* renamed from: d */
    private boolean m18343d() throws WriteException {
        boolean audioProcessorNeedsEndOfStream = false;
        if (this.f16602V == -1) {
            this.f16602V = this.f16629w ? 0 : this.f16596P.length;
            audioProcessorNeedsEndOfStream = true;
        }
        while (true) {
            int i = this.f16602V;
            AudioProcessor[] audioProcessorArr = this.f16596P;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                if (audioProcessorNeedsEndOfStream) {
                    audioProcessor.mo25044g();
                }
                m18346f(-9223372036854775807L);
                if (!audioProcessor.mo25038b()) {
                    return false;
                }
                audioProcessorNeedsEndOfStream = true;
                this.f16602V++;
            } else {
                ByteBuffer byteBuffer = this.f16599S;
                if (byteBuffer != null) {
                    m18336b(byteBuffer, -9223372036854775807L);
                    if (this.f16599S != null) {
                        return false;
                    }
                }
                this.f16602V = -1;
                return true;
            }
        }
    }

    /* renamed from: b */
    public boolean mo25059b() {
        return !m18354q() || (this.f16603W && !mo25061f());
    }

    /* renamed from: f */
    public boolean mo25061f() {
        return m18354q() && this.f16617k.mo25130c(m18351n());
    }

    /* renamed from: a */
    public C8438u mo25049a(C8438u playbackParameters) {
        if (!m18354q() || this.f16630x) {
            C8438u lastSetPlaybackParameters = this.f16632z;
            if (lastSetPlaybackParameters == null) {
                lastSetPlaybackParameters = !this.f16618l.isEmpty() ? ((C8113c) this.f16618l.getLast()).f16636a : this.f16581A;
            }
            if (!playbackParameters.equals(lastSetPlaybackParameters)) {
                if (m18354q()) {
                    this.f16632z = playbackParameters;
                } else {
                    this.f16581A = this.f16610d.mo25072a(playbackParameters);
                }
            }
            return this.f16581A;
        }
        this.f16581A = C8438u.f18482a;
        return this.f16581A;
    }

    /* renamed from: e */
    public C8438u mo25060e() {
        return this.f16581A;
    }

    /* renamed from: a */
    public void mo25055a(C8125j audioAttributes) {
        if (!this.f16628v.equals(audioAttributes)) {
            this.f16628v = audioAttributes;
            if (!this.f16607aa) {
                reset();
                this.f16605Y = 0;
            }
        }
    }

    /* renamed from: a */
    public void mo25056a(C8134o auxEffectInfo) {
        if (!this.f16606Z.equals(auxEffectInfo)) {
            int effectId = auxEffectInfo.f16717a;
            float sendLevel = auxEffectInfo.f16718b;
            AudioTrack audioTrack = this.f16621o;
            if (audioTrack != null) {
                if (this.f16606Z.f16717a != effectId) {
                    audioTrack.attachAuxEffect(effectId);
                }
                if (effectId != 0) {
                    this.f16621o.setAuxEffectSendLevel(sendLevel);
                }
            }
            this.f16606Z = auxEffectInfo;
        }
    }

    /* renamed from: a */
    public void mo25052a(int tunnelingAudioSessionId) {
        C8514e.m20490b(C8509F.f18793a >= 21);
        if (!this.f16607aa || this.f16605Y != tunnelingAudioSessionId) {
            this.f16607aa = true;
            this.f16605Y = tunnelingAudioSessionId;
            reset();
        }
    }

    /* renamed from: g */
    public void mo25062g() {
        if (this.f16607aa) {
            this.f16607aa = false;
            this.f16605Y = 0;
            reset();
        }
    }

    /* renamed from: a */
    public void mo25051a(float volume) {
        if (this.f16595O != volume) {
            this.f16595O = volume;
            m18356s();
        }
    }

    /* renamed from: s */
    private void m18356s() {
        if (m18354q()) {
            if (C8509F.f18793a >= 21) {
                m18331a(this.f16621o, this.f16595O);
            } else {
                m18335b(this.f16621o, this.f16595O);
            }
        }
    }

    public void pause() {
        this.f16604X = false;
        if (m18354q() && this.f16617k.mo25128b()) {
            this.f16621o.pause();
        }
    }

    public void reset() {
        if (m18354q()) {
            this.f16587G = 0;
            this.f16588H = 0;
            this.f16590J = 0;
            this.f16591K = 0;
            this.f16592L = 0;
            C8438u uVar = this.f16632z;
            if (uVar != null) {
                this.f16581A = uVar;
                this.f16632z = null;
            } else if (!this.f16618l.isEmpty()) {
                this.f16581A = ((C8113c) this.f16618l.getLast()).f16636a;
            }
            this.f16618l.clear();
            this.f16582B = 0;
            this.f16583C = 0;
            this.f16613g.mo25046i();
            this.f16598R = null;
            this.f16599S = null;
            m18347j();
            this.f16603W = false;
            this.f16602V = -1;
            this.f16584D = null;
            this.f16585E = 0;
            this.f16593M = 0;
            if (this.f16617k.mo25126a()) {
                this.f16621o.pause();
            }
            AudioTrack toRelease = this.f16621o;
            this.f16621o = null;
            this.f16617k.mo25129c();
            this.f16616j.close();
            new C8136q(this, toRelease).start();
        }
    }

    /* renamed from: a */
    public void mo25050a() {
        reset();
        m18355r();
        for (AudioProcessor audioProcessor : this.f16614h) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.f16615i) {
            audioProcessor2.reset();
        }
        this.f16605Y = 0;
        this.f16604X = false;
    }

    /* renamed from: r */
    private void m18355r() {
        if (this.f16620n != null) {
            AudioTrack toRelease = this.f16620n;
            this.f16620n = null;
            new C8137r(this, toRelease).start();
        }
    }

    /* renamed from: b */
    private long m18333b(long positionUs) {
        C8113c checkpoint = null;
        while (!this.f16618l.isEmpty() && positionUs >= ((C8113c) this.f16618l.getFirst()).f16638c) {
            checkpoint = (C8113c) this.f16618l.remove();
        }
        if (checkpoint != null) {
            this.f16581A = checkpoint.f16636a;
            this.f16583C = checkpoint.f16638c;
            this.f16582B = checkpoint.f16637b - this.f16594N;
        }
        if (this.f16581A.f18483b == 1.0f) {
            return (this.f16582B + positionUs) - this.f16583C;
        }
        if (this.f16618l.isEmpty()) {
            return this.f16582B + this.f16610d.mo25071a(positionUs - this.f16583C);
        }
        return this.f16582B + C8509F.m20438a(positionUs - this.f16583C, this.f16581A.f18483b);
    }

    /* renamed from: a */
    private long m18329a(long positionUs) {
        return m18341d(this.f16610d.mo25074b()) + positionUs;
    }

    /* renamed from: q */
    private boolean m18354q() {
        return this.f16621o != null;
    }

    /* renamed from: e */
    private long m18344e(long frameCount) {
        return (1000000 * frameCount) / ((long) this.f16624r);
    }

    /* renamed from: d */
    private long m18341d(long frameCount) {
        return (1000000 * frameCount) / ((long) this.f16625s);
    }

    /* renamed from: c */
    private long m18337c(long durationUs) {
        return (((long) this.f16625s) * durationUs) / 1000000;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public long m18350m() {
        return this.f16622p ? this.f16587G / ((long) this.f16586F) : this.f16588H;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public long m18351n() {
        return this.f16622p ? this.f16590J / ((long) this.f16589I) : this.f16591K;
    }

    /* renamed from: p */
    private AudioTrack m18353p() throws InitializationException {
        AudioTrack audioTrack;
        if (C8509F.f18793a >= 21) {
            audioTrack = m18339c();
        } else {
            int streamType = C8509F.m20473d(this.f16628v.f16671d);
            int i = this.f16605Y;
            if (i == 0) {
                AudioTrack audioTrack2 = new AudioTrack(streamType, this.f16625s, this.f16626t, this.f16627u, this.f16631y, 1);
                audioTrack = audioTrack2;
            } else {
                AudioTrack audioTrack3 = new AudioTrack(streamType, this.f16625s, this.f16626t, this.f16627u, this.f16631y, 1, i);
                audioTrack = audioTrack3;
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception e) {
        }
        throw new InitializationException(state, this.f16625s, this.f16626t, this.f16631y);
    }

    @TargetApi(21)
    /* renamed from: c */
    private AudioTrack m18339c() {
        AudioAttributes attributes;
        if (this.f16607aa) {
            attributes = new Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            attributes = this.f16628v.mo25085a();
        }
        AudioFormat format = new AudioFormat.Builder().setChannelMask(this.f16626t).setEncoding(this.f16627u).setSampleRate(this.f16625s).build();
        int i = this.f16605Y;
        AudioTrack audioTrack = new AudioTrack(attributes, format, this.f16631y, 1, i != 0 ? i : 0);
        return audioTrack;
    }

    /* renamed from: c */
    private AudioTrack m18340c(int audioSessionId) {
        AudioTrack audioTrack = new AudioTrack(3, 4000, 4, 2, 2, 0, audioSessionId);
        return audioTrack;
    }

    /* renamed from: k */
    private AudioProcessor[] m18348k() {
        return this.f16623q ? this.f16615i : this.f16614h;
    }

    /* renamed from: a */
    private static int m18326a(int channelCount, boolean isInputPcm) {
        if (C8509F.f18793a <= 28 && !isInputPcm) {
            if (channelCount == 7) {
                channelCount = 8;
            } else if (channelCount == 3 || channelCount == 4 || channelCount == 5) {
                channelCount = 6;
            }
        }
        if (C8509F.f18793a <= 26) {
            if ("fugu".equals(C8509F.f18794b) && !isInputPcm && channelCount == 1) {
                channelCount = 2;
            }
        }
        return C8509F.m20431a(channelCount);
    }

    /* renamed from: b */
    private static int m18332b(int encoding) {
        if (encoding == 5) {
            return 80000;
        }
        if (encoding == 6) {
            return 768000;
        }
        if (encoding == 7) {
            return 192000;
        }
        if (encoding == 8) {
            return 2250000;
        }
        if (encoding == 14) {
            return 3062500;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private static int m18325a(int encoding, ByteBuffer buffer) {
        int i;
        if (encoding == 7 || encoding == 8) {
            return C8138s.m18468a(buffer);
        }
        if (encoding == 5) {
            return C8122h.m18390a();
        }
        if (encoding == 6) {
            return C8122h.m18397b(buffer);
        }
        if (encoding == 14) {
            int syncframeOffset = C8122h.m18392a(buffer);
            if (syncframeOffset == -1) {
                i = 0;
            } else {
                i = C8122h.m18393a(buffer, syncframeOffset) * 16;
            }
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected audio encoding: ");
        sb.append(encoding);
        throw new IllegalStateException(sb.toString());
    }

    @TargetApi(21)
    /* renamed from: a */
    private static int m18327a(AudioTrack audioTrack, ByteBuffer buffer, int size) {
        return audioTrack.write(buffer, size, 1);
    }

    @TargetApi(21)
    /* renamed from: a */
    private int m18328a(AudioTrack audioTrack, ByteBuffer buffer, int size, long presentationTimeUs) {
        if (this.f16584D == null) {
            this.f16584D = ByteBuffer.allocate(16);
            this.f16584D.order(ByteOrder.BIG_ENDIAN);
            this.f16584D.putInt(1431633921);
        }
        if (this.f16585E == 0) {
            this.f16584D.putInt(4, size);
            this.f16584D.putLong(8, 1000 * presentationTimeUs);
            this.f16584D.position(0);
            this.f16585E = size;
        }
        int avSyncHeaderBytesRemaining = this.f16584D.remaining();
        if (avSyncHeaderBytesRemaining > 0) {
            int result = audioTrack.write(this.f16584D, avSyncHeaderBytesRemaining, 1);
            if (result < 0) {
                this.f16585E = 0;
                return result;
            } else if (result < avSyncHeaderBytesRemaining) {
                return 0;
            }
        }
        int result2 = m18327a(audioTrack, buffer, size);
        if (result2 < 0) {
            this.f16585E = 0;
            return result2;
        }
        this.f16585E -= result2;
        return result2;
    }

    @TargetApi(21)
    /* renamed from: a */
    private static void m18331a(AudioTrack audioTrack, float volume) {
        audioTrack.setVolume(volume);
    }

    /* renamed from: b */
    private static void m18335b(AudioTrack audioTrack, float volume) {
        audioTrack.setStereoVolume(volume, volume);
    }
}
