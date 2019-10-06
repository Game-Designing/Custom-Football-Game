package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzcmu {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Clock f27049a;

    /* renamed from: b */
    private final List<String> f27050b = Collections.synchronizedList(new ArrayList());

    public zzcmu(Clock clock) {
        this.f27049a = clock;
    }

    /* renamed from: a */
    public final <T> zzbbh<T> mo31210a(zzcxm zzcxm, zzbbh<T> zzbbh) {
        long a = this.f27049a.mo27934a();
        String str = zzcxm.f27569t;
        if (str != null) {
            zzbar.m26383a(zzbbh, (zzban<? super V>) new C9407ek<Object>(this, str, a), zzbbm.f25065b);
        }
        return zzbbh;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m28596a(String str, int i, long j) {
        List<String> list = this.f27050b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        String str2 = ".";
        sb.append(str2);
        sb.append(i);
        sb.append(str2);
        sb.append(j);
        list.add(sb.toString());
    }

    /* renamed from: a */
    public final String mo31211a() {
        return TextUtils.join("_", this.f27050b);
    }
}
