package p005cm.aptoide.p006pt.wallet;

import kotlin.C14268b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$showWalletInitialState$2 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$showWalletInitialState$2<T> implements C0129b<C14268b<? extends String, ? extends WalletApp>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5699083498546663521L, "cm/aptoide/pt/wallet/WalletInstallPresenter$showWalletInitialState$2", 6);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$showWalletInitialState$2(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[5] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((C14268b) obj);
        $jacocoInit[0] = true;
    }

    public final void call(C14268b<String, WalletApp> pair) {
        boolean[] $jacocoInit = $jacocoInit();
        if (((WalletApp) pair.mo44426b()).isInstalled()) {
            $jacocoInit[1] = true;
            this.this$0.getView().showWalletInstalledAlreadyView();
            $jacocoInit[2] = true;
        } else {
            this.this$0.getView().showWalletInstallationView((String) pair.mo44425a(), (WalletApp) pair.mo44426b());
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
    }
}
