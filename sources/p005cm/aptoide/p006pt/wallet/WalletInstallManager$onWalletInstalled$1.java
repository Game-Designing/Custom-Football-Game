package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallManager$onWalletInstalled$1 */
/* compiled from: WalletInstallManager.kt */
final class WalletInstallManager$onWalletInstalled$1<T, R> implements C0132p<Boolean, Boolean> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final WalletInstallManager$onWalletInstalled$1 INSTANCE = new WalletInstallManager$onWalletInstalled$1();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7046159717321355605L, "cm/aptoide/pt/wallet/WalletInstallManager$onWalletInstalled$1", 4);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
    }

    WalletInstallManager$onWalletInstalled$1() {
        $jacocoInit()[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean call = call((Boolean) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final Boolean call(Boolean isInstalled) {
        $jacocoInit()[1] = true;
        return isInstalled;
    }
}
