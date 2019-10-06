package p005cm.aptoide.p006pt.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.networking.Authentication */
public class Authentication {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String accessToken;
    private final String email;
    private final String password;
    private final String refreshToken;
    private final String type;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4279485815945299004L, "cm/aptoide/pt/networking/Authentication", 20);
        $jacocoData = probes;
        return probes;
    }

    public Authentication(String email2, String refreshToken2, String accessToken2, String password2, String type2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.email = email2;
        this.refreshToken = refreshToken2;
        this.accessToken = accessToken2;
        this.password = password2;
        this.type = type2;
        $jacocoInit[0] = true;
    }

    public String getEmail() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.email;
        $jacocoInit[1] = true;
        return str;
    }

    public String getRefreshToken() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.refreshToken;
        $jacocoInit[2] = true;
        return str;
    }

    public String getAccessToken() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.accessToken;
        $jacocoInit[3] = true;
        return str;
    }

    public String getPassword() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.password;
        $jacocoInit[4] = true;
        return str;
    }

    public String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[5] = true;
        return str;
    }

    public boolean isAuthenticated() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (isEmpty(this.email)) {
            $jacocoInit[6] = true;
        } else if (isEmpty(this.accessToken)) {
            $jacocoInit[7] = true;
        } else if (isEmpty(this.refreshToken)) {
            $jacocoInit[8] = true;
        } else if (isEmpty(this.password)) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            z = true;
            $jacocoInit[12] = true;
            return z;
        }
        z = false;
        $jacocoInit[11] = true;
        $jacocoInit[12] = true;
        return z;
    }

    private boolean isEmpty(String string) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (string == null) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            String trim = string.trim();
            $jacocoInit[15] = true;
            if (trim.length() == 0) {
                $jacocoInit[16] = true;
            } else {
                z = false;
                $jacocoInit[18] = true;
                $jacocoInit[19] = true;
                return z;
            }
        }
        $jacocoInit[17] = true;
        z = true;
        $jacocoInit[19] = true;
        return z;
    }
}
