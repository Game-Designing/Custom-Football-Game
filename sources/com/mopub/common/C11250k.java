package com.mopub.common;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.mopub.common.k */
/* compiled from: DiskLruCacheStrictLineReader */
class C11250k extends ByteArrayOutputStream {

    /* renamed from: a */
    final /* synthetic */ C11251l f34405a;

    C11250k(C11251l this$0, int x0) {
        this.f34405a = this$0;
        super(x0);
    }

    public String toString() {
        int i = this.count;
        try {
            return new String(this.buf, 0, (i <= 0 || this.buf[i + -1] != 13) ? this.count : i - 1, this.f34405a.f34407b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
