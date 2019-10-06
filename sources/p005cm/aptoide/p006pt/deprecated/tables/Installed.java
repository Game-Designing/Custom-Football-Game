package p005cm.aptoide.p006pt.deprecated.tables;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.text.TextUtils;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p024io.realm.C0106Z;

/* renamed from: cm.aptoide.pt.deprecated.tables.Installed */
public final class Installed extends BaseTable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = Installed.class.getSimpleName();
    private Updates updatesTable = new Updates();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7099802668135052093L, "cm/aptoide/pt/deprecated/tables/Installed", 15);
        $jacocoData = probes;
        return probes;
    }

    public Installed() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[14] = true;
    }

    public String getTableName() {
        boolean[] $jacocoInit = $jacocoInit();
        String tableName = this.updatesTable.getTableName();
        $jacocoInit[2] = true;
        return tableName;
    }

    public C0106Z convert(Cursor cursor, PackageManager packageManager, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        String path = cursor.getString(cursor.getColumnIndex("url"));
        $jacocoInit[3] = true;
        String packageName = cursor.getString(cursor.getColumnIndex("package_name"));
        $jacocoInit[4] = true;
        if (!TextUtils.isEmpty(path)) {
            $jacocoInit[5] = true;
        } else {
            try {
                $jacocoInit[6] = true;
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    $jacocoInit[7] = true;
                    p005cm.aptoide.p006pt.database.realm.Installed installed = new p005cm.aptoide.p006pt.database.realm.Installed(packageInfo, packageManager);
                    $jacocoInit[8] = true;
                    return installed;
                }
                $jacocoInit[9] = true;
            } catch (NameNotFoundException ex) {
                $jacocoInit[10] = true;
                CrashReport instance = CrashReport.getInstance();
                $jacocoInit[11] = true;
                instance.log(ex);
                $jacocoInit[12] = true;
            }
        }
        $jacocoInit[13] = true;
        return null;
    }
}
