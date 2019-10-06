package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public interface Types {
    }

    /* renamed from: a */
    public abstract int mo27926a();

    /* renamed from: c */
    public abstract long mo27927c();

    /* renamed from: d */
    public abstract long mo27928d();

    /* renamed from: e */
    public abstract String mo27929e();

    public String toString() {
        long c = mo27927c();
        int a = mo27926a();
        long d = mo27928d();
        String e = mo27929e();
        StringBuilder sb = new StringBuilder(String.valueOf(e).length() + 53);
        sb.append(c);
        String str = "\t";
        sb.append(str);
        sb.append(a);
        sb.append(str);
        sb.append(d);
        sb.append(e);
        return sb.toString();
    }
}
