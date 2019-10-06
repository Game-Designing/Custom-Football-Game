package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new zza();

    /* renamed from: a */
    private final int f19252a;

    /* renamed from: b */
    private final long f19253b;

    /* renamed from: c */
    private final String f19254c;

    /* renamed from: d */
    private final int f19255d;

    /* renamed from: e */
    private final int f19256e;

    /* renamed from: f */
    private final String f19257f;

    @Constructor
    AccountChangeEvent(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 3) String str, @Param(id = 4) int i2, @Param(id = 5) int i3, @Param(id = 6) String str2) {
        this.f19252a = i;
        this.f19253b = j;
        Preconditions.m21857a(str);
        this.f19254c = str;
        this.f19255d = i2;
        this.f19256e = i3;
        this.f19257f = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19252a);
        SafeParcelWriter.m21958a(parcel, 2, this.f19253b);
        SafeParcelWriter.m21965a(parcel, 3, this.f19254c, false);
        SafeParcelWriter.m21957a(parcel, 4, this.f19255d);
        SafeParcelWriter.m21957a(parcel, 5, this.f19256e);
        SafeParcelWriter.m21965a(parcel, 6, this.f19257f, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public String toString() {
        String str;
        int i = this.f19255d;
        if (i == 1) {
            str = "ADDED";
        } else if (i == 2) {
            str = "REMOVED";
        } else if (i == 3) {
            str = "RENAMED_FROM";
        } else if (i != 4) {
            str = "UNKNOWN";
        } else {
            str = "RENAMED_TO";
        }
        String str2 = this.f19254c;
        String str3 = this.f19257f;
        int i2 = this.f19256e;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 91 + String.valueOf(str).length() + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f19252a), Long.valueOf(this.f19253b), this.f19254c, Integer.valueOf(this.f19255d), Integer.valueOf(this.f19256e), this.f19257f);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        if (this.f19252a == accountChangeEvent.f19252a && this.f19253b == accountChangeEvent.f19253b && Objects.m21851a(this.f19254c, accountChangeEvent.f19254c) && this.f19255d == accountChangeEvent.f19255d && this.f19256e == accountChangeEvent.f19256e && Objects.m21851a(this.f19257f, accountChangeEvent.f19257f)) {
            return true;
        }
        return false;
    }
}
