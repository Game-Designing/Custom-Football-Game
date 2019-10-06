package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Creator<AccountChangeEventsResponse> CREATOR = new zzc();

    /* renamed from: a */
    private final int f19262a;

    /* renamed from: b */
    private final List<AccountChangeEvent> f19263b;

    @Constructor
    AccountChangeEventsResponse(@Param(id = 1) int i, @Param(id = 2) List<AccountChangeEvent> list) {
        this.f19262a = i;
        Preconditions.m21857a(list);
        this.f19263b = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19262a);
        SafeParcelWriter.m21977c(parcel, 2, this.f19263b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
