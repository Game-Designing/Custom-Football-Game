package p005cm.aptoide.p006pt.account.view.user;

import android.content.Context;
import android.content.res.Resources;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AccountValidationException;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.AccountErrorMapper;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.ThrowableToStringMapper;

/* renamed from: cm.aptoide.pt.account.view.user.CreateUserErrorMapper */
public class CreateUserErrorMapper implements ThrowableToStringMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AccountErrorMapper accountErrorMapper;
    private final Context context;
    private Resources resources;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6470051777716422889L, "cm/aptoide/pt/account/view/user/CreateUserErrorMapper", 10);
        $jacocoData = probes;
        return probes;
    }

    public CreateUserErrorMapper(Context context2, AccountErrorMapper accountErrorMapper2, Resources resources2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.accountErrorMapper = accountErrorMapper2;
        this.resources = resources2;
        $jacocoInit[0] = true;
    }

    public String map(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        String message = this.accountErrorMapper.map(throwable);
        if (throwable instanceof SocketTimeoutException) {
            $jacocoInit[1] = true;
        } else if (throwable instanceof TimeoutException) {
            $jacocoInit[2] = true;
        } else {
            if (!(throwable instanceof AccountValidationException)) {
                $jacocoInit[4] = true;
            } else {
                $jacocoInit[5] = true;
                int code = ((AccountValidationException) throwable).getCode();
                if (code == 5) {
                    message = StringU.getResString(C1375R.string.no_username_inserted, this.resources);
                    $jacocoInit[7] = true;
                } else if (code != 6) {
                    $jacocoInit[6] = true;
                } else {
                    message = StringU.getResString(C1375R.string.nothing_inserted_user, this.resources);
                    $jacocoInit[8] = true;
                }
            }
            $jacocoInit[9] = true;
            return message;
        }
        message = this.context.getString(C1375R.string.user_upload_photo_failed);
        $jacocoInit[3] = true;
        $jacocoInit[9] = true;
        return message;
    }
}
