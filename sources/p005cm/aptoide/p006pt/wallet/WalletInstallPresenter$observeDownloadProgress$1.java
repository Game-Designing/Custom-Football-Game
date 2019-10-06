package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$observeDownloadProgress$1 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$observeDownloadProgress$1<T> implements C0129b<DownloadModel> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(51428365988446505L, "cm/aptoide/pt/wallet/WalletInstallPresenter$observeDownloadProgress$1", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$observeDownloadProgress$1(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((DownloadModel) obj);
        $jacocoInit[0] = true;
    }

    public final void call(DownloadModel it) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallView view = this.this$0.getView();
        C14281f.m45913a((Object) it, "it");
        view.showDownloadState(it);
        $jacocoInit[1] = true;
    }
}
