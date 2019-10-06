package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleInstallDialogCancelButtonPress$1 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleInstallDialogCancelButtonPress$1<T> implements C0129b<Boolean> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2107554588613758703L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleInstallDialogCancelButtonPress$1", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleInstallDialogCancelButtonPress$1(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((Boolean) obj);
        $jacocoInit[0] = true;
    }

    public final void call(Boolean it) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0.getView().dismissDialog();
        $jacocoInit[1] = true;
    }
}
