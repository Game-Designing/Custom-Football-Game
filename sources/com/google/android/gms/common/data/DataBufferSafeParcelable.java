package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {

    /* renamed from: b */
    private static final String[] f19965b = {"data"};

    /* renamed from: c */
    private final Creator<T> f19966c;

    @KeepForSdk
    public T get(int i) {
        DataHolder dataHolder = this.f19952a;
        byte[] a = dataHolder.mo27667a("data", i, dataHolder.mo27665a(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(a, 0, a.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.f19966c.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
