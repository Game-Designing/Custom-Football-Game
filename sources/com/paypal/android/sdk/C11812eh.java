package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.paypal.android.sdk.eh */
public class C11812eh implements Parcelable {
    public static final Creator CREATOR = new C11832ib();

    /* renamed from: a */
    private final String f37184a;

    public C11812eh(Parcel parcel) {
        this.f37184a = parcel.readString();
    }

    public C11812eh(String str) {
        if (str.equals("OTHER") || str.length() == 2) {
            this.f37184a = str;
        } else {
            this.f37184a = "US";
        }
    }

    /* renamed from: a */
    public final String mo38767a() {
        return this.f37184a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C11812eh.class != obj.getClass()) {
            return false;
        }
        return this.f37184a.equals(((C11812eh) obj).f37184a);
    }

    public int hashCode() {
        return this.f37184a.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f37184a);
    }
}
