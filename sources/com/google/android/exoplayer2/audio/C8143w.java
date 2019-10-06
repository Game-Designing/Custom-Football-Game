package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.google.android.exoplayer2.audio.w */
/* compiled from: ResamplingAudioProcessor */
final class C8143w implements AudioProcessor {

    /* renamed from: a */
    private int f16760a = -1;

    /* renamed from: b */
    private int f16761b = -1;

    /* renamed from: c */
    private int f16762c = 0;

    /* renamed from: d */
    private ByteBuffer f16763d;

    /* renamed from: e */
    private ByteBuffer f16764e;

    /* renamed from: f */
    private boolean f16765f;

    public C8143w() {
        ByteBuffer byteBuffer = AudioProcessor.f16572a;
        this.f16763d = byteBuffer;
        this.f16764e = byteBuffer;
    }

    /* renamed from: a */
    public boolean mo25037a(int sampleRateHz, int channelCount, int encoding) throws UnhandledFormatException {
        if (encoding != 3 && encoding != 2 && encoding != Integer.MIN_VALUE && encoding != 1073741824) {
            throw new UnhandledFormatException(sampleRateHz, channelCount, encoding);
        } else if (this.f16760a == sampleRateHz && this.f16761b == channelCount && this.f16762c == encoding) {
            return false;
        } else {
            this.f16760a = sampleRateHz;
            this.f16761b = channelCount;
            this.f16762c = encoding;
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo25036a() {
        int i = this.f16762c;
        return (i == 0 || i == 2) ? false : true;
    }

    /* renamed from: d */
    public int mo25040d() {
        return this.f16761b;
    }

    /* renamed from: f */
    public int mo25042f() {
        return 2;
    }

    /* renamed from: e */
    public int mo25041e() {
        return this.f16760a;
    }

    /* renamed from: a */
    public void mo25035a(ByteBuffer inputBuffer) {
        int resampledSize;
        int position = inputBuffer.position();
        int limit = inputBuffer.limit();
        int size = limit - position;
        int i = this.f16762c;
        if (i == Integer.MIN_VALUE) {
            resampledSize = (size / 3) * 2;
        } else if (i == 3) {
            resampledSize = size * 2;
        } else if (i == 1073741824) {
            resampledSize = size / 2;
        } else {
            throw new IllegalStateException();
        }
        if (this.f16763d.capacity() < resampledSize) {
            this.f16763d = ByteBuffer.allocateDirect(resampledSize).order(ByteOrder.nativeOrder());
        } else {
            this.f16763d.clear();
        }
        int i2 = this.f16762c;
        if (i2 == Integer.MIN_VALUE) {
            for (int i3 = position; i3 < limit; i3 += 3) {
                this.f16763d.put(inputBuffer.get(i3 + 1));
                this.f16763d.put(inputBuffer.get(i3 + 2));
            }
        } else if (i2 == 3) {
            for (int i4 = position; i4 < limit; i4++) {
                this.f16763d.put(0);
                this.f16763d.put((byte) ((inputBuffer.get(i4) & 255) - 128));
            }
        } else if (i2 == 1073741824) {
            for (int i5 = position; i5 < limit; i5 += 4) {
                this.f16763d.put(inputBuffer.get(i5 + 2));
                this.f16763d.put(inputBuffer.get(i5 + 3));
            }
        } else {
            throw new IllegalStateException();
        }
        inputBuffer.position(inputBuffer.limit());
        this.f16763d.flip();
        this.f16764e = this.f16763d;
    }

    /* renamed from: g */
    public void mo25044g() {
        this.f16765f = true;
    }

    /* renamed from: c */
    public ByteBuffer mo25039c() {
        ByteBuffer outputBuffer = this.f16764e;
        this.f16764e = AudioProcessor.f16572a;
        return outputBuffer;
    }

    /* renamed from: b */
    public boolean mo25038b() {
        return this.f16765f && this.f16764e == AudioProcessor.f16572a;
    }

    public void flush() {
        this.f16764e = AudioProcessor.f16572a;
        this.f16765f = false;
    }

    public void reset() {
        flush();
        this.f16760a = -1;
        this.f16761b = -1;
        this.f16762c = 0;
        this.f16763d = AudioProcessor.f16572a;
    }
}
