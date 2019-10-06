package com.google.android.exoplayer2.p182a;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.a.e */
/* compiled from: DecoderInputBuffer */
public class C8107e extends C8102a {

    /* renamed from: b */
    public final C8104c f16554b = new C8104c();

    /* renamed from: c */
    public ByteBuffer f16555c;

    /* renamed from: d */
    public long f16556d;

    /* renamed from: e */
    private final int f16557e;

    /* renamed from: h */
    public static C8107e m18277h() {
        return new C8107e(0);
    }

    public C8107e(int bufferReplacementMode) {
        this.f16557e = bufferReplacementMode;
    }

    /* renamed from: d */
    public void mo25030d(int length) {
        ByteBuffer byteBuffer = this.f16555c;
        if (byteBuffer == null) {
            this.f16555c = m18276e(length);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f16555c.position();
        int requiredCapacity = position + length;
        if (capacity < requiredCapacity) {
            ByteBuffer newData = m18276e(requiredCapacity);
            if (position > 0) {
                this.f16555c.position(0);
                this.f16555c.limit(position);
                newData.put(this.f16555c);
            }
            this.f16555c = newData;
        }
    }

    /* renamed from: g */
    public final boolean mo25033g() {
        return this.f16555c == null && this.f16557e == 0;
    }

    /* renamed from: f */
    public final boolean mo25032f() {
        return mo25023b(1073741824);
    }

    /* renamed from: e */
    public final void mo25031e() {
        this.f16555c.flip();
    }

    /* renamed from: a */
    public void mo25020a() {
        super.mo25020a();
        ByteBuffer byteBuffer = this.f16555c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    /* renamed from: e */
    private ByteBuffer m18276e(int requiredCapacity) {
        int i = this.f16557e;
        if (i == 1) {
            return ByteBuffer.allocate(requiredCapacity);
        }
        if (i == 2) {
            return ByteBuffer.allocateDirect(requiredCapacity);
        }
        ByteBuffer byteBuffer = this.f16555c;
        int currentCapacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder();
        sb.append("Buffer too small (");
        sb.append(currentCapacity);
        sb.append(" < ");
        sb.append(requiredCapacity);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
}
