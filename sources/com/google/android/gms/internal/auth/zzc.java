package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzc {

    /* renamed from: a */
    private static final ClassLoader f29892a = zzc.class.getClassLoader();

    private zzc() {
    }

    /* renamed from: a */
    public static boolean m31676a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m31675a(Parcel parcel, Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }
}
