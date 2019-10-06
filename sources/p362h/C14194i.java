package p362h;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: h.i */
/* compiled from: BufferedSource */
public interface C14194i extends C14180B, ReadableByteChannel {
    /* renamed from: a */
    long mo44200a(byte b) throws IOException;

    /* renamed from: a */
    long mo44202a(C14179A a) throws IOException;

    /* renamed from: a */
    String mo44213a(Charset charset) throws IOException;

    /* renamed from: a */
    void mo44215a(C14191g gVar, long j) throws IOException;

    /* renamed from: a */
    boolean mo44216a(long j, C14195j jVar) throws IOException;

    /* renamed from: c */
    String mo44223c(long j) throws IOException;

    /* renamed from: d */
    byte[] mo44226d(long j) throws IOException;

    /* renamed from: e */
    void mo44227e(long j) throws IOException;

    /* renamed from: f */
    C14195j mo44230f(long j) throws IOException;

    /* renamed from: k */
    C14191g mo44238k();

    /* renamed from: n */
    String mo44241n() throws IOException;

    /* renamed from: o */
    short mo44242o() throws IOException;

    /* renamed from: p */
    byte[] mo44243p() throws IOException;

    /* renamed from: q */
    boolean mo44244q() throws IOException;

    /* renamed from: r */
    long mo44245r() throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    boolean request(long j) throws IOException;

    /* renamed from: s */
    int mo44253s() throws IOException;

    void skip(long j) throws IOException;

    /* renamed from: t */
    long mo44256t() throws IOException;

    /* renamed from: u */
    InputStream mo44258u();
}
