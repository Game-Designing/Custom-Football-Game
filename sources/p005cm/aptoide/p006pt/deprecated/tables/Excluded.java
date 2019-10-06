package p005cm.aptoide.p006pt.deprecated.tables;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.utils.AptoideUtils.IconSizeU;
import p024io.realm.C0106Z;

/* renamed from: cm.aptoide.pt.deprecated.tables.Excluded */
public class Excluded extends BaseTable {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String COLUMN_ICONPATH = "iconpath";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PACKAGE_NAME = "package_name";
    public static final String COLUMN_VERCODE = "vercode";
    public static final String COLUMN_VERNAME = "version_name";
    private static final String NAME = "excluded";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5172825138961192743L, "cm/aptoide/pt/deprecated/tables/Excluded", 11);
        $jacocoData = probes;
        return probes;
    }

    public Excluded() {
        $jacocoInit()[0] = true;
    }

    public String getTableName() {
        $jacocoInit()[1] = true;
        return "excluded";
    }

    public C0106Z convert(Cursor cursor, PackageManager packageManager, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        Update realmObject = new Update();
        $jacocoInit[2] = true;
        realmObject.setPackageName(cursor.getString(cursor.getColumnIndex("package_name")));
        $jacocoInit[3] = true;
        realmObject.setLabel(cursor.getString(cursor.getColumnIndex("name")));
        $jacocoInit[4] = true;
        realmObject.setVersionCode(cursor.getInt(cursor.getColumnIndex(COLUMN_VERCODE)));
        $jacocoInit[5] = true;
        realmObject.setUpdateVersionName(cursor.getString(cursor.getColumnIndex(COLUMN_VERNAME)));
        $jacocoInit[6] = true;
        realmObject.setExcluded(true);
        $jacocoInit[7] = true;
        String string = cursor.getString(cursor.getColumnIndex(COLUMN_ICONPATH));
        $jacocoInit[8] = true;
        String cleanIconPath = IconSizeU.cleanImageUrl(string);
        $jacocoInit[9] = true;
        realmObject.setIcon(cleanIconPath);
        $jacocoInit[10] = true;
        return realmObject;
    }
}
