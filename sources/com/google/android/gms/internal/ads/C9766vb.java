package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

/* renamed from: com.google.android.gms.internal.ads.vb */
final class C9766vb extends FilterInputStream {

    /* renamed from: a */
    private final HttpURLConnection f23254a;

    C9766vb(HttpURLConnection httpURLConnection) {
        super(zzat.m25772b(httpURLConnection));
        this.f23254a = httpURLConnection;
    }

    public final void close() throws IOException {
        super.close();
        this.f23254a.disconnect();
    }
}
