package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class PackageManagerWrapper {

    /* renamed from: a */
    private final Context f20330a;

    public PackageManagerWrapper(Context context) {
        this.f20330a = context;
    }

    @KeepForSdk
    /* renamed from: a */
    public ApplicationInfo mo27944a(String str, int i) throws NameNotFoundException {
        return this.f20330a.getPackageManager().getApplicationInfo(str, i);
    }

    @KeepForSdk
    /* renamed from: b */
    public PackageInfo mo27947b(String str, int i) throws NameNotFoundException {
        return this.f20330a.getPackageManager().getPackageInfo(str, i);
    }

    @TargetApi(19)
    /* renamed from: a */
    public final boolean mo27946a(int i, String str) {
        if (PlatformVersion.m22112f()) {
            try {
                ((AppOpsManager) this.f20330a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f20330a.getPackageManager().getPackagesForUid(i);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public int mo27942a(String str) {
        return this.f20330a.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    /* renamed from: a */
    public int mo27943a(String str, String str2) {
        return this.f20330a.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    /* renamed from: b */
    public CharSequence mo27948b(String str) throws NameNotFoundException {
        return this.f20330a.getPackageManager().getApplicationLabel(this.f20330a.getPackageManager().getApplicationInfo(str, 0));
    }

    @KeepForSdk
    /* renamed from: a */
    public boolean mo27945a() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.m22131a(this.f20330a);
        }
        if (PlatformVersion.m22117k()) {
            String nameForUid = this.f20330a.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                return this.f20330a.getPackageManager().isInstantApp(nameForUid);
            }
        }
        return false;
    }
}
