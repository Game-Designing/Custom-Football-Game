package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new zzq();

    /* renamed from: a */
    private final List<zzbh> f30482a;

    /* renamed from: b */
    private final int f30483b;

    /* renamed from: c */
    private final String f30484c;

    public static final class Builder {

        /* renamed from: a */
        private final List<zzbh> f30485a = new ArrayList();

        /* renamed from: b */
        private int f30486b = 5;

        /* renamed from: c */
        private String f30487c = "";
    }

    @Constructor
    GeofencingRequest(@Param(id = 1) List<zzbh> list, @Param(id = 2) int i, @Param(id = 3) String str) {
        this.f30482a = list;
        this.f30483b = i;
        this.f30484c = str;
    }

    /* renamed from: a */
    public int mo33018a() {
        return this.f30483b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeofencingRequest[");
        sb.append("geofences=");
        sb.append(this.f30482a);
        int i = this.f30483b;
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(", initialTrigger=");
        sb2.append(i);
        sb2.append(", ");
        sb.append(sb2.toString());
        String valueOf = String.valueOf(this.f30484c);
        String str = "tag=";
        sb.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21977c(parcel, 1, this.f30482a, false);
        SafeParcelWriter.m21957a(parcel, 2, mo33018a());
        SafeParcelWriter.m21965a(parcel, 3, this.f30484c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
