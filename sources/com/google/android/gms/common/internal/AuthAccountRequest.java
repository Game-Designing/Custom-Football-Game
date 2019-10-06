package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR = new zaa();

    /* renamed from: a */
    private final int f20000a;
    @Deprecated

    /* renamed from: b */
    private final IBinder f20001b;

    /* renamed from: c */
    private final Scope[] f20002c;

    /* renamed from: d */
    private Integer f20003d;

    /* renamed from: e */
    private Integer f20004e;

    /* renamed from: f */
    private Account f20005f;

    @Constructor
    AuthAccountRequest(@Param(id = 1) int i, @Param(id = 2) IBinder iBinder, @Param(id = 3) Scope[] scopeArr, @Param(id = 4) Integer num, @Param(id = 5) Integer num2, @Param(id = 6) Account account) {
        this.f20000a = i;
        this.f20001b = iBinder;
        this.f20002c = scopeArr;
        this.f20003d = num;
        this.f20004e = num2;
        this.f20005f = account;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20000a);
        SafeParcelWriter.m21960a(parcel, 2, this.f20001b, false);
        SafeParcelWriter.m21970a(parcel, 3, (T[]) this.f20002c, i, false);
        SafeParcelWriter.m21963a(parcel, 4, this.f20003d, false);
        SafeParcelWriter.m21963a(parcel, 5, this.f20004e, false);
        SafeParcelWriter.m21962a(parcel, 6, (Parcelable) this.f20005f, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
