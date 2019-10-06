package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

@zzard
public final class zzarx extends AbstractSafeParcelable {
    public static final Creator<zzarx> CREATOR = new zzary();

    /* renamed from: a */
    public final Bundle f24715a;

    /* renamed from: b */
    public final zzbai f24716b;

    /* renamed from: c */
    public final ApplicationInfo f24717c;

    /* renamed from: d */
    public final String f24718d;

    /* renamed from: e */
    public final List<String> f24719e;

    /* renamed from: f */
    public final PackageInfo f24720f;

    /* renamed from: g */
    public final String f24721g;

    /* renamed from: h */
    public final boolean f24722h;

    /* renamed from: i */
    public final String f24723i;

    @Constructor
    public zzarx(@Param(id = 1) Bundle bundle, @Param(id = 2) zzbai zzbai, @Param(id = 3) ApplicationInfo applicationInfo, @Param(id = 4) String str, @Param(id = 5) List<String> list, @Param(id = 6) PackageInfo packageInfo, @Param(id = 7) String str2, @Param(id = 8) boolean z, @Param(id = 9) String str3) {
        this.f24715a = bundle;
        this.f24716b = zzbai;
        this.f24718d = str;
        this.f24717c = applicationInfo;
        this.f24719e = list;
        this.f24720f = packageInfo;
        this.f24721g = str2;
        this.f24722h = z;
        this.f24723i = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21959a(parcel, 1, this.f24715a, false);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f24716b, i, false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) this.f24717c, i, false);
        SafeParcelWriter.m21965a(parcel, 4, this.f24718d, false);
        SafeParcelWriter.m21975b(parcel, 5, this.f24719e, false);
        SafeParcelWriter.m21962a(parcel, 6, (Parcelable) this.f24720f, i, false);
        SafeParcelWriter.m21965a(parcel, 7, this.f24721g, false);
        SafeParcelWriter.m21968a(parcel, 8, this.f24722h);
        SafeParcelWriter.m21965a(parcel, 9, this.f24723i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
