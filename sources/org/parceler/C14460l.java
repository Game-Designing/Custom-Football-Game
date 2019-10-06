package org.parceler;

import android.os.IBinder;
import android.os.Parcel;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.l */
/* compiled from: NonParcelRepository */
class C14460l extends C14443k<IBinder> {
    C14460l() {
    }

    /* renamed from: b */
    public IBinder m46097b(Parcel parcel) {
        return parcel.readStrongBinder();
    }

    /* renamed from: a */
    public void mo45547b(IBinder input, Parcel parcel) {
        parcel.writeStrongBinder(input);
    }
}
