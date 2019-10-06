package com.adyen.p081ui;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.p000v4.content.C0515e;
import android.util.Log;
import com.adyen.p081ui.activities.RedirectHandlerActivity;

/* renamed from: com.adyen.ui.RedirectionHandlerReceiver */
public class RedirectionHandlerReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f9380a = RedirectionHandlerReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String packageName = intent.getStringExtra("PackageName");
            PackageManager pm = context.getApplicationContext().getPackageManager();
            if (1 == pm.getComponentEnabledSetting(new ComponentName(context, RedirectHandlerActivity.class)) && !context.getPackageName().equals(packageName)) {
                String str = f9380a;
                StringBuilder sb = new StringBuilder();
                sb.append("Disabling RedirectHandlerActivity for this application: ");
                sb.append(context.getPackageName());
                Log.d(str, sb.toString());
                pm.setComponentEnabledSetting(new ComponentName(context, RedirectHandlerActivity.class), 2, 1);
                Intent returnIntent = new Intent();
                returnIntent.setAction("com.adyen.core.RedirectProblem");
                returnIntent.putExtra("returnUri", intent.getData());
                C0515e.m2597a(context).mo5314a(returnIntent);
            }
        }
    }
}
