package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;

@TargetApi(16)
@zzard
public final class zzbdq extends zzbco implements SurfaceTextureListener {

    /* renamed from: A */
    private int f25189A;

    /* renamed from: B */
    private final zzgh f25190B = new C9208Wd(this);

    /* renamed from: C */
    private final zzhh f25191C = new C9229Xd(this);

    /* renamed from: D */
    private final zzgq f25192D = new C9250Yd(this);

    /* renamed from: c */
    private float f25193c;

    /* renamed from: d */
    private final zzbdf f25194d;

    /* renamed from: e */
    private final Context f25195e;

    /* renamed from: f */
    private final int f25196f;

    /* renamed from: g */
    private final zzbdg f25197g;

    /* renamed from: h */
    private final boolean f25198h;

    /* renamed from: i */
    private final zzbde f25199i;

    /* renamed from: j */
    private zzbcn f25200j;

    /* renamed from: k */
    private Surface f25201k;

    /* renamed from: l */
    private zzbdk f25202l;

    /* renamed from: m */
    private zzge f25203m;

    /* renamed from: n */
    private zzhd f25204n;

    /* renamed from: o */
    private zzgn f25205o;

    /* renamed from: p */
    private String f25206p;

    /* renamed from: q */
    private boolean f25207q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f25208r = 1;

    /* renamed from: s */
    private zzbdd f25209s;

    /* renamed from: t */
    private boolean f25210t;

    /* renamed from: u */
    private boolean f25211u;

    /* renamed from: v */
    private boolean f25212v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f25213w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f25214x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public float f25215y;

    /* renamed from: z */
    private int f25216z;

    public zzbdq(Context context, zzbdg zzbdg, zzbdf zzbdf, int i, boolean z, boolean z2, zzbde zzbde) {
        super(context);
        this.f25195e = context;
        this.f25198h = z2;
        this.f25194d = zzbdf;
        this.f25196f = i;
        this.f25197g = zzbdg;
        this.f25210t = z;
        this.f25199i = zzbde;
        setSurfaceTextureListener(this);
        this.f25197g.mo30432a(this);
    }

    /* renamed from: m */
    private final boolean m26578m() {
        return this.f25203m != null && !this.f25207q;
    }

    /* renamed from: n */
    private final boolean m26579n() {
        return m26578m() && this.f25208r != 1;
    }

