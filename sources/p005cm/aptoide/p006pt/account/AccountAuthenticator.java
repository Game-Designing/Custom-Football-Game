package p005cm.aptoide.p006pt.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.Constants;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0117M;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.account.AccountAuthenticator */
class AccountAuthenticator extends AbstractAccountAuthenticator {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ARG_ACCOUNT_TYPE = "ACCOUNT_TYPE";
    private static final String ARG_AUTH_TYPE = "AUTH_TYPE";
    private static final String ARG_IS_ADDING_NEW_ACCOUNT = "IS_ADDING_ACCOUNT";
    private static final String ARG_OPTIONS_BUNDLE = "BE";
    private static final String AUTHTOKEN_TYPE_FULL_ACCESS = "Full access";
    private static final String AUTHTOKEN_TYPE_FULL_ACCESS_LABEL = "Full access to an Aptoide account";
    private static final String AUTHTOKEN_TYPE_READ_ONLY = "Read only";
    private static final String AUTHTOKEN_TYPE_READ_ONLY_LABEL = "Read only access to an Aptoide account";
    private static final String INVALID_AUTH_TOKEN_TYPE = "invalid authTokenType";
    private static final String TAG = AccountAuthenticator.class.getSimpleName();
    private final AptoideAccountManager accountManager;
    private final AccountManager androidAccountManager;
    private final CrashReport crashReport;
    private final Intent loginActivityBaseIntent;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-771570005706245658L, "cm/aptoide/pt/account/AccountAuthenticator", 47);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[46] = true;
    }

    AccountAuthenticator(Context context, AptoideAccountManager accountManager2, CrashReport crashReport2, AccountManager androidAccountManager2, Intent loginActivityBaseIntent2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        this.accountManager = accountManager2;
        this.crashReport = crashReport2;
        this.androidAccountManager = androidAccountManager2;
        this.loginActivityBaseIntent = loginActivityBaseIntent2;
        $jacocoInit[0] = true;
    }

    public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
        $jacocoInit()[1] = true;
        return null;
    }

    public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Adding account: type=");
        String str2 = accountType;
        sb.append(accountType);
        String sb2 = sb.toString();
        $jacocoInit[2] = true;
        instance.mo2146v(str, sb2);
        $jacocoInit[3] = true;
        Bundle createAuthActivityIntentBundle = createAuthActivityIntentBundle(response, accountType, requiredFeatures, authTokenType, null, options);
        $jacocoInit[4] = true;
        return createAuthActivityIntentBundle;
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options) throws NetworkErrorException {
        $jacocoInit()[5] = true;
        return null;
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        boolean[] $jacocoInit = $jacocoInit();
        if (!authTokenType.equals(AUTHTOKEN_TYPE_FULL_ACCESS)) {
            $jacocoInit[6] = true;
            Bundle result = new Bundle();
            $jacocoInit[7] = true;
            result.putString("errorMessage", INVALID_AUTH_TOKEN_TYPE);
            $jacocoInit[8] = true;
            return result;
        }
        String authToken = this.androidAccountManager.peekAuthToken(account, authTokenType);
        $jacocoInit[9] = true;
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("peekAuthToken returned - ");
        sb.append(account);
        String str2 = " ";
        sb.append(str2);
        sb.append(authToken);
        String sb2 = sb.toString();
        $jacocoInit[10] = true;
        instance.mo2146v(str, sb2);
        $jacocoInit[11] = true;
        Bundle result2 = new Bundle();
        $jacocoInit[12] = true;
        result2.putString("authAccount", account.name);
        $jacocoInit[13] = true;
        result2.putString("accountType", account.type);
        $jacocoInit[14] = true;
        result2.putString("authtoken", authToken);
        $jacocoInit[15] = true;
        Logger instance2 = Logger.getInstance();
        String str3 = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("getAuthToken returning - ");
        sb3.append(account);
        sb3.append(str2);
        sb3.append(authToken);
        String sb4 = sb3.toString();
        $jacocoInit[16] = true;
        instance2.mo2146v(str3, sb4);
        $jacocoInit[17] = true;
        return result2;
    }

    public String getAuthTokenLabel(String authTokenType) {
        boolean[] $jacocoInit = $jacocoInit();
        if (AUTHTOKEN_TYPE_FULL_ACCESS.equals(authTokenType)) {
            $jacocoInit[18] = true;
            return AUTHTOKEN_TYPE_FULL_ACCESS_LABEL;
        } else if (AUTHTOKEN_TYPE_READ_ONLY.equals(authTokenType)) {
            $jacocoInit[19] = true;
            return AUTHTOKEN_TYPE_READ_ONLY_LABEL;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(authTokenType);
            sb.append(" (Label)");
            String sb2 = sb.toString();
            $jacocoInit[20] = true;
            return sb2;
        }
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        $jacocoInit()[21] = true;
        return null;
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features) throws NetworkErrorException {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle result = new Bundle();
        $jacocoInit[22] = true;
        result.putBoolean("booleanResult", false);
        $jacocoInit[23] = true;
        return result;
    }

    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse response, Account account) throws NetworkErrorException {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle result = super.getAccountRemovalAllowed(response, account);
        if (result == null) {
            $jacocoInit[24] = true;
        } else {
            $jacocoInit[25] = true;
            String str = "booleanResult";
            if (!result.containsKey(str)) {
                $jacocoInit[26] = true;
            } else {
                $jacocoInit[27] = true;
                if (result.containsKey(Constants.INTENT_SCHEME)) {
                    $jacocoInit[28] = true;
                } else {
                    $jacocoInit[29] = true;
                    if (!result.getBoolean(str)) {
                        $jacocoInit[30] = true;
                    } else {
                        $jacocoInit[31] = true;
                        C0117M logout = this.accountManager.logout();
                        C1428a aVar = new C1428a(this);
                        $jacocoInit[32] = true;
                        C0117M a = logout.mo3583a((C0129b<? super Throwable>) aVar);
                        $jacocoInit[33] = true;
                        C0117M d = a.mo3602d();
                        $jacocoInit[34] = true;
                        d.mo3603e();
                        $jacocoInit[35] = true;
                    }
                }
            }
        }
        $jacocoInit[36] = true;
        return result;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9570a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[45] = true;
    }

    private Bundle createAuthActivityIntentBundle(AccountAuthenticatorResponse response, String accountType, String[] requiredFeatures, String authTokenType, String password, Bundle options) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = new Bundle();
        $jacocoInit[37] = true;
        Intent intent = createAuthActivityIntent(response, accountType, authTokenType, options);
        $jacocoInit[38] = true;
        bundle.putParcelable(Constants.INTENT_SCHEME, intent);
        $jacocoInit[39] = true;
        return bundle;
    }

    private Intent createAuthActivityIntent(AccountAuthenticatorResponse response, String accountType, String authTokenType, Bundle options) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loginActivityBaseIntent.putExtra(ARG_ACCOUNT_TYPE, accountType);
        $jacocoInit[40] = true;
        this.loginActivityBaseIntent.putExtra(ARG_AUTH_TYPE, authTokenType);
        $jacocoInit[41] = true;
        this.loginActivityBaseIntent.putExtra(ARG_IS_ADDING_NEW_ACCOUNT, true);
        $jacocoInit[42] = true;
        this.loginActivityBaseIntent.putExtra(ARG_OPTIONS_BUNDLE, options);
        $jacocoInit[43] = true;
        this.loginActivityBaseIntent.putExtra("accountAuthenticatorResponse", response);
        Intent intent = this.loginActivityBaseIntent;
        $jacocoInit[44] = true;
        return intent;
    }
}
