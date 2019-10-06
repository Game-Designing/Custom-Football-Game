package com.google.android.exoplayer2.p183b.p185b;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.util.C8514e;
import java.io.IOException;
import java.util.ArrayDeque;

/* renamed from: com.google.android.exoplayer2.b.b.c */
/* compiled from: DefaultEbmlReader */
final class C8161c implements C8163d {

    /* renamed from: a */
    private final byte[] f16868a = new byte[8];

    /* renamed from: b */
    private final ArrayDeque<C8162a> f16869b = new ArrayDeque<>();

    /* renamed from: c */
    private final C8171i f16870c = new C8171i();

    /* renamed from: d */
    private C8164e f16871d;

    /* renamed from: e */
    private int f16872e;

    /* renamed from: f */
    private int f16873f;

    /* renamed from: g */
    private long f16874g;

    /* renamed from: com.google.android.exoplayer2.b.b.c$a */
    /* compiled from: DefaultEbmlReader */
    private static final class C8162a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final int f16875a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long f16876b;

        private C8162a(int elementId, long elementEndPosition) {
            this.f16875a = elementId;
            this.f16876b = elementEndPosition;
        }
    }

    /* renamed from: a */
    public void mo25207a(C8164e eventHandler) {
        this.f16871d = eventHandler;
    }

    public void reset() {
        this.f16872e = 0;
        this.f16869b.clear();
        this.f16870c.mo25234b();
    }

    /* renamed from: a */
    public boolean mo25208a(C8261h input) throws IOException, InterruptedException {
        C8514e.m20490b(this.f16871d != null);
        while (true) {
            if (this.f16869b.isEmpty() || input.getPosition() < ((C8162a) this.f16869b.peek()).f16876b) {
                if (this.f16872e == 0) {
                    long result = this.f16870c.mo25233a(input, true, false, 4);
                    if (result == -2) {
                        result = m18657b(input);
                    }
                    if (result == -1) {
                        return false;
                    }
                    this.f16873f = (int) result;
                    this.f16872e = 1;
                }
                if (this.f16872e == 1) {
                    this.f16874g = this.f16870c.mo25233a(input, false, true, 8);
                    this.f16872e = 2;
                }
                int type = this.f16871d.mo25216b(this.f16873f);
                if (type == 0) {
                    input.mo25248c((int) this.f16874g);
                    this.f16872e = 0;
                } else if (type == 1) {
                    long elementContentPosition = input.getPosition();
                    this.f16869b.push(new C8162a(this.f16873f, elementContentPosition + this.f16874g));
                    this.f16871d.mo25214a(this.f16873f, elementContentPosition, this.f16874g);
                    this.f16872e = 0;
                    return true;
                } else if (type == 2) {
                    long j = this.f16874g;
                    if (j <= 8) {
                        this.f16871d.mo25213a(this.f16873f, m18658b(input, (int) j));
                        this.f16872e = 0;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid integer size: ");
                    sb.append(this.f16874g);
                    throw new ParserException(sb.toString());
                } else if (type == 3) {
                    long j2 = this.f16874g;
                    if (j2 <= 2147483647L) {
                        this.f16871d.mo25215a(this.f16873f, m18659c(input, (int) j2));
                        this.f16872e = 0;
                        return true;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("String element size: ");
                    sb2.append(this.f16874g);
                    throw new ParserException(sb2.toString());
                } else if (type == 4) {
                    this.f16871d.mo25212a(this.f16873f, (int) this.f16874g, input);
                    this.f16872e = 0;
                    return true;
                } else if (type == 5) {
                    long j3 = this.f16874g;
                    if (j3 == 4 || j3 == 8) {
                        this.f16871d.mo25211a(this.f16873f, m18656a(input, (int) this.f16874g));
                        this.f16872e = 0;
                        return true;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Invalid float size: ");
                    sb3.append(this.f16874g);
                    throw new ParserException(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid element type ");
                    sb4.append(type);
                    throw new ParserException(sb4.toString());
                }
            } else {
                this.f16871d.mo25210a(((C8162a) this.f16869b.pop()).f16875a);
                return true;
            }
        }
    }

    /* renamed from: b */
    private long m18657b(C8261h input) throws IOException, InterruptedException {
        input.mo25239a();
        while (true) {
            input.mo25241a(this.f16868a, 0, 4);
            int varintLength = C8171i.m18724a(this.f16868a[0]);
            if (varintLength != -1 && varintLength <= 4) {
                int potentialId = (int) C8171i.m18725a(this.f16868a, varintLength, false);
                if (this.f16871d.mo25217c(potentialId)) {
                    input.mo25248c(varintLength);
                    return (long) potentialId;
                }
            }
            input.mo25248c(1);
        }
    }

    /* renamed from: b */
    private long m18658b(C8261h input, int byteLength) throws IOException, InterruptedException {
        input.readFully(this.f16868a, 0, byteLength);
        long value = 0;
        for (int i = 0; i < byteLength; i++) {
            value = (value << 8) | ((long) (this.f16868a[i] & 255));
        }
        return value;
    }

    /* renamed from: a */
    private double m18656a(C8261h input, int byteLength) throws IOException, InterruptedException {
        long integerValue = m18658b(input, byteLength);
        if (byteLength == 4) {
            return (double) Float.intBitsToFloat((int) integerValue);
        }
        return Double.longBitsToDouble(integerValue);
    }

    /* renamed from: c */
    private String m18659c(C8261h input, int byteLength) throws IOException, InterruptedException {
        if (byteLength == 0) {
            return "";
        }
        byte[] stringBytes = new byte[byteLength];
        input.readFully(stringBytes, 0, byteLength);
        int trimmedLength = byteLength;
        while (trimmedLength > 0 && stringBytes[trimmedLength - 1] == 0) {
            trimmedLength--;
        }
        return new String(stringBytes, 0, trimmedLength);
    }
}
