package org.parceler.p386a;

import android.os.Parcel;
import java.util.Collection;
import org.parceler.C14382D;

/* renamed from: org.parceler.a.d */
/* compiled from: CollectionParcelConverter */
public abstract class C14436d<T, C extends Collection<T>> implements C14382D<Collection<T>, C> {
    /* renamed from: a */
    public abstract C mo45534a();

    /* renamed from: b */
    public abstract T mo45538b(Parcel parcel);

    /* renamed from: b */
    public abstract void mo45539b(T t, Parcel parcel);

    /* renamed from: a */
    public void mo45447a(Collection<T> input, Parcel parcel) {
        if (input == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(input.size());
        for (T item : input) {
            mo45539b(item, parcel);
        }
    }

    /* renamed from: a */
    public C m46024a(Parcel parcel) {
        int size = parcel.readInt();
        if (size == -1) {
            return null;
        }
        C list = mo45534a();
        for (int i = 0; i < size; i++) {
            list.add(mo45538b(parcel));
        }
        return list;
    }
}
