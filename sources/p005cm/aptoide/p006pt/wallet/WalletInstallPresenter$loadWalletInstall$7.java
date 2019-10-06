package p005cm.aptoide.p006pt.wallet;

import kotlin.C14268b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$loadWalletInstall$7 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$loadWalletInstall$7<T, R> implements C0132p<T, C0120S<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2125812877290348138L, "cm/aptoide/pt/wallet/WalletInstallPresenter$loadWalletInstall$7", 8);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$loadWalletInstall$7(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[7] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S call = call((C14268b) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final C0120S<Object> call(C14268b<String, WalletApp> walletInitialState) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M access$startWalletDownload = WalletInstallPresenter.access$startWalletDownload(this.this$0, (WalletApp) walletInitialState.mo44426b());
        $jacocoInit[1] = true;
        C0120S access$handleWalletInstallation = WalletInstallPresenter.access$handleWalletInstallation(this.this$0);
        $jacocoInit[2] = true;
        C0120S access$observeDownloadProgress = WalletInstallPresenter.access$observeDownloadProgress(this.this$0, (WalletApp) walletInitialState.mo44426b());
        $jacocoInit[3] = true;
        C0120S access$handleInstallDialogCancelButtonPress = WalletInstallPresenter.access$handleInstallDialogCancelButtonPress(this.this$0);
        $jacocoInit[4] = true;
        C0120S a = C0120S.m637a(access$handleWalletInstallation, access$observeDownloadProgress, access$handleInstallDialogCancelButtonPress);
        $jacocoInit[5] = true;
        C0120S<Object> a2 = access$startWalletDownload.mo3586a(a);
        $jacocoInit[6] = true;
        return a2;
    }
}
