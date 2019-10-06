package p005cm.aptoide.p006pt.account;

import com.facebook.FacebookException;
import com.facebook.login.C6748D;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.FacebookLoginResult */
public class FacebookLoginResult {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int STATE_CANCELLED = 1;
    public static final int STATE_ERROR = 99;
    public static final int STATE_SUCCESS = 0;
    private final FacebookException error;
    private final C6748D result;
    private final int state;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7820172374873955975L, "cm/aptoide/pt/account/FacebookLoginResult", 4);
        $jacocoData = probes;
        return probes;
    }

    public FacebookLoginResult(C6748D result2, int state2, FacebookException error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.result = result2;
        this.state = state2;
        this.error = error2;
        $jacocoInit[0] = true;
    }

    public C6748D getResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C6748D d = this.result;
        $jacocoInit[1] = true;
        return d;
    }

    public int getState() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.state;
        $jacocoInit[2] = true;
        return i;
    }

    public FacebookException getError() {
        boolean[] $jacocoInit = $jacocoInit();
        FacebookException facebookException = this.error;
        $jacocoInit[3] = true;
        return facebookException;
    }
}
