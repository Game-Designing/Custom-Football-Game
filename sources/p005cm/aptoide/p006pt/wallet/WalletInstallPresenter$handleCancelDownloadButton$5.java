package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleCancelDownloadButton$5 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleCancelDownloadButton$5 implements C0128a {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5824436528816816004L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleCancelDownloadButton$5", 2);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleCancelDownloadButton$5(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[1] = true;
    }

    public final void call() {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0.getView().dismissDialog();
        $jacocoInit[0] = true;
    }
}
