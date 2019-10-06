package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import com.google.android.exoplayer2.util.C8509F;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.google.android.exoplayer2.audio.x */
/* compiled from: SilenceSkippingAudioProcessor */
public final class C8144x implements AudioProcessor {

    /* renamed from: a */
    private int f16766a = -1;

    /* renamed from: b */
    private int f16767b = -1;

    /* renamed from: c */
    private int f16768c;

    /* renamed from: d */
    private boolean f16769d;

    /* renamed from: e */
    private ByteBuffer f16770e;

    /* renamed from: f */
    private ByteBuffer f16771f;

    /* renamed from: g */
    private boolean f16772g;

    /* renamed from: h */
    private byte[] f16773h;

    /* renamed from: i */
    private byte[] f16774i;

    /* renamed from: j */
    private int f16775j;

    /* renamed from: k */
    private int f16776k;

    /* renamed from: l */
    private int f16777l;

    /* renamed from: m */
    private boolean f16778m;

    /* renamed from: n */
    private long f16779n;

    public C8144x() {
        ByteBuffer byteBuffer = AudioProcessor.f16572a;
        this.f16770e = byteBuffer;
        this.f16771f = byteBuffer;
        byte[] bArr = C8509F.f18798f;
        this.f16773h = bArr;
        this.f16774i = bArr;
    }

    /* renamed from: a */
    public void mo25170a(boolean enabled) {
        this.f16769d = enabled;
        flush();
    }

    /* renamed from: h */
    public long mo25171h() {
        return this.f16779n;
    }

