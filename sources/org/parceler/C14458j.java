package org.parceler;

import android.os.Parcel;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.j */
/* compiled from: NonParcelRepository */
class C14458j extends C14443k<Double> {
    C14458j() {
    }

    /* renamed from: b */
    public Double m46089b(Parcel parcel) {
        return Double.valueOf(parcel.readDouble());
    }

    /* renamed from: a */
    public void mo45547b(Double input, Parcel parcel) {
        parcel.writeDouble(input.doubleValue());
    }
}
