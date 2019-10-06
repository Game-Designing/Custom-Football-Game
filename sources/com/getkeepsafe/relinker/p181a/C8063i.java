package com.getkeepsafe.relinker.p181a;

import com.getkeepsafe.relinker.p181a.C8053c.C8055b;
import com.getkeepsafe.relinker.p181a.C8053c.C8057d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.getkeepsafe.relinker.a.i */
/* compiled from: Section32Header */
public class C8063i extends C8057d {
    public C8063i(C8060f parser, C8055b header, int index) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(header.f16412a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f16425a = parser.mo24890e(buffer, header.f16415d + ((long) (header.f16418g * index)) + 28);
    }
}
