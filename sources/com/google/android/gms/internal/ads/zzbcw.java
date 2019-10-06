package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzbcw {

    /* renamed from: a */
    private final Context f25112a;

    /* renamed from: b */
    private final zzbdf f25113b;

    /* renamed from: c */
    private final ViewGroup f25114c;

    /* renamed from: d */
    private zzbcq f25115d;

    public zzbcw(Context context, ViewGroup viewGroup, zzbgz zzbgz) {
        this(context, viewGroup, zzbgz, null);
    }

    @VisibleForTesting
    private zzbcw(Context context, ViewGroup viewGroup, zzbdf zzbdf, zzbcq zzbcq) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f25112a = context;
        this.f25114c = viewGroup;
        this.f25113b = zzbdf;
        this.f25115d = null;
    }

    /* renamed from: a */
    public final void mo30413a(int i, int i2, int i3, int i4) {
        Preconditions.m21862a("The underlay may only be modified from the UI thread.");
        zzbcq zzbcq = this.f25115d;
        if (zzbcq != null) {
            zzbcq.mo30393a(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public final void mo30414a(int i, int i2, int i3, int i4, int i5, boolean z, zzbde zzbde) {
        if (this.f25115d == null) {
            zzadb.m24799a(this.f25113b.mo28706B().mo29614a(), this.f25113b.mo28711G(), "vpr2");
            Context context = this.f25112a;
            zzbdf zzbdf = this.f25113b;
            zzbcq zzbcq = new zzbcq(context, zzbdf, i5, z, zzbdf.mo28706B().mo29614a(), zzbde);
            this.f25115d = zzbcq;
            this.f25114c.addView(this.f25115d, 0, new LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            this.f25115d.mo30393a(i, i2, i3, i4);
            this.f25113b.mo28752f(false);
        }
    }

    /* renamed from: c */
    public final zzbcq mo30416c() {
        Preconditions.m21862a("getAdVideoUnderlay must be called from the UI thread.");
        return this.f25115d;
    }

    /* renamed from: b */
    public final void mo30415b() {
        Preconditions.m21862a("onPause must be called from the UI thread.");
        zzbcq zzbcq = this.f25115d;
        if (zzbcq != null) {
            zzbcq.mo30397b();
        }
    }

    /* renamed from: a */
    public final void mo30412a() {
        Preconditions.m21862a("onDestroy must be called from the UI thread.");
        zzbcq zzbcq = this.f25115d;
        if (zzbcq != null) {
            zzbcq.mo30390a();
            this.f25114c.removeView(this.f25115d);
            this.f25115d = null;
        }
    }
}
