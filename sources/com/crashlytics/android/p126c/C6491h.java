package com.crashlytics.android.p126c;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.crashlytics.android.c.h */
/* compiled from: CodedOutputStream */
final class C6491h implements Flushable {

    /* renamed from: a */
    private final byte[] f11658a;

    /* renamed from: b */
    private final int f11659b;

    /* renamed from: c */
    private int f11660c = 0;

    /* renamed from: d */
    private final OutputStream f11661d;

    /* renamed from: com.crashlytics.android.c.h$a */
    /* compiled from: CodedOutputStream */
    static class C6492a extends IOException {
        C6492a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C6491h(OutputStream output, byte[] buffer) {
        this.f11661d = output;
        this.f11658a = buffer;
        this.f11659b = buffer.length;
    }

    /* renamed from: a */
    public static C6491h m12688a(OutputStream output) {
        return m12689a(output, (int) Opcodes.ACC_SYNTHETIC);
    }

    /* renamed from: a */
    public static C6491h m12689a(OutputStream output, int bufferSize) {
        return new C6491h(output, new byte[bufferSize]);
    }

    /* renamed from: b */
    public void mo19554b(int fieldNumber, float value) throws IOException {
        mo19564f(fieldNumber, 5);
        mo19553b(value);
    }

    /* renamed from: b */
    public void mo19555b(int fieldNumber, long value) throws IOException {
        mo19564f(fieldNumber, 0);
        mo19565f(value);
    }

    /* renamed from: b */
    public void mo19557b(int fieldNumber, boolean value) throws IOException {
        mo19564f(fieldNumber, 0);
        mo19559b(value);
    }

    /* renamed from: b */
    public void mo19556b(int fieldNumber, C6481d value) throws IOException {
        mo19564f(fieldNumber, 2);
        mo19558b(value);
    }

    /* renamed from: g */
    public void mo19567g(int fieldNumber, int value) throws IOException {
        mo19564f(fieldNumber, 0);
        mo19574n(value);
    }

    /* renamed from: d */
    public void mo19561d(int fieldNumber, int value) throws IOException {
        mo19564f(fieldNumber, 0);
        mo19568h(value);
    }

    /* renamed from: e */
    public void mo19562e(int fieldNumber, int value) throws IOException {
        mo19564f(fieldNumber, 0);
        mo19573m(value);
    }

    /* renamed from: b */
    public void mo19553b(float value) throws IOException {
        mo19571k(Float.floatToRawIntBits(value));
    }

    /* renamed from: f */
    public void mo19565f(long value) throws IOException {
        mo19563e(value);
    }

    /* renamed from: i */
    public void mo19569i(int value) throws IOException {
        if (value >= 0) {
            mo19572l(value);
        } else {
            mo19563e((long) value);
        }
    }

    /* renamed from: b */
    public void mo19559b(boolean value) throws IOException {
        mo19570j(value);
    }

    /* renamed from: b */
    public void mo19558b(C6481d value) throws IOException {
        mo19572l(value.mo19535b());
        mo19560c(value);
    }

    /* renamed from: n */
    public void mo19574n(int value) throws IOException {
        mo19572l(value);
    }

    /* renamed from: h */
    public void mo19568h(int value) throws IOException {
        mo19569i(value);
    }

    /* renamed from: m */
    public void mo19573m(int value) throws IOException {
        mo19572l(m12700g(value));
    }

    /* renamed from: a */
    public static int m12681a(int fieldNumber, float value) {
        return m12698e(fieldNumber) + m12679a(value);
    }

    /* renamed from: a */
    public static int m12683a(int fieldNumber, long value) {
        return m12698e(fieldNumber) + m12697d(value);
    }

    /* renamed from: a */
    public static int m12685a(int fieldNumber, boolean value) {
        return m12698e(fieldNumber) + m12687a(value);
    }

    /* renamed from: a */
    public static int m12684a(int fieldNumber, C6481d value) {
        return m12698e(fieldNumber) + m12686a(value);
    }

    /* renamed from: c */
    public static int m12694c(int fieldNumber, int value) {
        return m12698e(fieldNumber) + m12699f(value);
    }

    /* renamed from: a */
    public static int m12682a(int fieldNumber, int value) {
        return m12698e(fieldNumber) + m12680a(value);
    }

    /* renamed from: b */
    public static int m12692b(int fieldNumber, int value) {
        return m12698e(fieldNumber) + m12696d(value);
    }

    /* renamed from: a */
    public static int m12679a(float value) {
        return 4;
    }

    /* renamed from: d */
    public static int m12697d(long value) {
        return m12695c(value);
    }

    /* renamed from: b */
    public static int m12691b(int value) {
        if (value >= 0) {
            return m12693c(value);
        }
        return 10;
    }

    /* renamed from: a */
    public static int m12687a(boolean value) {
        return 1;
    }

    /* renamed from: a */
    public static int m12686a(C6481d value) {
        return m12693c(value.mo19535b()) + value.mo19535b();
    }

    /* renamed from: f */
    public static int m12699f(int value) {
        return m12693c(value);
    }

    /* renamed from: a */
    public static int m12680a(int value) {
        return m12691b(value);
    }

    /* renamed from: d */
    public static int m12696d(int value) {
        return m12693c(m12700g(value));
    }

