package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.upstream.i */
/* compiled from: DataSource */
public interface C8487i {

    /* renamed from: com.google.android.exoplayer2.upstream.i$a */
    /* compiled from: DataSource */
    public interface C8488a {
        C8487i createDataSource();
    }

    /* renamed from: a */
    long mo25917a(C8489j jVar) throws IOException;

    /* renamed from: a */
    Map<String, List<String>> mo25954a();

    /* renamed from: a */
    void mo25955a(C8502v vVar);

    void close() throws IOException;

    Uri getUri();

    int read(byte[] bArr, int i, int i2) throws IOException;
}
