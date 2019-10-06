package p005cm.aptoide.p006pt.account.view;

import android.content.Context;
import android.content.res.Resources;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountException;
import p005cm.aptoide.accountmanager.AccountValidationException;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.ErrorsMapper;
import p005cm.aptoide.p006pt.account.FacebookSignUpException;
import p005cm.aptoide.p006pt.account.GoogleSignUpException;
import p005cm.aptoide.p006pt.dataprovider.util.ErrorUtils;
import p005cm.aptoide.p006pt.view.ThrowableToStringMapper;

/* renamed from: cm.aptoide.pt.account.view.AccountErrorMapper */
public class AccountErrorMapper implements ThrowableToStringMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Context context;
    private final ErrorsMapper errorsMapper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8527746437929804289L, "cm/aptoide/pt/account/view/AccountErrorMapper", 37);
        $jacocoData = probes;
        return probes;
    }

    public AccountErrorMapper(Context context2, ErrorsMapper errorsMapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.errorsMapper = errorsMapper2;
        $jacocoInit[0] = true;
    }

    public String map(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        String message = this.context.getString(C1375R.string.unknown_error);
        if (throwable instanceof GoogleSignUpException) {
            $jacocoInit[1] = true;
            message = this.context.getString(C1375R.string.google_login_cancelled);
            $jacocoInit[2] = true;
        } else if (throwable instanceof FacebookSignUpException) {
            $jacocoInit[3] = true;
            int code = ((FacebookSignUpException) throwable).getCode();
            if (code == 1) {
                message = this.context.getString(C1375R.string.facebook_email_permission_regected_message);
                $jacocoInit[5] = true;
            } else if (code == 2) {
                message = this.context.getString(C1375R.string.facebook_login_cancelled);
                $jacocoInit[6] = true;
            } else if (code != 99) {
                $jacocoInit[4] = true;
            } else {
                message = this.context.getString(C1375R.string.error_occured);
                $jacocoInit[7] = true;
            }
            $jacocoInit[8] = true;
        } else if (throwable instanceof AccountException) {
            $jacocoInit[9] = true;
            if (((AccountException) throwable).hasCode()) {
                Context context2 = this.context;
                ErrorsMapper errorsMapper2 = this.errorsMapper;
                AccountException accountException = (AccountException) throwable;
                $jacocoInit[10] = true;
                String code2 = accountException.getCode();
                Context context3 = this.context;
                $jacocoInit[11] = true;
                Context applicationContext = context3.getApplicationContext();
                $jacocoInit[12] = true;
                String packageName = applicationContext.getPackageName();
                Resources resources = this.context.getResources();
                $jacocoInit[13] = true;
                int webServiceErrorMessageFromCode = errorsMapper2.getWebServiceErrorMessageFromCode(code2, packageName, resources);
                $jacocoInit[14] = true;
                message = context2.getString(webServiceErrorMessageFromCode);
                $jacocoInit[15] = true;
            } else {
                Resources resources2 = this.context.getResources();
                StringBuilder sb = new StringBuilder();
                sb.append("ws_error_");
                AccountException accountException2 = (AccountException) throwable;
                $jacocoInit[16] = true;
                Map errors = accountException2.getErrors();
                $jacocoInit[17] = true;
                Set entrySet = errors.entrySet();
                $jacocoInit[18] = true;
                Iterator it = entrySet.iterator();
                $jacocoInit[19] = true;
                Entry entry = (Entry) it.next();
                $jacocoInit[20] = true;
                String str = (String) entry.getKey();
                $jacocoInit[21] = true;
                sb.append(str.replace("-", "_"));
                String sb2 = sb.toString();
                String packageName2 = this.context.getPackageName();
                $jacocoInit[22] = true;
                int errorId = resources2.getIdentifier(sb2, "string", packageName2);
                $jacocoInit[23] = true;
                message = this.context.getString(errorId);
                $jacocoInit[24] = true;
            }
        } else if (throwable instanceof AccountValidationException) {
            $jacocoInit[25] = true;
            int code3 = ((AccountValidationException) throwable).getCode();
            if (code3 == 1) {
                message = this.context.getString(C1375R.string.no_email_error_message);
                $jacocoInit[28] = true;
            } else if (code3 == 2) {
                message = this.context.getString(C1375R.string.no_pass_error_message);
                $jacocoInit[30] = true;
            } else if (code3 == 3) {
                message = this.context.getString(C1375R.string.no_email_and_pass_error_message);
                $jacocoInit[27] = true;
            } else if (code3 == 4) {
                message = this.context.getString(C1375R.string.password_validation_text);
                $jacocoInit[31] = true;
            } else if (code3 != 5) {
                $jacocoInit[26] = true;
            } else {
                message = this.context.getString(C1375R.string.nothing_inserted_user);
                $jacocoInit[29] = true;
            }
            $jacocoInit[32] = true;
        } else if (!ErrorUtils.isNoNetworkConnection(throwable)) {
            $jacocoInit[33] = true;
        } else {
            $jacocoInit[34] = true;
            message = this.context.getString(C1375R.string.connection_error);
            $jacocoInit[35] = true;
        }
        $jacocoInit[36] = true;
        return message;
    }
}
