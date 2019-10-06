package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: com.google.android.exoplayer2.b.e.x */
/* compiled from: PsDurationReader */
final class C8250x {

    /* renamed from: a */
    private final C8506D f17447a = new C8506D(0);

    /* renamed from: b */
    private final C8535t f17448b = new C8535t();

    /* renamed from: c */
    private boolean f17449c;

    /* renamed from: d */
    private boolean f17450d;

    /* renamed from: e */
    private boolean f17451e;

    /* renamed from: f */
    private long f17452f = -9223372036854775807L;

    /* renamed from: g */
    private long f17453g = -9223372036854775807L;

    /* renamed from: h */
    private long f17454h = -9223372036854775807L;

    C8250x() {
    }

    /* renamed from: c */
    public boolean mo25335c() {
        return this.f17449c;
    }

    /* renamed from: b */
    public C8506D mo25334b() {
        return this.f17447a;
    }

    /* renamed from: a */
    public int mo25332a(C8261h input, C8267n seekPositionHolder) throws IOException, InterruptedException {
        if (!this.f17451e) {
            return m19125c(input, seekPositionHolder);
        }
        if (this.f17453g == -9223372036854775807L) {
            return m19118a(input);
        }
        if (!this.f17450d) {
            return m19122b(input, seekPositionHolder);
        }
        long j = this.f17452f;
        if (j == -9223372036854775807L) {
            return m19118a(input);
        }
        this.f17454h = this.f17447a.mo26052b(this.f17453g) - this.f17447a.mo26052b(j);
        return m19118a(input);
    }

    /* renamed from: a */
    public long mo25333a() {
        return this.f17454h;
    }

    /* renamed from: a */
    public static long m19120a(C8535t packetBuffer) {
        int originalPosition = packetBuffer.mo26113c();
        if (packetBuffer.mo26104a() < 9) {
            return -9223372036854775807L;
        }
        byte[] scrBytes = new byte[9];
        packetBuffer.mo26110a(scrBytes, 0, scrBytes.length);
        packetBuffer.mo26118e(originalPosition);
        if (!m19121a(scrBytes)) {
            return -9223372036854775807L;
        }
        return m19124b(scrBytes);
    }

    /* renamed from: a */
    private int m19118a(C8261h input) {
        this.f17448b.mo26108a(C8509F.f18798f);
        this.f17449c = true;
        input.mo25239a();
        return 0;
    }

    /* renamed from: b */
    private int m19122b(C8261h input, C8267n seekPositionHolder) throws IOException, InterruptedException {
        int bytesToSearch = (int) Math.min(20000, input.getLength());
        if (input.getPosition() != ((long) 0)) {
            seekPositionHolder.f17510a = (long) 0;
            return 1;
        }
        this.f17448b.mo26114c(bytesToSearch);
        input.mo25239a();
        input.mo25241a(this.f17448b.f18861a, 0, bytesToSearch);
        this.f17452f = m19123b(this.f17448b);
        this.f17450d = true;
        return 0;
    }

    /* renamed from: b */
    private long m19123b(C8535t packetBuffer) {
        int searchStartPosition = packetBuffer.mo26113c();
        int searchEndPosition = packetBuffer.mo26115d();
        for (int searchPosition = searchStartPosition; searchPosition < searchEndPosition - 3; searchPosition++) {
            if (m19119a(packetBuffer.f18861a, searchPosition) == 442) {
                packetBuffer.mo26118e(searchPosition + 4);
                long scrValue = m19120a(packetBuffer);
                if (scrValue != -9223372036854775807L) {
                    return scrValue;
                }
            }
        }
        return -9223372036854775807L;
    }

    /* renamed from: c */
    private int m19125c(C8261h input, C8267n seekPositionHolder) throws IOException, InterruptedException {
        long inputLength = input.getLength();
        int bytesToSearch = (int) Math.min(20000, inputLength);
        long searchStartPosition = inputLength - ((long) bytesToSearch);
        if (input.getPosition() != searchStartPosition) {
            seekPositionHolder.f17510a = searchStartPosition;
            return 1;
        }
        this.f17448b.mo26114c(bytesToSearch);
        input.mo25239a();
        input.mo25241a(this.f17448b.f18861a, 0, bytesToSearch);
        this.f17453g = m19126c(this.f17448b);
        this.f17451e = true;
        return 0;
    }

    /* renamed from: c */
    private long m19126c(C8535t packetBuffer) {
        int searchStartPosition = packetBuffer.mo26113c();
        for (int searchPosition = packetBuffer.mo26115d() - 4; searchPosition >= searchStartPosition; searchPosition--) {
            if (m19119a(packetBuffer.f18861a, searchPosition) == 442) {
                packetBuffer.mo26118e(searchPosition + 4);
                long scrValue = m19120a(packetBuffer);
                if (scrValue != -9223372036854775807L) {
                    return scrValue;
                }
            }
        }
        return -9223372036854775807L;
    }

    /* renamed from: a */
    private int m19119a(byte[] data, int position) {
        return ((data[position] & 255) << 24) | ((data[position + 1] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((data[position + 2] & 255) << 8) | (data[position + 3] & 255);
    }

    /* renamed from: a */
    private static boolean m19121a(byte[] scrBytes) {
        boolean z = false;
        if ((scrBytes[0] & 196) != 68 || (scrBytes[2] & 4) != 4 || (scrBytes[4] & 4) != 4 || (scrBytes[5] & 1) != 1) {
            return false;
        }
        if ((scrBytes[8] & 3) == 3) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static long m19124b(byte[] scrBytes) {
        return (((((long) scrBytes[0]) & 56) >> 3) << 30) | ((((long) scrBytes[0]) & 3) << 28) | ((((long) scrBytes[1]) & 255) << 20) | (((((long) scrBytes[2]) & 248) >> 3) << 15) | ((((long) scrBytes[2]) & 3) << 13) | ((((long) scrBytes[3]) & 255) << 5) | ((((long) scrBytes[4]) & 248) >> 3);
    }
}
