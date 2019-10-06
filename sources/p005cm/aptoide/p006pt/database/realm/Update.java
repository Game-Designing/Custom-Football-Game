package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C14080oa;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.Update */
public class Update extends C0106Z implements C14080oa {
    public static final String ALTERNATIVE_URL = "alternativeApkPath";
    public static final String APK_PATH = "apkPath";
    public static final String APPC_UPGRADE = "appcUpgrade";
    public static final String APP_ID = "appId";
    public static final String EXCLUDED = "excluded";
    public static final String FILE_SIZE = "fileSize";
    public static final String ICON = "icon";
    public static final String LABEL = "label";
    public static final String MD5 = "md5";
    public static final String PACKAGE_NAME = "packageName";
    public static final String SIGNATURE = "signature";
    public static final String TIMESTAMP = "timestamp";
    public static final String UPDATE_VERSION_CODE = "updateVersionCode";
    public static final String UPDATE_VERSION_NAME = "updateVersionName";
    public static final String VERSION_CODE = "versionCode";
    private String alternativeApkPath;
    private String apkPath;
    private long appId;
    private boolean appcUpgrade;
    private boolean excluded;
    private boolean hasAppc;
    private String icon;
    private String label;
    private String mainObbMd5;
    private String mainObbName;
    private String mainObbPath;
    private String md5;
    private String packageName;
    private String patchObbMd5;
    private String patchObbName;
    private String patchObbPath;
    private long size;
    private long timestamp;
    private String trustedBadge;
    private int updateVersionCode;
    private String updateVersionName;
    private int versionCode;

    public String realmGet$alternativeApkPath() {
        return this.alternativeApkPath;
    }

    public String realmGet$apkPath() {
        return this.apkPath;
    }

    public long realmGet$appId() {
        return this.appId;
    }

    public boolean realmGet$appcUpgrade() {
        return this.appcUpgrade;
    }

    public boolean realmGet$excluded() {
        return this.excluded;
    }

    public boolean realmGet$hasAppc() {
        return this.hasAppc;
    }

    public String realmGet$icon() {
        return this.icon;
    }

    public String realmGet$label() {
        return this.label;
    }

    public String realmGet$mainObbMd5() {
        return this.mainObbMd5;
    }

    public String realmGet$mainObbName() {
        return this.mainObbName;
    }

    public String realmGet$mainObbPath() {
        return this.mainObbPath;
    }

    public String realmGet$md5() {
        return this.md5;
    }

    public String realmGet$packageName() {
        return this.packageName;
    }

    public String realmGet$patchObbMd5() {
        return this.patchObbMd5;
    }

    public String realmGet$patchObbName() {
        return this.patchObbName;
    }

    public String realmGet$patchObbPath() {
        return this.patchObbPath;
    }

    public long realmGet$size() {
        return this.size;
    }

    public long realmGet$timestamp() {
        return this.timestamp;
    }

    public String realmGet$trustedBadge() {
        return this.trustedBadge;
    }

    public int realmGet$updateVersionCode() {
        return this.updateVersionCode;
    }

    public String realmGet$updateVersionName() {
        return this.updateVersionName;
    }

    public int realmGet$versionCode() {
        return this.versionCode;
    }

    public void realmSet$alternativeApkPath(String str) {
        this.alternativeApkPath = str;
    }

    public void realmSet$apkPath(String str) {
        this.apkPath = str;
    }

    public void realmSet$appId(long j) {
        this.appId = j;
    }

    public void realmSet$appcUpgrade(boolean z) {
        this.appcUpgrade = z;
    }

    public void realmSet$excluded(boolean z) {
        this.excluded = z;
    }

    public void realmSet$hasAppc(boolean z) {
        this.hasAppc = z;
    }

    public void realmSet$icon(String str) {
        this.icon = str;
    }

    public void realmSet$label(String str) {
        this.label = str;
    }

    public void realmSet$mainObbMd5(String str) {
        this.mainObbMd5 = str;
    }

    public void realmSet$mainObbName(String str) {
        this.mainObbName = str;
    }

    public void realmSet$mainObbPath(String str) {
        this.mainObbPath = str;
    }

    public void realmSet$md5(String str) {
        this.md5 = str;
    }

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public void realmSet$patchObbMd5(String str) {
        this.patchObbMd5 = str;
    }

    public void realmSet$patchObbName(String str) {
        this.patchObbName = str;
    }

    public void realmSet$patchObbPath(String str) {
        this.patchObbPath = str;
    }

    public void realmSet$size(long j) {
        this.size = j;
    }

    public void realmSet$timestamp(long j) {
        this.timestamp = j;
    }

    public void realmSet$trustedBadge(String str) {
        this.trustedBadge = str;
    }

    public void realmSet$updateVersionCode(int i) {
        this.updateVersionCode = i;
    }

    public void realmSet$updateVersionName(String str) {
        this.updateVersionName = str;
    }

    public void realmSet$versionCode(int i) {
        this.versionCode = i;
    }

