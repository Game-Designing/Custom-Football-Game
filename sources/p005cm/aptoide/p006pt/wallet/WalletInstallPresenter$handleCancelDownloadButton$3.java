package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleCancelDownloadButton$3 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleCancelDownloadButton$3<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(957101114463008389L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleCancelDownloadButton$3", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleCancelDownloadButton$3(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((Void) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<WalletApp> call(Void it) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<WalletApp> wallet = this.this$0.getWalletInstallManager().getWallet();
        $jacocoInit[1] = true;
        return wallet;
    }
}
