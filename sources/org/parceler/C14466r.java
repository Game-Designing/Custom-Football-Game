package org.parceler;

import android.os.Parcel;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.r */
/* compiled from: NonParcelRepository */
class C14466r extends C14443k<Long> {
    C14466r() {
    }

    /* renamed from: b */
    public Long m46115b(Parcel parcel) {
        return Long.valueOf(parcel.readLong());
    }

    /* renamed from: a */
    public void mo45547b(Long input, Parcel parcel) {
        parcel.writeLong(input.longValue());
    }
}
