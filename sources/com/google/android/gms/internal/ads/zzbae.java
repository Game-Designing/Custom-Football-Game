package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@zzard
public final class zzbae {
    /* renamed from: a */
    public static <T> T m26364a(Context context, String str, zzbaf<IBinder, T> zzbaf) throws zzbag {
        try {
            return zzbaf.apply(m26365b(context).mo27984a(str));
        } catch (Exception e) {
            throw new zzbag(e);
        }
    }

    /* renamed from: a */
    public static Context m26363a(Context context) throws zzbag {
        return m26365b(context).mo27983a();
    }

    /* renamed from: b */
    private static DynamiteModule m26365b(Context context) throws zzbag {
        try {
            return DynamiteModule.m22215a(context, DynamiteModule.f20351h, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzbag(e);
        }
    }
}
