package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public class Wrappers {

    /* renamed from: a */
    private static Wrappers f20331a = new Wrappers();

    /* renamed from: b */
    private PackageManagerWrapper f20332b = null;

    @VisibleForTesting
    /* renamed from: b */
    private final synchronized PackageManagerWrapper m22140b(Context context) {
        if (this.f20332b == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f20332b = new PackageManagerWrapper(context);
        }
        return this.f20332b;
    }

    @KeepForSdk
    /* renamed from: a */
    public static PackageManagerWrapper m22139a(Context context) {
        return f20331a.m22140b(context);
    }
}
