package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import p005cm.aptoide.p006pt.BuildConfig;

@zzard
public final class zzbai extends AbstractSafeParcelable {
    public static final Creator<zzbai> CREATOR = new zzbaj();

    /* renamed from: a */
    public String f25057a;

    /* renamed from: b */
    public int f25058b;

    /* renamed from: c */
    public int f25059c;

    /* renamed from: d */
    public boolean f25060d;

    /* renamed from: e */
    private boolean f25061e;

    public zzbai(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzbai(int i, int i2, boolean z, boolean z2) {
        this(i, i2, true, false, false);
    }

    private zzbai(int i, int i2, boolean z, boolean z2, boolean z3) {
        String str = z ? BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID : "1";
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36);
        sb.append("afma-sdk-a-v");
        sb.append(i);
        String str2 = ".";
        sb.append(str2);
        sb.append(i2);
        sb.append(str2);
        sb.append(str);
        this(sb.toString(), i, i2, z, false);
    }

    @Constructor
    zzbai(@Param(id = 2) String str, @Param(id = 3) int i, @Param(id = 4) int i2, @Param(id = 5) boolean z, @Param(id = 6) boolean z2) {
        this.f25057a = str;
        this.f25058b = i;
        this.f25059c = i2;
        this.f25060d = z;
        this.f25061e = z2;
    }

    /* renamed from: a */
    public static zzbai m26367a() {
        return new zzbai(12451009, 12451009, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f25057a, false);
        SafeParcelWriter.m21957a(parcel, 3, this.f25058b);
        SafeParcelWriter.m21957a(parcel, 4, this.f25059c);
        SafeParcelWriter.m21968a(parcel, 5, this.f25060d);
        SafeParcelWriter.m21968a(parcel, 6, this.f25061e);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
