package p005cm.aptoide.p006pt.account;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.GoogleSignUpException */
public class GoogleSignUpException extends Exception {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String error;
    private final int statusCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8536003646615255126L, "cm/aptoide/pt/account/GoogleSignUpException", 3);
        $jacocoData = probes;
        return probes;
    }

    public GoogleSignUpException(String error2, int statusCode2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.error = error2;
        this.statusCode = statusCode2;
        $jacocoInit[0] = true;
    }

    public int getStatusCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.statusCode;
        $jacocoInit[1] = true;
        return i;
    }

    public String getError() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.error;
        $jacocoInit[2] = true;
        return str;
    }
}
