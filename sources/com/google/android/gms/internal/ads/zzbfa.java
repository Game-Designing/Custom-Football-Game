package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

@zzard
public final class zzbfa implements zzkw, zzqi, zzsj<zzrv>, zztn {
    @VisibleForTesting

    /* renamed from: a */
    private static int f25256a;
    @VisibleForTesting

    /* renamed from: b */
    private static int f25257b;

    /* renamed from: c */
    private final Context f25258c;

    /* renamed from: d */
    private final zzbez f25259d;

    /* renamed from: e */
    private final zzlo f25260e;

    /* renamed from: f */
    private final zzlo f25261f;

    /* renamed from: g */
    private final zzrj f25262g;

    /* renamed from: h */
    private final zzbde f25263h;

    /* renamed from: i */
    private zzkv f25264i;

    /* renamed from: j */
    private ByteBuffer f25265j;

    /* renamed from: k */
    private boolean f25266k;

    /* renamed from: l */
    private zzbfi f25267l;

    /* renamed from: m */
    private int f25268m;

    /* renamed from: n */
    private Set<WeakReference<C9511je>> f25269n = new HashSet();

    public zzbfa(Context context, zzbde zzbde) {
        this.f25258c = context;
        this.f25263h = zzbde;
        this.f25259d = new zzbez();
        zzth zzth = new zzth(this.f25258c, zzpg.f29129a, 0, zzaxi.f24961a, this, -1);
        this.f25260e = zzth;
        this.f25261f = new zzms(zzpg.f29129a);
        this.f25262g = new zzrg();
        if (zzawz.m26001a()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzawz.m26003f(sb.toString());
        }
        f25256a++;
        this.f25264i = zzkz.m30622a(new zzlo[]{this.f25261f, this.f25260e}, this.f25262g, this.f25259d);
        this.f25264i.mo29278b((zzkw) this);
    }

    /* renamed from: f */
    public final zzkv mo30531f() {
        return this.f25264i;
    }

    /* renamed from: d */
    public static int m26660d() {
        return f25256a;
    }

    /* renamed from: e */
    public static int m26661e() {
        return f25257b;
    }

    /* renamed from: a */
    public final void mo30509a(zzbfi zzbfi) {
        this.f25267l = zzbfi;
    }

    /* renamed from: g */
    public final zzbez mo30533g() {
        return this.f25259d;
    }

    /* renamed from: a */
    public final void mo30524a(Uri[] uriArr, String str) {
        mo30525a(uriArr, str, ByteBuffer.allocate(0), false);
    }

    /* renamed from: a */
    public final void mo30525a(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzql zzql;
        this.f25265j = byteBuffer;
        this.f25266k = z;
        if (uriArr.length == 1) {
            zzql = m26659a(uriArr[0], str);
        } else {
            zzql[] zzqlArr = new zzql[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                zzqlArr[i] = m26659a(uriArr[i], str);
            }
            zzql = new zzqo(zzqlArr);
        }
        this.f25264i.mo29274a(zzql);
        f25257b++;
    }

    /* renamed from: c */
    public final void mo30530c() {
        zzkv zzkv = this.f25264i;
        if (zzkv != null) {
            zzkv.mo29273a((zzkw) this);
            this.f25264i.mo29270a();
            this.f25264i = null;
            f25257b--;
        }
    }

    /* renamed from: b */
    public final long mo30526b() {
        return (long) this.f25268m;
    }

    /* renamed from: a */
    public final void mo30516a(IOException iOException) {
        zzbfi zzbfi = this.f25267l;
        if (zzbfi != null) {
            zzbfi.mo30472a("onLoadError", (Exception) iOException);
        }
    }

    /* renamed from: b */
    public final void mo30528b(zznc zznc) {
    }

    /* renamed from: a */
    public final void mo30520a(String str, long j, long j2) {
    }

    /* renamed from: a */
    public final void mo30511a(zzlh zzlh) {
    }

    /* renamed from: a */
    public final void mo30506a(int i, long j) {
    }

    /* renamed from: a */
    public final void mo30505a(int i, int i2, int i3, float f) {
        zzbfi zzbfi = this.f25267l;
        if (zzbfi != null) {
            zzbfi.mo30470a(i, i2);
        }
    }

    /* renamed from: a */
    public final void mo30507a(Surface surface) {
    }

