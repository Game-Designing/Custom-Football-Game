package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzcgt {
    /* renamed from: a */
    public static PackageInfo m28425a(Context context, ApplicationInfo applicationInfo) {
        try {
            return Wrappers.m22139a(context).mo27947b(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            return null;
        }
    }
}
