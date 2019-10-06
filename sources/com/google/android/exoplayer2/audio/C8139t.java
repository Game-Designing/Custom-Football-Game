package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import com.google.android.exoplayer2.util.C8509F;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: com.google.android.exoplayer2.audio.t */
/* compiled from: FloatResamplingAudioProcessor */
final class C8139t implements AudioProcessor {

    /* renamed from: a */
    private static final int f16734a = Float.floatToIntBits(Float.NaN);

    /* renamed from: b */
    private int f16735b = -1;

    /* renamed from: c */
    private int f16736c = -1;

    /* renamed from: d */
    private int f16737d = 0;

    /* renamed from: e */
    private ByteBuffer f16738e;

    /* renamed from: f */
    private ByteBuffer f16739f;

    /* renamed from: g */
    private boolean f16740g;

    public C8139t() {
        ByteBuffer byteBuffer = AudioProcessor.f16572a;
        this.f16738e = byteBuffer;
        this.f16739f = byteBuffer;
    }

    /* renamed from: a */
    public boolean mo25037a(int sampleRateHz, int channelCount, int encoding) throws UnhandledFormatException {
        if (!C8509F.m20477e(encoding)) {
            throw new UnhandledFormatException(sampleRateHz, channelCount, encoding);
        } else if (this.f16735b == sampleRateHz && this.f16736c == channelCount && this.f16737d == encoding) {
            return false;
        } else {
            this.f16735b = sampleRateHz;
            this.f16736c = channelCount;
            this.f16737d = encoding;
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo25036a() {
        return C8509F.m20477e(this.f16737d);
    }

    /* renamed from: d */
    public int mo25040d() {
        return this.f16736c;
    }

    /* renamed from: f */
    public int mo25042f() {
        return 4;
    }

    /* renamed from: e */
    public int mo25041e() {
        return this.f16735b;
    }

    /* renamed from: a */
    public void mo25035a(ByteBuffer inputBuffer) {
        boolean isInput32Bit = this.f16737d == 1073741824;
        int position = inputBuffer.position();
        int limit = inputBuffer.limit();
        int size = limit - position;
        int resampledSize = isInput32Bit ? size : (size / 3) * 4;
        if (this.f16738e.capacity() < resampledSize) {
            this.f16738e = ByteBuffer.allocateDirect(resampledSize).order(ByteOrder.nativeOrder());
        } else {
            this.f16738e.clear();
        }
        if (isInput32Bit) {
            for (int i = position; i < limit; i += 4) {
                m18475a((inputBuffer.get(i) & 255) | ((inputBuffer.get(i + 1) & 255) << 8) | ((inputBuffer.get(i + 2) & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((inputBuffer.get(i + 3) & 255) << 24), this.f16738e);
            }
        } else {
            for (int i2 = position; i2 < limit; i2 += 3) {
                m18475a(((inputBuffer.get(i2) & 255) << 8) | ((inputBuffer.get(i2 + 1) & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((inputBuffer.get(i2 + 2) & 255) << 24), this.f16738e);
            }
        }
        inputBuffer.position(inputBuffer.limit());
        this.f16738e.flip();
        this.f16739f = this.f16738e;
    }

    /* renamed from: g */
    public void mo25044g() {
        this.f16740g = true;
    }

    /* renamed from: c */
    public ByteBuffer mo25039c() {
        ByteBuffer outputBuffer = this.f16739f;
        this.f16739f = AudioProcessor.f16572a;
        return outputBuffer;
    }

    /* renamed from: b */
    public boolean mo25038b() {
        return this.f16740g && this.f16739f == AudioProcessor.f16572a;
    }

    public void flush() {
        this.f16739f = AudioProcessor.f16572a;
        this.f16740g = false;
    }

    public void reset() {
        flush();
        this.f16735b = -1;
        this.f16736c = -1;
        this.f16737d = 0;
        this.f16738e = AudioProcessor.f16572a;
    }

    /* renamed from: a */
    private static void m18475a(int pcm32BitInt, ByteBuffer buffer) {
        double d = (double) pcm32BitInt;
        Double.isNaN(d);
        int floatBits = Float.floatToIntBits((float) (d * 4.656612875245797E-10d));
        if (floatBits == f16734a) {
            floatBits = Float.floatToIntBits(0.0f);
        }
        buffer.putInt(floatBits);
    }
}
