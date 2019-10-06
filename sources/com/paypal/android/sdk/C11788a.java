package com.paypal.android.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.UUID;

/* renamed from: com.paypal.android.sdk.a */
public class C11788a {

    /* renamed from: a */
    private static final String f37112a = C11788a.class.getSimpleName();

    /* renamed from: b */
    private final Context f37113b;

    /* renamed from: c */
    private final String f37114c;

    /* renamed from: d */
    private final C11801da f37115d;

    public C11788a(Context context, String str, C11723Fa fa) {
        if (context == null) {
            throw new NullPointerException("context == null");
        } else if (str != null) {
            this.f37113b = context;
            this.f37114c = str;
            this.f37115d = fa.mo38564a(this);
        } else {
            throw new NullPointerException("prefs == null");
        }
    }

    /* renamed from: a */
    public final String mo38689a(String str) {
        return this.f37115d.mo38713b(this.f37113b.getSharedPreferences(this.f37114c, 0).getString(str, null));
    }

    /* renamed from: a */
    public final void mo38690a(String str, String str2) {
        Editor edit = this.f37113b.getSharedPreferences(this.f37114c, 0).edit();
        edit.putString(str, this.f37115d.mo38712a(str2));
        edit.commit();
    }

    /* renamed from: a */
    public final boolean mo38691a() {
        String str;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f37113b.getSystemService("connectivity");
        String str2 = "paypal.sdk";
        if (connectivityManager == null) {
            str = "Unable to retrieve Context.CONNECTIVITY_SERVICE. Ignoring.";
        } else if (connectivityManager.getAllNetworkInfo() == null) {
            str = "ConnectivityManager.getAllNetworkInfo() returned null. Ignoring.";
        } else {
            int i = 0;
            for (NetworkInfo isConnectedOrConnecting : connectivityManager.getAllNetworkInfo()) {
                if (isConnectedOrConnecting.isConnectedOrConnecting()) {
                    i++;
                }
            }
            return i > 0;
        }
        Log.w(str2, str);
        return true;
    }

    /* renamed from: b */
    public final int mo38692b() {
        return ((TelephonyManager) this.f37113b.getSystemService("phone")).getPhoneType();
    }

    /* renamed from: b */
    public final String mo38693b(String str) {
        return this.f37115d.mo38712a(str);
    }

    /* renamed from: c */
    public final String mo38694c() {
        try {
            PackageManager packageManager = this.f37113b.getPackageManager();
            return packageManager.getPackageInfo(this.f37113b.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: c */
    public final String mo38695c(String str) {
        return this.f37115d.mo38713b(str);
    }

    /* renamed from: d */
    public final String mo38696d() {
        try {
            return ((TelephonyManager) this.f37113b.getSystemService("phone")).getSimOperatorName();
        } catch (SecurityException e) {
            e.toString();
            return null;
        }
    }

    /* renamed from: e */
    public final String mo38697e() {
        String str = "InstallationGUID";
        String string = this.f37113b.getSharedPreferences(this.f37114c, 0).getString(str, null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        Editor edit = this.f37113b.getSharedPreferences(this.f37114c, 0).edit();
        edit.putString(str, uuid);
        edit.commit();
        return uuid;
    }

    /* renamed from: f */
    public final Context mo38698f() {
        return this.f37113b;
    }
}
