package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

@ShowFirstParty
public final class zam extends AbstractSafeParcelable {
    public static final Creator<zam> CREATOR = new zaj();

    /* renamed from: a */
    private final int f20247a;

    /* renamed from: b */
    final String f20248b;

    /* renamed from: c */
    final Field<?, ?> f20249c;

    @Constructor
    zam(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) Field<?, ?> field) {
        this.f20247a = i;
        this.f20248b = str;
        this.f20249c = field;
    }

    zam(String str, Field<?, ?> field) {
        this.f20247a = 1;
        this.f20248b = str;
        this.f20249c = field;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20247a);
        SafeParcelWriter.m21965a(parcel, 2, this.f20248b, false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) this.f20249c, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
