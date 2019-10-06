package p019d.p273h.p276c.p279c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import p019d.p273h.p276c.C12747I;

/* renamed from: d.h.c.c.a */
/* compiled from: IntegrationHelper */
class C12793a extends Thread {

    /* renamed from: a */
    final /* synthetic */ Activity f39383a;

    C12793a(Activity activity) {
        this.f39383a = activity;
    }

    public void run() {
        String str = "Google Play Services - MISSING";
        String str2 = "IntegrationHelper";
        try {
            Log.w(str2, "--------------- Google Play Services --------------");
            if (this.f39383a.getPackageManager().getApplicationInfo(this.f39383a.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                Log.i(str2, "Google Play Services - VERIFIED");
                String gaid = C12747I.m41186g().mo41202a((Context) this.f39383a);
                if (!TextUtils.isEmpty(gaid)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GAID is: ");
                    sb.append(gaid);
                    sb.append(" (use this for test devices)");
                    Log.i(str2, sb.toString());
                }
                return;
            }
            Log.e(str2, str);
        } catch (Exception e) {
            Log.e(str2, str);
        }
    }
}
