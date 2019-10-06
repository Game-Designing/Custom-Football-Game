package org.parceler;

import android.os.Parcel;
import org.parceler.NonParcelRepository.TreeSetParcelable;
import org.parceler.p386a.C14446n;

/* renamed from: org.parceler.x */
/* compiled from: NonParcelRepository */
class C14472x extends C14446n {
    C14472x() {
    }

    /* renamed from: b */
    public Object mo45538b(Parcel parcel) {
        return C14377B.m45945a(parcel.readParcelable(TreeSetParcelable.class.getClassLoader()));
    }

    /* renamed from: b */
    public void mo45539b(Object input, Parcel parcel) {
        parcel.writeParcelable(C14377B.m45944a(input), 0);
    }
}
