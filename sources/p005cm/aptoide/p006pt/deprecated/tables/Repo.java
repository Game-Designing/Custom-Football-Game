package p005cm.aptoide.p006pt.deprecated.tables;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Store;
import p024io.realm.C0106Z;

/* renamed from: cm.aptoide.pt.deprecated.tables.Repo */
public class Repo extends BaseTable {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String COLUMN_APK_PATH = "apk_path";
    public static final String COLUMN_AVATAR = "avatar_url";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DOWNLOADS = "downloads";
    public static final String COLUMN_FAILED = "is_failed";
    public static final String COLUMN_FEATURED_GRAPHIC_PATH = "featured_graphic_path";
    public static final String COLUMN_HASH = "hash";
    public static final String COLUMN_ICONS_PATH = "icons_path";
    public static final String COLUMN_ID = "id_repo";
    public static final String COLUMN_IS_USER = "is_user";
    public static final String COLUMN_ITEMS = "items";
    public static final String COLUMN_LATEST_TIMESTAMP = "latest_timestamp";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_REPO_NAME = "reponame";
    public static final String COLUMN_THEME = "theme";
    public static final String COLUMN_TOP_TIMESTAMP = "top_timestamp";
    public static final String COLUMN_URL = "url";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_VIEW = "list";
    public static final String COLUMN_WEBSERVICES_PATH = "webservices_path";
    private static final String NAME = "repo";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8330307553949209592L, "cm/aptoide/pt/deprecated/tables/Repo", 10);
        $jacocoData = probes;
        return probes;
    }

    public Repo() {
        $jacocoInit()[0] = true;
    }

    public String getTableName() {
        $jacocoInit()[1] = true;
        return "repo";
    }

    public C0106Z convert(Cursor cursor, PackageManager packageManager, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        Store realmObject = new Store();
        $jacocoInit[2] = true;
        realmObject.setStoreId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
        $jacocoInit[3] = true;
        realmObject.setDownloads(cursor.getLong(cursor.getColumnIndex("downloads")));
        $jacocoInit[4] = true;
        realmObject.setStoreName(cursor.getString(cursor.getColumnIndex("name")));
        $jacocoInit[5] = true;
        realmObject.setIconPath(cursor.getString(cursor.getColumnIndex(COLUMN_ICONS_PATH)));
        $jacocoInit[6] = true;
        realmObject.setPasswordSha1(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
        $jacocoInit[7] = true;
        realmObject.setUsername(cursor.getString(cursor.getColumnIndex("username")));
        $jacocoInit[8] = true;
        realmObject.setTheme(cursor.getString(cursor.getColumnIndex("theme")));
        $jacocoInit[9] = true;
        return realmObject;
    }
}
