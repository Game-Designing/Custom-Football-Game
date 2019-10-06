package p005cm.aptoide.p006pt.view;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.p001v7.widget.LinearLayoutManager;
import android.view.Window;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.store.StoreTheme;

/* renamed from: cm.aptoide.pt.view.ThemeUtils */
public class ThemeUtils {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1169173297640392189L, "cm/aptoide/pt/view/ThemeUtils", 28);
        $jacocoData = probes;
        return probes;
    }

    public ThemeUtils() {
        $jacocoInit()[0] = true;
    }

    public static void setStatusBarThemeColor(Activity activity, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT < 21) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            StoreTheme storeTheme = StoreTheme.get(theme);
            $jacocoInit[3] = true;
            Window window = activity.getWindow();
            $jacocoInit[4] = true;
            window.addFlags(LinearLayoutManager.INVALID_OFFSET);
            $jacocoInit[5] = true;
            window.clearFlags(67108864);
            $jacocoInit[6] = true;
            Resources resources = activity.getResources();
            $jacocoInit[7] = true;
            int color = resources.getColor(storeTheme.getDarkerColor());
            $jacocoInit[8] = true;
            window.setStatusBarColor(color);
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
    }

    public static void setAptoideTheme(Activity activity, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[11] = true;
        SharedPreferences sPref = ((AptoideApplication) activity.getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[12] = true;
        String str = "theme";
        String string = sPref.getString(str, "light");
        $jacocoInit[13] = true;
        if (string.equals("dark")) {
            $jacocoInit[14] = true;
            Editor edit = sPref.edit();
            $jacocoInit[15] = true;
            Editor putString = edit.putString(str, "default_dark");
            $jacocoInit[16] = true;
            putString.apply();
            $jacocoInit[17] = true;
            activity.setTheme(C1375R.style.AptoideThemeDefaultDark);
            $jacocoInit[18] = true;
        } else {
            Editor edit2 = sPref.edit();
            $jacocoInit[19] = true;
            Editor putString2 = edit2.putString(str, theme);
            $jacocoInit[20] = true;
            putString2.apply();
            $jacocoInit[21] = true;
            StoreTheme storeTheme = StoreTheme.get(theme);
            $jacocoInit[22] = true;
            int themeResource = storeTheme.getThemeResource();
            $jacocoInit[23] = true;
            activity.setTheme(themeResource);
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
    }

    public static void setStoreTheme(Activity activity, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTheme storeTheme = StoreTheme.get(theme);
        $jacocoInit[26] = true;
        activity.setTheme(storeTheme.getThemeResource());
        $jacocoInit[27] = true;
    }
}
