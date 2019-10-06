package p005cm.aptoide.p006pt.deprecated;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.Accessor;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.deprecated.tables.Downloads;
import p005cm.aptoide.p006pt.deprecated.tables.Excluded;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.preferences.secure.SecurePreferences;
import p005cm.aptoide.p006pt.preferences.secure.SecurePreferencesImplementation;

/* renamed from: cm.aptoide.pt.deprecated.SQLiteDatabaseHelper */
public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String DATABASE_NAME = "aptoide.db";
    public static final int DATABASE_VERSION = 60;
    public static int OLD_DATABASE_VERSION;
    private static final String TAG = SQLiteDatabaseHelper.class.getSimpleName();
    private Throwable aggregateExceptions;
    private final Context context;
    private PackageManager packageManager;
    private SharedPreferences securePreferences;
    private SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-627577294967853123L, "cm/aptoide/pt/deprecated/SQLiteDatabaseHelper", 55);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[54] = true;
    }

    public SQLiteDatabaseHelper(Context context2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context2, DATABASE_NAME, null, 60);
        this.context = context2;
        $jacocoInit[0] = true;
        this.sharedPreferences = ((AptoideApplication) context2.getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[1] = true;
        this.securePreferences = SecurePreferencesImplementation.getInstance(context2.getApplicationContext(), this.sharedPreferences);
        $jacocoInit[2] = true;
    }

    public void onCreate(SQLiteDatabase db) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[3] = true;
        instance.mo2148w(str, "onCreate() called");
        $jacocoInit[4] = true;
        this.packageManager = this.context.getPackageManager();
        $jacocoInit[5] = true;
        ManagerPreferences.setNeedsSqliteDbMigration(false, this.sharedPreferences);
        $jacocoInit[6] = true;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onUpgrade() called with: oldVersion = [");
        sb.append(oldVersion);
        sb.append("], newVersion = [");
        sb.append(newVersion);
        sb.append("]");
        String sb2 = sb.toString();
        $jacocoInit[7] = true;
        instance.mo2148w(str, sb2);
        OLD_DATABASE_VERSION = oldVersion;
        $jacocoInit[8] = true;
        migrate(db);
        $jacocoInit[9] = true;
        ManagerPreferences.setNeedsSqliteDbMigration(false, this.sharedPreferences);
        $jacocoInit[10] = true;
        SecurePreferences.setWizardAvailable(true, this.securePreferences);
        $jacocoInit[11] = true;
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDowngrade(db, oldVersion, newVersion);
        $jacocoInit[12] = true;
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onDowngrade() called with: oldVersion = [");
        sb.append(oldVersion);
        sb.append("], newVersion = [");
        sb.append(newVersion);
        sb.append("]");
        String sb2 = sb.toString();
        $jacocoInit[13] = true;
        instance.mo2148w(str, sb2);
        $jacocoInit[14] = true;
        migrate(db);
        $jacocoInit[15] = true;
        ManagerPreferences.setNeedsSqliteDbMigration(false, this.sharedPreferences);
        $jacocoInit[16] = true;
    }

    private void migrate(SQLiteDatabase db) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!ManagerPreferences.needsSqliteDbMigration(this.sharedPreferences)) {
            $jacocoInit[17] = true;
            return;
        }
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[18] = true;
        instance.mo2148w(str, "Migrating database started....");
        try {
            $jacocoInit[19] = true;
            Repo repo = new Repo();
            Context context2 = this.context;
            $jacocoInit[20] = true;
            Context applicationContext = context2.getApplicationContext();
            $jacocoInit[21] = true;
            $jacocoInit[22] = true;
            Accessor accessorFor = AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class);
            PackageManager packageManager2 = this.packageManager;
            Context context3 = this.context;
            $jacocoInit[23] = true;
            Context applicationContext2 = context3.getApplicationContext();
            $jacocoInit[24] = true;
            repo.migrate(db, accessorFor, packageManager2, applicationContext2);
            $jacocoInit[25] = true;
        } catch (Exception ex) {
            $jacocoInit[26] = true;
            logException(ex);
            try {
                $jacocoInit[27] = true;
            } catch (Exception ex2) {
                $jacocoInit[34] = true;
                logException(ex2);
                try {
                    $jacocoInit[35] = true;
                } catch (Exception ex3) {
                    $jacocoInit[40] = true;
                    logException(ex3);
                    $jacocoInit[41] = true;
                }
            }
        }
        Excluded excluded = new Excluded();
        Context context4 = this.context;
        $jacocoInit[28] = true;
        Context applicationContext3 = context4.getApplicationContext();
        $jacocoInit[29] = true;
        $jacocoInit[30] = true;
        Accessor accessorFor2 = AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext3.getApplicationContext()).getDatabase(), Update.class);
        PackageManager packageManager3 = this.packageManager;
        Context context5 = this.context;
        $jacocoInit[31] = true;
        Context applicationContext4 = context5.getApplicationContext();
        $jacocoInit[32] = true;
        excluded.migrate(db, accessorFor2, packageManager3, applicationContext4);
        $jacocoInit[33] = true;
        Downloads downloads = new Downloads();
        Context context6 = this.context;
        $jacocoInit[36] = true;
        Context applicationContext5 = context6.getApplicationContext();
        $jacocoInit[37] = true;
        $jacocoInit[38] = true;
        downloads.migrate((DownloadAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext5.getApplicationContext()).getDatabase(), Download.class));
        $jacocoInit[39] = true;
        if (this.aggregateExceptions == null) {
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            CrashReport instance2 = CrashReport.getInstance();
            Throwable th = this.aggregateExceptions;
            $jacocoInit[44] = true;
            instance2.log(th);
            $jacocoInit[45] = true;
        }
        Logger instance3 = Logger.getInstance();
        String str2 = TAG;
        $jacocoInit[46] = true;
        instance3.mo2148w(str2, "Migrating database finished.");
        $jacocoInit[47] = true;
    }

    private void logException(Exception ex) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[48] = true;
        instance.log(ex);
        if (this.aggregateExceptions == null) {
            this.aggregateExceptions = ex;
            $jacocoInit[49] = true;
        } else if (VERSION.SDK_INT < 19) {
            $jacocoInit[50] = true;
        } else {
            $jacocoInit[51] = true;
            $jacocoInit[52] = true;
        }
        $jacocoInit[53] = true;
    }
}
