package org.parceler;

import android.os.Parcel;
import android.util.SparseBooleanArray;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.v */
/* compiled from: NonParcelRepository */
class C14470v extends C14443k<SparseBooleanArray> {
    C14470v() {
    }

    /* renamed from: b */
    public SparseBooleanArray m46127b(Parcel parcel) {
        return parcel.readSparseBooleanArray();
    }

    /* renamed from: a */
    public void mo45547b(SparseBooleanArray input, Parcel parcel) {
        parcel.writeSparseBooleanArray(input);
    }
}
