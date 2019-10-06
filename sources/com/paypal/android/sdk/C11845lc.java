package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: com.paypal.android.sdk.lc */
public final class C11845lc {

    /* renamed from: a */
    private final Context f37274a;

    public C11845lc(Context context) {
        this.f37274a = context;
    }

    /* renamed from: a */
    public final void mo38821a(Collection collection) {
        try {
            HashSet hashSet = new HashSet(collection);
            ActivityInfo[] activityInfoArr = this.f37274a.getPackageManager().getPackageInfo(this.f37274a.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    hashSet.remove(activityInfo.name);
                }
            }
            if (!hashSet.isEmpty()) {
                StringBuilder sb = new StringBuilder("Missing required activities in manifest:");
                sb.append(hashSet);
                throw new RuntimeException(sb.toString());
            }
        } catch (NameNotFoundException e) {
            StringBuilder sb2 = new StringBuilder("Exception loading manifest");
            sb2.append(e.getMessage());
            throw new RuntimeException(sb2.toString());
        }
    }
}
