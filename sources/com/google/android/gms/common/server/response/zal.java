package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.Map;

@ShowFirstParty
public final class zal extends AbstractSafeParcelable {
    public static final Creator<zal> CREATOR = new zao();

    /* renamed from: a */
    private final int f20244a;

    /* renamed from: b */
    final String f20245b;

    /* renamed from: c */
    final ArrayList<zam> f20246c;

    @Constructor
    zal(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) ArrayList<zam> arrayList) {
        this.f20244a = i;
        this.f20245b = str;
        this.f20246c = arrayList;
    }

    zal(String str, Map<String, Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.f20244a = 1;
        this.f20245b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (Field) map.get(str2)));
            }
        }
        this.f20246c = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20244a);
        SafeParcelWriter.m21965a(parcel, 2, this.f20245b, false);
        SafeParcelWriter.m21977c(parcel, 3, this.f20246c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
