package org.parceler;

import android.os.Parcel;
import org.parceler.NonParcelRepository.SparseArrayParcelable;
import org.parceler.p386a.C14444l;

/* renamed from: org.parceler.u */
/* compiled from: NonParcelRepository */
class C14469u extends C14444l {
    C14469u() {
    }

    /* renamed from: b */
    public Object mo45549b(Parcel parcel) {
        return C14377B.m45945a(parcel.readParcelable(SparseArrayParcelable.class.getClassLoader()));
    }

    /* renamed from: b */
    public void mo45550b(Object input, Parcel parcel) {
        parcel.writeParcelable(C14377B.m45944a(input), 0);
    }
}
