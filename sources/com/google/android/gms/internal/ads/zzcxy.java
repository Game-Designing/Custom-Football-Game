package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

public final class zzcxy {
    /* renamed from: a */
    public static zzyd m28988a(Context context, List<zzcxn> list) {
        ArrayList arrayList = new ArrayList();
        for (zzcxn zzcxn : list) {
            if (zzcxn.f27578c) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzcxn.f27576a, zzcxn.f27577b));
            }
        }
        return new zzyd(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }
}
