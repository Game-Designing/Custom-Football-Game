package org.parceler;

import android.os.Parcel;
import org.parceler.NonParcelRepository.SetParcelable;
import org.parceler.p386a.C14438f;

/* renamed from: org.parceler.t */
/* compiled from: NonParcelRepository */
class C14468t extends C14438f {
    C14468t() {
    }

    /* renamed from: b */
    public Object mo45538b(Parcel parcel) {
        return C14377B.m45945a(parcel.readParcelable(SetParcelable.class.getClassLoader()));
    }

    /* renamed from: b */
    public void mo45539b(Object input, Parcel parcel) {
        parcel.writeParcelable(C14377B.m45944a(input), 0);
    }
}
