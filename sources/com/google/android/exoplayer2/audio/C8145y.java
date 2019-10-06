package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.C8514e;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.audio.y */
/* compiled from: Sonic */
final class C8145y {

    /* renamed from: a */
    private final int f16780a;

    /* renamed from: b */
    private final int f16781b;

    /* renamed from: c */
    private final float f16782c;

    /* renamed from: d */
    private final float f16783d;

    /* renamed from: e */
    private final float f16784e;

    /* renamed from: f */
    private final int f16785f;

    /* renamed from: g */
    private final int f16786g;

    /* renamed from: h */
    private final int f16787h = (this.f16786g * 2);

    /* renamed from: i */
    private final short[] f16788i;

    /* renamed from: j */
    private short[] f16789j;

    /* renamed from: k */
    private int f16790k;

    /* renamed from: l */
    private short[] f16791l;

    /* renamed from: m */
    private int f16792m;

    /* renamed from: n */
    private short[] f16793n;

    /* renamed from: o */
    private int f16794o;

    /* renamed from: p */
    private int f16795p;

    /* renamed from: q */
    private int f16796q;

    /* renamed from: r */
    private int f16797r;

    /* renamed from: s */
    private int f16798s;

    /* renamed from: t */
    private int f16799t;

    /* renamed from: u */
    private int f16800u;

    /* renamed from: v */
    private int f16801v;

    public C8145y(int inputSampleRateHz, int channelCount, float speed, float pitch, int outputSampleRateHz) {
        this.f16780a = inputSampleRateHz;
        this.f16781b = channelCount;
        this.f16782c = speed;
        this.f16783d = pitch;
        this.f16784e = ((float) inputSampleRateHz) / ((float) outputSampleRateHz);
        this.f16785f = inputSampleRateHz / 400;
        this.f16786g = inputSampleRateHz / 65;
        int i = this.f16787h;
        this.f16788i = new short[i];
        this.f16789j = new short[(i * channelCount)];
        this.f16791l = new short[(i * channelCount)];
        this.f16793n = new short[(i * channelCount)];
    }

    /* renamed from: b */
    public void mo25175b(ShortBuffer buffer) {
        int remaining = buffer.remaining();
        int i = this.f16781b;
        int framesToWrite = remaining / i;
        int bytesToWrite = i * framesToWrite * 2;
        this.f16789j = m18568c(this.f16789j, this.f16790k, framesToWrite);
        buffer.get(this.f16789j, this.f16790k * this.f16781b, bytesToWrite / 2);
        this.f16790k += framesToWrite;
        m18569d();
    }

    /* renamed from: a */
    public void mo25173a(ShortBuffer buffer) {
        int framesToRead = Math.min(buffer.remaining() / this.f16781b, this.f16792m);
        buffer.put(this.f16791l, 0, this.f16781b * framesToRead);
        this.f16792m -= framesToRead;
        short[] sArr = this.f16791l;
        int i = this.f16781b;
        System.arraycopy(sArr, framesToRead * i, sArr, 0, this.f16792m * i);
    }

    /* renamed from: c */
    public void mo25176c() {
        int i;
        int remainingFrameCount = this.f16790k;
        float f = this.f16782c;
        float f2 = this.f16783d;
        float r = this.f16784e * f2;
        int expectedOutputFrames = this.f16792m + ((int) ((((((float) remainingFrameCount) / (f / f2)) + ((float) this.f16794o)) / r) + 0.5f));
        this.f16789j = m18568c(this.f16789j, this.f16790k, (this.f16787h * 2) + remainingFrameCount);
        int xSample = 0;
        while (true) {
            i = this.f16787h;
            int i2 = i * 2;
            int i3 = this.f16781b;
            if (xSample >= i2 * i3) {
                break;
            }
            this.f16789j[(i3 * remainingFrameCount) + xSample] = 0;
            xSample++;
        }
        this.f16790k += i * 2;
        m18569d();
        if (this.f16792m > expectedOutputFrames) {
            this.f16792m = expectedOutputFrames;
        }
        this.f16790k = 0;
        this.f16797r = 0;
        this.f16794o = 0;
    }

