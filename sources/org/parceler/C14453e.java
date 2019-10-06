package org.parceler;

import android.os.Parcel;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.e */
/* compiled from: NonParcelRepository */
class C14453e extends C14443k<Boolean> {
    C14453e() {
    }

    /* renamed from: b */
    public Boolean m46071b(Parcel parcel) {
        return Boolean.valueOf(parcel.createBooleanArray()[0]);
    }

    /* renamed from: a */
    public void mo45547b(Boolean input, Parcel parcel) {
        parcel.writeBooleanArray(new boolean[]{input.booleanValue()});
    }
}
