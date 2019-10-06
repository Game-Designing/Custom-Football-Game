package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* renamed from: com.google.android.exoplayer2.audio.z */
/* compiled from: SonicAudioProcessor */
public final class C8146z implements AudioProcessor {

    /* renamed from: a */
    private int f16802a = -1;

    /* renamed from: b */
    private int f16803b = -1;

    /* renamed from: c */
    private float f16804c = 1.0f;

    /* renamed from: d */
    private float f16805d = 1.0f;

    /* renamed from: e */
    private int f16806e = -1;

    /* renamed from: f */
    private int f16807f = -1;

    /* renamed from: g */
    private C8145y f16808g;

    /* renamed from: h */
    private ByteBuffer f16809h = AudioProcessor.f16572a;

    /* renamed from: i */
    private ShortBuffer f16810i = this.f16809h.asShortBuffer();

    /* renamed from: j */
    private ByteBuffer f16811j = AudioProcessor.f16572a;

    /* renamed from: k */
    private long f16812k;

    /* renamed from: l */
    private long f16813l;

    /* renamed from: m */
    private boolean f16814m;

    /* renamed from: b */
    public float mo25179b(float speed) {
        float speed2 = C8509F.m20430a(speed, 0.1f, 8.0f);
        if (this.f16804c != speed2) {
            this.f16804c = speed2;
            this.f16808g = null;
        }
        flush();
        return speed2;
    }

    /* renamed from: a */
    public float mo25177a(float pitch) {
        float pitch2 = C8509F.m20430a(pitch, 0.1f, 8.0f);
        if (this.f16805d != pitch2) {
            this.f16805d = pitch2;
            this.f16808g = null;
        }
        flush();
        return pitch2;
    }

    /* renamed from: a */
    public long mo25178a(long duration) {
        long j;
        long j2 = this.f16813l;
        if (j2 >= 1024) {
            int i = this.f16806e;
            int i2 = this.f16803b;
            if (i == i2) {
                j = C8509F.m20471c(duration, this.f16812k, j2);
            } else {
                j = C8509F.m20471c(duration, this.f16812k * ((long) i), j2 * ((long) i2));
            }
            return j;
        }
        double d = (double) this.f16804c;
        double d2 = (double) duration;
        Double.isNaN(d);
        Double.isNaN(d2);
        return (long) (d * d2);
    }

    /* renamed from: a */
    public boolean mo25037a(int sampleRateHz, int channelCount, int encoding) throws UnhandledFormatException {
        if (encoding == 2) {
            int outputSampleRateHz = this.f16807f;
            if (outputSampleRateHz == -1) {
                outputSampleRateHz = sampleRateHz;
            }
            if (this.f16803b == sampleRateHz && this.f16802a == channelCount && this.f16806e == outputSampleRateHz) {
                return false;
            }
            this.f16803b = sampleRateHz;
            this.f16802a = channelCount;
            this.f16806e = outputSampleRateHz;
            this.f16808g = null;
            return true;
        }
        throw new UnhandledFormatException(sampleRateHz, channelCount, encoding);
    }

    /* renamed from: a */
    public boolean mo25036a() {
        return this.f16803b != -1 && (Math.abs(this.f16804c - 1.0f) >= 0.01f || Math.abs(this.f16805d - 1.0f) >= 0.01f || this.f16806e != this.f16803b);
    }

    /* renamed from: d */
    public int mo25040d() {
        return this.f16802a;
    }

    /* renamed from: f */
    public int mo25042f() {
        return 2;
    }

    /* renamed from: e */
    public int mo25041e() {
        return this.f16806e;
    }

    /* renamed from: a */
    public void mo25035a(ByteBuffer inputBuffer) {
        C8514e.m20490b(this.f16808g != null);
        if (inputBuffer.hasRemaining()) {
            ShortBuffer shortBuffer = inputBuffer.asShortBuffer();
            int inputSize = inputBuffer.remaining();
            this.f16812k += (long) inputSize;
            this.f16808g.mo25175b(shortBuffer);
            inputBuffer.position(inputBuffer.position() + inputSize);
        }
        int outputSize = this.f16808g.mo25174b() * this.f16802a * 2;
        if (outputSize > 0) {
            if (this.f16809h.capacity() < outputSize) {
                this.f16809h = ByteBuffer.allocateDirect(outputSize).order(ByteOrder.nativeOrder());
                this.f16810i = this.f16809h.asShortBuffer();
            } else {
                this.f16809h.clear();
                this.f16810i.clear();
            }
            this.f16808g.mo25173a(this.f16810i);
            this.f16813l += (long) outputSize;
            this.f16809h.limit(outputSize);
            this.f16811j = this.f16809h;
        }
    }

    /* renamed from: g */
    public void mo25044g() {
        C8514e.m20490b(this.f16808g != null);
        this.f16808g.mo25176c();
        this.f16814m = true;
    }

    /* renamed from: c */
    public ByteBuffer mo25039c() {
        ByteBuffer outputBuffer = this.f16811j;
        this.f16811j = AudioProcessor.f16572a;
        return outputBuffer;
    }

    /* renamed from: b */
    public boolean mo25038b() {
        if (this.f16814m) {
            C8145y yVar = this.f16808g;
            if (yVar == null || yVar.mo25174b() == 0) {
                return true;
            }
        }
        return false;
    }

    public void flush() {
        if (mo25036a()) {
            C8145y yVar = this.f16808g;
            if (yVar == null) {
                C8145y yVar2 = new C8145y(this.f16803b, this.f16802a, this.f16804c, this.f16805d, this.f16806e);
                this.f16808g = yVar2;
            } else {
                yVar.mo25172a();
            }
        }
        this.f16811j = AudioProcessor.f16572a;
        this.f16812k = 0;
        this.f16813l = 0;
        this.f16814m = false;
    }

    public void reset() {
        this.f16804c = 1.0f;
        this.f16805d = 1.0f;
        this.f16802a = -1;
        this.f16803b = -1;
        this.f16806e = -1;
        this.f16809h = AudioProcessor.f16572a;
        this.f16810i = this.f16809h.asShortBuffer();
        this.f16811j = AudioProcessor.f16572a;
        this.f16807f = -1;
        this.f16808g = null;
        this.f16812k = 0;
        this.f16813l = 0;
        this.f16814m = false;
    }
}
