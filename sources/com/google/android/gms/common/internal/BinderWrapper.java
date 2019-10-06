package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
@KeepForSdk
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new C8708i();

    /* renamed from: a */
    private IBinder f20049a;

    public BinderWrapper() {
        this.f20049a = null;
    }

    private BinderWrapper(Parcel parcel) {
        this.f20049a = null;
        this.f20049a = parcel.readStrongBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f20049a);
    }

    /* synthetic */ BinderWrapper(Parcel parcel, C8708i iVar) {
        this(parcel);
    }
}
