package org.parceler;

import android.os.Parcel;
import org.parceler.NonParcelRepository.LinkedListParcelable;
import org.parceler.p386a.C14441i;

/* renamed from: org.parceler.p */
/* compiled from: NonParcelRepository */
class C14464p extends C14441i {
    C14464p() {
    }

    /* renamed from: b */
    public Object mo45538b(Parcel parcel) {
        return C14377B.m45945a(parcel.readParcelable(LinkedListParcelable.class.getClassLoader()));
    }

    /* renamed from: b */
    public void mo45539b(Object input, Parcel parcel) {
        parcel.writeParcelable(C14377B.m45944a(input), 0);
    }
}
