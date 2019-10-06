package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.util.h */
/* compiled from: CodecSpecificDataUtil */
public final class C8518h {

    /* renamed from: a */
    private static final byte[] f18813a = {0, 0, 0, 1};

    /* renamed from: b */
    private static final int[] f18814b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: c */
    private static final int[] f18815c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* renamed from: a */
    public static Pair<Integer, Integer> m20502a(byte[] audioSpecificConfig) throws ParserException {
        return m20501a(new C8534s(audioSpecificConfig), false);
    }

    /* renamed from: a */
    public static Pair<Integer, Integer> m20501a(C8534s bitArray, boolean forceReadToEnd) throws ParserException {
        int audioObjectType = m20500a(bitArray);
        int sampleRate = m20506b(bitArray);
        int channelConfiguration = bitArray.mo26092a(4);
        if (audioObjectType == 5 || audioObjectType == 29) {
            sampleRate = m20506b(bitArray);
            audioObjectType = m20500a(bitArray);
            if (audioObjectType == 22) {
                channelConfiguration = bitArray.mo26092a(4);
            }
        }
        boolean z = true;
        if (forceReadToEnd) {
            if (!(audioObjectType == 1 || audioObjectType == 2 || audioObjectType == 3 || audioObjectType == 4 || audioObjectType == 6 || audioObjectType == 7 || audioObjectType == 17)) {
                switch (audioObjectType) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported audio object type: ");
                        sb.append(audioObjectType);
                        throw new ParserException(sb.toString());
                }
            }
            m20503a(bitArray, audioObjectType, channelConfiguration);
            switch (audioObjectType) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int epConfig = bitArray.mo26092a(2);
                    if (epConfig == 2 || epConfig == 3) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unsupported epConfig: ");
                        sb2.append(epConfig);
                        throw new ParserException(sb2.toString());
                    }
            }
        }
        int channelCount = f18815c[channelConfiguration];
        if (channelCount == -1) {
            z = false;
        }
        C8514e.m20488a(z);
        return Pair.create(Integer.valueOf(sampleRate), Integer.valueOf(channelCount));
    }

    /* renamed from: a */
    public static byte[] m20504a(int audioObjectType, int sampleRateIndex, int channelConfig) {
        return new byte[]{(byte) (((audioObjectType << 3) & 248) | ((sampleRateIndex >> 1) & 7)), (byte) (((sampleRateIndex << 7) & 128) | ((channelConfig << 3) & Opcodes.ISHL))};
    }

    /* renamed from: b */
    public static String m20507b(int profileIdc, int constraintsFlagsAndReservedZero2Bits, int levelIdc) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(profileIdc), Integer.valueOf(constraintsFlagsAndReservedZero2Bits), Integer.valueOf(levelIdc)});
    }

    /* renamed from: a */
    public static byte[] m20505a(byte[] data, int offset, int length) {
        byte[] bArr = f18813a;
        byte[] nalUnit = new byte[(bArr.length + length)];
        System.arraycopy(bArr, 0, nalUnit, 0, bArr.length);
        System.arraycopy(data, offset, nalUnit, f18813a.length, length);
        return nalUnit;
    }

    /* renamed from: a */
    private static int m20500a(C8534s bitArray) {
        int audioObjectType = bitArray.mo26092a(5);
        if (audioObjectType == 31) {
            return bitArray.mo26092a(6) + 32;
        }
        return audioObjectType;
    }

    /* renamed from: b */
    private static int m20506b(C8534s bitArray) {
        int frequencyIndex = bitArray.mo26092a(4);
        if (frequencyIndex == 15) {
            return bitArray.mo26092a(24);
        }
        C8514e.m20488a(frequencyIndex < 13);
        return f18814b[frequencyIndex];
    }

    /* renamed from: a */
    private static void m20503a(C8534s bitArray, int audioObjectType, int channelConfiguration) {
        bitArray.mo26101c(1);
        if (bitArray.mo26102d()) {
            bitArray.mo26101c(14);
        }
        boolean extensionFlag = bitArray.mo26102d();
        if (channelConfiguration != 0) {
            if (audioObjectType == 6 || audioObjectType == 20) {
                bitArray.mo26101c(3);
            }
            if (extensionFlag) {
                if (audioObjectType == 22) {
                    bitArray.mo26101c(16);
                }
                if (audioObjectType == 17 || audioObjectType == 19 || audioObjectType == 20 || audioObjectType == 23) {
                    bitArray.mo26101c(3);
                }
                bitArray.mo26101c(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
}
