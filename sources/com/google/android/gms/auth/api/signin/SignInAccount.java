package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<SignInAccount> CREATOR = new zzd();
    @Deprecated

    /* renamed from: a */
    private String f19459a;

    /* renamed from: b */
    private GoogleSignInAccount f19460b;
    @Deprecated

    /* renamed from: c */
    private String f19461c;

    @Constructor
    SignInAccount(@Param(id = 4) String str, @Param(id = 7) GoogleSignInAccount googleSignInAccount, @Param(id = 8) String str2) {
        this.f19460b = googleSignInAccount;
        Preconditions.m21859a(str, (Object) "8.3 and 8.4 SDKs require non-null email");
        this.f19459a = str;
        Preconditions.m21859a(str2, (Object) "8.3 and 8.4 SDKs require non-null userId");
        this.f19461c = str2;
    }

    /* renamed from: a */
    public final GoogleSignInAccount mo27213a() {
        return this.f19460b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 4, this.f19459a, false);
        SafeParcelWriter.m21962a(parcel, 7, (Parcelable) this.f19460b, i, false);
        SafeParcelWriter.m21965a(parcel, 8, this.f19461c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
