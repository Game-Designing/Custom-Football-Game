package com.smaato.soma.p261j.p262a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.smaato.soma.j.a.f */
/* compiled from: DiskLruCacheStrictLineReader */
class C12458f extends ByteArrayOutputStream {

    /* renamed from: a */
    final /* synthetic */ C12459g f38900a;

    C12458f(C12459g this$0, int x0) {
        this.f38900a = this$0;
        super(x0);
    }

    public String toString() {
        int i = this.count;
        try {
            return new String(this.buf, 0, (i <= 0 || this.buf[i + -1] != 13) ? this.count : i - 1, this.f38900a.f38902b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
