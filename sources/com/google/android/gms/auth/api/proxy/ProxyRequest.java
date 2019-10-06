package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdkWithMembers
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new zza();

    /* renamed from: a */
    public static final int f19389a = 0;

    /* renamed from: b */
    public static final int f19390b = 1;

    /* renamed from: c */
    public static final int f19391c = 2;

    /* renamed from: d */
    public static final int f19392d = 3;

    /* renamed from: e */
    public static final int f19393e = 4;

    /* renamed from: f */
    public static final int f19394f = 5;

    /* renamed from: g */
    public static final int f19395g = 6;

    /* renamed from: h */
    public static final int f19396h = 7;

    /* renamed from: i */
    public static final int f19397i = 7;

    /* renamed from: j */
    private final int f19398j;

    /* renamed from: k */
    public final String f19399k;

    /* renamed from: l */
    public final int f19400l;

    /* renamed from: m */
    public final long f19401m;

    /* renamed from: n */
    public final byte[] f19402n;

    /* renamed from: o */
    private Bundle f19403o;

    @KeepForSdkWithMembers
    public static class Builder {
    }

    @Constructor
    ProxyRequest(@Param(id = 1000) int i, @Param(id = 1) String str, @Param(id = 2) int i2, @Param(id = 3) long j, @Param(id = 4) byte[] bArr, @Param(id = 5) Bundle bundle) {
        this.f19398j = i;
        this.f19399k = str;
        this.f19400l = i2;
        this.f19401m = j;
        this.f19402n = bArr;
        this.f19403o = bundle;
    }

    public String toString() {
        String str = this.f19399k;
        int i = this.f19400l;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i);
        sb.append(" ]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f19399k, false);
        SafeParcelWriter.m21957a(parcel, 2, this.f19400l);
        SafeParcelWriter.m21958a(parcel, 3, this.f19401m);
        SafeParcelWriter.m21969a(parcel, 4, this.f19402n, false);
        SafeParcelWriter.m21959a(parcel, 5, this.f19403o, false);
        SafeParcelWriter.m21957a(parcel, 1000, this.f19398j);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
