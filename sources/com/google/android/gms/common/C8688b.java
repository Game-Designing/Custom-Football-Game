package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.common.b */
abstract class C8688b extends zzj {

    /* renamed from: b */
    private int f19945b;

    protected C8688b(byte[] bArr) {
        Preconditions.m21863a(bArr.length == 25);
        this.f19945b = Arrays.hashCode(bArr);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract byte[] mo27652a();

    public int hashCode() {
        return this.f19945b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzi)) {
            return false;
        }
        try {
            zzi zzi = (zzi) obj;
            if (zzi.mo27654h() != hashCode()) {
                return false;
            }
            IObjectWrapper G = zzi.mo27651G();
            if (G == null) {
                return false;
            }
            return Arrays.equals(mo27652a(), (byte[]) ObjectWrapper.m22187H(G));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    /* renamed from: G */
    public final IObjectWrapper mo27651G() {
        return ObjectWrapper.m22188a(mo27652a());
    }

    /* renamed from: h */
    public final int mo27654h() {
        return hashCode();
    }

    /* renamed from: c */
    protected static byte[] m21692c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
