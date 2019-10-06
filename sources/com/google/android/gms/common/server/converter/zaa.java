package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

public final class zaa extends AbstractSafeParcelable {
    public static final Creator<zaa> CREATOR = new zab();

    /* renamed from: a */
    private final int f20200a;

    /* renamed from: b */
    private final StringToIntConverter f20201b;

    @Constructor
    zaa(@Param(id = 1) int i, @Param(id = 2) StringToIntConverter stringToIntConverter) {
        this.f20200a = i;
        this.f20201b = stringToIntConverter;
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.f20200a = 1;
        this.f20201b = stringToIntConverter;
    }

    /* renamed from: a */
    public static zaa m22014a(FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* renamed from: a */
    public final FieldConverter<?, ?> mo27878a() {
        StringToIntConverter stringToIntConverter = this.f20201b;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20200a);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f20201b, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
