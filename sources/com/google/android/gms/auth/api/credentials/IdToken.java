package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<IdToken> CREATOR = new zzk();

    /* renamed from: a */
    private final String f19383a;

    /* renamed from: b */
    private final String f19384b;

    @Constructor
    public IdToken(@Param(id = 1) String str, @Param(id = 2) String str2) {
        Preconditions.m21864a(!TextUtils.isEmpty(str), (Object) "account type string cannot be null or empty");
        Preconditions.m21864a(!TextUtils.isEmpty(str2), (Object) "id token string cannot be null or empty");
        this.f19383a = str;
        this.f19384b = str2;
    }

    /* renamed from: a */
    public final String mo27150a() {
        return this.f19383a;
    }

    /* renamed from: c */
    public final String mo27151c() {
        return this.f19384b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, mo27150a(), false);
        SafeParcelWriter.m21965a(parcel, 2, mo27151c(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        if (!Objects.m21851a(this.f19383a, idToken.f19383a) || !Objects.m21851a(this.f19384b, idToken.f19384b)) {
            return false;
        }
        return true;
    }
}
