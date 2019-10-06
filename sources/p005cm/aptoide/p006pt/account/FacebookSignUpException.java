package p005cm.aptoide.p006pt.account;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.FacebookSignUpException */
public class FacebookSignUpException extends Exception {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int ERROR = 99;
    public static final int MISSING_REQUIRED_PERMISSIONS = 1;
    public static final int USER_CANCELLED = 2;
    private final int code;
    private final String facebookMessage;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7873921984649299520L, "cm/aptoide/pt/account/FacebookSignUpException", 3);
        $jacocoData = probes;
        return probes;
    }

    public FacebookSignUpException(int code2, String message) {
        boolean[] $jacocoInit = $jacocoInit();
        this.code = code2;
        this.facebookMessage = message;
        $jacocoInit[0] = true;
    }

    public String getFacebookMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.facebookMessage;
        $jacocoInit[1] = true;
        return str;
    }

    public int getCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.code;
        $jacocoInit[2] = true;
        return i;
    }
}
