package p005cm.aptoide.p006pt.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.deprecated.SQLiteDatabaseHelper;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.preferences.secure.SecureCoderDecoder;
import p026rx.C0117M;
import p026rx.C0126V;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0131o;

/* renamed from: cm.aptoide.pt.account.AndroidAccountDataMigration */
public class AndroidAccountDataMigration {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String[] MIGRATION_KEYS = {AndroidAccountManagerPersistence.ACCOUNT_ID, "username", AndroidAccountManagerPersistence.ACCOUNT_AVATAR_URL, AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN, "access_token", AuthenticationPersistence.ACCOUNT_TYPE, AndroidAccountManagerPersistence.ACCOUNT_STORE_NAME, AndroidAccountManagerPersistence.ACCOUNT_ACCESS_LEVEL};
    private static final Object MIGRATION_LOCK = new Object();
    private static final String[] NEW_STORE_MIGRATION_KEYS = {AndroidAccountManagerPersistence.ACCOUNT_STORE_AVATAR_URL, "account_store_download_count", "account_store_id", "account_store_theme", "account_store_username", "account_store_password"};
    private static final String TAG = AndroidAccountDataMigration.class.getName();
    private final AccountManager accountManager;
    private final String accountType;
    private final String applicationVersionName;
    private final int currentVersion;
    private final String databasePath;
    private final SharedPreferences defaultSharedPreferences;
    private int oldVersion = -1;
    private final C0126V scheduler;
    private final SecureCoderDecoder secureCoderDecoder;
    private final SharedPreferences secureSharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3046101184528372474L, "cm/aptoide/pt/account/AndroidAccountDataMigration", Opcodes.D2L);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[141] = true;
        $jacocoInit[142] = true;
    }

    public AndroidAccountDataMigration(SharedPreferences secureSharedPreferences2, SharedPreferences defaultSharedPreferences2, AccountManager accountManager2, SecureCoderDecoder secureCoderDecoder2, int currentVersion2, String databasePath2, String accountType2, String applicationVersionName2, C0126V scheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.secureSharedPreferences = secureSharedPreferences2;
        this.defaultSharedPreferences = defaultSharedPreferences2;
        this.accountManager = accountManager2;
        this.secureCoderDecoder = secureCoderDecoder2;
        this.currentVersion = currentVersion2;
        this.databasePath = databasePath2;
        this.accountType = accountType2;
        this.applicationVersionName = applicationVersionName2;
        this.scheduler = scheduler2;
        $jacocoInit[0] = true;
    }

    public C0117M migrate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C1405C<Object>(this));
        C0126V v = this.scheduler;
        $jacocoInit[1] = true;
        C0117M b = a.mo3593b(v);
        $jacocoInit[2] = true;
        return b;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    public /* synthetic */ C0117M mo9586b() {
        boolean[] $jacocoInit = $jacocoInit();
        if (isMigrated()) {
            $jacocoInit[127] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[128] = true;
            return b;
        }
        synchronized (MIGRATION_LOCK) {
            try {
                $jacocoInit[129] = true;
                generateOldVersion();
                $jacocoInit[130] = true;
                if (!isMigrated()) {
                    $jacocoInit[131] = true;
                    Log.i(TAG, String.format("Migrating from version %d to %d", new Object[]{Integer.valueOf(this.oldVersion), Integer.valueOf(this.currentVersion)}));
                    $jacocoInit[134] = true;
                    C0117M a = migrateAccountFromPreviousThan43().mo3580a(migrateAccountFrom43to59());
                    $jacocoInit[135] = true;
                    C0117M a2 = a.mo3580a(migrateAccountFromVersion59To60());
                    $jacocoInit[136] = true;
                    C0117M a3 = a2.mo3580a(cleanShareDialogShowPref());
                    C1637x xVar = new C1637x(this);
                    $jacocoInit[137] = true;
                    C0117M a4 = a3.mo3582a((C0128a) xVar);
                    $jacocoInit[138] = true;
                    return a4;
                }
                $jacocoInit[132] = true;
                C0117M b2 = C0117M.m590b();
                $jacocoInit[133] = true;
                return b2;
            } catch (Throwable th) {
                while (true) {
                    $jacocoInit[139] = true;
                    throw th;
                }
            }
        }
    }

    /* renamed from: f */
    public /* synthetic */ void mo9590f() {
        boolean[] $jacocoInit = $jacocoInit();
        markMigrated();
        $jacocoInit[140] = true;
    }

    private C0117M cleanShareDialogShowPref() {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferences sharedPreferences = this.defaultSharedPreferences;
        $jacocoInit[3] = true;
        String oldVersionName = ManagerPreferences.getPreviewDialogPrefVersionCleaned(sharedPreferences);
        $jacocoInit[4] = true;
        if (oldVersionName.equals(this.applicationVersionName)) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            if (getMajorIntFromVersionName(oldVersionName) >= getMajorIntFromVersionName(this.applicationVersionName)) {
                $jacocoInit[7] = true;
            } else {
                $jacocoInit[8] = true;
                C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C1638y<Object>(this));
                $jacocoInit[9] = true;
                return a;
            }
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[10] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9585a() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m584a((Callable<?>) new C1636w<Object>(this));
        $jacocoInit[123] = true;
        return a;
    }

    /* renamed from: g */
    public /* synthetic */ Object mo9591g() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        ManagerPreferences.setShowPreviewDialog(true, this.defaultSharedPreferences);
        $jacocoInit[124] = true;
        ManagerPreferences.setPreviewDialogPrefVersionCleaned(this.applicationVersionName, this.defaultSharedPreferences);
        $jacocoInit[125] = true;
        C0117M b = C0117M.m590b();
        $jacocoInit[126] = true;
        return b;
    }

    private int getMajorIntFromVersionName(String versionName) {
        boolean[] $jacocoInit = $jacocoInit();
        int res = 0;
        if (versionName == null) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            String[] parts = versionName.split("\\.");
            if (parts == null) {
                $jacocoInit[13] = true;
            } else if (parts.length <= 1) {
                $jacocoInit[14] = true;
            } else {
                try {
                    $jacocoInit[15] = true;
                    res = Integer.parseInt(parts[1]);
                    $jacocoInit[16] = true;
                } catch (Exception e) {
                    $jacocoInit[17] = true;
                }
            }
        }
        $jacocoInit[18] = true;
        return res;
    }

    private boolean isMigrated() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.oldVersion == this.currentVersion) {
            $jacocoInit[19] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[20] = true;
        }
        $jacocoInit[21] = true;
        return z;
    }

    private C0117M migrateAccountFromPreviousThan43() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.oldVersion < 43) {
            $jacocoInit[22] = true;
            Log.w(TAG, "migrateAccountFromPreviousThan43");
            $jacocoInit[23] = true;
            C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C1402A<Object>(this));
            $jacocoInit[24] = true;
            return a;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[25] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo9588d() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m584a((Callable<?>) new C1408F<Object>(this));
        $jacocoInit[93] = true;
        return a;
    }

    /* renamed from: h */
    public /* synthetic */ Object mo9592h() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        Log.i(TAG, "migrating from v7");
        $jacocoInit[94] = true;
        Account oldAccount = this.accountManager.getAccountsByType(this.accountType)[0];
        String[] strArr = MIGRATION_KEYS;
        int length = strArr.length;
        $jacocoInit[95] = true;
        int i = 0;
        while (i < length) {
            String key = strArr[i];
            $jacocoInit[96] = true;
            String sharedPrefsData = this.defaultSharedPreferences.getString(key, null);
            $jacocoInit[97] = true;
            if (TextUtils.isEmpty(sharedPrefsData)) {
                $jacocoInit[98] = true;
            } else {
                $jacocoInit[99] = true;
                this.accountManager.setUserData(oldAccount, key, sharedPrefsData);
                $jacocoInit[100] = true;
            }
            i++;
            $jacocoInit[101] = true;
        }
        String[] strArr2 = MIGRATION_KEYS;
        int length2 = strArr2.length;
        $jacocoInit[102] = true;
        int i2 = 0;
        while (i2 < length2) {
            String key2 = strArr2[i2];
            $jacocoInit[103] = true;
            String sharedPrefsData2 = this.secureSharedPreferences.getString(key2, null);
            $jacocoInit[104] = true;
            if (TextUtils.isEmpty(sharedPrefsData2)) {
                $jacocoInit[105] = true;
            } else {
                $jacocoInit[106] = true;
                this.accountManager.setUserData(oldAccount, key2, sharedPrefsData2);
                $jacocoInit[107] = true;
            }
            i2++;
            $jacocoInit[108] = true;
        }
        String refreshToken = this.accountManager.blockingGetAuthToken(oldAccount, "Full access", false);
        $jacocoInit[109] = true;
        if (TextUtils.isEmpty(refreshToken)) {
            $jacocoInit[110] = true;
        } else {
            $jacocoInit[111] = true;
            this.accountManager.setUserData(oldAccount, AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN, refreshToken);
            $jacocoInit[112] = true;
        }
        String matureSwitchKey = AndroidAccountManagerPersistence.ACCOUNT_ADULT_CONTENT_ENABLED;
        $jacocoInit[113] = true;
        String sharedPrefsData3 = this.defaultSharedPreferences.getString(matureSwitchKey, AdultContentAnalytics.UNLOCK);
        $jacocoInit[114] = true;
        this.accountManager.setUserData(oldAccount, matureSwitchKey, sharedPrefsData3);
        String accountManagerLoginModeKeyNew = AuthenticationPersistence.ACCOUNT_TYPE;
        $jacocoInit[115] = true;
        String sharedPrefsData4 = this.defaultSharedPreferences.getString("loginType", "");
        $jacocoInit[116] = true;
        if (sharedPrefsData4.isEmpty()) {
            $jacocoInit[117] = true;
        } else {
            $jacocoInit[118] = true;
            this.accountManager.setUserData(oldAccount, accountManagerLoginModeKeyNew, sharedPrefsData4);
            $jacocoInit[119] = true;
        }
        cleanKeysFromPreferences(MIGRATION_KEYS, this.defaultSharedPreferences);
        $jacocoInit[120] = true;
        cleanKeysFromPreferences(MIGRATION_KEYS, this.secureSharedPreferences);
        $jacocoInit[121] = true;
        C0117M b = C0117M.m590b();
        $jacocoInit[122] = true;
        return b;
    }

    private C0117M migrateAccountFrom43to59() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.oldVersion;
        if (i < 43) {
            $jacocoInit[26] = true;
        } else if (i >= 59) {
            $jacocoInit[27] = true;
        } else {
            $jacocoInit[28] = true;
            Log.w(TAG, "migrateAccountFrom43to59");
            $jacocoInit[29] = true;
            C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C1404B<Object>(this));
            $jacocoInit[30] = true;
            return a;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[31] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo9587c() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m584a((Callable<?>) new C1407E<Object>(this));
        $jacocoInit[61] = true;
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086 A[LOOP:0: B:17:0x0084->B:18:0x0086, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00fb  */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.lang.Object mo9593i() throws java.lang.Exception {
        /*
            r13 = this;
            boolean[] r0 = $jacocoInit()
            android.accounts.AccountManager r1 = r13.accountManager
            java.lang.String r2 = r13.accountType
            android.accounts.Account[] r1 = r1.getAccountsByType(r2)
            r2 = 1
            r3 = 62
            r0[r3] = r2
            java.lang.String[] r3 = MIGRATION_KEYS
            android.content.SharedPreferences r4 = r13.secureSharedPreferences
            boolean r3 = r13.accountHasKeysForMigration(r3, r4)
            if (r3 != 0) goto L_0x0020
            r3 = 63
            r0[r3] = r2
            goto L_0x0027
        L_0x0020:
            int r3 = r1.length
            if (r3 != 0) goto L_0x0042
            r3 = 64
            r0[r3] = r2
        L_0x0027:
            java.lang.String r3 = TAG
            java.lang.String r4 = "Account migration from <8.1.2.1 to >8.2.0.0 failed. the required keys were not available."
            android.util.Log.e(r3, r4)
            r3 = 65
            r0[r3] = r2
            r13.markMigrated()
            r3 = 66
            r0[r3] = r2
            rx.M r3 = p026rx.C0117M.m590b()
            r4 = 67
            r0[r4] = r2
            return r3
        L_0x0042:
            r3 = 0
            r4 = r1[r3]
            r5 = 68
            r0[r5] = r2
            android.accounts.AccountManager r5 = r13.accountManager
            java.lang.String r5 = r5.getPassword(r4)
            r6 = 69
            r0[r6] = r2
            cm.aptoide.pt.preferences.secure.SecureCoderDecoder r6 = r13.secureCoderDecoder
            java.lang.String r6 = r6.decrypt(r5)
            r7 = 70
            r0[r7] = r2
            int r7 = r13.oldVersion
            r8 = 55
            if (r7 > r8) goto L_0x0068
            r7 = 71
            r0[r7] = r2
            goto L_0x0077
        L_0x0068:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0073
            r7 = 72
            r0[r7] = r2
            goto L_0x007c
        L_0x0073:
            r7 = 73
            r0[r7] = r2
        L_0x0077:
            r6 = r5
            r7 = 74
            r0[r7] = r2
        L_0x007c:
            java.lang.String[] r7 = MIGRATION_KEYS
            int r8 = r7.length
            r9 = 75
            r0[r9] = r2
            r9 = 0
        L_0x0084:
            if (r9 >= r8) goto L_0x00a3
            r10 = r7[r9]
            r11 = 76
            r0[r11] = r2
            android.content.SharedPreferences r11 = r13.secureSharedPreferences
            r12 = 0
            java.lang.String r11 = r11.getString(r10, r12)
            r12 = 77
            r0[r12] = r2
            android.accounts.AccountManager r12 = r13.accountManager
            r12.setUserData(r4, r10, r11)
            int r9 = r9 + 1
            r10 = 78
            r0[r10] = r2
            goto L_0x0084
        L_0x00a3:
            java.lang.String r7 = "aptoide_account_manager_mature_switch"
            r8 = 79
            r0[r8] = r2
            android.content.SharedPreferences r8 = r13.secureSharedPreferences
            java.lang.String r9 = "false"
            java.lang.String r8 = r8.getString(r7, r9)
            r9 = 80
            r0[r9] = r2
            android.accounts.AccountManager r9 = r13.accountManager
            r9.setUserData(r4, r7, r8)
            java.lang.String r9 = "access_confirmed"
            android.content.SharedPreferences r10 = r13.defaultSharedPreferences
            r11 = 81
            r0[r11] = r2
            boolean r3 = r10.getBoolean(r9, r3)
            java.lang.String r3 = java.lang.Boolean.toString(r3)
            r8 = 82
            r0[r8] = r2
            android.accounts.AccountManager r8 = r13.accountManager
            r8.setUserData(r4, r9, r3)
            r8 = 83
            r0[r8] = r2
            android.accounts.AccountManager r8 = r13.accountManager
            r8.setPassword(r4, r6)
            java.lang.String r8 = "loginType"
            java.lang.String r10 = "aptoide_account_manager_login_mode"
            r11 = 84
            r0[r11] = r2
            android.content.SharedPreferences r11 = r13.defaultSharedPreferences
            java.lang.String r12 = ""
            java.lang.String r3 = r11.getString(r8, r12)
            r11 = 85
            r0[r11] = r2
            boolean r11 = r3.isEmpty()
            if (r11 == 0) goto L_0x00fb
            r11 = 86
            r0[r11] = r2
            goto L_0x0108
        L_0x00fb:
            r11 = 87
            r0[r11] = r2
            android.accounts.AccountManager r11 = r13.accountManager
            r11.setUserData(r4, r10, r3)
            r11 = 88
            r0[r11] = r2
        L_0x0108:
            java.lang.String[] r11 = MIGRATION_KEYS
            android.content.SharedPreferences r12 = r13.defaultSharedPreferences
            r13.cleanKeysFromPreferences(r11, r12)
            r11 = 89
            r0[r11] = r2
            java.lang.String[] r11 = MIGRATION_KEYS
            android.content.SharedPreferences r12 = r13.secureSharedPreferences
            r13.cleanKeysFromPreferences(r11, r12)
            r11 = 90
            r0[r11] = r2
            java.lang.String r11 = TAG
            java.lang.String r12 = "Account migration from <8.1.2.1 to >8.2.0.0 succeeded"
            android.util.Log.i(r11, r12)
            r11 = 91
            r0[r11] = r2
            rx.M r11 = p026rx.C0117M.m590b()
            r12 = 92
            r0[r12] = r2
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.AndroidAccountDataMigration.mo9593i():java.lang.Object");
    }

    private C0117M migrateAccountFromVersion59To60() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.oldVersion < 60) {
            $jacocoInit[32] = true;
            Log.w(TAG, "migrateAccountFromVersion59To60");
            $jacocoInit[33] = true;
            C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C1406D<Object>(this));
            $jacocoInit[34] = true;
            return a;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[35] = true;
        return b;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo9589e() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m584a((Callable<?>) new C1639z<Object>(this));
        $jacocoInit[52] = true;
        return a;
    }

    /* renamed from: j */
    public /* synthetic */ Object mo9594j() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        Account oldAccount = this.accountManager.getAccountsByType(this.accountType)[0];
        String[] strArr = NEW_STORE_MIGRATION_KEYS;
        int length = strArr.length;
        $jacocoInit[53] = true;
        while (i < length) {
            String key = strArr[i];
            $jacocoInit[54] = true;
            if (key.equals("account_store_download_count")) {
                $jacocoInit[55] = true;
            } else if (key.equals("account_store_id")) {
                $jacocoInit[56] = true;
            } else {
                this.accountManager.setUserData(oldAccount, key, "");
                $jacocoInit[58] = true;
                i++;
                $jacocoInit[59] = true;
            }
            this.accountManager.setUserData(oldAccount, key, BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
            $jacocoInit[57] = true;
            i++;
            $jacocoInit[59] = true;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[60] = true;
        return b;
    }

    private void cleanKeysFromPreferences(String[] migrationKeys, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[36] = true;
        while (i < migrationKeys.length) {
            $jacocoInit[37] = true;
            if (!sharedPreferences.contains(migrationKeys[i])) {
                $jacocoInit[38] = true;
            } else {
                $jacocoInit[39] = true;
                Editor edit = sharedPreferences.edit();
                String str = migrationKeys[i];
                $jacocoInit[40] = true;
                Editor remove = edit.remove(str);
                $jacocoInit[41] = true;
                remove.commit();
                $jacocoInit[42] = true;
            }
            i++;
            $jacocoInit[43] = true;
        }
        $jacocoInit[44] = true;
    }

    private void markMigrated() {
        boolean[] $jacocoInit = $jacocoInit();
        this.oldVersion = this.currentVersion;
        $jacocoInit[45] = true;
    }

    private boolean accountHasKeysForMigration(String[] migrationKeys, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[46] = true;
        while (i < migrationKeys.length) {
            $jacocoInit[47] = true;
            if (sharedPreferences.contains(migrationKeys[i])) {
                $jacocoInit[48] = true;
                return true;
            }
            i++;
            $jacocoInit[49] = true;
        }
        $jacocoInit[50] = true;
        return false;
    }

    private void generateOldVersion() {
        boolean[] $jacocoInit = $jacocoInit();
        this.oldVersion = SQLiteDatabaseHelper.OLD_DATABASE_VERSION;
        $jacocoInit[51] = true;
    }
}
