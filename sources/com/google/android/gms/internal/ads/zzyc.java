package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzard
public final class zzyc {

    /* renamed from: a */
    public static final zzyc f29767a = new zzyc();

    @VisibleForTesting
    protected zzyc() {
    }

    /* renamed from: a */
    public static zzxz m31508a(Context context, zzaaz zzaaz) {
        long j;
        List list;
        String str;
        zzaaz zzaaz2 = zzaaz;
        Date a = zzaaz.mo29384a();
        if (a != null) {
            j = a.getTime();
        } else {
            j = -1;
        }
        String b = zzaaz.mo29387b();
        int d = zzaaz.mo29390d();
        Set e = zzaaz.mo29391e();
        if (!e.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(e));
        } else {
            list = null;
        }
        boolean a2 = zzaaz2.mo29385a(context);
        int o = zzaaz.mo29401o();
        Location f = zzaaz.mo29392f();
        Bundle c = zzaaz2.mo29389c(AdMobAdapter.class);
        boolean g = zzaaz.mo29393g();
        String i = zzaaz.mo29395i();
        SearchAdRequest l = zzaaz.mo29398l();
        zzaca zzaca = l != null ? new zzaca(l) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzyt.m31532a();
            str = zzazt.m26306a(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        zzxz zzxz = new zzxz(8, j, c, d, list, a2, o, g, i, zzaca, f, b, zzaaz.mo29400n(), zzaaz.mo29388c(), Collections.unmodifiableList(new ArrayList(zzaaz.mo29402p())), zzaaz.mo29397k(), str, zzaaz.mo29396j(), null, zzaaz.mo29403q(), zzaaz.mo29394h());
        return zzxz;
    }
}
