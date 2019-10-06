package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Comparator;

public class DetectedActivity extends AbstractSafeParcelable {
    public static final Creator<DetectedActivity> CREATOR = new zzi();

    /* renamed from: a */
    private static final Comparator<DetectedActivity> f30470a = new C10032d();

    /* renamed from: b */
    private static final int[] f30471b = {9, 10};

    /* renamed from: c */
    private static final int[] f30472c = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19};

    /* renamed from: d */
    private static final int[] f30473d = {0, 1, 2, 3, 7, 8, 16, 17};

    /* renamed from: e */
    private int f30474e;

    /* renamed from: f */
    private int f30475f;

    @Constructor
    public DetectedActivity(@Param(id = 1) int i, @Param(id = 2) int i2) {
        this.f30474e = i;
        this.f30475f = i2;
    }

    /* renamed from: a */
    public static void m32667a(int i) {
        boolean z = false;
        for (int i2 : f30473d) {
            if (i2 == i) {
                z = true;
            }
        }
        if (!z) {
            StringBuilder sb = new StringBuilder(81);
            sb.append(i);
            sb.append(" is not a valid DetectedActivity supported by Activity Transition API.");
            Log.w("DetectedActivity", sb.toString());
        }
    }

    /* renamed from: a */
    public int mo33011a() {
        return this.f30475f;
    }

    /* renamed from: c */
    public int mo33012c() {
        int i = this.f30474e;
        if (i > 19 || i < 0) {
            return 4;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DetectedActivity.class == obj.getClass()) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            return this.f30474e == detectedActivity.f30474e && this.f30475f == detectedActivity.f30475f;
        }
    }

    public int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f30474e), Integer.valueOf(this.f30475f));
    }

    public String toString() {
        String str;
        int c = mo33012c();
        if (c == 0) {
            str = "IN_VEHICLE";
        } else if (c == 1) {
            str = "ON_BICYCLE";
        } else if (c == 2) {
            str = "ON_FOOT";
        } else if (c == 3) {
            str = "STILL";
        } else if (c == 4) {
            str = "UNKNOWN";
        } else if (c == 5) {
            str = "TILTING";
        } else if (c == 7) {
            str = "WALKING";
        } else if (c != 8) {
            switch (c) {
                case 16:
                    str = "IN_ROAD_VEHICLE";
                    break;
                case 17:
                    str = "IN_RAIL_VEHICLE";
                    break;
                case 18:
                    str = "IN_TWO_WHEELER_VEHICLE";
                    break;
                case 19:
                    str = "IN_FOUR_WHEELER_VEHICLE";
                    break;
                default:
                    str = Integer.toString(c);
                    break;
            }
        } else {
            str = "RUNNING";
        }
        int i = this.f30475f;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 48);
        sb.append("DetectedActivity [type=");
        sb.append(str);
        sb.append(", confidence=");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f30474e);
        SafeParcelWriter.m21957a(parcel, 2, this.f30475f);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
