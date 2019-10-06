package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$loadWalletInstall$3 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$loadWalletInstall$3<T, R> implements C0132p<LifecycleEvent, Boolean> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6845737685554738377L, "cm/aptoide/pt/wallet/WalletInstallPresenter$loadWalletInstall$3", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$loadWalletInstall$3(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(call((LifecycleEvent) obj));
        $jacocoInit[0] = true;
        return valueOf;
    }

    public final boolean call(LifecycleEvent it) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean access$hasMinimumSdk = WalletInstallPresenter.access$hasMinimumSdk(this.this$0);
        $jacocoInit[1] = true;
        return access$hasMinimumSdk;
    }
}
