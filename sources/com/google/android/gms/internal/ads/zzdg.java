package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzdg extends zzdf {
    /* renamed from: a */
    public static zzdg m29386a(String str, Context context, boolean z) {
        zzdf.m29306a(context, z);
        return new zzdg(context, str, z);
    }

    private zzdg(Context context, String str, boolean z) {
        super(context, str, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final List<Callable<Void>> mo31404b(zzdy zzdy, Context context, C15005zza zza, zza zza2) {
        if (zzdy.mo31716d() == null || !this.f27834y) {
            return super.mo31404b(zzdy, context, zza, zza2);
        }
        int c = zzdy.mo31715c();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.mo31404b(zzdy, context, zza, zza2));
        zzes zzes = new zzes(zzdy, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", zza, c, 24);
        arrayList.add(zzes);
        return arrayList;
    }
}