    /* renamed from: a */
    public boolean mo25037a(int sampleRateHz, int channelCount, int encoding) throws UnhandledFormatException {
        if (encoding != 2) {
            throw new UnhandledFormatException(sampleRateHz, channelCount, encoding);
        } else if (this.f16767b == sampleRateHz && this.f16766a == channelCount) {
            return false;
        } else {
            this.f16767b = sampleRateHz;
            this.f16766a = channelCount;
            this.f16768c = channelCount * 2;
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo25036a() {
        return this.f16767b != -1 && this.f16769d;
    }

    /* renamed from: d */
    public int mo25040d() {
        return this.f16766a;
    }

    /* renamed from: f */
    public int mo25042f() {
        return 2;
    }

    /* renamed from: e */
    public int mo25041e() {
        return this.f16767b;
    }

    /* renamed from: a */
    public void mo25035a(ByteBuffer inputBuffer) {
        while (inputBuffer.hasRemaining() && !this.f16771f.hasRemaining()) {
            int i = this.f16775j;
            if (i == 0) {
                m18541f(inputBuffer);
            } else if (i == 1) {
                m18540e(inputBuffer);
            } else if (i == 2) {
                m18542g(inputBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* renamed from: g */
    public void mo25044g() {
        this.f16772g = true;
        int i = this.f16776k;
        if (i > 0) {
            m18536a(this.f16773h, i);
        }
        if (!this.f16778m) {
            this.f16779n += (long) (this.f16777l / this.f16768c);
        }
    }

    /* renamed from: c */
    public ByteBuffer mo25039c() {
        ByteBuffer outputBuffer = this.f16771f;
        this.f16771f = AudioProcessor.f16572a;
        return outputBuffer;
    }

    /* renamed from: b */
    public boolean mo25038b() {
        return this.f16772g && this.f16771f == AudioProcessor.f16572a;
    }

    public void flush() {
        if (mo25036a()) {
            int maybeSilenceBufferSize = m18533a(150000) * this.f16768c;
            if (this.f16773h.length != maybeSilenceBufferSize) {
                this.f16773h = new byte[maybeSilenceBufferSize];
            }
            this.f16777l = m18533a(20000) * this.f16768c;
            int length = this.f16774i.length;
            int i = this.f16777l;
            if (length != i) {
                this.f16774i = new byte[i];
            }
        }
        this.f16775j = 0;
        this.f16771f = AudioProcessor.f16572a;
        this.f16772g = false;
        this.f16779n = 0;
        this.f16776k = 0;
        this.f16778m = false;
    }

    public void reset() {
        this.f16769d = false;
        flush();
        this.f16770e = AudioProcessor.f16572a;
        this.f16766a = -1;
        this.f16767b = -1;
        this.f16777l = 0;
        byte[] bArr = C8509F.f18798f;
        this.f16773h = bArr;
        this.f16774i = bArr;
    }

    /* renamed from: f */
    private void m18541f(ByteBuffer inputBuffer) {
        int limit = inputBuffer.limit();
        inputBuffer.limit(Math.min(limit, inputBuffer.position() + this.f16773h.length));
        int noiseLimit = m18537b(inputBuffer);
        if (noiseLimit == inputBuffer.position()) {
            this.f16775j = 1;
        } else {
            inputBuffer.limit(noiseLimit);
            m18539d(inputBuffer);
        }
        inputBuffer.limit(limit);
    }

    /* renamed from: e */
    private void m18540e(ByteBuffer inputBuffer) {
        int limit = inputBuffer.limit();
        int noisePosition = m18538c(inputBuffer);
        int maybeSilenceInputSize = noisePosition - inputBuffer.position();
        byte[] bArr = this.f16773h;
        int length = bArr.length;
        int i = this.f16776k;
        int maybeSilenceBufferRemaining = length - i;
        if (noisePosition >= limit || maybeSilenceInputSize >= maybeSilenceBufferRemaining) {
            int bytesToWrite = Math.min(maybeSilenceInputSize, maybeSilenceBufferRemaining);
            inputBuffer.limit(inputBuffer.position() + bytesToWrite);
            inputBuffer.get(this.f16773h, this.f16776k, bytesToWrite);
            this.f16776k += bytesToWrite;
            int i2 = this.f16776k;
            byte[] bArr2 = this.f16773h;
            if (i2 == bArr2.length) {
                if (this.f16778m) {
                    m18536a(bArr2, this.f16777l);
                    this.f16779n += (long) ((this.f16776k - (this.f16777l * 2)) / this.f16768c);
                } else {
                    this.f16779n += (long) ((i2 - this.f16777l) / this.f16768c);
                }
                m18535a(inputBuffer, this.f16773h, this.f16776k);
                this.f16776k = 0;
                this.f16775j = 2;
            }
            inputBuffer.limit(limit);
            return;
        }
        m18536a(bArr, i);
        this.f16776k = 0;
        this.f16775j = 0;
    }

    /* renamed from: g */
    private void m18542g(ByteBuffer inputBuffer) {
        int limit = inputBuffer.limit();
        int noisyPosition = m18538c(inputBuffer);
        inputBuffer.limit(noisyPosition);
        this.f16779n += (long) (inputBuffer.remaining() / this.f16768c);
        m18535a(inputBuffer, this.f16774i, this.f16777l);
        if (noisyPosition < limit) {
            m18536a(this.f16774i, this.f16777l);
            this.f16775j = 0;
            inputBuffer.limit(limit);
        }
    }

    /* renamed from: a */
    private void m18536a(byte[] data, int length) {
        m18534a(length);
        this.f16770e.put(data, 0, length);
        this.f16770e.flip();
        this.f16771f = this.f16770e;
    }

    /* renamed from: d */
    private void m18539d(ByteBuffer data) {
        m18534a(data.remaining());
        this.f16770e.put(data);
        this.f16770e.flip();
        this.f16771f = this.f16770e;
    }

    /* renamed from: a */
    private void m18534a(int size) {
        if (this.f16770e.capacity() < size) {
            this.f16770e = ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());
        } else {
            this.f16770e.clear();
        }
        if (size > 0) {
            this.f16778m = true;
        }
    }

    /* renamed from: a */
    private void m18535a(ByteBuffer input, byte[] buffer, int size) {
        int fromInputSize = Math.min(input.remaining(), this.f16777l);
        int fromBufferSize = this.f16777l - fromInputSize;
        System.arraycopy(buffer, size - fromBufferSize, this.f16774i, 0, fromBufferSize);
        input.position(input.limit() - fromInputSize);
        input.get(this.f16774i, fromBufferSize, fromInputSize);
    }

    /* renamed from: a */
    private int m18533a(long durationUs) {
        return (int) ((((long) this.f16767b) * durationUs) / 1000000);
    }

    /* renamed from: c */
    private int m18538c(ByteBuffer buffer) {
        for (int i = buffer.position() + 1; i < buffer.limit(); i += 2) {
            if (Math.abs(buffer.get(i)) > 4) {
                int i2 = this.f16768c;
                return i2 * (i / i2);
            }
        }
        return buffer.limit();
    }

    /* renamed from: b */
    private int m18537b(ByteBuffer buffer) {
        for (int i = buffer.limit() - 1; i >= buffer.position(); i -= 2) {
            if (Math.abs(buffer.get(i)) > 4) {
                int i2 = this.f16768c;
                return ((i / i2) * i2) + i2;
            }
        }
        return buffer.position();
    }
}
