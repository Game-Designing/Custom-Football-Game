package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.gms.ads.internal.zzk;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
@zzard
public final class zzbek extends zzbco implements SurfaceTextureListener, zzbfi {

    /* renamed from: c */
    private final zzbdf f25222c;

    /* renamed from: d */
    private final zzbdg f25223d;

    /* renamed from: e */
    private final boolean f25224e;

    /* renamed from: f */
    private final zzbde f25225f;

    /* renamed from: g */
    private zzbcn f25226g;

    /* renamed from: h */
    private Surface f25227h;

    /* renamed from: i */
    private zzbfa f25228i;

    /* renamed from: j */
    private String f25229j;

    /* renamed from: k */
    private String[] f25230k;

    /* renamed from: l */
    private boolean f25231l;

    /* renamed from: m */
    private int f25232m = 1;

    /* renamed from: n */
    private zzbdd f25233n;

    /* renamed from: o */
    private final boolean f25234o;

    /* renamed from: p */
    private boolean f25235p;

    /* renamed from: q */
    private boolean f25236q;

    /* renamed from: r */
    private int f25237r;

    /* renamed from: s */
    private int f25238s;

    /* renamed from: t */
    private int f25239t;

    /* renamed from: u */
    private int f25240u;

    /* renamed from: v */
    private float f25241v;

    public zzbek(Context context, zzbdg zzbdg, zzbdf zzbdf, boolean z, boolean z2, zzbde zzbde) {
        super(context);
        this.f25224e = z2;
        this.f25222c = zzbdf;
        this.f25223d = zzbdg;
        this.f25234o = z;
        this.f25225f = zzbde;
        setSurfaceTextureListener(this);
        this.f25223d.mo30432a(this);
    }

    /* renamed from: o */
    private final zzbfa m26611o() {
        return new zzbfa(this.f25222c.getContext(), this.f25225f);
    }

    /* renamed from: p */
    private final String m26612p() {
        return zzk.zzlg().mo30237b(this.f25222c.getContext(), this.f25222c.mo28793z().f25057a);
    }

    /* renamed from: l */
    private final boolean m26608l() {
        return this.f25228i != null && !this.f25231l;
    }

    /* renamed from: m */
    private final boolean m26609m() {
        return m26608l() && this.f25232m != 1;
    }

    /* renamed from: q */
    private final void m26613q() {
        if (this.f25228i == null) {
            String str = this.f25229j;
            if (str != null && this.f25227h != null) {
                if (str.startsWith("cache:")) {
                    zzbft b = this.f25222c.mo28736b(this.f25229j);
                    if (b instanceof zzbgp) {
                        this.f25228i = ((zzbgp) b).mo30568c();
                    } else if (b instanceof zzbgo) {
                        zzbgo zzbgo = (zzbgo) b;
                        String p = m26612p();
                        ByteBuffer c = zzbgo.mo30565c();
                        boolean e = zzbgo.mo30567e();
                        String d = zzbgo.mo30566d();
                        if (d == null) {
                            zzbad.m26359d("Stream cache URL is null.");
                            return;
                        } else {
                            this.f25228i = m26611o();
                            this.f25228i.mo30525a(new Uri[]{Uri.parse(d)}, p, c, e);
                        }
                    } else {
                        String str2 = "Stream cache miss: ";
                        String valueOf = String.valueOf(this.f25229j);
                        zzbad.m26359d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                        return;
                    }
                } else {
                    this.f25228i = m26611o();
                    String p2 = m26612p();
                    Uri[] uriArr = new Uri[this.f25230k.length];
                    int i = 0;
                    while (true) {
                        String[] strArr = this.f25230k;
                        if (i >= strArr.length) {
                            break;
                        }
                        uriArr[i] = Uri.parse(strArr[i]);
                        i++;
                    }
                    this.f25228i.mo30524a(uriArr, p2);
                }
                this.f25228i.mo30509a((zzbfi) this);
                m26606a(this.f25227h, false);
                this.f25232m = this.f25228i.mo30531f().mo29284i();
                if (this.f25232m == 3) {
                    m26610n();
                }
            }
        }
    }

