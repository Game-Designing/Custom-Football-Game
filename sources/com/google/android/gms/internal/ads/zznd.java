package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zznd extends zzmy {

    /* renamed from: b */
    public final zzmz f28950b = new zzmz();

    /* renamed from: c */
    public ByteBuffer f28951c;

    /* renamed from: d */
    public long f28952d;

    /* renamed from: e */
    private final int f28953e = 0;

    public zznd(int i) {
    }

    /* renamed from: d */
    public final void mo32024d(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.f28951c;
        if (byteBuffer != null) {
            int position = this.f28951c.position() + i;
            if (byteBuffer.capacity() < position) {
                m30785e(position);
                throw null;
            }
            return;
        }
        m30785e(i);
        throw null;
    }

    /* renamed from: e */
    public final boolean mo32025e() {
        return mo32017c(1073741824);
    }

    /* renamed from: a */
    public final void mo32012a() {
        super.mo32012a();
        ByteBuffer byteBuffer = this.f28951c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    /* renamed from: e */
    private final ByteBuffer m30785e(int i) {
        ByteBuffer byteBuffer = this.f28951c;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
}
