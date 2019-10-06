package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$observeDownloadProgress$2 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$observeDownloadProgress$2<T, R> implements C0132p<T, R> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletApp $walletApp;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3591151194047260948L, "cm/aptoide/pt/wallet/WalletInstallPresenter$observeDownloadProgress$2", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$observeDownloadProgress$2(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        this.$walletApp = walletApp;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp call = call((DownloadModel) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final WalletApp call(DownloadModel it) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp walletApp = this.$walletApp;
        $jacocoInit[1] = true;
        return walletApp;
    }
}
