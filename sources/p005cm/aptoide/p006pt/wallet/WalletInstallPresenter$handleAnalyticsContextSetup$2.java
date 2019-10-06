package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleAnalyticsContextSetup$2 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleAnalyticsContextSetup$2<T> implements C0129b<LifecycleEvent> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ WalletInstallPresenter this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8256406724431739343L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleAnalyticsContextSetup$2", 3);
        $jacocoData = probes;
        return probes;
    }

    WalletInstallPresenter$handleAnalyticsContextSetup$2(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = walletInstallPresenter;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((LifecycleEvent) obj);
        $jacocoInit[0] = true;
    }

    public final void call(LifecycleEvent it) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0.getWalletInstallManager().setupAnalyticsHistoryTracker();
        $jacocoInit[1] = true;
    }
}
