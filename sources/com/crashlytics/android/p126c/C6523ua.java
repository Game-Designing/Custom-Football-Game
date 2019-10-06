package com.crashlytics.android.p126c;

import android.content.Context;
import android.os.Bundle;

/* renamed from: com.crashlytics.android.c.ua */
/* compiled from: ManifestUnityVersionProvider */
class C6523ua implements C6446Qa {

    /* renamed from: a */
    private final Context f11709a;

    /* renamed from: b */
    private final String f11710b;

    public C6523ua(Context context, String packageName) {
        this.f11709a = context;
        this.f11710b = packageName;
    }

    /* renamed from: a */
    public String mo19462a() {
        try {
            Bundle metaData = this.f11709a.getPackageManager().getApplicationInfo(this.f11710b, 128).metaData;
            if (metaData != null) {
                return metaData.getString("io.fabric.unity.crashlytics.version");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
