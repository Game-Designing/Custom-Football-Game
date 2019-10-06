package com.google.android.gms.internal.ads;

import com.google.ads.mediation.C8081a;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p019d.p271g.p272a.C12720a;
import p019d.p271g.p272a.C12721b;

@zzard
public final class zzaog {
    /* renamed from: a */
    public static int m25541a(C12720a aVar) {
        int i = C9247Ya.f21936b[aVar.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            return 0;
        }
        return 3;
    }

    /* renamed from: a */
    public static C8081a m25542a(zzxz zzxz, boolean z) {
        C12721b bVar;
        List<String> list = zzxz.f29727e;
        Set hashSet = list != null ? new HashSet(list) : null;
        Date date = new Date(zzxz.f29724b);
        int i = zzxz.f29726d;
        if (i == 1) {
            bVar = C12721b.MALE;
        } else if (i != 2) {
            bVar = C12721b.UNKNOWN;
        } else {
            bVar = C12721b.FEMALE;
        }
        C8081a aVar = new C8081a(date, bVar, hashSet, z, zzxz.f29733k);
        return aVar;
    }
}
