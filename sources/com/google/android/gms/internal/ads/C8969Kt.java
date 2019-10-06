package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* renamed from: com.google.android.gms.internal.ads.Kt */
final class C8969Kt extends PushbackInputStream {

    /* renamed from: a */
    private final /* synthetic */ C8906Ht f21418a;

    C8969Kt(C8906Ht ht, InputStream inputStream, int i) {
        this.f21418a = ht;
        super(inputStream, 1);
    }

    public final synchronized void close() throws IOException {
        this.f21418a.f21237c.m31323a();
        super.close();
    }
}
