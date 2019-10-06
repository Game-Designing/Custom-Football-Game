package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new zzb();
    @KeepForSdk
    @VisibleForTesting

    /* renamed from: a */
    public static final Status f19597a = new Status(0);
    @KeepForSdk

    /* renamed from: b */
    public static final Status f19598b = new Status(14);
    @KeepForSdk

    /* renamed from: c */
    public static final Status f19599c = new Status(8);
    @KeepForSdk

    /* renamed from: d */
    public static final Status f19600d = new Status(15);
    @KeepForSdk

    /* renamed from: e */
    public static final Status f19601e = new Status(16);

    /* renamed from: f */
    private static final Status f19602f = new Status(17);
    @KeepForSdk

    /* renamed from: g */
    public static final Status f19603g = new Status(18);

    /* renamed from: h */
    private final int f19604h;

    /* renamed from: i */
    private final int f19605i;

    /* renamed from: j */
    private final String f19606j;

    /* renamed from: k */
    private final PendingIntent f19607k;

    @Constructor
    @KeepForSdk
    Status(@Param(id = 1000) int i, @Param(id = 1) int i2, @Param(id = 2) String str, @Param(id = 3) PendingIntent pendingIntent) {
        this.f19604h = i;
        this.f19605i = i2;
        this.f19606j = str;
        this.f19607k = pendingIntent;
    }

    @KeepForSdk
    public Status(int i) {
        this(i, null);
    }

    @KeepForSdk
    public Status(int i, String str) {
        this(1, i, str, null);
    }

    @KeepForSdk
    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    /* renamed from: a */
    public final void mo27418a(Activity activity, int i) throws SendIntentException {
        if (mo27420d()) {
            activity.startIntentSenderForResult(this.f19607k.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    /* renamed from: c */
    public final String mo27419c() {
        return this.f19606j;
    }

    @VisibleForTesting
    /* renamed from: d */
    public final boolean mo27420d() {
        return this.f19607k != null;
    }

    /* renamed from: e */
    public final boolean mo27421e() {
        return this.f19605i <= 0;
    }

    /* renamed from: a */
    public final int mo27417a() {
        return this.f19605i;
    }

    public final int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f19604h), Integer.valueOf(this.f19605i), this.f19606j, this.f19607k);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f19604h != status.f19604h || this.f19605i != status.f19605i || !Objects.m21851a(this.f19606j, status.f19606j) || !Objects.m21851a(this.f19607k, status.f19607k)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final String mo27423f() {
        String str = this.f19606j;
        if (str != null) {
            return str;
        }
        return CommonStatusCodes.m21125a(this.f19605i);
    }

    public final String toString() {
        return Objects.m21850a((Object) this).mo27810a("statusCode", mo27423f()).mo27810a("resolution", this.f19607k).toString();
    }

    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, mo27417a());
        SafeParcelWriter.m21965a(parcel, 2, mo27419c(), false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) this.f19607k, i, false);
        SafeParcelWriter.m21957a(parcel, 1000, this.f19604h);
        SafeParcelWriter.m21954a(parcel, a);
    }

    @KeepForSdk
    public final Status getStatus() {
        return this;
    }
}
