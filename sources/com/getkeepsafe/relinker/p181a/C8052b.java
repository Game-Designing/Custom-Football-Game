package com.getkeepsafe.relinker.p181a;

import com.getkeepsafe.relinker.p181a.C8053c.C8054a;
import com.getkeepsafe.relinker.p181a.C8053c.C8055b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.getkeepsafe.relinker.a.b */
/* compiled from: Dynamic64Structure */
public class C8052b extends C8054a {
    public C8052b(C8060f parser, C8055b header, long baseOffset, int index) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(header.f16412a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long baseOffset2 = baseOffset + ((long) (index * 16));
        this.f16410a = parser.mo24887c(buffer, baseOffset2);
        this.f16411b = parser.mo24887c(buffer, 8 + baseOffset2);
    }
}
