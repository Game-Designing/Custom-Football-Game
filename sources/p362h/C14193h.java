package p362h;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* renamed from: h.h */
/* compiled from: BufferedSink */
public interface C14193h extends C14179A, WritableByteChannel {
    /* renamed from: a */
    long mo44203a(C14180B b) throws IOException;

    /* renamed from: a */
    C14193h mo44205a(long j) throws IOException;

    /* renamed from: a */
    C14193h mo44207a(C14195j jVar) throws IOException;

    /* renamed from: b */
    C14193h mo44219b(long j) throws IOException;

    /* renamed from: f */
    C14193h mo44229f(String str) throws IOException;

    void flush() throws IOException;

    /* renamed from: k */
    C14191g mo44238k();

    /* renamed from: l */
    C14193h mo44239l() throws IOException;

    /* renamed from: m */
    C14193h mo44240m() throws IOException;

    C14193h write(byte[] bArr) throws IOException;

    C14193h write(byte[] bArr, int i, int i2) throws IOException;

    C14193h writeByte(int i) throws IOException;

    C14193h writeInt(int i) throws IOException;

    C14193h writeShort(int i) throws IOException;
}