    /* JADX WARNING: type inference failed for: r0v34, types: [com.google.android.gms.internal.ads.zzgl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m26580o() {
        /*
            r14 = this;
            com.google.android.gms.internal.ads.zzge r0 = r14.f25203m
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = r14.f25206p
            if (r0 == 0) goto L_0x0229
            android.view.Surface r1 = r14.f25201k
            if (r1 == 0) goto L_0x0229
            java.lang.String r1 = "cache:"
            boolean r0 = r0.startsWith(r1)
            java.lang.String r1 = "AdExoPlayerHelper Error"
            java.lang.String r2 = "video/webm"
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L_0x0134
            com.google.android.gms.internal.ads.zzbdf r0 = r14.f25194d
            java.lang.String r5 = r14.f25206p
            com.google.android.gms.internal.ads.zzbft r0 = r0.mo28736b(r5)
            if (r0 == 0) goto L_0x003f
            boolean r5 = r0 instanceof com.google.android.gms.internal.ads.zzbgl
            if (r5 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzbgl r0 = (com.google.android.gms.internal.ads.zzbgl) r0
            r0.mo30563d()
            com.google.android.gms.internal.ads.zzbdk r4 = r0.mo30564e()
            com.google.android.gms.internal.ads.zzgh r0 = r14.f25190B
            com.google.android.gms.internal.ads.zzhh r1 = r14.f25191C
            com.google.android.gms.internal.ads.zzgq r2 = r14.f25192D
            r4.mo30445a(r0, r1, r2)
            goto L_0x01d6
        L_0x003f:
            boolean r5 = r0 instanceof com.google.android.gms.internal.ads.zzbgg
            if (r5 == 0) goto L_0x0116
            com.google.android.gms.internal.ads.zzbgg r0 = (com.google.android.gms.internal.ads.zzbgg) r0
            java.nio.ByteBuffer r5 = r0.mo30557c()
            java.lang.String r6 = r0.mo30558d()
            boolean r0 = r0.mo30559e()
            com.google.android.gms.internal.ads.zzbdk r7 = new com.google.android.gms.internal.ads.zzbdk
            r7.<init>()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0064
            com.google.android.gms.internal.ads.zzjg r2 = new com.google.android.gms.internal.ads.zzjg
            r2.<init>()
            goto L_0x0069
        L_0x0064:
            com.google.android.gms.internal.ads.zziv r2 = new com.google.android.gms.internal.ads.zziv
            r2.<init>()
        L_0x0069:
            r11 = r2
            if (r0 == 0) goto L_0x0090
            int r0 = r5.limit()
            if (r0 <= 0) goto L_0x0090
            int r0 = r5.limit()
            byte[] r0 = new byte[r0]
            r5.get(r0)
            com.google.android.gms.internal.ads.zzjo r10 = new com.google.android.gms.internal.ads.zzjo
            r10.<init>(r0)
            com.google.android.gms.internal.ads.zzig r0 = new com.google.android.gms.internal.ads.zzig
            android.net.Uri r9 = android.net.Uri.parse(r6)
            r12 = 2
            com.google.android.gms.internal.ads.zzbde r2 = r14.f25199i
            int r13 = r2.f25149c
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
            goto L_0x00fe
        L_0x0090:
            com.google.android.gms.internal.ads.zzaxi r0 = com.google.android.gms.ads.internal.zzk.zzlg()
            com.google.android.gms.internal.ads.zzbdf r2 = r14.f25194d
            android.content.Context r2 = r2.getContext()
            com.google.android.gms.internal.ads.zzbdf r4 = r14.f25194d
            com.google.android.gms.internal.ads.zzbai r4 = r4.mo28793z()
            java.lang.String r4 = r4.f25057a
            java.lang.String r0 = r0.mo30237b(r2, r4)
            com.google.android.gms.internal.ads.zzjt r2 = new com.google.android.gms.internal.ads.zzjt
            com.google.android.gms.internal.ads.zzbdf r4 = r14.f25194d
            android.content.Context r4 = r4.getContext()
            r2.<init>(r4, r0)
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f24188vd
            com.google.android.gms.internal.ads.zzacr r4 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r0 = r4.mo29599a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00d0
            com.google.android.gms.internal.ads.zzbeh r0 = new com.google.android.gms.internal.ads.zzbeh
            android.content.Context r4 = r14.f25195e
            com.google.android.gms.internal.ads.Kd r8 = new com.google.android.gms.internal.ads.Kd
            r8.<init>(r14)
            r0.<init>(r4, r2, r8)
            goto L_0x00d1
        L_0x00d0:
            r0 = r2
        L_0x00d1:
            int r2 = r5.limit()
            if (r2 <= 0) goto L_0x00ee
            int r2 = r5.limit()
            byte[] r2 = new byte[r2]
            r5.get(r2)
            com.google.android.gms.internal.ads.zzjo r4 = new com.google.android.gms.internal.ads.zzjo
            r4.<init>(r2)
            com.google.android.gms.internal.ads.Zd r5 = new com.google.android.gms.internal.ads.Zd
            int r2 = r2.length
            r5.<init>(r4, r2, r0)
            r10 = r5
            goto L_0x00ef
        L_0x00ee:
            r10 = r0
        L_0x00ef:
            com.google.android.gms.internal.ads.zzig r0 = new com.google.android.gms.internal.ads.zzig
            android.net.Uri r9 = android.net.Uri.parse(r6)
            r12 = 2
            com.google.android.gms.internal.ads.zzbde r2 = r14.f25199i
            int r13 = r2.f25149c
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
        L_0x00fe:
            com.google.android.gms.internal.ads.zzgh r2 = r14.f25190B
            com.google.android.gms.internal.ads.zzhh r4 = r14.f25191C
            com.google.android.gms.internal.ads.zzgq r5 = r14.f25192D
            r7.mo30445a(r2, r4, r5)
            boolean r0 = r7.mo30446a(r0)
            if (r0 != 0) goto L_0x0113
            java.lang.String r0 = "Prepare from ByteBuffer failed."
            r14.m26571b(r1, r0)
        L_0x0113:
            r4 = r7
            goto L_0x01d6
        L_0x0116:
            java.lang.String r0 = "Source is MD5 but not found in cache. Source: "
            java.lang.String r1 = r14.f25206p
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x0129
            java.lang.String r0 = r0.concat(r1)
            goto L_0x012f
        L_0x0129:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x012f:
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)
            goto L_0x01d6
        L_0x0134:
            int r0 = r14.f25196f
            r5 = 2
            r6 = 1
            if (r0 != r6) goto L_0x014e
            com.google.android.gms.internal.ads.zzgl r0 = new com.google.android.gms.internal.ads.zzgl
            com.google.android.gms.internal.ads.zzbdf r2 = r14.f25194d
            android.content.Context r2 = r2.getContext()
            java.lang.String r6 = r14.f25206p
            android.net.Uri r6 = android.net.Uri.parse(r6)
            r0.<init>(r2, r6, r4, r5)
            goto L_0x01ba
        L_0x014e:
            if (r0 != r5) goto L_0x0151
            goto L_0x0152
        L_0x0151:
            r6 = 0
        L_0x0152:
            com.google.android.gms.common.internal.Preconditions.m21863a(r6)
            com.google.android.gms.internal.ads.zzaxi r0 = com.google.android.gms.ads.internal.zzk.zzlg()
            com.google.android.gms.internal.ads.zzbdf r5 = r14.f25194d
            android.content.Context r5 = r5.getContext()
            com.google.android.gms.internal.ads.zzbdf r6 = r14.f25194d
            com.google.android.gms.internal.ads.zzbai r6 = r6.mo28793z()
            java.lang.String r6 = r6.f25057a
            java.lang.String r0 = r0.mo30237b(r5, r6)
            com.google.android.gms.internal.ads.zzjt r5 = new com.google.android.gms.internal.ads.zzjt
            com.google.android.gms.internal.ads.zzbdf r6 = r14.f25194d
            android.content.Context r6 = r6.getContext()
            r5.<init>(r6, r0)
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f24188vd
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r0 = r6.mo29599a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0196
            com.google.android.gms.internal.ads.zzbeh r0 = new com.google.android.gms.internal.ads.zzbeh
            android.content.Context r6 = r14.f25195e
            com.google.android.gms.internal.ads.Jd r7 = new com.google.android.gms.internal.ads.Jd
            r7.<init>(r14)
            r0.<init>(r6, r5, r7)
            r10 = r0
            goto L_0x0197
        L_0x0196:
            r10 = r5
        L_0x0197:
            boolean r0 = r2.equals(r4)
            if (r0 == 0) goto L_0x01a3
            com.google.android.gms.internal.ads.zzjg r0 = new com.google.android.gms.internal.ads.zzjg
            r0.<init>()
            goto L_0x01a8
        L_0x01a3:
            com.google.android.gms.internal.ads.zziv r0 = new com.google.android.gms.internal.ads.zziv
            r0.<init>()
        L_0x01a8:
            r11 = r0
            com.google.android.gms.internal.ads.zzig r0 = new com.google.android.gms.internal.ads.zzig
            java.lang.String r2 = r14.f25206p
            android.net.Uri r9 = android.net.Uri.parse(r2)
            r12 = 2
            com.google.android.gms.internal.ads.zzbde r2 = r14.f25199i
            int r13 = r2.f25149c
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
        L_0x01ba:
            com.google.android.gms.internal.ads.zzbdk r4 = new com.google.android.gms.internal.ads.zzbdk
            r4.<init>()
            com.google.android.gms.internal.ads.zzgh r2 = r14.f25190B
            com.google.android.gms.internal.ads.zzhh r5 = r14.f25191C
            com.google.android.gms.internal.ads.zzgq r6 = r14.f25192D
            r4.mo30445a(r2, r5, r6)
            boolean r0 = r4.mo30446a(r0)
            if (r0 != 0) goto L_0x01d6
            java.lang.String r0 = "Prepare failed."
            r14.m26571b(r1, r0)
        L_0x01d6:
            r14.f25202l = r4
            com.google.android.gms.internal.ads.zzbdk r0 = r14.f25202l
            if (r0 != 0) goto L_0x01fa
            java.lang.String r0 = "AdExoPlayerHelper is null. Source: "
            java.lang.String r1 = r14.f25206p
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x01f0
            java.lang.String r0 = r0.concat(r1)
            goto L_0x01f6
        L_0x01f0:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x01f6:
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)
            return
        L_0x01fa:
            com.google.android.gms.internal.ads.zzge r0 = r0.mo30448e()
            r14.f25203m = r0
            com.google.android.gms.internal.ads.zzbdk r0 = r14.f25202l
            com.google.android.gms.internal.ads.zzhd r0 = r0.mo30449f()
            r14.f25204n = r0
            com.google.android.gms.internal.ads.zzbdk r0 = r14.f25202l
            com.google.android.gms.internal.ads.zzgn r0 = r0.mo30451g()
            r14.f25205o = r0
            com.google.android.gms.internal.ads.zzge r0 = r14.f25203m
            if (r0 == 0) goto L_0x0229
            android.view.Surface r0 = r14.f25201k
            r14.m26566a(r0, r3)
            com.google.android.gms.internal.ads.zzge r0 = r14.f25203m
            int r0 = r0.mo28341i()
            r14.f25208r = r0
            int r0 = r14.f25208r
            r1 = 4
            if (r0 != r1) goto L_0x0229
            r14.m26581p()
        L_0x0229:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdq.m26580o():void");
    }

    /* renamed from: a */
    private final void m26566a(Surface surface, boolean z) {
        zzge zzge = this.f25203m;
        if (zzge != null) {
            zzhd zzhd = this.f25204n;
            if (zzhd != null) {
                if (z) {
                    zzge.mo28332a(zzhd, 1, surface);
                    return;
                } else {
                    zzge.mo28337b(zzhd, 1, surface);
                    return;
                }
            }
        }
        zzbad.m26359d("Trying to set surface before player and renderers are initalized.");
    }

