package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.b.d.f */
/* compiled from: OggPacket */
final class C8189f {

    /* renamed from: a */
    private final C8190g f17068a = new C8190g();

    /* renamed from: b */
    private final C8535t f17069b = new C8535t(new byte[65025], 0);

    /* renamed from: c */
    private int f17070c = -1;

    /* renamed from: d */
    private int f17071d;

    /* renamed from: e */
    private boolean f17072e;

    C8189f() {
    }

    /* renamed from: c */
    public void mo25270c() {
        this.f17068a.mo25272a();
        this.f17069b.mo26139y();
        this.f17070c = -1;
        this.f17072e = false;
    }

    /* renamed from: a */
    public boolean mo25268a(C8261h input) throws IOException, InterruptedException {
        C8514e.m20490b(input != null);
        if (this.f17072e) {
            this.f17072e = false;
            this.f17069b.mo26139y();
        }
        while (!this.f17072e) {
            if (this.f17070c < 0) {
                if (!this.f17068a.mo25273a(input, true)) {
                    return false;
                }
                int segmentIndex = 0;
                C8190g gVar = this.f17068a;
                int bytesToSkip = gVar.f17081i;
                if ((gVar.f17075c & 1) == 1 && this.f17069b.mo26115d() == 0) {
                    bytesToSkip += m18832a(0);
                    segmentIndex = 0 + this.f17071d;
                }
                input.mo25248c(bytesToSkip);
                this.f17070c = segmentIndex;
            }
            int size = m18832a(this.f17070c);
            int segmentIndex2 = this.f17070c + this.f17071d;
            if (size > 0) {
                if (this.f17069b.mo26111b() < this.f17069b.mo26115d() + size) {
                    C8535t tVar = this.f17069b;
                    tVar.f18861a = Arrays.copyOf(tVar.f18861a, tVar.mo26115d() + size);
                }
                C8535t tVar2 = this.f17069b;
                input.readFully(tVar2.f18861a, tVar2.mo26115d(), size);
                C8535t tVar3 = this.f17069b;
                tVar3.mo26116d(tVar3.mo26115d() + size);
                this.f17072e = this.f17068a.f17083k[segmentIndex2 + -1] != 255;
            }
            this.f17070c = segmentIndex2 == this.f17068a.f17080h ? -1 : segmentIndex2;
        }
        return true;
    }

    /* renamed from: a */
    public C8190g mo25267a() {
        return this.f17068a;
    }

    /* renamed from: b */
    public C8535t mo25269b() {
        return this.f17069b;
    }

    /* renamed from: d */
    public void mo25271d() {
        C8535t tVar = this.f17069b;
        byte[] bArr = tVar.f18861a;
        if (bArr.length != 65025) {
            tVar.f18861a = Arrays.copyOf(bArr, Math.max(65025, tVar.mo26115d()));
        }
    }

    /* renamed from: a */
    private int m18832a(int startSegmentIndex) {
        int segmentLength;
        this.f17071d = 0;
        int size = 0;
        do {
            int i = this.f17071d;
            int i2 = startSegmentIndex + i;
            C8190g gVar = this.f17068a;
            if (i2 >= gVar.f17080h) {
                break;
            }
            int[] iArr = gVar.f17083k;
            this.f17071d = i + 1;
            segmentLength = iArr[i + startSegmentIndex];
            size += segmentLength;
        } while (segmentLength == 255);
        return size;
    }
}
