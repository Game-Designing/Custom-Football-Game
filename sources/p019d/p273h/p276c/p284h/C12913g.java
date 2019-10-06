package p019d.p273h.p276c.p284h;

import android.text.TextUtils;
import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.h.g */
/* compiled from: ErrorBuilder */
public class C12913g {
    /* renamed from: d */
    public static C12799b m41927d(String appKey, String userId) {
        StringBuilder sb = new StringBuilder();
        sb.append("Mediation - Unable to retrieve configurations from IronSource server, using cached configurations with appKey:");
        sb.append(appKey);
        sb.append(" and userId:");
        sb.append(userId);
        return new C12799b(502, sb.toString());
    }

    /* renamed from: a */
    public static C12799b m41921a(String credentialName, String credentialValue, String errorMessage) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Init Fail - ");
        sb.append(credentialName);
        sb.append(" value ");
        sb.append(credentialValue);
        sb.append(" is not valid");
        if (!TextUtils.isEmpty(errorMessage)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" - ");
            sb2.append(errorMessage);
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        return new C12799b(506, sb.toString());
    }

    /* renamed from: b */
    public static C12799b m41923b(String errorMsg, String adUnit) {
        String errorMsg2;
        if (TextUtils.isEmpty(errorMsg)) {
            StringBuilder sb = new StringBuilder();
            sb.append(adUnit);
            sb.append(" init failed due to an unknown error");
            errorMsg2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(adUnit);
            sb2.append(" - ");
            sb2.append(errorMsg);
            errorMsg2 = sb2.toString();
        }
        return new C12799b(508, errorMsg2);
    }

    /* renamed from: c */
    public static C12799b m41924c(String adUnit) {
        StringBuilder sb = new StringBuilder();
        sb.append(adUnit);
        sb.append(" Show Fail - No ads to show");
        return new C12799b(509, sb.toString());
    }

    /* renamed from: c */
    public static C12799b m41925c(String adUnit, String error) {
        StringBuilder sb = new StringBuilder();
        sb.append(adUnit);
        sb.append(" Show Fail - ");
        sb.append(error);
        return new C12799b(509, sb.toString());
    }

    /* renamed from: a */
    public static C12799b m41919a(String errorMsg) {
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg = "An error occurred";
        }
        return new C12799b(510, errorMsg);
    }

    /* renamed from: d */
    public static C12799b m41926d(String adUnit) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(adUnit);
        sb.append(" Show Fail - No Internet connection");
        return new C12799b(520, sb.toString());
    }

    /* renamed from: a */
    public static C12799b m41920a(String adUnit, String error) {
        StringBuilder sb = new StringBuilder();
        sb.append(adUnit);
        sb.append(" Show Fail - ");
        sb.append(error);
        return new C12799b(524, sb.toString());
    }

    /* renamed from: e */
    public static C12799b m41928e(String adUnit) {
        StringBuilder sb = new StringBuilder();
        sb.append(adUnit);
        sb.append(" The requested instance does not exist");
        return new C12799b(527, sb.toString());
    }

    /* renamed from: b */
    public static C12799b m41922b(String errorMsg) {
        String errorMsg2;
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg2 = "Load failed due to an unknown error";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Load failed - ");
            sb.append(errorMsg);
            errorMsg2 = sb.toString();
        }
        return new C12799b(510, errorMsg2);
    }

    /* renamed from: f */
    public static C12799b m41929f(String providerName) {
        StringBuilder sb = new StringBuilder();
        sb.append(providerName);
        sb.append(" unsupported banner size");
        return new C12799b(616, sb.toString());
    }
}
