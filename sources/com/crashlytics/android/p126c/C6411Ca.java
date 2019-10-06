package com.crashlytics.android.p126c;

import android.annotation.SuppressLint;
import p024io.fabric.sdk.android.p348a.p352d.C13884c;
import p024io.fabric.sdk.android.p348a.p352d.C13885d;

@SuppressLint({"CommitPrefEdits"})
/* renamed from: com.crashlytics.android.c.Ca */
/* compiled from: PreferenceManager */
class C6411Ca {

    /* renamed from: a */
    private final C13884c f11471a;

    /* renamed from: b */
    private final C6472aa f11472b;

    /* renamed from: a */
    public static C6411Ca m12428a(C13884c preferenceStore, C6472aa kit) {
        return new C6411Ca(preferenceStore, kit);
    }

    public C6411Ca(C13884c preferenceStore, C6472aa kit) {
        this.f11471a = preferenceStore;
        this.f11472b = kit;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19443a(boolean send) {
        C13884c cVar = this.f11471a;
        cVar.mo43294a(cVar.edit().putBoolean("always_send_reports_opt_in", send));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19444a() {
        String str = "preferences_migration_complete";
        String str2 = "always_send_reports_opt_in";
        if (!this.f11471a.get().contains(str)) {
            C13884c oldStore = new C13885d(this.f11472b);
            if (!this.f11471a.get().contains(str2) && oldStore.get().contains(str2)) {
                boolean alwaysSend = oldStore.get().getBoolean(str2, false);
                C13884c cVar = this.f11471a;
                cVar.mo43294a(cVar.edit().putBoolean(str2, alwaysSend));
            }
            C13884c cVar2 = this.f11471a;
            cVar2.mo43294a(cVar2.edit().putBoolean(str, true));
        }
        return this.f11471a.get().getBoolean(str2, false);
    }
}
