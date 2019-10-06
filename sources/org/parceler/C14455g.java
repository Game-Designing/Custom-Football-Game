package org.parceler;

import android.os.Parcel;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.g */
/* compiled from: NonParcelRepository */
class C14455g extends C14443k<Byte> {
    C14455g() {
    }

    /* renamed from: b */
    public Byte m46079b(Parcel parcel) {
        return Byte.valueOf(parcel.readByte());
    }

    /* renamed from: a */
    public void mo45547b(Byte input, Parcel parcel) {
        parcel.writeByte(input.byteValue());
    }
}