    public Update() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public Update(long id, String name, String icon2, String packageName2, String md5sum, String path, long size2, String versionName, String pathAlt, int versionCode2, String rankName, String mainObbFileName, String mainObbPath2, String mainObbMd52, String patchObbFileName, String patchObbPath2, String patchObbMd52, boolean appcUpgrade2, boolean hasAppc2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$appId(id);
        realmSet$label(name);
        realmSet$icon(icon2);
        realmSet$packageName(packageName2);
        realmSet$md5(md5sum);
        realmSet$apkPath(path);
        realmSet$size(size2);
        realmSet$updateVersionName(versionName);
        realmSet$alternativeApkPath(pathAlt);
        realmSet$updateVersionCode(versionCode2);
        realmSet$trustedBadge(rankName);
        realmSet$mainObbName(mainObbFileName);
        realmSet$mainObbPath(mainObbPath2);
        realmSet$mainObbMd5(mainObbMd52);
        realmSet$patchObbName(patchObbFileName);
        realmSet$patchObbPath(patchObbPath2);
        realmSet$patchObbMd5(patchObbMd52);
        realmSet$hasAppc(hasAppc2);
        realmSet$appcUpgrade(appcUpgrade2);
    }

    public long getAppId() {
        return realmGet$appId();
    }

    public void setAppId(long appId2) {
        realmSet$appId(appId2);
    }

    public String getLabel() {
        return realmGet$label();
    }

    public void setLabel(String label2) {
        realmSet$label(label2);
    }

    public String getIcon() {
        return realmGet$icon();
    }

    public void setIcon(String icon2) {
        realmSet$icon(icon2);
    }

    public String getPackageName() {
        return realmGet$packageName();
    }

    public void setPackageName(String packageName2) {
        realmSet$packageName(packageName2);
    }

    public int getVersionCode() {
        return realmGet$versionCode();
    }

    public void setVersionCode(int versionCode2) {
        realmSet$versionCode(versionCode2);
    }

    public long getTimestamp() {
        return realmGet$timestamp();
    }

    public void setTimestamp(long timestamp2) {
        realmSet$timestamp(timestamp2);
    }

    public String getMd5() {
        return realmGet$md5();
    }

    public void setMd5(String md52) {
        realmSet$md5(md52);
    }

    public String getApkPath() {
        return realmGet$apkPath();
    }

    public void setApkPath(String apkPath2) {
        realmSet$apkPath(apkPath2);
    }

    public long getSize() {
        return realmGet$size();
    }

    public void setSize(long size2) {
        realmSet$size(size2);
    }

    public String getUpdateVersionName() {
        return realmGet$updateVersionName();
    }

    public void setUpdateVersionName(String updateVersionName2) {
        realmSet$updateVersionName(updateVersionName2);
    }

    public String getAlternativeApkPath() {
        return realmGet$alternativeApkPath();
    }

    public void setAlternativeApkPath(String alternativeApkPath2) {
        realmSet$alternativeApkPath(alternativeApkPath2);
    }

    public int getUpdateVersionCode() {
        return realmGet$updateVersionCode();
    }

    public void setUpdateVersionCode(int updateVersionCode2) {
        realmSet$updateVersionCode(updateVersionCode2);
    }

    public String getMainObbPath() {
        return realmGet$mainObbPath();
    }

    public void setMainObbPath(String mainObbPath2) {
        realmSet$mainObbPath(mainObbPath2);
    }

    public String getMainObbMd5() {
        return realmGet$mainObbMd5();
    }

    public void setMainObbMd5(String mainObbMd52) {
        realmSet$mainObbMd5(mainObbMd52);
    }

    public String getPatchObbPath() {
        return realmGet$patchObbPath();
    }

    public void setPatchObbPath(String patchObbPath2) {
        realmSet$patchObbPath(patchObbPath2);
    }

    public String getPatchObbMd5() {
        return realmGet$patchObbMd5();
    }

    public void setPatchObbMd5(String patchObbMd52) {
        realmSet$patchObbMd5(patchObbMd52);
    }

    public boolean isExcluded() {
        return realmGet$excluded();
    }

    public void setExcluded(boolean excluded2) {
        realmSet$excluded(excluded2);
    }

    public String getMainObbName() {
        return realmGet$mainObbName();
    }

    public void setMainObbName(String mainObbName2) {
        realmSet$mainObbName(mainObbName2);
    }

    public String getPatchObbName() {
        return realmGet$patchObbName();
    }

    public void setPatchObbName(String patchObbName2) {
        realmSet$patchObbName(patchObbName2);
    }

    public String getTrustedBadge() {
        return realmGet$trustedBadge();
    }

    public boolean isAppcUpgrade() {
        return realmGet$appcUpgrade();
    }

    public void setAppcUpgrade(boolean appcUpgrade2) {
        realmSet$appcUpgrade(appcUpgrade2);
    }

    public boolean hasAppc() {
        return realmGet$hasAppc();
    }

    public void setHasAppc(boolean hasAppc2) {
        realmSet$hasAppc(hasAppc2);
    }
}
