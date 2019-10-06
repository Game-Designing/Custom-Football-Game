package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.util.Log;
import java.lang.reflect.Method;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@TargetApi(16)
public final class zzhq {

    /* renamed from: a */
    private static boolean f28533a = false;

    /* renamed from: A */
    private int f28534A;

    /* renamed from: B */
    private boolean f28535B;

    /* renamed from: C */
    private int f28536C;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ConditionVariable f28537b = new ConditionVariable(true);

    /* renamed from: c */
    private final long[] f28538c;

    /* renamed from: d */
    private final C9263Yq f28539d;

    /* renamed from: e */
    private AudioTrack f28540e;

    /* renamed from: f */
    private int f28541f;

    /* renamed from: g */
    private int f28542g;

    /* renamed from: h */
    private int f28543h;

    /* renamed from: i */
    private int f28544i;

    /* renamed from: j */
    private int f28545j;

    /* renamed from: k */
    private int f28546k;

    /* renamed from: l */
    private int f28547l;

    /* renamed from: m */
    private int f28548m;

    /* renamed from: n */
    private long f28549n;

    /* renamed from: o */
    private long f28550o;

    /* renamed from: p */
    private boolean f28551p;

    /* renamed from: q */
    private long f28552q;

    /* renamed from: r */
    private Method f28553r;

    /* renamed from: s */
    private long f28554s;

    /* renamed from: t */
    private int f28555t;

    /* renamed from: u */
    private long f28556u;

    /* renamed from: v */
    private long f28557v;

    /* renamed from: w */
    private long f28558w;

    /* renamed from: x */
    private float f28559x;

    /* renamed from: y */
    private byte[] f28560y;

    /* renamed from: z */
    private int f28561z;

