package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONObject;

@zzard
public final class zzajj extends zzaju<zzalf> implements zzajq, zzajw {

    /* renamed from: c */
    private final zzbjb f24374c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzajx f24375d;

    public zzajj(Context context, zzbai zzbai) throws zzbhj {
        try {
            this.f24374c = new zzbjb(context, new C9309aa(this));
            this.f24374c.setWillNotDraw(true);
            this.f24374c.addJavascriptInterface(new C9267Z(this), "GoogleJsInterface");
            zzk.zzlg().mo30231a(context, zzbai.f25057a, this.f24374c.getSettings());
            super.mo29784a(this);
        } catch (Throwable th) {
            throw new zzbhj("Init failed.", th);
        }
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

    /* renamed from: d */
    public final void mo29774d(String str) {
        mo29776e(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[]{str}));
    }

    /* renamed from: e */
    public final void mo29776e(String str) {
        zzbbm.f25064a.execute(new C9183V(this, str));
    }

    /* renamed from: c */
    public final void mo29773c(String str) {
        zzbbm.f25064a.execute(new C9204W(this, str));
    }

    /* renamed from: a */
    public final void mo29772a(zzajx zzajx) {
        this.f24375d = zzajx;
    }

    public final void destroy() {
        this.f24374c.destroy();
    }

    public final boolean isDestroyed() {
        return this.f24374c.isDestroyed();
    }

    /* renamed from: J */
    public final zzalg mo29771J() {
        return new zzalh(this);
    }

    /* renamed from: a */
    public final void mo28724a(String str) {
        zzbbm.f25064a.execute(new C9225X(this, str));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final /* synthetic */ void mo29777f(String str) {
        this.f24374c.mo28724a(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final /* synthetic */ void mo29778g(String str) {
        this.f24374c.loadUrl(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final /* synthetic */ void mo29779h(String str) {
        this.f24374c.loadData(str, "text/html", "UTF-8");
    }
}
