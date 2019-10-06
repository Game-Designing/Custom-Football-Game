package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.p183b.C8271p;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8524l;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.d.d */
/* compiled from: FlacReader */
final class C8186d extends C8194k {
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C8524l f17057n;

    /* renamed from: o */
    private C8187a f17058o;

    /* renamed from: com.google.android.exoplayer2.b.d.d$a */
    /* compiled from: FlacReader */
    private class C8187a implements C8191h, C8268o {

        /* renamed from: a */
        private long[] f17059a;

        /* renamed from: b */
        private long[] f17060b;

        /* renamed from: c */
        private long f17061c = -1;

        /* renamed from: d */
        private long f17062d = -1;

        public C8187a() {
        }

        /* renamed from: d */
        public void mo25266d(long firstFrameOffset) {
            this.f17061c = firstFrameOffset;
        }

        /* renamed from: a */
        public void mo25265a(C8535t data) {
            data.mo26120f(1);
            int numberOfSeekPoints = data.mo26134t() / 18;
            this.f17059a = new long[numberOfSeekPoints];
            this.f17060b = new long[numberOfSeekPoints];
            for (int i = 0; i < numberOfSeekPoints; i++) {
                this.f17059a[i] = data.mo26127m();
                this.f17060b[i] = data.mo26127m();
                data.mo26120f(2);
            }
        }

        /* renamed from: a */
        public long mo25254a(C8261h input) throws IOException, InterruptedException {
            long j = this.f17062d;
            if (j < 0) {
                return -1;
            }
            long result = -(j + 2);
            this.f17062d = -1;
            return result;
        }

        /* renamed from: c */
        public long mo25260c(long timeUs) {
            long granule = C8186d.this.mo25278b(timeUs);
            this.f17062d = this.f17059a[C8509F.m20465b(this.f17059a, granule, true, true)];
            return granule;
        }

        /* renamed from: a */
        public C8268o mo25256a() {
            return this;
        }

        /* renamed from: d */
        public boolean mo25195d() {
            return true;
        }

        /* renamed from: a */
        public C8269a mo25192a(long timeUs) {
            long j = timeUs;
            int index = C8509F.m20465b(this.f17059a, C8186d.this.mo25278b(j), true, true);
            long seekTimeUs = C8186d.this.mo25275a(this.f17059a[index]);
            C8271p seekPoint = new C8271p(seekTimeUs, this.f17061c + this.f17060b[index]);
            if (seekTimeUs < j) {
                long[] jArr = this.f17059a;
                if (index != jArr.length - 1) {
                    return new C8269a(seekPoint, new C8271p(C8186d.this.mo25275a(jArr[index + 1]), this.f17061c + this.f17060b[index + 1]));
                }
            }
            return new C8269a(seekPoint);
        }

        /* renamed from: b */
        public long mo25193b() {
            return C8186d.this.f17057n.mo26087b();
        }
    }

    C8186d() {
    }

    /* renamed from: b */
    public static boolean m18811b(C8535t data) {
        return data.mo26104a() >= 5 && data.mo26131q() == 127 && data.mo26133s() == 1179402563;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25263a(boolean headerData) {
        super.mo25263a(headerData);
        if (headerData) {
            this.f17057n = null;
            this.f17058o = null;
        }
    }

    /* renamed from: a */
    private static boolean m18810a(byte[] data) {
        return data[0] == -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo25262a(C8535t packet) {
        if (!m18810a(packet.f18861a)) {
            return -1;
        }
        return (long) m18812c(packet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo25264a(C8535t packet, long position, C8195a setupData) throws IOException, InterruptedException {
        C8535t tVar = packet;
        C8195a aVar = setupData;
        byte[] data = tVar.f18861a;
        if (this.f17057n == null) {
            this.f17057n = new C8524l(data, 17);
            byte[] metadata = Arrays.copyOfRange(data, 9, packet.mo26115d());
            metadata[4] = Byte.MIN_VALUE;
            List<byte[]> initializationData = Collections.singletonList(metadata);
            int a = this.f17057n.mo26086a();
            C8524l lVar = this.f17057n;
            aVar.f17101a = Format.m18250a(null, "audio/flac", null, -1, a, lVar.f18826f, lVar.f18825e, initializationData, null, 0, null);
            long j = position;
        } else if ((data[0] & Byte.MAX_VALUE) == 3) {
            this.f17058o = new C8187a();
            this.f17058o.mo25265a(tVar);
            long j2 = position;
        } else if (m18810a(data)) {
            C8187a aVar2 = this.f17058o;
            if (aVar2 != null) {
                aVar2.mo25266d(position);
                aVar.f17102b = this.f17058o;
            } else {
                long j3 = position;
            }
            return false;
        } else {
            long j4 = position;
        }
        return true;
    }

    /* renamed from: c */
    private int m18812c(C8535t packet) {
        int blockSizeCode = (packet.f18861a[2] & 255) >> 4;
        switch (blockSizeCode) {
            case 1:
                return Opcodes.CHECKCAST;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (blockSizeCode - 2);
            case 6:
            case 7:
                packet.mo26120f(4);
                packet.mo26138x();
                int value = blockSizeCode == 6 ? packet.mo26131q() : packet.mo26137w();
                packet.mo26118e(0);
                return value + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return Opcodes.ACC_NATIVE << (blockSizeCode - 8);
            default:
                return -1;
        }
    }
}
