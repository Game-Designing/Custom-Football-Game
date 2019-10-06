package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;
import p002b.p003c.p053g.p061f.C1273q;

public final class zzccd extends zzaff {

    /* renamed from: b */
    private final Context f26353b;

    /* renamed from: c */
    private final zzbyt f26354c;

    /* renamed from: d */
    private final zzbzl f26355d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzbyn f26356e;

    public zzccd(Context context, zzbyt zzbyt, zzbzl zzbzl, zzbyn zzbyn) {
        this.f26353b = context;
        this.f26354c = zzbyt;
        this.f26355d = zzbzl;
        this.f26356e = zzbyn;
    }

    /* renamed from: m */
    public final String mo29691m(String str) {
        return (String) this.f26354c.mo31024v().get(str);
    }

    /* renamed from: o */
    public final zzaei mo29692o(String str) {
        return (zzaei) this.f26354c.mo31023u().get(str);
    }

    public final List<String> getAvailableAssetNames() {
        C1273q u = this.f26354c.mo31023u();
        C1273q v = this.f26354c.mo31024v();
        String[] strArr = new String[(u.size() + v.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < u.size()) {
            strArr[i3] = (String) u.mo9157b(i2);
            i2++;
            i3++;
        }
        while (i < v.size()) {
            strArr[i3] = (String) v.mo9157b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.f26354c.mo31007e();
    }

    public final void performClick(String str) {
        this.f26356e.mo30972a(str);
    }

    public final void recordImpression() {
        this.f26356e.mo30980h();
    }

    public final zzaar getVideoController() {
        return this.f26354c.mo31015m();
    }

    public final void destroy() {
        this.f26356e.mo30853a();
    }

    /* renamed from: la */
    public final IObjectWrapper mo29690la() {
        return ObjectWrapper.m22188a(this.f26353b);
    }

    /* renamed from: j */
    public final boolean mo29689j(IObjectWrapper iObjectWrapper) {
        Object H = ObjectWrapper.m22187H(iObjectWrapper);
        if (!(H instanceof ViewGroup) || !this.f26355d.mo31069a((ViewGroup) H)) {
            return false;
        }
        this.f26354c.mo31020r().mo28721a((zzadx) new C9339bi(this));
        return true;
    }

    /* renamed from: v */
    public final IObjectWrapper mo29695v() {
        return null;
    }
}
