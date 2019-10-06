package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallConfiguration */
/* compiled from: WalletInstallConfiguration.kt */
public final class WalletInstallConfiguration {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String appPackageName;
    private final String walletPackageName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9019198782262144968L, "cm/aptoide/pt/wallet/WalletInstallConfiguration", 25);
        $jacocoData = probes;
        return probes;
    }

    public static /* synthetic */ WalletInstallConfiguration copy$default(WalletInstallConfiguration walletInstallConfiguration, String str, String str2, int i, Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if ((i & 1) == 0) {
            $jacocoInit[7] = true;
        } else {
            str = walletInstallConfiguration.appPackageName;
            $jacocoInit[8] = true;
        }
        if ((i & 2) == 0) {
            $jacocoInit[9] = true;
        } else {
            str2 = walletInstallConfiguration.walletPackageName;
            $jacocoInit[10] = true;
        }
        WalletInstallConfiguration copy = walletInstallConfiguration.copy(str, str2);
        $jacocoInit[11] = true;
        return copy;
    }

    public final String component1() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appPackageName;
        $jacocoInit[4] = true;
        return str;
    }

    public final String component2() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.walletPackageName;
        $jacocoInit[5] = true;
        return str;
    }

    public final WalletInstallConfiguration copy(String str, String str2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(str2, "walletPackageName");
        WalletInstallConfiguration walletInstallConfiguration = new WalletInstallConfiguration(str, str2);
        $jacocoInit[6] = true;
        return walletInstallConfiguration;
    }

    public boolean equals(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[18] = true;
        } else {
            if (!(obj instanceof WalletInstallConfiguration)) {
                $jacocoInit[19] = true;
            } else {
                WalletInstallConfiguration walletInstallConfiguration = (WalletInstallConfiguration) obj;
                if (!C14281f.m45915a((Object) this.appPackageName, (Object) walletInstallConfiguration.appPackageName)) {
                    $jacocoInit[20] = true;
                } else if (!C14281f.m45915a((Object) this.walletPackageName, (Object) walletInstallConfiguration.walletPackageName)) {
                    $jacocoInit[21] = true;
                } else {
                    $jacocoInit[22] = true;
                }
            }
            $jacocoInit[24] = true;
            return false;
        }
        $jacocoInit[23] = true;
        return true;
    }

    public int hashCode() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appPackageName;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            i = 0;
        }
        int i3 = i * 31;
        String str2 = this.walletPackageName;
        if (str2 != null) {
            i2 = str2.hashCode();
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
        }
        int i4 = i3 + i2;
        $jacocoInit[17] = true;
        return i4;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("WalletInstallConfiguration(appPackageName=");
        sb.append(this.appPackageName);
        sb.append(", walletPackageName=");
        sb.append(this.walletPackageName);
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[12] = true;
        return sb2;
    }

    public WalletInstallConfiguration(String appPackageName2, String walletPackageName2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(walletPackageName2, "walletPackageName");
        $jacocoInit[2] = true;
        this.appPackageName = appPackageName2;
        this.walletPackageName = walletPackageName2;
        $jacocoInit[3] = true;
    }

    public final String getAppPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appPackageName;
        $jacocoInit[0] = true;
        return str;
    }

    public final String getWalletPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.walletPackageName;
        $jacocoInit[1] = true;
        return str;
    }
}
