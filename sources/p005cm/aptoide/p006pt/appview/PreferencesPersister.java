package p005cm.aptoide.p006pt.appview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.appview.PreferencesPersister */
public class PreferencesPersister {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2347465124405902256L, "cm/aptoide/pt/appview/PreferencesPersister", 9);
        $jacocoData = probes;
        return probes;
    }

    public PreferencesPersister(SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public void save(String key, int value) {
        boolean[] $jacocoInit = $jacocoInit();
        Editor edit = this.sharedPreferences.edit();
        $jacocoInit[1] = true;
        Editor putInt = edit.putInt(key, value);
        $jacocoInit[2] = true;
        putInt.apply();
        $jacocoInit[3] = true;
    }

    public void save(String key, boolean value) {
        boolean[] $jacocoInit = $jacocoInit();
        Editor edit = this.sharedPreferences.edit();
        $jacocoInit[4] = true;
        Editor putBoolean = edit.putBoolean(key, value);
        $jacocoInit[5] = true;
        putBoolean.apply();
        $jacocoInit[6] = true;
    }

    public int get(String key, int defaultValue) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.sharedPreferences.getInt(key, defaultValue);
        $jacocoInit[7] = true;
        return i;
    }

    public boolean get(String key, boolean defaultValue) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.sharedPreferences.getBoolean(key, defaultValue);
        $jacocoInit[8] = true;
        return z;
    }
}
