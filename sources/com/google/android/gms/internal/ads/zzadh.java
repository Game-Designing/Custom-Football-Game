package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

@zzard
public final class zzadh {

    /* renamed from: a */
    private final Map<String, zzadg> f24233a = new HashMap();

    /* renamed from: b */
    private final zzadi f24234b;

    public zzadh(zzadi zzadi) {
        this.f24234b = zzadi;
    }

    /* renamed from: a */
    public final void mo29615a(String str, zzadg zzadg) {
        this.f24233a.put(str, zzadg);
    }

    /* renamed from: a */
    public final void mo29616a(String str, String str2, long j) {
        zzadg zzadg;
        zzadi zzadi = this.f24234b;
        zzadg zzadg2 = (zzadg) this.f24233a.get(str2);
        String[] strArr = {str};
        if (!(zzadi == null || zzadg2 == null)) {
            zzadi.mo29621a(zzadg2, j, strArr);
        }
        Map<String, zzadg> map = this.f24233a;
        zzadi zzadi2 = this.f24234b;
        if (zzadi2 == null) {
            zzadg = null;
        } else {
            zzadg = zzadi2.mo29617a(j);
        }
        map.put(str, zzadg);
    }

    /* renamed from: a */
    public final zzadi mo29614a() {
        return this.f24234b;
    }
}
