package com.crashlytics.android.p126c;

import java.util.HashMap;

/* renamed from: com.crashlytics.android.c.y */
/* compiled from: CrashlyticsController */
class C6530y extends HashMap<String, Object> {

    /* renamed from: a */
    final /* synthetic */ C6532z f11725a;

    C6530y(C6532z this$1) {
        this.f11725a = this$1;
        put("session_id", this.f11725a.f11726a);
        put("generator", this.f11725a.f11727b);
        put("started_at_seconds", Long.valueOf(this.f11725a.f11728c));
    }
}
