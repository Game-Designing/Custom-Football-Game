package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public final class zzow implements zznn, zznu {

    /* renamed from: a */
    private static final zznq f29043a = new C9741ts();

    /* renamed from: b */
    private static final int f29044b = zzsy.m31156b("qt  ");

    /* renamed from: c */
    private final zzst f29045c = new zzst(zzsq.f29316a);

    /* renamed from: d */
    private final zzst f29046d = new zzst(4);

    /* renamed from: e */
    private final zzst f29047e = new zzst(16);

    /* renamed from: f */
    private final Stack<C9503is> f29048f = new Stack<>();

    /* renamed from: g */
    private int f29049g;

    /* renamed from: h */
    private int f29050h;

    /* renamed from: i */
    private long f29051i;

    /* renamed from: j */
    private int f29052j;

    /* renamed from: k */
    private zzst f29053k;

    /* renamed from: l */
    private int f29054l;

    /* renamed from: m */
    private int f29055m;

    /* renamed from: n */
    private zznp f29056n;

    /* renamed from: o */
    private C9762us[] f29057o;

    /* renamed from: p */
    private long f29058p;

    /* renamed from: q */
    private boolean f29059q;

    /* renamed from: a */
    public final boolean mo32058a(zzno zzno) throws IOException, InterruptedException {
        return C9783vs.m24193a(zzno);
    }

    /* renamed from: a */
    public final void mo32057a(zznp zznp) {
        this.f29056n = zznp;
    }

    /* renamed from: a */
    public final void mo32056a(long j, long j2) {
        this.f29048f.clear();
        this.f29052j = 0;
        this.f29054l = 0;
        this.f29055m = 0;
        if (j == 0) {
            m30860d();
            return;
        }
        C9762us[] usVarArr = this.f29057o;
        if (usVarArr != null) {
            for (C9762us usVar : usVarArr) {
                C9804ws wsVar = usVar.f23239b;
                int a = wsVar.mo29258a(j2);
                if (a == -1) {
                    a = wsVar.mo29259b(j2);
                }
                usVar.f23241d = a;
            }
        }
    }

    /* renamed from: a */
    public final void mo32055a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x0199 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02aa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0006 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo32054a(com.google.android.gms.internal.ads.zzno r24, com.google.android.gms.internal.ads.zznt r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
        L_0x0006:
            int r3 = r0.f29049g
            r4 = -1
            r5 = 8
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x019a
            r8 = 262144(0x40000, double:1.295163E-318)
            r10 = 2
            if (r3 == r6) goto L_0x0115
            if (r3 != r10) goto L_0x010f
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r5 = -1
        L_0x0021:
            com.google.android.gms.internal.ads.us[] r14 = r0.f29057o
            int r15 = r14.length
            if (r3 >= r15) goto L_0x003e
            r14 = r14[r3]
            int r15 = r14.f23241d
            com.google.android.gms.internal.ads.ws r14 = r14.f23239b
            int r11 = r14.f23423a
            if (r15 == r11) goto L_0x003b
            long[] r11 = r14.f23424b
            r14 = r11[r15]
            int r11 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x003b
            r5 = r3
            r12 = r14
        L_0x003b:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x003e:
            if (r5 != r4) goto L_0x0043
            return r4
        L_0x0043:
            r3 = r14[r5]
            com.google.android.gms.internal.ads.zznw r4 = r3.f23240c
            int r5 = r3.f23241d
            com.google.android.gms.internal.ads.ws r11 = r3.f23239b
            long[] r12 = r11.f23424b
            r13 = r12[r5]
            int[] r11 = r11.f23425c
            r11 = r11[r5]
            com.google.android.gms.internal.ads.zzpa r12 = r3.f23238a
            int r12 = r12.f29072g
            if (r12 != r6) goto L_0x005f
            r16 = 8
            long r13 = r13 + r16
            int r11 = r11 + -8
        L_0x005f:
            long r16 = r24.getPosition()
            long r16 = r13 - r16
            int r12 = r0.f29054l
            r18 = r11
            long r10 = (long) r12
            long r10 = r16 + r10
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 < 0) goto L_0x010c
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 < 0) goto L_0x0078
            goto L_0x010c
        L_0x0078:
            int r2 = (int) r10
            r1.mo32045a(r2)
            com.google.android.gms.internal.ads.zzpa r2 = r3.f23238a
            int r2 = r2.f29076k
            if (r2 == 0) goto L_0x00d3
            com.google.android.gms.internal.ads.zzst r8 = r0.f29046d
            byte[] r8 = r8.f29334a
            r8[r7] = r7
            r8[r6] = r7
            r9 = 2
            r8[r9] = r7
            r8 = 4
            int r11 = 4 - r2
            r8 = r18
        L_0x0093:
            int r9 = r0.f29054l
            if (r9 >= r8) goto L_0x00d0
            int r9 = r0.f29055m
            if (r9 != 0) goto L_0x00c1
            com.google.android.gms.internal.ads.zzst r9 = r0.f29046d
            byte[] r9 = r9.f29334a
            r1.readFully(r9, r11, r2)
            com.google.android.gms.internal.ads.zzst r9 = r0.f29046d
            r9.mo32199b(r7)
            com.google.android.gms.internal.ads.zzst r9 = r0.f29046d
            int r9 = r9.mo32212l()
            r0.f29055m = r9
            com.google.android.gms.internal.ads.zzst r9 = r0.f29045c
            r9.mo32199b(r7)
            com.google.android.gms.internal.ads.zzst r9 = r0.f29045c
            r10 = 4
            r4.mo32064a(r9, r10)
            int r9 = r0.f29054l
            int r9 = r9 + r10
            r0.f29054l = r9
            int r8 = r8 + r11
            goto L_0x0093
        L_0x00c1:
            int r9 = r4.mo32061a(r1, r9, r7)
            int r10 = r0.f29054l
            int r10 = r10 + r9
            r0.f29054l = r10
            int r10 = r0.f29055m
            int r10 = r10 - r9
            r0.f29055m = r10
            goto L_0x0093
        L_0x00d0:
            r20 = r8
            goto L_0x00ee
        L_0x00d3:
            int r2 = r0.f29054l
            r11 = r18
            if (r2 >= r11) goto L_0x00ec
            int r2 = r11 - r2
            int r2 = r4.mo32061a(r1, r2, r7)
            int r8 = r0.f29054l
            int r8 = r8 + r2
            r0.f29054l = r8
            int r8 = r0.f29055m
            int r8 = r8 - r2
            r0.f29055m = r8
            r18 = r11
            goto L_0x00d3
        L_0x00ec:
            r20 = r11
        L_0x00ee:
            com.google.android.gms.internal.ads.ws r1 = r3.f23239b
            long[] r2 = r1.f23427e
            r17 = r2[r5]
            int[] r1 = r1.f23428f
            r19 = r1[r5]
            r21 = 0
            r22 = 0
            r16 = r4
            r16.mo32062a(r17, r19, r20, r21, r22)
            int r1 = r3.f23241d
            int r1 = r1 + r6
            r3.f23241d = r1
            r0.f29054l = r7
            r0.f29055m = r7
            return r7
        L_0x010c:
            r2.f28979a = r13
            return r6
        L_0x010f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0115:
            long r3 = r0.f29051i
            int r10 = r0.f29052j
            long r10 = (long) r10
            long r3 = r3 - r10
            long r10 = r24.getPosition()
            long r10 = r10 + r3
            com.google.android.gms.internal.ads.zzst r12 = r0.f29053k
            if (r12 == 0) goto L_0x017a
            byte[] r8 = r12.f29334a
            int r9 = r0.f29052j
            int r4 = (int) r3
            r1.readFully(r8, r9, r4)
            int r3 = r0.f29050h
            int r4 = com.google.android.gms.internal.ads.C9481hs.f22472a
            if (r3 != r4) goto L_0x015b
            com.google.android.gms.internal.ads.zzst r3 = r0.f29053k
            r3.mo32199b(r5)
            int r4 = r3.mo32202d()
            int r5 = f29044b
            if (r4 != r5) goto L_0x0143
            r3 = 1
            goto L_0x0158
        L_0x0143:
            r4 = 4
            r3.mo32201c(r4)
        L_0x0147:
            int r4 = r3.mo32214n()
            if (r4 <= 0) goto L_0x0157
            int r4 = r3.mo32202d()
            int r5 = f29044b
            if (r4 != r5) goto L_0x0147
            r3 = 1
            goto L_0x0158
        L_0x0157:
            r3 = 0
        L_0x0158:
            r0.f29059q = r3
            goto L_0x0182
        L_0x015b:
            java.util.Stack<com.google.android.gms.internal.ads.is> r3 = r0.f29048f
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0182
            java.util.Stack<com.google.android.gms.internal.ads.is> r3 = r0.f29048f
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.is r3 = (com.google.android.gms.internal.ads.C9503is) r3
            com.google.android.gms.internal.ads.js r4 = new com.google.android.gms.internal.ads.js
            int r5 = r0.f29050h
            com.google.android.gms.internal.ads.zzst r8 = r0.f29053k
            r4.<init>(r5, r8)
            java.util.List<com.google.android.gms.internal.ads.js> r3 = r3.f22577Ra
            r3.add(r4)
            goto L_0x0182
        L_0x017a:
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x0184
            int r4 = (int) r3
            r1.mo32045a(r4)
        L_0x0182:
            r3 = 0
            goto L_0x018c
        L_0x0184:
            long r8 = r24.getPosition()
            long r8 = r8 + r3
            r2.f28979a = r8
            r3 = 1
        L_0x018c:
            r0.m30859b(r10)
            if (r3 == 0) goto L_0x0197
            int r3 = r0.f29049g
            r4 = 2
            if (r3 == r4) goto L_0x0197
            r7 = 1
        L_0x0197:
            if (r7 == 0) goto L_0x0006
            return r6
        L_0x019a:
            int r3 = r0.f29052j
            if (r3 != 0) goto L_0x01c3
            com.google.android.gms.internal.ads.zzst r3 = r0.f29047e
            byte[] r3 = r3.f29334a
            boolean r3 = r1.mo32047a(r3, r7, r5, r6)
            if (r3 != 0) goto L_0x01ac
            r6 = 0
            goto L_0x02a8
        L_0x01ac:
            r0.f29052j = r5
            com.google.android.gms.internal.ads.zzst r3 = r0.f29047e
            r3.mo32199b(r7)
            com.google.android.gms.internal.ads.zzst r3 = r0.f29047e
            long r8 = r3.mo32210j()
            r0.f29051i = r8
            com.google.android.gms.internal.ads.zzst r3 = r0.f29047e
            int r3 = r3.mo32202d()
            r0.f29050h = r3
        L_0x01c3:
            long r8 = r0.f29051i
            r10 = 1
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x01df
            com.google.android.gms.internal.ads.zzst r3 = r0.f29047e
            byte[] r3 = r3.f29334a
            r1.readFully(r3, r5, r5)
            int r3 = r0.f29052j
            int r3 = r3 + r5
            r0.f29052j = r3
            com.google.android.gms.internal.ads.zzst r3 = r0.f29047e
            long r8 = r3.mo32213m()
            r0.f29051i = r8
        L_0x01df:
            int r3 = r0.f29050h
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22433B
            if (r3 == r8) goto L_0x01fc
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22437D
            if (r3 == r8) goto L_0x01fc
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22439E
            if (r3 == r8) goto L_0x01fc
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22441F
            if (r3 == r8) goto L_0x01fc
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22443G
            if (r3 == r8) goto L_0x01fc
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22461P
            if (r3 != r8) goto L_0x01fa
            goto L_0x01fc
        L_0x01fa:
            r3 = 0
            goto L_0x01fd
        L_0x01fc:
            r3 = 1
        L_0x01fd:
            if (r3 == 0) goto L_0x0229
            long r7 = r24.getPosition()
            long r9 = r0.f29051i
            long r7 = r7 + r9
            int r3 = r0.f29052j
            long r9 = (long) r3
            long r7 = r7 - r9
            java.util.Stack<com.google.android.gms.internal.ads.is> r3 = r0.f29048f
            com.google.android.gms.internal.ads.is r5 = new com.google.android.gms.internal.ads.is
            int r9 = r0.f29050h
            r5.<init>(r9, r7)
            r3.add(r5)
            long r9 = r0.f29051i
            int r3 = r0.f29052j
            long r11 = (long) r3
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0224
            r0.m30859b(r7)
            goto L_0x02a7
        L_0x0224:
            r23.m30860d()
            goto L_0x02a7
        L_0x0229:
            int r3 = r0.f29050h
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22463R
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22435C
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22464S
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22465T
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22497ma
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22499na
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22501oa
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22462Q
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22503pa
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22505qa
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22507ra
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22509sa
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22511ta
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22459O
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22472a
            if (r3 == r8) goto L_0x026e
            int r8 = com.google.android.gms.internal.ads.C9481hs.f22432Aa
            if (r3 != r8) goto L_0x026c
            goto L_0x026e
        L_0x026c:
            r3 = 0
            goto L_0x026f
        L_0x026e:
            r3 = 1
        L_0x026f:
            if (r3 == 0) goto L_0x02a2
            int r3 = r0.f29052j
            if (r3 != r5) goto L_0x0277
            r3 = 1
            goto L_0x0278
        L_0x0277:
            r3 = 0
        L_0x0278:
            com.google.android.gms.internal.ads.zzsk.m31082b(r3)
            long r8 = r0.f29051i
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x0286
            r3 = 1
            goto L_0x0287
        L_0x0286:
            r3 = 0
        L_0x0287:
            com.google.android.gms.internal.ads.zzsk.m31082b(r3)
            com.google.android.gms.internal.ads.zzst r3 = new com.google.android.gms.internal.ads.zzst
            long r8 = r0.f29051i
            int r9 = (int) r8
            r3.<init>(r9)
            r0.f29053k = r3
            com.google.android.gms.internal.ads.zzst r3 = r0.f29047e
            byte[] r3 = r3.f29334a
            com.google.android.gms.internal.ads.zzst r8 = r0.f29053k
            byte[] r8 = r8.f29334a
            java.lang.System.arraycopy(r3, r7, r8, r7, r5)
            r0.f29049g = r6
            goto L_0x02a7
        L_0x02a2:
            r3 = 0
            r0.f29053k = r3
            r0.f29049g = r6
        L_0x02a7:
        L_0x02a8:
            if (r6 != 0) goto L_0x02ab
            return r4
        L_0x02ab:
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzow.mo32054a(com.google.android.gms.internal.ads.zzno, com.google.android.gms.internal.ads.zznt):int");
    }

    /* renamed from: c */
    public final boolean mo32043c() {
        return true;
    }

    /* renamed from: b */
    public final long mo32042b() {
        return this.f29058p;
    }

    /* renamed from: a */
    public final long mo32041a(long j) {
        long j2 = Long.MAX_VALUE;
        for (C9762us usVar : this.f29057o) {
            C9804ws wsVar = usVar.f23239b;
            int a = wsVar.mo29258a(j);
            if (a == -1) {
                a = wsVar.mo29259b(j);
            }
            long j3 = wsVar.f23424b[a];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    /* renamed from: d */
    private final void m30860d() {
        this.f29049g = 0;
        this.f29052j = 0;
    }

    /* renamed from: b */
    private final void m30859b(long j) throws zzlm {
        while (!this.f29048f.isEmpty() && ((C9503is) this.f29048f.peek()).f22576Qa == j) {
            C9503is isVar = (C9503is) this.f29048f.pop();
            if (isVar.f22524Pa == C9481hs.f22433B) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                zzpo zzpo = null;
                zznr zznr = new zznr();
                C9525js d = isVar.mo29010d(C9481hs.f22432Aa);
                if (d != null) {
                    zzpo = C9547ks.m23839a(d, this.f29059q);
                    if (zzpo != null) {
                        zznr.mo32060a(zzpo);
                    }
                }
                for (int i = 0; i < isVar.f22578Sa.size(); i++) {
                    C9503is isVar2 = (C9503is) isVar.f22578Sa.get(i);
                    if (isVar2.f22524Pa == C9481hs.f22437D) {
                        zzpa a = C9547ks.m23838a(isVar2, isVar.mo29010d(C9481hs.f22435C), -9223372036854775807L, (zzne) null, this.f29059q);
                        if (a != null) {
                            C9804ws a2 = C9547ks.m23837a(a, isVar2.mo29011e(C9481hs.f22439E).mo29011e(C9481hs.f22441F).mo29011e(C9481hs.f22443G), zznr);
                            if (a2.f23423a != 0) {
                                C9762us usVar = new C9762us(a, a2, this.f29056n.mo28295b(i, a.f29067b));
                                zzlh a3 = a.f29071f.mo31939a(a2.f23426d + 30);
                                if (a.f29067b == 1) {
                                    if (zznr.mo32059a()) {
                                        a3 = a3.mo31940a(zznr.f28977c, zznr.f28978d);
                                    }
                                    if (zzpo != null) {
                                        a3 = a3.mo31942a(zzpo);
                                    }
                                }
                                usVar.f23240c.mo32063a(a3);
                                j2 = Math.max(j2, a.f29070e);
                                arrayList.add(usVar);
                            }
                        }
                    }
                }
                this.f29058p = j2;
                this.f29057o = (C9762us[]) arrayList.toArray(new C9762us[arrayList.size()]);
                this.f29056n.mo28301f();
                this.f29056n.mo28289a(this);
                this.f29048f.clear();
                this.f29049g = 2;
            } else if (!this.f29048f.isEmpty()) {
                ((C9503is) this.f29048f.peek()).f22578Sa.add(isVar);
            }
        }
        if (this.f29049g != 2) {
            m30860d();
        }
    }
}
