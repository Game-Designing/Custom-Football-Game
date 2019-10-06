package com.crashlytics.android.p126c;

import android.text.TextUtils;
import java.util.HashMap;
import p005cm.aptoide.p006pt.deprecated.tables.Excluded;
import p005cm.aptoide.p006pt.deprecated.tables.Updates;

/* renamed from: com.crashlytics.android.c.C */
/* compiled from: CrashlyticsController */
class C6410C extends HashMap<String, Object> {

    /* renamed from: a */
    final /* synthetic */ C6412D f11470a;

    C6410C(C6412D this$1) {
        this.f11470a = this$1;
        put("app_identifier", this.f11470a.f11473a);
        put("api_key", this.f11470a.f11478f.f11579p.f11611a);
        put(Updates.COLUMN_VERCODE, this.f11470a.f11474b);
        put(Excluded.COLUMN_VERNAME, this.f11470a.f11475c);
        put("install_uuid", this.f11470a.f11476d);
        put("delivery_mechanism", Integer.valueOf(this.f11470a.f11477e));
        put("unity_version", TextUtils.isEmpty(this.f11470a.f11478f.f11586w) ? "" : this.f11470a.f11478f.f11586w);
    }
}