    /* renamed from: a */
    private void m12690a() throws IOException {
        OutputStream outputStream = this.f11661d;
        if (outputStream != null) {
            outputStream.write(this.f11658a, 0, this.f11660c);
            this.f11660c = 0;
            return;
        }
        throw new C6492a();
    }

    public void flush() throws IOException {
        if (this.f11661d != null) {
            m12690a();
        }
    }

    /* renamed from: a */
    public void mo19549a(byte value) throws IOException {
        if (this.f11660c == this.f11659b) {
            m12690a();
        }
        byte[] bArr = this.f11658a;
        int i = this.f11660c;
        this.f11660c = i + 1;
        bArr[i] = value;
    }

    /* renamed from: j */
    public void mo19570j(int value) throws IOException {
        mo19549a((byte) value);
    }

    /* renamed from: c */
    public void mo19560c(C6481d value) throws IOException {
        mo19550a(value, 0, value.mo19535b());
    }

    /* renamed from: a */
    public void mo19551a(byte[] value) throws IOException {
        mo19552a(value, 0, value.length);
    }

    /* renamed from: a */
    public void mo19552a(byte[] value, int offset, int length) throws IOException {
        int i = this.f11659b;
        int i2 = this.f11660c;
        if (i - i2 >= length) {
            System.arraycopy(value, offset, this.f11658a, i2, length);
            this.f11660c += length;
            return;
        }
        int bytesWritten = i - i2;
        System.arraycopy(value, offset, this.f11658a, i2, bytesWritten);
        int offset2 = offset + bytesWritten;
        int length2 = length - bytesWritten;
        this.f11660c = this.f11659b;
        m12690a();
        if (length2 <= this.f11659b) {
            System.arraycopy(value, offset2, this.f11658a, 0, length2);
            this.f11660c = length2;
            return;
        }
        this.f11661d.write(value, offset2, length2);
    }

    /* renamed from: a */
    public void mo19550a(C6481d value, int offset, int length) throws IOException {
        int i = this.f11659b;
        int i2 = this.f11660c;
        if (i - i2 >= length) {
            value.mo19534a(this.f11658a, offset, i2, length);
            this.f11660c += length;
            return;
        }
        int bytesWritten = i - i2;
        value.mo19534a(this.f11658a, offset, i2, bytesWritten);
        int offset2 = offset + bytesWritten;
        int length2 = length - bytesWritten;
        this.f11660c = this.f11659b;
        m12690a();
        if (length2 <= this.f11659b) {
            value.mo19534a(this.f11658a, offset2, 0, length2);
            this.f11660c = length2;
            return;
        }
        InputStream inputStreamFrom = value.mo19533a();
        if (((long) offset2) == inputStreamFrom.skip((long) offset2)) {
            while (length2 > 0) {
                int bytesToRead = Math.min(length2, this.f11659b);
                int bytesRead = inputStreamFrom.read(this.f11658a, 0, bytesToRead);
                if (bytesRead == bytesToRead) {
                    this.f11661d.write(this.f11658a, 0, bytesRead);
                    length2 -= bytesRead;
                } else {
                    throw new IllegalStateException("Read failed.");
                }
            }
            return;
        }
        throw new IllegalStateException("Skip failed.");
    }

    /* renamed from: f */
    public void mo19564f(int fieldNumber, int wireType) throws IOException {
        mo19572l(C6465Ua.m12609a(fieldNumber, wireType));
    }

    /* renamed from: e */
    public static int m12698e(int fieldNumber) {
        return m12693c(C6465Ua.m12609a(fieldNumber, 0));
    }

    /* renamed from: l */
    public void mo19572l(int value) throws IOException {
        while ((value & -128) != 0) {
            mo19570j((value & Opcodes.LAND) | 128);
            value >>>= 7;
        }
        mo19570j(value);
    }

    /* renamed from: c */
    public static int m12693c(int value) {
        if ((value & -128) == 0) {
            return 1;
        }
        if ((value & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & value) == 0) {
            return 3;
        }
        if ((-268435456 & value) == 0) {
            return 4;
        }
        return 5;
    }

    /* renamed from: e */
    public void mo19563e(long value) throws IOException {
        while ((-128 & value) != 0) {
            mo19570j((((int) value) & Opcodes.LAND) | 128);
            value >>>= 7;
        }
        mo19570j((int) value);
    }

    /* renamed from: c */
    public static int m12695c(long value) {
        if ((-128 & value) == 0) {
            return 1;
        }
        if ((-16384 & value) == 0) {
            return 2;
        }
        if ((-2097152 & value) == 0) {
            return 3;
        }
        if ((-268435456 & value) == 0) {
            return 4;
        }
        if ((-34359738368L & value) == 0) {
            return 5;
        }
        if ((-4398046511104L & value) == 0) {
            return 6;
        }
        if ((-562949953421312L & value) == 0) {
            return 7;
        }
        if ((-72057594037927936L & value) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & value) == 0) {
            return 9;
        }
        return 10;
    }

    /* renamed from: k */
    public void mo19571k(int value) throws IOException {
        mo19570j(value & 255);
        mo19570j((value >> 8) & 255);
        mo19570j((value >> 16) & 255);
        mo19570j((value >> 24) & 255);
    }

    /* renamed from: g */
    public static int m12700g(int n) {
        return (n << 1) ^ (n >> 31);
    }
}
