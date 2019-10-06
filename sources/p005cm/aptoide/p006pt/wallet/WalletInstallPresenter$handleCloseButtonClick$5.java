package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleCloseButtonClick$5 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleCloseButtonClick$5<T> implements C0129b<Throwable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6260188997802686911L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleCloseButtonClick$5", 4);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleCloseButtonClick$5(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[3] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((Throwable) obj);
        $jacocoInit[0] = true;
    }

    public final void call(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        error.printStackTrace();
        $jacocoInit[1] = true;
        this.this$0.getView().dismissDialog();
        $jacocoInit[2] = true;
    }
}
