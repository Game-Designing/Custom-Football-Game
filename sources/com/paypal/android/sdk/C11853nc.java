package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import com.paypal.android.sdk.payments.PayPalService;

/* renamed from: com.paypal.android.sdk.nc */
public class C11853nc {

    /* renamed from: a */
    private static final String f37279a = C11853nc.class.getSimpleName();

    /* renamed from: b */
    private final Context f37280b;

    public C11853nc(Context context) {
        this.f37280b = context;
    }

    /* renamed from: b */
    private boolean m39204b() {
        ServiceInfo[] serviceInfoArr;
        try {
            PackageManager packageManager = this.f37280b.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.f37280b.getPackageName(), 4);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.f37280b.getPackageName(), 128);
            if (packageInfo.services != null) {
                for (ServiceInfo serviceInfo : packageInfo.services) {
                    if (serviceInfo.name.equals(PayPalService.class.getName())) {
                        new StringBuilder("context.getPackageName()=").append(this.f37280b.getPackageName());
                        new StringBuilder("serviceInfo.exported=").append(serviceInfo.exported);
                        new StringBuilder("serviceInfo.processName=").append(serviceInfo.processName);
                        new StringBuilder("applicationInfo.processName=").append(applicationInfo.processName);
                        if (!serviceInfo.exported && applicationInfo.processName.equals(serviceInfo.processName)) {
                            StringBuilder sb = new StringBuilder("Found ");
                            sb.append(PayPalService.class.getName());
                            sb.append(" in manifest.");
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            StringBuilder sb2 = new StringBuilder("Exception loading manifest");
            sb2.append(e.getMessage());
            throw new RuntimeException(sb2.toString());
        }
    }

    /* renamed from: a */
    public final void mo38825a() {
        if (!m39204b()) {
            throw new RuntimeException("Please declare the following in your manifest, and ensure it runs in the same process as your application:<service android:name=\"com.paypal.android.sdk.payments.PayPalService\" android:exported=\"false\" />");
        }
    }
}
