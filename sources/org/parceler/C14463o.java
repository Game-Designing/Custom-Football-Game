package org.parceler;

import android.os.Parcel;
import org.parceler.NonParcelRepository.LinkedHashSetParcelable;
import org.parceler.p386a.C14440h;

/* renamed from: org.parceler.o */
/* compiled from: NonParcelRepository */
class C14463o extends C14440h {
    C14463o() {
    }

    /* renamed from: b */
    public Object mo45538b(Parcel parcel) {
        return C14377B.m45945a(parcel.readParcelable(LinkedHashSetParcelable.class.getClassLoader()));
    }

    /* renamed from: b */
    public void mo45539b(Object input, Parcel parcel) {
        parcel.writeParcelable(C14377B.m45944a(input), 0);
    }
}
