package com.inmobi.ads;

import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

/* renamed from: com.inmobi.ads.ay */
/* compiled from: NativeScrollableDataSourceFactory */
final class C10435ay {
    /* renamed from: a */
    public static C10434ax m34163a(int i, C10406ao aoVar, C10419au auVar) {
        if (i == 0) {
            return new C10409ap(aoVar, auVar);
        }
        if (i != 1) {
            return null;
        }
        try {
            return new NativeRecyclerViewAdapter(aoVar, auVar);
        } catch (NoClassDefFoundError e) {
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Error rendering ad! RecyclerView not found. Please check if the recyclerview support library was included");
            C10621a.m34854a().mo34423a(new C10658a(e));
            return null;
        }
    }
}
