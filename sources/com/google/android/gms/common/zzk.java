package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzk extends AbstractSafeParcelable {
    public static final Creator<zzk> CREATOR = new zzl();

    /* renamed from: a */
    private final String f20333a;

    /* renamed from: b */
    private final C8688b f20334b;

    /* renamed from: c */
    private final boolean f20335c;

    /* renamed from: d */
    private final boolean f20336d;

    @Constructor
    zzk(@Param(id = 1) String str, @Param(id = 2) IBinder iBinder, @Param(id = 3) boolean z, @Param(id = 4) boolean z2) {
        this.f20333a = str;
        this.f20334b = m22141a(iBinder);
        this.f20335c = z;
        this.f20336d = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f20333a, false);
        C8688b bVar = this.f20334b;
        if (bVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = bVar.asBinder();
        }
        SafeParcelWriter.m21960a(parcel, 2, iBinder, false);
        SafeParcelWriter.m21968a(parcel, 3, this.f20335c);
        SafeParcelWriter.m21968a(parcel, 4, this.f20336d);
        SafeParcelWriter.m21954a(parcel, a);
    }

    /* renamed from: a */
    private static C8688b m22141a(IBinder iBinder) {
        String str = "Could not unwrap certificate";
        String str2 = "GoogleCertificatesQuery";
        C8689c cVar = null;
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper G = zzj.m22001a(iBinder).mo27651G();
            byte[] bArr = G == null ? null : (byte[]) ObjectWrapper.m22187H(G);
            if (bArr != null) {
                cVar = new C8689c(bArr);
            } else {
                Log.e(str2, str);
            }
            return cVar;
        } catch (RemoteException e) {
            Log.e(str2, str, e);
            return null;
        }
    }
}