    public zzhq() {
        if (zzkq.f28747a >= 18) {
            try {
                this.f28553r = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (zzkq.f28747a >= 19) {
            this.f28539d = new C9284Zq();
        } else {
            this.f28539d = new C9263Yq(null);
        }
        this.f28538c = new long[10];
        this.f28559x = 1.0f;
        this.f28555t = 0;
    }

    /* renamed from: a */
    public final boolean mo31824a() {
        return this.f28540e != null;
    }

    /* renamed from: a */
    public final long mo31821a(boolean z) {
        long j;
        if (!(mo31824a() && this.f28556u != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.f28540e.getPlayState() == 3) {
            long c = this.f28539d.mo28797c();
            if (c != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.f28550o >= 30000) {
                    long[] jArr = this.f28538c;
                    int i = this.f28547l;
                    jArr[i] = c - nanoTime;
                    this.f28547l = (i + 1) % 10;
                    int i2 = this.f28548m;
                    if (i2 < 10) {
                        this.f28548m = i2 + 1;
                    }
                    this.f28550o = nanoTime;
                    this.f28549n = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.f28548m;
                        if (i3 >= i4) {
                            break;
                        }
                        this.f28549n += this.f28538c[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!this.f28535B && nanoTime - this.f28552q >= 500000) {
                    this.f28551p = this.f28539d.mo28798d();
                    String str = "AudioTrack";
                    if (this.f28551p) {
                        long e = this.f28539d.mo28799e() / 1000;
                        long f = this.f28539d.mo28800f();
                        if (e < this.f28557v) {
                            this.f28551p = false;
                        } else {
                            String str2 = ", ";
                            if (Math.abs(e - nanoTime) > 5000000) {
                                this.f28551p = false;
                                StringBuilder sb = new StringBuilder(Opcodes.L2I);
                                sb.append("Spurious audio timestamp (system clock mismatch): ");
                                sb.append(f);
                                sb.append(str2);
                                sb.append(e);
                                sb.append(str2);
                                sb.append(nanoTime);
                                sb.append(str2);
                                sb.append(c);
                                Log.w(str, sb.toString());
                            } else if (Math.abs(m30398b(f) - c) > 5000000) {
                                this.f28551p = false;
                                StringBuilder sb2 = new StringBuilder(Opcodes.L2D);
                                sb2.append("Spurious audio timestamp (frame position mismatch): ");
                                sb2.append(f);
                                sb2.append(str2);
                                sb2.append(e);
                                sb2.append(str2);
                                sb2.append(nanoTime);
                                sb2.append(str2);
                                sb2.append(c);
                                Log.w(str, sb2.toString());
                            }
                        }
                    }
                    Method method = this.f28553r;
                    if (method != null) {
                        try {
                            this.f28558w = (((long) ((Integer) method.invoke(this.f28540e, null)).intValue()) * 1000) - m30398b(m30396a((long) this.f28546k));
                            this.f28558w = Math.max(this.f28558w, 0);
                            if (this.f28558w > 5000000) {
                                long j2 = this.f28558w;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j2);
                                Log.w(str, sb3.toString());
                                this.f28558w = 0;
                            }
                        } catch (Exception e2) {
                            this.f28553r = null;
                        }
                    }
                    this.f28552q = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.f28551p) {
            j = m30398b(this.f28539d.mo28800f() + m30399c(nanoTime2 - (this.f28539d.mo28799e() / 1000))) + this.f28556u;
        } else {
            if (this.f28548m == 0) {
                j = this.f28539d.mo28797c() + this.f28556u;
            } else {
                j = nanoTime2 + this.f28549n + this.f28556u;
            }
            if (!z) {
                j -= this.f28558w;
            }
        }
        return j;
    }

    /* renamed from: a */
    public final int mo31819a(int i) throws zzhu {
        this.f28537b.block();
        if (i == 0) {
            AudioTrack audioTrack = new AudioTrack(3, this.f28541f, this.f28542g, this.f28543h, this.f28546k, 1);
            this.f28540e = audioTrack;
        } else {
            AudioTrack audioTrack2 = new AudioTrack(3, this.f28541f, this.f28542g, this.f28543h, this.f28546k, 1, i);
            this.f28540e = audioTrack2;
        }
        int state = this.f28540e.getState();
        if (state == 1) {
            int audioSessionId = this.f28540e.getAudioSessionId();
            this.f28539d.mo28794a(this.f28540e, this.f28535B);
            mo31822a(this.f28559x);
            return audioSessionId;
        }
        try {
            this.f28540e.release();
        } catch (Exception e) {
        } finally {
            this.f28540e = null;
        }
        throw new zzhu(state, this.f28541f, this.f28542g, this.f28546k);
    }

    /* renamed from: a */
    public final void mo31823a(MediaFormat mediaFormat, int i) {
        int i2;
        int integer = mediaFormat.getInteger("channel-count");
        boolean z = true;
        if (integer == 1) {
            i2 = 4;
        } else if (integer == 2) {
            i2 = 12;
        } else if (integer == 6) {
            i2 = 252;
        } else if (integer == 8) {
            i2 = 1020;
        } else {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unsupported channel count: ");
            sb.append(integer);
            throw new IllegalArgumentException(sb.toString());
        }
        int integer2 = mediaFormat.getInteger("sample-rate");
        String string = mediaFormat.getString("mime");
        int i3 = "audio/ac3".equals(string) ? 5 : "audio/eac3".equals(string) ? 6 : zzkl.m30545b(string) ? 2 : 0;
        boolean z2 = i3 == 5 || i3 == 6;
        if (!mo31824a() || this.f28541f != integer2 || this.f28542g != i2 || this.f28535B || z2) {
            mo31827d();
            this.f28543h = i3;
            this.f28541f = integer2;
            this.f28542g = i2;
            this.f28535B = z2;
            this.f28536C = 0;
            this.f28544i = integer * 2;
            this.f28545j = AudioTrack.getMinBufferSize(integer2, i2, i3);
            if (this.f28545j == -2) {
                z = false;
            }
            zzkh.m30537b(z);
            int i4 = this.f28545j << 2;
            int c = ((int) m30399c(250000)) * this.f28544i;
            int max = (int) Math.max((long) this.f28545j, m30399c(750000) * ((long) this.f28544i));
            if (i4 < c) {
                i4 = c;
            } else if (i4 > max) {
                i4 = max;
            }
            this.f28546k = i4;
        }
    }

    /* renamed from: c */
    public final void mo31826c() {
        if (mo31824a()) {
            this.f28557v = System.nanoTime() / 1000;
            this.f28540e.play();
        }
    }

    /* renamed from: e */
    public final void mo31828e() {
        if (this.f28555t == 1) {
            this.f28555t = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo31820a(java.nio.ByteBuffer r11, int r12, int r13, long r14) throws com.google.android.gms.internal.ads.zzhv {
        /*
            r10 = this;
            r0 = 2
            if (r13 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = com.google.android.gms.internal.ads.zzkq.f28747a
            r2 = 22
            r3 = 0
            r5 = 1
            r6 = 0
            if (r1 > r2) goto L_0x002e
            boolean r1 = r10.f28535B
            if (r1 == 0) goto L_0x002e
            android.media.AudioTrack r1 = r10.f28540e
            int r1 = r1.getPlayState()
            if (r1 != r0) goto L_0x001b
            return r6
        L_0x001b:
            android.media.AudioTrack r1 = r10.f28540e
            int r1 = r1.getPlayState()
            if (r1 != r5) goto L_0x002e
            com.google.android.gms.internal.ads.Yq r1 = r10.f28539d
            long r1 = r1.mo28796b()
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x002e
            return r6
        L_0x002e:
            int r1 = r10.f28534A
            if (r1 != 0) goto L_0x00ad
            boolean r1 = r10.f28535B
            if (r1 == 0) goto L_0x0043
            int r1 = r10.f28536C
            if (r1 != 0) goto L_0x0043
            int r1 = r10.f28541f
            int r1 = com.google.android.gms.internal.ads.zzkg.m30531a(r13, r1)
            r10.f28536C = r1
        L_0x0043:
            long r1 = (long) r13
            long r1 = r10.m30396a(r1)
            long r1 = r10.m30398b(r1)
            long r14 = r14 - r1
            long r1 = r10.f28556u
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x005c
            long r14 = java.lang.Math.max(r3, r14)
            r10.f28556u = r14
            r10.f28555t = r5
            goto L_0x00ad
        L_0x005c:
            long r3 = r10.f28554s
            long r3 = r10.m30396a(r3)
            long r3 = r10.m30398b(r3)
            long r1 = r1 + r3
            int r3 = r10.f28555t
            if (r3 != r5) goto L_0x009f
            long r3 = r1 - r14
            long r3 = java.lang.Math.abs(r3)
            r7 = 200000(0x30d40, double:9.8813E-319)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x009f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 80
            r3.<init>(r4)
            java.lang.String r4 = "Discontinuity detected [expected "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = ", got "
            r3.append(r4)
            r3.append(r14)
            java.lang.String r4 = "]"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "AudioTrack"
            android.util.Log.e(r4, r3)
            r10.f28555t = r0
        L_0x009f:
            int r3 = r10.f28555t
            if (r3 != r0) goto L_0x00ad
            long r3 = r10.f28556u
            long r14 = r14 - r1
            long r3 = r3 + r14
            r10.f28556u = r3
            r10.f28555t = r5
            r14 = 1
            goto L_0x00ae
        L_0x00ad:
            r14 = 0
        L_0x00ae:
            int r15 = r10.f28534A
            r0 = 21
            if (r15 != 0) goto L_0x00cf
            r10.f28534A = r13
            r11.position(r12)
            int r12 = com.google.android.gms.internal.ads.zzkq.f28747a
            if (r12 >= r0) goto L_0x00cf
            byte[] r12 = r10.f28560y
            if (r12 == 0) goto L_0x00c4
            int r12 = r12.length
            if (r12 >= r13) goto L_0x00c8
        L_0x00c4:
            byte[] r12 = new byte[r13]
            r10.f28560y = r12
        L_0x00c8:
            byte[] r12 = r10.f28560y
            r11.get(r12, r6, r13)
            r10.f28561z = r6
        L_0x00cf:
            int r12 = com.google.android.gms.internal.ads.zzkq.f28747a
            if (r12 >= r0) goto L_0x0100
            long r11 = r10.f28554s
            com.google.android.gms.internal.ads.Yq r13 = r10.f28539d
            long r0 = r13.mo28796b()
            int r13 = r10.f28544i
            long r2 = (long) r13
            long r0 = r0 * r2
            long r11 = r11 - r0
            int r12 = (int) r11
            int r11 = r10.f28546k
            int r11 = r11 - r12
            if (r11 <= 0) goto L_0x00ff
            int r12 = r10.f28534A
            int r11 = java.lang.Math.min(r12, r11)
            android.media.AudioTrack r12 = r10.f28540e
            byte[] r13 = r10.f28560y
            int r15 = r10.f28561z
            int r6 = r12.write(r13, r15, r11)
            if (r6 < 0) goto L_0x00ff
            int r11 = r10.f28561z
            int r11 = r11 + r6
            r10.f28561z = r11
        L_0x00ff:
            goto L_0x0109
        L_0x0100:
            android.media.AudioTrack r12 = r10.f28540e
            int r13 = r10.f28534A
            int r6 = r12.write(r11, r13, r5)
        L_0x0109:
            if (r6 < 0) goto L_0x011d
            int r11 = r10.f28534A
            int r11 = r11 - r6
            r10.f28534A = r11
            long r11 = r10.f28554s
            long r0 = (long) r6
            long r11 = r11 + r0
            r10.f28554s = r11
            int r11 = r10.f28534A
            if (r11 != 0) goto L_0x011c
            r14 = r14 | 2
        L_0x011c:
            return r14
        L_0x011d:
            com.google.android.gms.internal.ads.zzhv r11 = new com.google.android.gms.internal.ads.zzhv
            r11.<init>(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhq.mo31820a(java.nio.ByteBuffer, int, int, long):int");
    }

    /* renamed from: f */
    public final boolean mo31829f() {
        return mo31824a() && (m30396a(this.f28554s) > this.f28539d.mo28796b() || this.f28539d.mo28795a());
    }

    /* renamed from: g */
    public final boolean mo31830g() {
        return this.f28554s > ((long) ((this.f28545j * 3) / 2));
    }

    /* renamed from: a */
    public final void mo31822a(float f) {
        this.f28559x = f;
        if (mo31824a()) {
            if (zzkq.f28747a >= 21) {
                this.f28540e.setVolume(f);
                return;
            }
            this.f28540e.setStereoVolume(f, f);
        }
    }

    /* renamed from: b */
    public final void mo31825b() {
        if (mo31824a()) {
            m30400h();
            this.f28540e.pause();
        }
    }

    /* renamed from: d */
    public final void mo31827d() {
        if (mo31824a()) {
            this.f28554s = 0;
            this.f28534A = 0;
            this.f28556u = 0;
            this.f28558w = 0;
            m30400h();
            if (this.f28540e.getPlayState() == 3) {
                this.f28540e.pause();
            }
            AudioTrack audioTrack = this.f28540e;
            this.f28540e = null;
            this.f28539d.mo28794a(null, false);
            this.f28537b.close();
            new C9242Xq(this, audioTrack).start();
        }
    }

    /* renamed from: a */
    private final long m30396a(long j) {
        if (!this.f28535B) {
            return j / ((long) this.f28544i);
        }
        int i = this.f28536C;
        if (i == 0) {
            return 0;
        }
        return ((j << 3) * ((long) this.f28541f)) / ((long) (i * 1000));
    }

    /* renamed from: b */
    private final long m30398b(long j) {
        return (j * 1000000) / ((long) this.f28541f);
    }

    /* renamed from: c */
    private final long m30399c(long j) {
        return (j * ((long) this.f28541f)) / 1000000;
    }

    /* renamed from: h */
    private final void m30400h() {
        this.f28549n = 0;
        this.f28548m = 0;
        this.f28547l = 0;
        this.f28550o = 0;
        this.f28551p = false;
        this.f28552q = 0;
    }
}
