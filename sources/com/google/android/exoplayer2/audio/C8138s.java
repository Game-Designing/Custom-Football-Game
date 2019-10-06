package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.C8534s;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.audio.s */
/* compiled from: DtsUtil */
public final class C8138s {

    /* renamed from: a */
    private static final int[] f16731a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b */
    private static final int[] f16732b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c */
    private static final int[] f16733c = {64, 112, 128, Opcodes.CHECKCAST, 224, Opcodes.ACC_NATIVE, 384, 448, 512, 640, 768, 896, Opcodes.ACC_ABSTRACT, 1152, 1280, 1536, 1920, Opcodes.ACC_STRICT, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, Opcodes.ACC_SYNTHETIC, 6144, 7680};

    /* renamed from: a */
    public static boolean m18471a(int word) {
        return word == 2147385345 || word == -25230976 || word == 536864768 || word == -14745368;
    }

    /* renamed from: a */
    public static Format m18470a(byte[] frame, String trackId, String language, DrmInitData drmInitData) {
        C8534s frameBits = m18473c(frame);
        frameBits.mo26101c(60);
        int channelCount = f16731a[frameBits.mo26092a(6)];
        int sampleRate = f16732b[frameBits.mo26092a(4)];
        int rate = frameBits.mo26092a(5);
        int[] iArr = f16733c;
        int bitrate = rate >= iArr.length ? -1 : (iArr[rate] * 1000) / 2;
        frameBits.mo26101c(10);
        int i = rate;
        return Format.m18250a(trackId, "audio/vnd.dts", null, bitrate, -1, channelCount + (frameBits.mo26092a(2) > 0 ? 1 : 0), sampleRate, null, drmInitData, 0, language);
    }

    /* renamed from: b */
    public static int m18472b(byte[] data) {
        int nblks;
        byte b = data[0];
        if (b == -2) {
            nblks = ((data[5] & 1) << 6) | ((data[4] & 252) >> 2);
        } else if (b == -1) {
            nblks = ((data[4] & 7) << 4) | ((data[7] & 60) >> 2);
        } else if (b != 31) {
            nblks = ((data[4] & 1) << 6) | ((data[5] & 252) >> 2);
        } else {
            nblks = ((data[5] & 7) << 4) | ((data[6] & 60) >> 2);
        }
        return (nblks + 1) * 32;
    }

    /* renamed from: a */
    public static int m18468a(ByteBuffer buffer) {
        int nblks;
        int position = buffer.position();
        byte b = buffer.get(position);
        if (b == -2) {
            nblks = ((buffer.get(position + 5) & 1) << 6) | ((buffer.get(position + 4) & 252) >> 2);
        } else if (b == -1) {
            nblks = ((buffer.get(position + 4) & 7) << 4) | ((buffer.get(position + 7) & 60) >> 2);
        } else if (b != 31) {
            nblks = ((buffer.get(position + 4) & 1) << 6) | ((buffer.get(position + 5) & 252) >> 2);
        } else {
            nblks = ((buffer.get(position + 5) & 7) << 4) | ((buffer.get(position + 6) & 60) >> 2);
        }
        return (nblks + 1) * 32;
    }

    /* renamed from: a */
    public static int m18469a(byte[] data) {
        int fsize;
        boolean uses14BitPerWord = false;
        byte b = data[0];
        if (b == -2) {
            fsize = (((data[4] & 3) << 12) | ((data[7] & 255) << 4) | ((data[6] & 240) >> 4)) + 1;
        } else if (b == -1) {
            fsize = (((data[7] & 3) << 12) | ((data[6] & 255) << 4) | ((data[9] & 60) >> 2)) + 1;
            uses14BitPerWord = true;
        } else if (b != 31) {
            fsize = (((data[5] & 3) << 12) | ((data[6] & 255) << 4) | ((data[7] & 240) >> 4)) + 1;
        } else {
            fsize = (((data[6] & 3) << 12) | ((data[7] & 255) << 4) | ((data[8] & 60) >> 2)) + 1;
            uses14BitPerWord = true;
        }
        return uses14BitPerWord ? (fsize * 16) / 14 : fsize;
    }

    /* renamed from: c */
    private static C8534s m18473c(byte[] frameHeader) {
        if (frameHeader[0] == Byte.MAX_VALUE) {
            return new C8534s(frameHeader);
        }
        byte[] frameHeader2 = Arrays.copyOf(frameHeader, frameHeader.length);
        if (m18474d(frameHeader2)) {
            for (int i = 0; i < frameHeader2.length - 1; i += 2) {
                byte temp = frameHeader2[i];
                frameHeader2[i] = frameHeader2[i + 1];
                frameHeader2[i + 1] = temp;
            }
        }
        C8534s frameBits = new C8534s(frameHeader2);
        if (frameHeader2[0] == 31) {
            C8534s scratchBits = new C8534s(frameHeader2);
            while (scratchBits.mo26091a() >= 16) {
                scratchBits.mo26101c(2);
                frameBits.mo26093a(scratchBits.mo26092a(14), 14);
            }
        }
        frameBits.mo26095a(frameHeader2);
        return frameBits;
    }

    /* renamed from: d */
    private static boolean m18474d(byte[] frameHeader) {
        return frameHeader[0] == -2 || frameHeader[0] == -1;
    }
}
