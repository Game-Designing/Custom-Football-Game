package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleCancelDownloadButton$4 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleCancelDownloadButton$4<T> implements C0129b<WalletApp> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7459313678297192094L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleCancelDownloadButton$4", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleCancelDownloadButton$4(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((WalletApp) obj);
        $jacocoInit[0] = true;
    }

    public final void call(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallManager walletInstallManager = this.this$0.getWalletInstallManager();
        C14281f.m45913a((Object) walletApp, "walletApp");
        walletInstallManager.removeDownload(walletApp);
        $jacocoInit[1] = true;
    }
}
