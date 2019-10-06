package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* renamed from: com.paypal.android.sdk.k */
public class C11838k {

    /* renamed from: a */
    private static final String f37250a = C11838k.class.getSimpleName();

    /* renamed from: a */
    private static boolean m39190a(PackageManager packageManager, String str, String str2, String str3, int i) {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        int length = signatureArr.length;
        boolean z = false;
        int i2 = 0;
        while (i2 < length) {
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signatureArr[i2].toByteArray()));
                String name = x509Certificate.getSubjectX500Principal().getName();
                String name2 = x509Certificate.getIssuerX500Principal().getName();
                int hashCode = x509Certificate.getPublicKey().hashCode();
                new StringBuilder("Certificate subject: ").append(name);
                new StringBuilder("Certificate issuer: ").append(name2);
                new StringBuilder("Certificate public key hash code: ").append(hashCode);
                if (str2.equals(name) && str3.equals(name2) && i == hashCode) {
                    z = true;
                }
                return z;
            } catch (CertificateException e) {
                i2++;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo38808a(Context context, boolean z, String str, String str2, String str3, int i) {
        PackageManager packageManager = context.getPackageManager();
        boolean z2 = false;
        try {
            packageManager.getApplicationInfo(str, 4224);
            if (!z || m39190a(packageManager, str, str2, str3, 34172764)) {
                z2 = true;
            }
        } catch (NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" not found.");
        }
        new StringBuilder("returning isValid:").append(z2);
        return z2;
    }
}
