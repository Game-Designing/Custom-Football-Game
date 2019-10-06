package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p183b.C8272q.C8273a;
import com.google.android.exoplayer2.util.C8535t;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.f */
/* compiled from: DummyTrackOutput */
public final class C8254f implements C8272q {
    /* renamed from: a */
    public void mo25340a(Format format) {
    }

    /* renamed from: a */
    public int mo25338a(C8261h input, int length, boolean allowEndOfInput) throws IOException, InterruptedException {
        int bytesSkipped = input.mo25244b(length);
        if (bytesSkipped != -1) {
            return bytesSkipped;
        }
        if (allowEndOfInput) {
            return -1;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public void mo25341a(C8535t data, int length) {
        data.mo26120f(length);
    }

    /* renamed from: a */
    public void mo25339a(long timeUs, int flags, int size, int offset, C8273a cryptoData) {
    }
}
