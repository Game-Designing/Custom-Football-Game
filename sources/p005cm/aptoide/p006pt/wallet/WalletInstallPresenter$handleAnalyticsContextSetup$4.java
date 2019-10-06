package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleAnalyticsContextSetup$4 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleAnalyticsContextSetup$4<T> implements C0129b<Throwable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2858479295102772196L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleAnalyticsContextSetup$4", 4);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleAnalyticsContextSetup$4(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[3] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((Throwable) obj);
        $jacocoInit[0] = true;
    }

    public final void call(Throwable it) {
        boolean[] $jacocoInit = $jacocoInit();
        it.printStackTrace();
        $jacocoInit[1] = true;
        this.this$0.getView().dismissDialog();
        $jacocoInit[2] = true;
    }
}
