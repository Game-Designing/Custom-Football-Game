package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzms extends zzpe implements zzso {
    /* access modifiers changed from: private */

    /* renamed from: V */
    public final zzma f28907V;

    /* renamed from: W */
    private final zzmh f28908W;

    /* renamed from: X */
    private boolean f28909X;

    /* renamed from: Y */
    private boolean f28910Y;

    /* renamed from: Z */
    private MediaFormat f28911Z;

    /* renamed from: aa */
    private int f28912aa;

    /* renamed from: ba */
    private int f28913ba;

    /* renamed from: ca */
    private long f28914ca;
    /* access modifiers changed from: private */

    /* renamed from: da */
    public boolean f28915da;

    public zzms(zzpg zzpg) {
        this(zzpg, null, true);
    }

    private zzms(zzpg zzpg, zznj<Object> zznj, boolean z) {
        this(zzpg, null, true, null, null);
    }

    private zzms(zzpg zzpg, zznj<Object> zznj, boolean z, Handler handler, zzlz zzlz) {
        this(zzpg, null, true, null, null, null, new zzlx[0]);
    }

    private zzms(zzpg zzpg, zznj<Object> zznj, boolean z, Handler handler, zzlz zzlz, zzlw zzlw, zzlx... zzlxArr) {
        super(1, zzpg, zznj, z);
        this.f28908W = new zzmh(null, zzlxArr, new C9093Qr(this));
        this.f28907V = new zzma(null, null);
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.internal.ads.zzpd.b(int):null, types can be incorrect */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (r7.mo32078b(r8) == false) goto L_0x0047;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo31997a(com.google.android.gms.internal.ads.zzpg r7, com.google.android.gms.internal.ads.zzlh r8) throws com.google.android.gms.internal.ads.zzpk {
        /*
            r6 = this;
            java.lang.String r0 = r8.f28784f
            boolean r1 = com.google.android.gms.internal.ads.zzsp.m31097a(r0)
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = com.google.android.gms.internal.ads.zzsy.f29345a
            r3 = 21
            if (r1 < r3) goto L_0x0013
            r1 = 16
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            boolean r4 = r6.m30740a(r0)
            r5 = 3
            if (r4 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzpd r4 = r7.mo29286a()
            if (r4 == 0) goto L_0x0025
            r7 = r1 | 4
            r7 = r7 | r5
            return r7
        L_0x0025:
            com.google.android.gms.internal.ads.zzpd r7 = r7.mo29287a(r0, r2)
            r0 = 1
            if (r7 != 0) goto L_0x002d
            return r0
        L_0x002d:
            int r4 = com.google.android.gms.internal.ads.zzsy.f29345a
            if (r4 < r3) goto L_0x0049
            int r3 = r8.f28797s
            r4 = -1
            if (r3 == r4) goto L_0x003c
            boolean r3 = r7.mo32074a(r3)
            if (r3 == 0) goto L_0x0047
        L_0x003c:
            int r8 = r8.f28796r
            if (r8 == r4) goto L_0x0049
            boolean r7 = r7.mo32078b(r8)
            if (r7 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r0 = 0
            goto L_0x004a
        L_0x0049:
        L_0x004a:
            if (r0 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r5 = 2
        L_0x004e:
            r7 = r1 | 4
            r7 = r7 | r5
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzms.mo31997a(com.google.android.gms.internal.ads.zzpg, com.google.android.gms.internal.ads.zzlh):int");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final zzpd mo32000a(zzpg zzpg, zzlh zzlh, boolean z) throws zzpk {
        if (m30740a(zzlh.f28784f)) {
            zzpd a = zzpg.mo29286a();
            if (a != null) {
                this.f28909X = true;
                return a;
            }
        }
        this.f28909X = false;
        return super.mo32000a(zzpg, zzlh, z);
    }

    /* renamed from: a */
    private final boolean m30740a(String str) {
        return this.f28908W.mo31985a(str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo32002a(com.google.android.gms.internal.ads.zzpd r4, android.media.MediaCodec r5, com.google.android.gms.internal.ads.zzlh r6, android.media.MediaCrypto r7) {
        /*
            r3 = this;
            java.lang.String r4 = r4.f29080a
            int r7 = com.google.android.gms.internal.ads.zzsy.f29345a
            r0 = 0
            r1 = 24
            if (r7 >= r1) goto L_0x003b
            java.lang.String r7 = "OMX.SEC.aac.dec"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x003b
            java.lang.String r4 = com.google.android.gms.internal.ads.zzsy.f29347c
            java.lang.String r7 = "samsung"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x003b
            java.lang.String r4 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r7 = "zeroflte"
            boolean r4 = r4.startsWith(r7)
            if (r4 != 0) goto L_0x0039
            java.lang.String r4 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r7 = "herolte"
            boolean r4 = r4.startsWith(r7)
            if (r4 != 0) goto L_0x0039
            java.lang.String r4 = com.google.android.gms.internal.ads.zzsy.f29346b
            java.lang.String r7 = "heroqlte"
            boolean r4 = r4.startsWith(r7)
            if (r4 == 0) goto L_0x003b
        L_0x0039:
            r4 = 1
            goto L_0x003c
        L_0x003b:
            r4 = 0
        L_0x003c:
            r3.f28910Y = r4
            boolean r4 = r3.f28909X
            r7 = 0
            if (r4 == 0) goto L_0x005f
            android.media.MediaFormat r4 = r6.mo31938a()
            r3.f28911Z = r4
            android.media.MediaFormat r4 = r3.f28911Z
            java.lang.String r1 = "mime"
            java.lang.String r2 = "audio/raw"
            r4.setString(r1, r2)
            android.media.MediaFormat r4 = r3.f28911Z
            r5.configure(r4, r7, r7, r0)
            android.media.MediaFormat r4 = r3.f28911Z
            java.lang.String r5 = r6.f28784f
            r4.setString(r1, r5)
            return
        L_0x005f:
            android.media.MediaFormat r4 = r6.mo31938a()
            r5.configure(r4, r7, r7, r0)
            r3.f28911Z = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzms.mo32002a(com.google.android.gms.internal.ads.zzpd, android.media.MediaCodec, com.google.android.gms.internal.ads.zzlh, android.media.MediaCrypto):void");
    }

    /* renamed from: f */
    public final zzso mo31916f() {
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32003a(String str, long j, long j2) {
        this.f28907V.mo31977a(str, j, j2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo32005b(zzlh zzlh) throws zzku {
        int i;
        super.mo32005b(zzlh);
        this.f28907V.mo31975a(zzlh);
        if ("audio/raw".equals(zzlh.f28784f)) {
            i = zzlh.f28798t;
        } else {
            i = 2;
        }
        this.f28912aa = i;
        this.f28913ba = zzlh.f28796r;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32001a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzku {
        String str;
        int[] iArr;
        boolean z = this.f28911Z != null;
        if (z) {
            str = this.f28911Z.getString("mime");
        } else {
            str = "audio/raw";
        }
        if (z) {
            mediaFormat = this.f28911Z;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f28910Y && integer == 6) {
            int i = this.f28913ba;
            if (i < 6) {
                int[] iArr2 = new int[i];
                for (int i2 = 0; i2 < this.f28913ba; i2++) {
                    iArr2[i2] = i2;
                }
                iArr = iArr2;
                this.f28908W.mo31984a(str, integer, integer2, this.f28912aa, 0, iArr);
            }
        }
        iArr = null;
        try {
            this.f28908W.mo31984a(str, integer, integer2, this.f28912aa, 0, iArr);
        } catch (zzml e) {
            throw zzku.m30599a(e, mo31924n());
        }
    }

    /* renamed from: a */
    protected static void m30737a(int i) {
    }

    /* renamed from: y */
    protected static void m30741y() {
    }

    /* renamed from: a */
    protected static void m30738a(int i, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31909a(boolean z) throws zzku {
        super.mo31909a(z);
        this.f28907V.mo31976a(this.f29107U);
        int i = mo31928r().f28814b;
        if (i != 0) {
            this.f28908W.mo31988b(i);
        } else {
            this.f28908W.mo31996j();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31907a(long j, boolean z) throws zzku {
        super.mo31907a(j, z);
        this.f28908W.mo31990d();
        this.f28914ca = j;
        this.f28915da = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void mo31925o() {
        super.mo31925o();
        this.f28908W.mo31987b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final void mo31926p() {
        this.f28908W.mo31981a();
        super.mo31926p();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public final void mo31927q() {
        try {
            this.f28908W.mo31989c();
            try {
                super.mo31927q();
            } finally {
                this.f29107U.mo32023a();
                this.f28907V.mo31978b(this.f29107U);
            }
        } catch (Throwable th) {
            super.mo31927q();
            throw th;
        } finally {
            this.f29107U.mo32023a();
            this.f28907V.mo31978b(this.f29107U);
        }
    }

    /* renamed from: b */
    public final boolean mo31953b() {
        return super.mo31953b() && this.f28908W.mo31991e();
    }

    public final boolean isReady() {
        return this.f28908W.mo31993g() || super.isReady();
    }

    /* renamed from: a */
    public final long mo31998a() {
        long a = this.f28908W.mo31979a(mo31953b());
        if (a != Long.MIN_VALUE) {
            if (!this.f28915da) {
                a = Math.max(this.f28914ca, a);
            }
            this.f28914ca = a;
            this.f28915da = false;
        }
        return this.f28914ca;
    }

    /* renamed from: a */
    public final zzln mo31999a(zzln zzln) {
        return this.f28908W.mo31980a(zzln);
    }

    /* renamed from: i */
    public final zzln mo32006i() {
        return this.f28908W.mo31995i();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo32004a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzku {
        if (this.f28909X && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.f29107U.f28947e++;
            this.f28908W.mo31992f();
            return true;
        } else {
            try {
                if (!this.f28908W.mo31986a(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.f29107U.f28946d++;
                return true;
            } catch (zzmm | zzmp e) {
                throw zzku.m30599a(e, mo31924n());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public final void mo32007v() throws zzku {
        try {
            this.f28908W.mo31994h();
        } catch (zzmp e) {
            throw zzku.m30599a(e, mo31924n());
        }
    }

    /* renamed from: a */
    public final void mo31905a(int i, Object obj) throws zzku {
        if (i == 2) {
            this.f28908W.mo31982a(((Float) obj).floatValue());
        } else if (i != 3) {
            super.mo31905a(i, obj);
        } else {
            this.f28908W.mo31983a(((Integer) obj).intValue());
        }
    }
}
