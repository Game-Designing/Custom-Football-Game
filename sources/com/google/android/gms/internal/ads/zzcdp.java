package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzb;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcdp {

    /* renamed from: a */
    private final zzbri f26434a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzbse f26435b;

    /* renamed from: c */
    private final zzbss f26436c;

    /* renamed from: d */
    private final zzbsv f26437d;

    /* renamed from: e */
    private final zzbtp f26438e;

    /* renamed from: f */
    private final Executor f26439f;

    /* renamed from: g */
    private final zzbva f26440g;

    /* renamed from: h */
    private final zzbmn f26441h;

    /* renamed from: i */
    private final zzb f26442i;

    /* renamed from: j */
    private final zzbry f26443j;

    /* renamed from: k */
    private final zzavb f26444k;

    /* renamed from: l */
    private final zzdh f26445l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final zzbtl f26446m;

    public zzcdp(zzbri zzbri, zzbse zzbse, zzbss zzbss, zzbsv zzbsv, zzbtp zzbtp, Executor executor, zzbva zzbva, zzbmn zzbmn, zzb zzb, zzbry zzbry, zzavb zzavb, zzdh zzdh, zzbtl zzbtl) {
        this.f26434a = zzbri;
        this.f26435b = zzbse;
        this.f26436c = zzbss;
        this.f26437d = zzbsv;
        this.f26438e = zzbtp;
        this.f26439f = executor;
        this.f26440g = zzbva;
        this.f26441h = zzbmn;
        this.f26442i = zzb;
        this.f26443j = zzbry;
        this.f26444k = zzavb;
        this.f26445l = zzdh;
        this.f26446m = zzbtl;
    }

    /* renamed from: a */
    public final void mo31128a(zzbgz zzbgz, boolean z) {
        zzbgz.mo28714a().mo30599a(new C9603ni(this), this.f26436c, this.f26437d, new C9625oi(this), new C9647pi(this), z, null, this.f26442i, new C9794wi(this), this.f26444k);
        zzbgz.setOnTouchListener(new C9668qi(this));
        zzbgz.setOnClickListener(new C9689ri(this));
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24127lc)).booleanValue()) {
            zzdc a = this.f26445l.mo31483a();
            if (a != null) {
                a.zzb(zzbgz.getView());
            }
        }
        this.f26440g.mo30897a(zzbgz, this.f26439f);
        this.f26440g.mo30897a(new C9710si(zzbgz), this.f26439f);
        this.f26440g.mo30923a(zzbgz.getView());
        zzbgz.mo28726a("/trackActiveViewUnit", (zzaho<? super zzbgz>) new C9731ti<Object>(this, zzbgz));
        this.f26441h.mo30743a((Object) zzbgz);
        this.f26443j.mo30878a(new C9752ui(zzbgz), this.f26439f);
    }

    /* renamed from: a */
    public static zzbbh<?> m28312a(zzbgz zzbgz, String str, String str2) {
        zzbbr zzbbr = new zzbbr();
        zzbgz.mo28714a().mo30597a((zzbij) new C9773vi(zzbbr));
        zzbgz.mo28728a(str, str2, null);
        return zzbbr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31127a(zzbgz zzbgz, zzbgz zzbgz2, Map map) {
        this.f26441h.mo30742a(zzbgz);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31126a(View view) {
        this.f26442i.recordClick();
        zzavb zzavb = this.f26444k;
        if (zzavb != null) {
            zzavb.mo30108b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ boolean mo31130a(View view, MotionEvent motionEvent) {
        this.f26442i.recordClick();
        zzavb zzavb = this.f26444k;
        if (zzavb != null) {
            zzavb.mo30108b();
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31125a() {
        this.f26435b.mo30883H();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31129a(String str, String str2) {
        this.f26438e.onAppEvent(str, str2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo31131b() {
        this.f26434a.onAdClicked();
    }
}
