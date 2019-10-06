package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.e.A */
/* compiled from: SectionReader */
public final class C8206A implements C8215G {

    /* renamed from: a */
    private final C8253z f17149a;

    /* renamed from: b */
    private final C8535t f17150b = new C8535t(32);

    /* renamed from: c */
    private int f17151c;

    /* renamed from: d */
    private int f17152d;

    /* renamed from: e */
    private boolean f17153e;

    /* renamed from: f */
    private boolean f17154f;

    public C8206A(C8253z reader) {
        this.f17149a = reader;
    }

    /* renamed from: a */
    public void mo25286a(C8506D timestampAdjuster, C8262i extractorOutput, C8219d idGenerator) {
        this.f17149a.mo25290a(timestampAdjuster, extractorOutput, idGenerator);
        this.f17154f = true;
    }

    /* renamed from: a */
    public void mo25285a() {
        this.f17154f = true;
    }

    /* renamed from: a */
    public void mo25287a(C8535t data, int flags) {
        boolean payloadUnitStartIndicator = (flags & 1) != 0;
        int payloadStartPosition = -1;
        if (payloadUnitStartIndicator) {
            payloadStartPosition = data.mo26113c() + data.mo26131q();
        }
        if (this.f17154f != 0) {
            if (payloadUnitStartIndicator) {
                this.f17154f = false;
                data.mo26118e(payloadStartPosition);
                this.f17152d = 0;
            } else {
                return;
            }
        }
        while (data.mo26104a() > 0) {
            int i = this.f17152d;
            if (i < 3) {
                if (i == 0) {
                    int tableId = data.mo26131q();
                    data.mo26118e(data.mo26113c() - 1);
                    if (tableId == 255) {
                        this.f17154f = true;
                        return;
                    }
                }
                int headerBytesToRead = Math.min(data.mo26104a(), 3 - this.f17152d);
                data.mo26110a(this.f17150b.f18861a, this.f17152d, headerBytesToRead);
                this.f17152d += headerBytesToRead;
                if (this.f17152d == 3) {
                    this.f17150b.mo26114c(3);
                    this.f17150b.mo26120f(1);
                    int secondHeaderByte = this.f17150b.mo26131q();
                    int thirdHeaderByte = this.f17150b.mo26131q();
                    this.f17153e = (secondHeaderByte & 128) != 0;
                    this.f17151c = (((secondHeaderByte & 15) << 8) | thirdHeaderByte) + 3;
                    int b = this.f17150b.mo26111b();
                    int i2 = this.f17151c;
                    if (b < i2) {
                        C8535t tVar = this.f17150b;
                        byte[] bytes = tVar.f18861a;
                        tVar.mo26114c(Math.min(4098, Math.max(i2, bytes.length * 2)));
                        System.arraycopy(bytes, 0, this.f17150b.f18861a, 0, 3);
                    }
                }
            } else {
                int bodyBytesToRead = Math.min(data.mo26104a(), this.f17151c - this.f17152d);
                data.mo26110a(this.f17150b.f18861a, this.f17152d, bodyBytesToRead);
                this.f17152d += bodyBytesToRead;
                int i3 = this.f17152d;
                int i4 = this.f17151c;
                if (i3 != i4) {
                    continue;
                } else {
                    if (!this.f17153e) {
                        this.f17150b.mo26114c(i4);
                    } else if (C8509F.m20436a(this.f17150b.f18861a, 0, i4, -1) != 0) {
                        this.f17154f = true;
                        return;
                    } else {
                        this.f17150b.mo26114c(this.f17151c - 4);
                    }
                    this.f17149a.mo25291a(this.f17150b);
                    this.f17152d = 0;
                }
            }
        }
    }
}
