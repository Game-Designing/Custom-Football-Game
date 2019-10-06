package com.getkeepsafe.relinker.p181a;

import com.getkeepsafe.relinker.p181a.C8053c.C8054a;
import com.getkeepsafe.relinker.p181a.C8053c.C8055b;
import com.getkeepsafe.relinker.p181a.C8053c.C8056c;
import com.getkeepsafe.relinker.p181a.C8053c.C8057d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.getkeepsafe.relinker.a.d */
/* compiled from: Elf32Header */
public class C8058d extends C8055b {

    /* renamed from: j */
    private final C8060f f16426j;

    public C8058d(boolean bigEndian, C8060f parser) throws IOException {
        this.f16412a = bigEndian;
        this.f16426j = parser;
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f16413b = parser.mo24885b(buffer, 16);
        this.f16414c = parser.mo24890e(buffer, 28);
        this.f16415d = parser.mo24890e(buffer, 32);
        this.f16416e = parser.mo24885b(buffer, 42);
        this.f16417f = parser.mo24885b(buffer, 44);
        this.f16418g = parser.mo24885b(buffer, 46);
        this.f16419h = parser.mo24885b(buffer, 48);
        this.f16420i = parser.mo24885b(buffer, 50);
    }

    /* renamed from: a */
    public C8057d mo24881a(int index) throws IOException {
        return new C8063i(this.f16426j, this, index);
    }

    /* renamed from: a */
    public C8056c mo24880a(long index) throws IOException {
        return new C8061g(this.f16426j, this, index);
    }

    /* renamed from: a */
    public C8054a mo24879a(long baseOffset, int index) throws IOException {
        C8051a aVar = new C8051a(this.f16426j, this, baseOffset, index);
        return aVar;
    }
}
