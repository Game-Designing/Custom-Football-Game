package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Stack;

/* renamed from: com.google.android.gms.internal.ads.lr */
final class C9568lr implements C9634or {

    /* renamed from: a */
    private final byte[] f22729a = new byte[8];

    /* renamed from: b */
    private final Stack<C9612nr> f22730b = new Stack<>();

    /* renamed from: c */
    private final C9677qr f22731c = new C9677qr();

    /* renamed from: d */
    private C9656pr f22732d;

    /* renamed from: e */
    private int f22733e;

    /* renamed from: f */
    private int f22734f;

    /* renamed from: g */
    private long f22735g;

    C9568lr() {
    }

    /* renamed from: a */
    public final void mo29069a(C9656pr prVar) {
        this.f22732d = prVar;
    }

    public final void reset() {
        this.f22733e = 0;
        this.f22730b.clear();
        this.f22731c.mo29147a();
    }

    /* renamed from: a */
    public final boolean mo29070a(zzie zzie) throws IOException, InterruptedException {
        double d;
        zzkh.m30537b(this.f22732d != null);
        while (true) {
            if (this.f22730b.isEmpty() || zzie.getPosition() < ((C9612nr) this.f22730b.peek()).f22817b) {
                if (this.f22733e == 0) {
                    long a = this.f22731c.mo29146a(zzie, true, false);
                    if (a == -1) {
                        return false;
                    }
                    this.f22734f = (int) a;
                    this.f22733e = 1;
                }
                if (this.f22733e == 1) {
                    this.f22735g = this.f22731c.mo29146a(zzie, false, true);
                    this.f22733e = 2;
                }
                int a2 = this.f22732d.mo29129a(this.f22734f);
                if (a2 == 0) {
                    zzie.mo31840a((int) this.f22735g);
                    this.f22733e = 0;
                } else if (a2 == 1) {
                    long position = zzie.getPosition();
                    this.f22730b.add(new C9612nr(this.f22734f, this.f22735g + position));
                    this.f22732d.mo29132a(this.f22734f, position, this.f22735g);
                    this.f22733e = 0;
                    return true;
                } else if (a2 == 2) {
                    long j = this.f22735g;
                    if (j <= 8) {
                        this.f22732d.mo29135b(this.f22734f, m23863a(zzie, (int) j));
                        this.f22733e = 0;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j);
                    throw new IllegalStateException(sb.toString());
                } else if (a2 == 3) {
                    long j2 = this.f22735g;
                    if (j2 <= 2147483647L) {
                        C9656pr prVar = this.f22732d;
                        int i = this.f22734f;
                        int i2 = (int) j2;
                        byte[] bArr = new byte[i2];
                        zzie.readFully(bArr, 0, i2);
                        prVar.mo29133a(i, new String(bArr, Charset.forName("UTF-8")));
                        this.f22733e = 0;
                        return true;
                    }
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j2);
                    throw new IllegalStateException(sb2.toString());
                } else if (a2 == 4) {
                    this.f22732d.mo29131a(this.f22734f, (int) this.f22735g, zzie);
                    this.f22733e = 0;
                    return true;
                } else if (a2 == 5) {
                    long j3 = this.f22735g;
                    if (j3 == 4 || j3 == 8) {
                        C9656pr prVar2 = this.f22732d;
                        int i3 = this.f22734f;
                        int i4 = (int) this.f22735g;
                        long a3 = m23863a(zzie, i4);
                        if (i4 == 4) {
                            d = (double) Float.intBitsToFloat((int) a3);
                        } else {
                            d = Double.longBitsToDouble(a3);
                        }
                        prVar2.mo29130a(i3, d);
                        this.f22733e = 0;
                        return true;
                    }
                    StringBuilder sb3 = new StringBuilder(40);
                    sb3.append("Invalid float size: ");
                    sb3.append(j3);
                    throw new IllegalStateException(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(a2);
                    throw new IllegalStateException(sb4.toString());
                }
            } else {
                this.f22732d.mo29134b(((C9612nr) this.f22730b.pop()).f22816a);
                return true;
            }
        }
    }

    /* renamed from: a */
    private final long m23863a(zzie zzie, int i) throws IOException, InterruptedException {
        zzie.readFully(this.f22729a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f22729a[i2] & 255));
        }
        return j;
    }
}
