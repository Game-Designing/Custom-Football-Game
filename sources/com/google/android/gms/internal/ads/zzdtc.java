package com.google.android.gms.internal.ads;

public abstract class zzdtc {
    /* renamed from: a */
    public abstract void mo31691a(String str);

    /* renamed from: a */
    public static zzdtc m30099a(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzdsx(cls.getSimpleName());
        }
        return new zzdsz(cls.getSimpleName());
    }
}
