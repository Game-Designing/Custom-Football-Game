package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor.Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new zzd();

    /* renamed from: a */
    private final int f20078a;

    /* renamed from: b */
    private final int f20079b;

    /* renamed from: c */
    private int f20080c;

    /* renamed from: d */
    String f20081d;

    /* renamed from: e */
    IBinder f20082e;

    /* renamed from: f */
    Scope[] f20083f;

    /* renamed from: g */
    Bundle f20084g;

    /* renamed from: h */
    Account f20085h;

    /* renamed from: i */
    Feature[] f20086i;

    /* renamed from: j */
    Feature[] f20087j;

    /* renamed from: k */
    private boolean f20088k;

    public GetServiceRequest(int i) {
        this.f20078a = 4;
        this.f20080c = GoogleApiAvailabilityLight.f19526a;
        this.f20079b = i;
        this.f20088k = true;
    }

    @Constructor
    GetServiceRequest(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3, @Param(id = 4) String str, @Param(id = 5) IBinder iBinder, @Param(id = 6) Scope[] scopeArr, @Param(id = 7) Bundle bundle, @Param(id = 8) Account account, @Param(id = 10) Feature[] featureArr, @Param(id = 11) Feature[] featureArr2, @Param(id = 12) boolean z) {
        this.f20078a = i;
        this.f20079b = i2;
        this.f20080c = i3;
        String str2 = "com.google.android.gms";
        if (str2.equals(str)) {
            this.f20081d = str2;
        } else {
            this.f20081d = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                account2 = AccountAccessor.m21720a(Stub.m21835a(iBinder));
            }
            this.f20085h = account2;
        } else {
            this.f20082e = iBinder;
            this.f20085h = account;
        }
        this.f20083f = scopeArr;
        this.f20084g = bundle;
        this.f20086i = featureArr;
        this.f20087j = featureArr2;
        this.f20088k = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20078a);
        SafeParcelWriter.m21957a(parcel, 2, this.f20079b);
        SafeParcelWriter.m21957a(parcel, 3, this.f20080c);
        SafeParcelWriter.m21965a(parcel, 4, this.f20081d, false);
        SafeParcelWriter.m21960a(parcel, 5, this.f20082e, false);
        SafeParcelWriter.m21970a(parcel, 6, (T[]) this.f20083f, i, false);
        SafeParcelWriter.m21959a(parcel, 7, this.f20084g, false);
        SafeParcelWriter.m21962a(parcel, 8, (Parcelable) this.f20085h, i, false);
        SafeParcelWriter.m21970a(parcel, 10, (T[]) this.f20086i, i, false);
        SafeParcelWriter.m21970a(parcel, 11, (T[]) this.f20087j, i, false);
        SafeParcelWriter.m21968a(parcel, 12, this.f20088k);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
