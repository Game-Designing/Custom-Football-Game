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
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.e.D */
/* compiled from: TsBinarySearchSeeker */
final class C8209D extends C8148a {

    /* renamed from: com.google.android.exoplayer2.b.e.D$a */
    /* compiled from: TsBinarySearchSeeker */
    private static final class C8210a implements C8155g {

        /* renamed from: a */
        private final C8506D f17160a;

        /* renamed from: b */
        private final C8535t f17161b = new C8535t();

        /* renamed from: c */
        private final int f17162c;

        public C8210a(int pcrPid, C8506D pcrTimestampAdjuster) {
            this.f17162c = pcrPid;
            this.f17160a = pcrTimestampAdjuster;
        }

        /* renamed from: a */
        public C8154f mo25197a(C8261h input, long targetTimestamp, C8151c outputFrameHolder) throws IOException, InterruptedException {
            long inputPosition = input.getPosition();
            int bytesToSearch = (int) Math.min(112800, input.getLength() - inputPosition);
            this.f17161b.mo26114c(bytesToSearch);
            input.mo25241a(this.f17161b.f18861a, 0, bytesToSearch);
            return m18895a(this.f17161b, targetTimestamp, inputPosition);
        }

        /* renamed from: a */
        private C8154f m18895a(C8535t packetBuffer, long targetPcrTimeUs, long bufferStartOffset) {
            long endOfLastPacketPosition;
            int limit;
            C8535t tVar = packetBuffer;
            long j = bufferStartOffset;
            int limit2 = packetBuffer.mo26115d();
            long startOfLastPacketPosition = -1;
            long pcrValue = -1;
            long lastPcrTimeUsInRange = -9223372036854775807L;
            while (true) {
                if (packetBuffer.mo26104a() < 188) {
                    long j2 = startOfLastPacketPosition;
                    endOfLastPacketPosition = pcrValue;
                    break;
                }
                int startOfPacket = C8220H.m18950a(tVar.f18861a, packetBuffer.mo26113c(), limit2);
                int endOfPacket = startOfPacket + Opcodes.NEWARRAY;
                if (endOfPacket > limit2) {
                    int i = limit2;
                    long j3 = startOfLastPacketPosition;
                    endOfLastPacketPosition = pcrValue;
                    break;
                }
                long j4 = pcrValue;
                long pcrValue2 = C8220H.m18951a(tVar, startOfPacket, this.f17162c);
                if (pcrValue2 != -9223372036854775807L) {
                    long pcrTimeUs = this.f17160a.mo26052b(pcrValue2);
                    if (pcrTimeUs > targetPcrTimeUs) {
                        if (lastPcrTimeUsInRange == -9223372036854775807L) {
                            return C8154f.m18628a(pcrTimeUs, j);
                        }
                        return C8154f.m18627a(j + startOfLastPacketPosition);
                    } else if (pcrTimeUs + 100000 > targetPcrTimeUs) {
                        int i2 = limit2;
                        long j5 = startOfLastPacketPosition;
                        return C8154f.m18627a(((long) startOfPacket) + j);
                    } else {
                        limit = limit2;
                        long j6 = startOfLastPacketPosition;
                        startOfLastPacketPosition = (long) startOfPacket;
                        lastPcrTimeUsInRange = pcrTimeUs;
                    }
                } else {
                    limit = limit2;
                    long j7 = startOfLastPacketPosition;
                }
                tVar.mo26118e(endOfPacket);
                pcrValue = (long) endOfPacket;
                limit2 = limit;
            }
            if (lastPcrTimeUsInRange != -9223372036854775807L) {
                return C8154f.m18630b(lastPcrTimeUsInRange, j + endOfLastPacketPosition);
            }
            return C8154f.f16835a;
        }

        /* renamed from: a */
        public void mo25198a() {
            this.f17161b.mo26108a(C8509F.f18798f);
        }
    }

    public C8209D(C8506D pcrTimestampAdjuster, long streamDurationUs, long inputLength, int pcrPid) {
        long j = streamDurationUs;
        super(new C8150b(), new C8210a(pcrPid, pcrTimestampAdjuster), j, 0, streamDurationUs + 1, 0, inputLength, 188, 940);
    }
}