    /* renamed from: a */
    public void mo25172a() {
        this.f16790k = 0;
        this.f16792m = 0;
        this.f16794o = 0;
        this.f16795p = 0;
        this.f16796q = 0;
        this.f16797r = 0;
        this.f16798s = 0;
        this.f16799t = 0;
        this.f16800u = 0;
        this.f16801v = 0;
    }

    /* renamed from: b */
    public int mo25174b() {
        return this.f16792m;
    }

    /* renamed from: c */
    private short[] m18568c(short[] buffer, int frameCount, int additionalFrameCount) {
        int length = buffer.length;
        int i = this.f16781b;
        int currentCapacityFrames = length / i;
        if (frameCount + additionalFrameCount <= currentCapacityFrames) {
            return buffer;
        }
        return Arrays.copyOf(buffer, i * (((currentCapacityFrames * 3) / 2) + additionalFrameCount));
    }

    /* renamed from: d */
    private void m18570d(int positionFrames) {
        int remainingFrames = this.f16790k - positionFrames;
        short[] sArr = this.f16789j;
        int i = this.f16781b;
        System.arraycopy(sArr, positionFrames * i, sArr, 0, i * remainingFrames);
        this.f16790k = remainingFrames;
    }

    /* renamed from: a */
    private void m18561a(short[] samples, int positionFrames, int frameCount) {
        this.f16791l = m18568c(this.f16791l, this.f16792m, frameCount);
        int i = this.f16781b;
        System.arraycopy(samples, positionFrames * i, this.f16791l, this.f16792m * i, i * frameCount);
        this.f16792m += frameCount;
    }

    /* renamed from: a */
    private int m18554a(int positionFrames) {
        int frameCount = Math.min(this.f16787h, this.f16797r);
        m18561a(this.f16789j, positionFrames, frameCount);
        this.f16797r -= frameCount;
        return frameCount;
    }

    /* renamed from: b */
    private void m18566b(short[] samples, int position, int skip) {
        int frameCount = this.f16787h / skip;
        int i = this.f16781b;
        int samplesPerValue = i * skip;
        int position2 = position * i;
        for (int i2 = 0; i2 < frameCount; i2++) {
            int value = 0;
            for (int j = 0; j < samplesPerValue; j++) {
                value += samples[(i2 * samplesPerValue) + position2 + j];
            }
            this.f16788i[i2] = (short) (value / samplesPerValue);
        }
    }

    /* renamed from: a */
    private int m18557a(short[] samples, int position, int minPeriod, int maxPeriod) {
        int bestPeriod = 0;
        int worstPeriod = 255;
        int minDiff = 1;
        int maxDiff = 0;
        int position2 = position * this.f16781b;
        for (int period = minPeriod; period <= maxPeriod; period++) {
            int diff = 0;
            for (int i = 0; i < period; i++) {
                diff += Math.abs(samples[position2 + i] - samples[(position2 + period) + i]);
            }
            if (diff * bestPeriod < minDiff * period) {
                minDiff = diff;
                bestPeriod = period;
            }
            if (diff * worstPeriod > maxDiff * period) {
                maxDiff = diff;
                worstPeriod = period;
            }
        }
        this.f16800u = minDiff / bestPeriod;
        this.f16801v = maxDiff / worstPeriod;
        return bestPeriod;
    }

