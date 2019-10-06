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
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzbd extends AbstractSafeParcelable {
    public static final Creator<zzbd> CREATOR = new zzbe();

    /* renamed from: a */
    static final List<ClientIdentity> f29946a = Collections.emptyList();

    /* renamed from: b */
    private LocationRequest f29947b;

    /* renamed from: c */
    private List<ClientIdentity> f29948c;

    /* renamed from: d */
    private String f29949d;

    /* renamed from: e */
    private boolean f29950e;

    /* renamed from: f */
    private boolean f29951f;

    /* renamed from: g */
    private boolean f29952g;

    /* renamed from: h */
    private String f29953h;

    /* renamed from: i */
    private boolean f29954i = true;

    @Constructor
    zzbd(@Param(id = 1) LocationRequest locationRequest, @Param(id = 5) List<ClientIdentity> list, @Param(id = 6) String str, @Param(id = 7) boolean z, @Param(id = 8) boolean z2, @Param(id = 9) boolean z3, @Param(id = 10) String str2) {
        this.f29947b = locationRequest;
        this.f29948c = list;
        this.f29949d = str;
        this.f29950e = z;
        this.f29951f = z2;
        this.f29952g = z3;
        this.f29953h = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbd = (zzbd) obj;
        return Objects.m21851a(this.f29947b, zzbd.f29947b) && Objects.m21851a(this.f29948c, zzbd.f29948c) && Objects.m21851a(this.f29949d, zzbd.f29949d) && this.f29950e == zzbd.f29950e && this.f29951f == zzbd.f29951f && this.f29952g == zzbd.f29952g && Objects.m21851a(this.f29953h, zzbd.f29953h);
    }

    public final int hashCode() {
        return this.f29947b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f29947b);
        if (this.f29949d != null) {
            sb.append(" tag=");
            sb.append(this.f29949d);
        }
        if (this.f29953h != null) {
            sb.append(" moduleId=");
            sb.append(this.f29953h);
        }
        sb.append(" hideAppOps=");
        sb.append(this.f29950e);
        sb.append(" clients=");
        sb.append(this.f29948c);
        sb.append(" forceCoarseLocation=");
        sb.append(this.f29951f);
        if (this.f29952g) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 1, (Parcelable) this.f29947b, i, false);
        SafeParcelWriter.m21977c(parcel, 5, this.f29948c, false);
        SafeParcelWriter.m21965a(parcel, 6, this.f29949d, false);
        SafeParcelWriter.m21968a(parcel, 7, this.f29950e);
        SafeParcelWriter.m21968a(parcel, 8, this.f29951f);
        SafeParcelWriter.m21968a(parcel, 9, this.f29952g);
        SafeParcelWriter.m21965a(parcel, 10, this.f29953h, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
