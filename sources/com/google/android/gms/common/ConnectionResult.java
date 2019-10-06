package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Creator<ConnectionResult> CREATOR = new zza();
    @KeepForSdk

    /* renamed from: a */
    public static final ConnectionResult f19510a = new ConnectionResult(0);

    /* renamed from: b */
    private final int f19511b;

    /* renamed from: c */
    private final int f19512c;

    /* renamed from: d */
    private final PendingIntent f19513d;

    /* renamed from: e */
    private final String f19514e;

    @Constructor
    ConnectionResult(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) PendingIntent pendingIntent, @Param(id = 4) String str) {
        this.f19511b = i;
        this.f19512c = i2;
        this.f19513d = pendingIntent;
        this.f19514e = str;
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    /* renamed from: a */
    public final void mo27276a(Activity activity, int i) throws SendIntentException {
        if (mo27279e()) {
            activity.startIntentSenderForResult(this.f19513d.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    /* renamed from: e */
    public final boolean mo27279e() {
        return (this.f19512c == 0 || this.f19513d == null) ? false : true;
    }

    /* renamed from: f */
    public final boolean mo27281f() {
        return this.f19512c == 0;
    }

    /* renamed from: a */
    public final int mo27275a() {
        return this.f19512c;
    }

    /* renamed from: d */
    public final PendingIntent mo27278d() {
        return this.f19513d;
    }

    /* renamed from: c */
    public final String mo27277c() {
        return this.f19514e;
    }

    /* renamed from: a */
    static String m21057a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        if (this.f19512c != connectionResult.f19512c || !Objects.m21851a(this.f19513d, connectionResult.f19513d) || !Objects.m21851a(this.f19514e, connectionResult.f19514e)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f19512c), this.f19513d, this.f19514e);
    }

    public final String toString() {
        return Objects.m21850a((Object) this).mo27810a("statusCode", m21057a(this.f19512c)).mo27810a("resolution", this.f19513d).mo27810a("message", this.f19514e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19511b);
        SafeParcelWriter.m21957a(parcel, 2, mo27275a());
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) mo27278d(), i, false);
        SafeParcelWriter.m21965a(parcel, 4, mo27277c(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
