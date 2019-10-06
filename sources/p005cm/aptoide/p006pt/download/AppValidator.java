package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb.ObbItem;

/* renamed from: cm.aptoide.pt.download.AppValidator */
public class AppValidator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppValidationAnalytics appValidationAnalytics;

    /* renamed from: cm.aptoide.pt.download.AppValidator$AppValidationResult */
    public enum AppValidationResult {
        INVALID_MD5("Invalid App md5"),
        NO_MAIN_DOWNLOAD_LINK("No main download link provided"),
        NO_ALTERNATIVE_DOWNLOAD_LINK("No alternative download link provided"),
        NO_MAIN_OBB_DOWNLOAD_LINK("No main obb download link provided"),
        NO_PATCH_OBB_DOWNLOAD_LINK("No patch obb download link provided"),
        NO_PACKAGE_NAME_SPECIFIED("This app has an OBB and doesn't have the package name specified"),
        NO_APP_NAME_SPECIFIED("This app has an OBB and doesn't have the App name specified"),
        VALID_APP("This is a valid app");
        
        private final String message;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[10] = true;
        }

        private AppValidationResult(String message2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.message = message2;
            $jacocoInit[2] = true;
        }

        public String getMessage() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.message;
            $jacocoInit[3] = true;
            return str;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6055076541619396418L, "cm/aptoide/pt/download/AppValidator", 33);
        $jacocoData = probes;
        return probes;
    }

    public AppValidator(AppValidationAnalytics appValidationAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appValidationAnalytics = appValidationAnalytics2;
        $jacocoInit[0] = true;
    }

    public AppValidationResult validateApp(String md5, Obb appObb, String packageName, String appName, String filePath, String filePathAlt) {
        boolean[] $jacocoInit = $jacocoInit();
        AppValidationResult result = AppValidationResult.VALID_APP;
        $jacocoInit[1] = true;
        if (!isStringEmptyOrNull(md5)) {
            $jacocoInit[2] = true;
        } else {
            result = AppValidationResult.INVALID_MD5;
            $jacocoInit[3] = true;
        }
        if (isStringEmptyOrNull(filePath)) {
            $jacocoInit[4] = true;
            this.appValidationAnalytics.sendInvalidDownloadMainPath(packageName);
            result = AppValidationResult.NO_MAIN_DOWNLOAD_LINK;
            $jacocoInit[5] = true;
        } else if (isStringEmptyOrNull(filePathAlt)) {
            $jacocoInit[6] = true;
            this.appValidationAnalytics.sendInvalidDownloadAlternativePath(packageName);
            result = AppValidationResult.NO_ALTERNATIVE_DOWNLOAD_LINK;
            $jacocoInit[7] = true;
        } else {
            if (appObb == null) {
                $jacocoInit[8] = true;
            } else if (appObb.getMain() == null) {
                $jacocoInit[9] = true;
            } else {
                ObbItem main = appObb.getMain();
                $jacocoInit[10] = true;
                String path = main.getPath();
                $jacocoInit[11] = true;
                if (!isStringEmptyOrNull(path)) {
                    $jacocoInit[12] = true;
                } else {
                    $jacocoInit[13] = true;
                    this.appValidationAnalytics.sendInvalidDownloadObbMainPath(packageName);
                    result = AppValidationResult.NO_MAIN_OBB_DOWNLOAD_LINK;
                    $jacocoInit[14] = true;
                }
            }
            if (appObb == null) {
                $jacocoInit[15] = true;
            } else if (appObb.getPatch() == null) {
                $jacocoInit[16] = true;
            } else {
                ObbItem patch = appObb.getPatch();
                $jacocoInit[17] = true;
                String path2 = patch.getPath();
                $jacocoInit[18] = true;
                if (!isStringEmptyOrNull(path2)) {
                    $jacocoInit[19] = true;
                } else {
                    $jacocoInit[20] = true;
                    this.appValidationAnalytics.sendInvalidDownloadObbPatchPath(packageName);
                    result = AppValidationResult.NO_PATCH_OBB_DOWNLOAD_LINK;
                    $jacocoInit[21] = true;
                }
            }
            if (appObb == null) {
                $jacocoInit[22] = true;
            } else if (!isStringEmptyOrNull(packageName)) {
                $jacocoInit[23] = true;
            } else {
                result = AppValidationResult.NO_PACKAGE_NAME_SPECIFIED;
                $jacocoInit[24] = true;
            }
            if (!isStringEmptyOrNull(appName)) {
                $jacocoInit[25] = true;
            } else {
                result = AppValidationResult.NO_APP_NAME_SPECIFIED;
                $jacocoInit[26] = true;
            }
        }
        $jacocoInit[27] = true;
        return result;
    }

    private boolean isStringEmptyOrNull(String text) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (text == null) {
            $jacocoInit[28] = true;
        } else if (text.isEmpty()) {
            $jacocoInit[29] = true;
        } else {
            z = false;
            $jacocoInit[31] = true;
            $jacocoInit[32] = true;
            return z;
        }
        $jacocoInit[30] = true;
        z = true;
        $jacocoInit[32] = true;
        return z;
    }
}
