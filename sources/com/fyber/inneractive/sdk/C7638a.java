package com.fyber.inneractive.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.a */
public class C7638a {
    /* renamed from: a */
    public static void m16876a(Context context, Intent intent) {
        if (context != null) {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(intent, 0)) {
                String str = resolveInfo.activityInfo.name;
                try {
                    ((BroadcastReceiver) Class.forName(str).newInstance()).onReceive(context, intent);
                } catch (ClassNotFoundException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(IAlog.m18017a(C7638a.class));
                    sb.append("Could not find receiver for ");
                    sb.append(str);
                    IAlog.m18023d(sb.toString());
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(IAlog.m18017a(C7638a.class));
                    sb2.append("Error instantiating or executing registration for kit ");
                    sb2.append(str);
                    IAlog.m18023d(sb2.toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("Context can't be null");
    }
}
