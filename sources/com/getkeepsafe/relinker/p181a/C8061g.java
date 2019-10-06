package com.getkeepsafe.relinker.p181a;

import com.getkeepsafe.relinker.p181a.C8053c.C8055b;
import com.getkeepsafe.relinker.p181a.C8053c.C8056c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.getkeepsafe.relinker.a.g */
/* compiled from: Program32Header */
public class C8061g extends C8056c {
    public C8061g(C8060f parser, C8055b header, long index) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(header.f16412a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long baseOffset = header.f16414c + (((long) header.f16416e) * index);
        this.f16421a = parser.mo24890e(buffer, baseOffset);
        this.f16422b = parser.mo24890e(buffer, 4 + baseOffset);
        this.f16423c = parser.mo24890e(buffer, 8 + baseOffset);
        this.f16424d = parser.mo24890e(buffer, 20 + baseOffset);
    }
}
