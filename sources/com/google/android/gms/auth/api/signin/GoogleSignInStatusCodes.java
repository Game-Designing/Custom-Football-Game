package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;
import p005cm.aptoide.p006pt.account.AccountAnalytics;

public final class GoogleSignInStatusCodes extends CommonStatusCodes {
    /* renamed from: a */
    public static String m20978a(int i) {
        switch (i) {
            case 12500:
                return "A non-recoverable sign in failure occurred";
            case AccountAnalytics.UNKNOWN_STATUS_CODE /*12501*/:
                return "Sign in action cancelled";
            case 12502:
                return "Sign-in in progress";
            default:
                return CommonStatusCodes.m21125a(i);
        }
    }

    private GoogleSignInStatusCodes() {
    }
}
