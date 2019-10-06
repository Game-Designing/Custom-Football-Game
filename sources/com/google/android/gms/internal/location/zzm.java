package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.zzj;
import java.util.Collections;
import java.util.List;

public final class zzm extends AbstractSafeParcelable {
    public static final Creator<zzm> CREATOR = new zzn();
    @VisibleForTesting

    /* renamed from: a */
    static final List<ClientIdentity> f29973a = Collections.emptyList();

    /* renamed from: b */
    static final zzj f29974b = new zzj();

    /* renamed from: c */
    private zzj f29975c;

    /* renamed from: d */
    private List<ClientIdentity> f29976d;

    /* renamed from: e */
    private String f29977e;

    @Constructor
    zzm(@Param(id = 1) zzj zzj, @Param(id = 2) List<ClientIdentity> list, @Param(id = 3) String str) {
        this.f29975c = zzj;
        this.f29976d = list;
        this.f29977e = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzm = (zzm) obj;
        return Objects.m21851a(this.f29975c, zzm.f29975c) && Objects.m21851a(this.f29976d, zzm.f29976d) && Objects.m21851a(this.f29977e, zzm.f29977e);
    }

    public final int hashCode() {
        return this.f29975c.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 1, (Parcelable) this.f29975c, i, false);
        SafeParcelWriter.m21977c(parcel, 2, this.f29976d, false);
        SafeParcelWriter.m21965a(parcel, 3, this.f29977e, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
