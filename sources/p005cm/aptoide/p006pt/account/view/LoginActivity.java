package p005cm.aptoide.p006pt.account.view;

import android.content.Intent;
import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;

/* renamed from: cm.aptoide.pt.account.view.LoginActivity */
public class LoginActivity extends LoginBottomSheetActivity {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ACCOUNT_TYPE = "account_type";
    public static final String AUTH_TYPE = "auth_type";
    public static final String IS_ADDING_NEW_ACCOUNT = "is_adding_new_account";
    private String accountType;
    private String authType;
    private boolean isNewAccount;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(414424650675369214L, "cm/aptoide/pt/account/view/LoginActivity", 13);
        $jacocoData = probes;
        return probes;
    }

    public LoginActivity() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        setContentView(getLayoutId());
        $jacocoInit[2] = true;
        loadExtras(getIntent());
        if (savedInstanceState != null) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            String str = this.accountType;
            String str2 = this.authType;
            boolean z = this.isNewAccount;
            $jacocoInit[5] = true;
            LoginSignUpFragment newInstance = LoginSignUpFragment.newInstance(false, true, false, str, str2, z, false);
            $jacocoInit[6] = true;
            fragmentNavigator.navigateToWithoutBackSave(newInstance, true);
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
    }

    private int getLayoutId() {
        $jacocoInit()[9] = true;
        return C1375R.layout.empty_frame;
    }

    private void loadExtras(Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountType = intent.getStringExtra(ACCOUNT_TYPE);
        $jacocoInit[10] = true;
        this.authType = intent.getStringExtra(AUTH_TYPE);
        $jacocoInit[11] = true;
        this.isNewAccount = intent.getBooleanExtra(IS_ADDING_NEW_ACCOUNT, false);
        $jacocoInit[12] = true;
    }
}
