package p005cm.aptoide.p006pt.deprecated.tables;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.text.TextUtils;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p005cm.aptoide.p006pt.database.realm.Update;
import p024io.realm.C0106Z;
import p026rx.C0120S;
import p026rx.p398d.C14906b;

/* renamed from: cm.aptoide.pt.deprecated.tables.Updates */
public class Updates extends BaseTable {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String COLUMN_ALT_URL = "alt_url";
    public static final String COLUMN_FILESIZE = "filesize";
    public static final String COLUMN_ICON = "icon";
    public static final String COLUMN_MD5 = "md5";
    public static final String COLUMN_PACKAGE = "package_name";
    public static final String COLUMN_REPO = "repo";
    public static final String COLUMN_SIGNATURE = "signature";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_UPDATE_VERCODE = "update_vercode";
    public static final String COLUMN_UPDATE_VERNAME = "update_vername";
    public static final String COLUMN_URL = "url";
    public static final String COLUMN_VERCODE = "version_code";
    private static final String NAME = "updates";
    private static final String TAG = Updates.class.getSimpleName();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1885666835457187560L, "cm/aptoide/pt/deprecated/tables/Updates", 43);
        $jacocoData = probes;
        return probes;
    }

    public Updates() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[42] = true;
    }

    public String getTableName() {
        $jacocoInit()[1] = true;
        return NAME;
    }

    public C0106Z convert(Cursor cursor, PackageManager packageManager, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = "url";
        String path = cursor.getString(cursor.getColumnIndex(str));
        $jacocoInit[2] = true;
        String str2 = "package_name";
        String packageName = cursor.getString(cursor.getColumnIndex(str2));
        $jacocoInit[3] = true;
        if (TextUtils.isEmpty(path)) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            $jacocoInit[6] = true;
            if (isExcluded(packageName, (UpdateAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) context.getApplicationContext()).getDatabase(), Update.class))) {
                $jacocoInit[7] = true;
            } else {
                try {
                    $jacocoInit[8] = true;
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                    $jacocoInit[9] = true;
                    Update realmObject = new Update();
                    $jacocoInit[10] = true;
                    realmObject.setIcon(cursor.getString(cursor.getColumnIndex("icon")));
                    $jacocoInit[11] = true;
                    realmObject.setMd5(cursor.getString(cursor.getColumnIndex("md5")));
                    $jacocoInit[12] = true;
                    realmObject.setPackageName(cursor.getString(cursor.getColumnIndex(str2)));
                    $jacocoInit[13] = true;
                    realmObject.setAlternativeApkPath(cursor.getString(cursor.getColumnIndex(COLUMN_ALT_URL)));
                    $jacocoInit[14] = true;
                    realmObject.setSize(0);
                    $jacocoInit[15] = true;
                    realmObject.setTimestamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                    String str3 = COLUMN_UPDATE_VERNAME;
                    $jacocoInit[16] = true;
                    String string = cursor.getString(cursor.getColumnIndex(str3));
                    $jacocoInit[17] = true;
                    realmObject.setUpdateVersionName(string);
                    $jacocoInit[18] = true;
                    if (!TextUtils.isEmpty(realmObject.getUpdateVersionName())) {
                        $jacocoInit[19] = true;
                    } else {
                        $jacocoInit[20] = true;
                        realmObject.setUpdateVersionName(packageInfo.versionName);
                        $jacocoInit[21] = true;
                    }
                    realmObject.setApkPath(cursor.getString(cursor.getColumnIndex(str)));
                    $jacocoInit[22] = true;
                    realmObject.setVersionCode(cursor.getInt(cursor.getColumnIndex(COLUMN_VERCODE)));
                    try {
                        $jacocoInit[23] = true;
                        int colIndex = cursor.getColumnIndex(COLUMN_UPDATE_VERCODE);
                        $jacocoInit[24] = true;
                        if (cursor.isNull(colIndex)) {
                            $jacocoInit[25] = true;
                        } else {
                            $jacocoInit[26] = true;
                            int vercode = Integer.valueOf(cursor.getString(colIndex), 10).intValue();
                            $jacocoInit[27] = true;
                            realmObject.setUpdateVersionCode(vercode);
                            $jacocoInit[28] = true;
                        }
                        $jacocoInit[29] = true;
                    } catch (NumberFormatException ex) {
                        $jacocoInit[30] = true;
                        ex.printStackTrace();
                        $jacocoInit[31] = true;
                    }
                    $jacocoInit[32] = true;
                    return realmObject;
                } catch (NameNotFoundException ex2) {
                    $jacocoInit[33] = true;
                    CrashReport instance = CrashReport.getInstance();
                    $jacocoInit[34] = true;
                    instance.log(ex2);
                    $jacocoInit[35] = true;
                }
            }
        }
        $jacocoInit[36] = true;
        return null;
    }

    private boolean isExcluded(String packageName, UpdateAccessor updateAccessor) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = updateAccessor.get(packageName, true);
        $jacocoInit[37] = true;
        C14906b k = s.mo3672k();
        $jacocoInit[38] = true;
        if (k.mo46111a(null) != null) {
            $jacocoInit[39] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[40] = true;
        }
        $jacocoInit[41] = true;
        return z;
    }
}
