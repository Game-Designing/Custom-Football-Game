package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor.UnhandledFormatException;
import com.google.android.exoplayer2.util.C8514e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.audio.p */
/* compiled from: ChannelMappingAudioProcessor */
final class C8135p implements AudioProcessor {

    /* renamed from: a */
    private int f16719a = -1;

    /* renamed from: b */
    private int f16720b = -1;

    /* renamed from: c */
    private int[] f16721c;

    /* renamed from: d */
    private boolean f16722d;

    /* renamed from: e */
    private int[] f16723e;

    /* renamed from: f */
    private ByteBuffer f16724f;

    /* renamed from: g */
    private ByteBuffer f16725g;

    /* renamed from: h */
    private boolean f16726h;

    public C8135p() {
        ByteBuffer byteBuffer = AudioProcessor.f16572a;
        this.f16724f = byteBuffer;
        this.f16725g = byteBuffer;
    }

    /* renamed from: a */
    public void mo25136a(int[] outputChannels) {
        this.f16721c = outputChannels;
    }

    /* renamed from: a */
    public boolean mo25037a(int sampleRateHz, int channelCount, int encoding) throws UnhandledFormatException {
        boolean outputChannelsChanged = !Arrays.equals(this.f16721c, this.f16723e);
        this.f16723e = this.f16721c;
        if (this.f16723e == null) {
            this.f16722d = false;
            return outputChannelsChanged;
        } else if (encoding != 2) {
            throw new UnhandledFormatException(sampleRateHz, channelCount, encoding);
        } else if (!outputChannelsChanged && this.f16720b == sampleRateHz && this.f16719a == channelCount) {
            return false;
        } else {
            this.f16720b = sampleRateHz;
            this.f16719a = channelCount;
            this.f16722d = channelCount != this.f16723e.length;
            int i = 0;
            while (true) {
                int[] iArr = this.f16723e;
                if (i >= iArr.length) {
                    return true;
                }
                int channelIndex = iArr[i];
                if (channelIndex < channelCount) {
                    this.f16722d |= channelIndex != i;
                    i++;
                } else {
                    throw new UnhandledFormatException(sampleRateHz, channelCount, encoding);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo25036a() {
        return this.f16722d;
    }

    /* renamed from: d */
    public int mo25040d() {
        int[] iArr = this.f16723e;
        return iArr == null ? this.f16719a : iArr.length;
    }

    /* renamed from: f */
    public int mo25042f() {
        return 2;
    }

    /* renamed from: e */
    public int mo25041e() {
        return this.f16720b;
    }

    /* renamed from: a */
    public void mo25035a(ByteBuffer inputBuffer) {
        C8514e.m20490b(this.f16723e != null);
        int position = inputBuffer.position();
        int limit = inputBuffer.limit();
        int outputSize = this.f16723e.length * ((limit - position) / (this.f16719a * 2)) * 2;
        if (this.f16724f.capacity() < outputSize) {
            this.f16724f = ByteBuffer.allocateDirect(outputSize).order(ByteOrder.nativeOrder());
        } else {
            this.f16724f.clear();
        }
        while (position < limit) {
            for (int channelIndex : this.f16723e) {
                this.f16724f.putShort(inputBuffer.getShort((channelIndex * 2) + position));
            }
            position += this.f16719a * 2;
        }
        inputBuffer.position(limit);
        this.f16724f.flip();
        this.f16725g = this.f16724f;
    }

    /* renamed from: g */
    public void mo25044g() {
        this.f16726h = true;
    }

    /* renamed from: c */
    public ByteBuffer mo25039c() {
        ByteBuffer outputBuffer = this.f16725g;
        this.f16725g = AudioProcessor.f16572a;
        return outputBuffer;
    }

    /* renamed from: b */
    public boolean mo25038b() {
        return this.f16726h && this.f16725g == AudioProcessor.f16572a;
    }

    public void flush() {
        this.f16725g = AudioProcessor.f16572a;
        this.f16726h = false;
    }

    public void reset() {
        flush();
        this.f16724f = AudioProcessor.f16572a;
        this.f16719a = -1;
        this.f16720b = -1;
        this.f16723e = null;
        this.f16721c = null;
        this.f16722d = false;
    }
}
