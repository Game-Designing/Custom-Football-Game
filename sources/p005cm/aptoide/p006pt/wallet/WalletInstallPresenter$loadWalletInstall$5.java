package p005cm.aptoide.p006pt.wallet;

import kotlin.C14268b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$loadWalletInstall$5 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$loadWalletInstall$5<T, R> implements C0132p<C14268b<? extends String, ? extends WalletApp>, Boolean> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final WalletInstallPresenter$loadWalletInstall$5 INSTANCE = new WalletInstallPresenter$loadWalletInstall$5();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6542441515421074461L, "cm/aptoide/pt/wallet/WalletInstallPresenter$loadWalletInstall$5", 6);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[5] = true;
    }

    WalletInstallPresenter$loadWalletInstall$5() {
        $jacocoInit()[4] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(call((C14268b) obj));
        $jacocoInit[0] = true;
        return valueOf;
    }

    public final boolean call(C14268b<String, WalletApp> walletInitialState) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!((WalletApp) walletInitialState.mo44426b()).isInstalled()) {
            $jacocoInit[1] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
        return z;
    }
}