    /* renamed from: a */
    private final void m26606a(Surface surface, boolean z) {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30508a(surface, z);
        } else {
            zzbad.m26359d("Trying to set surface before player is initalized.");
        }
    }

    /* renamed from: a */
    private final void m26605a(float f, boolean z) {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30503a(f, z);
        } else {
            zzbad.m26359d("Trying to set volume before player is initalized.");
        }
    }

    /* renamed from: a */
    public final void mo28179a() {
        m26605a(this.f25094b.mo30437a(), false);
    }

    /* renamed from: n */
    private final void m26610n() {
        if (!this.f25235p) {
            this.f25235p = true;
            zzaxi.f24961a.post(new C9291_d(this));
            mo28179a();
            this.f25223d.mo30433b();
            if (this.f25236q) {
                mo30351c();
            }
        }
    }

    /* renamed from: e */
    public final String mo30353e() {
        String valueOf = String.valueOf("ExoPlayer/3");
        String valueOf2 = String.valueOf(this.f25234o ? " spherical" : "");
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: a */
    public final void mo30348a(zzbcn zzbcn) {
        this.f25226g = zzbcn;
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.f25229j = str;
            this.f25230k = new String[]{str};
            m26613q();
        }
    }

    /* renamed from: a */
    public final void mo30383a(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.f25229j = str;
            this.f25230k = (String[]) Arrays.copyOf(strArr, strArr.length);
            m26613q();
        }
    }

    /* renamed from: c */
    public final void mo30351c() {
        if (m26609m()) {
            if (this.f25225f.f25147a) {
                m26615s();
            }
            this.f25228i.mo30531f().mo29275a(true);
            this.f25223d.mo30435c();
            this.f25094b.mo30440b();
            this.f25093a.mo30417a();
            zzaxi.f24961a.post(new C9357ce(this));
            return;
        }
        this.f25236q = true;
    }

    /* renamed from: d */
    public final void mo30352d() {
        if (m26608l()) {
            this.f25228i.mo30531f().stop();
            if (this.f25228i != null) {
                m26606a((Surface) null, true);
                zzbfa zzbfa = this.f25228i;
                if (zzbfa != null) {
                    zzbfa.mo30509a((zzbfi) null);
                    this.f25228i.mo30530c();
                    this.f25228i = null;
                }
                this.f25232m = 1;
                this.f25231l = false;
                this.f25235p = false;
                this.f25236q = false;
            }
        }
        this.f25223d.mo30436d();
        this.f25094b.mo30441c();
        this.f25223d.mo30431a();
    }

    /* renamed from: b */
    public final void mo30349b() {
        if (m26609m()) {
            if (this.f25225f.f25147a) {
                m26616t();
            }
            this.f25228i.mo30531f().mo29275a(false);
            this.f25223d.mo30436d();
            this.f25094b.mo30441c();
            zzaxi.f24961a.post(new C9379de(this));
        }
    }

    /* renamed from: b */
    public final void mo30350b(int i) {
        if (m26609m()) {
            this.f25228i.mo30531f().mo29271a((long) i);
        }
    }

    /* renamed from: c */
    public final void mo30384c(int i) {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30533g().mo30497c(i);
        }
    }

    /* renamed from: d */
    public final void mo30385d(int i) {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30533g().mo30498d(i);
        }
    }

    /* renamed from: e */
    public final void mo30386e(int i) {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30533g().mo30490a(i);
        }
    }

    /* renamed from: f */
    public final void mo30387f(int i) {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30533g().mo30495b(i);
        }
    }

    /* renamed from: g */
    public final void mo30388g(int i) {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30504a(i);
        }
    }

    /* renamed from: a */
    public final void mo30347a(float f, float f2) {
        zzbdd zzbdd = this.f25233n;
        if (zzbdd != null) {
            zzbdd.mo30422a(f, f2);
        }
    }

    public final int getCurrentPosition() {
        if (m26609m()) {
            return (int) this.f25228i.mo30531f().mo29280c();
        }
        return 0;
    }

    public final int getDuration() {
        if (m26609m()) {
            return (int) this.f25228i.mo30531f().getDuration();
        }
        return 0;
    }

    public final int getVideoWidth() {
        return this.f25237r;
    }

    public final int getVideoHeight() {
        return this.f25238s;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r0 != r12) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r11 = r10.getMeasuredWidth()
            int r12 = r10.getMeasuredHeight()
            float r0 = r10.f25241v
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbdd r2 = r10.f25233n
            if (r2 != 0) goto L_0x002a
            float r2 = (float) r11
            float r3 = (float) r12
            float r3 = r2 / r3
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            float r2 = r2 / r0
            int r12 = (int) r2
        L_0x0020:
            float r0 = r10.f25241v
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x002a
            float r11 = (float) r12
            float r11 = r11 * r0
            int r11 = (int) r11
        L_0x002a:
            r10.setMeasuredDimension(r11, r12)
            com.google.android.gms.internal.ads.zzbdd r0 = r10.f25233n
            if (r0 == 0) goto L_0x0034
            r0.mo30423a(r11, r12)
        L_0x0034:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00a4
            int r0 = r10.f25239t
            if (r0 <= 0) goto L_0x0040
            if (r0 != r11) goto L_0x0046
        L_0x0040:
            int r0 = r10.f25240u
            if (r0 <= 0) goto L_0x00a0
            if (r0 == r12) goto L_0x00a0
        L_0x0046:
            boolean r0 = r10.f25224e
            if (r0 == 0) goto L_0x00a0
            boolean r0 = r10.m26608l()
            if (r0 == 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzbfa r0 = r10.f25228i
            com.google.android.gms.internal.ads.zzkv r0 = r0.mo30531f()
            long r2 = r0.mo29280c()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00a0
            boolean r2 = r0.mo29281d()
            if (r2 == 0) goto L_0x0068
            goto L_0x00a0
        L_0x0068:
            r2 = 1
            r10.m26605a(r1, r2)
            r0.mo29275a(r2)
            long r1 = r0.mo29280c()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzk.zzln()
            long r3 = r3.mo27935b()
        L_0x007b:
            boolean r5 = r10.m26608l()
            if (r5 == 0) goto L_0x0098
            long r5 = r0.mo29280c()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0098
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzk.zzln()
            long r5 = r5.mo27935b()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x007b
        L_0x0098:
            r1 = 0
            r0.mo29275a(r1)
            r10.mo28179a()
        L_0x00a0:
            r10.f25239t = r11
            r10.f25240u = r12
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbek.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f25234o) {
            this.f25233n = new zzbdd(getContext());
            this.f25233n.mo30424a(surfaceTexture, i, i2);
            this.f25233n.start();
            SurfaceTexture c = this.f25233n.mo30426c();
            if (c != null) {
                surfaceTexture = c;
            } else {
                this.f25233n.mo30425b();
                this.f25233n = null;
            }
        }
        this.f25227h = new Surface(surfaceTexture);
        if (this.f25228i == null) {
            m26613q();
        } else {
            m26606a(this.f25227h, true);
            if (!this.f25225f.f25147a) {
                m26615s();
            }
        }
        if (this.f25237r == 0 || this.f25238s == 0) {
            m26607c(i, i2);
        } else {
            m26614r();
        }
        zzaxi.f24961a.post(new C9401ee(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbdd zzbdd = this.f25233n;
        if (zzbdd != null) {
            zzbdd.mo30423a(i, i2);
        }
        zzaxi.f24961a.post(new C9423fe(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f25223d.mo30434b(this);
        this.f25093a.mo30418a(surfaceTexture, this.f25226g);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        mo30349b();
        zzbdd zzbdd = this.f25233n;
        if (zzbdd != null) {
            zzbdd.mo30425b();
            this.f25233n = null;
        }
        if (this.f25228i != null) {
            m26616t();
            Surface surface = this.f25227h;
            if (surface != null) {
                surface.release();
            }
            this.f25227h = null;
            m26606a((Surface) null, true);
        }
        zzaxi.f24961a.post(new C9445ge(this));
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzawz.m26003f(sb.toString());
        zzaxi.f24961a.post(new C9467he(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* renamed from: a */
    public final void mo30473a(boolean z, long j) {
        if (this.f25222c != null) {
            zzbbm.f25064a.execute(new C9489ie(this, z, j));
        }
    }

    /* renamed from: a */
    public final void mo30469a(int i) {
        if (this.f25232m != i) {
            this.f25232m = i;
            if (i == 3) {
                m26610n();
            } else if (i == 4) {
                if (this.f25225f.f25147a) {
                    m26616t();
                }
                this.f25223d.mo30436d();
                this.f25094b.mo30441c();
                zzaxi.f24961a.post(new C9313ae(this));
            }
        }
    }

    /* renamed from: a */
    public final void mo30470a(int i, int i2) {
        this.f25237r = i;
        this.f25238s = i2;
        m26614r();
    }

    /* renamed from: a */
    public final void mo30472a(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        String str2 = "ExoPlayerAdapter error: ";
        zzbad.m26359d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f25231l = true;
        if (this.f25225f.f25147a) {
            m26616t();
        }
        zzaxi.f24961a.post(new C9335be(this, sb2));
    }

    /* renamed from: r */
    private final void m26614r() {
        m26607c(this.f25237r, this.f25238s);
    }

    /* renamed from: c */
    private final void m26607c(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.f25241v != f) {
            this.f25241v = f;
            requestLayout();
        }
    }

    /* renamed from: s */
    private final void m26615s() {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30529b(true);
        }
    }

    /* renamed from: t */
    private final void m26616t() {
        zzbfa zzbfa = this.f25228i;
        if (zzbfa != null) {
            zzbfa.mo30529b(false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo30475b(boolean z, long j) {
        this.f25222c.mo28734a(z, j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final /* synthetic */ void mo30479h(int i) {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final /* synthetic */ void mo30476f() {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.mo30376f();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo30474b(int i, int i2) {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.mo30373a(i, i2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final /* synthetic */ void mo30477g() {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.mo30380j();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final /* synthetic */ void mo30478h() {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.mo30381k();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final /* synthetic */ void mo30480i() {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.mo30378h();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30471a(String str) {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.mo30374a("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public final /* synthetic */ void mo30481j() {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.mo30377g();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public final /* synthetic */ void mo30482k() {
        zzbcn zzbcn = this.f25226g;
        if (zzbcn != null) {
            zzbcn.mo30379i();
        }
    }
}
