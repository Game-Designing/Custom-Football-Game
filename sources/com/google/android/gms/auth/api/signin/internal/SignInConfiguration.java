package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzx();

    /* renamed from: a */
    private final String f19469a;

    /* renamed from: b */
    private GoogleSignInOptions f19470b;

    @Constructor
    public SignInConfiguration(@Param(id = 2) String str, @Param(id = 5) GoogleSignInOptions googleSignInOptions) {
        Preconditions.m21866b(str);
        this.f19469a = str;
        this.f19470b = googleSignInOptions;
    }

    /* renamed from: a */
    public final GoogleSignInOptions mo27222a() {
        return this.f19470b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f19469a, false);
        SafeParcelWriter.m21962a(parcel, 5, (Parcelable) this.f19470b, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f19469a.equals(signInConfiguration.f19469a)) {
            GoogleSignInOptions googleSignInOptions = this.f19470b;
            if (googleSignInOptions != null ? googleSignInOptions.equals(signInConfiguration.f19470b) : signInConfiguration.f19470b == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new HashAccumulator().mo27220a((Object) this.f19469a).mo27220a((Object) this.f19470b).mo27219a();
    }
}
