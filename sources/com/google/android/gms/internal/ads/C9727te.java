package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

@zzard
/* renamed from: com.google.android.gms.internal.ads.te */
final class C9727te implements zzdsw {

    /* renamed from: a */
    private final ByteBuffer f23009a;

    C9727te(ByteBuffer byteBuffer) {
        this.f23009a = byteBuffer.duplicate();
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f23009a.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.f23009a.remaining());
        byte[] bArr = new byte[min];
        this.f23009a.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    public final long size() throws IOException {
        return (long) this.f23009a.limit();
    }

    public final long position() throws IOException {
        return (long) this.f23009a.position();
    }

    /* renamed from: g */
    public final void mo29175g(long j) throws IOException {
        this.f23009a.position((int) j);
    }

    /* renamed from: a */
    public final ByteBuffer mo29173a(long j, long j2) throws IOException {
        int position = this.f23009a.position();
        this.f23009a.position((int) j);
        ByteBuffer slice = this.f23009a.slice();
        slice.limit((int) j2);
        this.f23009a.position(position);
        return slice;
    }

    public final void close() throws IOException {
    }
}
