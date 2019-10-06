package com.bumptech.glide.load.p113c.p114a;

import com.bumptech.glide.load.C6347j.C6348a;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c.a.y */
/* compiled from: VideoDecoder */
class C6187y implements C6348a<Integer> {

    /* renamed from: a */
    private final ByteBuffer f10919a = ByteBuffer.allocate(4);

    C6187y() {
    }

    /* renamed from: a */
    public void mo19026a(byte[] keyBytes, Integer value, MessageDigest messageDigest) {
        if (value != null) {
            messageDigest.update(keyBytes);
            synchronized (this.f10919a) {
                this.f10919a.position(0);
                messageDigest.update(this.f10919a.putInt(value.intValue()).array());
            }
        }
    }
}
