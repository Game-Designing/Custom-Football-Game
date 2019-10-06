package p005cm.aptoide.p006pt.orientation;

import android.app.Activity;
import android.view.Display;
import android.view.WindowManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.orientation.ScreenOrientationManager */
public class ScreenOrientationManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Activity activity;
    private final WindowManager windowManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4780859355101055459L, "cm/aptoide/pt/orientation/ScreenOrientationManager", 8);
        $jacocoData = probes;
        return probes;
    }

    public ScreenOrientationManager(Activity activity2, WindowManager windowManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.activity = activity2;
        this.windowManager = windowManager2;
        $jacocoInit[0] = true;
    }

    public void lock() {
        int orientation;
        boolean[] $jacocoInit = $jacocoInit();
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        $jacocoInit[1] = true;
        int rotation = defaultDisplay.getRotation();
        if (rotation == 1) {
            $jacocoInit[3] = true;
            orientation = 0;
        } else if (rotation == 2) {
            orientation = 9;
            $jacocoInit[4] = true;
        } else if (rotation != 3) {
            orientation = 1;
            $jacocoInit[2] = true;
        } else {
            orientation = 8;
            $jacocoInit[5] = true;
        }
        this.activity.setRequestedOrientation(orientation);
        $jacocoInit[6] = true;
    }

    public void unlock() {
        boolean[] $jacocoInit = $jacocoInit();
        this.activity.setRequestedOrientation(-1);
        $jacocoInit[7] = true;
    }
}
