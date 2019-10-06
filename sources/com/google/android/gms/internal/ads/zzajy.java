package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import org.json.JSONObject;

@zzard
public final class zzajy implements zzajq, zzajw {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzbgz f24378a;

    /* renamed from: b */
    private final Context f24379b;

    public zzajy(Context context, zzbai zzbai, zzdh zzdh, zza zza) throws zzbhj {
        this.f24379b = context;
        zzk.zzlh();
        Context context2 = context;
        this.f24378a = zzbhf.m26877a(context2, zzbin.m27015b(), "", false, false, zzdh, zzbai, null, null, null, zzwj.m31331a());
        this.f24378a.getView().setWillNotDraw(true);
    }

    /* renamed from: a */
    public final void mo29037a(String str, String str2) {
        zzajr.m25122a((zzajq) this, str, str2);
    }

    /* renamed from: a */
    public final void mo28729a(String str, Map map) {
        zzajr.m25123a((zzajq) this, str, map);
    }

    /* renamed from: a */
    public final void mo28730a(String str, JSONObject jSONObject) {
        zzajr.m25125b(this, str, jSONObject);
    }

    /* renamed from: b */
    public final void mo28740b(String str, JSONObject jSONObject) {
        zzajr.m25124a((zzajq) this, str, jSONObject);
    }

    /* renamed from: a */
    private static void m25144a(Runnable runnable) {
        zzyt.m31532a();
        if (zzazt.m26314b()) {
            runnable.run();
        } else {
            zzaxi.f24961a.post(runnable);
        }
    }

    /* renamed from: a */
    public final void mo28724a(String str) {
        m25144a((Runnable) new C9353ca(this, str));
    }

    /* renamed from: d */
    public final void mo29774d(String str) {
        m25144a((Runnable) new C9419fa(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    /* renamed from: e */
    public final void mo29776e(String str) {
        m25144a((Runnable) new C9441ga(this, str));
    }

    /* renamed from: c */
    public final void mo29773c(String str) {
        m25144a((Runnable) new C9463ha(this, str));
    }

    /* renamed from: a */
    public final void mo29790a(String str, zzaho<? super zzalf> zzaho) {
        this.f24378a.mo28726a(str, (zzaho<? super zzbgz>) new C9485ia<Object>(this, zzaho));
    }

    /* renamed from: b */
    public final void mo29792b(String str, zzaho<? super zzalf> zzaho) {
        this.f24378a.mo28725a(str, (Predicate<zzaho<? super zzbgz>>) new C9375da<zzaho<? super zzbgz>>(zzaho));
    }

    /* renamed from: a */
    public final void mo29772a(zzajx zzajx) {
        zzbii a = this.f24378a.mo28714a();
        zzajx.getClass();
        a.mo30598a(C9397ea.m23547a(zzajx));
    }

    /* renamed from: J */
    public final zzalg mo29771J() {
        return new zzalh(this);
    }

    public final void destroy() {
        this.f24378a.destroy();
    }

    public final boolean isDestroyed() {
        return this.f24378a.isDestroyed();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo29791b(String str) {
        this.f24378a.mo28724a(str);
    }
}
