package p005cm.aptoide.p006pt.database.realm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p024io.realm.C0106Z;
import p024io.realm.C0109s;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.Installed */
public class Installed extends C0106Z implements C0109s {
    public static final String ICON = "icon";
    public static final String NAME = "name";
    public static final String PACKAGE_NAME = "packageName";
    public static final String SIGNATURE = "signature";
    public static final int STATUS_COMPLETED = 4;
    public static final int STATUS_INSTALLING = 3;
    public static final int STATUS_ROOT_TIMEOUT = 5;
    public static final int STATUS_UNINSTALLED = 1;
    public static final int STATUS_WAITING = 2;
    public static final String STORE_NAME = "storeName";
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_ROOT = 1;
    public static final int TYPE_SET_PACKAGE_NAME_INSTALLER = 3;
    public static final int TYPE_SYSTEM = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final String VERSION_CODE = "versionCode";
    public static final String VERSION_NAME = "versionName";
    private String icon;
    private String name;
    private String packageAndVersionCode;
    private String packageName;
    private String signature;
    private int status;
    private String storeName;
    private boolean systemApp;
    private int type;
    private int versionCode;
    private String versionName;

    public String realmGet$icon() {
        return this.icon;
    }

    public String realmGet$name() {
        return this.name;
    }

    public String realmGet$packageAndVersionCode() {
        return this.packageAndVersionCode;
    }

    public String realmGet$packageName() {
        return this.packageName;
    }

    public String realmGet$signature() {
        return this.signature;
    }

    public int realmGet$status() {
        return this.status;
    }

    public String realmGet$storeName() {
        return this.storeName;
    }

    public boolean realmGet$systemApp() {
        return this.systemApp;
    }

    public int realmGet$type() {
        return this.type;
    }

    public int realmGet$versionCode() {
        return this.versionCode;
    }

    public String realmGet$versionName() {
        return this.versionName;
    }

    public void realmSet$icon(String str) {
        this.icon = str;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$packageAndVersionCode(String str) {
        this.packageAndVersionCode = str;
    }

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public void realmSet$signature(String str) {
        this.signature = str;
    }

    public void realmSet$status(int i) {
        this.status = i;
    }

    public void realmSet$storeName(String str) {
        this.storeName = str;
    }

    public void realmSet$systemApp(boolean z) {
        this.systemApp = z;
    }

    public void realmSet$type(int i) {
        this.type = i;
    }

    public void realmSet$versionCode(int i) {
        this.versionCode = i;
    }

    public void realmSet$versionName(String str) {
        this.versionName = str;
    }

    public Installed() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public Installed(PackageInfo packageInfo, PackageManager packageManager) {
        this(packageInfo, null, packageManager);
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public Installed(PackageInfo packageInfo, String storeName2, PackageManager packageManager) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        setIcon(SystemU.getApkIconPath(packageInfo));
        setName(SystemU.getApkLabel(packageInfo, packageManager));
        setPackageName(packageInfo.packageName);
        setVersionCode(packageInfo.versionCode);
        setVersionName(packageInfo.versionName);
        setStoreName(storeName2);
        StringBuilder sb = new StringBuilder();
        sb.append(packageInfo.packageName);
        sb.append(packageInfo.versionCode);
        realmSet$packageAndVersionCode(sb.toString());
        boolean z = true;
        if ((packageInfo.applicationInfo.flags & 1) == 0) {
            z = false;
        }
        setSystemApp(z);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length > 0) {
            setSignature(AlgorithmU.computeSha1WithColon(signatureArr[0].toByteArray()));
        }
        setStatus(4);
        setType(-1);
    }

    public int hashCode() {
        return (((realmGet$packageAndVersionCode().hashCode() * 31) + realmGet$packageName().hashCode()) * 31) + realmGet$versionCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Installed installed = (Installed) o;
        if (realmGet$versionCode() == installed.realmGet$versionCode() && realmGet$packageAndVersionCode().equals(installed.realmGet$packageAndVersionCode())) {
            return realmGet$packageName().equals(installed.realmGet$packageName());
        }
        return false;
    }

    public void setPackageAndVersionCode(String packageAndVersionCode2) {
        realmSet$packageAndVersionCode(packageAndVersionCode2);
    }

    public int getStatus() {
        return realmGet$status();
    }

    public void setStatus(int status2) {
        realmSet$status(status2);
    }

    public int getType() {
        return realmGet$type();
    }

    public void setType(int type2) {
        realmSet$type(type2);
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

    public String getName() {
        return realmGet$name();
    }

    public void setName(String name2) {
        realmSet$name(name2);
    }

    public int getVersionCode() {
        return realmGet$versionCode();
    }

    public void setVersionCode(int versionCode2) {
        realmSet$versionCode(versionCode2);
    }

    public String getVersionName() {
        return realmGet$versionName();
    }

    public void setVersionName(String versionName2) {
        realmSet$versionName(versionName2);
    }

    public String getSignature() {
        return realmGet$signature();
    }

    public void setSignature(String signature2) {
        realmSet$signature(signature2);
    }

    public boolean isSystemApp() {
        return realmGet$systemApp();
    }

    public void setSystemApp(boolean systemApp2) {
        realmSet$systemApp(systemApp2);
    }

    public String getStoreName() {
        return realmGet$storeName();
    }

    public void setStoreName(String storeName2) {
        realmSet$storeName(storeName2);
    }
}
