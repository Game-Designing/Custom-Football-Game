package p024io.fabric.sdk.android.p348a.p350b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: io.fabric.sdk.android.a.b.i */
/* compiled from: ApiKey */
public class C13849i {
    /* renamed from: d */
    public String mo43240d(Context context) {
        String apiKey = mo43238b(context);
        if (TextUtils.isEmpty(apiKey)) {
            apiKey = mo43239c(context);
        }
        if (TextUtils.isEmpty(apiKey)) {
            apiKey = mo43237a(context);
        }
        if (TextUtils.isEmpty(apiKey)) {
            mo43241e(context);
        }
        return apiKey;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo43237a(Context context) {
        return new C13867x().mo43253a(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo43238b(Context context) {
        String str = "Fabric";
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String apiKey = bundle.getString("io.fabric.ApiKey");
            if ("@string/twitter_consumer_secret".equals(apiKey)) {
                C13920f.m44245e().mo43326c(str, "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                apiKey = null;
            }
            if (apiKey != null) {
                return apiKey;
            }
            C13920f.m44245e().mo43326c(str, "Falling back to Crashlytics key lookup from Manifest");
            return bundle.getString("com.crashlytics.ApiKey");
        } catch (Exception e) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Caught non-fatal exception while retrieving apiKey: ");
            sb.append(e);
            e2.mo43326c(str, sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo43239c(Context context) {
        String str = "string";
        int id = C13852l.m44019a(context, "io.fabric.ApiKey", str);
        if (id == 0) {
            C13920f.m44245e().mo43326c("Fabric", "Falling back to Crashlytics key lookup from Strings");
            id = C13852l.m44019a(context, "com.crashlytics.ApiKey", str);
        }
        if (id != 0) {
            return context.getResources().getString(id);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo43241e(Context context) {
        if (C13920f.m44246g() || C13852l.m44058j(context)) {
            throw new IllegalArgumentException(mo43236a());
        }
        C13920f.m44245e().mo43324b("Fabric", mo43236a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo43236a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
