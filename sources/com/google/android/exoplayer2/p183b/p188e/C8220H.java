package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.e.H */
/* compiled from: TsUtil */
public final class C8220H {
    /* renamed from: a */
    public static int m18950a(byte[] data, int startPosition, int limitPosition) {
        int position = startPosition;
        while (position < limitPosition && data[position] != 71) {
            position++;
        }
        return position;
    }

    /* renamed from: a */
    public static long m18951a(C8535t packetBuffer, int startOfPacket, int pcrPid) {
        packetBuffer.mo26118e(startOfPacket);
        if (packetBuffer.mo26104a() < 5) {
            return -9223372036854775807L;
        }
        int tsPacketHeader = packetBuffer.mo26119f();
        if ((8388608 & tsPacketHeader) != 0 || ((2096896 & tsPacketHeader) >> 8) != pcrPid) {
            return -9223372036854775807L;
        }
        boolean pcrFlagSet = true;
        if (((tsPacketHeader & 32) != 0) && packetBuffer.mo26131q() >= 7 && packetBuffer.mo26104a() >= 7) {
            if ((packetBuffer.mo26131q() & 16) != 16) {
                pcrFlagSet = false;
            }
            if (pcrFlagSet) {
                byte[] pcrBytes = new byte[6];
                packetBuffer.mo26110a(pcrBytes, 0, pcrBytes.length);
                return m18952a(pcrBytes);
            }
        }
        return -9223372036854775807L;
    }

    /* renamed from: a */
    private static long m18952a(byte[] pcrBytes) {
        return ((((long) pcrBytes[0]) & 255) << 25) | ((((long) pcrBytes[1]) & 255) << 17) | ((((long) pcrBytes[2]) & 255) << 9) | ((((long) pcrBytes[3]) & 255) << 1) | ((255 & ((long) pcrBytes[4])) >> 7);
    }
}
