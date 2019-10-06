package p005cm.aptoide.p006pt.account;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.LoginPreferences */
public class LoginPreferences {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Context context;
    private final GoogleApiAvailability googleApiAvailability;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2819363827843744663L, "cm/aptoide/pt/account/LoginPreferences", 5);
        $jacocoData = probes;
        return probes;
    }

    public LoginPreferences(Context context2, GoogleApiAvailability googleApiAvailability2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.googleApiAvailability = googleApiAvailability2;
        $jacocoInit[0] = true;
    }

    public boolean isGoogleLoginEnabled() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.googleApiAvailability.isGooglePlayServicesAvailable(this.context) == 0) {
            $jacocoInit[1] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
        return z;
    }

    public boolean isFacebookLoginEnabled() {
        $jacocoInit()[4] = true;
        return true;
    }
}
