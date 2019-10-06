package com.bumptech.glide.p098a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.bumptech.glide.a.c */
/* compiled from: StrictLineReader */
class C5916c extends ByteArrayOutputStream {

    /* renamed from: a */
    final /* synthetic */ C5917d f10373a;

    C5916c(C5917d this$0, int x0) {
        this.f10373a = this$0;
        super(x0);
    }

    public String toString() {
        int i = this.count;
        try {
            return new String(this.buf, 0, (i <= 0 || this.buf[i + -1] != 13) ? this.count : i - 1, this.f10373a.f10375b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
