package com.bumptech.glide.load.p113c.p114a;

import com.bumptech.glide.load.C6347j.C6348a;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c.a.x */
/* compiled from: VideoDecoder */
class C6186x implements C6348a<Long> {

    /* renamed from: a */
    private final ByteBuffer f10918a = ByteBuffer.allocate(8);

    C6186x() {
    }

    /* renamed from: a */
    public void mo19026a(byte[] keyBytes, Long value, MessageDigest messageDigest) {
        messageDigest.update(keyBytes);
        synchronized (this.f10918a) {
            this.f10918a.position(0);
            messageDigest.update(this.f10918a.putLong(value.longValue()).array());
        }
    }
}
