package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class zzvl implements Comparator<zzuz> {
    public zzvl(zzvk zzvk) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzuz zzuz = (zzuz) obj;
        zzuz zzuz2 = (zzuz) obj2;
        if (zzuz.mo32296b() < zzuz2.mo32296b()) {
            return -1;
        }
        if (zzuz.mo32296b() > zzuz2.mo32296b()) {
            return 1;
        }
        if (zzuz.mo32295a() < zzuz2.mo32295a()) {
            return -1;
        }
        if (zzuz.mo32295a() > zzuz2.mo32295a()) {
            return 1;
        }
        float d = (zzuz.mo32298d() - zzuz.mo32296b()) * (zzuz.mo32297c() - zzuz.mo32295a());
        float d2 = (zzuz2.mo32298d() - zzuz2.mo32296b()) * (zzuz2.mo32297c() - zzuz2.mo32295a());
        if (d > d2) {
            return -1;
        }
        if (d < d2) {
            return 1;
        }
        return 0;
    }
}
