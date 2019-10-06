package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Collections;
import java.util.List;

@zzard
public final class zzark extends AbstractSafeParcelable {
    public static final Creator<zzark> CREATOR = new zzarl();

    /* renamed from: a */
    public final boolean f24710a;

    /* renamed from: b */
    public final List<String> f24711b;

    public zzark() {
        this(false, Collections.emptyList());
    }

    @Constructor
    public zzark(@Param(id = 2) boolean z, @Param(id = 3) List<String> list) {
        this.f24710a = z;
        this.f24711b = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21968a(parcel, 2, this.f24710a);
        SafeParcelWriter.m21975b(parcel, 3, this.f24711b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
