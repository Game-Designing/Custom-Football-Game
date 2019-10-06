package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;

/* renamed from: com.facebook.internal.u */
/* compiled from: FacebookSignatureValidator */
public class C6733u {

    /* renamed from: a */
    private static final HashSet<String> f12306a = m13563a();

    /* renamed from: a */
    private static HashSet<String> m13563a() {
        HashSet<String> set = new HashSet<>();
        set.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
        set.add("cc2751449a350f668590264ed76692694a80308a");
        set.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
        set.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
        set.add("df6b721c8b4d3b6eb44c861d4415007e5a35fc95");
        set.add("9b8f518b086098de3d77736f9458a3d2f6f95a37");
        set.add("2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3");
        return set;
    }

    /* renamed from: a */
    public static boolean m13564a(Context context, String packageName) {
        String brand = Build.BRAND;
        int applicationFlags = context.getApplicationInfo().flags;
        if (brand.startsWith("generic") && (applicationFlags & 2) != 0) {
            return true;
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                if (!f12306a.contains(C6694S.m13406a(signature.toByteArray()))) {
                    return false;
                }
            }
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
