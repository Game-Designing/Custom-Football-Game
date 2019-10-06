package org.parceler;

import android.os.Parcel;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.k */
/* compiled from: NonParcelRepository */
class C14459k extends C14443k<Float> {
    C14459k() {
    }

    /* renamed from: b */
    public Float m46093b(Parcel parcel) {
        return Float.valueOf(parcel.readFloat());
    }

    /* renamed from: a */
    public void mo45547b(Float input, Parcel parcel) {
        parcel.writeFloat(input.floatValue());
    }
}
