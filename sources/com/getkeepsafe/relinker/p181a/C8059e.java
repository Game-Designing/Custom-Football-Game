package com.getkeepsafe.relinker.p181a;

import com.getkeepsafe.relinker.p181a.C8053c.C8054a;
import com.getkeepsafe.relinker.p181a.C8053c.C8055b;
import com.getkeepsafe.relinker.p181a.C8053c.C8056c;
import com.getkeepsafe.relinker.p181a.C8053c.C8057d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.getkeepsafe.relinker.a.e */
/* compiled from: Elf64Header */
public class C8059e extends C8055b {

    /* renamed from: j */
    private final C8060f f16427j;

    public C8059e(boolean bigEndian, C8060f parser) throws IOException {
        this.f16412a = bigEndian;
        this.f16427j = parser;
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f16413b = parser.mo24885b(buffer, 16);
        this.f16414c = parser.mo24887c(buffer, 32);
        this.f16415d = parser.mo24887c(buffer, 40);
        this.f16416e = parser.mo24885b(buffer, 54);
        this.f16417f = parser.mo24885b(buffer, 56);
        this.f16418g = parser.mo24885b(buffer, 58);
        this.f16419h = parser.mo24885b(buffer, 60);
        this.f16420i = parser.mo24885b(buffer, 62);
    }

    /* renamed from: a */
    public C8057d mo24881a(int index) throws IOException {
        return new C8064j(this.f16427j, this, index);
    }

    /* renamed from: a */
    public C8056c mo24880a(long index) throws IOException {
        return new C8062h(this.f16427j, this, index);
    }

    /* renamed from: a */
    public C8054a mo24879a(long baseOffset, int index) throws IOException {
        C8052b bVar = new C8052b(this.f16427j, this, baseOffset, index);
        return bVar;
    }
}
