package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
@KeepForSdk
public class GoogleSignatureVerifier {

    /* renamed from: a */
    private static GoogleSignatureVerifier f19530a;

    /* renamed from: b */
    private final Context f19531b;

    private GoogleSignatureVerifier(Context context) {
        this.f19531b = context.getApplicationContext();
    }

    @KeepForSdk
    /* renamed from: a */
    public static GoogleSignatureVerifier m21098a(Context context) {
        Preconditions.m21857a(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (f19530a == null) {
                C8629a.m21107a(context);
                f19530a = new GoogleSignatureVerifier(context);
            }
        }
        return f19530a;
    }

    /* renamed from: a */
    public static boolean m21100a(PackageInfo packageInfo, boolean z) {
        C8688b bVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                bVar = m21099a(packageInfo, C8693e.f19987a);
            } else {
                bVar = m21099a(packageInfo, C8693e.f19987a[0]);
            }
            if (bVar != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    /* renamed from: a */
    public boolean mo27316a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m21100a(packageInfo, false)) {
            return true;
        }
        if (m21100a(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f19531b)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    /* renamed from: a */
    private static C8688b m21099a(PackageInfo packageInfo, C8688b... bVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C8689c cVar = new C8689c(signatureArr[0].toByteArray());
        for (int i = 0; i < bVarArr.length; i++) {
            if (bVarArr[i].equals(cVar)) {
                return bVarArr[i];
            }
        }
        return null;
    }
}
