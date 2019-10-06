package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.e.q */
/* compiled from: Id3Reader */
public final class C8242q implements C8233l {

    /* renamed from: a */
    private final C8535t f17390a = new C8535t(10);

    /* renamed from: b */
    private C8272q f17391b;

    /* renamed from: c */
    private boolean f17392c;

    /* renamed from: d */
    private long f17393d;

    /* renamed from: e */
    private int f17394e;

    /* renamed from: f */
    private int f17395f;

    /* renamed from: a */
    public void mo25303a() {
        this.f17392c = false;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        idGenerator.mo25298a();
        this.f17391b = extractorOutput.mo25351a(idGenerator.mo25300c(), 4);
        this.f17391b.mo25340a(Format.m18253a(idGenerator.mo25299b(), "application/id3", (String) null, -1, (DrmInitData) null));
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        if ((flags & 4) != 0) {
            this.f17392c = true;
            this.f17393d = pesTimeUs;
            this.f17394e = 0;
            this.f17395f = 0;
        }
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) {
        if (this.f17392c) {
            int bytesAvailable = data.mo26104a();
            int i = this.f17395f;
            if (i < 10) {
                int headerBytesAvailable = Math.min(bytesAvailable, 10 - i);
                System.arraycopy(data.f18861a, data.mo26113c(), this.f17390a.f18861a, this.f17395f, headerBytesAvailable);
                if (this.f17395f + headerBytesAvailable == 10) {
                    this.f17390a.mo26118e(0);
                    if (73 == this.f17390a.mo26131q() && 68 == this.f17390a.mo26131q() && 51 == this.f17390a.mo26131q()) {
                        this.f17390a.mo26120f(3);
                        this.f17394e = this.f17390a.mo26130p() + 10;
                    } else {
                        C8526n.m20534d("Id3Reader", "Discarding invalid ID3 tag");
                        this.f17392c = false;
                        return;
                    }
                }
            }
            int bytesToWrite = Math.min(bytesAvailable, this.f17394e - this.f17395f);
            this.f17391b.mo25341a(data, bytesToWrite);
            this.f17395f += bytesToWrite;
        }
    }

    /* renamed from: b */
    public void mo25307b() {
        if (this.f17392c) {
            int i = this.f17394e;
            if (i != 0 && this.f17395f == i) {
                this.f17391b.mo25339a(this.f17393d, 1, i, 0, null);
                this.f17392c = false;
            }
        }
    }
}