    /* renamed from: a */
    private final void m26564a(float f, boolean z) {
        zzge zzge = this.f25203m;
        if (zzge != null) {
            zzgn zzgn = this.f25205o;
            if (zzgn != null) {
                if (z) {
                    zzge.mo28332a(zzgn, 1, Float.valueOf(f));
                    return;
                } else {
                    zzge.mo28337b(zzgn, 1, Float.valueOf(f));
                    return;
                }
            }
        }
        zzbad.m26359d("Trying to set volume before player and renderers are initalized.");
    }

    /* renamed from: a */
    public final void mo28179a() {
        m26564a(this.f25094b.mo30437a(), false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m26565a(int i, int i2, float f) {
        float f2 = i2 == 0 ? 1.0f : (((float) i) * f) / ((float) i2);
        if (this.f25193c != f2) {
            this.f25193c = f2;
            requestLayout();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public final void m26581p() {
        if (!this.f25211u) {
            this.f25211u = true;
            zzawz.m26003f("Video is ready.");
            zzaxi.f24961a.post(new C9037Od(this));
            mo28179a();
            this.f25197g.mo30433b();
            if (this.f25212v) {
                mo30351c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m26577l() {
        zzawz.m26003f("Video ended.");
        if (this.f25199i.f25147a) {
            m26583r();
        }
        this.f25197g.mo30436d();
        this.f25094b.mo30441c();
        zzaxi.f24961a.post(new C9058Pd(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m26571b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 19 + String.valueOf(str2).length());
        sb.append("Error received: ");
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        zzbad.m26359d(sb.toString());
        this.f25207q = true;
        if (this.f25199i.f25147a) {
            m26583r();
        }
        zzaxi.f24961a.post(new C9079Qd(this, str, str2));
    }

    /* renamed from: e */
    public final String mo30353e() {
        String str;
        int i = this.f25196f;
        if (i == 1) {
            str = "/Framework";
        } else if (i == 2) {
            StringBuilder sb = new StringBuilder(String.valueOf(null).length() + 12);
            sb.append("/Extractor(");
            sb.append(null);
            sb.append(")");
            str = sb.toString();
        } else {
            str = "/Unknown";
        }
        String str2 = this.f25210t ? " spherical" : "";
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str2).length());
        sb2.append("ExoPlayer/1");
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: a */
    public final void mo30348a(zzbcn zzbcn) {
        this.f25200j = zzbcn;
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.f25206p = str;
            m26580o();
            return;
        }
        zzbad.m26359d("Path is null.");
    }

    /* renamed from: c */
    public final void mo30351c() {
        if (m26579n()) {
            if (this.f25199i.f25147a) {
                m26582q();
            }
            this.f25203m.mo28334a(true);
            this.f25197g.mo30435c();
            this.f25094b.mo30440b();
            this.f25093a.mo30417a();
            zzaxi.f24961a.post(new C9099Rd(this));
            return;
        }
        this.f25212v = true;
    }

    /* renamed from: d */
    public final void mo30352d() {
        if (m26578m()) {
            this.f25203m.stop();
            if (this.f25203m != null) {
                m26566a((Surface) null, true);
                zzbdk zzbdk = this.f25202l;
                if (zzbdk != null) {
                    zzbdk.mo30447d();
                    this.f25202l = null;
                }
                this.f25203m = null;
                this.f25204n = null;
                this.f25205o = null;
                this.f25208r = 1;
                this.f25207q = false;
                this.f25211u = false;
                this.f25212v = false;
            }
        }
        this.f25197g.mo30436d();
        this.f25094b.mo30441c();
        this.f25197g.mo30431a();
    }

    /* renamed from: b */
    public final void mo30349b() {
        if (m26579n()) {
            if (this.f25199i.f25147a) {
                m26583r();
            }
            this.f25203m.mo28334a(false);
            this.f25197g.mo30436d();
            this.f25094b.mo30441c();
            zzaxi.f24961a.post(new C9120Sd(this));
        }
    }

    /* renamed from: b */
    public final void mo30350b(int i) {
        if (m26579n()) {
            this.f25203m.mo28330a((long) i);
        }
    }

    /* renamed from: a */
    public final void mo30347a(float f, float f2) {
        zzbdd zzbdd = this.f25209s;
        if (zzbdd != null) {
            zzbdd.mo30422a(f, f2);
        }
    }

    public final int getCurrentPosition() {
        if (m26579n()) {
            return (int) this.f25203m.mo28338c();
        }
        return 0;
    }

    public final int getDuration() {
        if (m26579n()) {
            return (int) this.f25203m.getDuration();
        }
        return 0;
    }

    public final int getVideoWidth() {
        return this.f25213w;
    }

    public final int getVideoHeight() {
        return this.f25214x;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r0 != r11) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            super.onMeasure(r10, r11)
            int r10 = r9.getMeasuredWidth()
            int r11 = r9.getMeasuredHeight()
            float r0 = r9.f25193c
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzbdd r2 = r9.f25209s
            if (r2 != 0) goto L_0x0033
            float r2 = (float) r10
            float r3 = (float) r11
            float r4 = r2 / r3
            float r4 = r0 / r4
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r5
            r5 = 1008981770(0x3c23d70a, float:0.01)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0029
            float r2 = r2 / r0
            int r11 = (int) r2
            goto L_0x0033
        L_0x0029:
            r2 = -1138501878(0xffffffffbc23d70a, float:-0.01)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0033
            float r3 = r3 * r0
            int r10 = (int) r3
        L_0x0033:
            r9.setMeasuredDimension(r10, r11)
            com.google.android.gms.internal.ads.zzbdd r0 = r9.f25209s
            if (r0 == 0) goto L_0x003d
            r0.mo30423a(r10, r11)
        L_0x003d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00b7
            int r0 = r9.f25216z
            if (r0 <= 0) goto L_0x0049
            if (r0 != r10) goto L_0x004f
        L_0x0049:
            int r0 = r9.f25189A
            if (r0 <= 0) goto L_0x00b3
            if (r0 == r11) goto L_0x00b3
        L_0x004f:
            boolean r0 = r9.f25198h
            if (r0 == 0) goto L_0x00b3
            boolean r0 = r9.m26578m()
            if (r0 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzge r0 = r9.f25203m
            long r2 = r0.mo28338c()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzge r0 = r9.f25203m
            boolean r0 = r0.mo28339d()
            if (r0 != 0) goto L_0x00b3
            r0 = 1
            r9.m26564a(r1, r0)
            com.google.android.gms.internal.ads.zzge r1 = r9.f25203m
            r1.mo28334a(r0)
            com.google.android.gms.internal.ads.zzge r0 = r9.f25203m
            long r0 = r0.mo28338c()
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzk.zzln()
            long r2 = r2.mo27935b()
        L_0x0085:
            boolean r4 = r9.m26578m()
            if (r4 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzge r4 = r9.f25203m
            long r4 = r4.mo28338c()
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x00a4
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzk.zzln()
            long r4 = r4.mo27935b()
            long r4 = r4 - r2
            r6 = 250(0xfa, double:1.235E-321)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0085
        L_0x00a4:
            boolean r0 = r9.m26578m()
            if (r0 == 0) goto L_0x00b0
            com.google.android.gms.internal.ads.zzge r0 = r9.f25203m
            r1 = 0
            r0.mo28334a(r1)
        L_0x00b0:
            r9.mo28179a()
        L_0x00b3:
            r9.f25216z = r10
            r9.f25189A = r11
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdq.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f25210t) {
            this.f25209s = new zzbdd(getContext());
            this.f25209s.mo30424a(surfaceTexture, i, i2);
            this.f25209s.start();
            SurfaceTexture c = this.f25209s.mo30426c();
            if (c != null) {
                surfaceTexture = c;
            } else {
                this.f25209s.mo30425b();
                this.f25209s = null;
            }
        }
        this.f25201k = new Surface(surfaceTexture);
        if (this.f25203m == null) {
            m26580o();
        } else {
            m26566a(this.f25201k, true);
            if (!this.f25199i.f25147a) {
                m26582q();
            }
        }
        float f = 1.0f;
        int i3 = this.f25213w;
        if (i3 != 0) {
            int i4 = this.f25214x;
            if (i4 != 0) {
                f = this.f25215y;
                i = i3;
                i2 = i4;
            }
        }
        m26565a(i, i2, f);
        zzaxi.f24961a.post(new C9145Td(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbdd zzbdd = this.f25209s;
        if (zzbdd != null) {
            zzbdd.mo30423a(i, i2);
        }
        zzaxi.f24961a.post(new C9166Ud(this, i, i2));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawz.m26003f("Surface destroyed");
        mo30349b();
        zzbdd zzbdd = this.f25209s;
        if (zzbdd != null) {
            zzbdd.mo30425b();
            this.f25209s = null;
        }
        if (this.f25203m != null) {
            m26583r();
            Surface surface = this.f25201k;
            if (surface != null) {
                surface.release();
            }
            this.f25201k = null;
            m26566a((Surface) null, true);
        }
        zzaxi.f24961a.post(new C9187Vd(this));
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f25197g.mo30434b(this);
        this.f25093a.mo30418a(surfaceTexture, this.f25200j);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView1 window visibility changed to ");
        sb.append(i);
        zzawz.m26003f(sb.toString());
        zzaxi.f24961a.post(new C8974Ld(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* renamed from: q */
    private final void m26582q() {
        zzge zzge = this.f25203m;
        if (zzge != null) {
            zzge.mo28329a(0, true);
        }
    }

    /* renamed from: r */
    private final void m26583r() {
        zzge zzge = this.f25203m;
        if (zzge != null) {
            zzge.mo28329a(0, false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final /* synthetic */ void mo30459h(int i) {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final /* synthetic */ void mo30456f() {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.mo30376f();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo30453b(int i, int i2) {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.mo30373a(i, i2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final /* synthetic */ void mo30457g() {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.mo30380j();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final /* synthetic */ void mo30458h() {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.mo30381k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final /* synthetic */ void mo30460i() {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.mo30378h();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30452a(String str, String str2) {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.mo30374a(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public final /* synthetic */ void mo30461j() {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.mo30377g();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public final /* synthetic */ void mo30462k() {
        zzbcn zzbcn = this.f25200j;
        if (zzbcn != null) {
            zzbcn.mo30379i();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo30454b(boolean z, long j) {
        this.f25194d.mo28734a(z, j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final /* synthetic */ void mo30455c(boolean z, long j) {
        this.f25194d.mo28734a(z, j);
    }
}
