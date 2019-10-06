package p005cm.aptoide.p006pt.util;

import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.logger.Logger;

/* renamed from: cm.aptoide.pt.util.ScreenTrackingUtils */
public class ScreenTrackingUtils {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final String LIFE_CYCLE_STATE = "LIFE_CYCLE_STATE";
    static final String NUMBER_OF_SCREENS = "NUMBER_OF_SCREENS";
    static final String NUMBER_OF_SCREENS_ON_BACK_STACK = "NUMBER_OF_SCREENS_ON_BACK_STACK";
    static final String SCREEN_HISTORY = "SCREEN_HISTORY";
    private static final String TAG = ScreenTrackingUtils.class.getSimpleName();
    private int MAX_HISTORY;
    private ArrayList<String> history;
    private int numberScreensOnBackStack;
    private int totalNumberScreens;

    /* renamed from: cm.aptoide.pt.util.ScreenTrackingUtils$1 */
    static /* synthetic */ class C51611 {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(5864235215576239415L, "cm/aptoide/pt/util/ScreenTrackingUtils$1", 0);
            $jacocoData = probes;
            return probes;
        }
    }

    /* renamed from: cm.aptoide.pt.util.ScreenTrackingUtils$LifeCycle */
    public enum LifeCycle {
        CREATE,
        DESTROY;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.util.ScreenTrackingUtils$ScreenUtilsHelper */
    private static class ScreenUtilsHelper {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private static final ScreenTrackingUtils INSTANCE = new ScreenTrackingUtils(null);

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(1107348487267283419L, "cm/aptoide/pt/util/ScreenTrackingUtils$ScreenUtilsHelper", 3);
            $jacocoData = probes;
            return probes;
        }

        private ScreenUtilsHelper() {
            $jacocoInit()[0] = true;
        }

        static /* synthetic */ ScreenTrackingUtils access$000() {
            boolean[] $jacocoInit = $jacocoInit();
            ScreenTrackingUtils screenTrackingUtils = INSTANCE;
            $jacocoInit[1] = true;
            return screenTrackingUtils;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[2] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3941335356682539358L, "cm/aptoide/pt/util/ScreenTrackingUtils", 29);
        $jacocoData = probes;
        return probes;
    }

    /* synthetic */ ScreenTrackingUtils(C51611 x0) {
        boolean[] $jacocoInit = $jacocoInit();
        this();
        $jacocoInit[27] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[28] = true;
    }

    private ScreenTrackingUtils() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.history = new ArrayList<>();
        this.MAX_HISTORY = 10;
        this.totalNumberScreens = 0;
        this.numberScreensOnBackStack = 0;
        $jacocoInit[1] = true;
    }

    public static ScreenTrackingUtils getInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        ScreenTrackingUtils access$000 = ScreenUtilsHelper.access$000();
        $jacocoInit[2] = true;
        return access$000;
    }

    public void addScreenToHistory(String screenName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.history.size() < this.MAX_HISTORY) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            this.history.remove(0);
            $jacocoInit[5] = true;
        }
        this.history.add(screenName);
        $jacocoInit[6] = true;
        CrashReport instance = CrashReport.getInstance();
        ArrayList<String> arrayList = this.history;
        $jacocoInit[7] = true;
        instance.log(SCREEN_HISTORY, arrayList.toString());
        $jacocoInit[8] = true;
        Logger instance2 = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("addScreenToHistory: ");
        ArrayList<String> arrayList2 = this.history;
        $jacocoInit[9] = true;
        sb.append(arrayList2.toString());
        instance2.mo2136d(str, sb.toString());
        $jacocoInit[10] = true;
    }

    public void incrementNumberOfScreens() {
        boolean[] $jacocoInit = $jacocoInit();
        this.totalNumberScreens++;
        this.numberScreensOnBackStack++;
        $jacocoInit[11] = true;
        CrashReport instance = CrashReport.getInstance();
        int i = this.totalNumberScreens;
        $jacocoInit[12] = true;
        instance.log(NUMBER_OF_SCREENS, String.valueOf(i));
        $jacocoInit[13] = true;
        CrashReport instance2 = CrashReport.getInstance();
        int i2 = this.numberScreensOnBackStack;
        $jacocoInit[14] = true;
        instance2.log(NUMBER_OF_SCREENS_ON_BACK_STACK, String.valueOf(i2));
        $jacocoInit[15] = true;
        CrashReport instance3 = CrashReport.getInstance();
        LifeCycle lifeCycle = LifeCycle.CREATE;
        $jacocoInit[16] = true;
        instance3.log(LIFE_CYCLE_STATE, lifeCycle.toString());
        $jacocoInit[17] = true;
        Logger instance4 = Logger.getInstance();
        String str = TAG;
        $jacocoInit[18] = true;
        instance4.mo2136d(str, "incrementNumberOfScreens: NOS: NUMBER_OF_SCREENS, NOSOBS: NUMBER_OF_SCREENS_ON_BACK_STACK");
        $jacocoInit[19] = true;
    }

    public void decrementNumberOfScreens() {
        boolean[] $jacocoInit = $jacocoInit();
        this.numberScreensOnBackStack--;
        $jacocoInit[20] = true;
        CrashReport instance = CrashReport.getInstance();
        int i = this.numberScreensOnBackStack;
        $jacocoInit[21] = true;
        instance.log(NUMBER_OF_SCREENS_ON_BACK_STACK, String.valueOf(i));
        $jacocoInit[22] = true;
        CrashReport instance2 = CrashReport.getInstance();
        LifeCycle lifeCycle = LifeCycle.DESTROY;
        $jacocoInit[23] = true;
        instance2.log(LIFE_CYCLE_STATE, lifeCycle.toString());
        $jacocoInit[24] = true;
        Logger instance3 = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("decrementNumberOfScreens: NOSOBS: ");
        int i2 = this.numberScreensOnBackStack;
        $jacocoInit[25] = true;
        sb.append(String.valueOf(i2));
        instance3.mo2136d(str, sb.toString());
        $jacocoInit[26] = true;
    }
}
