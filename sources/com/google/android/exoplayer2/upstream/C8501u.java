package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.C8514e;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.upstream.u */
/* compiled from: TeeDataSource */
public final class C8501u implements C8487i {

    /* renamed from: a */
    private final C8487i f18773a;

    /* renamed from: b */
    private final C8485g f18774b;

    /* renamed from: c */
    private boolean f18775c;

    /* renamed from: d */
    private long f18776d;

    public C8501u(C8487i upstream, C8485g dataSink) {
        C8514e.m20486a(upstream);
        this.f18773a = upstream;
        C8514e.m20486a(dataSink);
        this.f18774b = dataSink;
    }

    /* renamed from: a */
    public void mo25955a(C8502v transferListener) {
        this.f18773a.mo25955a(transferListener);
    }

    /* renamed from: a */
    public long mo25917a(C8489j dataSpec) throws IOException {
        this.f18776d = this.f18773a.mo25917a(dataSpec);
        long j = this.f18776d;
        if (j == 0) {
            return 0;
        }
        if (dataSpec.f18720g == -1 && j != -1) {
            dataSpec = dataSpec.mo26017a(0, j);
        }
        this.f18775c = true;
        this.f18774b.mo25950a(dataSpec);
        return this.f18776d;
    }

    public int read(byte[] buffer, int offset, int max) throws IOException {
        if (this.f18776d == 0) {
            return -1;
        }
        int bytesRead = this.f18773a.read(buffer, offset, max);
        if (bytesRead > 0) {
            this.f18774b.write(buffer, offset, bytesRead);
            long j = this.f18776d;
            if (j != -1) {
                this.f18776d = j - ((long) bytesRead);
            }
        }
        return bytesRead;
    }

    public Uri getUri() {
        return this.f18773a.getUri();
    }

    /* renamed from: a */
    public Map<String, List<String>> mo25954a() {
        return this.f18773a.mo25954a();
    }

    public void close() throws IOException {
        try {
            this.f18773a.close();
        } finally {
            if (this.f18775c) {
                this.f18775c = false;
                this.f18774b.close();
            }
        }
    }
}
