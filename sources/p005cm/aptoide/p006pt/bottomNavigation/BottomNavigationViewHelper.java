package p005cm.aptoide.p006pt.bottomNavigation;

import android.annotation.SuppressLint;
import android.support.design.internal.C0215a;
import android.support.design.internal.C0218d;
import android.support.design.widget.BottomNavigationView;
import android.support.p001v7.view.menu.C0879p;
import android.util.Log;
import java.lang.reflect.Field;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.bottomNavigation.BottomNavigationViewHelper */
public class BottomNavigationViewHelper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2374458081693890569L, "cm/aptoide/pt/bottomNavigation/BottomNavigationViewHelper", 20);
        $jacocoData = probes;
        return probes;
    }

    public BottomNavigationViewHelper() {
        $jacocoInit()[0] = true;
    }

    @SuppressLint({"RestrictedApi"})
    public static void disableShiftMode(BottomNavigationView view) {
        String str = "BNVHelper";
        boolean[] $jacocoInit = $jacocoInit();
        C0218d menuView = (C0218d) view.getChildAt(0);
        try {
            $jacocoInit[1] = true;
            try {
                $jacocoInit[2] = true;
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                $jacocoInit[3] = true;
                shiftingMode.setAccessible(true);
                $jacocoInit[4] = true;
                shiftingMode.setBoolean(menuView, false);
                $jacocoInit[5] = true;
                shiftingMode.setAccessible(false);
                $jacocoInit[6] = true;
                $jacocoInit[7] = true;
                int i = 0;
                while (i < menuView.getChildCount()) {
                    $jacocoInit[8] = true;
                    C0215a item = (C0215a) menuView.getChildAt(i);
                    $jacocoInit[9] = true;
                    item.setShiftingMode(false);
                    $jacocoInit[10] = true;
                    C0879p itemData = item.getItemData();
                    $jacocoInit[11] = true;
                    boolean isChecked = itemData.isChecked();
                    $jacocoInit[12] = true;
                    item.setChecked(isChecked);
                    i++;
                    $jacocoInit[13] = true;
                }
                $jacocoInit[14] = true;
            } catch (NoSuchFieldException e) {
                e = e;
                $jacocoInit[15] = true;
                Log.e(str, "Unable to get shift mode field", e);
                $jacocoInit[16] = true;
                $jacocoInit[19] = true;
            } catch (IllegalAccessException e2) {
                e = e2;
                $jacocoInit[17] = true;
                Log.e(str, "Unable to change value of shift mode", e);
                $jacocoInit[18] = true;
                $jacocoInit[19] = true;
            }
        } catch (NoSuchFieldException e3) {
            e = e3;
            $jacocoInit[15] = true;
            Log.e(str, "Unable to get shift mode field", e);
            $jacocoInit[16] = true;
            $jacocoInit[19] = true;
        } catch (IllegalAccessException e4) {
            e = e4;
            $jacocoInit[17] = true;
            Log.e(str, "Unable to change value of shift mode", e);
            $jacocoInit[18] = true;
            $jacocoInit[19] = true;
        }
        $jacocoInit[19] = true;
    }
}