    /* renamed from: a */
    public final void mo30514a(zznc zznc) {
    }

    /* renamed from: a */
    public final void mo30513a(zzlr zzlr, Object obj) {
    }

    /* renamed from: a */
    public final void mo30515a(zzrb zzrb, zzro zzro) {
    }

    /* renamed from: a */
    public final void mo30521a(boolean z) {
    }

    /* renamed from: a */
    public final void mo30522a(boolean z, int i) {
        zzbfi zzbfi = this.f25267l;
        if (zzbfi != null) {
            zzbfi.mo30469a(i);
        }
    }

    /* renamed from: a */
    public final void mo30510a(zzku zzku) {
        zzbfi zzbfi = this.f25267l;
        if (zzbfi != null) {
            zzbfi.mo30472a("onPlayerError", (Exception) zzku);
        }
    }

    /* renamed from: a */
    public final void mo30502a() {
    }

    /* renamed from: a */
    public final void mo30512a(zzln zzln) {
    }

    /* renamed from: a */
    public final void mo30504a(int i) {
        for (WeakReference weakReference : this.f25269n) {
            C9511je jeVar = (C9511je) weakReference.get();
            if (jeVar != null) {
                jeVar.mo29018a(i);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30508a(Surface surface, boolean z) {
        zzky zzky = new zzky(this.f25260e, 1, surface);
        if (z) {
            this.f25264i.mo29279b(zzky);
            return;
        }
        this.f25264i.mo29276a(zzky);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30503a(float f, boolean z) {
        zzky zzky = new zzky(this.f25261f, 2, Float.valueOf(f));
        if (z) {
            this.f25264i.mo29279b(zzky);
            return;
        }
        this.f25264i.mo29276a(zzky);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo30529b(boolean z) {
        for (int i = 0; i < this.f25264i.mo29282e(); i++) {
            this.f25262g.mo32160a(i, !z);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private final zzql m26659a(Uri uri, String str) {
        zzrw zzrw;
        zzrw zzrw2;
        zzrw zzrw3;
        if (!this.f25266k || this.f25265j.limit() <= 0) {
            if (this.f25263h.f25155i > 0) {
                zzrw2 = new C9577me(this, str);
            } else {
                zzrw2 = new C9599ne(this, str);
            }
            if (this.f25263h.f25156j) {
                zzrw3 = new C9621oe(this, zzrw2);
            } else {
                zzrw3 = zzrw2;
            }
            if (this.f25265j.limit() > 0) {
                byte[] bArr = new byte[this.f25265j.limit()];
                this.f25265j.get(bArr);
                zzrw3 = new C9643pe(zzrw3, bArr);
            }
            zzrw = zzrw3;
        } else {
            byte[] bArr2 = new byte[this.f25265j.limit()];
            this.f25265j.get(bArr2);
            zzrw = new C9555le(bArr2);
        }
        zzqh zzqh = new zzqh(uri, zzrw, C9664qe.f22896a, -1, zzaxi.f24961a, this, null, this.f25263h.f25153g);
        return zzqh;
    }

    public final void finalize() throws Throwable {
        f25256a--;
        if (zzawz.m26001a()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzawz.m26003f(sb.toString());
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo30517a(Object obj) {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo30518a(Object obj, int i) {
        this.f25268m += i;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo30519a(Object obj, zzry zzry) {
        this.f25268m = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzrv mo30500a(zzrw zzrw) {
        return new zzbex(this.f25258c, zzrw.mo29060a(), this, new C9685re(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30523a(boolean z, long j) {
        zzbfi zzbfi = this.f25267l;
        if (zzbfi != null) {
            zzbfi.mo30473a(z, j);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzrv mo30501a(String str) {
        zzbfa zzbfa = this.f25263h.f25156j ? null : this;
        zzbde zzbde = this.f25263h;
        zzsa zzsa = new zzsa(str, null, zzbfa, zzbde.f25150d, zzbde.f25152f, true, null);
        return zzsa;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzrv mo30527b(String str) {
        zzbfa zzbfa = this.f25263h.f25156j ? null : this;
        zzbde zzbde = this.f25263h;
        C9511je jeVar = new C9511je(str, zzbfa, zzbde.f25150d, zzbde.f25152f, zzbde.f25155i);
        this.f25269n.add(new WeakReference(jeVar));
        return jeVar;
    }
}
