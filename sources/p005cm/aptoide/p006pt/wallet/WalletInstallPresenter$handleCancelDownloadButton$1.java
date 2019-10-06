package p005cm.aptoide.p006pt.wallet;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallPresenter$handleCancelDownloadButton$1 */
/* compiled from: WalletInstallPresenter.kt */
final class WalletInstallPresenter$handleCancelDownloadButton$1<T, R> implements C0132p<LifecycleEvent, Boolean> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final WalletInstallPresenter$handleCancelDownloadButton$1 INSTANCE = new WalletInstallPresenter$handleCancelDownloadButton$1();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7498753284386683482L, "cm/aptoide/pt/wallet/WalletInstallPresenter$handleCancelDownloadButton$1", 6);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[5] = true;
    }

    WalletInstallPresenter$handleCancelDownloadButton$1() {
        $jacocoInit()[4] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(call((LifecycleEvent) obj));
        $jacocoInit[0] = true;
        return valueOf;
    }

    public final boolean call(LifecycleEvent lifecycleEvent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (LifecycleEvent.CREATE == lifecycleEvent) {
            $jacocoInit[1] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
        return z;
    }
}
