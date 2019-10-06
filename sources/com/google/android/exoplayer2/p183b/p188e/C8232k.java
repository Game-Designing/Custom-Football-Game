package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8216a;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8535t;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.b.e.k */
/* compiled from: DvbSubtitleReader */
public final class C8232k implements C8233l {

    /* renamed from: a */
    private final List<C8216a> f17286a;

    /* renamed from: b */
    private final C8272q[] f17287b;

    /* renamed from: c */
    private boolean f17288c;

    /* renamed from: d */
    private int f17289d;

    /* renamed from: e */
    private int f17290e;

    /* renamed from: f */
    private long f17291f;

    public C8232k(List<C8216a> subtitleInfos) {
        this.f17286a = subtitleInfos;
        this.f17287b = new C8272q[subtitleInfos.size()];
    }

    /* renamed from: a */
    public void mo25303a() {
        this.f17288c = false;
    }

    /* renamed from: a */
    public void mo25305a(C8262i extractorOutput, C8219d idGenerator) {
        for (int i = 0; i < this.f17287b.length; i++) {
            C8216a subtitleInfo = (C8216a) this.f17286a.get(i);
            idGenerator.mo25298a();
            C8272q output = extractorOutput.mo25351a(idGenerator.mo25300c(), 3);
            output.mo25340a(Format.m18252a(idGenerator.mo25299b(), "application/dvbsubs", null, -1, 0, Collections.singletonList(subtitleInfo.f17202c), subtitleInfo.f17200a, null));
            this.f17287b[i] = output;
        }
    }

    /* renamed from: a */
    public void mo25304a(long pesTimeUs, int flags) {
        if ((flags & 4) != 0) {
            this.f17288c = true;
            this.f17291f = pesTimeUs;
            this.f17290e = 0;
            this.f17289d = 2;
        }
    }

    /* renamed from: b */
    public void mo25307b() {
        if (this.f17288c) {
            C8272q[] qVarArr = this.f17287b;
            int length = qVarArr.length;
            for (int i = 0; i < length; i++) {
                qVarArr[i].mo25339a(this.f17291f, 1, this.f17290e, 0, null);
            }
            this.f17288c = false;
        }
    }

    /* renamed from: a */
    public void mo25306a(C8535t data) {
        C8272q[] qVarArr;
        if (this.f17288c && (this.f17289d != 2 || m19016a(data, 32))) {
            if (this.f17289d != 1 || m19016a(data, 0)) {
                int dataPosition = data.mo26113c();
                int bytesAvailable = data.mo26104a();
                for (C8272q output : this.f17287b) {
                    data.mo26118e(dataPosition);
                    output.mo25341a(data, bytesAvailable);
                }
                this.f17290e += bytesAvailable;
            }
        }
    }

    /* renamed from: a */
    private boolean m19016a(C8535t data, int expectedValue) {
        if (data.mo26104a() == 0) {
            return false;
        }
        if (data.mo26131q() != expectedValue) {
            this.f17288c = false;
        }
        this.f17289d--;
        return this.f17288c;
    }
}
