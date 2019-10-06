package com.getkeepsafe.relinker.p181a;

import com.getkeepsafe.relinker.p181a.C8053c.C8055b;
import com.getkeepsafe.relinker.p181a.C8053c.C8056c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.getkeepsafe.relinker.a.h */
/* compiled from: Program64Header */
public class C8062h extends C8056c {
    public C8062h(C8060f parser, C8055b header, long index) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(header.f16412a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long baseOffset = header.f16414c + (((long) header.f16416e) * index);
        this.f16421a = parser.mo24890e(buffer, baseOffset);
        this.f16422b = parser.mo24887c(buffer, 8 + baseOffset);
        this.f16423c = parser.mo24887c(buffer, 16 + baseOffset);
        this.f16424d = parser.mo24887c(buffer, 40 + baseOffset);
    }
}
