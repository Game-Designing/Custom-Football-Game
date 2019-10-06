package p005cm.aptoide.p006pt.util;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.preferences.managed.ManagedKeys;

/* renamed from: cm.aptoide.pt.util.SettingsConstants */
public class SettingsConstants {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final CharSequence ABOUT_DIALOG = "aboutDialog";
    public static final CharSequence ADULT_CHECK_BOX = "matureChkBox";
    public static final CharSequence ADULT_PIN = "Maturepin";
    public static final String ALLOW_ROOT_INSTALLATION = "allowRoot";
    public static final String AUTO_UPDATE_ENABLE = "auto_update";
    public static final CharSequence CHECK_AUTO_UPDATE = ManagedKeys.CHECK_AUTO_UPDATE;
    public static final CharSequence CHECK_AUTO_UPDATE_CATEGORY = "checkautoupdatecategory";
    public static final CharSequence CLEAR_CACHE = "clearcache";
    public static final CharSequence FILTER_APPS = ManagedKeys.HWSPECS_FILTER;
    public static final CharSequence HARDWARE_SPECS = "hwspecs";
    public static final CharSequence MAX_FILE_CACHE = ManagedKeys.MAX_FILE_CACHE;
    public static final CharSequence ROOT = "root";
    public static final CharSequence THEME = "theme";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8572911393426436153L, "cm/aptoide/pt/util/SettingsConstants", 2);
        $jacocoData = probes;
        return probes;
    }

    public SettingsConstants() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
    }
}
