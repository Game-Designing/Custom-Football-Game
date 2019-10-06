package p005cm.aptoide.p006pt.toolbox;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.widget.Toast;
import java.util.Locale;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.accountmanager.Store;
import p005cm.aptoide.p006pt.ApplicationComponent;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.account.AndroidAccountManagerPersistence;
import p005cm.aptoide.p006pt.account.FacebookSignUpAdapter;
import p005cm.aptoide.p006pt.account.GoogleSignUpAdapter;
import p005cm.aptoide.p006pt.deprecated.tables.Updates;
import p005cm.aptoide.p006pt.networking.Authentication;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p398d.C14906b;
import p026rx.p401g.C14959b;

/* renamed from: cm.aptoide.pt.toolbox.ToolboxContentProvider */
public class ToolboxContentProvider extends ContentProvider {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String BACKUP_PACKAGE = "pt.aptoide.backupapps";
    private static final int CHANGE_PREFERENCE = 6;
    private static final int LOGIN_NAME = 5;
    private static final int LOGIN_TYPE = 4;
    private static final int PASSHASH = 3;
    private static final int REFRESH_TOKEN = 7;
    private static final int REPO = 2;
    private static final int TOKEN = 1;
    private static final String UPLOADER_PACKAGE = "pt.caixamagica.aptoide.uploader";
    @Inject
    AptoideAccountManager accountManager;
    @Inject
    AuthenticationPersistence authenticationPersistence;
    private ToolboxSecurityManager securityManager;
    @Inject
    SharedPreferences sharedPreferences;
    private UriMatcher uriMatcher;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5295500045728161409L, "cm/aptoide/pt/toolbox/ToolboxContentProvider", Opcodes.ISHL);
        $jacocoData = probes;
        return probes;
    }

    public ToolboxContentProvider() {
        $jacocoInit()[0] = true;
    }

    public boolean onCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        this.securityManager = new ToolboxSecurityManager(getContext().getPackageManager());
        $jacocoInit[1] = true;
        this.uriMatcher = new UriMatcher(-1);
        $jacocoInit[2] = true;
        UriMatcher uriMatcher2 = this.uriMatcher;
        String str = BuildConfig.CONTENT_AUTHORITY;
        uriMatcher2.addURI(str, "token", 1);
        $jacocoInit[3] = true;
        this.uriMatcher.addURI(str, "refreshToken", 7);
        $jacocoInit[4] = true;
        this.uriMatcher.addURI(str, Updates.COLUMN_REPO, 2);
        $jacocoInit[5] = true;
        this.uriMatcher.addURI(str, "loginType", 4);
        $jacocoInit[6] = true;
        this.uriMatcher.addURI(str, "passHash", 3);
        $jacocoInit[7] = true;
        this.uriMatcher.addURI(str, "loginName", 5);
        $jacocoInit[8] = true;
        this.uriMatcher.addURI(str, "changePreference", 6);
        $jacocoInit[9] = true;
        ApplicationComponent applicationComponent = ((AptoideApplication) getContext().getApplicationContext()).getApplicationComponent();
        $jacocoInit[10] = true;
        applicationComponent.inject(this);
        $jacocoInit[11] = true;
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.securityManager.checkSignature(Binder.getCallingUid(), BuildConfig.SIGNATURE_BACKUP, BACKUP_PACKAGE)) {
            $jacocoInit[12] = true;
        } else {
            ToolboxSecurityManager toolboxSecurityManager = this.securityManager;
            $jacocoInit[13] = true;
            if (toolboxSecurityManager.checkSignature(Binder.getCallingUid(), BuildConfig.SIGNATURE_UPLOADER, UPLOADER_PACKAGE)) {
                $jacocoInit[14] = true;
            } else {
                SecurityException securityException = new SecurityException("Package not authorized to access provider.");
                $jacocoInit[43] = true;
                throw securityException;
            }
        }
        Single authentication = this.authenticationPersistence.getAuthentication();
        $jacocoInit[15] = true;
        Single f = authentication.mo3700f(null);
        $jacocoInit[16] = true;
        C14959b a = f.mo3689a();
        $jacocoInit[17] = true;
        Authentication authentication2 = (Authentication) a.mo46175a();
        $jacocoInit[18] = true;
        C0120S accountStatus = this.accountManager.accountStatus();
        $jacocoInit[19] = true;
        C14906b k = accountStatus.mo3672k();
        $jacocoInit[20] = true;
        Account account = (Account) k.mo46110a();
        if (authentication2 == null) {
            $jacocoInit[21] = true;
        } else if (account != null) {
            int match = this.uriMatcher.match(uri);
            if (match == 1) {
                MatrixCursor create = create("userToken", authentication2.getAccessToken());
                $jacocoInit[25] = true;
                return create;
            } else if (match != 2) {
                if (match == 3) {
                    String str = "userPass";
                    if (AptoideAccountManager.APTOIDE_SIGN_UP_TYPE.equals(authentication2.getType())) {
                        $jacocoInit[30] = true;
                        String computeSha1 = AlgorithmU.computeSha1(authentication2.getPassword());
                        $jacocoInit[31] = true;
                        MatrixCursor create2 = create(str, computeSha1);
                        $jacocoInit[32] = true;
                        return create2;
                    }
                    if (FacebookSignUpAdapter.TYPE.equals(authentication2.getType())) {
                        $jacocoInit[33] = true;
                    } else {
                        $jacocoInit[34] = true;
                        if (!GoogleSignUpAdapter.TYPE.equals(authentication2.getType())) {
                            $jacocoInit[35] = true;
                        } else {
                            $jacocoInit[36] = true;
                        }
                    }
                    MatrixCursor create3 = create(str, authentication2.getPassword());
                    $jacocoInit[37] = true;
                    return create3;
                } else if (match == 4) {
                    $jacocoInit[24] = true;
                } else if (match == 5) {
                    MatrixCursor create4 = create("loginName", authentication2.getEmail());
                    $jacocoInit[41] = true;
                    return create4;
                } else if (match == 7) {
                    MatrixCursor create5 = create("userRefreshToken", authentication2.getRefreshToken());
                    $jacocoInit[26] = true;
                    return create5;
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Only /token, /repo, /passHash, /loginType and /loginName supported.");
                    $jacocoInit[42] = true;
                    throw illegalArgumentException;
                }
                String type = authentication2.getType();
                Locale locale = Locale.US;
                $jacocoInit[38] = true;
                String lowerCase = type.toLowerCase(locale);
                $jacocoInit[39] = true;
                MatrixCursor create6 = create("loginType", lowerCase);
                $jacocoInit[40] = true;
                return create6;
            } else {
                Store store = account.getStore();
                $jacocoInit[27] = true;
                String name = store.getName();
                $jacocoInit[28] = true;
                MatrixCursor create7 = create(AndroidAccountManagerPersistence.ACCOUNT_STORE_NAME, name);
                $jacocoInit[29] = true;
                return create7;
            }
        } else {
            $jacocoInit[22] = true;
        }
        IllegalStateException illegalStateException = new IllegalStateException("User not logged in.");
        $jacocoInit[23] = true;
        throw illegalStateException;
    }

    public String getType(Uri uri) {
        $jacocoInit()[44] = true;
        return null;
    }

    public Uri insert(Uri uri, ContentValues values) {
        $jacocoInit()[45] = true;
        return null;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        $jacocoInit()[46] = true;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x025a A[Catch:{ NullPointerException -> 0x029b }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x025f A[Catch:{ NullPointerException -> 0x029b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(android.net.Uri r18, android.content.ContentValues r19, java.lang.String r20, java.lang.String[] r21) {
        /*
            r17 = this;
            r1 = r17
            boolean[] r2 = $jacocoInit()
            r0 = 47
            r3 = 0
            r4 = 1
            r2[r0] = r4     // Catch:{ NullPointerException -> 0x02a9 }
            r5 = r3
            int r0 = android.os.Binder.getCallingUid()     // Catch:{ NullPointerException -> 0x02a5 }
            r6 = 48
            r2[r6] = r4     // Catch:{ NullPointerException -> 0x02a5 }
            android.content.Context r6 = r17.getContext()     // Catch:{ NullPointerException -> 0x02a5 }
            r7 = 49
            r2[r7] = r4     // Catch:{ NullPointerException -> 0x02a5 }
            android.content.pm.PackageManager r7 = r6.getPackageManager()     // Catch:{ NullPointerException -> 0x02a5 }
            r8 = 50
            r2[r8] = r4     // Catch:{ NullPointerException -> 0x02a5 }
            java.lang.String[] r8 = r7.getPackagesForUid(r0)     // Catch:{ NullPointerException -> 0x02a5 }
            r3 = r8[r3]     // Catch:{ NullPointerException -> 0x02a5 }
            r8 = 51
            r2[r8] = r4     // Catch:{ NullPointerException -> 0x02a5 }
            java.lang.String r8 = "AptoideDebug"
            java.lang.String r9 = "Someone is trying to update preferences"
            android.util.Log.d(r8, r9)     // Catch:{ NullPointerException -> 0x02a5 }
            r8 = 52
            r2[r8] = r4     // Catch:{ NullPointerException -> 0x02a5 }
            java.lang.String r8 = r6.getPackageName()     // Catch:{ NullPointerException -> 0x02a5 }
            int r8 = r7.checkSignatures(r3, r8)     // Catch:{ NullPointerException -> 0x02a5 }
            if (r8 != 0) goto L_0x029d
            r9 = 53
            r2[r9] = r4     // Catch:{ NullPointerException -> 0x02a5 }
            android.content.UriMatcher r9 = r1.uriMatcher     // Catch:{ NullPointerException -> 0x02a5 }
            r10 = r18
            int r9 = r9.match(r10)     // Catch:{ NullPointerException -> 0x029b }
            r11 = 6
            if (r9 == r11) goto L_0x005c
            r9 = 54
            r2[r9] = r4     // Catch:{ NullPointerException -> 0x029b }
            r9 = 108(0x6c, float:1.51E-43)
            r2[r9] = r4
            return r5
        L_0x005c:
            android.content.SharedPreferences r9 = r1.sharedPreferences     // Catch:{ NullPointerException -> 0x029b }
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ NullPointerException -> 0x029b }
            r11 = 55
            r2[r11] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.util.Set r11 = r19.valueSet()     // Catch:{ NullPointerException -> 0x029b }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ NullPointerException -> 0x029b }
            r12 = 56
            r2[r12] = r4     // Catch:{ NullPointerException -> 0x029b }
        L_0x0072:
            boolean r12 = r11.hasNext()     // Catch:{ NullPointerException -> 0x029b }
            if (r12 == 0) goto L_0x0292
            java.lang.Object r12 = r11.next()     // Catch:{ NullPointerException -> 0x029b }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ NullPointerException -> 0x029b }
            r13 = 57
            r2[r13] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Object r13 = r12.getValue()     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r13 instanceof java.lang.String     // Catch:{ NullPointerException -> 0x029b }
            if (r14 == 0) goto L_0x0170
            r14 = 58
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            android.content.SharedPreferences r14 = r1.sharedPreferences     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.isDebug(r14)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 == 0) goto L_0x009b
            r14 = 59
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            goto L_0x00ab
        L_0x009b:
            r14 = 60
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            cm.aptoide.pt.toolbox.a r14 = new cm.aptoide.pt.toolbox.a     // Catch:{ NullPointerException -> 0x029b }
            r14.<init>(r6)     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.utils.AptoideUtils.ThreadU.runOnUiThread(r14)     // Catch:{ NullPointerException -> 0x029b }
            r14 = 61
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
        L_0x00ab:
            java.lang.Object r14 = r12.getKey()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "forcecountry"
            r16 = 62
            r2[r16] = r4     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.equals(r15)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 == 0) goto L_0x00d2
            r14 = 63
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = r13
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            android.content.SharedPreferences r15 = r1.sharedPreferences     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.setForceCountry(r14, r15)     // Catch:{ NullPointerException -> 0x029b }
            int r5 = r5 + 1
            r14 = 64
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = 1
            goto L_0x0258
        L_0x00d2:
            java.lang.Object r14 = r12.getKey()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "notificationtype"
            r16 = 65
            r2[r16] = r4     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.equals(r15)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 == 0) goto L_0x00f9
            r14 = 66
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = r13
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            android.content.SharedPreferences r15 = r1.sharedPreferences     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.setNotificationType(r14, r15)     // Catch:{ NullPointerException -> 0x029b }
            int r5 = r5 + 1
            r14 = 67
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = 1
            goto L_0x0258
        L_0x00f9:
            java.lang.Object r14 = r12.getKey()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "pullNotificationAction"
            r16 = 68
            r2[r16] = r4     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.equals(r15)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 == 0) goto L_0x0133
            r14 = 69
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            android.content.Intent r14 = new android.content.Intent     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Class<cm.aptoide.pt.notification.PullingContentService> r15 = p005cm.aptoide.p006pt.notification.PullingContentService.class
            r14.<init>(r6, r15)     // Catch:{ NullPointerException -> 0x029b }
            r15 = 70
            r2[r15] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "PUSH_NOTIFICATIONS_ACTION"
            r14.setAction(r15)     // Catch:{ NullPointerException -> 0x029b }
            r15 = 71
            r2[r15] = r4     // Catch:{ NullPointerException -> 0x029b }
            r6.startService(r14)     // Catch:{ NullPointerException -> 0x029b }
            int r5 = r5 + 1
            r15 = 72
            r2[r15] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = 73
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = 1
            goto L_0x0258
        L_0x0133:
            java.lang.Object r14 = r12.getKey()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "UpdatesAction"
            r16 = 74
            r2[r16] = r4     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.equals(r15)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 != 0) goto L_0x014b
            r14 = 75
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            goto L_0x023f
        L_0x014b:
            r14 = 76
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            android.content.Intent r14 = new android.content.Intent     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Class<cm.aptoide.pt.notification.PullingContentService> r15 = p005cm.aptoide.p006pt.notification.PullingContentService.class
            r14.<init>(r6, r15)     // Catch:{ NullPointerException -> 0x029b }
            r15 = 77
            r2[r15] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "UPDATES_ACTION"
            r14.setAction(r15)     // Catch:{ NullPointerException -> 0x029b }
            r15 = 78
            r2[r15] = r4     // Catch:{ NullPointerException -> 0x029b }
            r6.startService(r14)     // Catch:{ NullPointerException -> 0x029b }
            int r5 = r5 + 1
            r14 = 79
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = 1
            goto L_0x0258
        L_0x0170:
            boolean r14 = r13 instanceof java.lang.Boolean     // Catch:{ NullPointerException -> 0x029b }
            if (r14 == 0) goto L_0x021c
            r14 = 80
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Object r14 = r12.getKey()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "debugmode"
            r16 = 81
            r2[r16] = r4     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.equals(r15)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 != 0) goto L_0x018f
            r14 = 82
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            goto L_0x01b9
        L_0x018f:
            r14 = 83
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Object r14 = r12.getValue()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.booleanValue()     // Catch:{ NullPointerException -> 0x029b }
            android.content.SharedPreferences r15 = r1.sharedPreferences     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.setDebug(r14, r15)     // Catch:{ NullPointerException -> 0x029b }
            r14 = 84
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Object r14 = r12.getValue()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.booleanValue()     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.logger.Logger.setDBG(r14)     // Catch:{ NullPointerException -> 0x029b }
            int r5 = r5 + 1
            r14 = 85
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
        L_0x01b9:
            java.lang.Object r14 = r12.getKey()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "toolbox_enable_http_scheme"
            r16 = 86
            r2[r16] = r4     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.equals(r15)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 != 0) goto L_0x01d0
            r14 = 87
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            goto L_0x01e9
        L_0x01d0:
            r14 = 88
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Object r14 = r12.getValue()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.booleanValue()     // Catch:{ NullPointerException -> 0x029b }
            android.content.SharedPreferences r15 = r1.sharedPreferences     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.setToolboxEnableHttpScheme(r14, r15)     // Catch:{ NullPointerException -> 0x029b }
            int r5 = r5 + 1
            r14 = 89
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
        L_0x01e9:
            java.lang.Object r14 = r12.getKey()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "toolbox_enable_retrofit_logs"
            r16 = 90
            r2[r16] = r4     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.equals(r15)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 != 0) goto L_0x0201
            r14 = 91
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = 1
            goto L_0x0258
        L_0x0201:
            r14 = 92
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Object r14 = r12.getValue()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.booleanValue()     // Catch:{ NullPointerException -> 0x029b }
            android.content.SharedPreferences r15 = r1.sharedPreferences     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.setToolboxEnableRetrofitLogs(r14, r15)     // Catch:{ NullPointerException -> 0x029b }
            int r5 = r5 + 1
            r14 = 93
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = 1
            goto L_0x0258
        L_0x021c:
            boolean r14 = r13 instanceof java.lang.Long     // Catch:{ NullPointerException -> 0x029b }
            if (r14 != 0) goto L_0x0225
            r14 = 94
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            goto L_0x023f
        L_0x0225:
            r14 = 95
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            java.lang.Object r14 = r12.getKey()     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r15 = "lastPushNotificationPullInterval"
            r16 = 96
            r2[r16] = r4     // Catch:{ NullPointerException -> 0x029b }
            boolean r14 = r14.equals(r15)     // Catch:{ NullPointerException -> 0x029b }
            if (r14 != 0) goto L_0x0241
            r14 = 97
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
        L_0x023f:
            r14 = 1
            goto L_0x0258
        L_0x0241:
            r14 = 98
            r2[r14] = r4     // Catch:{ NullPointerException -> 0x029b }
            r14 = r13
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ NullPointerException -> 0x029b }
            long r14 = r14.longValue()     // Catch:{ NullPointerException -> 0x029b }
            android.content.SharedPreferences r4 = r1.sharedPreferences     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager.setPushNotificationPullingInterval(r14, r4)     // Catch:{ NullPointerException -> 0x029b }
            int r5 = r5 + 1
            r4 = 99
            r14 = 1
            r2[r4] = r14     // Catch:{ NullPointerException -> 0x029b }
        L_0x0258:
            if (r5 > 0) goto L_0x025f
            r4 = 100
            r2[r4] = r14     // Catch:{ NullPointerException -> 0x029b }
            goto L_0x028b
        L_0x025f:
            java.lang.Object r4 = r12.getValue()     // Catch:{ NullPointerException -> 0x029b }
            r15 = 101(0x65, float:1.42E-43)
            r2[r15] = r14     // Catch:{ NullPointerException -> 0x029b }
            java.lang.String r4 = r4.toString()     // Catch:{ NullPointerException -> 0x029b }
            r15 = 102(0x66, float:1.43E-43)
            r2[r15] = r14     // Catch:{ NullPointerException -> 0x029b }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ NullPointerException -> 0x029b }
            if (r4 == 0) goto L_0x027a
            r4 = 103(0x67, float:1.44E-43)
            r2[r4] = r14     // Catch:{ NullPointerException -> 0x029b }
            goto L_0x028b
        L_0x027a:
            r4 = 104(0x68, float:1.46E-43)
            r2[r4] = r14     // Catch:{ NullPointerException -> 0x029b }
            cm.aptoide.pt.toolbox.b r4 = new cm.aptoide.pt.toolbox.b     // Catch:{ NullPointerException -> 0x029b }
            r4.<init>(r6, r12)     // Catch:{ NullPointerException -> 0x029b }
            p005cm.aptoide.p006pt.utils.AptoideUtils.ThreadU.runOnUiThread(r4)     // Catch:{ NullPointerException -> 0x029b }
            r4 = 105(0x69, float:1.47E-43)
            r14 = 1
            r2[r4] = r14     // Catch:{ NullPointerException -> 0x029b }
        L_0x028b:
            r4 = 106(0x6a, float:1.49E-43)
            r2[r4] = r14     // Catch:{ NullPointerException -> 0x029b }
            r4 = 1
            goto L_0x0072
        L_0x0292:
            r9.apply()     // Catch:{ NullPointerException -> 0x029b }
            r4 = 107(0x6b, float:1.5E-43)
            r11 = 1
            r2[r4] = r11
            return r5
        L_0x029b:
            r0 = move-exception
            goto L_0x02ae
        L_0x029d:
            r10 = r18
            r0 = 109(0x6d, float:1.53E-43)
            r3 = 1
            r2[r0] = r3
            goto L_0x02b3
        L_0x02a5:
            r0 = move-exception
            r10 = r18
            goto L_0x02ae
        L_0x02a9:
            r0 = move-exception
            r10 = r18
            r0 = r3
            r5 = r0
        L_0x02ae:
            r0 = 110(0x6e, float:1.54E-43)
            r3 = 1
            r2[r0] = r3
        L_0x02b3:
            r0 = 111(0x6f, float:1.56E-43)
            r2[r0] = r3
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.toolbox.ToolboxContentProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* renamed from: a */
    static /* synthetic */ void m9434a(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        Toast makeText = Toast.makeText(context, "Please enable debug mode for toolbox to work.", 1);
        $jacocoInit[118] = true;
        makeText.show();
        $jacocoInit[119] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9435a(Context context, Entry entry) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("Preference set: ");
        $jacocoInit[114] = true;
        sb.append((String) entry.getKey());
        sb.append("=");
        sb.append(entry.getValue());
        String sb2 = sb.toString();
        $jacocoInit[115] = true;
        Toast makeText = Toast.makeText(context, sb2, 1);
        $jacocoInit[116] = true;
        makeText.show();
        $jacocoInit[117] = true;
    }

    private MatrixCursor create(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        MatrixCursor cursor = new MatrixCursor(new String[]{key}, 1);
        $jacocoInit[112] = true;
        cursor.addRow(new String[]{value});
        $jacocoInit[113] = true;
        return cursor;
    }
}
