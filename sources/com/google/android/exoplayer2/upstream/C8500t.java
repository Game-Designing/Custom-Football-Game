package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.C8514e;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.upstream.t */
/* compiled from: StatsDataSource */
public final class C8500t implements C8487i {

    /* renamed from: a */
    private final C8487i f18769a;

    /* renamed from: b */
    private long f18770b;

    /* renamed from: c */
    private Uri f18771c = Uri.EMPTY;

    /* renamed from: d */
    private Map<String, List<String>> f18772d = Collections.emptyMap();

    public C8500t(C8487i dataSource) {
        C8514e.m20486a(dataSource);
        this.f18769a = dataSource;
    }

    /* renamed from: b */
    public long mo26033b() {
        return this.f18770b;
    }

    /* renamed from: c */
    public Uri mo26034c() {
        return this.f18771c;
    }

    /* renamed from: d */
    public Map<String, List<String>> mo26035d() {
        return this.f18772d;
    }

    /* renamed from: a */
    public void mo25955a(C8502v transferListener) {
        this.f18769a.mo25955a(transferListener);
    }

    /* renamed from: a */
    public long mo25917a(C8489j dataSpec) throws IOException {
        this.f18771c = dataSpec.f18714a;
        this.f18772d = Collections.emptyMap();
        long availableBytes = this.f18769a.mo25917a(dataSpec);
        Uri uri = getUri();
        C8514e.m20486a(uri);
        this.f18771c = uri;
        this.f18772d = mo25954a();
        return availableBytes;
    }

    public int read(byte[] buffer, int offset, int readLength) throws IOException {
        int bytesRead = this.f18769a.read(buffer, offset, readLength);
        if (bytesRead != -1) {
            this.f18770b += (long) bytesRead;
        }
        return bytesRead;
    }

    public Uri getUri() {
        return this.f18769a.getUri();
    }

    /* renamed from: a */
    public Map<String, List<String>> mo25954a() {
        return this.f18769a.mo25954a();
    }

    public void close() throws IOException {
        this.f18769a.close();
    }
}
