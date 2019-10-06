package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;

public final class zzcuw implements zzcva<zzcuv> {

    /* renamed from: a */
    private final zzbbl f27427a;

    /* renamed from: b */
    private final Context f27428b;

    /* renamed from: c */
    private final zzbai f27429c;

    public zzcuw(zzbbl zzbbl, Context context, zzbai zzbai) {
        this.f27427a = zzbbl;
        this.f27428b = context;
        this.f27429c = zzbai;
    }

    /* renamed from: a */
    public final zzbbh<zzcuv> mo28586a() {
        return this.f27427a.mo30326a((Callable<T>) new C9045Ol<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcuv mo31268b() throws Exception {
        boolean a = Wrappers.m22139a(this.f27428b).mo27945a();
        zzk.zzlg();
        boolean j = zzaxi.m26142j(this.f27428b);
        String str = this.f27429c.f25057a;
        zzk.zzli();
        boolean c = zzaxo.m26165c();
        zzk.zzlg();
        zzcuv zzcuv = new zzcuv(a, j, str, c, zzaxi.m26140h(this.f27428b), DynamiteModule.m22219b(this.f27428b, ModuleDescriptor.MODULE_ID));
        return zzcuv;
    }
}
