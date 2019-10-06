package com.google.android.gms.internal.ads;

import android.text.TextUtils;

@zzard
public final class zzada {
    /* renamed from: a */
    public static void m24797a(zzacy zzacy, zzacx zzacx) {
        if (zzacx.mo29603a() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzacx.mo29604b())) {
            zzacy.mo29609a(zzacx.mo29603a(), zzacx.mo29604b(), zzacx.mo29605c(), zzacx.mo29606d());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
