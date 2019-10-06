package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;

/* renamed from: com.google.android.gms.internal.ads.Yr */
final class C9264Yr implements C9327as {

    /* renamed from: a */
    private final byte[] f22005a = new byte[8];

    /* renamed from: b */
    private final Stack<C9305_r> f22006b = new Stack<>();

    /* renamed from: c */
    private final C9459gs f22007c = new C9459gs();

    /* renamed from: d */
    private C9349bs f22008d;

    /* renamed from: e */
    private int f22009e;

    /* renamed from: f */
    private int f22010f;

    /* renamed from: g */
    private long f22011g;

    C9264Yr() {
    }

    /* renamed from: a */
    public final void mo28801a(C9349bs bsVar) {
        this.f22008d = bsVar;
    }

    public final void reset() {
        this.f22009e = 0;
        this.f22006b.clear();
        this.f22007c.mo28980a();
    }

    /* renamed from: a */
    public final boolean mo28802a(zzno zzno) throws IOException, InterruptedException {
        String str;
        double d;
        int a;
        int a2;
        zzsk.m31082b(this.f22008d != null);
        while (true) {
            if (this.f22006b.isEmpty() || zzno.getPosition() < ((C9305_r) this.f22006b.peek()).f22065b) {
                if (this.f22009e == 0) {
                    long a3 = this.f22007c.mo28979a(zzno, true, false, 4);
                    if (a3 == -2) {
                        zzno.mo32044a();
                        while (true) {
                            zzno.mo32046a(this.f22005a, 0, 4);
                            a = C9459gs.m23656a(this.f22005a[0]);
                            if (a != -1 && a <= 4) {
                                a2 = (int) C9459gs.m23657a(this.f22005a, a, false);
                                if (this.f22008d.mo28892c(a2)) {
                                    break;
                                }
                            }
                            zzno.mo32045a(1);
                        }
                        zzno.mo32045a(a);
                        a3 = (long) a2;
                    }
                    if (a3 == -1) {
                        return false;
                    }
                    this.f22010f = (int) a3;
                    this.f22009e = 1;
                }
                if (this.f22009e == 1) {
                    this.f22011g = this.f22007c.mo28979a(zzno, false, true, 8);
                    this.f22009e = 2;
                }
                int a4 = this.f22008d.mo28885a(this.f22010f);
                if (a4 == 0) {
                    zzno.mo32045a((int) this.f22011g);
                    this.f22009e = 0;
                } else if (a4 == 1) {
                    long position = zzno.getPosition();
                    this.f22006b.add(new C9305_r(this.f22010f, this.f22011g + position));
                    this.f22008d.mo28888a(this.f22010f, position, this.f22011g);
                    this.f22009e = 0;
                    return true;
                } else if (a4 == 2) {
                    long j = this.f22011g;
                    if (j <= 8) {
                        this.f22008d.mo28891b(this.f22010f, m23352a(zzno, (int) j));
                        this.f22009e = 0;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j);
                    throw new zzlm(sb.toString());
                } else if (a4 == 3) {
                    long j2 = this.f22011g;
                    if (j2 <= 2147483647L) {
                        C9349bs bsVar = this.f22008d;
                        int i = this.f22010f;
                        int i2 = (int) j2;
                        if (i2 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i2];
                            zzno.readFully(bArr, 0, i2);
                            str = new String(bArr);
                        }
                        bsVar.mo28889a(i, str);
                        this.f22009e = 0;
                        return true;
                    }
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j2);
                    throw new zzlm(sb2.toString());
                } else if (a4 == 4) {
                    this.f22008d.mo28887a(this.f22010f, (int) this.f22011g, zzno);
                    this.f22009e = 0;
                    return true;
                } else if (a4 == 5) {
                    long j3 = this.f22011g;
                    if (j3 == 4 || j3 == 8) {
                        C9349bs bsVar2 = this.f22008d;
                        int i3 = this.f22010f;
                        int i4 = (int) this.f22011g;
                        long a5 = m23352a(zzno, i4);
                        if (i4 == 4) {
                            d = (double) Float.intBitsToFloat((int) a5);
                        } else {
                            d = Double.longBitsToDouble(a5);
                        }
                        bsVar2.mo28886a(i3, d);
                        this.f22009e = 0;
                        return true;
                    }
                    StringBuilder sb3 = new StringBuilder(40);
                    sb3.append("Invalid float size: ");
                    sb3.append(j3);
                    throw new zzlm(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(a4);
                    throw new zzlm(sb4.toString());
                }
            } else {
                this.f22008d.mo28890b(((C9305_r) this.f22006b.pop()).f22064a);
                return true;
            }
        }
    }

    /* renamed from: a */
    private final long m23352a(zzno zzno, int i) throws IOException, InterruptedException {
        zzno.readFully(this.f22005a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f22005a[i2] & 255));
        }
        return j;
    }
}
