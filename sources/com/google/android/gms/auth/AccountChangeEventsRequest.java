package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    /* renamed from: a */
    private final int f19258a;

    /* renamed from: b */
    private int f19259b;
    @Deprecated

    /* renamed from: c */
    private String f19260c;

    /* renamed from: d */
    private Account f19261d;

    @Constructor
    AccountChangeEventsRequest(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) String str, @Param(id = 4) Account account) {
        this.f19258a = i;
        this.f19259b = i2;
        this.f19260c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f19261d = account;
        } else {
            this.f19261d = new Account(str, "com.google");
        }
    }

    public AccountChangeEventsRequest() {
        this.f19258a = 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19258a);
        SafeParcelWriter.m21957a(parcel, 2, this.f19259b);
        SafeParcelWriter.m21965a(parcel, 3, this.f19260c, false);
        SafeParcelWriter.m21962a(parcel, 4, (Parcelable) this.f19261d, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
