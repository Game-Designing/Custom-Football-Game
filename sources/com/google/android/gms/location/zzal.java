package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Collections;
import java.util.List;

public final class zzal extends AbstractSafeParcelable {
    public static final Creator<zzal> CREATOR = new zzam();

    /* renamed from: a */
    private final List<String> f30537a;

    /* renamed from: b */
    private final PendingIntent f30538b;

    /* renamed from: c */
    private final String f30539c;

    @Constructor
    zzal(@Param(id = 1) List<String> list, @Param(id = 2) PendingIntent pendingIntent, @Param(id = 3) String str) {
        this.f30537a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f30538b = pendingIntent;
        this.f30539c = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21975b(parcel, 1, this.f30537a, false);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f30538b, i, false);
        SafeParcelWriter.m21965a(parcel, 3, this.f30539c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
