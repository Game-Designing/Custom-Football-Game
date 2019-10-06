package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new zam();

    /* renamed from: a */
    private final int f20121a;

    /* renamed from: b */
    private final Account f20122b;

    /* renamed from: c */
    private final int f20123c;

    /* renamed from: d */
    private final GoogleSignInAccount f20124d;

    @Constructor
    ResolveAccountRequest(@Param(id = 1) int i, @Param(id = 2) Account account, @Param(id = 3) int i2, @Param(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.f20121a = i;
        this.f20122b = account;
        this.f20123c = i2;
        this.f20124d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    /* renamed from: a */
    public Account mo27813a() {
        return this.f20122b;
    }

    /* renamed from: c */
    public int mo27814c() {
        return this.f20123c;
    }

    /* renamed from: d */
    public GoogleSignInAccount mo27815d() {
        return this.f20124d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20121a);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) mo27813a(), i, false);
        SafeParcelWriter.m21957a(parcel, 3, mo27814c());
        SafeParcelWriter.m21962a(parcel, 4, (Parcelable) mo27815d(), i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
