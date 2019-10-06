package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

@zzard
public class zzyh {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzxx f29781a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzxw f29782b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final zzabk f29783c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzagk f29784d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzatf f29785e;

    /* renamed from: f */
    private final zzauj f29786f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzaqf f29787g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzagl f29788h;

    public zzyh(zzxx zzxx, zzxw zzxw, zzabk zzabk, zzagk zzagk, zzatf zzatf, zzauj zzauj, zzaqf zzaqf, zzagl zzagl) {
        this.f29781a = zzxx;
        this.f29782b = zzxw;
        this.f29783c = zzabk;
        this.f29784d = zzagk;
        this.f29785e = zzatf;
        this.f29786f = zzauj;
        this.f29787g = zzaqf;
        this.f29788h = zzagl;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m31521b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzyt.m31532a().mo30312a(context, zzyt.m31538g().f25057a, "gmob-apps", bundle, true);
    }

    /* renamed from: a */
    public final zzzf mo32390a(Context context, String str, zzamp zzamp) {
        return (zzzf) new C9505iu(this, context, str, zzamp).mo29114a(context, false);
    }

    /* renamed from: a */
    public final zzaem mo32387a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzaem) new C9549ku(this, frameLayout, frameLayout2, context).mo29114a(context, false);
    }

    /* renamed from: a */
    public final zzaer mo32388a(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzaer) new C9571lu(this, view, hashMap, hashMap2).mo29114a(view.getContext(), false);
    }

    /* renamed from: b */
    public final zzatt mo32391b(Context context, String str, zzamp zzamp) {
        return (zzatt) new C9615nu(this, context, str, zzamp).mo29114a(context, false);
    }

    /* renamed from: a */
    public final zzaqg mo32389a(Activity activity) {
        C9439fu fuVar = new C9439fu(this, activity);
        Intent intent = activity.getIntent();
        String str = "com.google.android.gms.ads.internal.overlay.useClientJar";
        boolean z = false;
        if (!intent.hasExtra(str)) {
            zzbad.m26355b("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra(str, false);
        }
        return (zzaqg) fuVar.mo29114a(activity, z);
    }
}
