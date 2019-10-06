package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleCloseButtonClick$3 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleCloseButtonClick$3<T> implements C0129b<Void> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6075509614077986549L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleCloseButtonClick$3", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleCloseButtonClick$3(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((Void) obj);
        $jacocoInit[0] = true;
    }

    public final void call(Void it) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0.getView().dismissDialog();
        $jacocoInit[1] = true;
    }
}
