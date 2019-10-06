package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Map;
import java.util.Map.Entry;

@zzard
public final class zzaia extends AbstractSafeParcelable {
    public static final Creator<zzaia> CREATOR = new zzaib();

    /* renamed from: a */
    private final String f24352a;

    /* renamed from: b */
    private final String[] f24353b;

    /* renamed from: c */
    private final String[] f24354c;

    @Constructor
    zzaia(@Param(id = 1) String str, @Param(id = 2) String[] strArr, @Param(id = 3) String[] strArr2) {
        this.f24352a = str;
        this.f24353b = strArr;
        this.f24354c = strArr2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f24352a, false);
        SafeParcelWriter.m21971a(parcel, 2, this.f24353b, false);
        SafeParcelWriter.m21971a(parcel, 3, this.f24354c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* renamed from: a */
    public static zzaia m25074a(zzr zzr) throws zza {
        Map e = zzr.mo29244e();
        int size = e.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Entry entry : e.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            i++;
        }
        return new zzaia(zzr.mo32131g(), strArr, strArr2);
    }
}
