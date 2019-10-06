package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@TargetApi(16)
@zzard
public final class zzbdk {
    @VisibleForTesting

    /* renamed from: a */
    private static int f25180a;
    @VisibleForTesting

    /* renamed from: b */
    private static int f25181b;

    /* renamed from: c */
    private zzge f25182c;

    /* renamed from: d */
    private zzhd f25183d;

    /* renamed from: e */
    private zzgn f25184e;

    /* renamed from: f */
    private zzbdo f25185f;

    /* renamed from: g */
    private final C8890Hd f25186g = new C8890Hd(this);

    /* renamed from: h */
    private final C8911Id f25187h = new C8911Id(this);

    /* renamed from: i */
    private final C8869Gd f25188i = new C8869Gd(this);

    public zzbdk() {
        Preconditions.m21862a("ExoPlayer must be created on the main UI thread.");
        if (zzawz.m26001a()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
            sb.append("AdExoPlayerHelper initialize ");
            sb.append(valueOf);
            zzawz.m26003f(sb.toString());
        }
        f25180a++;
        this.f25182c = zzgg.m30259a(2);
        this.f25182c.mo28333a((zzgh) this.f25186g);
    }

    /* renamed from: b */
    public static int m26550b() {
        return f25180a;
    }

    /* renamed from: c */
    public static int m26551c() {
        return f25181b;
    }

    /* renamed from: a */
    public final boolean mo30446a(zzhn zzhn) {
        if (this.f25182c == null) {
            return false;
        }
        zzhd zzhd = new zzhd(zzhn, 1, 0, zzaxi.f24961a, this.f25187h, -1);
        this.f25183d = zzhd;
        this.f25184e = new zzgn(zzhn, zzaxi.f24961a, this.f25188i);
        this.f25182c.mo28335a(this.f25183d, this.f25184e);
        f25181b++;
        return true;
    }

    /* renamed from: d */
    public final void mo30447d() {
        zzge zzge = this.f25182c;
        if (zzge != null) {
            zzge.mo28328a();
            this.f25182c = null;
            f25181b--;
        }
    }

    /* renamed from: a */
    public final synchronized void mo30444a(zzbdo zzbdo) {
        this.f25185f = zzbdo;
    }

    /* renamed from: a */
    public final synchronized void mo30443a() {
        this.f25185f = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final synchronized void m26549a(String str, String str2) {
        if (this.f25185f != null) {
            this.f25185f.mo28257a(str, str2);
        }
    }

    /* renamed from: e */
    public final zzge mo30448e() {
        return this.f25182c;
    }

    /* renamed from: f */
    public final zzhd mo30449f() {
        return this.f25183d;
    }

    /* renamed from: g */
    public final zzgn mo30451g() {
        return this.f25184e;
    }

    /* renamed from: a */
    public final void mo30445a(zzgh zzgh, zzhh zzhh, zzgq zzgq) {
        this.f25186g.mo28308a(zzgh);
        this.f25187h.mo28349a(zzhh);
        this.f25188i.mo28252a(zzgq);
    }

    public final void finalize() throws Throwable {
        f25180a--;
        if (zzawz.m26001a()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("AdExoPlayerHelper finalize ");
            sb.append(valueOf);
            zzawz.m26003f(sb.toString());
        }
    }
}
