package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleCloseButtonClick$2 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleCloseButtonClick$2<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4854810873986909842L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleCloseButtonClick$2", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleCloseButtonClick$2(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((LifecycleEvent) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<Void> call(LifecycleEvent it) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> closeButtonClicked = this.this$0.getView().closeButtonClicked();
        $jacocoInit[1] = true;
        return closeButtonClicked;
    }
}
