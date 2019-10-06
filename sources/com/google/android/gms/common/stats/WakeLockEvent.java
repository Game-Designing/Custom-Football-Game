package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new zza();

    /* renamed from: a */
    private final int f20267a;

    /* renamed from: b */
    private final long f20268b;

    /* renamed from: c */
    private int f20269c;

    /* renamed from: d */
    private final String f20270d;

    /* renamed from: e */
    private final String f20271e;

    /* renamed from: f */
    private final String f20272f;

    /* renamed from: g */
    private final int f20273g;

    /* renamed from: h */
    private final List<String> f20274h;

    /* renamed from: i */
    private final String f20275i;

    /* renamed from: j */
    private final long f20276j;

    /* renamed from: k */
    private int f20277k;

    /* renamed from: l */
    private final String f20278l;

    /* renamed from: m */
    private final float f20279m;

    /* renamed from: n */
    private final long f20280n;

    /* renamed from: o */
    private final boolean f20281o;

    /* renamed from: p */
    private long f20282p = -1;

    @Constructor
    WakeLockEvent(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 11) int i2, @Param(id = 4) String str, @Param(id = 5) int i3, @Param(id = 6) List<String> list, @Param(id = 12) String str2, @Param(id = 8) long j2, @Param(id = 14) int i4, @Param(id = 10) String str3, @Param(id = 13) String str4, @Param(id = 15) float f, @Param(id = 16) long j3, @Param(id = 17) String str5, @Param(id = 18) boolean z) {
        this.f20267a = i;
        this.f20268b = j;
        this.f20269c = i2;
        this.f20270d = str;
        this.f20271e = str3;
        this.f20272f = str5;
        this.f20273g = i3;
        this.f20274h = list;
        this.f20275i = str2;
        this.f20276j = j2;
        this.f20277k = i4;
        this.f20278l = str4;
        this.f20279m = f;
        this.f20280n = j3;
        this.f20281o = z;
    }

    /* renamed from: c */
    public final long mo27927c() {
        return this.f20268b;
    }

    /* renamed from: a */
    public final int mo27926a() {
        return this.f20269c;
    }

    /* renamed from: d */
    public final long mo27928d() {
        return this.f20282p;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20267a);
        SafeParcelWriter.m21958a(parcel, 2, mo27927c());
        SafeParcelWriter.m21965a(parcel, 4, this.f20270d, false);
        SafeParcelWriter.m21957a(parcel, 5, this.f20273g);
        SafeParcelWriter.m21975b(parcel, 6, this.f20274h, false);
        SafeParcelWriter.m21958a(parcel, 8, this.f20276j);
        SafeParcelWriter.m21965a(parcel, 10, this.f20271e, false);
        SafeParcelWriter.m21957a(parcel, 11, mo27926a());
        SafeParcelWriter.m21965a(parcel, 12, this.f20275i, false);
        SafeParcelWriter.m21965a(parcel, 13, this.f20278l, false);
        SafeParcelWriter.m21957a(parcel, 14, this.f20277k);
        SafeParcelWriter.m21956a(parcel, 15, this.f20279m);
        SafeParcelWriter.m21958a(parcel, 16, this.f20280n);
        SafeParcelWriter.m21965a(parcel, 17, this.f20272f, false);
        SafeParcelWriter.m21968a(parcel, 18, this.f20281o);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* renamed from: e */
    public final String mo27929e() {
        String str;
        String str2 = this.f20270d;
        int i = this.f20273g;
        List<String> list = this.f20274h;
        String str3 = "";
        if (list == null) {
            str = str3;
        } else {
            str = TextUtils.join(",", list);
        }
        int i2 = this.f20277k;
        String str4 = this.f20271e;
        if (str4 == null) {
            str4 = str3;
        }
        String str5 = this.f20278l;
        if (str5 == null) {
            str5 = str3;
        }
        float f = this.f20279m;
        String str6 = this.f20272f;
        if (str6 != null) {
            str3 = str6;
        }
        boolean z = this.f20281o;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 51 + String.valueOf(str).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str3).length());
        String str7 = "\t";
        sb.append(str7);
        sb.append(str2);
        sb.append(str7);
        sb.append(i);
        sb.append(str7);
        sb.append(str);
        sb.append(str7);
        sb.append(i2);
        sb.append(str7);
        sb.append(str4);
        sb.append(str7);
        sb.append(str5);
        sb.append(str7);
        sb.append(f);
        sb.append(str7);
        sb.append(str3);
        sb.append(str7);
        sb.append(z);
        return sb.toString();
    }
}
