package com.getkeepsafe.relinker.p181a;

import com.getkeepsafe.relinker.p181a.C8053c.C8054a;
import com.getkeepsafe.relinker.p181a.C8053c.C8055b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.getkeepsafe.relinker.a.a */
/* compiled from: Dynamic32Structure */
public class C8051a extends C8054a {
    public C8051a(C8060f parser, C8055b header, long baseOffset, int index) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(header.f16412a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long baseOffset2 = baseOffset + ((long) (index * 8));
        this.f16410a = parser.mo24890e(buffer, baseOffset2);
        this.f16411b = parser.mo24890e(buffer, 4 + baseOffset2);
    }
}
