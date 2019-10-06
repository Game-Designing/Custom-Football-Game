package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.upstream.C8487i;
import com.google.android.exoplayer2.util.C8509F;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.exoplayer2.b.d */
/* compiled from: DefaultExtractorInput */
public final class C8181d implements C8261h {

    /* renamed from: a */
    private final byte[] f17036a = new byte[Opcodes.ACC_SYNTHETIC];

    /* renamed from: b */
    private final C8487i f17037b;

    /* renamed from: c */
    private final long f17038c;

    /* renamed from: d */
    private long f17039d;

    /* renamed from: e */
    private byte[] f17040e = new byte[65536];

    /* renamed from: f */
    private int f17041f;

    /* renamed from: g */
    private int f17042g;

    public C8181d(C8487i dataSource, long position, long length) {
        this.f17037b = dataSource;
        this.f17039d = position;
        this.f17038c = length;
    }

    public int read(byte[] target, int offset, int length) throws IOException, InterruptedException {
        int bytesRead = m18776b(target, offset, length);
        if (bytesRead == 0) {
            bytesRead = m18775a(target, offset, length, 0, true);
        }
        m18777d(bytesRead);
        return bytesRead;
    }

    /* renamed from: b */
    public boolean mo25247b(byte[] target, int offset, int length, boolean allowEndOfInput) throws IOException, InterruptedException {
        int bytesRead = m18776b(target, offset, length);
        while (bytesRead < length && bytesRead != -1) {
            bytesRead = m18775a(target, offset, length, bytesRead, allowEndOfInput);
        }
        m18777d(bytesRead);
        return bytesRead != -1;
    }

    public void readFully(byte[] target, int offset, int length) throws IOException, InterruptedException {
        mo25247b(target, offset, length, false);
    }

    /* renamed from: b */
    public int mo25244b(int length) throws IOException, InterruptedException {
        int bytesSkipped = m18779f(length);
        if (bytesSkipped == 0) {
            byte[] bArr = this.f17036a;
            bytesSkipped = m18775a(bArr, 0, Math.min(length, bArr.length), 0, true);
        }
        m18777d(bytesSkipped);
        return bytesSkipped;
    }

    /* renamed from: b */
    public boolean mo25246b(int length, boolean allowEndOfInput) throws IOException, InterruptedException {
        int bytesSkipped = m18779f(length);
        while (bytesSkipped < length && bytesSkipped != -1) {
            bytesSkipped = m18775a(this.f17036a, -bytesSkipped, Math.min(length, this.f17036a.length + bytesSkipped), bytesSkipped, allowEndOfInput);
        }
        m18777d(bytesSkipped);
        return bytesSkipped != -1;
    }

    /* renamed from: c */
    public void mo25248c(int length) throws IOException, InterruptedException {
        mo25246b(length, false);
    }

    /* renamed from: a */
    public boolean mo25243a(byte[] target, int offset, int length, boolean allowEndOfInput) throws IOException, InterruptedException {
        if (!mo25242a(length, allowEndOfInput)) {
            return false;
        }
        System.arraycopy(this.f17040e, this.f17041f - length, target, offset, length);
        return true;
    }

    /* renamed from: a */
    public void mo25241a(byte[] target, int offset, int length) throws IOException, InterruptedException {
        mo25243a(target, offset, length, false);
    }

    /* renamed from: a */
    public boolean mo25242a(int length, boolean allowEndOfInput) throws IOException, InterruptedException {
        m18778e(length);
        int bytesPeeked = this.f17042g - this.f17041f;
        while (bytesPeeked < length) {
            bytesPeeked = m18775a(this.f17040e, this.f17041f, length, bytesPeeked, allowEndOfInput);
            if (bytesPeeked == -1) {
                return false;
            }
            this.f17042g = this.f17041f + bytesPeeked;
        }
        this.f17041f += length;
        return true;
    }

    /* renamed from: a */
    public void mo25240a(int length) throws IOException, InterruptedException {
        mo25242a(length, false);
    }

    /* renamed from: a */
    public void mo25239a() {
        this.f17041f = 0;
    }

    /* renamed from: b */
    public long mo25245b() {
        return this.f17039d + ((long) this.f17041f);
    }

    public long getPosition() {
        return this.f17039d;
    }

    public long getLength() {
        return this.f17038c;
    }

    /* renamed from: e */
    private void m18778e(int length) {
        int requiredLength = this.f17041f + length;
        byte[] bArr = this.f17040e;
        if (requiredLength > bArr.length) {
            this.f17040e = Arrays.copyOf(this.f17040e, C8509F.m20433a(bArr.length * 2, 65536 + requiredLength, 524288 + requiredLength));
        }
    }

    /* renamed from: f */
    private int m18779f(int length) {
        int bytesSkipped = Math.min(this.f17042g, length);
        m18780g(bytesSkipped);
        return bytesSkipped;
    }

    /* renamed from: b */
    private int m18776b(byte[] target, int offset, int length) {
        int i = this.f17042g;
        if (i == 0) {
            return 0;
        }
        int peekBytes = Math.min(i, length);
        System.arraycopy(this.f17040e, 0, target, offset, peekBytes);
        m18780g(peekBytes);
        return peekBytes;
    }

    /* renamed from: g */
    private void m18780g(int bytesConsumed) {
        this.f17042g -= bytesConsumed;
        this.f17041f = 0;
        byte[] newPeekBuffer = this.f17040e;
        int i = this.f17042g;
        if (i < this.f17040e.length - 524288) {
            newPeekBuffer = new byte[(i + 65536)];
        }
        System.arraycopy(this.f17040e, bytesConsumed, newPeekBuffer, 0, this.f17042g);
        this.f17040e = newPeekBuffer;
    }

    /* renamed from: a */
    private int m18775a(byte[] target, int offset, int length, int bytesAlreadyRead, boolean allowEndOfInput) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int bytesRead = this.f17037b.read(target, offset + bytesAlreadyRead, length - bytesAlreadyRead);
            if (bytesRead != -1) {
                return bytesAlreadyRead + bytesRead;
            }
            if (bytesAlreadyRead == 0 && allowEndOfInput) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    /* renamed from: d */
    private void m18777d(int bytesRead) {
        if (bytesRead != -1) {
            this.f17039d += (long) bytesRead;
        }
    }
}
