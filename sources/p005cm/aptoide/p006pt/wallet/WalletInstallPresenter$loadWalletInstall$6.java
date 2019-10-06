package p005cm.aptoide.p006pt.wallet;

import kotlin.C14268b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$loadWalletInstall$6 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$loadWalletInstall$6<T> implements C0129b<C14268b<? extends String, ? extends WalletApp>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3504572089375781594L, "cm/aptoide/pt/wallet/WalletInstallPresenter$loadWalletInstall$6", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$loadWalletInstall$6(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((C14268b) obj);
        $jacocoInit[0] = true;
    }

    public final void call(C14268b<String, WalletApp> it) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0.getView().showIndeterminateDownload();
        $jacocoInit[1] = true;
    }
}
