package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus.Status;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallManager$onWalletInstallationCanceled$1 */
/* compiled from: WalletInstallManager.kt */
final class WalletInstallManager$onWalletInstallationCanceled$1<T, R> implements C0132p<T, R> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final WalletInstallManager$onWalletInstallationCanceled$1 INSTANCE = new WalletInstallManager$onWalletInstallationCanceled$1();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2373691991879116976L, "cm/aptoide/pt/wallet/WalletInstallManager$onWalletInstallationCanceled$1", 4);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
    }

    WalletInstallManager$onWalletInstallationCanceled$1() {
        $jacocoInit()[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(call((InstallStatus) obj));
        $jacocoInit[0] = true;
        return valueOf;
    }

    public final boolean call(InstallStatus installStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        Status status = Status.CANCELED;
        C14281f.m45913a((Object) installStatus, "installStatus");
        boolean equals = status.equals(installStatus.getStatus());
        $jacocoInit[1] = true;
        return equals;
    }
}
