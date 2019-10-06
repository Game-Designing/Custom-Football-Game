package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallManager$onWalletInstallationCanceled$2 */
/* compiled from: WalletInstallManager.kt */
final class WalletInstallManager$onWalletInstallationCanceled$2<T, R> implements C0132p<Boolean, Boolean> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final WalletInstallManager$onWalletInstallationCanceled$2 INSTANCE = new WalletInstallManager$onWalletInstallationCanceled$2();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7729662039862938185L, "cm/aptoide/pt/wallet/WalletInstallManager$onWalletInstallationCanceled$2", 4);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
    }

    WalletInstallManager$onWalletInstallationCanceled$2() {
        $jacocoInit()[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean call = call((Boolean) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final Boolean call(Boolean isCanceled) {
        $jacocoInit()[1] = true;
        return isCanceled;
    }
}