    /* renamed from: a */
    private boolean m18562a(int minDiff, int maxDiff) {
        if (minDiff == 0 || this.f16798s == 0 || maxDiff > minDiff * 3 || minDiff * 2 <= this.f16799t * 3) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private int m18555a(short[] samples, int position) {
        int period;
        int retPeriod;
        int i = this.f16780a;
        int skip = i > 4000 ? i / 4000 : 1;
        if (this.f16781b == 1 && skip == 1) {
            period = m18557a(samples, position, this.f16785f, this.f16786g);
        } else {
            m18566b(samples, position, skip);
            period = m18557a(this.f16788i, 0, this.f16785f / skip, this.f16786g / skip);
            if (skip != 1) {
                int period2 = period * skip;
                int minP = period2 - (skip * 4);
                int maxP = (skip * 4) + period2;
                if (minP < this.f16785f) {
                    minP = this.f16785f;
                }
                if (maxP > this.f16786g) {
                    maxP = this.f16786g;
                }
                if (this.f16781b == 1) {
                    period = m18557a(samples, position, minP, maxP);
                } else {
                    m18566b(samples, position, 1);
                    period = m18557a(this.f16788i, 0, minP, maxP);
                }
            }
        }
        if (m18562a(this.f16800u, this.f16801v)) {
            retPeriod = this.f16798s;
        } else {
            retPeriod = period;
        }
        this.f16799t = this.f16800u;
        this.f16798s = period;
        return retPeriod;
    }

    /* renamed from: b */
    private void m18565b(int originalOutputFrameCount) {
        int frameCount = this.f16792m - originalOutputFrameCount;
        this.f16793n = m18568c(this.f16793n, this.f16794o, frameCount);
        short[] sArr = this.f16791l;
        int i = this.f16781b;
        System.arraycopy(sArr, originalOutputFrameCount * i, this.f16793n, this.f16794o * i, i * frameCount);
        this.f16792m = originalOutputFrameCount;
        this.f16794o += frameCount;
    }

    /* renamed from: c */
    private void m18567c(int frameCount) {
        if (frameCount != 0) {
            short[] sArr = this.f16793n;
            int i = this.f16781b;
            System.arraycopy(sArr, frameCount * i, sArr, 0, (this.f16794o - frameCount) * i);
            this.f16794o -= frameCount;
        }
    }

    /* renamed from: b */
    private short m18564b(short[] in, int inPos, int oldSampleRate, int newSampleRate) {
        short left = in[inPos];
        short right = in[this.f16781b + inPos];
        int position = this.f16796q * oldSampleRate;
        int i = this.f16795p;
        int leftPosition = i * newSampleRate;
        int rightPosition = (i + 1) * newSampleRate;
        int ratio = rightPosition - position;
        int width = rightPosition - leftPosition;
        return (short) (((ratio * left) + ((width - ratio) * right)) / width);
    }

    /* renamed from: a */
    private void m18559a(float rate, int originalOutputFrameCount) {
        int i;
        int i2;
        if (this.f16792m != originalOutputFrameCount) {
            int newSampleRate = (int) (((float) this.f16780a) / rate);
            int oldSampleRate = this.f16780a;
            while (true) {
                if (newSampleRate <= 16384 && oldSampleRate <= 16384) {
                    break;
                }
                newSampleRate /= 2;
                oldSampleRate /= 2;
            }
            m18565b(originalOutputFrameCount);
            int position = 0;
            while (true) {
                int i3 = this.f16794o;
                boolean z = true;
                if (position < i3 - 1) {
                    while (true) {
                        i = this.f16795p;
                        int i4 = (i + 1) * newSampleRate;
                        i2 = this.f16796q;
                        if (i4 <= i2 * oldSampleRate) {
                            break;
                        }
                        this.f16791l = m18568c(this.f16791l, this.f16792m, 1);
                        int i5 = 0;
                        while (true) {
                            int i6 = this.f16781b;
                            if (i5 >= i6) {
                                break;
                            }
                            this.f16791l[(this.f16792m * i6) + i5] = m18564b(this.f16793n, (i6 * position) + i5, oldSampleRate, newSampleRate);
                            i5++;
                        }
                        this.f16796q++;
                        this.f16792m++;
                    }
                    this.f16795p = i + 1;
                    if (this.f16795p == oldSampleRate) {
                        this.f16795p = 0;
                        if (i2 != newSampleRate) {
                            z = false;
                        }
                        C8514e.m20490b(z);
                        this.f16796q = 0;
                    }
                    position++;
                } else {
                    m18567c(i3 - 1);
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private int m18563b(short[] samples, int position, float speed, int period) {
        int newFrameCount;
        if (speed >= 2.0f) {
            newFrameCount = (int) (((float) period) / (speed - 1.0f));
        } else {
            int newFrameCount2 = period;
            this.f16797r = (int) ((((float) period) * (2.0f - speed)) / (speed - 1.0f));
            newFrameCount = newFrameCount2;
        }
        this.f16791l = m18568c(this.f16791l, this.f16792m, newFrameCount);
        m18560a(newFrameCount, this.f16781b, this.f16791l, this.f16792m, samples, position, samples, position + period);
        this.f16792m += newFrameCount;
        return newFrameCount;
    }

    /* renamed from: a */
    private int m18556a(short[] samples, int position, float speed, int period) {
        int newFrameCount;
        if (speed < 0.5f) {
            newFrameCount = (int) ((((float) period) * speed) / (1.0f - speed));
        } else {
            int newFrameCount2 = period;
            this.f16797r = (int) ((((float) period) * ((2.0f * speed) - 1.0f)) / (1.0f - speed));
            newFrameCount = newFrameCount2;
        }
        this.f16791l = m18568c(this.f16791l, this.f16792m, period + newFrameCount);
        int i = this.f16781b;
        System.arraycopy(samples, position * i, this.f16791l, this.f16792m * i, i * period);
        m18560a(newFrameCount, this.f16781b, this.f16791l, this.f16792m + period, samples, position + period, samples, position);
        this.f16792m += period + newFrameCount;
        return newFrameCount;
    }

    /* renamed from: a */
    private void m18558a(float speed) {
        if (this.f16790k >= this.f16787h) {
            int frameCount = this.f16790k;
            int positionFrames = 0;
            do {
                if (this.f16797r > 0) {
                    positionFrames += m18554a(positionFrames);
                } else {
                    int period = m18555a(this.f16789j, positionFrames);
                    if (((double) speed) > 1.0d) {
                        positionFrames += m18563b(this.f16789j, positionFrames, speed, period) + period;
                    } else {
                        positionFrames += m18556a(this.f16789j, positionFrames, speed, period);
                    }
                }
            } while (this.f16787h + positionFrames <= frameCount);
            m18570d(positionFrames);
        }
    }

    /* renamed from: d */
    private void m18569d() {
        int originalOutputFrameCount = this.f16792m;
        float f = this.f16782c;
        float f2 = this.f16783d;
        float s = f / f2;
        float r = this.f16784e * f2;
        if (((double) s) > 1.00001d || ((double) s) < 0.99999d) {
            m18558a(s);
        } else {
            m18561a(this.f16789j, 0, this.f16790k);
            this.f16790k = 0;
        }
        if (r != 1.0f) {
            m18559a(r, originalOutputFrameCount);
        }
    }

    /* renamed from: a */
    private static void m18560a(int frameCount, int channelCount, short[] out, int outPosition, short[] rampDown, int rampDownPosition, short[] rampUp, int rampUpPosition) {
        for (int i = 0; i < channelCount; i++) {
            int o = (outPosition * channelCount) + i;
            int u = (rampUpPosition * channelCount) + i;
            int d = (rampDownPosition * channelCount) + i;
            for (int t = 0; t < frameCount; t++) {
                out[o] = (short) (((rampDown[d] * (frameCount - t)) + (rampUp[u] * t)) / frameCount);
                o += channelCount;
                d += channelCount;
                u += channelCount;
            }
        }
    }
}
