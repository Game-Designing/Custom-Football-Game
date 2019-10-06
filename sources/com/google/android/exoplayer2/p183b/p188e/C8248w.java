package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.p183b.C8148a;
import com.google.android.exoplayer2.p183b.C8148a.C8150b;
import com.google.android.exoplayer2.p183b.C8148a.C8151c;
import com.google.android.exoplayer2.p183b.C8148a.C8154f;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: com.google.android.exoplayer2.b.e.w */
/* compiled from: PsBinarySearchSeeker */
final class C8248w extends C8148a {

    /* renamed from: com.google.android.exoplayer2.b.e.w$a */
    /* compiled from: PsBinarySearchSeeker */
    private static final class C8249a implements C8155g {

        /* renamed from: a */
        private final C8506D f17445a;

        /* renamed from: b */
        private final C8535t f17446b;

        private C8249a(C8506D scrTimestampAdjuster) {
            this.f17445a = scrTimestampAdjuster;
            this.f17446b = new C8535t();
        }

        /* renamed from: a */
        public C8154f mo25197a(C8261h input, long targetTimestamp, C8151c outputFrameHolder) throws IOException, InterruptedException {
            long inputPosition = input.getPosition();
            int bytesToSearch = (int) Math.min(20000, input.getLength() - inputPosition);
            this.f17446b.mo26114c(bytesToSearch);
            input.mo25241a(this.f17446b.f18861a, 0, bytesToSearch);
            return m19114a(this.f17446b, targetTimestamp, inputPosition);
        }

        /* renamed from: a */
        public void mo25198a() {
            this.f17446b.mo26108a(C8509F.f18798f);
        }

        /* renamed from: a */
        private C8154f m19114a(C8535t packetBuffer, long targetScrTimeUs, long bufferStartOffset) {
            C8535t tVar = packetBuffer;
            long j = bufferStartOffset;
            int startOfLastPacketPosition = -1;
            int endOfLastPacketPosition = -1;
            long lastScrTimeUsInRange = -9223372036854775807L;
            while (packetBuffer.mo26104a() >= 4) {
                if (C8248w.m19113b(tVar.f18861a, packetBuffer.mo26113c()) != 442) {
                    tVar.mo26120f(1);
                } else {
                    tVar.mo26120f(4);
                    long scrValue = C8250x.m19120a(packetBuffer);
                    if (scrValue != -9223372036854775807L) {
                        long scrTimeUs = this.f17445a.mo26052b(scrValue);
                        if (scrTimeUs > targetScrTimeUs) {
                            if (lastScrTimeUsInRange == -9223372036854775807L) {
                                return C8154f.m18628a(scrTimeUs, j);
                            }
                            return C8154f.m18627a(((long) startOfLastPacketPosition) + j);
                        } else if (100000 + scrTimeUs > targetScrTimeUs) {
                            return C8154f.m18627a(((long) packetBuffer.mo26113c()) + j);
                        } else {
                            lastScrTimeUsInRange = scrTimeUs;
                            startOfLastPacketPosition = packetBuffer.mo26113c();
                        }
                    }
                    m19115a(packetBuffer);
                    endOfLastPacketPosition = packetBuffer.mo26113c();
                }
            }
            if (lastScrTimeUsInRange != -9223372036854775807L) {
                return C8154f.m18630b(lastScrTimeUsInRange, ((long) endOfLastPacketPosition) + j);
            }
            return C8154f.f16835a;
        }

        /* renamed from: a */
        private static void m19115a(C8535t packetBuffer) {
            int limit = packetBuffer.mo26115d();
            if (packetBuffer.mo26104a() < 10) {
                packetBuffer.mo26118e(limit);
                return;
            }
            packetBuffer.mo26120f(9);
            int packStuffingLength = packetBuffer.mo26131q() & 7;
            if (packetBuffer.mo26104a() < packStuffingLength) {
                packetBuffer.mo26118e(limit);
                return;
            }
            packetBuffer.mo26120f(packStuffingLength);
            if (packetBuffer.mo26104a() < 4) {
                packetBuffer.mo26118e(limit);
                return;
            }
            if (C8248w.m19113b(packetBuffer.f18861a, packetBuffer.mo26113c()) == 443) {
                packetBuffer.mo26120f(4);
                int systemHeaderLength = packetBuffer.mo26137w();
                if (packetBuffer.mo26104a() < systemHeaderLength) {
                    packetBuffer.mo26118e(limit);
                    return;
                }
                packetBuffer.mo26120f(systemHeaderLength);
            }
            while (packetBuffer.mo26104a() >= 4) {
                int nextStartCode = C8248w.m19113b(packetBuffer.f18861a, packetBuffer.mo26113c());
                if (nextStartCode == 442 || nextStartCode == 441 || (nextStartCode >>> 8) != 1) {
                    break;
                }
                packetBuffer.mo26120f(4);
                if (packetBuffer.mo26104a() < 2) {
                    packetBuffer.mo26118e(limit);
                    return;
                } else {
                    packetBuffer.mo26118e(Math.min(packetBuffer.mo26115d(), packetBuffer.mo26113c() + packetBuffer.mo26137w()));
                }
            }
        }
    }

    public C8248w(C8506D scrTimestampAdjuster, long streamDurationUs, long inputLength) {
        super(new C8150b(), new C8249a(scrTimestampAdjuster), streamDurationUs, 0, streamDurationUs + 1, 0, inputLength, 188, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m19113b(byte[] data, int position) {
        return ((data[position] & 255) << 24) | ((data[position + 1] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((data[position + 2] & 255) << 8) | (data[position + 3] & 255);
    }
}
