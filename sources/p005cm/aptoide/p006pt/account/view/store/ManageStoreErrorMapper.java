package p005cm.aptoide.p006pt.account.view.store;

import android.content.res.Resources;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.ErrorsMapper;

/* renamed from: cm.aptoide.pt.account.view.store.ManageStoreErrorMapper */
public class ManageStoreErrorMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ErrorsMapper errorsMapper;
    private final Resources resources;

    /* renamed from: cm.aptoide.pt.account.view.store.ManageStoreErrorMapper$1 */
    static /* synthetic */ class C15231 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$account$view$store$ManageStoreErrorMapper$SocialErrorType */
        static final /* synthetic */ int[] f4462x4bddeb47 = new int[SocialErrorType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-6121861558141667888L, "cm/aptoide/pt/account/view/store/ManageStoreErrorMapper$1", 10);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f4462x4bddeb47[SocialErrorType.INVALID_URL_TEXT.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            $jacocoInit[8] = true;
                        }
                    }
                }
            }
            f4462x4bddeb47[SocialErrorType.LINK_CHANNEL_ERROR.ordinal()] = 2;
            $jacocoInit[3] = true;
            f4462x4bddeb47[SocialErrorType.PAGE_DOES_NOT_EXIST.ordinal()] = 3;
            $jacocoInit[5] = true;
            f4462x4bddeb47[SocialErrorType.GENERIC_ERROR.ordinal()] = 4;
            $jacocoInit[7] = true;
            $jacocoInit[9] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.account.view.store.ManageStoreErrorMapper$SocialErrorType */
    enum SocialErrorType {
        INVALID_URL_TEXT,
        LINK_CHANNEL_ERROR,
        PAGE_DOES_NOT_EXIST,
        GENERIC_ERROR;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8340136850346758460L, "cm/aptoide/pt/account/view/store/ManageStoreErrorMapper", 12);
        $jacocoData = probes;
        return probes;
    }

    public ManageStoreErrorMapper(Resources resources2, ErrorsMapper errorsMapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.resources = resources2;
        this.errorsMapper = errorsMapper2;
        $jacocoInit[0] = true;
    }

    public String getGenericError() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = this.resources.getString(C1375R.string.all_message_general_error);
        $jacocoInit[1] = true;
        return string;
    }

    public String getImageError() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = this.resources.getString(C1375R.string.ws_error_IMAGE_ERROR_1);
        $jacocoInit[2] = true;
        return string;
    }

    public String getInvalidStoreError() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = this.resources.getString(C1375R.string.ws_error_WOP_2);
        $jacocoInit[3] = true;
        return string;
    }

    public String getNetworkError(String errorCode, String applicationPackageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources resources2 = this.resources;
        ErrorsMapper errorsMapper2 = this.errorsMapper;
        $jacocoInit[4] = true;
        int webServiceErrorMessageFromCode = errorsMapper2.getWebServiceErrorMessageFromCode(errorCode, applicationPackageName, resources2);
        $jacocoInit[5] = true;
        String string = resources2.getString(webServiceErrorMessageFromCode);
        $jacocoInit[6] = true;
        return string;
    }

    public String getError(SocialErrorType errorType) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = this.resources.getString(getErrorMessage(errorType));
        $jacocoInit[7] = true;
        return string;
    }

    private int getErrorMessage(SocialErrorType errorType) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C15231.f4462x4bddeb47[errorType.ordinal()];
        if (i == 1) {
            $jacocoInit[8] = true;
            return C1375R.string.edit_store_social_link_invalid_url_text;
        } else if (i == 2) {
            $jacocoInit[9] = true;
            return C1375R.string.edit_store_social_link_channel_error;
        } else if (i != 3) {
            $jacocoInit[11] = true;
            return C1375R.string.all_message_general_error;
        } else {
            $jacocoInit[10] = true;
            return C1375R.string.edit_store_page_doesnt_exist_error_short;
        }
    }
}
