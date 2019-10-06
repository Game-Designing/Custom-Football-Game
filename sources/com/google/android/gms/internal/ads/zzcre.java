package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public final class zzcre implements zzcva<zzcrd> {

    /* renamed from: a */
    private final zzbbl f27267a;

    /* renamed from: b */
    private final Context f27268b;

    /* renamed from: c */
    private final zzcxv f27269c;

    /* renamed from: d */
    private final View f27270d;

    public zzcre(zzbbl zzbbl, Context context, zzcxv zzcxv, ViewGroup viewGroup) {
        this.f27267a = zzbbl;
        this.f27268b = context;
        this.f27269c = zzcxv;
        this.f27270d = viewGroup;
    }

    /* renamed from: a */
    public final zzbbh<zzcrd> mo28586a() {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24203ya)).booleanValue()) {
            return zzbar.m26375a((Throwable) new Exception("Ad Key signal disabled."));
        }
        return this.f27267a.mo30326a((Callable<T>) new C9408el<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcrd mo31251b() throws Exception {
        Context context = this.f27268b;
        zzyd zzyd = this.f27269c.f27601e;
        ArrayList arrayList = new ArrayList();
        View view = this.f27270d;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzcrd(context, zzyd, arrayList);
    }
}
