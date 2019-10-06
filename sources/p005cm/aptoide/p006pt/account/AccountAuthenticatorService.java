package p005cm.aptoide.p006pt.account;

import android.accounts.AccountManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.account.view.LoginActivity;
import p005cm.aptoide.p006pt.crashreports.CrashReport;

/* renamed from: cm.aptoide.pt.account.AccountAuthenticatorService */
public class AccountAuthenticatorService extends Service {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1001908104377157437L, "cm/aptoide/pt/account/AccountAuthenticatorService", 6);
        $jacocoData = probes;
        return probes;
    }

    public AccountAuthenticatorService() {
        $jacocoInit()[0] = true;
    }

    public IBinder onBind(Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        AptoideAccountManager accountManager = ((AptoideApplication) getApplicationContext()).getAccountManager();
        $jacocoInit[2] = true;
        CrashReport instance = CrashReport.getInstance();
        AccountManager accountManager2 = AccountManager.get(getApplicationContext());
        $jacocoInit[3] = true;
        AccountAuthenticator accountAuthenticator = new AccountAuthenticator(this, accountManager, instance, accountManager2, new Intent(getApplicationContext(), LoginActivity.class));
        $jacocoInit[4] = true;
        IBinder iBinder = accountAuthenticator.getIBinder();
        $jacocoInit[5] = true;
        return iBinder;
    }
}
