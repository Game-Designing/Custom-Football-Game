package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import com.google.android.exoplayer2.util.C8509F;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.google.android.exoplayer2.audio.A */
/* compiled from: TrimmingAudioProcessor */
final class C8108A implements AudioProcessor {

    /* renamed from: a */
    private boolean f16558a;

    /* renamed from: b */
    private int f16559b;

    /* renamed from: c */
    private int f16560c;

    /* renamed from: d */
    private int f16561d = -1;

    /* renamed from: e */
    private int f16562e = -1;

    /* renamed from: f */
    private int f16563f;

    /* renamed from: g */
    private boolean f16564g;

    /* renamed from: h */
    private int f16565h;

    /* renamed from: i */
    private ByteBuffer f16566i;

    /* renamed from: j */
    private ByteBuffer f16567j;

    /* renamed from: k */
    private byte[] f16568k = C8509F.f18798f;

    /* renamed from: l */
    private int f16569l;

    /* renamed from: m */
    private boolean f16570m;

    /* renamed from: n */
    private long f16571n;

    public C8108A() {
        ByteBuffer byteBuffer = AudioProcessor.f16572a;
        this.f16566i = byteBuffer;
        this.f16567j = byteBuffer;
    }

    /* renamed from: a */
    public void mo25034a(int trimStartFrames, int trimEndFrames) {
        this.f16559b = trimStartFrames;
        this.f16560c = trimEndFrames;
    }

    /* renamed from: i */
    public void mo25046i() {
        this.f16571n = 0;
    }

    /* renamed from: h */
    public long mo25045h() {
        return this.f16571n;
    }

    /* renamed from: a */
    public boolean mo25037a(int sampleRateHz, int channelCount, int encoding) throws UnhandledFormatException {
        if (encoding == 2) {
            int i = this.f16569l;
            if (i > 0) {
                this.f16571n += (long) (i / this.f16563f);
            }
            this.f16561d = channelCount;
            this.f16562e = sampleRateHz;
            this.f16563f = C8509F.m20462b(2, channelCount);
            int i2 = this.f16560c;
            int i3 = this.f16563f;
            this.f16568k = new byte[(i2 * i3)];
            this.f16569l = 0;
            int i4 = this.f16559b;
            this.f16565h = i3 * i4;
            boolean wasActive = this.f16558a;
            this.f16558a = (i4 == 0 && i2 == 0) ? false : true;
            this.f16564g = false;
            if (wasActive != this.f16558a) {
                return true;
            }
            return false;
        }
        throw new UnhandledFormatException(sampleRateHz, channelCount, encoding);
    }

    /* renamed from: a */
    public boolean mo25036a() {
        return this.f16558a;
    }

    /* renamed from: d */
    public int mo25040d() {
        return this.f16561d;
    }

    /* renamed from: f */
    public int mo25042f() {
        return 2;
    }

    /* renamed from: e */
    public int mo25041e() {
        return this.f16562e;
    }

    /* renamed from: a */
    public void mo25035a(ByteBuffer inputBuffer) {
        int position = inputBuffer.position();
        int limit = inputBuffer.limit();
        int remaining = limit - position;
        if (remaining != 0) {
            this.f16564g = true;
            int trimBytes = Math.min(remaining, this.f16565h);
            this.f16571n += (long) (trimBytes / this.f16563f);
            this.f16565h -= trimBytes;
            inputBuffer.position(position + trimBytes);
            if (this.f16565h <= 0) {
                int remaining2 = remaining - trimBytes;
                int remainingBytesToOutput = (this.f16569l + remaining2) - this.f16568k.length;
                if (this.f16566i.capacity() < remainingBytesToOutput) {
                    this.f16566i = ByteBuffer.allocateDirect(remainingBytesToOutput).order(ByteOrder.nativeOrder());
                } else {
                    this.f16566i.clear();
                }
                int endBufferBytesToOutput = C8509F.m20433a(remainingBytesToOutput, 0, this.f16569l);
                this.f16566i.put(this.f16568k, 0, endBufferBytesToOutput);
                int inputBufferBytesToOutput = C8509F.m20433a(remainingBytesToOutput - endBufferBytesToOutput, 0, remaining2);
                inputBuffer.limit(inputBuffer.position() + inputBufferBytesToOutput);
                this.f16566i.put(inputBuffer);
                inputBuffer.limit(limit);
                int remaining3 = remaining2 - inputBufferBytesToOutput;
                this.f16569l -= endBufferBytesToOutput;
                byte[] bArr = this.f16568k;
                System.arraycopy(bArr, endBufferBytesToOutput, bArr, 0, this.f16569l);
                inputBuffer.get(this.f16568k, this.f16569l, remaining3);
                this.f16569l += remaining3;
                this.f16566i.flip();
                this.f16567j = this.f16566i;
            }
        }
    }

    /* renamed from: g */
    public void mo25044g() {
        this.f16570m = true;
    }

    /* renamed from: c */
    public ByteBuffer mo25039c() {
        ByteBuffer outputBuffer = this.f16567j;
        if (this.f16570m && this.f16569l > 0 && outputBuffer == AudioProcessor.f16572a) {
            int capacity = this.f16566i.capacity();
            int i = this.f16569l;
            if (capacity < i) {
                this.f16566i = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            } else {
                this.f16566i.clear();
            }
            this.f16566i.put(this.f16568k, 0, this.f16569l);
            this.f16569l = 0;
            this.f16566i.flip();
            outputBuffer = this.f16566i;
        }
        this.f16567j = AudioProcessor.f16572a;
        return outputBuffer;
    }

    /* renamed from: b */
    public boolean mo25038b() {
        return this.f16570m && this.f16569l == 0 && this.f16567j == AudioProcessor.f16572a;
    }

    public void flush() {
        this.f16567j = AudioProcessor.f16572a;
        this.f16570m = false;
        if (this.f16564g) {
            this.f16565h = 0;
        }
        this.f16569l = 0;
    }

    public void reset() {
        flush();
        this.f16566i = AudioProcessor.f16572a;
        this.f16561d = -1;
        this.f16562e = -1;
        this.f16568k = C8509F.f18798f;
    }
}
