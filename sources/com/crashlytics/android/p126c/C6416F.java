package com.crashlytics.android.p126c;

import android.os.Build.VERSION;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.HashMap;

/* renamed from: com.crashlytics.android.c.F */
/* compiled from: CrashlyticsController */
class C6416F extends HashMap<String, Object> {

    /* renamed from: a */
    final /* synthetic */ C6418G f11486a;

    C6416F(C6418G this$1) {
        this.f11486a = this$1;
        put(MediationMetaData.KEY_VERSION, VERSION.RELEASE);
        put("build_version", VERSION.CODENAME);
        put("is_rooted", Boolean.valueOf(this.f11486a.f11490a));
    }
}
