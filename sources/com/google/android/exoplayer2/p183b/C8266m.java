package com.google.android.exoplayer2.p183b;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.m */
/* compiled from: MpegAudioHeader */
public final class C8266m {

    /* renamed from: a */
    private static final String[] f17496a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b */
    private static final int[] f17497b = {44100, 48000, 32000};

    /* renamed from: c */
    private static final int[] f17498c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d */
    private static final int[] f17499d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e */
    private static final int[] f17500e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f */
    private static final int[] f17501f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: g */
    private static final int[] f17502g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* renamed from: h */
    public int f17503h;

    /* renamed from: i */
    public String f17504i;

    /* renamed from: j */
    public int f17505j;

    /* renamed from: k */
    public int f17506k;

    /* renamed from: l */
    public int f17507l;

    /* renamed from: m */
    public int f17508m;

    /* renamed from: n */
    public int f17509n;

    /* renamed from: a */
    public static int m19191a(int header) {
        if ((header & -2097152) != -2097152) {
            return -1;
        }
        int version = (header >>> 19) & 3;
        if (version == 1) {
            return -1;
        }
        int layer = (header >>> 17) & 3;
        if (layer == 0) {
            return -1;
        }
        int bitrateIndex = (header >>> 12) & 15;
        if (bitrateIndex == 0 || bitrateIndex == 15) {
            return -1;
        }
        int samplingRateIndex = (header >>> 10) & 3;
        if (samplingRateIndex == 3) {
            return -1;
        }
        int samplingRate = f17497b[samplingRateIndex];
        if (version == 2) {
            samplingRate /= 2;
        } else if (version == 0) {
            samplingRate /= 4;
        }
        int padding = (header >>> 9) & 1;
        if (layer == 3) {
            return ((((version == 3 ? f17498c[bitrateIndex - 1] : f17499d[bitrateIndex - 1]) * 12) / samplingRate) + padding) * 4;
        }
        int bitrate = version == 3 ? layer == 2 ? f17500e[bitrateIndex - 1] : f17501f[bitrateIndex - 1] : f17502g[bitrateIndex - 1];
        if (version == 3) {
            return ((bitrate * Opcodes.D2F) / samplingRate) + padding;
        }
        return (((layer == 1 ? 72 : Opcodes.D2F) * bitrate) / samplingRate) + padding;
    }

    /* renamed from: a */
    public static boolean m19193a(int headerData, C8266m header) {
        int samplesPerFrame;
        int frameSize;
        if ((headerData & -2097152) != -2097152) {
            return false;
        }
        int version = (headerData >>> 19) & 3;
        if (version == 1) {
            return false;
        }
        int layer = (headerData >>> 17) & 3;
        if (layer == 0) {
            return false;
        }
        int bitrateIndex = (headerData >>> 12) & 15;
        if (bitrateIndex == 0 || bitrateIndex == 15) {
            return false;
        }
        int samplingRateIndex = (headerData >>> 10) & 3;
        if (samplingRateIndex == 3) {
            return false;
        }
        int sampleRate = f17497b[samplingRateIndex];
        if (version == 2) {
            sampleRate /= 2;
        } else if (version == 0) {
            sampleRate /= 4;
        }
        int padding = (headerData >>> 9) & 1;
        if (layer == 3) {
            frameSize = ((((version == 3 ? f17498c[bitrateIndex - 1] : f17499d[bitrateIndex - 1]) * 12) / sampleRate) + padding) * 4;
            samplesPerFrame = 384;
        } else if (version == 3) {
            samplesPerFrame = 1152;
            frameSize = (((layer == 2 ? f17500e[bitrateIndex - 1] : f17501f[bitrateIndex - 1]) * Opcodes.D2F) / sampleRate) + padding;
        } else {
            samplesPerFrame = layer == 1 ? 576 : 1152;
            frameSize = (((layer == 1 ? 72 : Opcodes.D2F) * f17502g[bitrateIndex - 1]) / sampleRate) + padding;
        }
        header.m19192a(version, f17496a[3 - layer], frameSize, sampleRate, ((headerData >> 6) & 3) == 3 ? 1 : 2, ((frameSize * 8) * sampleRate) / samplesPerFrame, samplesPerFrame);
        return true;
    }

    /* renamed from: a */
    private void m19192a(int version, String mimeType, int frameSize, int sampleRate, int channels, int bitrate, int samplesPerFrame) {
        this.f17503h = version;
        this.f17504i = mimeType;
        this.f17505j = frameSize;
        this.f17506k = sampleRate;
        this.f17507l = channels;
        this.f17508m = bitrate;
        this.f17509n = samplesPerFrame;
    }
}
