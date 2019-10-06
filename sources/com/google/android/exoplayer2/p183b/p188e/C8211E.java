package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.p183b.C8267n;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.e.E */
/* compiled from: TsDurationReader */
final class C8211E {

    /* renamed from: a */
    private final C8506D f17163a = new C8506D(0);

    /* renamed from: b */
    private final C8535t f17164b = new C8535t();

    /* renamed from: c */
    private boolean f17165c;

    /* renamed from: d */
    private boolean f17166d;

    /* renamed from: e */
    private boolean f17167e;

    /* renamed from: f */
    private long f17168f = -9223372036854775807L;

    /* renamed from: g */
    private long f17169g = -9223372036854775807L;

    /* renamed from: h */
    private long f17170h = -9223372036854775807L;

    C8211E() {
    }

    /* renamed from: c */
    public boolean mo25295c() {
        return this.f17165c;
    }

    /* renamed from: a */
    public int mo25292a(C8261h input, C8267n seekPositionHolder, int pcrPid) throws IOException, InterruptedException {
        if (pcrPid <= 0) {
            return m18898a(input);
        }
        if (!this.f17167e) {
            return m18902c(input, seekPositionHolder, pcrPid);
        }
        if (this.f17169g == -9223372036854775807L) {
            return m18898a(input);
        }
        if (!this.f17166d) {
            return m18900b(input, seekPositionHolder, pcrPid);
        }
        long j = this.f17168f;
        if (j == -9223372036854775807L) {
            return m18898a(input);
        }
        this.f17170h = this.f17163a.mo26052b(this.f17169g) - this.f17163a.mo26052b(j);
        return m18898a(input);
    }

    /* renamed from: a */
    public long mo25293a() {
        return this.f17170h;
    }

    /* renamed from: b */
    public C8506D mo25294b() {
        return this.f17163a;
    }

    /* renamed from: a */
    private int m18898a(C8261h input) {
        this.f17164b.mo26108a(C8509F.f18798f);
        this.f17165c = true;
        input.mo25239a();
        return 0;
    }

    /* renamed from: b */
    private int m18900b(C8261h input, C8267n seekPositionHolder, int pcrPid) throws IOException, InterruptedException {
        int bytesToSearch = (int) Math.min(112800, input.getLength());
        if (input.getPosition() != ((long) 0)) {
            seekPositionHolder.f17510a = (long) 0;
            return 1;
        }
        this.f17164b.mo26114c(bytesToSearch);
        input.mo25239a();
        input.mo25241a(this.f17164b.f18861a, 0, bytesToSearch);
        this.f17168f = m18899a(this.f17164b, pcrPid);
        this.f17166d = true;
        return 0;
    }

    /* renamed from: a */
    private long m18899a(C8535t packetBuffer, int pcrPid) {
        int searchStartPosition = packetBuffer.mo26113c();
        int searchEndPosition = packetBuffer.mo26115d();
        for (int searchPosition = searchStartPosition; searchPosition < searchEndPosition; searchPosition++) {
            if (packetBuffer.f18861a[searchPosition] == 71) {
                long pcrValue = C8220H.m18951a(packetBuffer, searchPosition, pcrPid);
                if (pcrValue != -9223372036854775807L) {
                    return pcrValue;
                }
            }
        }
        return -9223372036854775807L;
    }

    /* renamed from: c */
    private int m18902c(C8261h input, C8267n seekPositionHolder, int pcrPid) throws IOException, InterruptedException {
        long inputLength = input.getLength();
        int bytesToSearch = (int) Math.min(112800, inputLength);
        long searchStartPosition = inputLength - ((long) bytesToSearch);
        if (input.getPosition() != searchStartPosition) {
            seekPositionHolder.f17510a = searchStartPosition;
            return 1;
        }
        this.f17164b.mo26114c(bytesToSearch);
        input.mo25239a();
        input.mo25241a(this.f17164b.f18861a, 0, bytesToSearch);
        this.f17169g = m18901b(this.f17164b, pcrPid);
        this.f17167e = true;
        return 0;
    }

    /* renamed from: b */
    private long m18901b(C8535t packetBuffer, int pcrPid) {
        int searchStartPosition = packetBuffer.mo26113c();
        for (int searchPosition = packetBuffer.mo26115d() - 1; searchPosition >= searchStartPosition; searchPosition--) {
            if (packetBuffer.f18861a[searchPosition] == 71) {
                long pcrValue = C8220H.m18951a(packetBuffer, searchPosition, pcrPid);
                if (pcrValue != -9223372036854775807L) {
                    return pcrValue;
                }
            }
        }
        return -9223372036854775807L;
    }
}
