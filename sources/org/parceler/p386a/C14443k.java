package org.parceler.p386a;

import android.os.Parcel;
import org.parceler.C14473y;

/* renamed from: org.parceler.a.k */
/* compiled from: NullableParcelConverter */
public abstract class C14443k<T> implements C14473y<T> {
    /* renamed from: b */
    public abstract T mo45546b(Parcel parcel);

    /* renamed from: b */
    public abstract void mo45547b(T t, Parcel parcel);

    /* renamed from: a */
    public void mo45447a(T input, Parcel parcel) {
        if (input == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(1);
        mo45547b(input, parcel);
    }

    /* renamed from: a */
    public T mo45446a(Parcel parcel) {
        if (parcel.readInt() == -1) {
            return null;
        }
        return mo45546b(parcel);
    }
}
