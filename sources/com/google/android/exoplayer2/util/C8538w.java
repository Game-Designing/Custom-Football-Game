package com.google.android.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.exoplayer2.util.w */
/* compiled from: ReusableBufferedOutputStream */
public final class C8538w extends BufferedOutputStream {

    /* renamed from: a */
    private boolean f18868a;

    public C8538w(OutputStream out) {
        super(out);
    }

    public C8538w(OutputStream out, int size) {
        super(out, size);
    }

    public void close() throws IOException {
        this.f18868a = true;
        Throwable thrown = null;
        try {
            flush();
        } catch (Throwable e) {
            thrown = e;
        }
        try {
            this.out.close();
        } catch (Throwable e2) {
            if (thrown == null) {
                thrown = e2;
            }
        }
        if (thrown != null) {
            C8509F.m20452a(thrown);
            throw null;
        }
    }

    /* renamed from: a */
    public void mo26149a(OutputStream out) {
        C8514e.m20490b(this.f18868a);
        this.out = out;
        this.count = 0;
        this.f18868a = false;
    }
}
