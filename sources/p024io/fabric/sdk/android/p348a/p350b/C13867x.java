package p024io.fabric.sdk.android.p348a.p350b;

import android.content.Context;
import android.text.TextUtils;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: io.fabric.sdk.android.a.b.x */
/* compiled from: FirebaseInfo */
public class C13867x {
    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo43253a(Context context) {
        int id = C13852l.m44019a(context, "google_app_id", "string");
        if (id == 0) {
            return null;
        }
        C13920f.m44245e().mo43326c("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return mo43254a(context.getResources().getString(id));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo43254a(String appId) {
        return C13852l.m44052d(appId).substring(0, 40);
    }

    /* renamed from: e */
    public boolean mo43258e(Context context) {
        boolean z = false;
        if (C13852l.m44040a(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        if (mo43256c(context) && !mo43255b(context)) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo43255b(Context context) {
        if (!TextUtils.isEmpty(new C13849i().mo43238b(context))) {
            return true;
        }
        return true ^ TextUtils.isEmpty(new C13849i().mo43239c(context));
    }

    /* renamed from: d */
    public boolean mo43257d(Context context) {
        int id = C13852l.m44019a(context, "io.fabric.auto_initialize", "bool");
        if (id == 0) {
            return false;
        }
        boolean autoInitialize = context.getResources().getBoolean(id);
        if (autoInitialize) {
            C13920f.m44245e().mo43326c("Fabric", "Found Fabric auto-initialization flag for joint Firebase/Fabric customers");
        }
        return autoInitialize;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo43256c(Context context) {
        int id = C13852l.m44019a(context, "google_app_id", "string");
        if (id == 0) {
            return false;
        }
        return !TextUtils.isEmpty(context.getResources().getString(id));
    }
}
