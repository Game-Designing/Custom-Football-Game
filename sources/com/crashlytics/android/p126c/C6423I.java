package com.crashlytics.android.p126c;

import android.os.Build;
import java.util.HashMap;

/* renamed from: com.crashlytics.android.c.I */
/* compiled from: CrashlyticsController */
class C6423I extends HashMap<String, Object> {

    /* renamed from: a */
    final /* synthetic */ C6426J f11507a;

    C6423I(C6426J this$1) {
        this.f11507a = this$1;
        put("arch", Integer.valueOf(this.f11507a.f11511a));
        put("build_model", Build.MODEL);
        put("available_processors", Integer.valueOf(this.f11507a.f11512b));
        put("total_ram", Long.valueOf(this.f11507a.f11513c));
        put("disk_space", Long.valueOf(this.f11507a.f11514d));
        put("is_emulator", Boolean.valueOf(this.f11507a.f11515e));
        put("ids", this.f11507a.f11516f);
        put("state", Integer.valueOf(this.f11507a.f11517g));
        put("build_manufacturer", Build.MANUFACTURER);
        put("build_product", Build.PRODUCT);
    }
}
